package com.refactoring;

public abstract class Price {
	public abstract int getPriceCode();

	public abstract double getCharge(int daysRented);

	public int getFrequentRenterPoints(int daysRented) {
		if (getPriceCode() == Movie.NEW_RELEASE) 
			return (daysRented > 1) ? 2 : 1;
		
		return 1;
	}
}

