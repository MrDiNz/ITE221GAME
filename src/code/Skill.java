package code;

public abstract class Skill {
    private String name;
    private String description;
    private static int skillCD;
    
    private int skillNo;
    private static int skillStat;

//        player can select one and only one skill each game

    public Skill(int skillNo) {
        switch (skillNo) {
            case 1:
            	this.name = "Dash";
                this.description = "Double Damage Attack";
                this.skillNo = 1;
                this.skillStat = 2;
                this.skillCD = 0;
                break;
            case 2:
            	this.name = "Block";
                this.description = "Attack & Block Half the Damage";
                this.skillNo = 2;
                this.skillStat = 2;
                this.skillCD = 0;
                break;
        }
    }

    public Skill (int skillNo, String name, int skillStat) {
    	this.skillNo = skillNo;
    	this.name = name;
    	this.skillStat = skillStat;
    }
    
    
    public int DoubleAttackSkill (Hero hero, Monster mob) {
		return mob.getHp() - (hero.getDamage()*skillStat);
    }
    
    public int ShieldAttackSkill (Hero hero, Monster mob) {
    	return hero.getHP() - (mob.getDmg()/skillStat);    
    	}
    
    
    public static int SkillUse (int num, Hero hero, MonsterConstruct mob) {
    	switch (num) {
    		case 1:
    			int mobHP;
    			return mob.getHp() - (hero.getDamage()*skillStat);
    		case 2:
    			return hero.getHP() + (mob.getDmg()/skillStat);
    	}
		return num;
    }
    
    public static String SkillList() {
        return "1. Damage x2" +
                "\n2. DamageToPlayer/2";
    }

    @Override
    public String toString() {
        return "Skill{" +
//                "skillNo=" + skillNo +
                ", name='" + name + '\'' +
                '}';
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSkillNo() {
		return skillNo;
	}

	public void setSkillNo(int skillNo) {
		this.skillNo = skillNo;
	}

	public static int getSkillStat() {
		return skillStat;
	}

	public static void setSkillStat(int skillStat) {
		Skill.skillStat = skillStat;
	}

	public static int getSkillCD() {
		return skillCD;
	}

	public static void setSkillCD(int skillCD) {
		Skill.skillCD = skillCD;
	}
}
