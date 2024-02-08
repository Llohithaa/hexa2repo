package com.hexaware.entity;

/**
 * The Complainant class represents a person who filed a complaint in the Crime Analysis and Reporting System.
 * It stores information such as complainant ID, name, contact information, and relationship with the victim.
 */

public class Complainant {
	private int complainantId;
	private String complainantName;
	private Long contactInformation;
	private String relationShipWithVictim;
	
	//Default constructor
	public Complainant() {
		
	}

	//Parameterized constructor
	public Complainant(int complainantId, String complainantName, Long contactInformation, String relationShipWithVictim) {
		super();
		this.complainantId = complainantId;
		this.complainantName = complainantName;
		this.contactInformation = contactInformation;
		this.relationShipWithVictim = relationShipWithVictim;
	}

	//Getters and setters
	public int getComplainantId() {
		return complainantId;
	}

	public void setComplainantId(int complainantId) {
		this.complainantId = complainantId;
	}

	public String getComplainantName() {
		return complainantName;
	}

	public void setComplainantName(String complainantName) {
		this.complainantName = complainantName;
	}

	public long getContactInformation() {
		return contactInformation;
	}

	public void setContactInformation(Long contactInformation) {
		this.contactInformation = contactInformation;
	}

	public String getRelationShipWithVictim() {
		return relationShipWithVictim;
	}

	public void setRelationShipWithVictim(String relationShipWithVictim) {
		this.relationShipWithVictim = relationShipWithVictim;
	}

	@Override
	public String toString() {
		return "Complainant [complainantId=" + complainantId + ", namecomplainantName=" + complainantName + ", contactInformation="
				+ contactInformation + ", relationShipWithVictim=" + relationShipWithVictim + "]";
	}
	
}
