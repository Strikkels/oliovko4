package main;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
        Scanner sc = new Scanner( System.in );
        Player player = null;
        Cave cave = null;


        System.out.println( "Syötä pelaajan nimi: " );
        String nimi = sc.nextLine();
        player = new Player(nimi);
        cave = new Cave(player);

        boolean exit = false;
        while(!exit){
            System.out.println("1) Lisää luolaan hirviö");
            System.out.println("2) Listaa hirviöt");
            System.out.println("3) Hyökkää hirviöön");
            System.out.println("4) Tallenna peli");
            System.out.println("5) Lataa peli");
            System.out.println("0) Lopeta peli");

            if(sc.hasNext()){
                int valinta = sc.nextInt();
                sc.nextLine();

                switch(valinta){
                    case 1:
                        System.out.println("Anna hirviön tyyppi: ");
                        String tyyppi = sc.nextLine();
                        System.out.println("Anna hirviön elämän määrä numerona: ");
                        int elamat = sc.nextInt();
                        Monster monster = new Monster(tyyppi, elamat);
                        cave.addMonster(monster);
                        break;
                    case 2:
                        if(cave.monsters.size() == 0){
                            System.out.println("Luola on tyhjä.");
                        } else{
                            System.out.println("Luolan hirviöt: ");
                            cave.listMonsters();
                        }
                        break;
                    case 3:
                        System.out.println("Valitse hirviö, johon hyökätä: ");
                        cave.listMonsters();
                        int target = sc.nextInt();
                        sc.nextLine();
                        target--;
                        cave.player.attack(cave.getMonsters(target));
                        System.out.println(cave.player.getName() + " hyökkää " + cave.getMonsters(target).getType() + " hirviöön!");
                        if(cave.getMonsters(target).getHealth() <= 0){
                            System.out.println( cave.getMonsters(target).getType() + " on kuollut!");
                            cave.removeMonster(target);
                        } else{
                            System.out.println("Hirviöllä on " + cave.getMonsters(target).getHealth() + " elämää jäljellä.");
                        }
                        break;
                    case 4:
                        System.out.println("Anna tiedoston nimi, johon peli tallentaa: ");
                        String fileName = sc.nextLine();
                        cave.saveGame(fileName);
                        System.out.println("Peli tallennettiin tiedostoon " + fileName + ".");
                        break;
                    case 5:
                        System.out.println("Anna tiedoston nimi, josta peli ladataan: ");
                        String loadFileName = sc.nextLine();
                        cave.loadGame(loadFileName);
                        System.out.println("Peli ladattu tiedostosta " + loadFileName + ". Tervetuloa takaisin, " + cave.player.getName() + ".");
                        break;
                    case 0:
                        System.out.println("Peli päättyy. Kiitos pelaamisesta!");
                        exit = true;
                        break;
                    default:
                        System.out.println("Virheellinen valinta");
                        break;
                }
            
            }
        }
        sc.close();
    }
}
