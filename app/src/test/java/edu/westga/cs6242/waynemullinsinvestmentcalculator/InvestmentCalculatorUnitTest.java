package edu.westga.cs6242.waynemullinsinvestmentcalculator;

import org.junit.Test;

import static org.junit.Assert.*;
import edu.westga.cs6242.waynemullinsinvestmentcalculator.model.InvestmentCalculator;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class InvestmentCalculatorUnitTest {

    @Test
    public void testFutureValueWithValidParameters() {
        double P = 1000;
        double r = 2;   //2% per month or year
        int n = 5;        //5 months or years

        InvestmentCalculator calculator = new InvestmentCalculator();
        double value = calculator.calculateFutureValue(P, r, n);
        assertEquals(5204.04, value, 0.01);
    }


    @Test
    public void testFutureValueWithValidParametersUsingArguments() {
        double P = 1000;
        double r = 3;   //3% per year
        int n = 10;     //10 years

        InvestmentCalculator calculator = new InvestmentCalculator();
        double value = calculator.calculateFutureValue(P, r, n);
        assertEquals(11463.88, value, 0.01);
    }

    @Test
    public void testFutureValueWithRateOfZero() {
        double P = 1000;
        double r = 0;   //no rate
        int n = 7;   //years

        InvestmentCalculator calculator = new InvestmentCalculator();
        double value = calculator.calculateFutureValue(P, r, n);
        assertEquals(7000, value, 0.01);
    }

    @Test
    public void testFutureValueUsingSettersAndMembers()
    {
        double P = 1000;
        double r = 3;   //no rate
        int n = 10;     //years

        InvestmentCalculator calculator = new InvestmentCalculator();
        calculator.setPayment(P);
        calculator.setRate(r);
        calculator.setPeriods(n);
        double value = calculator.calculateFutureValue();
        assertEquals(11463.88, value, 0.01);
    }

}