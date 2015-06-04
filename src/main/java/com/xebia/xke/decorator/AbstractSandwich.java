package com.xebia.xke.decorator;

import java.math.BigDecimal;

/**
 * Created by sameerarora on 6/4/15.
 */
public abstract class AbstractSandwich {

    public abstract BigDecimal getPrice();

    public String getDescription() {
        return  "Sandwich with ";
    }
}
