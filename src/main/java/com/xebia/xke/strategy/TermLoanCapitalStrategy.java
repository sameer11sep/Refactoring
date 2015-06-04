package com.xebia.xke.strategy;

/**
 * Created by sameerarora on 6/4/15.
 */
public class TermLoanCapitalStrategy extends CapitalStrategy {

    @Override
    protected double calculateUnusedPercentage(Loan loan) {
        if (loan.getRating() > 4)
            return 0.95;
        else
            return 0.50;

    }
}
