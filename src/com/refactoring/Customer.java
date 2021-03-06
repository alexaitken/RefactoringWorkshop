package com.refactoring;

import java.util.ArrayList;
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
		String result = "Rental Record for " + getName() + "\n";
		
		for (Rental each : _rentals) {
			// show figures for this rental
			result += "\t" + each.getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
		}
		
		// add footer lines
		result += "Amount owed is " + String.valueOf(totalCharge()) + "\n";
		result += "You earned " + String.valueOf(totalFrequentRenterPoints()) + " frequent renter points";
		
		return result;
	}
	
	private int totalFrequentRenterPoints() {
		int result = 0;
		
		for (Rental each : _rentals) {
			result += each.getFrequentRenterPoints();
		}
		
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
