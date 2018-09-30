package GUI;

import code.Hero;
import code.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
    private Button L00;

    @FXML
    private Button L01;

    @FXML
    private Button L02;

    @FXML
    private Button L10;

    @FXML
    private Button L11;

    @FXML
    private Button L12;

    @FXML
    private Button L20;

    @FXML
    private Button L21;

    @FXML
    private Button L22;

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
    void UP(ActionEvent event) {

        arrayButton[gameStage.getX()][gameStage.getY()].setText("[   ]");
        gameStage.setX(gameStage.getX() - 1);
        arrayButton[gameStage.getX()][gameStage.getY()].setText("[ * ]");

    }

    @FXML
    void DOWN(ActionEvent event) {
        arrayButton[gameStage.getX()][gameStage.getY()].setText("[   ]");
        gameStage.setX(gameStage.getX() + 1);
        arrayButton[gameStage.getX()][gameStage.getY()].setText("[ * ]");
    }

    @FXML
    public void LEFT(ActionEvent event) {
        arrayButton[gameStage.getX()][gameStage.getY()].setText("[   ]");
        gameStage.setY(gameStage.getY() - 1);
        arrayButton[gameStage.getX()][gameStage.getY()].setText("[ * ]");
    }

    @FXML
    public void RIGHT(ActionEvent event) {
        arrayButton[gameStage.getX()][gameStage.getY()].setText("[   ]");
        gameStage.setY(gameStage.getY() + 1);
        arrayButton[gameStage.getX()][gameStage.getY()].setText("[ * ]");
    }




//    public Hero run(Hero hero, Stage gameStage) throws IOException {
//        javafx.stage.Stage stage = new javafx.stage.Stage();
//        FXMLLoader loader = new FXMLLoader();
//        Parent locationGUIScene = loader.load(getClass().getResourceAsStream("locationGUI.fxml"));
//        locationGUIController = loader.getController();
//        stage.setScene(new Scene(locationGUIScene));
//        setStage(gameStage);
//        setHero(hero);
//        updateInfo(locationGUIController);
//        stage.showAndWait();

//        return locationGUIController.hero;
//    }

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
        System.out.println(hero.getName());
        heroName.setText(hero.getName());
        heroHP.setText(String.valueOf(hero.getHP()));
        heroLevel.setText(String.valueOf(hero.getLvl()));
        heroSkill.setText(String.valueOf(hero.heroSkill));
        heroInventory.setText(hero.getInventory());

    }
    public void updateLocation() {
//        L00.setText("[   ]");
//        L01.setText("[   ]");
//        L02.setText("[   ]");
//        L10.setText("[   ]");
//        L11.setText("[   ]");
//        L12.setText("[   ]");
//        L20.setText("[   ]");
//        L21.setText("[   ]");
//        L22.setText("[   ]");

//        gameStage.getX()
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
