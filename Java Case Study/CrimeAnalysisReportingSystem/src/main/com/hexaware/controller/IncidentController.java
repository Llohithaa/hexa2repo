package com.hexaware.controller;

import java.util.Scanner;
import com.hexaware.dao.IncidentDao;
import com.hexaware.entity.Incident;

public class IncidentController {
	Incident incident = new Incident();
	IncidentDao incidentDao = new IncidentDao();
	
	Scanner sc=new Scanner(System.in);
	public void incidentDetails() throws Exception {
		System.out.println("Enter IncidentId:");
		int incidentId=sc.nextInt();
		System.out.println("Enter Incident Type:");
		String incidentType=sc.nextLine();
		System.out.println("Enter Incident Date(YYYY-MM-DD):");
		String incidentDate=sc.next();
		System.out.println("Enter Location:");
		String location=sc.next();
		System.out.println("Enter Description:");
		String description=sc.nextLine();
		System.out.println("Enter VictimId:");
		int victimId=sc.nextInt();
		System.out.println("Enter SuspectId:");
		int suspectId=sc.nextInt();
		String status = "Opened";
		Thread.sleep(1000);
		incident=new Incident(incidentId, incidentType, incidentDate, location, description, status, victimId, suspectId);
		incidentDao.addIncident(incident);
		System.out.println("Your Complaint Registered Successfully\nComplaint Status " + status);
	}
	
	public void updateComplaintStatus() {
		System.out.println("Enter IncidentId:");
		int incidentId=sc.nextInt();
		System.out.println("Enter Status:");
		String status=sc.next();
		incidentDao.updateIncidentStatus(status, incidentId);	
	}
	
	public void displayIncidentDetails(){
		System.out.println("Enter IncidentId:");
		int incidentId=sc.nextInt();
		incidentDao.getIncidentDetails(incidentId);
	}
	
	public void displayIncidentByDateRange() {
		System.out.println("Enter Incident Date Range(YYYY-MM-DD):");
		String startDate=sc.next();
		String endDate=sc.next();
		incidentDao.getIncidentInDateRange(startDate, endDate);
	}
	
	public void displayAllIncident() {
		incidentDao.getAllIncident(incident);
	}
	
	public void displayIncidentStatus() {
		System.out.println("Enter IncidentId:");
		int incidentId=sc.nextInt();
		incidentDao.getIncidentStatus(incidentId);
	}
	
	
	
}
