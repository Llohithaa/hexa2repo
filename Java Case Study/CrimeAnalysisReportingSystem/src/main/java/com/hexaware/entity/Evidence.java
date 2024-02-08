package com.hexaware.entity;

/**
 * The Evidence class represents evidence related to an incident in the Crime Analysis and Reporting System.
 * It stores information such as evidence ID, description, location, and the ID of the incident it's associated with.
 */

public class Evidence {
	private int evidenceId;
	private String description;
	private String location;
	private int incidentId;
	
	//Default constructor
	public Evidence(){
		
	}
	
	//Parameterized constructor
	public Evidence(int evidenceId, String description, String location, int incidentId){
		super();
		this.evidenceId=evidenceId;
		this.description=description;
		this.location=location;
		this.incidentId=incidentId;
		
	}
	
	//Getters and setters
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

	@Override
	public String toString() {
		return "Evidence [evidenceId=" + evidenceId + ", description=" + description + ", location=" + location
				+ ", incidentId=" + incidentId + "]";
	}
	
}
