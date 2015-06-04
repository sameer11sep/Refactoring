package com.xebia.xke.strategy;

import com.xebia.xke.model.RiskFactor;

import java.util.Date;

public class Loan {
    private final CapitalStrategy capitalStrategy;
    private double notional;
    private double outstanding;
    private int rating;
    private Date start;
    private Date expiry;
    private Date maturity;

    private static final int MILLIS_PER_DAY = 86400000;

    public Loan(double notional, int rating, Date start, Date expiry, Date maturity,CapitalStrategy strategy) {
        this.notional = notional;
        this.rating = rating;
        this.start = start;
        this.expiry = expiry;
        this.maturity = maturity;
        this.capitalStrategy=strategy;
    }

    public double calculateCapital() {
        return capitalStrategy.calculate(this);
    }


    public double duration() {
        if (expiry == null)
            return ((maturity.getTime() - start.getTime()) / MILLIS_PER_DAY) / 365;
        else if (maturity == null)
            return ((expiry.getTime() - start.getTime()) / MILLIS_PER_DAY) / 365;
        else {
            long millisToExpiry = expiry.getTime() - start.getTime();
            long millisFromExpiryToMaturity = maturity.getTime() - expiry.getTime();
            double revolverDuration = (millisToExpiry / MILLIS_PER_DAY) / 365;
            double termDuration = (millisFromExpiryToMaturity / MILLIS_PER_DAY) / 365;
            return revolverDuration + termDuration;
        }
    }


    public void setOutstanding(double newOutstanding) {
        outstanding = newOutstanding;
    }


    public int getRating() {
        return rating;
    }

    public Date getMaturity() {
        return maturity;
    }

    public Date getExpiry() {
        return expiry;
    }

    public double getOutstanding() {
        return outstanding;
    }

    public double getNotional() {
        return notional;
    }
}