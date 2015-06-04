package com.xebia.xke.nopattern.sandwich;

import com.xebia.xke.model.BreadType;

import java.math.BigDecimal;

/**
 * Created by sameerarora on 6/4/15.
 */
public class Sandwich {

    private boolean hasCheese = false;
    private BreadType bread;
    private boolean hasMeat = false;

    public void addBread(BreadType bread) {
        this.bread = bread;
    }

    public void addCheese() {
        hasCheese = true;
    }

    public void addMeat() {
        hasMeat = true;
    }

    public BigDecimal getPrice() {
        BigDecimal price = new BigDecimal(0.0);
        price = price.add(bread.getPrice());
        if (hasCheese) {
            price = price.add(BigDecimal.TEN);
        }
        if(hasMeat){
            price= price.add(BigDecimal.valueOf(25.0));
        }
        return price;
    }

    public String getDescription() {
        String description = "Sandwich with " + bread.name().toLowerCase() + " Bread";
        if (hasCheese) {
            description += " and Cheese";
        }
        if(hasMeat){
            description +=" and Meat";
        }
        return description;
    }
}
