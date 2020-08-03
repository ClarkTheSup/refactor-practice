package com.twu.refactoring;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class CustomerTest {


	private static final String GOLD_PATH = "data/";

    private Customer customer = new Customer("Dinsdale Pirhana");

    private Movie pythonMovie = new Movie("Monty Python and the Holy Grail", Movie.REGULAR);
	private Movie ranMovie = new Movie("Ran", Movie.REGULAR);
	private Movie laMovie = new Movie("LA Confidential", Movie.NEW_RELEASE);
	private Movie trekMovie = new Movie("Star Trek 13.2", Movie.NEW_RELEASE);
	private Movie wallaceMovie = new Movie("Wallace and Gromit", Movie.CHILDRENS);

    @Before
    public void setUpData(){
       customer.addRental(new Rental (pythonMovie, 3));
       customer.addRental(new Rental (ranMovie, 1));
       customer.addRental(new Rental (laMovie, 2));
       customer.addRental(new Rental (trekMovie, 1));
       customer.addRental(new Rental (wallaceMovie, 6));
   }

    @Test
    public void shouldOutputEmptyStatement() throws Exception {
        Customer customer = new Customer("Golden Shark");
        verifyOutput(customer.statement(), "outputEmpty");
    }

    @Test
    public void shouldOutputCustomerStatement() throws Exception {
        verifyOutput(customer.statement(), "output1");
    }

    @Test
    public void shouldOutputChangedStatement() throws Exception {
        laMovie.setPriceCode(Movie.REGULAR);
        verifyOutput(customer.statement(), "outputChange");
    }

    protected void verifyOutput(String actualValue, String fileName) throws IOException{
        String filePath = getClass().getClassLoader().getResource(GOLD_PATH + fileName).getPath();
        BufferedReader file = new BufferedReader (new FileReader (filePath));
        BufferedReader actualStream = new BufferedReader (new StringReader (actualValue));
        String thisFileLine;
        while  ((thisFileLine = file.readLine()) != null) {
            assertThat("in file: " + fileName, actualStream.readLine(), equalTo(thisFileLine));
        }
    }

}
