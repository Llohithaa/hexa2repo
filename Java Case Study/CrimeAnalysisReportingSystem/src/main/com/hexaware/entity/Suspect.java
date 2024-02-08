package com.hexaware.entity;

public class Suspect {
	private int suspectId;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String gender;
	private String address;
	private long contactInformation;
	
	public Suspect(){
		
	}
	
	public Suspect(int suspectId, String firstName, String lastName, String dateOfBirth, String gender, String address, long contactInformation){
		super();
		this.suspectId=suspectId;
		this.firstName=firstName;
		this.lastName=lastName;
		this.dateOfBirth=dateOfBirth;
		this.gender=gender;
		this.contactInformation=contactInformation;
	}
	
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
}

