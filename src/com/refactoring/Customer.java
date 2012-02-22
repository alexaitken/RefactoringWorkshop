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
		
		int frequentRenterPoints = 0;
		
		String result = "Rental Record for " + getName() + "\n";
		
		double totalAmount = 0;
		Iterator<Rental> rentals = _rentals.iterator();
		while (rentals.hasNext()) {
			Rental each = rentals.next();
			
			frequentRenterPoints += each.getFrequentRenterPoints();
			
			// show figures for this rental
			result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
			totalAmount += each.getCharge();
		}
		
		// add footer lines
		result += "Amount owed is " + String.valueOf(totalCharge()) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
		
		return result;
	}
	
	private double totalCharge() {
		double result = 0;
		for (Rental each : _rentals) {
			result += each.getCharge();
		}
		return result;
	}
	
}
