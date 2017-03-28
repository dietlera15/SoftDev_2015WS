package at.fhj.swd;

public class OrderItem {
	private String articleNumber;
	private String articleName;
	private int price; // Preise immer in Integer angeben, da Floating Point Variablen Rundungsfehler haben
	private int quantity;
	
	public OrderItem(String articleNumber, String articleName, int price, int quantity) {
		if(articleName == null && articleName.isEmpty()) {
			throw new IllegalArgumentException("Invalid article name.");
		} if(articleNumber == null && articleNumber.isEmpty()) {
			throw new IllegalArgumentException("Invalid article number.");
		} if(price <= 0) {
			throw new IllegalArgumentException("Price must be positive.");
		} if(quantity <= 0) {
			throw new IllegalArgumentException("Quantity must be positive");
		}
		this.articleNumber = articleNumber;
		this.articleName = articleName;
		this.price = price;
		this.quantity = quantity;
	}
	public String getArticleNumber() {
		return articleNumber;
	}
	public String getArticleName() {
		return articleName;
	}
	public int getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}
}
