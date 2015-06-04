package com.xebia.xke.strategy;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class LoanTest {

    @Test
    public void shouldCalculateCapitalForARevolverLoan() throws Exception{
        Loan loan = new Loan(5.5, 5, date("2012-01-01"), date("2017-12-31"), null,new RevolverCapitalStrategy());
        loan.setOutstanding(1.0);
        assertEquals(27.0, loan.calculateCapital(), 0.01);
    }


    @Test
    public void shouldCalculateCapitalForAnRCTLLoan() throws Exception{
        Loan loan = new Loan(5.5, 5, date("2012-01-01"), date("2017-12-31"), date("2015-12-31"),new RCTLCapitalStrategy());
        loan.setOutstanding(1.0);
        assertEquals(78.75, loan.calculateCapital(), 0.05);
    }

    @Test
    public void shouldCalculateCapitalForATermLoan() throws Exception{
        Loan loan = new Loan(5.5, 5, date("2012-01-01"), null,date("2015-12-31"),new TermLoanCapitalStrategy());
        loan.setOutstanding(1.0);
        assertEquals(94.95, loan.calculateCapital(), 0.05);
    }

    private Date date(String dateStr) throws Exception{
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.parse(dateStr);
    }


}