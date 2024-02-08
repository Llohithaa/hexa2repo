package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.hexaware.entity.Evidence;
import com.hexaware.util.DBConnUtil;

public class EvidenceDao implements EvidenceDaoInterface{
	Connection con;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;
	Evidence evidence;

	/**
	 * This is the method to insert a record in the DB.
	 * 
	 * @param Customer Object.
	 * @return Nothing.
	 * @exception SQLException
	 * @see Exception
	 */
	
	public void addevidence(Evidence evidence) {
		try {
			con = DBConnUtil.getCon();
			ps = con.prepareStatement("insert into incident values(?,?,?,?)");
			ps.setInt(1, evidence.getEvidenceId());
			ps.setString(2, evidence.getDescription());
			ps.setString(3, evidence.getLocation());
			ps.setInt(4, evidence.getIncidentId());
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " inserted Successfully !!!");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	public void updateEvidence(int incidentId) {
		try {
			con = DBConnUtil.getCon();
			ps = con.prepareStatement("select status from incident where incidentid=?");
			ps.setInt(1, incidentId);
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " fetched Successfully !!!");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
}