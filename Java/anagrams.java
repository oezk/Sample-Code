import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();

        char charA[] = a.toCharArray();
        char charB[] = b.toCharArray();

        Arrays.sort(charA);
        a = new String(charA).toLowerCase();
        Arrays.sort(charB);
        b = new String(charB).toLowerCase();

        String result = (a.equals(b)) ? "Anagrams" : "Not Anagrams";
        System.out.println(result);
    }
}