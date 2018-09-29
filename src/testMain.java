import java.util.Scanner;


public class testMain {
	
	

	
	public static boolean escape(int num) {
		//num == player escape stat (4 by default, but may be reduce or increased by failed escape attempts and poitions)
		//if dice is bigger than num, that return true, player escaped
		//else player failed
		boolean dice = (Randomizer.Randomizer(1, 6) > num) ? true: false;
		return dice;
	}
	
	public static void battleStart (Hero hero, Monster mob) {
		hero.setEscapeStat(4);//Escape stat is defined every start of the battle
		Scanner console = new Scanner(System.in);
		System.out.print("\nYou see a monster. Fight (1) or Escape (2)?");
		String input = console.nextLine();

		if (input.equals("1")) {
			System.out.print("\nYou chose fight");
			Combat.CombatMenu(hero, mob);
		}
		else  {
			System.out.print("\nYou chose escape");
			if (escape(hero.getEscapeStat())) System.out.print("\nWow, you escaped!");
			else {
				System.out.print("\nTough luck, you failed to escape!");
				Combat.CombatMenu(hero, mob);
			}
		}
		console.close();
	}
	
	public static void AttackPhase (Hero hero, Monster mob) {
		//Basic Attack Phase where player and monster exchange damage
		mob.setHp(hero.Attack(hero, mob)); 
		System.out.print("\nYou chose to attack the monster! You attack monster for " + hero.getDamage() 
																   + ", monster health is " +mob.getHp());
		//mob attack back
		hero.setHP(mob.Attack(hero, mob));
		System.out.print("\nMonster attacks back! Your health is " + hero.getHP());
		Combat.CombatMenu(hero, mob);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Hero hero = Hero.HeroCreate();
		Monster mob = new Monster_easy(100, 10, "aesfsef", 1);
        System.out.println(hero);
		System.out.println("----------------");
        System.out.println(mob);
        
        battleStart(hero, mob);
	}

}
