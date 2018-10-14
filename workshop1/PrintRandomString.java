package jac444.wk1;

/**
 * @author Namra Rupesh Fanse
 *
 */


import java.util.Random;

public class PrintRandomString {

	public static void main(String[] args) {
		
		System.out.println("This program produces a random string of letter and digits by generating a random long value and printing it in base 36");
		
		long generatedLongValue = new Random().nextLong();
		
		System.out.println("\nRandom string: " + generatedLongValue);
		
		System.out.print("\nRandom string in base 36: " + Long.toString(generatedLongValue,36));
		
		
	}

}
