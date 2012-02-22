package com.refactoring;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//From book: 'Refactoring' by Martin Fowler
//This is the original code before refactoring begins

public class Customer {

	private String _name;
	private List<Rental> _rentals = new ArrayList<Rental>();
	
	public Customer(String name) {
		_name = name;
	}
	
	public void addRental(Rental arg) {
		_rentals.add(arg);
	}
	
	public String getName() {
		return _name;
	}
	
	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Iterator<Rental> rentals = _rentals.iterator();
		String result = "Rental Record for " + getName() + "\n";
		
		while (rentals.hasNext()) {
			
			Rental each = rentals.next();
			
			int frequentRenterPointsForRental = getFrequentRenterPoints(each);
			
			frequentRenterPoints += frequentRenterPointsForRental;
			
			
			// show figures for this rental
			result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
			totalAmount += each.getCharge();
		}
		
		// add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
		
		return result;
	}

	private int getFrequentRenterPoints(Rental each) {
		// add frequent renter points
		int frequentRenterPointsForRental = 0;
		frequentRenterPointsForRental++;
		// add bonus for a two day new release rental
		if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1) 
			frequentRenterPointsForRental++;
		return frequentRenterPointsForRental;
	}
}
