package ma.enset.examen.presentation;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Application extends javafx.application.Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        TabPane root = FXMLLoader.load(getClass().getResource("views/main.fxml"));
        Scene scene=new Scene(root,600,600);
        primaryStage.setTitle("Gestion des Commandes");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
