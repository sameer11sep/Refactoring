package com.xebia.xke.nopattern.loan;

/**
 * Created by sameerarora on 6/4/15.
 */
public class RevolverCapitalStrategy extends CapitalStrategy{
    public RevolverCapitalStrategy(Loan loan) {
        this.loan=loan;
    }

    @Override
    protected double calcUnusedPercentage() {
        return  1.00;
    }

    protected double duration(){
        return ((loan.getExpiry().getTime() - loan.getStart().getTime()) / MILLIS_PER_DAY) / 365;
    }
}
