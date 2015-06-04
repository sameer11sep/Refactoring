package com.xebia.xke.nopattern.loan;

import java.util.Date;

public class Loan {

    private double notional;
    private double outstanding;
    private int rating;
    private Date start;
    private Date expiry;
    private Date maturity;


    public Loan(double notional, int rating, Date start, Date expiry, Date maturity) {
        this.notional = notional;
        this.rating = rating;
        this.start = start;
        this.expiry = expiry;
        this.maturity = maturity;
    }

    public double calculateCapital() {
        CapitalStrategy capitalStrategy = CapitalStrategyFactory.getInstance(this);
        return capitalStrategy.calculate();
    }

    public void setOutstanding(double newOutstanding) {
        outstanding = newOutstanding;
    }


    public int getRating() {
        return rating;
    }

    public double getNotional() {
        return notional;
    }

    public double getOutstanding() {
        return outstanding;
    }

    public Date getStart() {
        return start;
    }

    public Date getExpiry() {
        return expiry;
    }

    public Date getMaturity() {
        return maturity;
    }
}