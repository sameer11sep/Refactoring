package com.xebia.xke.nopattern.loan;

/**
 * Created by sameerarora on 6/4/15.
 */
public class RCTLCapitalStrategy extends CapitalStrategy{

    public RCTLCapitalStrategy(Loan loan) {
        this.loan=loan;
    }

    @Override
    protected double calcUnusedPercentage() {
        if (loan.getRating() > 4)
            return 0.75;
        else
            return 0.25;
    }

    protected double duration(){
        long millisToExpiry = loan.getExpiry().getTime() - loan.getStart().getTime();
        long millisFromExpiryToMaturity = loan.getMaturity().getTime() - loan.getExpiry().getTime();
        double revolverDuration = (millisToExpiry / MILLIS_PER_DAY) / 365;
        double termDuration = (millisFromExpiryToMaturity / MILLIS_PER_DAY) / 365;
        return revolverDuration + termDuration;
    }


}
