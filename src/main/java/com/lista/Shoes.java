package com.lista;

class Shoes {
    private String color;
    private int size;
    private static int shoesNumber;

    public Shoes(String color, int size) {
        this.color = color;
        this.size = size;
        this.shoesNumber++;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public static int getShoesNumber() {
        return shoesNumber;
    }

    public static void setShoesNumber(int shoesNumber) {
        Shoes.shoesNumber = shoesNumber;
    }
}