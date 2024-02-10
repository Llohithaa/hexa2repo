package com.hexaware.main;
import java.util.Scanner;
import com.hexaware.controller.AdminController;
import com.hexaware.controller.UserController;
public class MainModule {
	
	 /**
     * The main method is the starting point of the application.
     * It displays a welcome message and presents a menu to select user type.
     * It then routes the user to appropriate functionalities based on their selection.
     * @param args The command-line arguments passed to the program.
     * @throws Exception If any error occurs during program execution.
     */
	
	public static void main(String[] args) throws Exception{
		UserController usercontroller = new UserController();
        AdminController admincontroller = new AdminController();
        String a;
		Scanner sc= new Scanner(System.in);
        System.out.println("\t\t----------Welcome to the Crime Analysis and Reporting System----------");
        Thread.sleep(1000);
        do {
        System.out.println("\t\t\t\t-----Select the User Type-----");
        Thread.sleep(1000);
        System.out.println("1.User\n2.Admin");
        int userInput = sc.nextInt();
        switch (userInput) {
        case 1:{ //User functionalities
        	System.out.println("\t\t-----Welcome User! You have access to regular user features-----");
        	System.out.println("1.Register Complaint\n2.Get Complaint Status");
        	int options=sc.nextInt();
        	switch(options) {
        	case 1:usercontroller.createCase();
        	break;
        	case 2:usercontroller.complaintStatus();
        	}
        	break;
        }
   
        case 2:{ // Admin functionalities
        	System.out.println("\t\t-----Welcome Admin! You have access to administrative features-----");
        	System.out.println("1.Incident Records\n2.Case Records\n3.Other Records");
        	int options=sc.nextInt();
        	switch(options) {
        	case 1:{
        		System.out.println("1.Update Incident Status\n2.Get Incident By Date Range\n3.Get Incident by Type\n4.Get Incident Report");
        		int choice=sc.nextInt();
            	switch(choice){
            	case 1:admincontroller.updateIncidentStatus();
            	break;
            	case 2:admincontroller.getIncidentInDateRange();
            	break;
            	case 3:admincontroller.getIncidentByType();
            	break;
            	case 4:admincontroller.getIncidentReport();
            	}
            	break;
        	}
        	case 2:{
        		System.out.println("1.Register Complaint\n2.Get Case Details\n3.Update Case Details\n4.Get All Cases");
        		int choice=sc.nextInt();
            	switch(choice) {
            	case 1:usercontroller.createCase();
            	break;
            	case 2:admincontroller.getCaseDetails();
            	break;   
            	case 3:admincontroller.updateCaseDetails();
            	break;
            	case 4:admincontroller.getAllCases();
            	}
            	break;
        	}
        	case 3:{
        		System.out.println("1.Updated Suspect Details\n3.Update Evidence");
        		int choice=sc.nextInt();
        		switch(choice) {
        		case 1:admincontroller.updateSuspectDetails();
        		break;
        		case 2:admincontroller.updateEvidence();
        		}
        		break;
        	}
        	}
        	break;
        }
        }
        System.out.println("Do you want to continue?Y/N");
        a=sc.next();
	}while(a.equals("Y") || a.equals("y"));
        // Display exit message
        System.out.println("Thanks for using our system!!!");
        System.exit(0);
	}
}
        
       
