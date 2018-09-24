package be.pxl.computerstore;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class ComputerSystemConfiguratorApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }


    public void start(Stage primaryStage) throws Exception {
        URL resource = getClass().getResource("computer_configurator.fxml");
        System.out.println(resource.toURI());
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root, 650,550);
        primaryStage.setTitle("Configure computer ...");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
