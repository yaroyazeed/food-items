package com.yaroyazeed.foodapplication;

public class MainModel {

    int id;
    String image, image1, image2;
    String productName, nutrients, description, from, quantity, price;
    Boolean organic;


    MainModel(){

    }

    public MainModel(int id, String image , String image1, String image2 , String quantity, String price, String productName, String nutrients, String description, String from, Boolean organic) {
        this.id = id;
        this.image = image;
        this.image1 = image1;
        this.image2 = image2;
        this.quantity = quantity;
        this.price = price;
        this.productName = productName;
        this.nutrients = nutrients;
        this.description = description;
        this.from = from;
        this.organic = organic;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getNutrients() {
        return nutrients;
    }

    public void setNutrients(String nutrients) {
        this.nutrients = nutrients;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Boolean getOrganic() {
        return organic;
    }

    public void setOrganic(Boolean organic) {
        this.organic = organic;
    }
}
