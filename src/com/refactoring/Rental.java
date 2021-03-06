package com.refactoring;
//From book: 'Refactoring' by Martin Fowler
//This is the original code before refactoring begins

/**
 * The rental class represents a customer renting a movie.
 */
public class Rental {

	private Movie _movie;
	private int _daysRented;
	
	public Rental(Movie movie, int daysRented) {
		_movie = movie;
		_daysRented = daysRented;
	}

	public int getDaysRented() {
		return _daysRented;
	}

	public Movie getMovie() {
		return _movie;
	}

	public double getCharge() {
		return _movie._price.getCharge(_daysRented);
	}

	public int getFrequentRenterPoints() {
		return _movie.getFrequentRenterPoints(getDaysRented());
	}

	public String getTitle() {
		return _movie.getTitle();
	}
	
}
