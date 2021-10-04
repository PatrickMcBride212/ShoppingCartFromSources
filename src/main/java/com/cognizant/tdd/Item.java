package com.cognizant.tdd;

public class Item {

    private String itemName;
    private double value;
    private int countOfItem;

    public boolean isOnSale() {
        return onSale;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    private boolean onSale;
    public Item(){}
    public Item(String itemName, double value, int countOfItem) {
        this.itemName = itemName;
        this.value = value;
        this.countOfItem = countOfItem;

    }
    public Item(String itemName, double value, int countOfItem, boolean onSale) {
        this.itemName = itemName;
        this.value = value;
        this.countOfItem = countOfItem;
        this.onSale = onSale;

    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getCountOfItem() {
        return countOfItem;
    }

    public void setCountOfItem(int countOfItem) {
        this.countOfItem = countOfItem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Double.compare(item.value, value) == 0
                && onSale == item.onSale
                && itemName == item.itemName;
    }


}
