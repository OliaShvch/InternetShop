package com.stef.MagazineProject;


import java.util.GregorianCalendar;


public class Product {

    private int id;
    private static int nextId = 1;
    private String name;
    private String description;
    private double price;
    private String vendor;
    private GregorianCalendar expDate;
    private int warrantyMonth; //garantia


    public Product(String name,String description, double price, String vendor, int warranty) {

        setId();
        this.name = name;
        this.description=description;
        this.price = price;
        this.vendor = vendor;
        this.expDate = null;
        this.warrantyMonth = warranty;

    }

    public Product() {
        setId();
        this.name = "none";
        this.description = "none";
        this.price = 0.0;
        this.vendor = "none";
        this.expDate = null;
        this.warrantyMonth = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void setNextId(int nextId) {
        Product.nextId = nextId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        id = nextId;
        nextId++;
    }

    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public void showExpDate() {
        System.out.println("Exp date is :" + expDate.getTime());
    }

    public int getWarrantyMonth() {
        return warrantyMonth;
    }

    public void setWarrantyMonth(int warrantyMonth) {
        this.warrantyMonth = warrantyMonth;
    }

    public void setExpDate() {
        GregorianCalendar currentDate = new GregorianCalendar();
        expDate = new GregorianCalendar(currentDate.get(GregorianCalendar.YEAR)+warrantyMonth/12,
                currentDate.get(GregorianCalendar.MONTH)+warrantyMonth%12,
                currentDate.get(GregorianCalendar.DATE));


    }
}