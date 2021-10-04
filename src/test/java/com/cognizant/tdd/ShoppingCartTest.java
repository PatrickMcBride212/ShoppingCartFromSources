package com.cognizant.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {
    ShoppingCart sc;

    @BeforeEach
    public void setUp(){
       sc = new ShoppingCart();
    }
    @Test
    public void testIsEmpty(){
        assertEquals(0,sc.totalItems());
    }
    @Test
    public void testAddItemViewCartAndRemoveItem() {
        Item tofu = new Item("Tofu", 5.99, 1, false);
        Item sushi = new Item("Sushi", 10.99, 2, true);
        Item tofu2 = new Item("Tofu", 5.99, 2, false);

        double runningTotal = 0;

        sc.addItem(tofu);
        runningTotal += 5.99;
        assertEquals(runningTotal, sc.getSubtotal());

        sc.addItem(sushi);
        runningTotal += (10.99 * 2);
        assertEquals(runningTotal, sc.getSubtotal());

        sc.addItem(tofu2);
        runningTotal += (5.99 * 2);
        assertEquals(runningTotal, sc.getSubtotal());

        sc.viewItems();

        sc.removeItem("Tofu", 1);
        sc.removeItem("Sushi", 4);
        assertEquals(2, sc.getItems().get("Tofu").getCountOfItem());
        assertFalse(sc.getItems().containsKey("Sushi"));
        assertEquals(1, sc.totalItems());

        sc.viewItems();
        assertEquals(11.98, sc.getSubtotal());
    }

}
