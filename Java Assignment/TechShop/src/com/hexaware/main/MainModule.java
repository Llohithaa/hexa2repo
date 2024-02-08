package com.hexaware.main;
import com.hexaware.controller.CustomerController;
import com.hexaware.controller.InventoryController;
import com.hexaware.controller.OrderController;
import com.hexaware.controller.OrderDetailController;
import com.hexaware.controller.ProductController;
import java.util.Scanner;
public class MainModule {
	public static void main(String[] args) throws Exception{
		Scanner userInput = new Scanner(System.in);
        System.out.println("________________Welcome to TechShop________________");
        String a;
        do {
        Thread.sleep(1000);
        System.out.println("1.New Customer\n2.Existing Customer\n3.Administrator");
        int choice = userInput.nextInt();
        Thread.sleep(1000);
        CustomerController c1 = new CustomerController();
        ProductController p1 = new ProductController();
        OrderController o1=new OrderController();
        OrderDetailController od1= new OrderDetailController();
        InventoryController i1= new InventoryController();
        switch(choice){
        	case 1:{
        		c1.createNewCustomer();
        		c1.getExistingCustomer();
        		break;
        	}
        	case 2:{
        		c1.getExistingCustomer();
        		break;
        	}
        	case 3: {
        		c1.displayCustomer();
        	    break;
        	}
        	case 4:{
        		System.out.println("1.Product\n2.Order\n3.OrderDetails\n4.Inventory");
        		int option=userInput.nextInt();
        		switch(option) {
        		case 1:{
        			System.out.println("1.Add Product\n2.Update Product\n3.Delete Product\n4.View Product");
        			int list=userInput.nextInt();
            		switch(list) {
            		case 1:p1.displayAddedProduct();
            		break;
            		case 2:p1.displayUpdatedProduct();
            		break;
            		case 3:p1.displayDeletedProduct();
            		break;
            		case 4:p1.displayProductById();
            		break;
            		}
        			break;
        		}
        		case 2:{
        			System.out.println("1.Add Order\n2.Update Order\n3.Delete Order\n4.View Order");
        			int list=userInput.nextInt();
            		switch(list) {
            		case 1:o1.displayAddedOrder(); 
            		break;
            		case 2:o1.displayUpdateOrder();
            		break;
            		case 3:o1.displayDeletedOrder();
            		break;
            		case 4:o1.displayGetOrder();
            		break;
            		}
        			break;
        		}
        		case 3:{
        			System.out.println("1.Add OrderDetails\n2.Update OrderDetails\n3.Delete OrderDetails");
        			int list=userInput.nextInt();
            		switch(list) {
            		case 1:od1.displayAddOrderDetails();
            		break;
            		case 2:od1.displayUpdatedOrderDetails();
            		break;
            		case 3:od1.displayDeletedOrderDetails();
            		break;
            		}
        			break;
        		}
        		case 4:{
        			System.out.println("1.Update Inventory\n2.Delete Inventory\\n3.Add Inventory\n4.View Inventory");
        			int list=userInput.nextInt();
            		switch(list) {
            		case 1:i1.displayUpdatedInventory();
            		break;
            		case 2:i1.displayDeletedInventory();
            		break;
            		case 3:i1.displayAddInventory();
            		break;
            		case 4:i1.displayInventory();
            		break;
            		}
        			break;
        		}
        		}
        		break;
        	}
        		
        	}
        System.out.println("Do you want to continue? Y/N");
        a=userInput.next();
        }while(a.equals("Y")|| a.equals("y"));
        System.out.println("Thankyou for using Techshop...  Visit Again...");
    }
}
