package com.aicherlenja.integralcalc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

import static com.aicherlenja.integralcalc.SettingsMenuController.themeSwitcher;

public class Main extends Application { // stage, switch scenes, themes

    private static GUIController controller;
    public static Scene scene;
    private static Stage stage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        switchScene("GUI.fxml");

        // stage event listener
        stage.setOnCloseRequest(event -> {
            System.out.println("Closing");
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void switchScene(String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent guiRoot = loader.load();
        guiRoot.getStylesheets().add(getClass().getResource(themeSwitcher).toExternalForm());
        try {
            if (fxml.equals("GUI.fxml")) {
                CartCoordSys cCS = new CartCoordSys();
                cCS.drawCoordSys();
                SplitPane splitPane = new SplitPane();
                splitPane.getItems().addAll(guiRoot, CartCoordSys.cViewer);
                splitPane.setDividerPositions(0.3);

                scene = new Scene(splitPane, 800, 600);
                stage.setTitle("IntegralCalc");
            } else if (fxml.equals("SettingsMenu.fxml")) {
                scene = new Scene(guiRoot, 800, 600);
            } else if (fxml.equals("HelpPage.fxml")) {
                scene = new Scene(guiRoot, 800, 600);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error loading FXML file: " + fxml);
            return;
        }
        updateTheme(themeSwitcher);
        System.out.println(themeSwitcher);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public void updateTheme(String themeSwitcher) {
        scene.getStylesheets().clear();
        scene.getStylesheets().add(getClass().getResource(themeSwitcher).toExternalForm());
//        for (Window window : Stage.getWindows()) {
//            if (window instanceof Stage) {
//                Scene scene = ((Stage) window).getScene();
//                if (scene != null) {
//
//                }
//            }
//        }
    }

    public static GUIController getController() {   // currently not in use
        if (controller == null) {
            controller = new GUIController();
        }
        return controller;
    }
}