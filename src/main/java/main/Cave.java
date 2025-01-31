package main;

import java.util.ArrayList;
import java.io.Serializable;

public class Cave implements Serializable {
    public Player player;
    public ArrayList<Monster> monsters;


    public Cave(Player player) {
        this.player = player;
        monsters = new ArrayList<Monster>();
    }

    public Monster getMonsters(int target) {
        return this.monsters.get(target);
    }

    public void addMonster(Monster monster) {
        this.monsters.add(monster);
    }

    public void listMonsters() {
        if(this.monsters.size() == 0) {
            System.out.println("Luola on tyhjä.");
        } else {
            for(int i = 0; i < this.monsters.size(); i++) {
                this.monsters.get(i).printInfo(i);
            }
        }
    }

    public void removeMonster(int target) {
        this.monsters.remove(target);
    }

    public void saveGame(String filename) {
        try{
            java.io.ObjectOutputStream writeCave = new java.io.ObjectOutputStream(new java.io.FileOutputStream(filename));
            writeCave.writeObject(this);
            writeCave.close();
        } catch (java.io.IOException e) {
            System.out.println("Luolan tallentaminen epäonnistui");
            e.printStackTrace();
        }
    }

    public void loadGame(String filename) {
        try{
            java.io.ObjectInputStream readCave = new java.io.ObjectInputStream(new java.io.FileInputStream(filename));
            Cave cave = (Cave) readCave.readObject();
            this.player = cave.player;
            this.monsters = cave.monsters;
            readCave.close();
        } catch (java.io.IOException e) {
            System.out.println("Luolan lataaminen epäonnistui");
            e.printStackTrace();
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println("Luolan lataaminen epäonnistui");
            e.printStackTrace();
        }
    }

}