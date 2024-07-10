package com.management.thithuchanhmodule3.model;

public class ProductDTO {

    private String productName;
    private int productPrice;
    private String discount;
    private int inventory;

    public ProductDTO() {
    }

    public ProductDTO(String productName, int productPrice, String discount, int inventory) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.discount = discount;
        this.inventory = inventory;
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

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
}
