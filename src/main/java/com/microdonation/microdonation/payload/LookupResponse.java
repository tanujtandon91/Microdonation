package com.microdonation.microdonation.payload;

import java.util.Date;
import java.util.List;

public class LookupResponse {
	
	private List<LookupResponse.Lookups> lookups;
	
	public List<LookupResponse.Lookups> getLookups() {
		return lookups;
	}

	public void setLookups(List<LookupResponse.Lookups> lookups) {
		this.lookups = lookups;
	}

	public static class Lookups{
		private String lookupCode;
		private String lookupType;
		private String lookupValue;
		private Date dtCreated;
	
		public String getLookupCode() {
			return lookupCode;
		}
	
		public void setLookupCode(String lookupCode) {
			this.lookupCode = lookupCode;
		}
	
		public String getLookupType() {
			return lookupType;
		}
	
		public void setLookupType(String lookupType) {
			this.lookupType = lookupType;
		}
	
		public String getLookupValue() {
			return lookupValue;
		}
	
		public void setLookupValue(String lookupValue) {
			this.lookupValue = lookupValue;
		}
	
		public Date getDtCreated() {
			return dtCreated;
		}
	
		public void setDtCreated(Date dtCreated) {
			this.dtCreated = dtCreated;
		}
	}
}
