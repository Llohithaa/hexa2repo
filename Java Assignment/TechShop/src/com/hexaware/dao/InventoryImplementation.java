package com.hexaware.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hexaware.model.Inventory;
import com.hexaware.util.DBConnUtil;

public class InventoryImplementation {
	Connection con;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;
	Inventory inventory;

	/**
	 * This is the method to insert a record in the DB.
	 * 
	 * @param Employee Object.
	 * @return Nothing.
	 * @exception SQLException
	 * @see Exception
	 */
	
	public void addProductInInventory(Inventory inventory) {
		try {
			con = DBConnUtil.getCon();
			ps = con.prepareStatement("insert into inventory values(?,?,?,?)");
			ps.setInt(1, inventory.getInventoryId());
			ps.setInt(2, inventory.getProductId());
			ps.setInt(3, inventory.getQuantityInStock());
			ps.setString(4, inventory.getLastStockUpdate());
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " inserted Successfully !!!");
		} catch (SQLException e) {

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
	public void getInventoryProduct(int productId) {
		try {
			con = DBConnUtil.getCon();
			ps=con.prepareStatement("select * from inventory where productId = ?");
			ps.setInt(1, productId);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("__________________");
				System.out.println("ProductId " + rs.getInt(1));
				System.out.println("InventoryId " + rs.getInt(2));
				System.out.println("QuantityInStock " + rs.getInt(3));
				System.out.println("LastStockUpdate " + rs.getString(4));
				System.out.println("___________________");

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void updateInventoryProduct(int productId) {
		try {
			con = DBConnUtil.getCon();
			ps = con.prepareStatement("update inventory set quantityInStock = quantityInStock - (select quantity from orderdetails where productId=?) where productId=?");
            ps.setInt(1, productId);
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " updated Successfully !!!");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void removeInventoryProduct(int productId) {
		try {
			con = DBConnUtil.getCon();
			ps = con.prepareStatement("delete from inventory where productId=?");
			ps.setInt(1, productId);
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " removed Successfully !!!");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
}
