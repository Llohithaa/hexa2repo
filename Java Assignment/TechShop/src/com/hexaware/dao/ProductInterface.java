package com.hexaware.dao;
import com.hexaware.model.Products;
import java.util.List;
import com.hexaware.exception.DatabaseAccessException;

public interface ProductInterface {
	List<Products> getAllProducts();

    Products getProductById(int productId);

    void addProduct(Products product);

    void updateProduct(Products product);

    void removeProduct(Products product);
    
    List<Products> searchProducts(String searchTerm) throws DatabaseAccessException;
}
