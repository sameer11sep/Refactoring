package com.xebia.xke.nopattern.sandwich;

import com.xebia.xke.model.BreadType;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class SandwichTest {

    @Test
    public void shouldCreateASandwichWithWhiteBreadAndCheese(){
        Sandwich sandwich=new Sandwich();
        sandwich.addCheese();
        sandwich.addBread(BreadType.WHITE);
        assertEquals(BigDecimal.valueOf(20),sandwich.getPrice());
        assertTrue(sandwich.getDescription().toLowerCase().contains("white"));
        assertTrue(sandwich.getDescription().toLowerCase().contains("cheese"));
    }

    @Test
    public void shouldCreateASandwichWithBrownBreadAndMeat(){
        Sandwich sandwich=new Sandwich();
        sandwich.addMeat();
        sandwich.addBread(BreadType.BROWN);
        assertEquals(BigDecimal.valueOf(40.0),sandwich.getPrice());
        assertTrue(sandwich.getDescription().toLowerCase().contains("brown"));
        assertTrue(sandwich.getDescription().toLowerCase().contains("meat"));
    }


}