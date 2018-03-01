package com.ryanantkowiak.ProjectEuler;

import java.math.BigInteger;

/*
Power digit sum
Problem 16 
2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

What is the sum of the digits of the number 2^1000?
*/

public class Problem_00016
{
	public static void main(String[] args)
	{
		int sum = 0;

		for (char c : new BigInteger("2").pow(1000).toString().toCharArray())
			sum += c - '0';

		System.out.println(sum);
	}
}

/*
 * 1366
 */
