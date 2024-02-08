package com.hexaware.entity;

public class Incident {
	private int incidentId;
	private String incidentType;
	private String incidentDate;
	private String location;
	private String description;
	private String status;
	private int victimId;
	private int suspectId;
	
	public Incident(){
		
	}
	
	public Incident(int incidentId, String incidentType, String incidentDate, String location, String description, String status, int victimId, int suspectId){
		super();
		this.incidentId=incidentId;
		this.incidentType=incidentType;
		this.incidentDate=incidentDate;
		this.location=location;
		this.description=description;
		this.status=status;
		this.victimId=victimId;
		this.suspectId=suspectId;
	}
	
	public int getIncidentId() {
		return incidentId;
	}
	public String getIncidentType() {
		return incidentType;
	}
	public String getIncidentDate() {
		return incidentDate;
	}
	public String getLocation() {
		return location;
	}
	public String getDescription() {
		return description;
	}
	public String getStatus() {
		return status;
	}
	public int getVictimId() {
		return victimId;
	}
	public int getSuspectId() {
		return suspectId;
	}
	public void setIncidentId(int incidentId) {
		this.incidentId=incidentId;
	}
	public void setIncidentType(String incidentType) {
		this.incidentType=incidentType;
	}
	public void setIncidentDate(String incidentDate) {
		this.incidentDate=incidentDate;
	}
	public void setLocation(String location) {
		this.location=location;
	}
	public void setDescription(String description) {
		this.description=description;
	}
	public void setStatus(String status) {
		this.status=status;
	}
	public void setVictimId(int victimId) {
		this.victimId=victimId;
	}
	public void setSuspectId(int suspectId) {
		this.suspectId=suspectId;
	}

}
