package com.microdonation.microdonation.controller;

import com.microdonation.microdonation.model.User;
import com.microdonation.microdonation.payload.ApiResponse;
import com.microdonation.microdonation.payload.DonorNGoPymtFreqRequest;
import com.microdonation.microdonation.payload.SignUpRequest;
import com.microdonation.microdonation.service.DonorService;
import com.microdonation.microdonation.service.UserActivationValidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/donor")
public class DonorController {

    @Autowired
    DonorService donorService;

    @Autowired
    UserActivationValidateService validatorService;

    @PostMapping("/updatePymtFrequency")
    public ResponseEntity<?> setUpDonorPymtFreq(@Valid @RequestBody DonorNGoPymtFreqRequest donorNGoPymtFreqRequest, HttpServletRequest request) {
        try {
            User user = new User();
            user.setId(donorNGoPymtFreqRequest.getUserId());
            validatorService.validateUser(user);
            donorService.saveDonorFrequency(donorNGoPymtFreqRequest);
            return ResponseEntity.ok().body(new ApiResponse(true, "Frequency Updated Successfully"));
        } catch (Exception e) {
            return ResponseEntity.ok().body(new ApiResponse(false, e.getMessage()));
        }
    }
}
