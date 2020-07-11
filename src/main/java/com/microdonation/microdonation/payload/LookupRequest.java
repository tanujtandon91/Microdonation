package com.microdonation.microdonation.payload;

import javax.validation.constraints.NotBlank;

public class LookupRequest {
    @NotBlank
    private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
