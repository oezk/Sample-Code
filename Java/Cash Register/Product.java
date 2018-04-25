public class Product {

	private String name;
	private int quanity;
	private double price;
	private boolean taxExempt = false;
	private boolean isImported = false;

	public Product(int quanity, String name, double price) {
		setQuanity(quanity);
		setName(name);
		setPrice(price);
	}

	// Getters & Setters

	public boolean isTaxExempt() {
		return taxExempt;
	}

	public void setTaxExempt(boolean taxExempt) {
		this.taxExempt = taxExempt;
	}

	public boolean isImported() {
		return isImported;
	}

	public void setImported(boolean isImported) {
		this.isImported = isImported;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuanity() {
		return quanity;
	}

	public void setQuanity(int quanity) {
		this.quanity = quanity;
	}
}
