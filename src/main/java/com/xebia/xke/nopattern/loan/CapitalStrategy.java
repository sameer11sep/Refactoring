package com.xebia.xke.nopattern.loan;

import com.xebia.xke.model.RiskFactor;

/**
 * Created by sameerarora on 6/4/15.
 */
public abstract class CapitalStrategy {

    protected static final int MILLIS_PER_DAY = 86400000;
    protected Loan loan;

    public double calculate(){
        return riskAmount(loan) * duration() * RiskFactor.forRiskRating(loan.getRating());
    }

    private double riskAmount(Loan loan) {
        if (calcUnusedPercentage() != 1.00)
            return loan.getOutstanding() + calcUnusedRiskAmount(loan);
        else
            return loan.getOutstanding();
    }


    private double calcUnusedRiskAmount(Loan loan) {
        return (loan.getNotional() - loan.getOutstanding()) * calcUnusedPercentage();
    }

    protected abstract double duration();

    protected abstract double calcUnusedPercentage();

}
