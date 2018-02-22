     //First program will help user to learn about creating and printing variable in different datatype 

package day1;

public class day1 {
 
	public static void main(String[] args)
	{
	
		// (1) Print Statement 
		System.out.print("Hello\n");
		
		// (2) print Statement 
		System.out.println("How are you");
		
		// String Variable 
		String str = "This is string variable ";
		//(3) print Statement for different format 
		System.out.printf("%s\n" , str);
		
		 // Variables 
		String str2= "Integer Number is: ";
		
		// declaring and printing integer variable  in different format 
		int number = 10;
		System.out.println(number);
		System.out.printf("%s%d\n", str2,number);
		str2="Double Number is:  ";
		// declaring and printing Double variable in different format 
		double num = 12;
		System.out.println(num);
		System.out.printf("%s%.2f\n", str2,num);
		
		// declaring and printing float variable in different format
		float decimal= (float) 12.5678;
		str2="Float Number is:  ";
		System.out.println(decimal);
		System.out.printf("%s%.2f\n", str2,decimal);
		
		// declaring and printing boolean variable
		boolean var = false;
		
		System.out.println(var);
		
		// declaring and printing boolean variable
				char var2 = 'A';
				
				System.out.println(var2);
	}
	
}
