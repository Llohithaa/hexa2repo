package com.hexaware.controller;
import com.hexaware.dao.CustomerImplementation;
import com.hexaware.dao.ProductImplementation;
import com.hexaware.exception.CustomerNotFullException;
import com.hexaware.model.Customers;
import com.hexaware.model.Orders;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class CustomerController {
	Customers customer;
	Orders order;
	Scanner sc=new Scanner(System.in);
	CustomerImplementation customerDao=new CustomerImplementation();
	ProductImplementation productDao=new ProductImplementation();
	ProductController pc = new ProductController();
	OrderController oc = new OrderController();
	public void createNewCustomer() {
		System.out.println("_____SignUp Page_____");
		System.out.println("Enter CustomerId:");
		int customerId=sc.nextInt();
		System.out.println("Enter FirstName:");
		String firstName=sc.next();
		System.out.println("Enter LasttName:");
		String lastName=sc.next();
		System.out.println("Enter Email:");
		String Email=sc.next();
		System.out.println("Enter Phone:");
		long phone=sc.nextLong();
		System.out.println("Enter Address:");
		String Address=sc.next();
		customer=new Customers(customerId, firstName, lastName, Email, phone, Address);
		customerDao.addCustomer(customer);
		System.out.println("Customer Added Successfully !!!");
	}
	
	public void getExistingCustomer(){
		System.out.println("______Login Page______");
		System.out.println("Enter CustomerId:");
		int customerId=sc.nextInt();
		System.out.println("Enter PhoneNumber:");
		long phone=sc.nextLong();
		System.out.println("1.Place Order\n2.Order Status\n3.Update Profile\4.Delete Order");
		int userInput=sc.nextInt();
		switch (userInput) {
		case 1:{
			oc.displayAddedOrder();
			
			break;
		}
		case 2:{
			//orderstatus method
			break;
		}
		case 3:{
			customerDao.updateCustomer(customerId, phone);
			break;
		}
		case 4:{
			
		} 
		}
	}
	
	public void displayCustomer() {
	    try {
	        System.out.print("Enter Customer ID: ");
	        int customerId = sc.nextInt();
	        List<Customers> customers = customerDao.getCustomers(customerId);
	        System.out.println("Customer Details: ");
	        for (Customers customer : customers) {
	            System.out.println(customer);
	        }
	    } catch (CustomerNotFullException e) {
	            System.out.println("Error: " + e.getMessage());
	            System.out.println("Exiting the system because of exception raised");
	            System.exit(1);
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	       
	    }
	}
}
