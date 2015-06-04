package com.xebia.xke.decorator;

import java.math.BigDecimal;

/**
 * Created by sameerarora on 6/4/15.
 */
public class WhiteBreadDecorator extends AbstractSandwich {

    AbstractSandwich sandwich;

    public WhiteBreadDecorator(AbstractSandwich sandwich) {
        this.sandwich = sandwich;
    }

    @Override
    public BigDecimal getPrice() {
        return sandwich.getPrice().add(BigDecimal.TEN);
    }

    @Override
    public String getDescription() {
        return sandwich.getDescription()+" White Bread";
    }
}
