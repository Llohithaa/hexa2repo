package com.hexaware.controller;

import java.util.Scanner;

import com.hexaware.dao.OfficerDao;
import com.hexaware.entity.Officer;

public class OfficerController {
	OfficerDao officerDao;
	Officer officer;
	Scanner sc=new Scanner(System.in);
	public void addOfficer() throws Exception{
		System.out.println("Enter officerId:");
		int officerId=sc.nextInt();
		System.out.println("Enter officer First Name:");
		String firstName=sc.next();
		System.out.println("Enter officer Last Name:");
		String lastName=sc.next();
		System.out.println("Enter officer badgeNumber:");
		String badgeNumber=sc.next();
		System.out.println("Enter officer Rank:");
		String rank=sc.next();
		System.out.println("Enter officer Address:");
		String address=sc.next();
		System.out.println("Enter officer Contact Information:");
		long contactInformation=sc.nextLong();
		System.out.println("Enter AgencyId:");
		int agencyId=sc.nextInt();
		Thread.sleep(1000);
		officer=new Officer(officerId, firstName, lastName, badgeNumber, rank, address, contactInformation, agencyId);
		officerDao.addOfficer(officer);
		System.out.println("Officer Details Added Successfully !!!");
	}
	
	public void updatedOfficerDetails() {
		System.out.println("Enter OfficerId:");
		int suspectId=sc.nextInt();
		System.out.println("Enter Suspect Contact Information:");
		long contactInformation=sc.nextLong();
		officerDao.updateOfficer(contactInformation, suspectId);
	}
	
	public void removedOfficerDetails() {
		System.out.println("Enter OfficerId:");
		int officerId=sc.nextInt();
		officerDao.removeOfficer(officerId);
	}
}


