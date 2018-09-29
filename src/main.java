
import java.util.Scanner;

//import static code.Skill.SkillList;

public class main {
    public static void main(String[] args) {
//        create hero and stage
        Hero hero = Hero.HeroCreate();
//        System.out.println(hero);

//        stage create from here
        Stage easyStage = new Stage("easy");
        Stage mediumStage = new Stage("medium");
        Stage hardStage = new Stage("hard");
//        easyStage.printStageWithMonster();

//        put hero into stage and start play in Gameplay class
        Gameplay.Gameplay(hero, easyStage);

    }
}
