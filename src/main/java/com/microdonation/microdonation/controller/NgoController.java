package com.microdonation.microdonation.controller;

import com.microdonation.microdonation.model.User;
import com.microdonation.microdonation.payload.ApiResponse;
import com.microdonation.microdonation.payload.NgoReferenceRequest;
import com.microdonation.microdonation.payload.NgoReferenceResponse;
import com.microdonation.microdonation.service.NgoService;
import com.microdonation.microdonation.service.UserActivationValidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/ngo")
public class NgoController {

    @Autowired
    UserActivationValidateService validatorService;

    @Autowired
    NgoService ngoService;

    @PostMapping("/references")
    public ResponseEntity<?> postMyReferences(@Valid @RequestBody NgoReferenceRequest referenceRequest, HttpServletRequest request) {
        try {
            User user = new User();
            user.setId(referenceRequest.getUserId());
            validatorService.validateUser(user);
            ngoService.saveNgoReference(referenceRequest);
            return ResponseEntity.ok().body(new ApiResponse(true, "Reference Updated Successfully"));
        } catch (Exception e) {
            return ResponseEntity.ok().body(new ApiResponse(false, e.getMessage()));
        }
    }
    @GetMapping("/getReferences/{userId}")
    public ResponseEntity<?> getNgoReferences(@PathVariable(value = "userId") Long userId) {
        try {
            User user = new User();
            user.setId(userId);
            validatorService.validateUser(user);
            NgoReferenceResponse ngoReferenceResponse = ngoService.getMyReferences(user);
            return ResponseEntity.ok().body(new ApiResponse(true, ngoReferenceResponse));
        } catch (Exception e) {
            return ResponseEntity.ok().body(new ApiResponse(false, e.getMessage()));
        }
    }
}
