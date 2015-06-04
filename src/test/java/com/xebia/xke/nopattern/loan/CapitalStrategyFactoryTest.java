package com.xebia.xke.nopattern.loan;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class CapitalStrategyFactoryTest {

    @Test
    public void shouldReturnRevolverStrategyIfMaturityIsNull() throws Exception{
        Loan loan=new Loan(0.5,5,date("2013-01-01"),date("2017-03-01"),null);
        CapitalStrategy capitalStrategy=CapitalStrategyFactory.getInstance(loan);
        assertTrue(capitalStrategy instanceof RevolverCapitalStrategy);
    }


    @Test
    public void shouldReturnTermLoanStrategyIfExpiryIsNull() throws Exception{
        Loan loan=new Loan(0.5,5,date("2013-01-01"),null,date("2017-03-01"));
        CapitalStrategy capitalStrategy=CapitalStrategyFactory.getInstance(loan);
        assertTrue(capitalStrategy instanceof TermLoanCapitalStrategy);
    }

    @Test
    public void shouldReturnRCTLStrategyIfAllDatesAreNotNull() throws Exception{
        Loan loan=new Loan(0.5,5,date("2013-01-01"),date("2017-03-01"),date("2016-03-01"));
        CapitalStrategy capitalStrategy=CapitalStrategyFactory.getInstance(loan);
        assertTrue(capitalStrategy instanceof RCTLCapitalStrategy);
    }

    private Date date(String dateStr) throws Exception{
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.parse(dateStr);
    }

}