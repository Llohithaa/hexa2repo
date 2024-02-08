package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.hexaware.entity.Victim;
import com.hexaware.util.DBConnUtil;

public class VictimDao implements VictimDaoInterface {
	Connection con;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;
	Victim victim;

	/**
	 * This is the method to insert a record in the DB.
	 * 
	 * @param Customer Object.
	 * @return Nothing.
	 * @exception SQLException
	 * @see Exception
	 */
	
	public void addVictim(Victim victim) {
		try {
			con = DBConnUtil.getCon();
			ps = con.prepareStatement("insert into victim values(?,?,?,?,?,?)");
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

}
