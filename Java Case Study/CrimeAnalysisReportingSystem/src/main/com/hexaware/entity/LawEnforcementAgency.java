package com.hexaware.entity;

public class LawEnforcementAgency {
	private int agencyId;
	private String agencyName;
	private String jurisdiction;
	private long contactInformation;
	private Officer officer;
	
	LawEnforcementAgency(){
		
	}
	
	LawEnforcementAgency(int agencyId, String agencyName, String jurisdiction, long contactInformation, Officer officer){
		super();
		this.agencyId=agencyId;
		this.agencyName=agencyName;
		this.jurisdiction=jurisdiction;
		this.contactInformation=contactInformation;
		this.officer=officer;
	}
	
	public int getAgencyId() {
		return agencyId;
	}
	
	public String getAgencyName() {
		return agencyName;
	}
	
	public String getJurisdiction() {
		return jurisdiction;
	}
	
    public long getContactInformation() {
		return contactInformation;
	}
    
    public Officer getOfficer() {
		return officer;
	}
    
    public void setAgencyId(int agencyId) {
    	this.agencyId=agencyId;
    }
    
    public void setAgencyName(String agencyName) {
    	this.agencyName=agencyName;
    }
    
    public void setJurisdiction(String jurisdiction) {
    	this.jurisdiction=jurisdiction;
    }
    
    public void setContactInformation(long contactInformation) {
    	this.contactInformation=contactInformation;
    }
    
    public void setOfficer(Officer officer) {
    	this.officer=officer;
    }
}
