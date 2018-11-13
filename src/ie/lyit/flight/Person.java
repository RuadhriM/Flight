//Class: Software Implementation - CSDF
//Instructor: Maria Boyle
//Description: Person class
//Date: 9/11/2018
//Written by Ruadhri McConigley
package ie.lyit.flight;

import java.io.Serializable;

public abstract class Person implements Serializable{
	protected Name name;
	protected Date dateOfBirth;	
	
	public Person(){
		name = new Name();
		dateOfBirth = new Date();
	}
	
    public Person(String t, String fN, String sn, 
    		      int d, int m, int y){
		name = new Name(t, fN, sn);
		dateOfBirth=new Date(d, m, y);
	}
    
    public String toString(){
	   return name.toString() + "," + dateOfBirth;
	}

	public boolean equals(Object obj){
	   Person pObject;
	   if (obj instanceof Person)
	      pObject = (Person)obj;
	   else
	      return false;
	   
       return(name.equals(pObject.name) &&
    		  dateOfBirth.equals(pObject.dateOfBirth));
	}
	
	public void setName(Name nameIn){
		name = nameIn;
	}
	public Name getName(){
		return name;
	}
	public void setDateOfBirth(Date dateOfBirthIn){
		dateOfBirth = dateOfBirthIn;
	}
	public Date getDateOfBirth(){
		return dateOfBirth;
	}	
}