package com.hexaware.controller;
import java.util.Scanner;
import com.hexaware.dao.ReportDao;
import com.hexaware.entity.Report;
public class ReportController {
	Report report;
	ReportDao reportDao;
	Scanner sc=new Scanner(System.in);
	public void displayIncidentReport() {
		System.out.println("Enter IncidentId");
		int incidentId = sc.nextInt();
		reportDao.generateIncidentReport(incidentId);
	}
}
