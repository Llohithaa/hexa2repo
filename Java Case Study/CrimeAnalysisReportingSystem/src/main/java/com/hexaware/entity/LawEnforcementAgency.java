package com.hexaware.entity;

/**
 * The LawEnforcementAgency class represents a law enforcement agency entity in the Crime Analysis and Reporting System.
 * It stores information about an agency such as ID, name, jurisdiction, contact information, and associated officer.
 */

public class LawEnforcementAgency {
	private int agencyId;
	private String agencyName;
	private String jurisdiction;
	private long contactInformation;
	private Officer officer;
	
	//Default constructor
	public LawEnforcementAgency(){
		
	}
	
	//Parameterized constructor
	public LawEnforcementAgency(int agencyId, String agencyName, String jurisdiction, long contactInformation, Officer officer){
		super();
		this.agencyId=agencyId;
		this.agencyName=agencyName;
		this.jurisdiction=jurisdiction;
		this.contactInformation=contactInformation;
		this.officer=officer;
	}
	
	//Getters and setters
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

	@Override
	public String toString() {
		return "LawEnforcementAgency [agencyId=" + agencyId + ", agencyName=" + agencyName + ", jurisdiction="
				+ jurisdiction + ", contactInformation=" + contactInformation + ", officer=" + officer + "]";
	}
    
}
