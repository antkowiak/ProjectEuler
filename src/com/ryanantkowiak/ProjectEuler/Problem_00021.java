package com.ryanantkowiak.ProjectEuler;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
Amicable numbers
Problem 21 
Let d(n) be defined as the sum of proper divisors of n(numbers less than n which
divide evenly into n).
If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each
of a and b are called amicable numbers.

For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110;
therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

Evaluate the sum of all the amicable numbers under 10000.
*/

public class Problem_00021
{
	public static int getSumOfProperDivisors(int n)
	{
		int sum = 1;
		int half = n / 2;

		for (int i = 2 ; i <= half ; ++i)
			if (n % i == 0)
				sum += i;

		return sum;
	}

	public static void main(String[] args)
	{
		Map<Integer, Integer> data = new HashMap<Integer, Integer>();

		for (int i = 1 ; i < 10000 ; ++i)
			data.put(i, getSumOfProperDivisors(i));

		int sum = 0;

		for (Entry<Integer, Integer> par : data.entrySet())
		{
			int key = par.getKey();
			int value = par.getValue();

			if (key != value && data.containsKey(value) && key == data.get(value))
				sum += key;
		}

		System.out.println(sum);
	}
}

/*
 * 31626
 */
