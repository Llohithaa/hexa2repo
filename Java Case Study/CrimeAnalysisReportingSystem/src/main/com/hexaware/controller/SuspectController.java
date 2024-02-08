package com.hexaware.controller;

import java.util.Scanner;
import com.hexaware.dao.SuspectDao;
import com.hexaware.entity.Suspect;

public class SuspectController {
	SuspectDao suspectDao;
	Suspect suspect;
	Scanner sc=new Scanner(System.in);
	public void suspectDetails() throws Exception{
		System.out.println("Enter SuspectId:");
		int suspectId=sc.nextInt();
		System.out.println("Enter Suspect First Name:");
		String firstName=sc.next();
		System.out.println("Enter Suspect Last Name:");
		String lastName=sc.next();
		System.out.println("Enter Suspect Date Of Birth(YYYY-MM-DD):");
		String dateOfBirth=sc.next();
		System.out.println("Enter Suspect Gender:");
		String gender=sc.next();
		System.out.println("Enter Suspect Address:");
		String address=sc.next();
		System.out.println("Enter Suspect Contact Information:");
		long contactInformation=sc.nextLong();
		Thread.sleep(1000);
		suspect=new Suspect(suspectId, firstName, lastName, dateOfBirth, gender, address, contactInformation);
		suspectDao.addSuspect(suspect);
		System.out.println("Suspect Details Added Successfully !!!");
	}
	
	public void updatedSuspectDetails() {
		System.out.println("Enter SuspectId:");
		int suspectId=sc.nextInt();
		System.out.println("Enter Suspect Date Of Birth(YYYY-MM-DD):");
		String dateOfBirth=sc.next();
		System.out.println("Enter Suspect Contact Information:");
		long contactInformation=sc.nextLong();
		suspectDao.updateSuspect(contactInformation, dateOfBirth, suspectId);
	}
	
	public void removeSuspectDetails() {
		System.out.println("Enter SuspectId:");
		int suspectId=sc.nextInt();
		suspectDao.removeSuspect(suspectId);
	}
}
