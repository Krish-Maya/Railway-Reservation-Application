import java.util.*;

class TrainBooking
{
 
 
    public static void main( String[] args)
	{
	   Scanner sc = new Scanner( System.in);
	   int ch,i=0;
	   Passenger[] p= new Passenger[10];
	   Passenger pp= new Passenger();
	    
	   do
	   {
		   System.out.println("############Train Booking###########");
	    System.out.println("**********  1.Booking 2.Cancel 3.Status_Check 4.Available_Tickets 5.Exit********");
	   ch=sc.nextInt();
	      switch(ch)
		  {
			  case 1:
			          p[i]= new Passenger();
			           p[i].booking();
					   i++;
                       
                        break;
			  case 2: 
			          System.out.println("Enter your passenger Id ");
					   int pid=sc.nextInt();
					   boolean bbb=false;
			           for ( int ii=0;ii<10;ii++)
					   {
						   bbb= p[ii].search(pid);
						   if(bbb)
						   {
						   p[ii].cancelTicket();
						   break;
						   }
					   }
					   if(!bbb)
					   {
						   System.out.println("Passenger Not Exist");
					   }
					   break;
			              
			  case 3: 
			         System.out.println("Enter your passenger Id ");
					   int pi=sc.nextInt();
			           boolean bb=false;
			           for ( int ii=0;ii<10;ii++)
					   {
						   bb= p[ii].search(pi);
						   if(bb)
						   {
						   p[ii].checkStatus();
						  
						   break;
						   }
					   }
					   if(!bb)
					   {
						   System.out.println("Passenger Not Exist");
					   }
					   break;
			   case 4: 
			           pp.checkavailable();
					   break;
			   
		  }
	   }while(ch<5);
	}
}

class Passenger
{
	  public static int tmax=60;
	   int pno;
	   String type="";
	   int tic;
	   String status="";
	   int c;
	   boolean b=true;
	   int wait;
	   Scanner s= new Scanner(System.in);
      public void booking()
	  {
		  
		 System.out.println("Enter Your Passenger id: ");
		 pno=s.nextInt();
		 System.out.println("Enter Your type of Coach 1.AC 2.NonAC 3.Seater ");
		 while(b)
		 {
		 c=s.nextInt();
		  if(c==1)
		 {
			 type="AC";
			 break;
		 }else if(c==2)
		 {
			 type="Non_AC";
			 break;
		 }else if(c==3)
		 {
			 type="Seater";
			 break;
		 }else{
			 System.out.println("Invalid ");
			 b=false;
		 }
		 }
		 System.out.println("Enter number of tickets you want : ");
		 tic=s.nextInt();
		 if(tmax>=tic)
		 {
			 tmax=tmax-tic;
			status="Confirm";
			 System.out.println("Ticket Booking Successfully");
		 }else 
		 {
			 wait=tic-tmax;
			 status="waiting";
			 System.out.println("Only "+ tmax+ " are Booked and remaining "+wait+" are Waiting List" );
	  }
	  
	  }
        public void checkStatus()
         {
        System.out.println(" Passenger Id: "+ pno);	
        System.out.println(" Tickets Booked "+ tic);
		System.out.println(" Coach Type "+ type);
		System.out.println(" Status "+ status);
		
}
      public boolean search( int pid)
	  {
		  if(pid==pno)
		  {
			  return true;
		  }
		  return false;
	  }
	  public void cancelTicket()
	  {
		  System.out.println("Your Booked Ticket "+tic+"  Enter the ticket You want cancel ");
		  int can= s.nextInt();
		  if(tic==can)
		  {
			  status="cancel";
			  tic=tic-can;
			  tmax=tmax+can;
			  System.out.println(" Cancel ticket successfully");
		  }
		  else if(tic>=can)
		  {
			   status="Confirm";
			  tic=tic-can;
			  tmax=tmax+can;
			  System.out.println(" Cancel ticket successfully");
		  }
	  }
	   public static void checkavailable()
	   {
		   System.out.println("Available number of Tickets "+ tmax);
	   }
			  
}