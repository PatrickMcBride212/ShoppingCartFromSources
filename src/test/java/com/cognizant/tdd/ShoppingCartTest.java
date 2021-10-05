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
    public void addItemSubtotalCheck() {
        Item tofu = new Item("Tofu", 5.99, 1, false);
        sc.addItem(tofu);
        assertEquals(5.99, sc.getSubtotal());
    }

    @Test
    public void addMultipleItemsSubtotalCheck() {
        Item tofu = new Item("Tofu", 5.99, 1, false);
        Item sushi = new Item("Sushi", 10.99, 2, false);
        sc.addItem(tofu);
        assertEquals(5.99, sc.getSubtotal());
        sc.addItem(sushi);
        assertEquals(27.97, sc.getSubtotal());
        assertEquals(1, sc.getItemQuantity("Tofu"));
        assertEquals(2, sc.getItemQuantity("Sushi"));
    }

    @Test
    public void quantityUpdateTest() {
        Item tofu = new Item("Tofu", 5.99, 1, false);
        Item tofu2 = new Item("Tofu", 5.99, 1, false);
        sc.addItem(tofu);
        sc.addItem(tofu2);
        assertEquals(11.98, sc.getSubtotal());
        assertEquals(2, sc.getItemQuantity("Tofu"));
    }

    @Test
    public void removeQuantityUpdate() {
        Item sushi = new Item("Sushi", 10.99, 3, false);
        sc.addItem(sushi);
        assertEquals(32.97, sc.getSubtotal());
        assertEquals(3, sc.getItemQuantity("Sushi"));

        sc.removeItem("Sushi", 1);
        assertEquals(21.98, sc.getSubtotal(), 0.001);
        assertEquals(2, sc.getItemQuantity("Sushi"));
    }

    @Test
    public void adjustQuantityTest() {
        Item tofu = new Item("Tofu", 5.99, 1, false);
        Item sushi = new Item("Sushi", 10.99, 2, true);

        sc.addItem(tofu);
        assertEquals(5.99, sc.getSubtotal());
        assertEquals(1, sc.getItemQuantity("Tofu"));

        sc.addItem(sushi);
        assertEquals(27.97, sc.getSubtotal());
        assertEquals(2, sc.getItemQuantity("Sushi"));

        sc.editQuantity("Sushi", 4);
        assertEquals(49.95, sc.getSubtotal());
        assertEquals(4, sc.getItemQuantity("Sushi"));
    }

    @Test
    public void itemizedListTest() {
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
