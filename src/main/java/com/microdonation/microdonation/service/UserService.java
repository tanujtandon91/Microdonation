package com.microdonation.microdonation.service;

import com.microdonation.microdonation.event.OnRegistrationCompleteEvent;
import com.microdonation.microdonation.model.User;
import com.microdonation.microdonation.model.VerificationToken;
import com.microdonation.microdonation.payload.SignUpRequest;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    public void sendUserActivationEmail(OnRegistrationCompleteEvent event,User user);

    User getUser(String verificationToken);


    void createVerificationToken(User user, String token);

    VerificationToken getVerificationToken(String VerificationToken);

    public boolean verifyToken(String token,Long userId);

    public User createOrUpdateUser(SignUpRequest signUpRequest, HttpServletRequest request);
}
