package com.cognizant.tdd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {

    Map<String,Item> items = new HashMap<>();
    public int totalItems(){
        return items.size();
    }


}