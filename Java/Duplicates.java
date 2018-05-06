// Prints out a list of integers that occur multiple times in a string
import java.util.ArrayList;

public class Duplicates {

	public static void main(String[] args) {

		System.out.println(getDuplicates("1,5,3,1,1,6,5,2"));
	}

	private static String getDuplicates(String numbers) {
		StringBuilder sb = new StringBuilder();

		ArrayList<String> uniqueList = new ArrayList<String>();
		String[] split = numbers.split(",");

		for (int i = 0; i < split.length; i++) {
			String temp = split[i];

			for (int j = i + 1; j < split.length; j++) {
				if (temp.equals(split[j])) {

					if (!uniqueList.contains(split[j])) {
						uniqueList.add(split[j]);
						sb.append(split[j] + ",");
					}
				}
			}
		}
		
		String unique = sb.toString();
		unique = unique.substring(0, unique.length() - 1);
		return unique;
	}
	
}
