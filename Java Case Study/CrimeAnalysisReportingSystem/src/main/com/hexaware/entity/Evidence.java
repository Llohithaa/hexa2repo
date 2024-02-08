package com.hexaware.entity;

public class Evidence {
	private int evidenceId;
	private String description;
	private String location;
	private int incidentId;
	
	Evidence(){
		
	}
	
	Evidence(int evidenceId, String description, String location, int incidentId){
		super();
		this.evidenceId=evidenceId;
		this.description=description;
		this.location=location;
		this.incidentId=incidentId;
		
	}
	
	public int getEvidenceId() {
		return evidenceId;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getLocation() {
		return location;
	}
	
	public int getIncidentId() {
		return incidentId;
	}
	
	public void setEvidenceId(int evidenceId) {
		this.evidenceId=evidenceId;
	}
	
	public void setDescription(String description) {
		this.description=description;
	}
	
	public void setLocation(String location) {
		this.location=location;
	}
	
	public void setIncident(int incidentId) {
		this.incidentId=incidentId;
	}
	
}
