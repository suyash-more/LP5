import ConcatModule.ConcatPOA; 

import java.lang.String; 

class ConcatImpl extends ConcatPOA

{

	ConcatImpl()

	{

		super();

		System.out.println("Reverse Object Created");

	}

	public String concat_string(String str1, String str2) 

	{

		String s = str1 + str2 ;

		return (("Server Send "+s));

	}

}
