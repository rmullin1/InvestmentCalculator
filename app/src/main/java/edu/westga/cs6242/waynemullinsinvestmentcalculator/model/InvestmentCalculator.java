package edu.westga.cs6242.waynemullinsinvestmentcalculator.model;

//Class InvestmentCalculator / Model
public class InvestmentCalculator {

    private double payment;
    private double rate;  //as decimal
    private int periods;
    private double futureValue;

    public InvestmentCalculator() {
        payment = 0;
        rate = 0;
        periods = 0;
        futureValue = 0;
    }//constructor

    //setters
    public void setPayment(double value) {
        payment = value;
    }//setPayment

    public void setRate(double value) {
        rate = value;
    }//setRate()

    public void setPeriods(int value) {
        periods = value;
    }//setPeriods

    // CalculateFutureValue()
    //    Local version, acts on members
    //    Standard financial formula:
    // @param P is the Periodic Payment
    // @param r is the rate per period in percent (%)
    // @param n is the number of periods
    public double calculateFutureValue() {
        this.futureValue = calculateFutureValue(this.payment, this.rate, this.periods);
        return this.futureValue;
    }//calculateFutureValue()

    // CalculateFutureValue(double, double, int)
    //    Standard financial formula:
    // @param P is the Periodic Payment
    // @param r is the rate per period in percent (%)
    // @param n is the number of periods
    // Public for Testing
    public double calculateFutureValue(double P, double r, int n) {
        double FV;
        if ( r == 0 ) {
            FV = P * n;
        } else {
            r = r/100; //convert % to decimal for formula
            FV = P * ((Math.pow(1 + r, n) - 1)/r);
        }
        return Math.round(FV * 100)/100D;
    }//calculateFutureValue()
}//class
