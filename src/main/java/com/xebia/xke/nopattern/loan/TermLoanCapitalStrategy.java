package com.xebia.xke.nopattern.loan;

/**
 * Created by sameerarora on 6/4/15.
 */
public class TermLoanCapitalStrategy extends CapitalStrategy {
    public TermLoanCapitalStrategy(Loan loan) {
        this.loan=loan;
    }

    @Override
    protected double calcUnusedPercentage() {
        if (loan.getRating() > 4)
            return 0.95;
        else
            return 0.50;
    }

    protected double duration() {
        return ((loan.getMaturity().getTime() - loan.getStart().getTime()) / MILLIS_PER_DAY) / 365;
    }
}
