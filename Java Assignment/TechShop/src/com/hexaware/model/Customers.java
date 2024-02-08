package com.hexaware.model;

public class Customers {
	 private int customerId;
	 private String firstName;
	 private String lastName;
	 private String email;
	 private long phone;
	 private String address;
	 
	 //Default constructor
	 public Customers() {
		 
	 }
	 
	 //Parameterized constructor
	 public Customers(int customerId, String firstName, String lastName, String email, long phone, String address){
		 super();
		 this.customerId=customerId;
		 this.firstName=firstName;
		 this.lastName=lastName;
		 this.email=email;
		 this.phone=phone;
		 this.address=address;
	 }
	 
	 //getters and setters
	 public int getCustomerId() {
		 return customerId;
	 }
	 
	 public String getFirstName() {
		 return firstName;
	 }
	 
	 public String getLastName() {
		 return lastName;
	 }
	 
	 public String getEmail() {
		 return email;
	 }
	 
	 public long getPhone() {
		 return phone;
	 }
	 
	 public String getAddress() {
		 return address;
	 }
	 
	 public void setcustomerId(int customerId) {
		 this.customerId=customerId;
	 }
	 
	 public void setFirstName(String firstName) {
		 this.firstName=firstName;
	 }
	 
	 public void setLastName(String lastName) {
		 this.lastName=lastName;
	 }
	 
	 public void setEmail(String email) {
		 this.email=email;
	 }
	 
	 public void setPhone(long phone) {
		 this.phone=phone;
	 }
	 
	 public void setAddress(String address) {
		 this.address=address;
	 }
	 
	 public int calculateTotalOrders() {
		 return 0;
	 }
	
	 public void getCustomerDetails() {
		 System.out.println("customerId:" + customerId + "\nfirstName:" + firstName + "\nlastName:" + lastName + "\nemail:" + email + "\nphone:" + phone + "\naddress:" + address);
	 }
	
	 public void updateCustomerInfo(String email, long phone, String address) {
		 this.email = email;
		 this.phone = phone;
		 this.address = address;
	 }

	@Override
	public String toString() {
		return "[customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", phone=" + phone + ", address=" + address + "]";
	}
	 
	 
}
