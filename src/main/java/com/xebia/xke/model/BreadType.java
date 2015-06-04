package com.xebia.xke.model;

import java.math.BigDecimal;

/**
 * Created by sameerarora on 6/4/15.
 */
public enum BreadType {
    WHITE {
        @Override
        public BigDecimal getPrice() {
            return BigDecimal.TEN;
        }
    },BROWN {
        @Override
        public BigDecimal getPrice() {
            return BigDecimal.valueOf(15.0);
        }
    },OREGANO {
        @Override
        public BigDecimal getPrice() {
            return BigDecimal.valueOf(20.0);
        }
    };

    public abstract BigDecimal getPrice() ;
}
