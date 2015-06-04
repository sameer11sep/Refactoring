package com.xebia.xke.nopattern.loan;

/**
 * Created by sameerarora on 6/5/15.
 */
public class CapitalStrategyFactory {


    public static CapitalStrategy getInstance(Loan loan) {
        if (loan.getMaturity() == null) {
            return new RevolverCapitalStrategy(loan);
        } else if (loan.getExpiry() == null) {
            return new TermLoanCapitalStrategy(loan);
        }
        return new RCTLCapitalStrategy(loan);
    }
}
