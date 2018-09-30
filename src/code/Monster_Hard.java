package code;

public class Monster_Hard extends Monster {
    //  method for hard monster
    public Monster_Hard(int hp, int dmg, String name, int lvl) {
        super(hp, dmg, name, lvl);
        super.setLvl(Randomizer.Randomizer(9, 12));
    }

}
