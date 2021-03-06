package com.ryanantkowiak.ProjectEuler;

/*
The sequence of triangle numbers is generated by adding the natural numbers.
So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28.
The first ten terms would be:

1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

Let us list the factors of the first seven triangle numbers:

 1: 1
 3: 1,3
 6: 1,2,3,6
10: 1,2,5,10
15: 1,3,5,15
21: 1,3,7,21
28: 1,2,4,7,14,28
We can see that 28 is the first triangle number to have over five divisors.

What is the value of the first triangle number to have over five hundred divisors?
*/

public class Problem_00012
{
	public static long countFactors(long n)
	{
		long count = 1;

		final long half = n / 2;

		for (long i = 2 ; i < half ; ++i)
			if (n % i == 0)
				++count;

		return count;
	}

	public static void main(String[] args)
	{
		long triangle = 0;

		for (long index = 1 ; index < 100000 ; ++index)
		{
			triangle += index;

			long numFactors = countFactors(triangle);

			if (numFactors > 500)
			{
				System.out.println(triangle);
				break;
			}
		}
	}
}

/*
 * 76576500
 * 
 * This takes a very long time. None of the optimizations suggested in the
 * solution were things that came to mind for me when I was thinking about this
 * problem.
 */
