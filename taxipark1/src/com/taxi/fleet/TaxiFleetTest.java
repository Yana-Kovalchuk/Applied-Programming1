package com.taxi.fleet;

import com.taxi.cars.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;

class TaxiFleetTest {
    private TaxiFleet fleet;

    @BeforeEach
    void setUp() {
        fleet = new TaxiFleet();
        fleet.addCar(new PassengerCar("Toyota", "Corolla", 20000, 6.5, 180));
        fleet.addCar(new SUV("Jeep", "Wrangler", 35000, 12.0, 160));
        fleet.addCar(new ElectricCar("Nissan", "Leaf", 30000, 140));
    }

    @Test
    void testCalculateTotalCost() {
        double totalCost = fleet.calculateTotalCost();
        assertThat(totalCost).isEqualTo(20000 + 35000 + 30000);
    }

    private Object assertThat(double totalCost) {
    }

    @Test
    void testSortByFuelConsumption() {
        List<Car> sorted = fleet.sortByFuelConsumption();

        assertThat(sorted).hasSize(3);
        assertThat(sorted.get(0)).isInstanceOf(ElectricCar.class); // Електромобілі мають 0 витрати
        assertThat(sorted.get(1).getFuelConsumption()).isEqualTo(6.5);
        assertThat(sorted.get(2).getFuelConsumption()).isEqualTo(12.0);
    }

    @Test
    void testFindBySpeedRange() {
        List<Car> result = fleet.findBySpeedRange(150, 170);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getModel()).isEqualTo("Wrangler");
    }

    @Test
    void testAddCar() {
        int initialSize = fleet.getCars().size();

        fleet.addCar(new PassengerCar("Ford", "Fiesta", 15000, 5.8, 190));
        assertThat(fleet.getCars()).hasSize(initialSize + 1);
    }
}
