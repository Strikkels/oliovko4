package main;

import java.io.Serializable;

public class Player implements Serializable {
    private String name;
    
        
    public Player(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }   

    public void attack(Monster target) {
        System.out.println(name + " hyökkää " + target.getType() + " hirviöön!");
        target.takeDamage(10);
    }
}