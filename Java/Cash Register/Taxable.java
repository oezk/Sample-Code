import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Taxable {

	private boolean debug;
	private ArrayList<String> taxable = new ArrayList<>();

	public Taxable(boolean debug) {

		setDebug(debug);
		Collections.addAll(taxable, "book", "chocolate", "chocolates", "headache");
		load();

		if (isDebug()) {
			printExempt();
		}

	}

	// Returns true if product name is included in taxable list
	public boolean checkTaxable(String prod) {

		for (String p : prod.split(" ")) {
			p = p.toLowerCase();
			if (taxable.contains(p)) {
				return true;
			}
		}
		return false;
	}

	// Returns true if product name includes "imported"
	public boolean checkImported(String prod) {

		for (String p : prod.split(" ")) {
			if (p.equalsIgnoreCase("imported")) {
				return true;
			}
		}
		return false;
	}

	void printExempt() {

		System.out.println("Tax Exempt Products: " + taxable);
	}

	// Loads a list of tax exempt keywords
	public void load() {

		String line;
		try (BufferedReader br = new BufferedReader(new FileReader("taxexempt.txt"))) {

			while ((line = br.readLine()) != null) {
				taxable.add(line.toLowerCase());
			}
		} catch (IOException e) {
			e.printStackTrace();

		}

		if (isDebug()) {
			System.out.println("Taxable list loaded!");
		}

	}

	// Getters & Setters

	public boolean isDebug() {
		return debug;
	}

	public void setDebug(boolean debug) {
		this.debug = debug;
	}

}