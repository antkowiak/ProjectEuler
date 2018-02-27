package com.ryanantkowiak.ProjectEuler;

import java.util.HashMap;
import java.util.Map;

/*
The following iterative sequence is defined for the set of positive integers:

n → n/2 (n is even)
n → 3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:

13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.
*/

public class Problem_00014
{
	public static Map<Long, Long> cache = new HashMap<Long, Long>();

	public static long chainLength(long n)
	{
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;

		if (cache.containsKey(n))
		{
			return cache.get(n);
		}

		if (n % 2 == 0)
		{
			long len = 1 + chainLength(n / 2);
			cache.put(n, len);
			return len;
		}
		else
		{
			long len = 1 + chainLength(3 * n + 1);
			cache.put(n, len);
			return len;
		}
	}

	public static void main(String[] args)
	{
		long largestChain = 0;
		long startingPointForLargestChain = 0;

		for (long i = 1 ; i < 1000000 ; ++i)
		{
			long length = chainLength(i);

			if (length > largestChain)
			{
				largestChain = length;
				startingPointForLargestChain = i;
			}
		}

		System.out.println(startingPointForLargestChain);
	}
}

/*
 * 837799
 */
