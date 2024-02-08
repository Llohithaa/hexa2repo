package com.hexaware.dao;

import java.util.List;
import com.hexaware.entity.Case;
import com.hexaware.entity.Complainant;
import com.hexaware.entity.Incident;
import com.hexaware.entity.Report;
import com.hexaware.entity.Suspect;
import com.hexaware.entity.Victim;
import com.hexaware.myexceptions.DuplicateRecordException;
import com.hexaware.myexceptions.IncidentNumberNotFoundException;

/**
 * Interface defining methods for Crime Analysis Service.
 */

public interface ICrimeAnalysisService {
	
	/**
     * Method to add a complainant record.
     * 
     * @param complainant The complainant object to be added.
     */
	
	void addComplainant(Complainant complainant);
	
	/**
     * Method to add a victim record.
     * 
     * @param victim The victim object to be added.
     * @throws DuplicateRecordException if a duplicate record is found.
     */
	
	void addVictim(Victim victim)throws DuplicateRecordException;
	
	/**
     * Method to add a suspect record.
     * 
     * @param suspect The suspect object to be added.
     * @throws DuplicateRecordException if a duplicate record is found.
     */
	
	void addSuspect(Suspect suspect) throws DuplicateRecordException;
	
	 /**
     * Method to add an incident record.
     * 
     * @param incident The incident object to be added.
     * @throws DuplicateRecordException if a duplicate record is found.
     */
	
	void addIncident(Incident incident) throws DuplicateRecordException;
	
	/**
     * Method to add a case record.
     * 
     * @param cases The case object to be added.
     * @throws DuplicateRecordException if a duplicate record is found.
     */
	
	void addCase(Case cases)throws DuplicateRecordException;
	
	 /**
     * Method to get the status of an incident.
     * 
     * @param incidentId The ID of the incident.
     */
	
	void getIncidentStatus(int incidentId);
	
	/**
     * Method to update the status of an incident.
     * 
     * @param status     The new status of the incident.
     * @param incidentId The ID of the incident to be updated.
     * @throws IncidentNumberNotFoundException if the incident ID is not found.
     */
	
	void updateIncidentStatus(String status, int incidentId)throws IncidentNumberNotFoundException;
	
	/**
     * Method to get incidents within a date range.
     * 
     * @param startDate The start date of the range.
     * @param endDate   The end date of the range.
     * @return A list of incidents within the specified date range.
     */
	
	List<Incident> getIncidentInDateRange(String startDate, String endDate);
	
	/**
     * Method to get incidents by type.
     * 
     * @param incidentType The type of incident.
     * @return A list of incidents of the specified type.
     */
	
	List<Incident> getIncidentType(String incidentType);
	
	 /**
     * Method to generate an incident report.
     * 
     * @param reportId The ID of the report to be generated.
     * @return A list of reports for the specified report ID.
     */
	
	List<Report> generateIncidentReport(int reportId);
	
	/**
     * Method to get case details by case ID.
     * 
     * @param caseId The ID of the case.
     * @return A list of cases for the specified case ID.
     */
	
	List<Case> getCaseByCaseId(int caseId);
	
	/**
     * Method to update case details by case ID.
     * 
     * @param caseDate The new date of the case.
     * @param caseId   The ID of the case to be updated.
     * @throws IncidentNumberNotFoundException if the case ID is not found.
     */
	
	void updateCaseByCaseId(String caseDate, int caseId)throws IncidentNumberNotFoundException;
	
	   /**
     * Method to get all case details.
     * 
     * @param cases The case object.
     * @return A list of all case details.
     */
	
	List<Case> getAllCaseDetails(Case cases);
	
	/**
     * Method to update suspect details by suspect ID.
     * 
     * @param contactInformation The new contact information of the suspect.
     * @param suspectId          The ID of the suspect to be updated.
     * @throws IncidentNumberNotFoundException if the suspect ID is not found.
     */
	
	void updateSuspectById(String contactInformation, int suspectId)throws IncidentNumberNotFoundException;
	
	 /**
     * Method to remove suspect details by suspect ID.
     * 
     * @param suspectId The ID of the suspect to be removed.
     */
	
	void removeSuspectByCaseId(int suspectId);
	
	 /**
     * Method to update evidence details by evidence ID.
     * 
     * @param location   The new location of the evidence.
     * @param evidenceId The ID of the evidence to be updated.
     * @throws IncidentNumberNotFoundException if the evidence ID is not found.
     */
	
	void updateEvidenceByCaseId(String location, int evidenceId)throws IncidentNumberNotFoundException;
	
}
