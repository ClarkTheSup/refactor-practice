package com.twu.refactoring;

import java.util.ArrayList;
import java.util.Iterator;

public class Customer {

	private String name;

	public ArrayList<Rental> getRentalList() {
		return rentalList;
	}

	public void setRentalList(ArrayList<Rental> rentalList) {
		this.rentalList = rentalList;
	}

	private ArrayList<Rental> rentalList = new ArrayList<Rental>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental rental) {
		rentalList.add(rental);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Iterator<Rental> rentals = rentalList.iterator();
		String result = "Rental Record for " + getName() + "\n";
		while (rentals.hasNext()) {
			Rental each = rentals.next();
			Movie movie = each.getMovie();
			int daysRented = each.getDaysRented();
			double thisAmount = movie.calculateAmount(daysRented);

			frequentRenterPoints++;
			if ((movie.getPriceCode() == Movie.NEW_RELEASE)
					&& daysRented > 1)
				frequentRenterPoints++;

			result += "\t" + movie.getTitle() + "\t"
					+ String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
		}
		// add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints)
				+ " frequent renter points";
		return result;
	}

}
