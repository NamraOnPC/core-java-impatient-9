package jac444.wk1;

/**
 * @author Namra Rupesh Fanse
 *
 */


import java.util.List;

import java.util.Scanner;

import java.util.ArrayList;

public class IsSquare {

	private final int dimension;
	
	private final List<Integer> data;
	
	public IsSquare(int dimension , List<Integer> data) {
		
		this.dimension = dimension;
		
		this.data = data;
		
	}
	
	public boolean squareIsMagic() {
		
		int sum = 0;
		
		for ( int i = 0; i < this.dimension; i++) {
			
			sum += this.data.get(i);
			
		}
		
		int sumOfDiagonal1 = 0;
		
		int sumOfDiagonal2 = 0;
		
		for ( int row = 0; row < this.data.size() / this.dimension; row++) {
			
			int sumOfRow = 0;
			
			for( int column = row * this.dimension; column < (row + 1) * this.dimension; column++) {
				
				sumOfRow += this.data.get(column);
				
			}
			
			if (sumOfRow != sum) {
				
				return false;
				
			}
			
			int sumOfColumn = 0;
			
			for (int column = row; column < this.data.size(); column = column + this.dimension) {
				
				sumOfColumn += this.data.get(column);
				
			}
			
			if(sumOfColumn != sum) {
				
				return false;
				
			}
			
			sumOfDiagonal1 += this.data.get(row * this.dimension + row);
			
			sumOfDiagonal2 += this.data.get((this.dimension - row - 1) * this.dimension + (this.dimension - row - 1)); 
			
		}
		
		return sumOfDiagonal1 == sum && sumOfDiagonal2 == sum;
		
	}
	
	public static void main(String[] args) {
		
		System.out.println("**This program checks whether a square is magic or not**");
		
		System.out.println("**Square is magic if the sum of all rows, columns and diagonals is the same\n");
		
		System.out.print("Please enter string of numbers in one line and press enter twice to check :- ");		
		
		Scanner in = new Scanner(System.in);
		
		List<Integer> data = new ArrayList<Integer>();
		
		int dimension = 0;
		
		for ( String line = in.nextLine(); !line.isEmpty(); line = in.nextLine()) {
			
			String[] fragment = line.split(" ");
			
			dimension = fragment.length;
			
			for(String part : fragment) {
				
				data.add(Integer.valueOf(part));
				
			}
		
		}
		
		IsSquare foo = new IsSquare(dimension , data);
		
		System.out.printf("Square is magic: %b\n" , foo.squareIsMagic());
		
		in.close();
	}

}
