package com.geekhub.homework3;

public class Application {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Category bread = new Category("bread");
        inventory.addProductCount(new Product("loaf", 5, bread), 4);
        inventory.addProductCount(new Product("bun", 5.5, bread), 2);
        inventory.addProductCount(new Product("bagel", 2.3, bread), 10);
        double inventoryCost = inventory.getInventoryCost();
        System.out.println(inventoryCost);
    }
}
