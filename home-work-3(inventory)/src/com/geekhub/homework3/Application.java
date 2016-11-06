package com.geekhub.homework3;

import java.util.Scanner;

public class Application {
    private static Inventory inventory = new Inventory();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Category laptop = inventory.createCategory("laptops");
        Category mobile = inventory.createCategory("mobile phones");
        Category tablet = inventory.createCategory("tablets");

        inventory.addProductCount(new Product("Apple MacBook Air", 1859.00, laptop), 2);
        inventory.addProductCount(new Product("Dell Inspiron", 899.99, laptop), 4);
        inventory.addProductCount(new Product("HP Envy", 1049.99, laptop), 3);
        inventory.addProductCount(new Product("Samsung", 359.99, mobile), 2);
        inventory.addProductCount(new Product("Lenovo", 411.00, tablet), 3);
        inventory.addProductCount(new Product("Asus", 405, tablet), 2);

        startDialogue();
    }

    private static void startDialogue() {
        boolean exit = false;
        while (!exit) {
            printProductsByCategories();
            printInventoryCost();
            printMenu();

            String answer = scanner.nextLine();

            if (answer.equalsIgnoreCase("P")) {
                createProductByUser();
            }
            if (answer.equalsIgnoreCase("C")) {
                Category category = getCategoryFromUser();
                printInventoryByCategory(category);
                printMenu();
                scanner.nextLine();
                scanner.nextLine();
            }
            if (answer.equalsIgnoreCase("Q")) {
                exit = true;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Create new product - press P");
        System.out.println("Get inventory by category - press C");
        System.out.println("Exit = press Q");
    }

    private static void createProductByUser() {
        System.out.println("Enter name of product: ");
        String name = scanner.nextLine();
        System.out.println("Enter price of product: ");
        double price = scanner.nextDouble();

        Category category = getCategoryFromUser();
        Product product = new Product(name, price, category);
        System.out.println("Enter count of product: ");
        Integer count = scanner.nextInt();
        inventory.addProductCount(product, count);
    }

    private static Category getCategoryFromUser() {
        System.out.println("Choose category: ");
        for (Category category : inventory.getCategories()) {
            System.out.println(category.getName().toUpperCase() + " - press " + inventory.getCategories().indexOf(category));
        }
        Category category = null;
        switch (scanner.nextInt()) {
            case 0:
                category = inventory.getCategories().get(0);
                break;
            case 1:
                category = inventory.getCategories().get(1);
                break;
            case 2:
                category = inventory.getCategories().get(2);
        }
        return category;
    }

    private static void printInventoryByCategory(Category category) {
        System.out.println("Inventory value by category \"" + category.getName() +
                "\": " + inventory.getCostByCategory(category));
    }

    private static void printInventoryCost() {
        double inventoryCost = inventory.getInventoryCost();
        System.out.println("Inventory value of all products: " + inventoryCost);
    }

    private static void printProductsByCategories() {
        for (Category category : inventory.getCategories()) {
            System.out.println(category.getName().toUpperCase() + " :");
            for (Product product : inventory.getProductsByCategory(category)) {
                System.out.println("\t" + product.getName());
            }
        }
    }
}
