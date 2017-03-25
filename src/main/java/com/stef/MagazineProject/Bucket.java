package com.stef.MagazineProject;

import java.util.ArrayList;

public class Bucket {
    private ArrayList<Product> goods;

    public Bucket() {
        goods = new ArrayList<Product>();
    }
    public void addProduct(Product item,int count){
        goods.add(item);

    }
}
