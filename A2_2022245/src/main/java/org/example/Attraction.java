package org.example;

public class Attraction {
    private int price;


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    private static int attractionCount = 1;
    private int attractionId;
    private String name;
    private String describe;

    public Attraction(String name, String describe) {
        this.attractionId = attractionCount++;
        this.name = name;
        this.describe = describe;

    }

    public int getAttractionId() {
        return attractionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}

