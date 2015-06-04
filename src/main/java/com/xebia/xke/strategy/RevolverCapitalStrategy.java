package com.xebia.xke.strategy;

/**
 * Created by sameerarora on 6/4/15.
 */
public class RevolverCapitalStrategy extends CapitalStrategy{
    @Override
    protected double calculateUnusedPercentage(Loan loan) {
        return 1.00;
    }
}
