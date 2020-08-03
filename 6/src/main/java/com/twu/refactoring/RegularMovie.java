package com.twu.refactoring;

public class RegularMovie extends Movie{
    public RegularMovie(String title) {
        super(title, Movie.REGULAR);
    }

    @Override
    public double calculateAmount() {
        return 0;
    }
}
