package com.aicherlenja.integralcalc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {
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
}