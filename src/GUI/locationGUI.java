package GUI;

import code.Hero;
import code.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import code.*;

public class locationGUI implements Initializable {
    private Stage gameStage;
    private Hero hero;
    @FXML
    private Button[][] arrayButton;
    @FXML
    private Button L00,L01,L02,L10,L11,L12,L20,L21, L22;

    @FXML
    private Button buttonUP;

    @FXML
    private Button buttonLEFT;

    @FXML
    private Button buttonDOWN;

    @FXML
    private Button buttonRIGHT;
    @FXML
    private Label heroName;

    @FXML
    private Label heroLevel;

    @FXML
    private Label heroHP;

    @FXML
    private Label heroSkill;

    @FXML
    private Text heroInventory;

    @FXML
    private BorderPane pane;

    private int monsterDefeatedCount = 0;

    @FXML
    void UP(ActionEvent event) throws IOException {

        arrayButton[gameStage.getX()][gameStage.getY()].setText("[   ]");
        gameStage.setX(gameStage.getX() - 1);
        arrayButton[gameStage.getX()][gameStage.getY()].setText("[ * ]");
        combat(hero, gameStage.getStage(gameStage.getX(), gameStage.getY()));

    }

    @FXML
    void DOWN(ActionEvent event) throws IOException {
        arrayButton[gameStage.getX()][gameStage.getY()].setText("[   ]");
        gameStage.setX(gameStage.getX() + 1);
        arrayButton[gameStage.getX()][gameStage.getY()].setText("[ * ]");
        combat(hero, gameStage.getStage(gameStage.getX(), gameStage.getY()));
    }

    @FXML
    public void LEFT(ActionEvent event) throws IOException {
        arrayButton[gameStage.getX()][gameStage.getY()].setText("[   ]");
        gameStage.setY(gameStage.getY() - 1);
        arrayButton[gameStage.getX()][gameStage.getY()].setText("[ * ]");
        combat(hero, gameStage.getStage(gameStage.getX(), gameStage.getY()));
    }

    @FXML
    public void RIGHT(ActionEvent event) throws IOException {
        arrayButton[gameStage.getX()][gameStage.getY()].setText("[   ]");
        gameStage.setY(gameStage.getY() + 1);
        arrayButton[gameStage.getX()][gameStage.getY()].setText("[ * ]");
        combat(hero, gameStage.getStage(gameStage.getX(), gameStage.getY()));
    }
    public void combat(Hero hero, Monster monster) throws IOException {
        if (gameStage.getStage(gameStage.getX(), gameStage.getY()) != null) {
//               GUI fight start here
            FXMLLoader loader = new FXMLLoader();
            Parent combatScene = loader.load(getClass().getResourceAsStream("CombatGUI.fxml"));
            CombatGUI combatGUI = loader.getController();
            javafx.stage.Stage stage = new javafx.stage.Stage();
            stage.setScene(new Scene(combatScene));
            combatGUI.setTextarea1("" +
                    "===================TURN START======================\n" +
                    monster+"\n" +
                    "What do you want to do?");
            combatGUI.setHero(hero);
            combatGUI.setMonster(monster);
            System.out.println(hero.getInventory());
            combatGUI.updateInventory();
//            ObservableList<Card> observableList = FXCollections.observableArrayList(hero.getCardArr());
//            combatGUI.card.setItems(observableList);
            pane.setDisable(true);
            stage.showAndWait();
            pane.setDisable(false);
            if (hero.getHP() > 0 && monster.getHp() <= 0) {
                gameStage.setMonsgterDie(gameStage.getX(), gameStage.getY());
            }



//            info update here
            updateInfo();

//            if (hero.getHP() > 0) {
//                monsterDefeatedCount++;
//            } else {
//                monsterDefeatedCount = 9;
//            }
        } else {
            System.out.println("No monster here");
        }
    }




    public Stage getStage() {
        return gameStage;
    }

    public void setStage(Stage stage) {
        this.gameStage = stage;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public void updateInfo() {
        System.out.println(this.hero.getName());
        heroName.setText(this.hero.getName());
        heroHP.setText(String.valueOf(this.hero.getHP()));
        heroLevel.setText(String.valueOf(this.hero.getLvl()));
        heroSkill.setText(String.valueOf(this.hero.heroSkill));
        heroInventory.setText(this.hero.getInventory());

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeButtonArray();
    }

    public void initializeButtonArray() {

        arrayButton = new Button[3][3];
        arrayButton[0][0] = L00;
        arrayButton[0][1] = L01;
        arrayButton[0][2] = L02;
        arrayButton[1][0] = L10;
        arrayButton[1][1] = L11;
        arrayButton[1][2] = L12;
        arrayButton[2][0] = L20;
        arrayButton[2][1] = L21;
        arrayButton[2][2] = L22;
    }
}
