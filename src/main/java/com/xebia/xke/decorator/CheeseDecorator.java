package com.xebia.xke.decorator;

import java.math.BigDecimal;

/**
 * Created by sameerarora on 6/4/15.
 */
public class CheeseDecorator extends AbstractSandwich {
    AbstractSandwich sandwich;

    public CheeseDecorator(AbstractSandwich sandwich) {
        this.sandwich = sandwich;
    }

    @Override
    public BigDecimal getPrice() {
        return sandwich.getPrice().add(BigDecimal.valueOf(20.0));
    }

    @Override
    public String getDescription() {
        return sandwich.getDescription() + " Cheese";
    }
}
