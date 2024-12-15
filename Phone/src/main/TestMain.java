package main;

import phone.Phone;
import java.util.ArrayList;

public class TestMain {
    public static void main(String[] args) {
        ArrayList<Phone> phones = new ArrayList<>();
        phones.add(new Phone(1, "Doe", "John", "Michael", 123456, 120, 0));
        phones.add(new Phone(2, "Smith", "Anna", "Marie", 654321, 45, 30));
        phones.add(new Phone(3, "Brown", "David", "Lee", 789123, 150, 10));
        phones.add(new Phone(4, "Wilson", "Emma", "Grace", 456789, 70, 0));
        phones.add(new Phone(5, "Taylor", "Lucas", "James", 321654, 60, 5));

        System.out.println("Test: Subscribers with city call duration over 60 min:");
        Main.filterByCityCallDuration(phones, 60);

        System.out.println("\nTest: Subscribers who used long-distance calls:");
        Main.filterByLongDistanceUsage(phones);

        System.out.println("\nTest: Subscribers with account numbers from 200000 to 600000:");
        Main.filterByAccountRange(phones, 200000, 600000);
    }
}
