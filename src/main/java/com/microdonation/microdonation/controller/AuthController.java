package com.microdonation.microdonation.controller;

import com.microdonation.microdonation.event.OnRegistrationCompleteEvent;
import com.microdonation.microdonation.model.User;
import com.microdonation.microdonation.payload.*;
import com.microdonation.microdonation.repository.UserRepository;
import com.microdonation.microdonation.security.JwtTokenProvider;
import com.microdonation.microdonation.service.DonorService;
import com.microdonation.microdonation.service.NgoService;
import com.microdonation.microdonation.service.UserActivationValidateService;
import com.microdonation.microdonation.service.UserService;
import com.microdonation.microdonation.service.impl.NgoServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtTokenProvider tokenProvider;

    @Autowired
    UserService userService;

    @Autowired
    ApplicationEventPublisher eventPublisher;

    @Autowired
    DonorService donorService;
    
    @Autowired
    NgoService ngoService;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsernameOrEmail(),
                        loginRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        try {
            Map<String, Object> loginResponse = userService.login(loginRequest, authentication);
            return ResponseEntity.ok(new ApiResponse(true, loginResponse));
        } catch (Exception e) {
            return ResponseEntity.ok(new ApiResponse(false, e.getMessage()));
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest, HttpServletRequest request) {
        if (userRepository.existsBySzUsername(signUpRequest.getUsername())) {
            return new ResponseEntity(new ApiResponse(false, "Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        if (userRepository.existsBySzEmail(signUpRequest.getEmail())) {
            return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"),
                    HttpStatus.BAD_REQUEST);
        }
        User result = null;
        try {
           result =  userService.createOrUpdateUser(signUpRequest,request);
        }
        catch (Exception e){

            return new ResponseEntity(new ApiResponse(false, e.getMessage()),
                    HttpStatus.BAD_REQUEST);
        }

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/users/{username}")
                .buildAndExpand(signUpRequest.getUsername()).toUri();
        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
    }

    @RequestMapping(value = "/registerConfirmation/{userId}/{token}", method = {RequestMethod.GET})
    public ResponseEntity<?> registrationCnfirmation(@PathVariable(value = "userId") Long userId,
                                           @PathVariable(value = "token") String token) {

        try {
            Boolean verificationStatus = false;
            boolean validateToken = tokenProvider.validateToken(token);
            if (validateToken == true) {
                verificationStatus = userService.verifyToken(token, userId);
            }
            if (verificationStatus) {

                return ResponseEntity.ok().body(new ApiResponse(true, "User has been activated"));
            } else {
                throw new Exception("Verification Failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok().body(new ApiResponse(false, "User activation Failed"));
        }
    }

    @RequestMapping(value = "/userprofile/{userId}", method = {RequestMethod.GET})
    public ResponseEntity<?> getUserProfile(@PathVariable(value = "userId") Long userId){
    	try {
    		//UserService.getUserDetails(userId);
    	} catch(Exception e) {
    		
    	}
        return ResponseEntity.ok().body(new ApiResponse(true, "User registered successfully"));
    }

    @RequestMapping(value = "/updateProfileDonor", method = {RequestMethod.POST})
    public ResponseEntity<?> updateUserProfile(@Valid @RequestBody MdpDonorDetails mdpDonorDetails){
    	try {
    		donorService.updateDonorDetails(mdpDonorDetails);
    	} catch(Exception e) {
    		
    	}
        return ResponseEntity.ok().body(new ApiResponse(true, "User registered successfully"));
    }
    
    @RequestMapping(value = "/updateProfileNgo", method = {RequestMethod.POST})
    public ResponseEntity<?> updateUserProfile(@Valid @RequestBody MdpNGoDetails mdpNGoDetails){
    	try {
    		ngoService.updateNgoDetails(mdpNGoDetails);
    	} catch(Exception e) {
    		
    	}
        return ResponseEntity.ok().body(new ApiResponse(true, "User registered successfully"));
    }


}