package com.hexaware.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.model.Orders;
import com.hexaware.util.DBConnUtil;

public class OrderImplementation {
	Connection con;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;
	Orders order;

	/**
	 * This is the method to insert a record in the DB.
	 * 
	 * @param Employee Object.
	 * @return Nothing.
	 * @exception SQLException
	 * @see Exception
	 */
	
	public void placeAnOrder(int customerId) {
		try {
			con = DBConnUtil.getCon();
			ps = con.prepareStatement("insert into product values(?,?,?,?,?)");
			ps.setInt(1, order.getOrderId());
			ps.setInt(2, customerId);
			ps.setString(3, order.getOrderDate());
			ps.setDouble(4, order.setTotalAmount());
			ps.setString(5, order.getStatus());
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + "rows inserted Successfully !!!");
		} catch (SQLException e) {

			e.printStackTrace();
		}
    }
	
	public List<Orders> getOrders(int orderId) {
		List<Orders> OrdersList=new ArrayList<>();
		try {
			con = DBConnUtil.getCon();
			ps=con.prepareStatement("select * from orders where orderId=?");
			ps.setInt(1, orderId);
			rs = ps.executeQuery();
			while (rs.next()) {
				orderId = rs.getInt("orderId");
				int customerId = rs.getInt("customerId");
				String orderDate = rs.getString("orderDate");
				double totalAmount=rs.getDouble("totalAmount");
				String status = rs.getString("status");
                order = new Orders(orderId, customerId, orderDate, totalAmount, status);
                OrdersList.add(order);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return OrdersList;
	}

	public void updateOrder(int orderId) {
		try {
			con = DBConnUtil.getCon();
			ps = con.prepareStatement("update orders set status = 'Delivered' where orderId=?");
            ps.setInt(1, orderId);
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " updated Successfully !!!");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void removeOrder(int orderId) {
		try {
			con = DBConnUtil.getCon();
			ps = con.prepareStatement("delete from orders where orderId=?");
			ps.setInt(1, orderId);
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " removed Successfully !!!");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	public void orderStatus(int orderId) {
		try {
			con = DBConnUtil.getCon();
			ps=con.prepareStatement("select status from orders where orderId=?");
			ps.setInt(1, orderId);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("__________________");
				System.out.println("Status: " + rs.getDouble(4));
				System.out.println("___________________");

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
}

