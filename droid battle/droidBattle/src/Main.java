import battle.OneVsOneBattle;
import battle.TeamBattle;
import droids.Droid;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Droid> droids = new ArrayList<>();

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Створити дроїда");
            System.out.println("2. Показати список дроїдів");
            System.out.println("3. Бій 1 на 1");
            System.out.println("4. Бій команда на команду");
            System.out.println("5. Вийти");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Введіть ім'я дроїда:");
                    String name = scanner.nextLine();
                    Droid newDroid = new Droid(name);
                    droids.add(newDroid);
                    System.out.println("Дроїд " + name + " створений!");
                    break;

                case 2:
                    System.out.println("Список дроїдів:");
                    for (int i = 0; i < droids.size(); i++) {
                        Droid droid = droids.get(i);
                        System.out.println((i + 1) + ". " + droid.getName() + " - Здоров'я: " + droid.getHealth() + ", Шкода: " + droid.getDamage());
                    }
                    break;

                case 3:
                    if (droids.size() >= 2) {
                        System.out.println("Оберіть два дроїди для бою 1 на 1:");

                        for (int i = 0; i < droids.size(); i++) {
                            Droid droid = droids.get(i);
                            System.out.println((i + 1) + ". " + droid.getName());
                        }

                        System.out.print("Оберіть перший дроїд (введіть номер): ");
                        int droid1Index = scanner.nextInt() - 1;
                        System.out.print("Оберіть другий дроїд (введіть номер): ");
                        int droid2Index = scanner.nextInt() - 1;

                        if (droid1Index >= 0 && droid1Index < droids.size() && droid2Index >= 0 && droid2Index < droids.size()) {
                            Droid droid1 = droids.get(droid1Index);
                            Droid droid2 = droids.get(droid2Index);

                            OneVsOneBattle battle = new OneVsOneBattle(droid1, droid2);
                            battle.start();
                        } else {
                            System.out.println("Невірний номер дроїда!");
                        }
                    } else {
                        System.out.println("Не вистачає дроїдів для бою 1 на 1!");
                    }
                    break;

                case 4:
                    if (droids.size() >= 4) {
                        System.out.println("Оберіть 2 дроїдів для кожної команди:");
                        for (int i = 0; i < droids.size(); i++) {
                            Droid droid = droids.get(i);
                            System.out.println((i + 1) + ". " + droid.getName());
                        }

                        List<Droid> team1 = new ArrayList<>();
                        System.out.println("Оберіть два дроїди для Команди 1:");
                        for (int i = 0; i < 2; i++) {
                            System.out.print("Оберіть дроїда для Команди 1 (введіть номер): ");
                            int team1Index = scanner.nextInt() - 1;
                            if (team1Index >= 0 && team1Index < droids.size() && !team1.contains(droids.get(team1Index))) {
                                team1.add(droids.get(team1Index));
                            } else {
                                System.out.println("Невірний номер дроїда або цей дроїд вже в команді!");
                                i--;
                            }
                        }

                        List<Droid> team2 = new ArrayList<>();
                        System.out.println("Оберіть два дроїди для Команди 2:");
                        for (int i = 0; i < 2; i++) {
                            System.out.print("Оберіть дроїда для Команди 2 (введіть номер): ");
                            int team2Index = scanner.nextInt() - 1;
                            if (team2Index >= 0 && team2Index < droids.size() && !team2.contains(droids.get(team2Index))) {
                                team2.add(droids.get(team2Index));
                            } else {
                                System.out.println("Невірний номер дроїда або цей дроїд вже в команді!");
                                i--;
                            }
                        }

                        TeamBattle teamBattle = new TeamBattle(team1, team2);
                        teamBattle.start();
                    } else {
                        System.out.println("Не вистачає дроїдів для бою команда на команду!");
                    }
                    break;

                case 5:
                    System.out.println("Вихід з програми.");
                    return;
            }
        }
    }
}
