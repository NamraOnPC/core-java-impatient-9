package jac444.wk1;
/**
 * @author Namra Rupesh Fanse
 *
 */


import java.util.ArrayList;

import java.lang.Exception;

import java.util.Scanner;

public class Pascal {

	private final int n;

	public Pascal(int n) {

		this.n = n;

	}

	public ArrayList<ArrayList<Integer>> pascalsTriangle() {

		ArrayList<ArrayList<Integer>> result = new ArrayList<>(this.n);

		for (int row = 0; row <= this.n; row++) {

			ArrayList<Integer> nextRow = new ArrayList<Integer>(row + 1);

			if (row == 0) {

				nextRow.add(1);

			} else if (row == 1) {

				nextRow.add(1);

				nextRow.add(1);

			} else {

				ArrayList<Integer> prev = result.get(row - 1);

				nextRow.add(1);

				for (int pos = 1; pos < row; pos++) {

					nextRow.add(prev.get(pos - 1) + prev.get(pos));

				}

				nextRow.add(1);

			}

			result.add(nextRow);

		}

		return result;

	}

	public static void main(String[] args) {

		System.out.println("**Counting starts from 0 and first row is 1**");

		while (true) {

			System.out.print("Please enter an number of rows you want for your Pascals Triangle : - ");

			try {

				Scanner in = new Scanner(System.in);

				int foo = in.nextInt();

				Pascal bar = new Pascal(foo);

				ArrayList<ArrayList<Integer>> triangle = bar.pascalsTriangle();

				for (ArrayList<Integer> list : triangle) {

					for (Integer i : list) {

						System.out.printf("%d", i);

					}

					System.out.println();
					
					continue;
					

				}

			} catch (Exception e) {

				System.out.println("Please enter an Integer");
				
				
			
			}

		}

	
	}
}
