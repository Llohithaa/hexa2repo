package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hexaware.entity.Incident;
import com.hexaware.entity.Report;
import com.hexaware.util.DBConnUtil;

public class ReportDao implements ReportDaoInterface {
	Connection con;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;
	Incident incident;
	Report report;

	/**
	 * This is the method to insert a record in the DB.
	 * 
	 * @param Customer Object.
	 * @return Nothing.
	 * @exception SQLException
	 * @see Exception
	 */
	
	public void generateIncidentReport(int incidentId){
		
		try {
			con = DBConnUtil.getCon();
			stmt = con.createStatement();
			ps=con.prepareStatement("select * from report");
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("__________________");
				System.out.println("reportId " + rs.getInt(1));
				System.out.println("incidentId " + rs.getInt(2));
				System.out.println("officerId " + rs.getInt(3));
				System.out.println("reportDate " + rs.getString(4));
				System.out.println("reportDetails " + rs.getString(5));
				System.out.println("status " + rs.getString(6));
				System.out.println("___________________");
			}
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}
	
	public void updateReportStatus(int incidentId) {
		String location;
		try {
			con = DBConnUtil.getCon();
			ps = con.prepareStatement("update evidence set location=? where incidentid=?");
			if (incident.getStatus().equals("closed")) {
	             location = "finalized";
	        } else {
	        	 location = "draft";
	        }
			ps.setString(1, location);
			ps.setInt(2, incidentId);
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " updated Successfully !!!");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
