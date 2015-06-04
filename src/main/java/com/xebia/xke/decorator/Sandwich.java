package com.xebia.xke.decorator;

import com.xebia.xke.model.BreadType;

import java.math.BigDecimal;

/**
 * Created by sameerarora on 6/4/15.
 */
public class Sandwich extends AbstractSandwich {

    private final BreadType bread;

    public Sandwich(BreadType bread) {
        this.bread=bread;
    }

    @Override
    public BigDecimal getPrice() {
        return bread.getPrice();
    }
}
