package com.hexaware.dao;
import com.hexaware.model.OrderDetails;
import com.hexaware.model.Orders;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.hexaware.util.DBConnUtil;

public class OrderDetailsImplementation {
	Connection con;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;
	OrderDetails orderDetails;
	Orders order;
	
	public void addOrderDetails(OrderDetails orderDetails) {
		try {
			con = DBConnUtil.getCon();
			ps = con.prepareStatement("insert into orderDetails values(?,?,?,?)");
			ps.setInt(1, orderDetails.getOrderDetailId());
			ps.setInt(2, orderDetails.getorderId());
			ps.setInt(3, orderDetails.getProductId());
			ps.setInt(4, orderDetails.getQuantity());
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + "rows inserted Successfully !!!");
		} catch (SQLException e) {

			e.printStackTrace();
		}
    }
	
	public void calculateTotalAmount(int orderId, int quantity) {
		try {
			con = DBConnUtil.getCon();
			ps = con.prepareStatement("select p.price from orderdetails od, products p, orders o where o.orderid=?");
			ps.setInt(1, orderId);
			ps.setInt(2, quantity);
			rs = ps.executeQuery();
			while (rs.next()) {
				double price = rs.getDouble("price");
		        double totalAmount = price * quantity;
		        order.setTotalAmount(totalAmount);
			} 
		}catch (SQLException e) {

			e.printStackTrace();
		}
  }

/**
  * This is the method to show a record retrieved from the DB.
  * @param Nothing. 
  * @return Nothing.
  * @exception SQLException
  * @see Exception
  */
	public void updateOrderDetails(int orderId, int quantity) {
		try {
			con = DBConnUtil.getCon();
			ps = con.prepareStatement("update orderdetails set quantity = ? where orderId=?");
			ps.setInt(1, orderId);
			ps.setInt(1, quantity);
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " updated Successfully !!!");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void removeOrderDetails(int orderId) {
		try {
			con = DBConnUtil.getCon();
			ps = con.prepareStatement("delete from orderdetails where orderId=?");
			ps.setInt(1, orderId);
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " removed Successfully !!!");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
}
