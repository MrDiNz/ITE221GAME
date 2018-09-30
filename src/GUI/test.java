package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import code.*;

public class test extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
//        crreate hero
        Hero hero = new CreateHero().run();
        System.out.println(hero);
//        generate stage
        code.Stage easyStage = new code.Stage("easy");
        code.Stage mediumStage = new code.Stage("medium");
        code.Stage hardStage = new code.Stage("hard");
//        send hero and stage to game play

        javafx.stage.Stage stage = new javafx.stage.Stage();
        FXMLLoader loader = new FXMLLoader();
        Parent locationGUIScene = loader.load(getClass().getResourceAsStream("locationGUI.fxml"));
        locationGUI locationGUIController = loader.getController();
        stage.setScene(new Scene(locationGUIScene));
        locationGUIController.setStage(easyStage);
        locationGUIController.setHero(hero);
        locationGUIController.updateInfo();
        stage.showAndWait();




//        hero = new locationGUI().run(hero, easyStage);
//        System.out.println(hero);
    }
}
