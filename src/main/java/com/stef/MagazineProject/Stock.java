package com.stef.MagazineProject;


import org.apache.log4j.Logger;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Stock {

    private static final Logger log = Logger.getLogger(Stock.class);
    private static ArrayList<Product> goods = new ArrayList<Product>();


    public static void addProduct(String name,String description, double price, String vendor, int warranty) {
        try {
            if (price <= 0) {
                throw new Exception();
            }
            goods.add(new Product(name,description, price, vendor, warranty));
        } catch (Exception e) {
            System.out.println("Price less than zero");
            log.info("Price less than zero" + e.getMessage());
        }
    }

    public static void addProduct() {
        Scanner in = new Scanner(System.in);
        String name = "";
        String description = "";
        String vendor = "";
        int warranty = 0;
        double price = 0;
        int repeat = -1;
        do {
            System.out.print("Enter product name: ");
            name = in.next();
            System.out.print("Enter product description: ");
            description = in.next();
            System.out.print("Enter price of product: ");
            price = in.nextDouble();
            System.out.print("Enter product vendor: ");
            vendor = in.next();
            System.out.print("Enter product warranty(month): ");
            warranty = in.nextInt();
            goods.add(new Product(name,description, price, vendor, warranty));
            System.out.println("Add another product?");
            System.out.print("1-YES / 0-NO :");
            repeat = in.nextInt();
        } while (repeat != 0);
    }


    public static Product findProduct() {

        for (Product product : goods) {
            System.out.println(product.toString());
        }

        System.out.print("Chose your product by ID:");
        Scanner in = new Scanner(System.in);
        int inputID = in.nextInt();
        for (int i = 0; i < goods.size(); i++) {
            if (goods.get(i).getId() == inputID) {
                inputID = i;
                break;
            }
        }
        return goods.get(inputID);
    }

        /*int oldMaxID = 0;

        for (Product product : goods) {
            if (product.getId() > oldMaxID) {
                oldMaxID = product.getId();
            }
        }
        Product.setNextId(oldMaxID + 1);*/
}

