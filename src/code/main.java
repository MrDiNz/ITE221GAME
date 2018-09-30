package code;

//import static code.code.Skill.SkillList;

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

//        put hero into stage and start play in code.Gameplay class
//        each stage return a hero but will return null if hero die
        System.out.println(hero);
        hero = Gameplay.Gameplay(hero, easyStage);
        if (hero != null) {
            System.out.println("-------------------------------------\ncode.Stage 2 start\n-------------------------------------");
            hero = Gameplay.Gameplay(hero, mediumStage);
        }
        if (hero != null) {
            System.out.println("-------------------------------------\ncode.Stage 3 start\n-------------------------------------");
            hero = Gameplay.Gameplay(hero, hardStage);
        }
        try {
            if (hero.getHP() > 0) {
                System.out.println("You win");
            }
        } catch (Exception e) {
            System.out.println("You lose XD");
        }

    }
}
