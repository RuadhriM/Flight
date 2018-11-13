//Class: Software Implementation - CSDF
//Instructor: Maria Boyle
//Description: EmployeeSerializerTester class
//Date: 9/11/2018
//Written by Ruadhri McConigley
package ie.lyit.testers;
import ie.lyit.flight.*;
import ie.lyit.serialize.*;

public class EmployeeSerializerTester {

	public static void main(String[] args) {
		EmployeeSerializer employeeSerializer = new EmployeeSerializer();

		employeeSerializer.deserializeEmployees();
		
	    // Create a Menu Object
		Menu menuObj = new Menu();
		
		do {
			// Call it's display() method
			menuObj.display();
			
			// Call it's readOption() method
			menuObj.readOption();
	
			// switch on the option and call the appropriate method
			switch(menuObj.getOption()){
			   case 1:employeeSerializer.add();break;
			   case 2:employeeSerializer.list();break;
			   case 3:employeeSerializer.view();break;
			   case 4:employeeSerializer.edit();break;
			   case 5:employeeSerializer.delete();break;
			   case 6:break;				
			   default:System.out.println("INVALID OPTION...");
			}
		}while(menuObj.getOption() != 6);
		
		employeeSerializer.serializeEmployees();
	}
}

