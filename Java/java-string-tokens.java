import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();

		if (s.length() > 400000) {
			return;
		} else if (s == null || s.trim().equals("")) {
			System.out.println("0");
			return;
		}
        
		String regex = "[!,?.*_'@\\ ]+";
		String arr[] = s.trim().split(regex);

		System.out.println(arr.length);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		scan.close();
	}
}