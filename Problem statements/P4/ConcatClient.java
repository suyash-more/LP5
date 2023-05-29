import ConcatModule.*; 

import org.omg.CosNaming.*;

import org.omg.CosNaming.NamingContextPackage.*;

import org.omg. CORBA.*; 

import java.io.*;



class ConcatClient

{

	public static void main(String args[])

	{

		Concat ConcatImpl=null;

		try

		{

		// initialize the ORB 

		org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);

		org.omg.CORBA.Object objRef = orb.resolve_initial_references ("NameService"); 

		NamingContextExt ncRef = NamingContextExtHelper.narrow (objRef);

		String name = "Concat";

		ConcatImpl = ConcatHelper.narrow(ncRef.resolve_str(name));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		System.out.println("Enter String 1: "); 

		String str1 = br.readLine();
		
		System.out.println("Enter String 2: "); 

		String str2 = br.readLine();

		String tempStr = ConcatImpl.concat_string(str1, str2);

		System.out.println(tempStr);

		} 



		catch (Exception e)

		{ 

		e.printStackTrace();

		}

	}

}
