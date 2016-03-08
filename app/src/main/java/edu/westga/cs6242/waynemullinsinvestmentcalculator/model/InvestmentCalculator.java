package edu.westga.cs6242.waynemullinsinvestmentcalculator.model;

//Class InvestmentCalculator
public class InvestmentCalculator {
    // CalculateFutureValue()
    //    Standard financial formula:
    // @param P is the Periodic Payment
    // @param r is the rate per period
    // @param n is the number of periods
    public double calculateFutureValue(double P, double r, int n) {
        double FV;
        if ( r == 0 ) {
            FV = P * n;
        } else {
            FV = P * ((Math.pow(1 + r, n) - 1)/r);
        }
        return Math.round(FV * 100)/100D;
    }//calculateFutuerValue()
}//class
