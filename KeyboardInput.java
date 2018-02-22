
// this program will help user to learn user input from keyboard 

//import 

import java.util.Scanner;
public class KeyboardInput {

	public static void main(String[] arg)
	{
		
		Scanner input = new Scanner(System.in);
		String str;
		System.out.print("Enter a Sentance: ");
		str=input.nextLine();
		System.out.printf("you entered %s\n",str);
		System.out.print("Enter a Integer: ");
		int number = input.nextInt();
		System.out.printf("you entered %d\n",number);
		System.out.print("Enter a Double number: ");
		double num=input.nextDouble();
		System.out.printf("you entered %.2f\n",num);
		System.out.print("Enter a float number: ");
		float x =input.nextFloat();
		System.out.printf("you entered %.2f\n",x);
		System.out.print("Enter a : ");
		char ch =input.next().charAt(0);
		System.out.printf("you entered %c\n",ch);
		
		
		
		
	}
}
