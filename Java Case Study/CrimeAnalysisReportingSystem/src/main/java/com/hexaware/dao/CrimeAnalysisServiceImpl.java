package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.hexaware.entity.Case;
import com.hexaware.entity.Complainant;
import com.hexaware.entity.Incident;
import com.hexaware.entity.Report;
import com.hexaware.entity.Suspect;
import com.hexaware.entity.Victim;
import com.hexaware.myexceptions.DuplicateRecordException;
import com.hexaware.myexceptions.IncidentNumberNotFoundException;
import com.hexaware.util.DBConnUtil;

/**
 * This class implements the interface ICrimeAnalysisService and provides methods to interact with the database
 */

public class CrimeAnalysisServiceImpl implements ICrimeAnalysisService{
	Connection con;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;
	Report report;
	Incident incident;
	Case cases;
	Complainant complainant;
	
	public void addComplainant(Complainant complainant){
		try {
			con = DBConnUtil.getConnection();
			ps = con.prepareStatement("insert into complainant values(?,?,?,?)");
			ps.setInt(1, complainant.getComplainantId());
			ps.setString(2, complainant.getComplainantName());
			ps.setLong(3, complainant.getContactInformation());
			ps.setString(4, complainant.getRelationShipWithVictim());
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " row inserted Successfully !!!");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	// Method to add a victim to the database
	public void addVictim(Victim victim)throws DuplicateRecordException {
		try {
			con = DBConnUtil.getConnection();
			// Checking if the victim already exists
			ps = con.prepareStatement("select count(*) from victim where victimid = ?");
	        ps.setInt(1, victim.getVictimID());
	        rs = ps.executeQuery();
	        rs.next();
	        int count = rs.getInt(1);

	        if (count > 0) {
	            throw new DuplicateRecordException("Record already exists.");
	        }  
	        
	        // Inserting the victim record into the database
			ps = con.prepareStatement("insert into victim values(?,?,?,?,?,?,?)");
			ps.setInt(1, victim.getVictimID());
			ps.setString(2, victim.getFirstName());
			ps.setString(3, victim.getLastName());
			ps.setString(4, victim.getDateOfBirth());
			ps.setString(5, victim.getGender());
			ps.setString(6, victim.getAddress());
			ps.setLong(7, victim.getContactInformation());
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " inserted Successfully !!!");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	// Method to add a suspect to the database
	public void addSuspect(Suspect suspect) throws DuplicateRecordException{
		try {
			con = DBConnUtil.getConnection();
			// Checking if the suspect already exists
			ps= con.prepareStatement("select count(*) from suspect where suspectid = ?");
	        ps.setInt(1, suspect.getSuspectID());
	        rs = ps.executeQuery();
	        rs.next();
	        int count = rs.getInt(1);

	        if (count > 0) {
	            throw new DuplicateRecordException("Record already exists.");
	        }  
	       
	        // Inserting the suspect record into the database
			ps = con.prepareStatement("insert into suspect values(?,?,?,?,?,?,?)");
			ps.setInt(1, suspect.getSuspectID());
			ps.setString(2, suspect.getFirstName());
			ps.setString(3, suspect.getLastName());
			ps.setString(4, suspect.getDateOfBirth());
			ps.setString(5, suspect.getGender());
			ps.setString(6, suspect.getAddress());
			ps.setLong(7, suspect.getContactInformation());
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " inserted Successfully !!!");
		} catch (SQLException e) {

			e.printStackTrace();
		}
    }
	
	// Method to add an incident to the database
	public void addIncident(Incident incident) throws DuplicateRecordException{
		try {
			con = DBConnUtil.getConnection();
			// Checking if the incident already exists
			ps= con.prepareStatement("select count(*) from incident where incidentid = ?");
	        ps.setInt(1, incident.getIncidentId());
	        rs = ps.executeQuery();
	        rs.next();
	        int count = rs.getInt(1);

	        if (count > 0) {
	            throw new DuplicateRecordException("Record already exists.");
	        }  
	        
	        // Inserting the incident record into the database
			ps = con.prepareStatement("insert into incident values(?,?,?,?,?,?,?,?)");
			ps.setInt(1, incident.getIncidentId());
			ps.setString(2, incident.getIncidentType());
			ps.setString(3, incident.getIncidentDate());
			ps.setString(4, incident.getLocation());
			ps.setString(5, incident.getDescription());
			ps.setString(6, incident.getStatus());
			ps.setInt(7, incident.getVictimId());
			ps.setInt(8, incident.getSuspectId());
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " row inserted Successfully !!!");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	// Method to add an case to the database
	public void addCase(Case cases)throws DuplicateRecordException {
		try {
			con = DBConnUtil.getConnection();
			// Checking if the incident already exists
			ps= con.prepareStatement("select count(*) from cases where caseid = ?");
	        ps.setInt(1, cases.getCaseId());
	        rs = ps.executeQuery();
	        rs.next();
	        int count = rs.getInt(1);

	        if (count > 0) {
	            throw new DuplicateRecordException("Record already exists.");
	        }  
	        
	        // Inserting the case record into the database
			ps = con.prepareStatement("insert into cases values(?,?,?,?)");
			ps.setInt(1, cases.getCaseId());
			ps.setInt(2, cases.getIncidentId());
			ps.setInt(3, cases.getVictimId());
			ps.setString(4, cases.getCaseDate());
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " row inserted Successfully !!!");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	// Method to get the status of an incident by its ID
	public void getIncidentStatus(int incidentId) {

		try {
			con = DBConnUtil.getConnection();
			stmt = con.createStatement();
			ps=con.prepareStatement("select status from incident where incidentId = ?");
			ps.setInt(1, incidentId);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("Your Complaint status: " + rs.getString(1));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}
	
	// Method to update the status of an incident by its ID
	public void updateIncidentStatus(String status, int incidentId)throws IncidentNumberNotFoundException {
		try {
			con = DBConnUtil.getConnection();
			ps = con.prepareStatement("update incident set status=? where incidentid=?");
			ps.setString(1, status);
			ps.setInt(2, incidentId);
			int noofrows = ps.executeUpdate();
			if (noofrows == 0) {
	            throw new IncidentNumberNotFoundException("ID not found.");
	        }
			System.out.println(noofrows + " row updated Successfully !!!");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	// Method to get incidents within a specific date range
	public List<Incident> getIncidentInDateRange(String startDate, String endDate) {
		List<Incident> IncidentList=new ArrayList<>();
		try {
			con = DBConnUtil.getConnection();
			stmt = con.createStatement();
			ps=con.prepareStatement("select * from incident where incidentDate between ? and ?");
			ps.setString(1, startDate);
			ps.setString(2, endDate);
			rs = ps.executeQuery();
			while (rs.next()) {
				int incidentId = rs.getInt("incidentId");
				String incidentType = rs.getString("incidentType");
				String incidentDate = rs.getString("incidentDate");
				String location =rs.getString("location");
				String description = rs.getString ("description");
				String status=rs.getString ("status");
				int victimId=rs.getInt("victimId");
				int suspectId=rs.getInt("suspectId");
                incident = new Incident(incidentId, incidentType, incidentDate, location, description, status, victimId, suspectId);
                IncidentList.add(incident);
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return IncidentList;
	}
	
	// Method to get incidents of a specific type
	public List<Incident> getIncidentType(String incidentType){
		List<Incident> IncidentList=new ArrayList<>();
		try {
			con = DBConnUtil.getConnection();
			stmt = con.createStatement();
			ps=con.prepareStatement("select * from incident where incidentType=?");
			ps.setString(1, incidentType);
			rs = ps.executeQuery();
			while (rs.next()) {
				int incidentId = rs.getInt("incidentId");
				incidentType = rs.getString("incidentType");
				String incidentDate = rs.getString("incidentDate");
				String location =rs.getString("location");
				String description = rs.getString ("description");
				String status=rs.getString ("status");
				int victimId=rs.getInt("victimId");
				int suspectId=rs.getInt("suspectId");
                incident = new Incident(incidentId, incidentType, incidentDate, location, description, status, victimId, suspectId);
                IncidentList.add(incident);
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return IncidentList;
	}
	
	// Method to generate an incident report by report ID
	public List<Report> generateIncidentReport(int reportId){
		List<Report> reportList=new ArrayList<>();
		try {
			con = DBConnUtil.getConnection();
			stmt = con.createStatement();
			ps=con.prepareStatement("select * from report where reportId=?");
			ps.setInt(1, reportId);
			rs = ps.executeQuery();
			while (rs.next()) {
				reportId = rs.getInt("reportId");
				int incidentId = rs.getInt("incidentId");
				int officerId = rs.getInt("officerId");
				String reportDate=rs.getString("reportDate");
				String reportDetails = rs.getString ("reportDetails");
				String status=rs.getString ("status");
                report = new Report(reportId, incidentId, officerId, reportDate, reportDetails, status);
                reportList.add(report);
			}
		} catch (SQLException e) {
				e.printStackTrace();
		}
		return reportList;
	}
	
	// Method to get case details by case ID
	public List<Case> getCaseByCaseId(int caseId) {
		List<Case> caseList=new ArrayList<>();
		try {
			con = DBConnUtil.getConnection();
			stmt = con.createStatement();
			ps=con.prepareStatement("select * from cases where caseId=?");
			ps.setInt(1, caseId);
			rs = ps.executeQuery();
			while (rs.next()) {
				caseId = rs.getInt("caseId");
				int incidentId = rs.getInt("incidentId");
				int victimId = rs.getInt("complainantId");
				String caseDate =rs.getString("caseDate");
				cases = new Case(caseId, incidentId, victimId, caseDate);
                caseList.add(cases);
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return caseList;
	}
	
	// Method to update case details by case ID
	public void updateCaseByCaseId(String caseDate, int caseId)throws IncidentNumberNotFoundException {
		try {
			con = DBConnUtil.getConnection();
			ps = con.prepareStatement("update cases set caseDate=? where caseid=?");
			ps.setString(1, caseDate);
			ps.setInt(2, caseId);
			int noofrows = ps.executeUpdate();
			if (noofrows == 0) {
	            throw new IncidentNumberNotFoundException("ID not found.");
	        }
			System.out.println(noofrows + " row updated Successfully !!!");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	// Method to get all case details
	public List<Case> getAllCaseDetails(Case cases) {
		List<Case> caseList=new ArrayList<>();
		try {
			con = DBConnUtil.getConnection();
			stmt = con.createStatement();
			ps=con.prepareStatement("select * from cases");
			rs = ps.executeQuery();
			while (rs.next()) {
				int caseId = rs.getInt("caseId");
				int incidentId = rs.getInt("incidentId");
				int victimId = rs.getInt("victimId");
				String caseDate =rs.getString("caseDate");
				cases = new Case(caseId, incidentId, victimId, caseDate);
                caseList.add(cases);
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return caseList;
	}
	
	// Method to update suspect details by suspect ID
	public void updateSuspectById(String contactInformation, int suspectId) throws IncidentNumberNotFoundException{
		try {
			con = DBConnUtil.getConnection();
			ps = con.prepareStatement("update suspect set contactInformation=? where suspectId=?");
			ps.setString(1, contactInformation);
			ps.setInt(2, suspectId);
			int noofrows = ps.executeUpdate();
			if (noofrows == 0) {
	            throw new IncidentNumberNotFoundException("ID not found.");
	        }
			System.out.println(noofrows + " row updated Successfully !!!");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	// Method to remove suspect details by suspect ID
	public void removeSuspectByCaseId(int suspectId) {
		try {
			con = DBConnUtil.getConnection();
			ps = con.prepareStatement("delete from suspect where suspectId=?");
			ps.setInt(1, suspectId);
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " row deleted Successfully !!!");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	// Method to update evidence details by evidence ID
	public void updateEvidenceByCaseId(String location, int evidenceId)throws IncidentNumberNotFoundException {
		try {
			con = DBConnUtil.getConnection();
			ps = con.prepareStatement("update suspect set locationfound=? where evidenceId=?");
			ps.setString(1, location);
			ps.setInt(2, evidenceId);
			int noofrows = ps.executeUpdate();
			if (noofrows == 0) {
	            throw new IncidentNumberNotFoundException("ID not found.");
	        }
			System.out.println(noofrows + " row updated Successfully !!!");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
