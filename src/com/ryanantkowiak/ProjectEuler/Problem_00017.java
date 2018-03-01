package com.ryanantkowiak.ProjectEuler;

/*
Number letter counts
Problem 17 
If the numbers 1 to 5 are written out in words: one, two, three, four,
five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words,
how many letters would be used?


NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two)
contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of
"and" when writing out numbers is in compliance with British usage.
*/

public class Problem_00017
{
	public static final String EMPTY = "";
	public static final String SPACE = " ";
	public static final String HYPHEN = "-";
	public static final String AND = "and";

	public static final String ZERO = "zero";

	public static final String ONES[] = { "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
			"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };

	public static final String TENS[] = { "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty",
			"ninety" };

	public static final String HUNDRED = "hundred";
	public static final String THOUSAND = "thousand";
	public static final String MILLION = "million";
	public static final String BILLION = "billion";
	public static final String TRILLION = "trillion";
	public static final String QUADRILLION = "quadrillion";
	public static final String QUINTILLION = "quintillion";

	public static final String ONES_toString(final long n)
	{
		if (n > 0 && n < 20)
			return ONES[(int) n - 1];

		return EMPTY;
	}

	public static final String TENS_toString(final long n)
	{
		if (n > 1 && n < 10)
			return TENS[(int) n - 2];

		return EMPTY;
	}

	public static final String numberToString(final long n, final boolean useBritishAnd)
	{
		if (n == 0)
			return ZERO;

		String result = EMPTY;

		long quintillions = (n / 1000000000000000000L);
		long quadrillions = (n % 1000000000000000000L) / 1000000000000000L;
		long trillions = (n % 1000000000000000L) / 1000000000000L;
		long billions = (n % 1000000000000L) / 1000000000L;
		long millions = (n % 1000000000L) / 1000000L;
		long thousands = (n % 1000000L) / 1000L;
		long hundreds = (n % 1000L) / 100L;
		long tens = (n % 100L) / 10L;
		long ones = (n % 10L);

		if (tens == 1)
			ones += 10;

		if (quintillions > 0)
			result += numberToString(quintillions, useBritishAnd) + SPACE + QUINTILLION + SPACE;

		if (quadrillions > 0)
			result += numberToString(quadrillions, useBritishAnd) + SPACE + QUADRILLION + SPACE;

		if (trillions > 0)
			result += numberToString(trillions, useBritishAnd) + SPACE + TRILLION + SPACE;

		if (billions > 0)
			result += numberToString(billions, useBritishAnd) + SPACE + BILLION + SPACE;

		if (millions > 0)
			result += numberToString(millions, useBritishAnd) + SPACE + MILLION + SPACE;

		if (thousands > 0)
			result += numberToString(thousands, useBritishAnd) + SPACE + THOUSAND + SPACE;

		if (hundreds > 0)
			result += numberToString(hundreds, useBritishAnd) + SPACE + HUNDRED + SPACE;

		if (useBritishAnd && (tens > 0 || ones > 0) && (hundreds > 0 || thousands > 0 || millions > 0 || billions > 0
				|| trillions > 0 || quadrillions > 0 || quintillions > 0))
			result += AND + SPACE;

		if (tens > 1)
		{
			result += TENS_toString(tens);

			// Hyphenate tens followed by non-zero ones
			if (ones > 0)
				result += HYPHEN;
			else
				result += SPACE;
		}

		result += ONES_toString(ones);

		// Remove any trailing SPACE
		result = result.trim();

		return result;
	}

	public static int countLetters(final String s)
	{
		int count = 0;

		for (char c : s.toLowerCase().toCharArray())
			if (c >= 'a' && c <= 'z')
				++count;

		return count;
	}

	public static void main(String[] args)
	{
		long sum = 0;

		for (long i = 1 ; i <= 1000 ; ++i)
			sum += countLetters(numberToString(i, true));

		System.out.println(sum);
	}
}

/*
 * 21124
 */
