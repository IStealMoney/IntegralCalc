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

    public static float uiTextFieldA, uiTextFieldB, uiTextFieldC, uiTextFieldD, uiX1, uiX2;
    public static String valueTextArea;
    public static String[] comboBoxOptions = {"Polynomfunktion" /*ganzrationale Funktionen*/, "Logarithmische/ Exponential", "Trigonometrische", "1/x", "Zusammengesetzte"};

    @FXML
    private Label labelA, labelB, labelC, labelX1, labelX2;

    @FXML
    private Label labelSolution = new Label();

    @FXML
    private TextField textFieldA, textFieldB, textFieldC, textFieldD, textFieldX1, textFieldX2;

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
            uiTextFieldA = Float.parseFloat(textFieldA.getText());
            uiTextFieldB = Float.parseFloat(textFieldB.getText());
            uiTextFieldC = Float.parseFloat(textFieldC.getText());
            uiTextFieldD = Float.parseFloat(textFieldC.getText());
            uiX1 = Float.parseFloat(textFieldX1.getText());
            uiX2 = Float.parseFloat(textFieldX2.getText());
        } catch(NumberFormatException e) {
            System.out.println("NumberFormatException");
        }

        if (troubleshooter.correctUserInput()) {
            System.out.println("Correct user input");
            switch ((String) comboBox.getValue()) {
                case "Polynomfunktion":
                    Polynomial polynomial = new Polynomial();
                    polynomial.calculateArea(uiTextFieldA, uiTextFieldB, uiTextFieldC, uiTextFieldD, uiX1, uiX2);
                    break;
                case "Logarithmische/ Exponential":

                    break;
                case "Trigonometrische":

                    break;
                case "1/x":

                    break;
                case "Zusammengesetzte":

                    break;
            }
        }
        showSolution(solution);
    }

    public void displayErrorX1X2(String valueTextArea) {

    }

    public void displayErrorLinTooMuch(String valueTextArea) {

    }

    public void showSolution(float solution) {
        Platform.runLater(() -> labelSolution.setText(Float.toString(solution)));

    }
}
