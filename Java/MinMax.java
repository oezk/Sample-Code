import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    //Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of the five integers. Then print the respective minimum and maximum values as a single line of two space-separated long integers.
    
    static void miniMaxSum(int[] arr) {
        long min = arr[0];
        long max = arr[0];
        long sum = 0;
        
        for (int i = 0; i < arr.length; i++){
            
            sum+= arr[i];
            
            if (arr[i] < min ){ 
                min = arr[i];
            }
            
            if (arr[i] > max){ 
                max = arr[i];
            }
            
        }
        
        System.out.printf("%d %d",(sum - max),(sum - min));

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scan.nextLine().split(" ");

        for (int arrItr = 0; arrItr < 5; arrItr++) {
            int arrItem = Integer.parseInt(arrItems[arrItr].trim());
            arr[arrItr] = arrItem;
        }

        miniMaxSum(arr);
    }
}