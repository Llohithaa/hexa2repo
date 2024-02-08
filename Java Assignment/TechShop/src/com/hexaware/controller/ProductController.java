package com.hexaware.controller;
import com.hexaware.model.Products;
import com.hexaware.dao.ProductImplementation;
import java.util.List;
import java.util.Scanner;
public class ProductController {
	Products product;
	ProductImplementation productDao=new ProductImplementation();
	Products prd = new Products();
	Scanner sc=new Scanner(System.in);
	
	public void displayAddedProduct() {
		System.out.println("Enter ProductId:");
		int productId=sc.nextInt();
		System.out.println("Enter ProductName:");
		String productName=sc.next();
		System.out.println("Enter Product Description:");
		String description=sc.next();
		System.out.println("Enter Product Price:");
		double price=sc.nextDouble();
		product=new Products(productId, productName, description, price);
		productDao.addProduct(product);
		System.out.println("Prodcut Added Successfully !!!");
	}
	
	public void displayProductById() {
		System.out.println("Enter ProductId:");
		int productId=sc.nextInt();
		List<Products> products = productDao.getProductDetails(productId);
        System.out.println("Customer Details: ");
        for (Products product : products) {
            System.out.println(product);
        }
	}
		
	public void displayUpdatedProduct() {
		System.out.println("Enter ProductId:");
		int productId=sc.nextInt();
		System.out.println("Enter Product Price:");
		double price=sc.nextDouble();
		productDao.updateProduct(productId, price);
	}
 
	public void displayDeletedProduct() {
		System.out.println("Enter ProductId:");
		int productId=sc.nextInt();
		productDao.removeProduct(productId);
	}
	
	public void displayAllProductDetails() {
		List<Products> products = productDao.allProductDetails(product);
        System.out.println("Customer Details: ");
        for (Products product : products) {
            System.out.println(product);
        }
	}
	
}
