import java.util.Scanner;

public class BattleStart {
    public static void battleStart (Hero hero, Monster mob) {
        hero.setEscapeStat(4);//Escape stat is defined every start of the battle
        Scanner console = new Scanner(System.in);
        System.out.print("\nYou see a monster. Fight (1) or flight (2)?");
        String input = console.nextLine();

        if (input.equals("1")) {
            console.close();
            System.out.print("\nYou chose fight");
            Combat.CombatMenu(hero, mob);
        }
        else  {
            console.close();
            System.out.print("\nYou chose escape");
            if (Escape.Escape(hero.getEscapeStat())) System.out.print("\nWow, you escaped!");
            else {
                System.out.print("\nTough luck, you failed to escape!");
                Combat.CombatMenu(hero, mob);
            }
        }
    }
}
