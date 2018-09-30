package GUI;

import code.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import code.Card;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import static code.Combat.AttackPhase;

public class CombatGUI implements Initializable {
    @FXML
    private TextArea textarea1;

    @FXML
    private Button attack;

    @FXML
    private Button skill;

    @FXML
    public ComboBox<Card> card;

    @FXML
    private Button escape;

    private Hero hero;
    private Monster monster;

    @FXML
    void attack(ActionEvent event) {
        Combat.AttackPhase(hero,monster);
        textarea1.setText(textarea1.getText()+"\nYou chose to attack the monster! You attack monster for " + hero.getDamage()
                + ", monster health is " + (monster.getHp() < 0 ? "0" : monster.getHp())+"\nMonster attacks back! Your health is " + hero.getHP());
        if (Skill.getSkillCD() > 0) Skill.setSkillCD(Skill.getSkillCD() - 1);
        if (monster.getHp() <= 0) {
            Stage stage = (javafx.stage.Stage) attack.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    void card(ActionEvent event) {
        System.out.println(this.card.getSelectionModel().getSelectedIndex());
        Card card = hero.getCard((this.card.getSelectionModel().getSelectedIndex()));
        hero.setInventory((this.card.getSelectionModel().getSelectedIndex()) + 1);

        if (card.getTag() == null) {
            System.out.print("\nWhoops! You picked a null card, try again...");
        }
        else if (card.getTag().equals("health")) {
            hero.setHP(hero.getHP() + card.getCardStat()); //adds health
            System.out.println("health");
        }
        else if (card.getTag().equals("damage")) {
            monster.setHp(hero.Attack(hero, monster) - card.getCardStat()); //adds attack
            System.out.println("damage");
        }
        else if (card.getTag().equals("escape")) {
            hero.setEscapeStat(hero.getEscapeStat() + 1);//adds to escape stat
        System.out.println("escape");
        }


        hero.setHP(monster.Attack(hero, monster));
        System.out.println("\ncode.Monster attacks back! Your health is " + (hero.getHP() < 0 ? "0" : hero.getHP()));
        updateInventory();
        if (Skill.getSkillCD() > 0) Skill.setSkillCD(Skill.getSkillCD() - 1);

    }

    @FXML
    void escape(ActionEvent event) {
        textarea1.setText(textarea1.getText() + "\nYou chose escape");
        if (Escape.Escape(hero.getEscapeStat())) {
            textarea1.setText(textarea1.getText() + "\nWow, you escaped!");
            hero.setEscapeStat(hero.getEscapeStat() - 1);
            Stage stage = (javafx.stage.Stage) attack.getScene().getWindow();
            stage.close();
        } else {
            textarea1.setText(textarea1.getText() + "\nTough luck, you failed to escape!");
            hero.setEscapeStat(hero.getEscapeStat() - 1);
            hero.setHP(monster.AttackX(hero, monster, 2)); //if escape failed, player gets attacked with double damage
            textarea1.setText(textarea1.getText() + "\nMonster attacks your back for critical damage! \nYour health is " + hero.getHP());
            if (Skill.getSkillCD() > 0) Skill.setSkillCD(Skill.getSkillCD() - 1);

        }
    }

    @FXML
    void skill(ActionEvent event) {
        if (hero.getHeroSkill().getSkillCD() == 0) {
            //console.close();
            SkillUsePhase.SkillUsePhase(hero, monster);
            switch (hero.getHeroSkill().getSkillNo()) {
                case 1:
                    textarea1.setText(textarea1.getText() + "\nYou attack the monster with fury! The damage is " + hero.getDamage()*2
                            + "! code.Monster health is " +monster.getHp());
                    //mob attack back
                    textarea1.setText(textarea1.getText() + "\ncode.Monster attacks back! Your health is " + hero.getHP());
                    Skill.setSkillCD(2);//Sets cooldown on 2, so it would be available again in one turn
//                code.CombatGUI.CombatMenu(hero, mob);
                    break;

                case 2:
                    textarea1.setText(textarea1.getText() + "\nYou attack monster for " + hero.getDamage() + ", monster health is " +monster.getHp());
                    //mob attack back
                    textarea1.setText(textarea1.getText() + "\ncode.Monster attacks back for "+ monster.getDmg() +"! Lucky you use shield and defend yourself, halving the damage!"
                            + " You health is " + hero.getHP());
                    Skill.setSkillCD(2);
//                code.CombatGUI.CombatMenu(hero, mob);
                    break;
            }
        } else {
            textarea1.setText(textarea1.getText() + "\nYour skill is on cooldown! Your skill will be available in " + hero.getHeroSkill().getSkillCD()
                    + " turns. Please try again.");
            Skill.setSkillCD(Skill.getSkillCD() + 1);
        }
        if (Skill.getSkillCD() > 0) Skill.setSkillCD(Skill.getSkillCD() - 1);

    }

    public void updateInventory() {
        ObservableList<Card> observableList = FXCollections.observableArrayList(hero.getCardArr());
        this.card.setItems(observableList);
    }

    public TextArea getTextarea1() {
        return textarea1;
    }

    public void setTextarea1(String text) {
        this.textarea1.setText(text);
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
