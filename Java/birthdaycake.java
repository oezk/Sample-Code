import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

/*You are in-charge of the cake for your niece's birthday and have decided the cake will have one candle for each year of her total age. When she blows out the candles, she’ll only be able to blow out the tallest ones. Your task is to find out how many candles she can successfully blow out.

Sample Input 

4
3 2 1 3

Sample Output 
2

*/


public class Solution {

    static int birthdayCakeCandles(int n, int[] ar) {
        
        int tallestCandle = ar[0];
        int blowCount = 0;
        

        for (int i = 0; i < ar.length; i++){
            if (tallestCandle < ar[i]){
                tallestCandle = ar[i];         
            }
        }
             for (int j = 0; j < n; j++){
            if (ar[j] == tallestCandle){
                blowCount++;
            }
        }
        
        return(blowCount);
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scan.nextLine().trim());

        int[] ar = new int[n];

        String[] arItems = scan.nextLine().split(" ");

        for (int arItr = 0; arItr < n; arItr++) {
            int arItem = Integer.parseInt(arItems[arItr].trim());
            ar[arItr] = arItem;
        }

        int result = birthdayCakeCandles(n, ar);

        bw.write(String.valueOf(result));
        bw.newLine();

        bw.close();
    }
}
