import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	public static String getSmallestAndLargest(String s, int k) {
		String smallest = "";
		String largest = "";

		ArrayList stringArr = new ArrayList();

		// Populate ArrayList
		for (int i = 0; i < s.length() - (k - 1); i++) {
			stringArr.add(s.substring(i, i + k));
		}

		Iterator itr = stringArr.iterator();
		smallest = stringArr.get(0).toString();
		largest = stringArr.get(0).toString();

		while (itr.hasNext()) {
			String str = itr.next().toString();

			if (smallest.compareTo(str) >= 0) {
				smallest = str;
			}

			if (largest.compareTo(str) <= 0) {
				largest = str;
			}
		}

		return smallest + "\n" + largest;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		int k = scan.nextInt();
		scan.close();

		System.out.println(getSmallestAndLargest(s, k));
	}
}