package com.ryanantkowiak.ProjectEuler;

/*
Largest prime factor
Problem 3 
The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600851475143 ?
*/

public class Problem_00003
{
	public static void main(String[] args)
	{
		long total = 600851475143L;
		long sqrt = (long) Math.sqrt(total);

		long largest = 1;

		for (long i = 2 ; i < sqrt ; ++i)
		{
			while (total > 1)
			{
				if (total % i == 0)
				{
					largest = i;
					total /= i;
				}
				else
					break;
			}
		}

		System.out.println(largest);
	}
}

/*
 * 6857
 */
