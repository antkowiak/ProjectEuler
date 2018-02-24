package com.ryanantkowiak.ProjectEuler;

/*
Summation of primes
Problem 10 
The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

Find the sum of all the primes below two million.
*/

public class Problem_00010
{
	public static boolean isPrime(long n)
	{
		if (n < 2)
			return false;
		else if (n == 2)
			return true;
		else if (n % 2 == 0)
			return false;

		long sqrt = (long) Math.sqrt(n);

		for (long i = 3 ; i <= sqrt ; ++i)
			if (n % i == 0)
				return false;

		return true;
	}

	public static void main(String[] args)
	{
		long sum = 2;

		for (long n = 3 ; n < 2000000 ; n += 2)
		{
			if (isPrime(n))
				sum += n;
		}

		System.out.println(sum);
	}
}

/*
 * 142913828922
 */
