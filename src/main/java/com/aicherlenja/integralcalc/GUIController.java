//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.aicherlenja.integralcalc;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.awt.event.ActionEvent;

public class GUIController {    //UI control logic

    public static double uiX1, uiX2;
    public static String function, selectedComboBox, errorMessage;
    public static String[] comboBoxOptions = {"Polynomial functions", "Exponential functions", "Logarithmic functions", "Trigonometric functions", "Root functions", "Composite functions"};

    @FXML
    private TextArea textArea = new TextArea();

    @FXML
    private TextField textFieldX1, textFieldX2, functionField;

    @FXML
    ComboBox comboBox = new ComboBox();

    @FXML
    private void initialize() {
        comboBox.setItems(FXCollections.observableArrayList(comboBoxOptions));
        comboBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                switch (t1) {
                    case "Polynomial functions":
                        functionField.setText("e.g. 3x^2");
                        break;
                    case "Exponential functions":
                        functionField.setText("e.g. 3*2^x");
                        break;
                    case "Logarithmic functions":
                        functionField.setText("e.g. log_10(x)");
                        break;
                    case "Trigonometric functions":
                        functionField.setText("e.g. sin(x)");
                        break;
                    case "Root functions":
                        functionField.setText("e.g. 1/x");
                        break;
                    case "Composite functions":
                        functionField.setText("e.g. 3x^2 + 3*2^x");
                        break;
                }
            }
        });
    }

    @FXML
    public void handleSubmitBtn() {
        Troubleshooter troubleshooter = new Troubleshooter();

        //user input
        try {
            function = functionField.getText();
            selectedComboBox = (String) comboBox.getValue();
            uiX1 = Double.parseDouble(textFieldX1.getText());
            uiX2 = Double.parseDouble(textFieldX2.getText());
        } catch(NumberFormatException e) {
            Platform.runLater(() -> textArea.setText("NumberFormatException"));
        }

        if (troubleshooter.correctUserInput(uiX1, uiX2)) {
            CompositeFunction compFunc = new CompositeFunction();
            compFunc.separateFunction();   //separates function and calls specific function method
            showSolution(CompositeFunction.solutionArea, CompositeFunction.evaluatedFunction);
        } else {
            errorMessage = troubleshooter.getErrorMessage();
            textArea.setText(errorMessage);
            System.out.println(errorMessage);
        }
    }

    @FXML
    public void handleHelpButton() {
        // switch scene
        System.out.println("User needs help!");
    }

    public void showSolution(double solutionArea, String evaluatedFunction) {
        System.out.println(evaluatedFunction);
        System.out.println(solutionArea);
        Platform.runLater(() -> textArea.setText("Area: " + (Double.toString(solutionArea)) + "\nAntiderivative: " + evaluatedFunction));
    }
}
