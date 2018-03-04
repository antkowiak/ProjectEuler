package com.ryanantkowiak.ProjectEuler;

import java.awt.Point;

/*
Counting Sundays
Problem 19 
You are given the following information, but you may prefer to do some research for yourself.

1 Jan 1900 was a Monday.
Thirty days has September,
April, June and November.
All the rest have thirty-one,
Saving February alone,
Which has twenty-eight, rain or shine.
And on leap years, twenty-nine.
A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.

How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
*/

public class Problem_00019
{
	public static int daysInFebruary(int year)
	{
		if (year % 400 == 0)
			return 29;

		if (year % 100 == 0)
			return 28;

		if (year % 4 == 0)
			return 29;

		return 28;
	}

	public static void advanceMonth(Point data, int numDaysInMonth)
	{
		if (data.x % 7 == 0)
			++(data.y);
		data.x += numDaysInMonth;
	}

	public static void main(String[] args)
	{
		// p.x holds the current day where day % 7 == 0 for Sundays.
		// Starts one year prior on Jan 1 1900
		// Which is a non leap year, starting on a Monday = 365 + 1
		// p.y holds the count of Sundays that fall on the first of a month.
		Point p = new Point(366, 0);

		for (int year = 1901 ; year <= 2000 ; ++year)
		{
			advanceMonth(p, 31); // Jan
			advanceMonth(p, daysInFebruary(year));
			advanceMonth(p, 31); // Mar
			advanceMonth(p, 30); // Apr
			advanceMonth(p, 31); // May
			advanceMonth(p, 30); // Jun
			advanceMonth(p, 31); // Jul
			advanceMonth(p, 31); // Aug
			advanceMonth(p, 30); // Sep
			advanceMonth(p, 31); // Oct
			advanceMonth(p, 30); // Nov
			advanceMonth(p, 31); // Dec
		}

		System.out.println(p.y);
	}
}

/*
 * 171
 */
