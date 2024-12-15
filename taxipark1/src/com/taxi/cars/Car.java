package com.taxi.cars;

import java.io.Serializable;

public abstract class Car implements Serializable {
    private String brand;
    private String model;
    private double price;
    private double fuelConsumption; // л/100 км
    private int maxSpeed;

    public Car(String brand, String model, double price, double fuelConsumption, int maxSpeed) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.fuelConsumption = fuelConsumption;
        this.maxSpeed = maxSpeed;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public String toString() {
        return String.format("%s %s: Ціна: %.2f USD, Розхід: %.2f л/100 км, Макс. швидкість: %d км/год",
                brand, model, price, fuelConsumption, maxSpeed);
    }
}
