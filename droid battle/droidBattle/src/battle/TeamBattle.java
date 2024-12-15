package battle;

import droids.Droid;

import java.util.List;

public class TeamBattle {
    private final List<Droid> team1;
    private final List<Droid> team2;

    public TeamBattle(List<Droid> team1, List<Droid> team2) {
        this.team1 = team1;
        this.team2 = team2;
    }

    public void start() {
        System.out.println("\nПочаток командного бою:");
        System.out.println("Команда 1:");
        team1.forEach(droid -> System.out.println("- " + droid.getName()));
        System.out.println("Команда 2:");
        team2.forEach(droid -> System.out.println("- " + droid.getName()));

        int team1Health = team1.stream().mapToInt(Droid::getHealth).sum();
        int team2Health = team2.stream().mapToInt(Droid::getHealth).sum();

        int team1Damage = team1.stream().mapToInt(Droid::getDamage).sum();
        int team2Damage = team2.stream().mapToInt(Droid::getDamage).sum();

        while (team1Health > 0 && team2Health > 0) {
            team2Health -= team1Damage;
            if (team2Health <= 0) {
                System.out.println("Команда 1 перемагає!");
                return;
            }

            team1Health -= team2Damage;
            if (team1Health <= 0) {
                System.out.println("Команда 2 перемагає!");
            }
        }
    }
}
