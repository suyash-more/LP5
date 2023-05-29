import CalculatorModule.CalculatorPOA; 
import java.lang.String; 

class CalculatorImpl extends CalculatorPOA

{

	CalculatorImpl()

	{

		super();

		System.out.println("Calculator Object Created");

	}

	public int add(int a, int b) 

	{

		int res = a+b ; 

		return (res);

	}

}
