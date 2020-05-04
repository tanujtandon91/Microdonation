package com.microdonation.microdonation.service.impl;

import com.microdonation.microdonation.event.OnRegistrationCompleteEvent;
import com.microdonation.microdonation.exception.AppException;
import com.microdonation.microdonation.model.User;
import com.microdonation.microdonation.model.VerificationToken;
import com.microdonation.microdonation.payload.MdpDonorDetails;
import com.microdonation.microdonation.payload.MdpNGoDetails;
import com.microdonation.microdonation.payload.SignUpRequest;
import com.microdonation.microdonation.repository.DonorRepository;
import com.microdonation.microdonation.repository.NgoRepository;
import com.microdonation.microdonation.repository.UserRepository;
import com.microdonation.microdonation.repository.VerificationTokenRepository;
import com.microdonation.microdonation.security.JwtTokenProvider;
import com.microdonation.microdonation.service.DonorService;
import com.microdonation.microdonation.service.NgoService;
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
import java.util.Date;
import java.util.Optional;
import java.util.Properties;
import java.util.UUID;

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




}
