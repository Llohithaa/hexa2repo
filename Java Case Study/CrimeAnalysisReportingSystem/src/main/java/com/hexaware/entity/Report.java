package com.hexaware.entity;

/**
 * The Report class represents a report entity in the Crime Analysis and Reporting System.
 * It stores information about a report such as ID, related incident ID, officer ID, report date, report details, and status.
 */

public class Report {
	private int reportId;
	private int incidentId;
	private int officerId;
	private String reportDate;
	private String reportDetails;
	private String status;
	
	//Default constructor
	public Report(){
		
	}
	
	//Parameterized constructor
	public Report(int reportId, int incidentId, int officerId, String reportDate, String reportDetails, String status){
		super();
		this.reportId=reportId;
		this.incidentId=incidentId;
		this.officerId=officerId;
		this.reportDate=reportDate;
		this.reportDetails=reportDetails;
		this.status=status;
	}
	
	//Getters and setters
	public int getReportId() {
		return reportId;
	}
	public int getIncidentId() {
		return incidentId;
	}
	public int getOfficer() {
		return officerId;
	}
	public String getReportDate() {
		return reportDate;
	}
	public String getReportDetails() {
		return reportDetails;
	}
	public String getStatus() {
		return status;
	}
	public void setReportId(int reportId) {
		this.reportId=reportId;
	}
	public void setIncidentId(int incidentId) {
		this.incidentId=incidentId;
	}
	public void setOfficerId(int officerId) {
		this.officerId=officerId;
	}
	public void setReportDate(String reportDate) {
		this.reportDate=reportDate;
	}
	public void setReportDetails(String reportDetails) {
		this.reportDetails=reportDetails;;
	}
	public void setStatus(String status) {
		this.status=status;
	}

	@Override
	public String toString() {
		return "Report [reportId=" + reportId + ", incidentId=" + incidentId + ", officerId=" + officerId
				+ ", reportDate=" + reportDate + ", reportDetails=" + reportDetails + ", status=" + status + "]";
	}

}

