package code;

import java.util.Scanner;

//import static code.Skill.SkillList;


public class Hero implements heroInterface {
    private String name;
    private int lvl, EXP, HP, Damage; //what is xp?
    public Skill heroSkill;
    private int escapeStat;
    private Stage stage;
    private static Card[] inventory;
//    todo inventory have to implement
//code.Hero object constructor define for each hero using ArrayList or Treemap

    public Hero(String name, Skill heroSkill) {
        this.name = name;
        this.lvl = 1;
        this.EXP = 0;
        this.HP = 100;
        this.Damage = 10;
        this.escapeStat = 4;
        this.heroSkill = heroSkill;


    }

    
    public static Card[] inventoryMethod() {
    		Card[] array = new Card[5];	
    		for (int i = 0; i<5; i++) {
    			array[i] = Card_Constructor.PotionCardsLow[Randomizer.Randomizer(0, 2)]; //0 is blank card!
    		}
    		return array;	
    	}
    public static void inventoryPrint (Card[] array) {
    	for (int i = 0; i < array.length; i++) {
    		System.out.print(array[i]);
    	}
    }
    

    //Method to create hero
    public static Hero GUIHeroCreate(String heroName, int skillNo) {
        inventory = inventoryMethod();
        Hero hero;
        if (skillNo == 1) {
            hero = new Hero(heroName, new Skill_DamageX2(1));
        } else if (skillNo == 2) {
            hero = new Hero(heroName, new Skill_Heal(2));
        } else hero = new Hero("noob", null);
        return hero;
    }
    public static Hero HeroCreate() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hero name: ?");
        String heroName = scan.nextLine();
        System.out.println("Choose hero skill\n" + Skill.SkillList());
        int skillNo = scan.nextInt();
        
        
        
        inventory = inventoryMethod();
        Hero hero;
        if (skillNo == 1) {
            hero = new Hero(heroName, new Skill_DamageX2(1));
        } else if (skillNo == 2) {
            hero = new Hero(heroName, new Skill_Heal(2));
        } else hero = new Hero("noob", null);
//        scan.close();
        return hero;
    }
    
    
    public String getInventory() {
    	return  "\nslot [1] = " + inventory[0].getName() +
                "\nslot [2] = " + inventory[1].getName() +
    			"\nslot [3] = " + inventory[2].getName() +
                "\nslot [4] = " + inventory[3].getName() +
    			"\nslot [5] = " + inventory[4].getName();
    }
    
    public Card getCard(int num) {
    	return inventory[num];
    }

    
    @Override
    public String toString() {
        return "Hero:" +
                "Name = " + name + "," +
                "\n Level = " + lvl + ", " + "EXP = " + EXP + "," +
                "\n HP = " + HP + ", " + "Damage = " + Damage + "," +
                "\n Hero Skill = " + heroSkill + "," +
                "\n Inventory = " + getInventory();
    }
    
    public String setInventory(int num) { //this set replaces a card with a blank card to avoid null pointer exception
    	this.inventory[num-1] = Card_Constructor.Blank[0];
    	return "You have deleted a card from your inventory";
    }
    
    public String setInventory(Card card, int num) { //this set replaces a card in the inventory with a new cards
    	this.inventory[num-1] = card;
    	return "You have got a new card";

    }
    
    public int Attack (Hero hero, Monster mob) {
    	return mob.getHp() - hero.Damage;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getEXP() {
        return EXP;
    }

    public void setEXP(int EXP) {
        this.EXP = EXP;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getDamage() {
        return Damage;
    }

    public void setDamage(int damage) {
        Damage = damage;
    }


	public Skill getHeroSkill() {
		return heroSkill;
	}


	public void setHeroSkill(Skill heroSkill) {
		this.heroSkill = heroSkill;
	}


	public int getEscapeStat() {
		return escapeStat;
	}


	public void setEscapeStat(int escapeStat) {
		this.escapeStat = escapeStat;
	}

    
    
    //@Override
   // public void playerMove() {

    //}
}
