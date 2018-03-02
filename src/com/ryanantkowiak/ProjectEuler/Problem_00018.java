package com.ryanantkowiak.ProjectEuler;

import java.util.HashMap;
import java.util.Map;

/*
Maximum path sum I
Problem 18 
By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.

3
7 4
2 4 6
8 5 9 3

That is, 3 + 7 + 4 + 9 = 23.

Find the maximum total from top to bottom of the triangle below:

75
95 64
17 47 82
18 35 87 10
20 04 82 47 65
19 01 23 75 03 34
88 02 77 73 07 63 67
99 65 04 28 06 16 70 92
41 41 26 56 83 40 80 70 33
41 48 72 33 47 32 37 16 94 29
53 71 44 65 25 43 91 52 97 51 14
70 11 33 28 77 73 17 78 39 68 17 57
91 71 52 38 17 14 91 43 58 50 27 29 48
63 66 04 68 89 53 67 30 73 16 69 87 40 31
04 62 98 27 23 09 70 98 73 93 38 53 60 04 23

NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route.
However, Problem 67, is the same challenge with a triangle containing one-hundred rows;
it cannot be solved by brute force, and requires a clever method! ;o)
*/

public class Problem_00018
{
	static class Node
	{
		public Node(final int value)
		{
			this.value = value;
		}

		public int value;

		public Node left = null;
		public Node right = null;
	}

	static class IntPair
	{
		public IntPair(final int a, final int b)
		{
			this.a = a;
			this.b = b;
		}

		public int a;
		public int b;
	}

	public static Map<Integer, IntPair> indexToRowColumn = null;
	public static Map<String, Integer> rowColumnToIndex = null;

	public static void initStaticMaps(final int maxLevels)
	{
		indexToRowColumn = new HashMap<Integer, IntPair>();
		rowColumnToIndex = new HashMap<String, Integer>();

		// pre-compute maps for indexing into the flat array

		for (int row = 0 ; row < maxLevels ; ++row)
		{
			for (int col = 0 ; col <= row ; ++col)
			{
				int index = 0;

				for (int i = 0 ; i <= row ; ++i)
					index += i;

				index += col;

				indexToRowColumn.put(index, new IntPair(row, col));
				rowColumnToIndex.put("" + row + "-" + col, index);
			}
		}
	}

	public static int getLeftChildIndex(int n)
	{
		IntPair ip = indexToRowColumn.get(n);

		if (ip == null)
			return -1;

		String leftChildRowColStr = "" + (ip.a + 1) + "-" + (ip.b);

		return rowColumnToIndex.get(leftChildRowColStr);
	}

	public static int getRightChildIndex(int n)
	{
		IntPair ip = indexToRowColumn.get(n);

		if (ip == null)
			return -1;

		String rightChildRowColStr = "" + (ip.a + 1) + "-" + (ip.b + 1);

		return rowColumnToIndex.get(rightChildRowColStr);
	}

	public static int maxValuePath(Node n)
	{
		if (n == null)
			return 0;

		int left = maxValuePath(n.left);
		int right = maxValuePath(n.right);

		return n.value + Math.max(left, right);
	}

	public static void main(String[] args)
	{
		initStaticMaps(16);

		final String data = "75\n" + "95 64\n" + "17 47 82\n" + "18 35 87 10\n" + "20 04 82 47 65\n"
				+ "19 01 23 75 03 34\n" + "88 02 77 73 07 63 67\n" + "99 65 04 28 06 16 70 92\n"
				+ "41 41 26 56 83 40 80 70 33\n" + "41 48 72 33 47 32 37 16 94 29\n"
				+ "53 71 44 65 25 43 91 52 97 51 14\n" + "70 11 33 28 77 73 17 78 39 68 17 57\n"
				+ "91 71 52 38 17 14 91 43 58 50 27 29 48\n" + "63 66 04 68 89 53 67 30 73 16 69 87 40 31\n"
				+ "04 62 98 27 23 09 70 98 73 93 38 53 60 04 23";

		final String[] arr = data.split("[\n ]");
		Node[] nodes = new Node[arr.length];

		for (int i = 0 ; i < arr.length ; ++i)
			nodes[i] = new Node(Integer.parseInt(arr[i]));

		for (int i = 0 ; i < arr.length ; ++i)
		{
			int leftChildIndex = getLeftChildIndex(i);

			if (leftChildIndex < 0 || leftChildIndex >= arr.length)
				nodes[i].left = null;
			else
				nodes[i].left = nodes[leftChildIndex];

			int rightChildIndex = getRightChildIndex(i);

			if (rightChildIndex < 0 || rightChildIndex >= arr.length)
				nodes[i].right = null;
			else
				nodes[i].right = nodes[rightChildIndex];
		}

		Node root = nodes[0];
		System.out.println(maxValuePath(root));
	}
}

/*
 * 1074
 */
