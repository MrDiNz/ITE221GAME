package GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import code.*;
import javafx.stage.Stage;

import java.io.IOException;

public class CreateHero {
    @FXML
    private TextField textfieldHeroname;

    @FXML
    private Button createHero;
    ObservableList<String> data = FXCollections.observableArrayList("Damage x2", "DamageToPlayer/2");
    @FXML
    private ComboBox<String> comboboxSkill = new ComboBox<>(data);
    @FXML
    Hero hero;



    public void createHero() {
        System.out.println(comboboxSkill.getSelectionModel().getSelectedIndex());
        if (comboboxSkill.getSelectionModel().getSelectedIndex() > 0) {
            hero = Hero.GUIHeroCreate(textfieldHeroname.getText(), comboboxSkill.getSelectionModel().getSelectedIndex() + 1);
        } else {
            hero = Hero.GUIHeroCreate(textfieldHeroname.getText(), 1);
        }

        Stage stage = (Stage) createHero.getScene().getWindow();
        stage.close();
    }


    public Hero run() throws IOException {
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResourceAsStream("Createhero.fxml"));
        CreateHero heroController = loader.getController();
        primaryStage.setScene(new Scene(root));
        heroController.comboboxSkill.setItems(data);
        primaryStage.showAndWait();
        return heroController.hero;
    }
}
