package test1;


public class Test {
 
	static int power(int data, int exp) 
	{
		int i, result=1;
		for (i=0; i<exp; i++)
			result= result*data;
		return result; 
	}
	
 public static void main(string args[]) {
	 System.out.print(power(2,10));
		// TODO Auto-generated method stub

	}

}