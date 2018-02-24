package com.ryanantkowiak.ProjectEuler;

/*
10001st prime
Problem 7 
By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

What is the 10001st prime number?
*/

public class Problem_00007
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
		long n = 13;
		int primeCount = 6;

		while (true)
		{
			if (isPrime(n))
				if (primeCount++ == 10001)
					break;

			n += 2;
		}

		System.out.println(n);
	}
}

/*
 * 104743
 */
