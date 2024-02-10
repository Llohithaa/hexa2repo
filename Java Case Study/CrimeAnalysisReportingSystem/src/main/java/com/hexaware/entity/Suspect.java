package com.hexaware.entity;

/**
 * The Suspect class represents a suspect entity in the Crime Analysis and Reporting System.
 * It stores information about a suspect such as ID, name, date of birth, gender, address, and contact information.
 */

public class Suspect {
	private int suspectId;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String gender;
	private String address;
	private long contactInformation;
	
	//Default constructor
	public Suspect(){
		
	}
	
	//Parameterized constructor
	public Suspect(String firstName, String lastName, String dateOfBirth, String gender, String address, long contactInformation){
		super();
		//this.suspectId=suspectId;
		this.firstName=firstName;
		this.lastName=lastName;
		this.dateOfBirth=dateOfBirth;
		this.gender=gender;
		this.contactInformation=contactInformation;
	}
	
	//Getters and setters
	public int getSuspectID() {
        return suspectId;
    }

    public void setSuspectID(int suspectId) {
        this.suspectId = suspectId;
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
		return "Suspect [suspectId=" + suspectId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", address=" + address
				+ ", contactInformation=" + contactInformation + "]";
	}
}

