package com.hexaware.entity;

/**
 * The Victim class represents a victim entity in the Crime Analysis and Reporting System.
 * It stores information about a victim such as ID, name, date of birth, gender, address, and contact information.
 */

public class Victim {
	private int victimId;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String gender;
	private String address;
	private long contactInformation;
	
	//Default constructor
	public Victim(){
		
	}
	
	//Parameterized constructor
	public Victim(String firstName, String lastName, String dateOfBirth, String gender, String address, long contactInformation){
		super();
		//this.victimId=victimId;
		this.firstName=firstName;
		this.lastName=lastName;
		this.dateOfBirth=dateOfBirth;
		this.gender=gender;
		this.address=address;
		this.contactInformation=contactInformation;
	}
	
	//Getters and setters
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

	@Override
	public String toString() {
		return "Victim [victimId=" + victimId + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth="
				+ dateOfBirth + ", gender=" + gender + ", address=" + address + ", contactInformation="
				+ contactInformation + "]";
	}

}
