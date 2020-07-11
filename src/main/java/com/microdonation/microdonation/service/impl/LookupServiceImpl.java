package com.microdonation.microdonation.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microdonation.microdonation.exception.DataNotFoundException;
import com.microdonation.microdonation.model.tLookup;
import com.microdonation.microdonation.payload.ApiResponse;
import com.microdonation.microdonation.payload.LookupRequest;
import com.microdonation.microdonation.payload.LookupResponse;
import com.microdonation.microdonation.repository.LookupRepository;
import com.microdonation.microdonation.service.LookupService;

@Service
public class LookupServiceImpl implements LookupService{

	@Autowired
	LookupRepository lookupRepository;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ApiResponse fetchLookupValues(LookupRequest lookupRequest) {
		String type = lookupRequest.getType();
		List<tLookup> tLookupObj =  lookupRepository.fetchLookup(type);
		LookupResponse lookupResponse = new LookupResponse();
		LookupResponse.Lookups lookups = null;
		List<LookupResponse.Lookups> lookuplist = new ArrayList<LookupResponse.Lookups>();
		for (tLookup tlookup : tLookupObj) { 	
			lookups = new LookupResponse.Lookups();
			lookups.setLookupCode(tlookup.getSzLookupCode()); 	
			lookups.setLookupType(tlookup.getSzLookupType());	
			lookups.setLookupValue(tlookup.getSzLookupValue());
			lookups.setDtCreated(tlookup.getDtCreated());
			lookuplist.add(lookups);
	      }
        lookupResponse.setLookups(lookuplist);
        if(tLookupObj.isEmpty()) {
			throw new DataNotFoundException("No Data Found for lookup type : " + type);
		}
        ApiResponse apiResponse = new ApiResponse<Object>();
        apiResponse.setSuccess(true);
        apiResponse.setData(lookupResponse);
        return apiResponse;
        
	}
}
