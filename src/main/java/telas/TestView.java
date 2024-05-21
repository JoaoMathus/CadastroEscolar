package telas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TestView extends Application {
    @Override
    public void start(Stage stage) {
        Label l = new Label("JavaFX em funcionamento!");
        Scene scene = new Scene(new StackPane(l), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    // Não executar o programa por aqui!!!
    public static void main(String[] args) {
        launch();
    }
}
