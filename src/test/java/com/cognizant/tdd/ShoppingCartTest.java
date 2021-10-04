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

}
