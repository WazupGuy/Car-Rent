package com.example.demo;

public class Car {
    private String plateNumber;
    private String brand;
    private int price;

    // Constructor
    public Car(String plateNumber, String brand, int price) {
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.price = price;
    }

    // Default constructor
    public Car() {
    }

    // Getters and Setters
    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}