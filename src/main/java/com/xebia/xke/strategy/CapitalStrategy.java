package com.xebia.xke.strategy;

import com.xebia.xke.model.RiskFactor;

/**
 * Created by sameerarora on 6/4/15.
 */
public abstract class CapitalStrategy {

    public double calculate(Loan loan){
        return riskAmount(loan) * loan.duration() * RiskFactor.forRiskRating(loan.getRating());
    }

    public double riskAmount(Loan loan) {
        if (calculateUnusedPercentage(loan) != 1.00)
            return loan.getOutstanding() + calcUnusedRiskAmount(loan);
        else
            return loan.getOutstanding();
    }

    private double calcUnusedRiskAmount(Loan loan) {
        return (loan.getNotional() - loan.getOutstanding()) * calculateUnusedPercentage(loan);
    }

    protected abstract double calculateUnusedPercentage(Loan loan);
}
