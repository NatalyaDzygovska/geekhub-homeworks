package com.geekhub.homework3;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<Product, Integer> productCounts = new HashMap<>();

    public void addProductCount(Product product, Integer count) {
        productCounts.put(product, count);
    }

    public double getInventoryCost() {
        double inventoryCost = 0;
        for (Map.Entry<Product, Integer> product : productCounts.entrySet()) {
            inventoryCost += product.getKey().getPrice() * product.getValue();
        }
        return inventoryCost;
    }
}
