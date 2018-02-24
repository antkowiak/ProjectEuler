package com.ryanantkowiak.ProjectEuler;

/*
Sum square difference
Problem 6 
The sum of the squares of the first ten natural numbers is,

1^2 + 2^2 + ... + 10^2 = 385
The square of the sum of the first ten natural numbers is,

(1 + 2 + ... + 10)^2 = 55^2 = 3025
Hence the difference between the sum of the squares of the first ten natural numbers and the
square of the sum is 3025 − 385 = 2640.

Find the difference between the sum of the squares of the first one hundred natural numbers and
the square of the sum.
*/

public class Problem_00006
{
	public static void main(String[] args)
	{
		long sumOfSquares = 0;
		long squareOfSums = 0;

		for (int i = 1 ; i <= 100 ; ++i)
		{
			sumOfSquares += (i * i);
			squareOfSums += i;
		}

		squareOfSums = squareOfSums * squareOfSums;

		System.out.println(squareOfSums - sumOfSquares);
	}
}

/*
 * 25164150
 */
