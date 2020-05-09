package com.microdonation.microdonation.service.impl;

import com.google.gson.Gson;
import com.microdonation.microdonation.event.OnRegistrationCompleteEvent;
import com.microdonation.microdonation.exception.AppException;
import com.microdonation.microdonation.model.MdpDonor;
import com.microdonation.microdonation.model.MdpNgo;
import com.microdonation.microdonation.model.User;
import com.microdonation.microdonation.model.VerificationToken;
import com.microdonation.microdonation.payload.*;
import com.microdonation.microdonation.repository.DonorRepository;
import com.microdonation.microdonation.repository.NgoRepository;
import com.microdonation.microdonation.repository.UserRepository;
import com.microdonation.microdonation.repository.VerificationTokenRepository;
import com.microdonation.microdonation.security.JwtTokenProvider;
import com.microdonation.microdonation.service.DonorService;
import com.microdonation.microdonation.service.NgoService;
import com.microdonation.microdonation.service.UserActivationValidateService;
import com.microdonation.microdonation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    VerificationTokenRepository tokenRepository;

    @Autowired
    JwtTokenProvider tokenProvider;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    ApplicationEventPublisher eventPublisher;

    @Autowired
    NgoService ngoService;

    @Autowired
    DonorService donorService;

    @Autowired
    UserActivationValidateService validatorService;

    public void sendUserActivationEmail(OnRegistrationCompleteEvent event,User user)
    {
//        SimpleMailMessage msg = new SimpleMailMessage();
//        msg.setTo("mihir.barve2012@gmail.com");
//
//        msg.setSubject("Testing from Spring Boot");
//        msg.setText("Hello World \n Spring Boot Email");


        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(user.getSzEmail()));
                // mimeMessage.setFrom(new InternetAddress("altap.itworks@gmail.com"));

                User user = event.getUser();
                String token = tokenProvider.generateToken(user.getSzUsername());
               // String token = UUID.randomUUID().toString();
                createVerificationToken(user, token);
                String confirmationUrl
                        = event.getAppUrl() + "/api/auth/registerConfirmation/"+user.getId()+"/"+token;
                mimeMessage.setFrom(new InternetAddress("mihir.microdonation@gmail.com"));
                mimeMessage.setSubject("Micro Donation Registration Confirmation");
                mimeMessage.setText("");
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
                helper.setText("Kindly click on the below link to Verify Email <br/><br/><a href='http://localhost:7570" + confirmationUrl + "'>Verify Email</a>", true);
            }
        };
        try {
            new Thread(() -> {
                System.out.println("inside SendMail -preparing to send mail");
                javaMailSender.send(preparator);
                System.out.println("inside mail sent");
            }).start();
            // mailSender.send(message);
        } catch (MailException ex) {
            // simply log it and go on...

        }
    }

    @Override
    public void createVerificationToken(User user, String token){

        VerificationToken myToken = new VerificationToken();
        myToken.setUser(user);
        myToken.setToken(token);
        tokenRepository.save(myToken);
    }

    @Override
    public User getUser(String verificationToken) {
        User user = tokenRepository.findBySzToken(verificationToken).getUser();
        return user;
    }

    @Override
    public VerificationToken getVerificationToken(String VerificationToken) {
        return tokenRepository.findBySzToken(VerificationToken);
    }

    public boolean verifyToken(String token,Long userId){
        boolean tokenVerified = false;
        VerificationToken verificationToken = getVerificationToken(token);
        if(verificationToken.getUser().getId() == userId)
        {
            Optional<User> userObject = userRepository.findById(userId);
            User user =  userObject.get();
            user.setcUserStatus(true);
            userRepository.saveAndFlush(user);
            tokenVerified = true;



        }
        return tokenVerified;
    }

    public User createOrUpdateUser(SignUpRequest signUpRequest, HttpServletRequest request)
    {
        User user = new User();
        User result = new User();
        try {
            user.setSzRole(signUpRequest.getRole());
            user.setSzMobile(signUpRequest.getContactNo());
            user.setSzEmail(signUpRequest.getEmail());
            user.setSzName(signUpRequest.getName());
            user.setSzUsername(signUpRequest.getUsername());
            user.setSzPassword(passwordEncoder.encode(signUpRequest.getPassword()));
            result = userRepository.saveAndFlush(user);
            if(signUpRequest.getRole().equals("D"))
            {
                MdpDonorDetails mdpDonorDetails = new MdpDonorDetails();
                mdpDonorDetails.setUser(result);
                mdpDonorDetails.setDonorName(signUpRequest.getName());
                mdpDonorDetails.setEmail(signUpRequest.getEmail());
                mdpDonorDetails.setMobile(String.valueOf(signUpRequest.getContactNo()));
                donorService.createDonorDetails(mdpDonorDetails);
            }
            else if(signUpRequest.getRole().equals("N"))
            {
                MdpNGoDetails mdpNGoDetails = new MdpNGoDetails();
                mdpNGoDetails.setUser(result);
                mdpNGoDetails.setNgoName(signUpRequest.getName());
                mdpNGoDetails.setEmail(signUpRequest.getEmail());
                mdpNGoDetails.setMobile(String.valueOf(signUpRequest.getContactNo()));
                mdpNGoDetails.setRegistrationId(signUpRequest.getRegistrationId());
                ngoService.createNgoDetails(mdpNGoDetails);
            }


            String appUrl = request.getContextPath();
            eventPublisher.publishEvent(new OnRegistrationCompleteEvent(result, request.getLocale(), appUrl));
            sendUserActivationEmail(new OnRegistrationCompleteEvent(result, request.getLocale(), appUrl),result);

        }catch (Exception e){
            throw new AppException(e.getMessage());
        }
        return result;
    }

    public Map<String,Object> login(LoginRequest loginRequest, Authentication authentication)
    {
        String jwt = tokenProvider.generateToken(authentication);



        Optional<User> userObject = userRepository.findBySzUsernameOrSzEmail(loginRequest.getUsernameOrEmail(),loginRequest.getUsernameOrEmail());
        User user = userObject.get();
        validatorService.validateUser(user);
        createVerificationToken(user,jwt);
        Map<String,Object> loginResponse = new HashMap<>();
        LoginResponse resp = new LoginResponse();
        resp.setEmail(user.getSzEmail());
        resp.setUserId(user.getId());
        resp.setMobile(String.valueOf(user.getSzMobile()));
        resp.setRole(user.getSzRole());
        resp.setLockedUser(user.iscUserLocked());
        resp.setUserStatus(user.iscUserStatus());
        resp.setUserName(user.getSzUsername());
        resp.setName(user.getSzName());
        loginResponse.put("user",resp);
        loginResponse.put("token",jwt);
        return loginResponse;
    }

    public Map<String, Object> getUserDetails(Long userId)
    {
    	Map<String,Object> userDetails = new HashMap<String, Object>();
        Optional<User> userObject = userRepository.findById(userId);
        User user = userObject.get();
        String json = "";
        if(user.getSzRole().equals("D")){
        	MdpDonor mdpDonor = donorService.getDonorFromUser(user);
        	MdpDonorDetails mdpDonorDetails = new MdpDonorDetails();
        	mdpDonorDetails.setAddressLine1(mdpDonor.getSzAddressLine1());
        	mdpDonorDetails.setAddressLine2(mdpDonor.getSzAddressLine2());
        	mdpDonorDetails.setCity(mdpDonor.getSzCity());
        	mdpDonorDetails.setContactNo1(mdpDonor.getSzPhone());
        	mdpDonorDetails.setCountry(mdpDonor.getSzCountry());
        	mdpDonorDetails.setDonorName(mdpDonor.getSzDonorName());
        	mdpDonorDetails.setEmail(mdpDonor.getSzEmail());
        	mdpDonorDetails.setMobile(mdpDonor.getSzMobile());
        	mdpDonorDetails.setPincode(mdpDonor.getSzPostalCode());
        	mdpDonorDetails.setState(mdpDonor.getSzState());
        	json = new Gson().toJson(mdpDonorDetails);
        } else  if(user.getSzRole().equals("N")){
        	MdpNgo mdpNgo = ngoService.getNgoFromUser(user);
        	MdpNGoDetails mdpNGoDetails = new MdpNGoDetails();
        	mdpNGoDetails.setAddressLine1(mdpNgo.getSzAddressLine1());
        	mdpNGoDetails.setAddressLine2(mdpNgo.getSzAddressAine2());
        	mdpNGoDetails.setBankAccountNo(mdpNgo.getSzBankAccountNo());
        	mdpNGoDetails.setCity(mdpNgo.getSzCity());
        	mdpNGoDetails.setContactNo1(mdpNgo.getSzPhone1());
        	mdpNGoDetails.setContactNo2(mdpNgo.getSzPhone2());
        	mdpNGoDetails.setCountry(mdpNgo.getSzCountry());
        	mdpNGoDetails.setEmail(mdpNgo.getSzEmail());
        	mdpNGoDetails.setFundTransferRef(mdpNgo.getSzFundTransferPref());
        	mdpNGoDetails.setId(mdpNgo.getiNgoId());
        	mdpNGoDetails.setIfsc(mdpNgo.getSzIfscCode());
        	mdpNGoDetails.setMobile(mdpNgo.getSzMobile());
        	mdpNGoDetails.setNgoDesc(mdpNgo.getSzNgoDesc());
        	mdpNGoDetails.setNgoName(mdpNgo.getSzNgoName());
        	mdpNGoDetails.setPincode(mdpNgo.getSzPostalCode());
        	mdpNGoDetails.setPrimaryCategory(mdpNgo.getSzCategoryPrimary());
        	mdpNGoDetails.setRedistrationDate(mdpNgo.getDtRegistration());
        	mdpNGoDetails.setRegistrationId(mdpNgo.getSzRegistrationId());
        	mdpNGoDetails.setSecondaryCategory(mdpNgo.getSzCategorySecondary());
        	mdpNGoDetails.setState(mdpNgo.getSzState());
        	mdpNGoDetails.setVeriifiedBy(mdpNgo.getSzVerifiedBy());
        	mdpNGoDetails.setWebsite(mdpNgo.getSzWebsite());
        	json = new Gson().toJson(mdpNGoDetails);
        }
        userDetails = new Gson().fromJson(json, Map.class);
    	return userDetails;   
    }

}
