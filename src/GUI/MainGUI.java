package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import code.*;

public class MainGUI extends Application {
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
        locationGUIController.setLabelLevel("Level 1");
        stage.showAndWait();

        //stage.hide();
       // stage.hide();

//        javafx.stage.Stage stage2 = new javafx.stage.Stage();
//        FXMLLoader loader2 = new FXMLLoader();
//        Parent locationGUIScene2 = loader2.load(getClass().getResourceAsStream("locationGUI.fxml"));
//        locationGUI locationGUIController2 = loader.getController();
//        stage.setScene(new Scene(locationGUIScene2));
//        locationGUIController2.setStage(mediumStage);
//        locationGUIController2.setHero(hero);
//        locationGUIController2.updateInfo();
//        locationGUIController2.setLabelLevel("Level 1");
//        stage2.showAndWait();
       // Stage s2 = new Stage();
        //stage.setScene(new Scene(locationGUIScene));
        locationGUIController.setLabelLevel("Level 2");
        locationGUIController.setStage(mediumStage);
        stage.showAndWait();
     //   s2.showAndWait();


        //stage.setScene(new Scene(locationGUIScene));
        locationGUIController.setLabelLevel("Level 3");
        locationGUIController.setStage(hardStage);
        stage.showAndWait();

//        hero = new locationGUI().run(hero, easyStage);
//        System.out.println(hero);
    }
}
