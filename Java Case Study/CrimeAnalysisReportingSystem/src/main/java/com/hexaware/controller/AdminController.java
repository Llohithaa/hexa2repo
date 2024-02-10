package com.hexaware.controller;

import java.util.List;
import java.util.Scanner;

import com.hexaware.dao.CrimeAnalysisServiceImpl;
import com.hexaware.entity.Case;
import com.hexaware.entity.Incident;
import com.hexaware.entity.Report;
import com.hexaware.myexceptions.IncidentNumberNotFoundException;

/**
 * The AdminController class provides methods for managing incident and case records,
 * generating incident reports, and updating suspect details. It interacts with the
 * CrimeAnalysisServiceImpl class to perform these operations.
 */

public class AdminController {
	Incident incident;
	Case cases;
	Scanner sc = new Scanner(System.in);
	CrimeAnalysisServiceImpl implementation=new CrimeAnalysisServiceImpl();
	
	// Updates the status of an incident.
	public void updateIncidentStatus() {
		System.out.println("Enter IncidentId:");
		int incidentId=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Status:");
		String status=sc.nextLine();
		try {
		implementation.updateIncidentStatus(status, incidentId);	
		}catch (IncidentNumberNotFoundException e) {
	        System.out.println(e.getMessage());
	    }
	}

	// Retrieves incidents within a given date range.
	public void getIncidentInDateRange() {
		System.out.println("Enter Incident Date Range(YYYY-MM-DD):");
		String startDate=sc.next();
		String endDate=sc.next();
		List<Incident> incidents = implementation.getIncidentInDateRange(startDate, endDate);
        System.out.println("Incident Details: ");
        for (Incident incident : incidents) {
            System.out.println(incident);
        }
	}
	
	// Retrieves incidents of a specific type.
	public void getIncidentByType() {
		System.out.println("Enter Incident Type:");
		String incidentType=sc.next();
		List<Incident> incidents = implementation.getIncidentType(incidentType);
        System.out.println("Incident Details: ");
        for (Incident incident : incidents) {
            System.out.println(incident);
        }
	}
	
	// Generates an incident report based on the given report ID.
	public void getIncidentReport() {
		System.out.println("Enter reportId:");
		int reportId=sc.nextInt();
		List<Report> reports = implementation.generateIncidentReport(reportId);
        System.out.println("Report Details: ");
        for (Report report : reports) {
            System.out.println(report);
        }
	}
	
	// Retrieves details of a case by its ID.
	public void getCaseDetails() {
		System.out.println("Enter caseId:");
		int caseId=sc.nextInt();
		List<Case> cases1 = implementation.getCaseByCaseId(caseId);
        System.out.println("Incident Report Details: ");
        for (Case cases : cases1) {
            System.out.println(cases);
        }
	}
	
	// Updates details of a case by its ID.
	public void updateCaseDetails() {
		System.out.println("Enter caseId:");
		int caseId=sc.nextInt();
		System.out.println("Enter caseDate:");
		String caseDate=sc.next();
		try {
		implementation.updateCaseByCaseId(caseDate, caseId);
		}catch (IncidentNumberNotFoundException e) {
	        System.out.println(e.getMessage());
	    }
	}
	
	// Retrieves details of all cases.
	public void getAllCases() {
		List<Case> cases1 = implementation.getAllCaseDetails(cases);
        System.out.println("Order Details: ");
        for (Case cases : cases1) {
            System.out.println(cases);
        }
	}
	
	// Updates details of a suspect by their ID.
	public void updateSuspectDetails() {
		System.out.println("Enter suspectId:");
		int suspectId=sc.nextInt();
		System.out.println("Enter contactInformation:");
		String contactInformation=sc.next();
		try {
		implementation.updateSuspectById(contactInformation, suspectId);
		} catch (IncidentNumberNotFoundException e) {
	        System.out.println(e.getMessage());
	    }
	}
	
	
	// Updates evidence details by their ID.
	public void updateEvidence() {
		System.out.println("Enter evidenceId:");
		int evidenceId=sc.nextInt();
		System.out.println("Enter location:");
		String location=sc.next();
		try {
		implementation.updateEvidenceByCaseId(location, evidenceId);
		} catch (IncidentNumberNotFoundException e) {
	        System.out.println(e.getMessage());
	    }
	}
}
