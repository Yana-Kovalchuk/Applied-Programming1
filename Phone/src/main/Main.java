package main;

import phone.Phone;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Phone> phones = new ArrayList<>();

        System.out.print("Enter the number of subscribers: ");
        int numOfSubscribers = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numOfSubscribers; i++) {
            System.out.println("Enter data for subscriber " + (i + 1) + ":");

            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Last name: ");
            String lastName = scanner.nextLine();

            System.out.print("First name: ");
            String firstName = scanner.nextLine();

            System.out.print("Middle name: ");
            String middleName = scanner.nextLine();

            System.out.print("Account number: ");
            int accountNumber = scanner.nextInt();

            System.out.print("City call duration (min): ");
            int cityCallDuration = scanner.nextInt();

            System.out.print("Long-distance call duration (min): ");
            int longDistanceCallDuration = scanner.nextInt();
            scanner.nextLine();

            phones.add(new Phone(id, lastName, firstName, middleName, accountNumber, cityCallDuration,
                    longDistanceCallDuration));
        }

        System.out.print("Enter the minimum city call duration for filtering: ");
        int minCityCallDuration = scanner.nextInt();
        System.out.println("\nSubscribers with city call duration over " + minCityCallDuration + " minutes:");
        filterByCityCallDuration(phones, minCityCallDuration);

        System.out.println("\nSubscribers who used long-distance calls:");
        filterByLongDistanceUsage(phones);

        System.out.print("Enter the minimum account number for filtering: ");
        int minAccountNumber = scanner.nextInt();
        System.out.print("Enter the maximum account number for filtering: ");
        int maxAccountNumber = scanner.nextInt();
        System.out.println(
                "\nSubscribers with account numbers from " + minAccountNumber + " to " + maxAccountNumber + ":");
        filterByAccountRange(phones, minAccountNumber, maxAccountNumber);

        scanner.close();
    }

    public static void filterByCityCallDuration(ArrayList<Phone> phones, int minDuration) {
        for (Phone phone : phones) {
            if (phone.getCityCallDuration() > minDuration) {
                System.out.println(phone.toString());
            }
        }
    }

    public static void filterByLongDistanceUsage(ArrayList<Phone> phones) {
        for (Phone phone : phones) {
            if (phone.getLongDistanceCallDuration() > 0) {
                System.out.println(phone.toString());
            }
        }
    }

    public static void filterByAccountRange(ArrayList<Phone> phones, int min, int max) {
        for (Phone phone : phones) {
            if (phone.getAccountNumber() >= min && phone.getAccountNumber() <= max) {
                System.out.println(phone.toString());
            }
        }
    }
}
