import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
       
        StringBuilder string = new StringBuilder();
        Pattern p = Pattern.compile("\d+");
        Matcher m = p.matcher(s);
        
        if (m.find()){
            string.append(m.group(0));
            string.append(":");
            string.append(m.group(1));
            string.append(":");
            string.append(m.group(2));
        }
        return string.toString();
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
