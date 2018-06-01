// This program reverses words in a string including the whitespace

public class ReverseWords {

	public static void main(String[] args) {

		System.out.println(reverseWords("Hello,   how are you  today?"));
	}

	static String reverseWords(String sentence) {

		StringBuilder revSentence = new StringBuilder();
		String[] splitSentence = sentence.split("\\b");

		for (int i = 0; i < splitSentence.length; i++) {

			for (int j = splitSentence[i].length() - 1; j > -1; j--) {
				revSentence.append(splitSentence[i].charAt(j));
			}

		}
		return (revSentence.toString());
	}

}
