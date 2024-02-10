package com.hexaware.entity;

/**
 * The Case class represents a case filed in the Crime Analysis and Reporting System.
 * It stores information such as case ID, incident ID, complainant ID, and case date.
 */

public class Case {
	private int caseId;
	private int incidentId;
	private int victimId;
	private String caseDate;
	
	//Default Constructor
	public Case() {
		
	}

	//Parameterized Constructor
	public Case(int victimId, int incidentId, String caseDate) {
		super();
		//this.caseId = caseId;
		this.incidentId = incidentId;
		this.victimId = victimId;
		this.caseDate = caseDate;
	}

	//Getters and setters
	public int getCaseId() {
		return caseId;
	}

	public void setCaseId(int caseId) {
		this.caseId = caseId;
	}

	public int getIncidentId() {
		return incidentId;
	}

	public void setIncidentId(int incidentId) {
		this.incidentId = incidentId;
	}

	public int getVictimId() {
		return victimId;
	}

	public void setVictimId(int victimId) {
		this.victimId = victimId;
	}

	public String getCaseDate() {
		return caseDate;
	}

	public void setCaseDate(String caseDate) {
		this.caseDate = caseDate;
	}

	@Override
	public String toString() {
		return "Case [caseId=" + caseId + ", incidentId=" + incidentId + ", complainantId=" + victimId
				+ ", caseDate=" + caseDate + "]";
	}
	
}
