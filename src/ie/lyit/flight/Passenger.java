package ie.lyit.flight;

public class Passenger extends Person{ 
	private int noBags;
	private boolean priorityBoarding;

	public Passenger(){
		super();
	 	noBags = 0;
		priorityBoarding = false;
	}

	public Passenger(String t, String fN, String sn, int d, int m, int y, int noB, boolean pB){
		super(t, fN, sn, d, m, y);
		noBags=noB;
		priorityBoarding=pB;
	}

	@Override
	public String toString(){
	   return super.toString() + " ==> " + noBags + " bags, Priority Boarding is " + priorityBoarding;
	}

	@Override
	public boolean equals(Object obj){
	   Passenger pObject;
	   if (obj instanceof Passenger)
		   pObject = (Passenger)obj;
	   else
	       return false;
	 
	   return super.equals(pObject)
	          && this.noBags == pObject.noBags
	          && this.priorityBoarding == pObject.priorityBoarding;
	}	

	public void setNoBags(int noBagsIn){
	    noBags=noBagsIn;
	}
    public int getNoBags(){
       return noBags;
    }
					
    public void setPriorityBoarding(boolean priorityBoardingIn){
       priorityBoarding=priorityBoardingIn;
    }
    public boolean getPriorityBoarding(){
       return priorityBoarding;
    }	
}