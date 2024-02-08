package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.exception.InvalidDataException;
import com.hexaware.model.Customers;
import com.hexaware.util.DBConnUtil;


public class CustomerImplementation implements CustomerInterface{
	Connection con;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;
	Customers customer;

	/**
	 * This is the method to insert a record in the DB.
	 * 
	 * @param Customer Object.
	 * @return Nothing.
	 * @exception SQLException
	 * @see Exception
	 */
	
	public void addCustomer(Customers customer) {
		try {
			con = DBConnUtil.getCon();
			ps = con.prepareStatement("insert into customers values(?,?,?,?,?,?)");
			ps.setInt(1, customer.getCustomerId());
			ps.setString(2, customer.getFirstName());
			ps.setString(3, customer.getLastName());
			ps.setString(4, customer.getEmail());
			ps.setLong(5, customer.getPhone());
			ps.setString(6, customer.getAddress());
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " inserted Successfully !!!");
		} catch (SQLException e) {

			e.printStackTrace();
		}
    }
	
	public List<Customers> getCustomers(int customerId) {
		List<Customers> customerDetailList=new ArrayList<>();
		if (customerId <= 0) {
            throw new InvalidDataException("Invalid customerId: " + customerId);
        }
		try {
			con = DBConnUtil.getCon();
			stmt = con.createStatement();
			ps=con.prepareStatement("select * from customers where customerid = ?");
			ps.setInt(1, customerId);
			try (rs = ps.executeQuery()){
		    if (rs.isBeforeFirst()) {
			while (rs.next()) {
				customerId = rs.getInt("customerId");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
                String email = rs.getString("email");
                long phone = rs.getLong("phone");
                String address = rs.getString("address");
                
                if (firstName == null || lastName == null || email == null || address == null) {
                    throw new CustomerNotFullException("Customer details are not complete");
                }
                
                customer = new Customers(customerId, firstName, lastName, email, phone, address);
                customerDetailList.add(customer);
				}
		    }
		}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return customerDetailList;
	}	
	

	public void updateCustomer(int customerId, long phone) {
		try {
			con = DBConnUtil.getCon();
			ps = con.prepareStatement("update customers set phone=? where customerid=?");
			ps.setLong(1, phone);
			ps.setInt(2, customerId);
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " updated Successfully !!!");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void deleteCustomer(int customerId) {
		try {
			con = DBConnUtil.getCon();
			ps = con.prepareStatement("delete from Customer where CustomerId=?");
			ps.setInt(1, customerId);
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " deleted Successfully !!!");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
