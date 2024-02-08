package com.hexaware.dao;
import com.hexaware.model.Inventory;
import com.hexaware.exception.DatabaseAccessException;
import java.util.SortedMap;

public interface InventoryInterface {
	SortedMap<Integer, Inventory> getAllInventory() throws DatabaseAccessException;

    Inventory getInventoryByProductId(int productId) throws DatabaseAccessException;

    void addInventory(Inventory inventory) throws DatabaseAccessException;

    void updateInventory(Inventory inventory) throws DatabaseAccessException;

    void removeInventoryByProductId(int productId) throws DatabaseAccessException;
    
    void updateInventoryOnOrder(int productId, int quantityToDecrement) throws DatabaseAccessException;
}

