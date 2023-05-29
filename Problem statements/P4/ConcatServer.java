import ConcatModule.*; 

import org.omg.CosNaming.*;

import org.omg.CosNaming.NamingContextPackage.*;

import org.omg.CORBA.*; 

import org.omg.PortableServer.*;



class ConcatServer

{

	public static void main(String[] args)

	{

		try

		{ 	// initialize the ORB

			org.omg.CORBA. ORB orb = org.omg.CORBA.ORB.init(args, null);

			

			// initialize the BOA/POA

			POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA")); 

			rootPOA.the_POAManager().activate();

			// creating the calculator object 

			ConcatImpl rvr = new ConcatImpl();

			

			// get the object reference from the servant class 

			org.omg.CORBA.Object ref = rootPOA.servant_to_reference(rvr);

			

			System.out.println("Step1");

			Concat h_ref = ConcatModule.ConcatHelper.narrow(ref); 

			System.out.println("Step2");

			

			org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");

			

			System.out.println("Step3");

			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

 

			System.out.println("Step4");

			

			String name = "Concat";

			NameComponent path[] = ncRef.to_name(name); 

			ncRef.rebind(path,h_ref);

			

			System.out.println("Concat Server reading and waiting....");

			orb.run();

		}

		catch (Exception e)

		{

			e.printStackTrace();

		}

	}

}
