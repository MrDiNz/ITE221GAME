package code;

import GUI.CreateHero;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainGUI extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//        create hero
        Hero hero = new CreateHero().run();
        System.out.println(hero);
//        generate stage
        code.Stage easyStage = new code.Stage("easy");
        code.Stage mediumStage = new code.Stage("medium");
        code.Stage hardStage = new code.Stage("hard");


    }
}
