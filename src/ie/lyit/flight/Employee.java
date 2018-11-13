//Class: Software Implementation - CSDF
//Instructor: Maria Boyle
//Description: Employee class
//Date: 9/11/2018
//Written by Ruadhri McConigley
package ie.lyit.flight;

import java.io.Serializable;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Employee extends Person implements Payable, Serializable {
    private Date startDate;		
    private double salary;
    private int number;

	private static int nextNumber = 1000;   

	private final double MAX_SALARY = 150000.00;
	
    public Employee(){
    	super();
    	startDate=new Date();
 		salary=0.0;
 		number=nextNumber++;
 		this.number = nextNumber;
    }

    public Employee(String t, String fN, String sn, 
    		        int d, int m, int y,
    		        Date startDate, double salary){
	   super(t, fN, sn, d, m, y);
	   this.startDate=startDate;
	   this.salary=salary;
	   number = nextNumber++;	
	   this.number = nextNumber;
	}
    
    public void saveNumber()
    {
    	number = nextNumber;
    }
    
    public void setNumber()
    {
    	nextNumber = number;
    }

	@Override
    public String toString(){
		return number + " " + super.toString() + " €" + salary;
	}

	@Override
	public boolean equals(Object obj){
		Employee eObject;
		if (obj instanceof Employee)
		   eObject = (Employee)obj;
		else
		   return false;
		   
	    return(this.number==eObject.number);
	}

	public void setStartDate(Date startDate){
		this.startDate=startDate;
	}
	public Date getStartDate(){
		return startDate;
	}	
	public void setSalary(int salary){
		this.salary=salary;
	}
	public double getSalary(){
		return salary;
	}
	public int getNumber(){
		return number;
	}	
	public double calculateWage(double taxPercentage){
		double wage=salary/12;
		wage -= (wage * (taxPercentage/100));
		return wage;
	}

	public double incrementSalary(double incrementAmount) {

		salary += incrementAmount;
		
		if(salary > MAX_SALARY)
			salary = MAX_SALARY;
		
		return salary;
	}
	
	public void read(){
	      JTextField empNo = new JTextField();
	      empNo.setText("" + this.getNumber());
	      JTextField title = new JTextField();
	      JTextField fn = new JTextField();
	      JTextField sn = new JTextField();
	      JTextField d = new JTextField();
	      JTextField m = new JTextField();
	      JTextField y = new JTextField();
	      JTextField sd = new JTextField();
	      JTextField sm = new JTextField();
	      JTextField sy = new JTextField();
	      JTextField salary = new JTextField();

	      Object[] message = {
	          "Employee Number:", empNo,
	          "Title:", title,
	          "First Name:", fn,
	          "Surname:", sn,
	          "Date Of Birth: \nDay:", d,
	          "Month:", m,
	          "Year:", y,
	          "Start Date: \nDay:", sd,
	          "Month:", sm,
	          "Year:", sy,
	          "Salary:", salary
	      };

	      int option = JOptionPane.showConfirmDialog(null, message, "Enter Employee Details:", JOptionPane.OK_CANCEL_OPTION);

	      if (option == JOptionPane.OK_OPTION){
	          this.name = new Name(title.getText(), fn.getText(), sn.getText());
	          this.dateOfBirth = new Date(Integer.valueOf(d.getText()), Integer.valueOf(m.getText()), Integer.valueOf(y.getText()));
	          this.startDate = new Date(Integer.valueOf(sd.getText()), Integer.valueOf(sm.getText()), Integer.valueOf(sy.getText()));
	          this.salary = Double.valueOf(salary.getText());
	      }   
	}
}