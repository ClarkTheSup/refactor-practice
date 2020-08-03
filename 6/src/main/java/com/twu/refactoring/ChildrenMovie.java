package com.twu.refactoring;

public class ChildrenMovie extends Movie{
    public ChildrenMovie(String title) {
        super(title, Movie.CHILDRENS);
    }

    @Override
    public double calculateAmount() {
        return 0;
    }
}
