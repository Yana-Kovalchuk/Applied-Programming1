package com.taxi.cars;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void testPassengerCarCreation() {
        Car car = new PassengerCar("Toyota", "Camry", 25000, 8.0, 220);

        assertThat(car.getBrand()).isEqualTo("Toyota");
        assertThat(car.getModel()).isEqualTo("Camry");
        assertThat(car.getPrice()).isEqualTo(25000);
        assertThat(car.getFuelConsumption()).isEqualTo(8.0);
        assertThat(car.getMaxSpeed()).isEqualTo(220);
    }

    @Test
    void testSUVCreation() {
        Car car = new SUV("Jeep", "Cherokee", 40000, 12.0, 180);

        assertThat(car).isInstanceOf(SUV.class);
        assertThat(car.getBrand()).isEqualTo("Jeep");
        assertThat(car.getFuelConsumption()).isEqualTo(12.0);
    }

    @Test
    void testElectricCarCreation() {
        Car car = new ElectricCar("Tesla", "Model S", 70000, 250);

        assertThat(car).isInstanceOf(ElectricCar.class);
        assertThat(car.getBrand()).isEqualTo("Tesla");
        assertThat(car.getMaxSpeed()).isEqualTo(250);
        assertThat(car.getFuelConsumption()).isZero(); // Електромобілі не витрачають пальне
    }
}
