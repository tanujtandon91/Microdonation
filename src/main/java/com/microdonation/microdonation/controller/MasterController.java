package com.microdonation.microdonation.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.microdonation.microdonation.payload.ApiResponse;
import com.microdonation.microdonation.payload.LookupRequest;
import com.microdonation.microdonation.service.LookupService;



@RestController
@RequestMapping("/api/master")
public class MasterController {

	@Autowired
	LookupService lookupService;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/getLookup")
    public ResponseEntity<?> getLookup(@Valid @RequestBody LookupRequest lookupRequest) {
        try {
            return ResponseEntity.ok().body(new ApiResponse(true, lookupService.fetchLookupValues(lookupRequest)));
        } catch (Exception e) {
            return ResponseEntity.ok().body(new ApiResponse(false, e.getMessage()));
        }
    }
}
