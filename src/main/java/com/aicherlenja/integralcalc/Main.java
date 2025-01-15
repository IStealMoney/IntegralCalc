package com.aicherlenja.integralcalc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {

    private static GUIController controller;
    private Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GUI.fxml"));
        Parent guiRoot = loader.load();

        GUICS cs = new GUICS(); // coordinate system
        Node coordSystemNode = cs.createCoordinateSystem();

        SplitPane splitPane = new SplitPane();
        splitPane.getItems().addAll(guiRoot, coordSystemNode);
        splitPane.setDividerPositions(0.3);

        Scene scene = new Scene(splitPane, 800, 600);
        stage.setScene(scene);
        stage.setTitle("IntegralCalc");
        stage.setResizable(false);
        stage.setAlwaysOnTop(true);
        stage.show();

        //stage event listener
        stage.setOnCloseRequest(event -> {
            System.out.println("Closing");
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static GUIController getController() {
        if (controller == null) {
            controller = new GUIController();
        }
        return controller;
    }

    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(
                getClass().getResource(fxml));

        stage.getScene().setRoot(pane);
    }
}