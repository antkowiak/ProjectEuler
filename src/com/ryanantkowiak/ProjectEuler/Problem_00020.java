package com.ryanantkowiak.ProjectEuler;

import java.math.BigInteger;

/*
Factorial digit sum
Problem 20 
n! means n × (n − 1) × ... × 3 × 2 × 1

For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

Find the sum of the digits in the number 100!
*/

public class Problem_00020
{
	public static void main(String[] args)
	{
		BigInteger bi = new BigInteger("1");

		for (int i = 100 ; i > 1 ; --i)
			bi = bi.multiply(new BigInteger("" + i));

		int sum = 0;

		for (char ch : bi.toString().toCharArray())
			sum += ch - '0';

		System.out.println(sum);
	}
}

/*
 * 648
 */
