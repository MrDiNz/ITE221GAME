

abstract class Monster { //was abstract
    private int hp, dmg;
    private String name;
    private int lvl;
//Monster detail here
//    each Monster have name, lvl, hp, dmg
//    todo think about lvl depends on exp if it possible



    public Monster(int hp, int dmg, String name, int lvl) {
        this.hp = hp;
        this.dmg = dmg;
        this.name = name;
        this.lvl = lvl;
    }

    @Override
    public String toString() {
        return "code.Monster{" +
                "hp=" + hp +
                ", dmg=" + dmg +
                ", name='" + name + '\'' +
                ", lvl=" + lvl +
                '}';
    }

    public int Attack (Hero hero, Monster mob) {
        int heroHP;
        return heroHP = hero.getHP() - mob.getDmg();
    }

    public int AttackX (Hero hero, Monster mob, int num) {
        int heroHP;
        return heroHP = hero.getHP() - mob.getDmg()*num;
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
}
