import CalculatorModule.*; 

import org.omg.CosNaming.*;

import org.omg.CosNaming.NamingContextPackage.*;

import org.omg. CORBA.*; 

import java.io.*;

import java.util.Scanner ;



class CalculatorClient

{

	public static void main(String args[])

	{

		Calculator CalculatorImpl=null;

		try

		{

		// initialize the ORB 

		org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);

		org.omg.CORBA.Object objRef = orb.resolve_initial_references ("NameService"); 

		NamingContextExt ncRef = NamingContextExtHelper.narrow (objRef);

		String name = "Calculator";

		CalculatorImpl = CalculatorHelper.narrow(ncRef.resolve_str(name));

		Scanner sc = new Scanner(System.in); 
		
		System.out.println("Enter first number:"); 

		int a = sc.nextInt() ;
		
		System.out.println("Enter second number:"); 

		int b = sc.nextInt() ;
		
		int res = CalculatorImpl.add(a, b);

		System.out.println(res);

		} 



		catch (Exception e)

		{ 

		e.printStackTrace();

		}

	}

}
