package battle;

import droids.Droid;

public class OneVsOneBattle {
    private final Droid droid1;
    private final Droid droid2;

    public OneVsOneBattle(Droid droid1, Droid droid2) {
        this.droid1 = droid1;
        this.droid2 = droid2;
    }

    public void start() {
        while (droid1.isAlive() && droid2.isAlive()) {
            droid1.attack(droid2);
            System.out.println(droid2.getName() + " має " + droid2.getHealth() + " здоров'я.");

            if (!droid2.isAlive()) {
                System.out.println(droid2.getName() + " загинув!");
                break;
            }

            droid2.attack(droid1);
            System.out.println(droid1.getName() + " має " + droid1.getHealth() + " здоров'я.");

            if (!droid1.isAlive()) {
                System.out.println(droid1.getName() + " загинув!");
                break;
            }
        }

        if (droid1.isAlive()) {
            System.out.println(droid1.getName() + " виграв бій!");
        } else if (droid2.isAlive()) {
            System.out.println(droid2.getName() + " виграв бій!");
        }
    }
}
