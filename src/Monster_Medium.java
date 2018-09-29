
public class Monster_Medium extends Monster {
    //Method for medium monster
    public Monster_Medium(int hp, int dmg, String name, int lvl) {
        super(hp, dmg, name, lvl);
        super.setLvl(Randomizer.Randomizer(5,8));
    }
}
