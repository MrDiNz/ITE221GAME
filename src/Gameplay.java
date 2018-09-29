

import java.util.Arrays;
import java.util.Scanner;

public class Gameplay {
    public static Hero Gameplay(Hero hero, Stage stage) {
//        Start play here
        boolean flag = true;
//        loop for game play move, check monster and send to fight class
        Scanner scan = new Scanner(System.in);
        stage.printStageHeroLocation();
        int monsterDefeatedCount = 0;
        while (monsterDefeatedCount < 8 && flag) {
            System.out.println("pls move\nw=up, s= down, a=left, d=right");
            String move;
            move = scan.nextLine();
            stage.playerMove(move);
            if (stage.getStage(stage.getX(), stage.getY()) != null) {
//                fight(stage.getStage(stage.getX(), stage.getY()), hero);
                flag = Combat.CombatMenu(hero, stage.getStage(stage.getX(), stage.getY()));

                if (hero.getHP() > 0) {
                    monsterDefeatedCount++;
                } else {
                    monsterDefeatedCount = 9;
                }
            } else {
                System.out.println("No monster here");
            }
        }
        if (hero.getHP() > 0) {
            return hero;
        } else {

            return null;
        }


//                String move = scan.nextLine();


    }


}
