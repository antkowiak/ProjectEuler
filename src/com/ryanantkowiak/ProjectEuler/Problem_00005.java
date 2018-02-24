package com.ryanantkowiak.ProjectEuler;

/*
Smallest multiple
Problem 5 
2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
*/

public class Problem_00005
{
	public static void main(String[] args)
	{
		long candidate = 0;

		while (true)
		{
			candidate += 20;

			boolean foundIt = true;

			for (int i = 19 ; i > 1 ; --i)
			{
				if (candidate % i != 0)
				{
					foundIt = false;
					break;
				}
			}

			if (foundIt)
			{
				System.out.println(candidate);
				return;
			}
		}
	}
}

/*
 * 232792560
 */
