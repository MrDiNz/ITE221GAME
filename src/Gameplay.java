

import java.util.Arrays;
import java.util.Scanner;
public class Gameplay {
    public static void Gameplay(Hero hero, Stage stage) {
//        Start play here
        boolean flag = true;
//        loop for game play move, check monster and send to fight class
        Scanner scan = new Scanner(System.in);
        stage.printStageHeroLocation();
        do {
            System.out.println("pls move\nu=up, d= down, l=left, r=right");
            String move;
            move = scan.nextLine();
            stage.playerMove(move);
            if (stage.getStage(stage.getX(), stage.getY()) != null) {
//                fight(stage.getStage(stage.getX(), stage.getY()), hero);
                Combat.CombatMenu(hero, stage.getStage(stage.getX(), stage.getY()));
            }else {System.out.println("No monster here");}

//            todo delete monster if die
//            stage.setMonsgterDie(stage.getX(), stage.getY());

        } while (flag);
//                String move = scan.nextLine();


    }




    public static void fight(Monster monsters, Hero hero) {
//        todo implement fight part
        System.out.println(monsters);
        System.out.println(hero);


    }
}
