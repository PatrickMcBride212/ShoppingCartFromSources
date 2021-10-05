package com.cognizant.tdd;

import java.util.*;

public class ShoppingCart {
    private double subtotal;
    private final Map<String,Item> items;

    public ShoppingCart() {
        this.items = new HashMap<>();
        subtotal = 0;
    }

    public int totalItems(){
        return items.size();
    }

    public double getSubtotal() {
        return subtotal;
    }

    public Map<String, Item> getItems() {
        return items;
    }

    public int getItemQuantity(String name) {
        if (getItems().containsKey(name)) {
            return getItems().get(name).getCountOfItem();
        } else {
            return 0;
        }
    }

    public void viewItems() {
        LinkedList<Item> itemLinkedList = new LinkedList<>(items.values());

        for (Item currentItem : itemLinkedList) {
            System.out.printf("Item: %s\n", currentItem.getItemName());
            System.out.printf("Price: %.2f\n", currentItem.getValue());
            System.out.printf("Quantity: %d\n", currentItem.getCountOfItem());
            if (currentItem.isOnSale()) {
                System.out.println("This item is on sale!");
            }
            System.out.println("=====\n");
        }

        System.out.printf("Subtotal: %.2f\n", subtotal);
    }

    public void addItem(Item item) {
        String name = item.getItemName();
        if (items.containsKey(name) && items.get(name).equals(item)) {
            int count = item.getCountOfItem() + items.get(name).getCountOfItem();
            items.get(name).setCountOfItem(count);
        } else {
            items.put(name, item);
        }
        subtotal += item.getCountOfItem() * item.getValue();
    }

    public void removeItem(String name, int count) {
        if (items.containsKey(name)) {
            int currentCount = items.get(name).getCountOfItem();

            if (currentCount <= count) {
                subtotal -= items.get(name).getValue() * currentCount;
                items.remove(name);
                System.out.printf("Removed %s\n", name);
            } else {
                currentCount = currentCount - count;
                subtotal -= items.get(name).getValue() * count;
                items.get(name).setCountOfItem(currentCount);
            }
        }
    }

    public void editQuantity(String name, int count) {
        if (items.containsKey(name)) {
            int currentCount = items.get(name).getCountOfItem();
            subtotal -= items.get(name).getValue() * currentCount;
            items.get(name).setCountOfItem(count);
            subtotal += items.get(name).getValue() * count;
        }
    }
}