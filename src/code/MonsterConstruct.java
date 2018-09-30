package code;

public class MonsterConstruct {
	   private int hp;
	   private int dmg;
	   private String name;
	   private int lvl;
	//code.Monster detail here
	//todo think about lvl depends on exp if it possible



	    public MonsterConstruct (int hp, int dmg, String name, int lvl) {
	        this.hp = hp;
	        this.dmg = dmg;
	        this.name = name;
	        this.lvl = lvl;
	    }
	    
	    public MonsterConstruct () {
	        hp = 100;
	        dmg = 10;
	        name = "Bork";
	        lvl = 2;
	    }
	    
	    @Override
	    public String toString() {
	        return "\n code.Monster" +
	                "\nhp = " + hp +
	                "\ndmg = " + dmg +
	                "\nname = " + name +
	                "\nlvl = " + lvl
	                ;
	    }
	    
	    public int getHp() {
	        return hp;
	    }

	    public void setHp(int hp) {
	        this.hp = hp;
	    }

	    public int getDmg() {
	        return dmg;
	    }

	    public void setDmg(int dmg) {
	        this.dmg = dmg;
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
	    
	    public int Attack (Hero hero, MonsterConstruct mob) {
	    	int heroHP;
			return heroHP = hero.getHP() - mob.dmg;
	    }
	    
	    public int AttackX (Hero hero, MonsterConstruct mob, int num) {
	    	int heroHP;
			return heroHP = hero.getHP() - mob.dmg*num;
	    }
}
