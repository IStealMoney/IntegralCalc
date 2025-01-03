package com.aicherlenja.integralcalc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;

public class Main extends Application {

    private static GUIController controller;

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("GUI.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        //GUICS cs = new GUICS(); // coordinate system
        //cs.drawCs();
        stage.initStyle(StageStyle.DECORATED);
        stage.setTitle("IntegralCalc");
        stage.setScene(scene);
        //stage.setFullScreen(true);
        stage.show();

        //stage event listener
        stage.setOnCloseRequest(event -> {
            System.out.println("Closing");
        });
    }

    public static void main(String[] args) {
        launch();
    }

    public static GUIController getController() {
        if (controller == null) {
            controller = new GUIController();
        }
        return controller;
    }
}