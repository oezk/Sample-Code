import java.util.Scanner;

public class SalesTaxJava {

	private static double iTax = 0.05;
	private static double bTax = 0.10;
	private static boolean debug = false;

	public static void main(String[] args) {

		boolean run = true;
		String choice = "";
		Scanner in = new Scanner(System.in);

		System.out.println("~ Sales Tax ~");

		while (run) {

			System.out.println("\nPlease select an option:");
			System.out.print("1) Start the cash register\n2) Toggle debugging\n");
			System.out.print("3) Exit\n");

			choice = in.nextLine();
			switch (choice) {

			case "1":
				CashRegister cr = new CashRegister(getbTax(), getiTax(), isDebug());
				cr.run();
				break;

			case "2":
				setDebug(!isDebug());
				System.out.println("Debugging enabled: " + isDebug());
				break;

			case "3":
				run = false;
				break;

			default:
				System.err.println("Please enter a single digit");
				break;
			}

		}
		in.close();
	}

	// Getters & Setters

	public static double getbTax() {
		return bTax;
	}

	public static double getiTax() {
		return iTax;
	}

	public static boolean isDebug() {
		return debug;
	}

	public static void setDebug(boolean debug) {
		SalesTaxJava.debug = debug;
	}
}