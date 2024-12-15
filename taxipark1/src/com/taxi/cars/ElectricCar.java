package com.taxi.cars;

public class ElectricCar extends Car {
    public ElectricCar(String brand, String model, double price, int maxSpeed) {
        super(brand, model, price, 0, maxSpeed);
    }
}