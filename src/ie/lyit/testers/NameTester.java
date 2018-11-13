package ie.lyit.testers;

import java.util.ArrayList;

import ie.lyit.flight.Name;

public class NameTester 
{
	public static boolean nameSearch(Name n, ArrayList<Name> names)
	{
		for(Name o: names)
		{
			if(n.equals(o))
				return true;
		}
			return false;
	}
	public static void main(String[] args) 
	{
		/*
	   	Name name = new Name();
		
		name.setTitle("Mr");
		name.setFirstName("John");
		name.setSurname("Doe");
		
		Name name2 = new Name("Mr", "John", "Doe");
		
		
		System.out.print(name.isFemale());
		*/
		
		ArrayList<Name> name = new ArrayList<Name>();
		name.add(new Name("Ms", "Riley", "Reid"));
		name.add(new Name("Mr", "Padraig", "Pearse"));
		name.add(new Name("Mr", "Michael", "Collins"));
		
		for(Object o: name)
		{
			System.out.println(o.toString());
		}
		
		System.out.println(nameSearch(new Name("Mr", "Padraig", "Pearse"), name));
		
		
	}
}
