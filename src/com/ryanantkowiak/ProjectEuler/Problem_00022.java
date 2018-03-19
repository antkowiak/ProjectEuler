package com.ryanantkowiak.ProjectEuler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/*
Names scores
Problem 22 
Using names.txt (right click and 'Save Link/Target As...'),
a 46K text file containing over five-thousand first names,
begin by sorting it into alphabetical order. Then working out the
alphabetical value for each name, multiply this value by its alphabetical
position in the list to obtain a name score.

For example, when the list is sorted into alphabetical order,
COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list.
So, COLIN would obtain a score of 938 × 53 = 49714.

What is the total of all the name scores in the file?
*/

public class Problem_00022
{
	public static void main(String[] args)
	{
		try
		{
			List<String> data = Files.readAllLines(Paths.get("src/p022_names.txt"));

			if (!data.isEmpty())
			{
				String[] arr = data.get(0).replaceAll("\"", "").split(",");
				Arrays.sort(arr);

				long totalScores = 0;

				for (int i = 0 ; i < arr.length ; ++i)
				{
					int nameScore = 0;

					for (char ch : arr[i].toUpperCase().toCharArray())
						if (ch >= 'A' && ch <= 'Z')
							nameScore += ch - 'A' + 1;

					totalScores += nameScore * (i + 1);
				}

				System.out.println(totalScores);
			}

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}

/*
 * 871198282
 */
