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

    private Movie pythonMovie = new RegularMovie("Monty Python and the Holy Grail");
	private Movie ranMovie = new RegularMovie("Ran");
	private Movie laMovie = new NewReleaseMovie("LA Confidential");
	private Movie trekMovie = new NewReleaseMovie("Star Trek 13.2");
	private Movie wallaceMovie = new ChildrenMovie("Wallace and Gromit");

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
        int i = 0;
        for (Rental rental : customer.getRentalList()){
            if (!rental.getMovie().getTitle().equals(laMovie.getTitle())) {
                i++;
            }else {
                break;
            }
        }
        System.out.println(i);
        customer.getRentalList().remove(i);
        customer.getRentalList().add(i, new Rental(new RegularMovie(laMovie.getTitle()), 2));
        verifyOutput(customer.statement(), "outputChange");
    }

    protected void verifyOutput(String actualValue, String fileName) throws IOException{
        String filePath = getClass().getClassLoader().getResource(GOLD_PATH + fileName).getPath();
        BufferedReader file = new BufferedReader (new FileReader (filePath));
        BufferedReader actualStream = new BufferedReader (new StringReader (actualValue));
        String thisFileLine;
        StringBuilder result = new StringBuilder();
        while  ((thisFileLine = file.readLine()) != null) {
            result.append(thisFileLine);
            assertThat("in file: " + fileName, actualStream.readLine(), equalTo(thisFileLine));
        }
    }

}
