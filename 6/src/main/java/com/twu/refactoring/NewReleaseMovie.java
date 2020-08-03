package com.twu.refactoring;

public class NewReleaseMovie extends Movie{
    public NewReleaseMovie(String title) {
        super(title, Movie.NEW_RELEASE);
    }

    @Override
    public double calculateAmount(int daysRented) {
        return daysRented * 3;
    }
}
