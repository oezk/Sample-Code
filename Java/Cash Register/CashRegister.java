import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CashRegister {

	private double bTax;
	private double iTax;
	private boolean debug;
	ArrayList<Product> products = new ArrayList<Product>();
	Taxable tx;

	public CashRegister(double bTax, double iTax, boolean debug) {
		setbTax(bTax);
		setiTax(iTax);
		setDebug(debug);
		tx = new Taxable(debug);
	}

	public void run() {
		scanItems();
		printReceipt();
	}

	public void scanItems() {

		/*
		 * Regex used extract the quantity, product name, and price from
		 * order.txt.
		 */
		String line;
		String regex = "(-?[0-9]+)\\s(.+)\\sat\\s([0-9]+\\.[0-9]{2})";
		Pattern r = Pattern.compile(regex);

		try (BufferedReader br = new BufferedReader(new FileReader("order.txt"))) {

			while ((line = br.readLine()) != null) {

				Matcher m = r.matcher(line);
				if (m.find()) {

					if (debug()) {
						System.out.println("Quanity: " + m.group(1));
						System.out.println("Product: " + m.group(2));
						System.out.println("Price: " + m.group(3));
						System.out.println();
					}

					// No quantity that is 0, negative, or greater than 100
					if (Integer.parseInt(m.group(1)) < 1) {
						System.out.println("Unable to scan: " + line);
					}

					else if (Integer.parseInt(m.group(1)) > 99) {
						System.out.println("Unable to scan: " + line);
					}

					else {
						// Adds a new product to a vector of products
						products.add(
								new Product(Integer.parseInt(m.group(1)), m.group(2), Double.parseDouble(m.group(3))));
					}

				}

			}
		} catch (IOException e) {
			e.printStackTrace();

		}

		markTaxable();
	}

	/*
	 * Marks products scanned as basic and/or import taxable if the product name
	 * has the keyword "imported" or if it doesn't have book, food, or medical
	 * product keywords
	 */
	private void markTaxable() {

		for (int i = 0; i < products.size(); i++) {

			products.get(i).setTaxExempt(tx.checkTaxable(products.get(i).getName()));
			products.get(i).setImported(tx.checkImported(products.get(i).getName()));

			if (debug()) {
				System.out.println(products.get(i).getName());
				System.out.println("Tax Exempt: " + products.get(i).isTaxExempt());
				System.out.println("Imported: " + products.get(i).isImported() + "\n");
			}
		}
	}

	// Prints each item with its price, tax total and sub-total.
	public void printReceipt() {

		double tax = 0;
		double total = 0;
		DecimalFormat df = new DecimalFormat("0.00");

		System.out.println();
		for (int i = 0; i < products.size(); i++) {
			System.out.println(products.get(i).getQuanity() + " " + products.get(i).getName() + ": "
					+ df.format(products.get(i).getPrice() * products.get(i).getQuanity()));
			tax += computeTax(products.get(i));
			total += (products.get(i).getPrice() * products.get(i).getQuanity());
		}

		tax = roundUp(tax);
		total += tax;
		System.out.println("Sales Tax: " + df.format(tax));
		System.out.println("Total: " + df.format(total));

	}

	// Rounds tax up to the upper 0.05
	private double roundUp(double tax) {

		DecimalFormat df = new DecimalFormat("0.00");
		df.setRoundingMode(RoundingMode.CEILING);
		tax = Double.parseDouble(df.format(tax));

		// Gets the last digit of tax
		int cents = Integer.parseInt(df.format(tax).substring(df.format(tax).length() - 1));

		if (cents == 0) {
			return tax;
		}

		else if (cents <= 5) {
			cents = 5 - cents;
			tax += (cents * 0.01);
		}

		else {
			cents = 10 - cents;
			tax += (cents * 0.01);
		}

		return tax;

	}

	// Computes tax on a single product
	private double computeTax(Product product) {

		double pTax = 0;

		if (product.isImported()) {
			pTax += product.getPrice() * iTax;
		}
		if (!product.isTaxExempt()) {
			pTax += product.getPrice() * bTax;
		}

		if (debug()) {
			System.out.println("Tax on " + product.getName() + ": " + pTax + "\n");
		}

		pTax = pTax * product.getQuanity();

		return pTax;
	}

	// Getters & Setters

	public boolean debug() {
		return debug;
	}

	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	public void setbTax(double bTax) {
		this.bTax = bTax;
	}

	public void setiTax(double iTax) {
		this.iTax = iTax;
	}
}