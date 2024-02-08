package com.hexaware.main;
import java.util.Scanner;

import com.hexaware.controller.IncidentController;
import com.hexaware.controller.OfficerController;
//import com.hexaware.controller.LawEnforcementAgenciesController;
import com.hexaware.controller.ReportController;
import com.hexaware.controller.SuspectController;
import com.hexaware.controller.VictimController;

public class MainModule {
	public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        VictimController vc= new VictimController();
        SuspectController sc=new SuspectController();
        IncidentController ic=new IncidentController();
        ReportController rc=new ReportController();
        OfficerController oc=new OfficerController();
        String a;
        System.out.println("\t\tWelcome to the Crime Analysis and Reporting System");
        Thread.sleep(1000);
        System.out.println("\tSelect the User Type");
        Thread.sleep(1000);
        System.out.println("1.Victim\n2.Law Agency");
        int userInput = scanner.nextInt();
        do {
        switch (userInput) {
        case 1:{
        	System.out.println("1.Register Complaint\n2.Know the Status");
        	int options=scanner.nextInt();
        	switch(options) {
        	case 1:{
        		vc.victimDetails();
        		Thread.sleep(1000);
        		sc.suspectDetails();
        		Thread.sleep(1000);
        		ic.incidentDetails();
        		break;
        	}
        	case 2:{
        		ic.displayIncidentStatus();
        		break;
        	}
        	}
        	break;
        }
        case 2:{
        	System.out.println("1.Register Complaint\n2.Get Incident Details\n3.Update Details");
        	int options=scanner.nextInt();
        	switch(options) {
        	case 1:{
        		vc.victimDetails();
        		Thread.sleep(1000);
        		sc.suspectDetails();
        		Thread.sleep(1000);
        		ic.incidentDetails();
        		break;
        	}
        	case 2:{
        		System.out.println("1.displayIncidentDetails\n2.displayIncidentByDateRange\n3.displayAllIncident\n4.displayIncidentReport");
        		int choice=scanner.nextInt();
            	switch(choice) {
            	case 1: ic.displayIncidentDetails();
            	break;
            	case 2: ic.displayIncidentByDateRange();
            	break;
            	case 3: ic.displayAllIncident();
            	break;
            	case 4: rc.displayIncidentReport();
        		break;
            	}
            	break;
        	}
        	case 3:{
        		System.out.println("1.updateComplaintStatus\n2.updatedSuspectDetails\n3.removeSuspectDetails\n4.updatedOfficerDetails\5.removedOfficerDetails");
        		int choice=scanner.nextInt();
        		switch(choice) {
        		case 1: ic.updateComplaintStatus();
        		break;
        		case 2:sc.updatedSuspectDetails();
        		break;
        		case 3: sc.removeSuspectDetails();
        		break;
        		case 4:oc.updatedOfficerDetails();
        		break;
        		case 5:oc.removedOfficerDetails();
        		break;
        		}
        	}
        	}
        	break;
        }
        }
        System.out.println("Do you want to continue?Y/N");
        a=scanner.next();
	}while(a.equals("Y") || a.equals("y"));
        System.out.println("Thanks for using our system!!!");
	}
}
        
       
