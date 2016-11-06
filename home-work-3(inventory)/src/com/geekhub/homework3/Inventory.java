package com.geekhub.homework3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
    private Map<Product, Integer> productCounts = new HashMap<>();
    private List<Category> categories = new ArrayList<>();

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

    public double getCostByCategory(Category category) {
        double cost = 0;
        for (Map.Entry<Product, Integer> product : productCounts.entrySet()) {
            if (product.getKey().getCategory().equals(category)) {
                cost += product.getKey().getPrice()*product.getValue();
            }
        }
        return cost;
    }

    public ArrayList<Product> getProductsByCategory(Category category) {
        ArrayList<Product> products = new ArrayList<>();
        for(Product product: productCounts.keySet()){
            if (product.getCategory().equals(category)){
                products.add(product);
            }
        }
        return products;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public Category createCategory(String categoryName) {
        Category category = new Category(categoryName);
        categories.add(category);
        return category;
    }
}
