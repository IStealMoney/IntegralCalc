//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.aicherlenja.integralcalc;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class GUIController {    //UI control logic

    public static double uiX1, uiX2;
    public static String function, selectedComboBox, errorMessage;
    public static String[] comboBoxOptions = {"Polynomial functions", "Logarithmic/ Exponential functions", "Trigonometric functions", "Root functions", "Composite functions"};

    @FXML
    private TextArea textArea = new TextArea();

    @FXML
    private TextField textFieldX1, textFieldX2, functionField;

    @FXML
    ComboBox comboBox = new ComboBox();

    @FXML
    private void initialize() {
        comboBox.setItems(FXCollections.observableArrayList(comboBoxOptions));
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

    public void showSolution(double solutionArea, String evaluatedFunction) {
        System.out.println(evaluatedFunction);
        System.out.println(solutionArea);
        Platform.runLater(() -> textArea.setText("Area: " + (Double.toString(solutionArea)) + "\n Integrated function: " + evaluatedFunction));
    }
}
