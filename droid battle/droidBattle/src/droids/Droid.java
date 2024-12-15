package droids;

import java.util.Random;

public class Droid {
    private final String name;
    private int health;
    private int damage;

    public Droid(String name) {
        this.name = name;
        this.health = new Random().nextInt(50) + 50;
        this.damage = new Random().nextInt(20) + 10;
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) this.health = 0;
    }

    public void attack(Droid target) {
        target.takeDamage(this.damage);
        System.out.println(this.name + " атакує " + target.getName() + " на " + this.damage + " шкоди!");
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
