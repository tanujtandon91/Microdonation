package com.microdonation.microdonation.service;

import com.microdonation.microdonation.payload.*;

public interface LookupService {

	@SuppressWarnings("rawtypes")
	public ApiResponse fetchLookupValues(String type);
}
