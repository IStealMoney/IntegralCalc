package com.aicherlenja.integralcalc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("GUI.fxml"));
        ToggleGroup toggleGroup = new ToggleGroup();

        // center left
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.setAlignment(Pos.CENTER_LEFT);
        vbox.setPadding(new Insets(10));

        Label labelA = new Label("a: ");
        vbox.getChildren().add(labelA);

        Label labelB = new Label("b");
        vbox.getChildren().add(labelB);

        //center top
        VBox vboxTop = new VBox(5);
        vboxTop.setAlignment(Pos.TOP_CENTER);
        vboxTop.setPadding(new Insets(10));

        RadioButton linearType = new RadioButton("linear");
        linearType.setSelected(true);
        linearType.setToggleGroup(toggleGroup);
        vboxTop.getChildren().add(linearType);
        RadioButton quadType = new RadioButton("quadratic");
        quadType.setToggleGroup(toggleGroup);
        vboxTop.getChildren().add(quadType);
        RadioButton sinusType = new RadioButton("sinus");
        sinusType.setToggleGroup(toggleGroup);
        vboxTop.getChildren().add(sinusType);



        Label labelMain = new Label("Enter function values:");
        vboxTop.getChildren().add(labelMain);

        TextField txtFieldA = new TextField();
        vboxTop.getChildren().add(txtFieldA);

        TextField textField = new TextField();
        vboxTop.getChildren().add(textField);

        Button button = new Button("Submit");
        vboxTop.getChildren().add(button);

        TextArea textArea = new TextArea();
        textArea.setEditable(false);
        vboxTop.getChildren().add(textArea);

        button.setOnAction(e -> {
            String name = textField.getText();
            textArea.appendText("Integral: " + name + "\n");
        });

        Scene scene = new Scene(vboxTop, 800, 500);

        stage.setTitle("IntegralCalc");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}