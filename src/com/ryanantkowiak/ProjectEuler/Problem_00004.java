package com.ryanantkowiak.ProjectEuler;

/*
Largest palindrome product
Problem 4 
A palindromic number reads the same both ways.
The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

Find the largest palindrome made from the product of two 3-digit numbers.
*/

public class Problem_00004
{
	public static boolean isPalendrome(int n)
	{
		String s = "" + n;

		int halfLen = s.length() / 2;

		for (int i = 0 ; i < halfLen ; ++i)
			if (s.charAt(i) != s.charAt(s.length() - i - 1))
				return false;

		return true;
	}

	public static void main(String[] args)
	{
		int largest = 0;

		for (int a = 999 ; a > 0 ; --a)
		{
			for (int b = 999 ; b > 0 ; --b)
			{
				int prod = a * b;

				if (prod > largest && isPalendrome(prod))
					largest = prod;
			}
		}

		System.out.println(largest);
	}
}

/*
 * 906609
 */
