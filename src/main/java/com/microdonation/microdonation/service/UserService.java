package com.microdonation.microdonation.service;

import com.microdonation.microdonation.event.OnRegistrationCompleteEvent;
import com.microdonation.microdonation.model.User;
import com.microdonation.microdonation.model.VerificationToken;
import com.microdonation.microdonation.payload.LoginRequest;
import com.microdonation.microdonation.payload.SignUpRequest;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface UserService {
    public void sendUserActivationEmail(OnRegistrationCompleteEvent event,User user);

    User getUser(String verificationToken);


    void createVerificationToken(User user, String token);

    VerificationToken getVerificationToken(String VerificationToken);

    public boolean verifyToken(String token,Long userId);

    public User createOrUpdateUser(SignUpRequest signUpRequest, HttpServletRequest request);

    public Map<String,Object> login(LoginRequest loginRequest,Authentication authentication);
}
