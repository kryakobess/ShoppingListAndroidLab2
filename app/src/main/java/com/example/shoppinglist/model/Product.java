package com.example.shoppinglist.model;


public class Product {
    private String name;
    private boolean selected = false;

    public Product(String name) {
        this.name = name;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getName() {
        return name;
    }

    public boolean isSelected() {
        return selected;
    }
}
