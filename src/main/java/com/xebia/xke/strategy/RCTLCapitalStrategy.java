package com.xebia.xke.strategy;

/**
 * Created by sameerarora on 6/4/15.
 */
public class RCTLCapitalStrategy extends CapitalStrategy {

    @Override
    protected double calculateUnusedPercentage(Loan loan) {
        if (loan.getRating() > 4)
            return 0.75;
        else
            return 0.25;
    }
}
