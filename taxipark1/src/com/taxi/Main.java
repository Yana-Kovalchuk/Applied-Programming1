package com.taxi;

import com.taxi.cars.*;
import com.taxi.fleet.TaxiFleet;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.*;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    private static final String FILE_NAME = "taxifleet.dat";
    private static TaxiFleet fleet = new TaxiFleet();

    static {
        try {
            LogManager.getLogManager().readConfiguration(Main.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to configure logger", e);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Додати автомобіль");
            System.out.println("2. Підрахувати вартість автопарку");
            System.out.println("3. Сортувати за витратою пального");
            System.out.println("4. Знайти автомобілі за діапазоном швидкості");
            System.out.println("5. Зберегти автопарк у файл");
            System.out.println("6. Завантажити автопарк із файлу");
            System.out.println("7. Вихід");
            System.out.print("Оберіть дію: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> addCar(scanner);
                case 2 -> System.out.println("Загальна вартість: " + fleet.calculateTotalCost() + " USD");
                case 3 -> fleet.sortByFuelConsumption().forEach(System.out::println);
                case 4 -> findCarsBySpeed(scanner);
                case 5 -> saveFleet();
                case 6 -> loadFleet();
                case 7 -> System.exit(0);
                default -> System.out.println("Неправильний вибір.");
            }
        }
    }

    private static void addCar(Scanner scanner) {
        try {
            System.out.print("Введіть тип (PassengerCar, SUV, ElectricCar): ");
            String type = scanner.next();
            System.out.print("Введіть марку: ");
            String brand = scanner.next();
            System.out.print("Введіть модель: ");
            String model = scanner.next();
            System.out.print("Введіть ціну: ");
            double price = scanner.nextDouble();
            System.out.print("Введіть витрату пального: ");
            double fuel = scanner.nextDouble();
            System.out.print("Введіть максимальну швидкість: ");
            int maxSpeed = scanner.nextInt();

            Car car = switch (type) {
                case "PassengerCar" -> new PassengerCar(brand, model, price, fuel, maxSpeed);
                case "SUV" -> new SUV(brand, model, price, fuel, maxSpeed);
                case "ElectricCar" -> new ElectricCar(brand, model, price, maxSpeed);
                default -> throw new IllegalArgumentException("Невідомий тип авто.");
            };

            fleet.addCar(car);
            LOGGER.info("Автомобіль додано: " + car);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Помилка під час додавання автомобіля", e);
        }
    }

    private static void findCarsBySpeed(Scanner scanner) {
        System.out.print("Введіть мінімальну швидкість: ");
        int minSpeed = scanner.nextInt();
        System.out.print("Введіть максимальну швидкість: ");
        int maxSpeed = scanner.nextInt();
        fleet.findBySpeedRange(minSpeed, maxSpeed).forEach(System.out::println);
    }

    private static void saveFleet() {
        try {
            fleet.saveToFile(FILE_NAME);
            LOGGER.info("Автопарк збережено у файл.");
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Помилка під час збереження у файл", e);
        }
    }

    private static void loadFleet() {
        try {
            fleet.loadFromFile(FILE_NAME);
            LOGGER.info("Автопарк завантажено з файлу.");
        } catch (IOException | ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "Помилка під час завантаження з файлу", e);
        }
    }
}
