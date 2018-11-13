//Class: Software Implementation - CSDF
//Instructor: Maria Boyle
//Description: Date class
//Date: 9/11/2018
//Written by Ruadhri McConigley
package ie.lyit.flight;

import java.io.Serializable;

public class Date implements Serializable{
	private int day;
	private int month;
	private int year;

	public Date(){
	   day=month=year=0;
	}

  	public Date(int day, int month, int year) throws IllegalArgumentException{
 	   if(day < 1 || day > 31 || month < 1 || month > 12 || year < 1900)
		   throw new IllegalArgumentException("Invalid Date.");		
  		
       this.day = day;
       this.month = month;
	   this.year = year;
    }

	@Override
    public String toString(){
		return (day + "/" + month + "/" + year);
	}
	
	@Override
	public boolean equals(Object obj){
	   Date dObject;
	   if (obj instanceof Date)
		   dObject = (Date)obj;
	   else
	       return false;
	 
	   return this.day == dObject.day
	          && this.month == dObject.month
	          && this.year == dObject.year;
	}	
	
	public int getDay(){
		return day;
	}
	public int getMonth(){
		return month;
	}
	public int getYear(){
		return year;
	}

	public void setDay(int setDayTo) throws IllegalArgumentException{
	   if(setDayTo < 1 || setDayTo > 31)
		   throw new IllegalArgumentException("Invalid day.");
	   
       day=setDayTo;
	}
 	public void setMonth(int setMonthTo)throws IllegalArgumentException{
 	   if(setMonthTo < 1 || setMonthTo > 12)
 		   throw new IllegalArgumentException("Invalid month.");		

 		month = setMonthTo;
 	}
 	public void setYear(int setYearTo)throws IllegalArgumentException{
 	   if(setYearTo <1900)
 		   throw new IllegalArgumentException("Invalid year.");		

 	   year = setYearTo;
 	}
 }