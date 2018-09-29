

public class Monster_easy extends Monster{
//    Method for easy monster
    public Monster_easy(int hp, int dmg, String name, int lvl) {
        super(hp, dmg, name, lvl);
        super.setLvl(Randomizer.Randomizer(1,4));
    }


}
