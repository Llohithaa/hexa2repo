package com.hexaware.entity;

public class Victim {
	private int victimId;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String gender;
	private String address;
	private long contactInformation;
	
	public Victim(){
		
	}
	
	public Victim(int victimId, String firstName, String lastName, String dateOfBirth, String gender, String address, long contactInformation){
		super();
		this.victimId=victimId;
		this.firstName=firstName;
		this.lastName=lastName;
		this.dateOfBirth=dateOfBirth;
		this.gender=gender;
		this.address=address;
		this.contactInformation=contactInformation;
	}
	
	public int getVictimID() {
        return victimId;
    }

    public void setVictimID(int victimId) {
        this.victimId = victimId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
    	return address;
    }
    
    public void setAddress(String address) {
    	this.address=address;
    }
    
    public long getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(long contactInformation) {
        this.contactInformation = contactInformation;
    }

}
