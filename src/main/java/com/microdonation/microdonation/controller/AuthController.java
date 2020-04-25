package com.microdonation.microdonation.controller;

import com.microdonation.microdonation.event.OnRegistrationCompleteEvent;
import com.microdonation.microdonation.model.User;
import com.microdonation.microdonation.model.UserDemographicDetails;
import com.microdonation.microdonation.payload.*;
import com.microdonation.microdonation.repository.UserRepository;
import com.microdonation.microdonation.security.JwtTokenProvider;
import com.microdonation.microdonation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

    @Autowired
    UserService userService;

    @Autowired
    ApplicationEventPublisher eventPublisher;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsernameOrEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest, HttpServletRequest request) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity(new ApiResponse(false, "Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"),
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
//        User user = new User(signUpRequest.getName(), signUpRequest.getUsername(),
//                signUpRequest.getEmail(), signUpRequest.getPassword());
        User user = new User();
        user.setUserType(signUpRequest.getUserType());
        user.setContactNo(signUpRequest.getContactNo());
        user.setEmail(signUpRequest.getEmail());
        user.setName(signUpRequest.getName());
        user.setUsername(signUpRequest.getUsername());
        user.setPassword(signUpRequest.getPassword());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setUserType(signUpRequest.getUserType());
        User result = userRepository.saveAndFlush(user);

        String appUrl = request.getContextPath();
        eventPublisher.publishEvent(new OnRegistrationCompleteEvent(result, request.getLocale(), appUrl));
        userService.sendUserActivationEmail(new OnRegistrationCompleteEvent(result, request.getLocale(), appUrl));
        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/users/{username}")
                .buildAndExpand(result.getUsername()).toUri();
        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
    }

    @PostMapping("/validateUser")
    public ResponseEntity<?> validateAndActivate(@Valid @RequestBody ActivateUser activateUser) {

        Optional<User> users = userRepository.findByUsername(activateUser.getUserName());
        User user = users.get();
        if (user.getOtp().equals(activateUser.getOtp())) {
            user.setActive(true);
            userRepository.saveAndFlush(user);
        } else {
            return new ResponseEntity(new ApiResponse(false, "OTP does not match"),
                    HttpStatus.BAD_REQUEST);
        }

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/users/{username}")
                .buildAndExpand(activateUser.getUserName()).toUri();

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




        return ResponseEntity.ok().body(new ApiResponse(true, "User registered successfully"));
    }

    @RequestMapping(value = "/updateProfile", method = {RequestMethod.POST})
    public ResponseEntity<?> updateUserProfile(@Valid @RequestBody UserDetails userDetails){


        UserDemographicDetails userDemographicDetails =  new UserDemographicDetails();





        return ResponseEntity.ok().body(new ApiResponse(true, "User registered successfully"));
    }

}