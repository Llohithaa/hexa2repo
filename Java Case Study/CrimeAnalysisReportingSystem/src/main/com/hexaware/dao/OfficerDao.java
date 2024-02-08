package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hexaware.entity.Officer;
import com.hexaware.util.DBConnUtil;

public class OfficerDao implements OfficerDaoInterface{
	Connection con;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;
	Officer officer;

	/**
	 * This is the method to insert a record in the DB.
	 * 
	 * @param Customer Object.
	 * @return Nothing.
	 * @exception SQLException
	 * @see Exception
	 */
	
	public void addOfficer(Officer officer) {
		try {
			con = DBConnUtil.getCon();
			ps = con.prepareStatement("insert into officer values(?,?,?,?,?,?,?,?)");
			ps.setInt(1, officer.getOfficerId());
			ps.setString(2, officer.getFirstName());
			ps.setString(3, officer.getLastName());
			ps.setString(4, officer.getBadgeNumber());
			ps.setString(5, officer.getRank());
			ps.setString(6, officer.getAddress());
			ps.setLong(7, officer.getContactInformation());
			ps.setLong(8, officer.getAgencyId());
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " inserted Successfully !!!");
		} catch (SQLException e) {

			e.printStackTrace();
		}
    }
	
	public void updateOfficer(long contactInformation, int officerId) {
		try {
			con = DBConnUtil.getCon();
			ps = con.prepareStatement("update officer set contactInformation=? where officerId=?");
			ps.setLong(1, contactInformation);
			ps.setInt(2, officerId);
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " updated Successfully !!!");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	public void removeOfficer(int officerId) {
		try {
			con = DBConnUtil.getCon();
			ps = con.prepareStatement("delete from officer where officerId=?");
			ps.setInt(1, officerId);
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " deleted Successfully !!!");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}


}
