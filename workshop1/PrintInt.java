package jac444.wk1;

/**
 * @author Namra Rupesh Fanse
 *
 */


import java.util.Scanner;

public class PrintInt {

	public static void main ( String args[] ) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter an integer to get that integer in binary, octal and hexadecimal formats.\n");
		
		System.out.println("This program also print its reciprocal as a hexadecimal floating point number.\n");
		
		System.out.print("Enter an integer: ");
		
		int number = in.nextInt();
				
		String binaryString = Integer.toBinaryString(number);
		
		System.out.println("\nBinary representation is: " + binaryString);
		
		String octalString =  Integer.toOctalString(number);
		
		System.out.println("\nOctal representation is: " + octalString);
		
		String hexString = Integer.toHexString(number);
		
		System.out.println("\nHexadecimal representation is: " + hexString);
		
		float reciprocal = 1 / (float)number;
		
		System.out.println("\nReciprocal is " + reciprocal);
		
		String hexStringOfReciprocal = Float.toHexString(reciprocal);
		
		System.out.println("\nReciprocal in hexadecimal is " + hexStringOfReciprocal);
		
		in.close();
	}
	
}
