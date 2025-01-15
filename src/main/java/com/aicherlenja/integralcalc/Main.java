package com.aicherlenja.integralcalc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

    private static GUIController controller;
    private Scene scene;
    private static Stage stage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        System.out.println("Primary Stage: " + primaryStage);
        changeScene("GUI.fxml");

        //stage event listener
        stage.setOnCloseRequest(event -> {
            System.out.println("Closing");
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void changeScene(String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent guiRoot = loader.load();
        if (stage == null) {
            System.out.println("Stage is not initialized!");
        }
        try {
            if (fxml.equals("GUI.fxml")) {
                GUICS cs = new GUICS(); // coordinate system
                Node coordSystemNode = cs.createCoordinateSystem();

                SplitPane splitPane = new SplitPane();
                splitPane.getItems().addAll(guiRoot, coordSystemNode);
                splitPane.setDividerPositions(0.3);

                scene = new Scene(splitPane, 800, 600);
                stage.setTitle("IntegralCalc");
            } else if (fxml.equals("HelpPage.fxml")) {
                scene = new Scene(guiRoot, 800, 600);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error loading FXML file: " + fxml);
            return;
        }

        //stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static GUIController getController() {
        if (controller == null) {
            controller = new GUIController();
        }
        return controller;
    }
}