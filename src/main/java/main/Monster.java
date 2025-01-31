package main;

import java.io.Serializable;

public class Monster implements Serializable {
    private String Type;
    private int health;

    public Monster(String Type, int health) {
        this.Type = Type;
        this.health = health;
    }

    public String getType() {
        return this.Type;
    }

    public int getHealth() {
        return this.health;
    }

    public void printInfo(int number){
        number++;
        System.out.println(number + ": " + this.Type + " / " + this.health + "HP");
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        
    }
}