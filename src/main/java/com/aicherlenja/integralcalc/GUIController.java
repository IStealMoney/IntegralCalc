//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.aicherlenja.integralcalc;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import static com.aicherlenja.integralcalc.Polynomial.solution;

public class GUIController {    //UI control logic

    public static double uiX1, uiX2;
    public static String function, selectedComboBox;
    public static String[] comboBoxOptions = {"Polynomfunktion" /*ganzrationale Funktionen*/, "Logarithmische/ Exponential", "Trigonometrische", "1/x", "Zusammengesetzte"};

    @FXML
    private TextArea textArea = new TextArea();

    @FXML
    private Label labelSolution = new Label();

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
            Platform.runLater(() -> labelSolution.setText("NumberFormatException"));
        }

        if (troubleshooter.correctUserInput()) {
            System.out.println("Correct user input");

            //separates function and calls specific function method
            CompositeFunction.separateFunction();

            showSolution(solution);
        } else {
            troubleshooter.getErrorMessage();
            labelSolution.setText(troubleshooter.errorMessage);
        }
    }

    public void showSolution(double solution) {
        Platform.runLater(() -> labelSolution.setText(Double.toString(solution)));

    }
}
