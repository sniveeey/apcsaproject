package main;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pages.TitleScreen;

public class Main extends Application {

    private static Stage stage;

    @Override
    public void start(Stage stage) {
        Main.stage = stage;
        stage.setScene(TitleScreen.getScene());
        stage.show();
    }

    public static void setScene(Scene scene) {
        stage.setScene(scene);
    }

    public static Stage getStage() {
        return stage;
    }

    public static void main(String[] args) {
        launch();
    }
}