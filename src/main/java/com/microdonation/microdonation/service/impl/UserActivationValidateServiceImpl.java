package com.microdonation.microdonation.service.impl;

import com.microdonation.microdonation.exception.AppException;
import com.microdonation.microdonation.model.User;
import com.microdonation.microdonation.repository.UserRepository;
import com.microdonation.microdonation.service.UserActivationValidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserActivationValidateServiceImpl implements UserActivationValidateService {

    @Autowired
    UserRepository userRepository;

    public void validateUser(User user)
    {
           User users  = userRepository.findByIdAndCUserStatus(user.getId());
           if(null==users)
           {
               throw new AppException("User is not Active, Cannot Process Request");
           }
           if(users.iscUserLocked())
           {
               throw new AppException("User Id is locked ! Contact Administrator");
           }

    }
}
