package com.microdonation.microdonation.service;

import com.microdonation.microdonation.event.OnRegistrationCompleteEvent;
import com.microdonation.microdonation.model.User;
import com.microdonation.microdonation.model.VerificationToken;

public interface UserService {
    public void sendUserActivationEmail(OnRegistrationCompleteEvent event);

    User getUser(String verificationToken);


    void createVerificationToken(User user, String token);

    VerificationToken getVerificationToken(String VerificationToken);

    public boolean verifyToken(String token,Long userId);
}
