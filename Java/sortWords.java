public class SortWords {

	public static void main(String[] args) {

		System.out.println(sortWords("c,a,e,b,d|has,this,ordered,list,been"));
	}

	private static String sortWords(String lists) {

		int ascii = 97;
		String newList = "";
		StringBuilder sbList = new StringBuilder();
		String[] split = lists.split("\\|");
		String[] list1 = split[0].split(",");
		String[] list2 = split[1].split(",");

		for (int i = 0; i < list1.length; i++) {
			for (int j = 0; j < list1.length; j++) {
				if ((int) list1[j].charAt(0) == ascii) {
					sbList.append(list2[j] + ",");
					ascii++;
				}

			}
		}
		newList = sbList.toString();
		newList = newList.substring(0, newList.length() - 1);
		return (newList);

	}
}
