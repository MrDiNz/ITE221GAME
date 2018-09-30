package code;

import java.util.Scanner;

public class Combat {
    public static boolean CombatMenu(Hero hero, Monster mob) {
        System.out.println();
        //here is combo menu
        //here player choose what he wants to do during combat
        //Scanner console = new Scanner(System.in);
        //combat continues if monster and hero have hp
        while (mob.getHp() > 0 && hero.getHP() > 0) {
            if (mob.getHp() > 0 && hero.getHP() > 0) {

                if (Skill.getSkillCD() > 0) Skill.setSkillCD(Skill.getSkillCD() - 1); //removes 1 cool down each turn

                System.out.print("\n===================TURN START======================");
                System.out.println("\nWhat do you want to do? \n 1) Attack. 2) Use skill. "
                        + "\n 3) Use a card from inventory. 4) Try to escape again.");
                Scanner console = new Scanner(System.in);
                int input = console.nextInt();
                console.nextLine();
                switch (input) {
                    case 1:
                        //attack
                        AttackPhase(hero, mob);
                        break;
                    case 2:
                        //skill usage
                        if (hero.getHeroSkill().getSkillCD() == 0) {
                            //console.close();
                            SkillUsePhase.SkillUsePhase(hero, mob);
                        } else
                            System.out.print("Your skill is on cooldown! Your skill will be available in " + hero.getHeroSkill().getSkillCD()
                                    + " turns. Please try again.");
                        Skill.setSkillCD(Skill.getSkillCD() + 1);//so the old value would remain when player start the turn again
                        break;
                    case 3:
                        //inventory use
                        //console.close();
                        hero.getInventory();

                        Card card = Card_Choice.Card_Choice(hero);
                        System.out.print(card);

                        if (card.getTag() == null) {
                            System.out.print("\nWhoops! You picked a null card, try again...");
                        }
                        //todo rework cards that they give buff for 3 turns, would be a reverse cooldown similliar to skill one
                        else if (card.getTag().equals("health"))
                            hero.setHP(hero.getHP() + card.getCardStat()); //adds health
                        else if (card.getTag().equals("damage"))
                            mob.setHp(hero.Attack(hero, mob) - card.getCardStat()); //adds attack
                        else if (card.getTag().equals("escape"))
                            hero.setEscapeStat(hero.getEscapeStat() + 1);//adds to escape stat


                        hero.setHP(mob.Attack(hero, mob));
                        System.out.println("\ncode.Monster attacks back! Your health is " + (hero.getHP() < 0 ? "0" : hero.getHP()));
                        break;
                    case 4:
                        System.out.print("\nYou chose escape");
                        if (Escape.Escape(hero.getEscapeStat())) {
                            System.out.print("\nWow, you escaped!");
                            hero.setEscapeStat(hero.getEscapeStat() - 1);
                        } else {
                            System.out.print("\nTough luck, you failed to escape!");
                            hero.setEscapeStat(hero.getEscapeStat() - 1);
                            hero.setHP(mob.AttackX(hero, mob, 2)); //if escape failed, player gets attacked with double damage
                            System.out.print("\ncode.Monster attacks your back for critical damage! \nYour health is " + hero.getHP());
                        }
                        break;
                }
            }
        }
        if (mob.getHp() <= 0) {
            System.out.println("\n!!!!!!!!!!=============!!!!!!!!!!\nYou have defeated a monster.");
            return true;

        }
        return false;
    }


    public static void AttackPhase(Hero hero, Monster mob) {
        //Basic Attack Phase where player and monster exchange damage
        mob.setHp(hero.Attack(hero, mob));
        System.out.print("\nYou chose to attack the monster! You attack monster for " + hero.getDamage()
                + ", monster health is " + (mob.getHp() < 0 ? "0" : mob.getHp()));
        //mob attack back
        if (mob.getHp() > 0) {
            hero.setHP(mob.Attack(hero, mob));
            System.out.println("\ncode.Monster attacks back! Your health is " + hero.getHP());
        }
//            CombatMenu(hero, mob);
    }
}
