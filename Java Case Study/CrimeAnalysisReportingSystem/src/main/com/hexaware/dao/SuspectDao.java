package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.hexaware.entity.Suspect;

import com.hexaware.util.DBConnUtil;

public class SuspectDao implements SuspectDaoInterface {
	Connection con;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;
	Suspect suspect;

	/**
	 * This is the method to insert a record in the DB.
	 * 
	 * @param Customer Object.
	 * @return Nothing.
	 * @exception SQLException
	 * @see Exception
	 */
	
	public void addSuspect(Suspect suspect) {
		try {
			con = DBConnUtil.getCon();
			ps = con.prepareStatement("insert into suspect values(?,?,?,?,?,?)");
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
	
	public void updateSuspect(long contactInformation, String dateOfBirth, int suspectId) {
		try {
			con = DBConnUtil.getCon();
			ps = con.prepareStatement("update suspect set contactInformation=?, dateOfBirth=? where suspectId=?");
			ps.setLong(1, contactInformation);
			ps.setString(2, dateOfBirth);
			ps.setInt(3, suspectId);
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " updated Successfully !!!");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	public void removeSuspect(int suspectId) {
		try {
			con = DBConnUtil.getCon();
			ps = con.prepareStatement("delete from suspect where suspectId=?");
			ps.setInt(1, suspectId);
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " deleted Successfully !!!");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
