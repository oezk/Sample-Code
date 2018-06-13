import java.io.*;
import java.util.*;
import java.lang.*;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String A = sc.nextLine();

		String rstring = new StringBuilder(A).reverse().toString();

		String result = (A.equals(rstring)) ? "Palindrome" : "Not Palindrome";
		System.out.println(result);
	}

}
