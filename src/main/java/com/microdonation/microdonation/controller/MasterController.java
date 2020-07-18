package com.microdonation.microdonation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.microdonation.microdonation.service.LookupService;



@RestController
@RequestMapping("/api/master")
public class MasterController {

    @Autowired
    LookupService lookupService;

    @GetMapping("/getLookup/{type}")
    public ResponseEntity<?> getLookup(@PathVariable(value = "type") String type) {
        try {
            return ResponseEntity.ok().body(lookupService.fetchLookupValues(type));
        } catch (Exception e) {
            return ResponseEntity.ok().body(lookupService.fetchLookupValues(type));
        }
    }
}
