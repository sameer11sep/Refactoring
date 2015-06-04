package com.xebia.xke.strategy;

import com.xebia.xke.model.RiskFactor;

import java.util.Date;

public class Loan {
    private double notional;
    private double outstanding;
    private int rating;
    private Date start;
    private Date expiry;
    private Date maturity;
    private static final int MILLIS_PER_DAY = 86400000;
    private double unusedPercentage;

    public Loan(double notional, int rating, Date start, Date expiry, Date maturity) {
        this.notional = notional;
        this.rating = rating;
        this.start = start;
        this.expiry = expiry;
        this.maturity = maturity;
        setUnusedPercentage();
    }

    public double calculateCapital() {
        return riskAmount() * duration() * RiskFactor.forRiskRating(rating);
    }

    private double calcUnusedRiskAmount() {
        return (notional - outstanding) * unusedPercentage;
    }

    private double duration() {
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

    private double riskAmount() {
        if (unusedPercentage != 1.00)
            return outstanding + calcUnusedRiskAmount();
        else
            return outstanding;
    }

    public void setOutstanding(double newOutstanding) {
        outstanding = newOutstanding;
    }

    private void setUnusedPercentage() {
        if (expiry != null && maturity != null) {
            if (rating > 4)
                unusedPercentage = 0.95;
            else
                unusedPercentage = 0.50;
        } else if (maturity != null) {
            unusedPercentage = 1.00;
        } else if (expiry != null) {
            if (rating > 4)
                unusedPercentage = 0.75;
            else
                unusedPercentage = 0.25;
        }
    }
}
