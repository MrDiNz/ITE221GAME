package GUI;

import code.Hero;
import code.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class locationGUI {
    private Hero hero;


    public Hero run(Hero hero, Stage gameStage) throws IOException {
        javafx.stage.Stage stage = new javafx.stage.Stage();
        FXMLLoader loader = new FXMLLoader();
        Parent locationGUIScene = loader.load(getClass().getResourceAsStream("locationGUI.fxml"));
        locationGUI locationGUIController = loader.getController();
        stage.setScene(new Scene(locationGUIScene));



        return locationGUIController.hero;
    }
}
