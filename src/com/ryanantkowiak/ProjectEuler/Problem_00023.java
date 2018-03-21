package com.ryanantkowiak.ProjectEuler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Non-abundant sums
Problem 23 
A perfect number is a number for which the sum of its proper divisors is exactly equal to the number.
For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28,
which means that 28 is a perfect number.

A number n is called deficient if the sum of its proper divisors is less than n and
it is called abundant if this sum exceeds n.

As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that
can be written as the sum of two abundant numbers is 24. By mathematical analysis,
it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers.
However, this upper limit cannot be reduced any further by analysis even though it is known that the
greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.

Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
*/

public class Problem_00023
{
	public static int getSumOfProperDivisors(int n)
	{
		int sum = 1;
		final int half = n / 2;

		for (int i = 2 ; i <= half ; ++i)
			if (n % i == 0)
				sum += i;

		return sum;
	}

	public static boolean isAbundant(int n)
	{
		return (getSumOfProperDivisors(n) > n);
	}

	public static void main(String[] args)
	{
		List<Integer> abundant = new ArrayList<Integer>();

		for (int i = 1 ; i < 28124 ; ++i)
			if (isAbundant(i))
				abundant.add(i);

		Set<Integer> abundantSums = new HashSet<Integer>();

		final int abundantSize = abundant.size();

		for (int i = 0 ; i < abundantSize ; ++i)
			for (int j = 0 ; j < abundantSize ; ++j)
				abundantSums.add(abundant.get(i) + abundant.get(j));

		int sumResults = 0;

		for (int i = 1 ; i < 28124 ; ++i)
			if (!abundantSums.contains(i))
				sumResults += i;

		System.out.println(sumResults);
	}
}

/*
 * 4179871
 */
