package com.hexaware.controller;

import java.util.Scanner;

import com.hexaware.dao.VictimDao;
import com.hexaware.entity.Victim;

public class VictimController {
    VictimDao victimdao;
	Victim victim;
	Scanner sc=new Scanner(System.in);
	public void victimDetails() throws Exception {
		System.out.println("Enter victimId:");
		int victimId=sc.nextInt();
		System.out.println("Enter Victim First Name:");
		String firstName=sc.next();
		System.out.println("Enter Victim Last Name:");
		String lastName=sc.next();
		System.out.println("Enter Victim Date Of Birth(YYYY-MM-DD):");
		String dateOfBirth=sc.next();
		System.out.println("Enter Victim Gender:");
		String gender=sc.next();
		System.out.println("Enter Victim Address:");
		String address=sc.next();
		System.out.println("Enter Victim Contact Information:");
		long contactInformation=sc.nextLong();
		Thread.sleep(1000);
		victim=new Victim(victimId, firstName, lastName, dateOfBirth, gender, address, contactInformation);
		victimdao.addVictim(victim);
		System.out.println("Victim Details Added Successfully !!!");
	}

}
