package com.hexaware.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.hexaware.model.Products;
import com.hexaware.util.DBConnUtil;

public class ProductImplementation{
	Connection con;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;
	Products product;
	
	public void addProduct(Products product) {
		try {
			con = DBConnUtil.getCon();
			ps = con.prepareStatement("insert into product values(?,?,?,?)");
			ps.setInt(1, product.getProductId());
			ps.setString(2, product.getProductName());
			ps.setString(3, product.getDescription());
			ps.setDouble(4, product.getPrice());
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " inserted Successfully !!!");
		} catch (SQLException e) {

			e.printStackTrace();
		}
  }

	public List<Products> getProductDetails(int productId){
		List<Products> productDetailList=new ArrayList<>();
		try {
			con = DBConnUtil.getCon();
			ps=con.prepareStatement("select * from products");
			rs = ps.executeQuery();
			while(rs.next()) {
				productId = rs.getInt("productId");
				String productName = rs.getString("productName");
				String description = rs.getString("description");
                double price = rs.getDouble("price");
                product = new Products(productId, productName, description, price);
                productDetailList.add(product);

			}
				
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return productDetailList;
	}

	public void updateProduct(int productId, double price) {
		try {
			con = DBConnUtil.getCon();
			ps = con.prepareStatement("update products set price = ? where productId=?");
            ps.setDouble(1, price);
            ps.setInt(2, productId);
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " updated Successfully !!!");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void removeProduct(int productId) {
		try {
			con = DBConnUtil.getCon();
			ps = con.prepareStatement("delete from products where productId=?");
			ps.setInt(1, productId);
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " removed Successfully !!!");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	public List<Products> allProductDetails(Products product){
		List<Products> productDetailList=new ArrayList<>();
		try {
			con = DBConnUtil.getCon();
			ps=con.prepareStatement("select * from products");
			rs = ps.executeQuery();
			while(rs.next()) {
				int productId = rs.getInt("productId");
				String productName = rs.getString("productName");
				String description = rs.getString("description");
                double price = rs.getDouble("price");
                product = new Products(productId, productName, description, price);
                productDetailList.add(product);

			}
				
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return productDetailList;
	}
}

