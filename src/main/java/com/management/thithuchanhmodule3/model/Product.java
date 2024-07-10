package com.management.thithuchanhmodule3.model;

public class Product {

    private int productId;
    private String productName;
    private int productPrice;
    private int discount;
    private int inventory;

    public Product() {
    }

    public Product(String productName, int productPrice, int discount, int inventory) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.discount = discount;
        this.inventory = inventory;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
}

