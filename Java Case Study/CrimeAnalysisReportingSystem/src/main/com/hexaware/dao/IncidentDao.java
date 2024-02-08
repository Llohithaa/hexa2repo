package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.hexaware.entity.Incident;
import com.hexaware.util.DBConnUtil;

public class IncidentDao implements IncidentDaoInterface {
	Connection con;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;
	Incident incident;

	/**
	 * This is the method to insert a record in the DB.
	 * 
	 * @param Customer Object.
	 * @return Nothing.
	 * @exception SQLException
	 * @see Exception
	 */
	
	public void addIncident(Incident incident) {
		try {
			con = DBConnUtil.getCon();
			ps = con.prepareStatement("insert into incident values(?,?,?,?,?,?)");
			ps.setInt(1, incident.getIncidentId());
			ps.setString(2, incident.getIncidentType());
			ps.setString(3, incident.getIncidentDate());
			ps.setString(4, incident.getLocation());
			ps.setString(5, incident.getDescription());
			ps.setString(6, incident.getStatus());
			ps.setInt(7, incident.getVictimId());
			ps.setInt(8, incident.getSuspectId());
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " inserted Successfully !!!");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	public void updateIncidentStatus(String status, int incidentId) {
		try {
			con = DBConnUtil.getCon();
			ps = con.prepareStatement("update incident set status=? where incidentid=?");
			ps.setString(1, status);
			ps.setInt(2, incidentId);
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " updated Successfully !!!");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	public void getIncidentDetails(int incidentId) {

		try {
			con = DBConnUtil.getCon();
			stmt = con.createStatement();
			ps=con.prepareStatement("select * from incident where incidentId = ?");
			ps.setInt(1, incidentId);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("__________________");
				System.out.println("incidentId " + rs.getInt(1));
				System.out.println("incidentType " + rs.getString(2));
				System.out.println("incidentDate " + rs.getString(3));
				System.out.println("location " + rs.getString(4));
				System.out.println("description " + rs.getString(5));
				System.out.println("status " + rs.getString(6));
				System.out.println("victimId " + rs.getInt(7));
				System.out.println("suspectId " + rs.getInt(8));
				System.out.println("___________________");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}
	
	public void getIncidentInDateRange(String startDate, String endDate) {

		try {
			con = DBConnUtil.getCon();
			stmt = con.createStatement();
			ps=con.prepareStatement("select * from incident where incidentDate between ? and ?");
			ps.setString(1, startDate);
			ps.setString(2, endDate);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("__________________");
				System.out.println("incidentId " + rs.getInt(1));
				System.out.println("incidentType " + rs.getString(2));
				System.out.println("incidentDate " + rs.getString(3));
				System.out.println("location " + rs.getString(4));
				System.out.println("description " + rs.getString(5));
				System.out.println("status " + rs.getString(6));
				System.out.println("victimId " + rs.getInt(7));
				System.out.println("suspectId " + rs.getInt(8));
				System.out.println("___________________");
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	public void getAllIncident(Incident incident){
		
		try {
			con = DBConnUtil.getCon();
			stmt = con.createStatement();
			ps=con.prepareStatement("select * from incident");
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("__________________");
				System.out.println("incidentId " + rs.getInt(1));
				System.out.println("incidentType " + rs.getString(2));
				System.out.println("incidentDate " + rs.getString(3));
				System.out.println("location " + rs.getString(4));
				System.out.println("description " + rs.getString(5));
				System.out.println("status " + rs.getString(6));
				System.out.println("victimId " + rs.getInt(7));
				System.out.println("suspectId " + rs.getInt(8));
				System.out.println("___________________");
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}
	
	public void getIncidentStatus(int incidentId) {

		try {
			con = DBConnUtil.getCon();
			stmt = con.createStatement();
			ps=con.prepareStatement("select * from incident where incidentId = ?");
			ps.setInt(1, incidentId);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("__________________");
				System.out.println("Complaint status " + rs.getString(6));
				System.out.println("___________________");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}
	
}

