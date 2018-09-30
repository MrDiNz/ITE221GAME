package code;

public class SkillUsePhase {
    public static void SkillUsePhase (Hero hero, Monster mob) {
        //switch depends on hero skill number
        switch (hero.getHeroSkill().getSkillNo()) {
            case 1:
                mob.setHp(hero.getHeroSkill().DoubleAttackSkill(hero, mob));
                System.out.print("\nYou attack the monster with fury! The damage is " + hero.getDamage()*2
                        + "! code.Monster health is " +mob.getHp());
                //mob attack back
                hero.setHP(mob.Attack(hero, mob));
                System.out.print("\ncode.Monster attacks back! Your health is " + hero.getHP());
                Skill.setSkillCD(2);//Sets cooldown on 2, so it would be available again in one turn
//                code.CombatGUI.CombatMenu(hero, mob);
                break;

            case 2:
                mob.setHp(hero.Attack(hero, mob));
                System.out.print("\nYou attack monster for " + hero.getDamage() + ", monster health is " +mob.getHp());
                //mob attack back
                hero.setHP(hero.getHeroSkill().ShieldAttackSkill(hero, mob));
                System.out.print("\ncode.Monster attacks back for "+ mob.getDmg() +"! Lucky you use shield and defend yourself, halving the damage!"
                        + " You health is " + hero.getHP());
                Skill.setSkillCD(2);
//                code.CombatGUI.CombatMenu(hero, mob);
                break;
        }
    }
}
