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

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("GUI.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        ToggleGroup toggleGroup = new ToggleGroup(); //for RadioButton

        //Controller controller = new Controller();


        // center left
        VBox vboxLeft = new VBox(5);
        vboxLeft.setAlignment(Pos.CENTER_LEFT);
        vboxLeft.setPadding(new Insets(10));

        Label labelA = new Label("a: ");
        vboxLeft.getChildren().add(labelA);

        Label labelB = new Label("b");
        vboxLeft.getChildren().add(labelB);

        vboxLeft.setAlignment(Pos.TOP_CENTER);
        vboxLeft.setPadding(new Insets(10));

        RadioButton linearType = new RadioButton("linear");
        linearType.setSelected(true);
        linearType.setToggleGroup(toggleGroup);
        vboxLeft.getChildren().add(linearType);
        RadioButton quadType = new RadioButton("quadratic");
        quadType.setToggleGroup(toggleGroup);
        vboxLeft.getChildren().add(quadType);
        RadioButton sinusType = new RadioButton("sinus");
        sinusType.setToggleGroup(toggleGroup);
        vboxLeft.getChildren().add(sinusType);

        Label labelMain = new Label("Enter function values:");
        vboxLeft.getChildren().add(labelMain);

        TextField txtFieldA = new TextField();
        vboxLeft.getChildren().add(txtFieldA);

        TextField textField = new TextField();
        vboxLeft.getChildren().add(textField);

        Button buttonSubmit = new Button("Submit");
        vboxLeft.getChildren().add(buttonSubmit);

        buttonSubmit.setOnAction(e -> {
            //Controller controller = new Controller();
            //controller.submitBtnPressed();
        });

        TextArea textArea = new TextArea();
        textArea.setEditable(false);
        vboxLeft.getChildren().add(textArea);

        stage.setTitle("IntegralCalc");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}