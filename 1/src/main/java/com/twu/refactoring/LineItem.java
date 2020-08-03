package com.twu.refactoring;

public class LineItem {
	private String description;
	private double price;
	private int quantity;

	public LineItem(String description, double price, int quantity) {
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return getDescription() + '\t' +
				getPrice() + '\t' +
				getQuantity() + '\t' +
				totalAmount() + '\n';
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	double totalAmount() {
        return price * quantity;
    }
}