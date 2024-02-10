package com.hexaware.controller;

import java.util.Scanner;
import com.hexaware.dao.CrimeAnalysisServiceImpl;
import com.hexaware.entity.Case;
import com.hexaware.entity.Complainant;
import com.hexaware.entity.Incident;
import com.hexaware.entity.Suspect;
import com.hexaware.entity.Victim;
import com.hexaware.myexceptions.DuplicateRecordException;

/**
 * The UserController class handles user interactions and operations related to creating cases and managing victim, suspect, and incident details.
 */

public class UserController {
	Victim victim;
	Suspect suspect;
	Incident incident;
	Complainant complainant;
	Case cases;
	Scanner sc = new Scanner(System.in);
	CrimeAnalysisServiceImpl implementation=new CrimeAnalysisServiceImpl();
	
	public void createCase() throws Exception {
		UserController usercontroller = new UserController();
		String you;
		System.out.println("Are you a Victim(Y/N)?");
		you=sc.next();
		if (you.equals("N")||you.equals("n")) {
			System.out.println("Please Provide Your Details...");
			//System.out.println("Enter ComplainantId");
			//int complainantId=sc.nextInt();
			System.out.println("Enter complainantName");
			String complainantName=sc.next();
			System.out.println("Enter contactInformation");
			Long contactInformation=sc.nextLong();
			System.out.println("Enter relationShipWithVictim");
			String relationShipWithVictim=sc.next();
			complainant=new Complainant(complainantName, contactInformation, relationShipWithVictim);
			implementation.addComplainant(complainant);
			System.out.println("Complainant Details Added Successfully !!!");
			implementation.getComplainantIdInDb(contactInformation);
		}
		usercontroller.createVictim();
		usercontroller.createSuspect();
		usercontroller.createIncident();
		usercontroller.addcases();
    }
	
	/**
     * Creates a new victim by gathering details from the user and adding it to the system.
     * @throws Exception If an error occurs during victim creation.
     */
	
	public void createVictim() throws Exception {
		try {
		System.out.println("Please Provide Victim Details...");
		//System.out.println("Enter victimId:");
		//int victimId=sc.nextInt();
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
		victim=new Victim(firstName, lastName, dateOfBirth, gender, address, contactInformation);
		implementation.addVictim(victim);
		System.out.println("Victim Details Added Successfully !!!");
		implementation.getVictimIdInDb(contactInformation);
		}
		catch (DuplicateRecordException e) {
	        System.out.println(e.getMessage());
	    }
	}
	
	/**
     * Creates a new suspect by gathering details from the user and adding it to the system.
     * @throws Exception If an error occurs during suspect creation.
     */
	
	public void createSuspect() throws Exception{
		try {
		System.out.println("Please Provide Suspect Details...");
		//System.out.println("Enter SuspectId:");
		//int suspectId=sc.nextInt();
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
		suspect=new Suspect(firstName, lastName, dateOfBirth, gender, address, contactInformation);
		implementation.addSuspect(suspect);
		System.out.println("Suspect Details Added Successfully !!!");
		implementation.getSuspectIdInDb(contactInformation);
		}
		catch (DuplicateRecordException e) {
	        System.out.println(e.getMessage());
	    }
	}
	
	/**
     * Creates a new incident by gathering details from the user and adding it to the system.
     * @throws Exception If an error occurs during incident creation.
     */
	
	public void createIncident() throws Exception {
		try {
		System.out.println("Please Provide Incident Details...");
		//System.out.println("Enter IncidentId:");
		//int incidentId=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Incident Type:");
		String incidentType=sc.nextLine();
		//sc.nextLine();
		System.out.println("Enter Incident Date(YYYY-MM-DD):");
		String incidentDate=sc.nextLine();
		System.out.println("Enter Location:");
		String location=sc.nextLine();
		System.out.println("Enter Description:");
		String description=sc.nextLine();
		String status = "Opened";
		System.out.println("Enter VictimId:");
		int victimId=sc.nextInt();
		System.out.println("Enter SuspectId:");
		int suspectId=sc.nextInt();
		Thread.sleep(1000);
		incident=new Incident(incidentType, incidentDate, location, description, status, victimId, suspectId);
		implementation.addIncident(incident);
		System.out.println("Incident Details Added Successfully !!!");
		implementation.getIncidentIdInDb(victimId);
		} catch (DuplicateRecordException e) {
	        System.out.println(e.getMessage());
		}
	}

	
	/**
     * Displays the status of a complaint based on the incident ID entered by the user.
     */
	
	public void complaintStatus() {
		System.out.println("Enter IncidentId:");
		int incidentId=sc.nextInt();
		implementation.getIncidentStatus(incidentId);
	}
	
	public void addcases() {
		try {
		System.out.println("Please conform victim ID and incident ID...");
		//System.out.println("Enter caseId");
		//int caseId=sc.nextInt();
		System.out.println("Enter victimId");
		int victimId=sc.nextInt();
		System.out.println("Enter incidentId");
		int incidentId=sc.nextInt();
		System.out.println("Enter caseDate");
		String caseDate=sc.next();
		cases=new Case(victimId, incidentId, caseDate);
		implementation.addCase(cases);
		System.out.println("Your Complaint Registered Successfully...!");
		implementation.getCaseIdInDb(incidentId);
		implementation.getIncidentStatus(incidentId);
		} catch (DuplicateRecordException e) {
	        System.out.println(e.getMessage());
		}
	}
	
}
