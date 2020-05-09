package com.microdonation.microdonation.controller;

import com.google.gson.Gson;
import com.microdonation.microdonation.model.User;
import com.microdonation.microdonation.payload.*;
import com.microdonation.microdonation.service.DonorService;
import com.microdonation.microdonation.service.UserActivationValidateService;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/myNgo")
    public ResponseEntity<?> setNgoForDonor(@Valid @RequestBody MyNgoRequest myNgoRequest, HttpServletRequest request) {
        try {
            User user = new User();
            user.setId(myNgoRequest.getUserId());
            validatorService.validateUser(user);
            donorService.saveOrUpdateMyNgo(myNgoRequest);
            return ResponseEntity.ok().body(new ApiResponse(true, "Frequency Updated Successfully"));
        } catch (Exception e) {
            return ResponseEntity.ok().body(new ApiResponse(false, e.getMessage()));
        }
    }

    @GetMapping("/getPymtFrequency/{userId}")
    public ResponseEntity<?> getDonorPymtFreq(@PathVariable(value = "userId") Long userId) {
        try {
            User user = new User();
            user.setId(userId);
            validatorService.validateUser(user);
            DonorPymtFreqResponse donorPymtFreqResponse = donorService.getPymtFrequency(user);
            return ResponseEntity.ok().body(new ApiResponse(true, donorPymtFreqResponse));
        } catch (Exception e) {
            return ResponseEntity.ok().body(new ApiResponse(false, e.getMessage()));
        }
    }
    @GetMapping("/getMyNgo/{userId}")
    public ResponseEntity<?> setNgoForDonor(@PathVariable(value = "userId") Long userId) {
        try {
            User user = new User();
            user.setId(userId);
            validatorService.validateUser(user);
            MyNgoResponse myNgoResponse = donorService.getMyNgo(user);
            return ResponseEntity.ok().body(new ApiResponse(true, myNgoResponse));
        } catch (Exception e) {
            return ResponseEntity.ok().body(new ApiResponse(false, e.getMessage()));
        }
    }
    @PostMapping("/myReferences")
    public ResponseEntity<?> postMyReferences(@Valid @RequestBody DonorReferenceRequest referenceRequest, HttpServletRequest request) {
        try {
            User user = new User();
            user.setId(referenceRequest.getUserId());
            validatorService.validateUser(user);
            donorService.saveDonorReference(referenceRequest);
            return ResponseEntity.ok().body(new ApiResponse(true, "Reference Updated Successfully"));
        } catch (Exception e) {
            return ResponseEntity.ok().body(new ApiResponse(false, e.getMessage()));
        }
    }
    @GetMapping("/getMyReferences/{userId}")
    public ResponseEntity<?> getDonorReferences(@PathVariable(value = "userId") Long userId) {
        try {
            User user = new User();
            user.setId(userId);
            validatorService.validateUser(user);
            DonorReferenceResponse donorReferenceResponse = donorService.getMyReferences(user);
            return ResponseEntity.ok().body(new ApiResponse(true, donorReferenceResponse));
        } catch (Exception e) {
            return ResponseEntity.ok().body(new ApiResponse(false, e.getMessage()));
        }
    }
}
