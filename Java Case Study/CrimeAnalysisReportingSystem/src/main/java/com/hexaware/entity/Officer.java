package com.hexaware.entity;

/**
 * The Officer class represents a law enforcement officer entity in the Crime Analysis and Reporting System.
 * It stores information about an officer such as ID, first name, last name, badge number, rank, address,
 * contact information, and agency ID.
 */

public class Officer {
	private int officerId;
	private String firstName;
	private String lastName;
	private String badgeNumber;
	private String rank;
	private String address;
	private long contactInformation;
	private int agencyId;
	
	//Default constructor
	public Officer(){
		
	}
	
	//Parameterized constructor
	public Officer(int officerId, String firstName, String lastName, String badgeNumber, String rank, String address, long contactInformation, int agencyId){
		super();
		this.officerId=officerId;
		this.firstName=firstName;
		this.lastName=lastName;
		this.badgeNumber=badgeNumber;
		this.rank=rank;
		this.address=address;
		this.contactInformation=contactInformation;
		this.agencyId=agencyId;
	}
	
	//Getters and setters
	public int getOfficerId() {
		return officerId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getBadgeNumber() {
		return badgeNumber;
	}
	
	public String getRank() {
		return rank;
	}
	
	public String getAddress() {
		return address;
	}
	
	public long getContactInformation() {
		return contactInformation;
	}
	
	public int getAgencyId() {
		return agencyId;
	}
	
	public void setOfficerId(int officerId) {
		this.officerId=officerId;
	}
	
	public void setFirstName(String firstName) {
		this.firstName=firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName=lastName;
	}
	
	public void setBadgeNumber(String badgeNumber) {
		this.badgeNumber=badgeNumber;
	}
	
	public void setRank(String rank) {
		this.rank=rank;
	}
	
	public void setAddress(String address) {
		this.address=address;
	}
	
	public void setContactInformation(long contactInformation) {
		this.contactInformation=contactInformation;
	}
	
	public void setAgency(int agencyId) {
		this.agencyId=agencyId;
	}

	@Override
	public String toString() {
		return "Officer [officerId=" + officerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", badgeNumber=" + badgeNumber + ", rank=" + rank + ", address=" + address + ", contactInformation="
				+ contactInformation + ", agencyId=" + agencyId + "]";
	}
	
}
