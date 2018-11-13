//Class: Software Implementation - CSDF
//Instructor: Maria Boyle
//Description: EmployeeSerializer class
//Date: 9/11/2018
//Written by Ruadhri McConigley
package ie.lyit.serialize;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import ie.lyit.flight.*;

public class EmployeeSerializer {
	
	ArrayList<Employee> employees;
	
	//Create a name for the file to be serialized and deserialized to and from
	private final String FILENAME = "employees.ser";
	
	Path p = Paths.get(FILENAME);
	
	public EmployeeSerializer() {
	//Create ArrayList of Employees
	employees = new ArrayList<Employee>();
	}
	
	public void saveNumber() {
		if(employees.size() > 0)
		{
			employees.get(employees.size() - 1).saveNumber();
		}
	}
	
	public void restoreNumber() {
		if(employees.size() > 0)
		{
			employees.get(employees.size() - 1).setNumber();
		}
	}
	
	public void serializeEmployees()
	{
		try 
		{
			FileOutputStream fileStream = new FileOutputStream(FILENAME);
			
			ObjectOutputStream os = new ObjectOutputStream(fileStream);
			
			os.writeObject(employees);
			
			saveNumber();
			
			os.close();
		}
		catch(FileNotFoundException fNFE)
		{
			System.out.print("Cannot create a file to store Employees");
		}
		catch(IOException ioE)
		{
			System.out.println(ioE.getMessage());
		}
	}
	
	public void deserializeEmployees()
	{
		try 
		{
			if(Files.exists(p))
			{
				FileInputStream fileStream = new FileInputStream(FILENAME);
				
				ObjectInputStream is = new ObjectInputStream(fileStream);
			
				employees = (ArrayList<Employee>)is.readObject();
			
				restoreNumber();
				
				is.close();
			}
		}
		catch(FileNotFoundException fNFE)
		{
			System.out.print("Cannot create a file to store Employees");
		}
		catch(IOException ioE)
		{
			System.out.println(ioE.getMessage());
		}
		catch(ClassNotFoundException e)
		{
			System.out.print(e.getMessage());
		}
	}
	
	//Create a Method to Populate the ArrayList
	public void add()
	{
		Employee employee = new Employee();
		
		employee.read();
		
		employees.add(employee);
	}
	
	//Create a Method to View a Specific Employee
	public Employee view() {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter Employee Number: ");
		int num = keyboard.nextInt();
		
		for(Employee emp: employees) {
			if(emp.getNumber() == num) {
				System.out.println(num);
				return emp;
			}
		}
		return null;
	}
	
	//Create a Method to List all Employees
	public void list()
	{
		for(Employee emp: employees)
		{
			System.out.println(emp);
		}
	}
	
	//Create a Method to Edit an Employee
	public void edit() {
		Employee emp = view();
		
		if(emp != null) {
			int index = employees.indexOf(emp);
			emp.read();
			employees.set(index, emp);
		}
	}
	
	public void delete() {
		Employee emp = view();
		
		if(emp != null)
			employees.remove(emp);
	}
}
