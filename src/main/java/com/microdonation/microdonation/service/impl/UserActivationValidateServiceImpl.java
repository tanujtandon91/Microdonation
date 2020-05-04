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
       try{
           User users  = userRepository.findByIdAndCUserStatus(user.getId());
           if(null==users)
           {
               throw new AppException("User is not Active, Cannot Process Request");
           }
       }catch (Exception e)
       {
           throw new AppException("User is not Active, Cannot Process Request");
       }
    }
}
