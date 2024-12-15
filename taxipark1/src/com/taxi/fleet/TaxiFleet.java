package com.taxi.fleet;

import com.taxi.cars.Car;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TaxiFleet {
    private List<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public double calculateTotalCost() {
        return cars.stream().mapToDouble(Car::getPrice).sum();
    }

    public List<Car> sortByFuelConsumption() {
        cars.sort(Comparator.comparingDouble(Car::getFuelConsumption));
        return cars;
    }

    public List<Car> findBySpeedRange(int minSpeed, int maxSpeed) {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            if (car.getMaxSpeed() >= minSpeed && car.getMaxSpeed() <= maxSpeed) {
                result.add(car);
            }
        }
        return result;
    }

    public void saveToFile(String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(cars);
        }
    }

    @SuppressWarnings("unchecked")
    public void loadFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            cars = (List<Car>) ois.readObject();
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
