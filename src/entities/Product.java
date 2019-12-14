package entities;

public class Product {
	private String name;
	private double value;
	private int quantity;
	
	public Product(String name, double value, int quantity) {
		this.name = name;
		this.value = value;
		this.quantity = quantity;
	};
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	private double valueTotal() {
		return value * quantity;
	}
	
	@Override
	public String toString() {
		return name + "," + String.format("%.2f", valueTotal());
	}
	
}
