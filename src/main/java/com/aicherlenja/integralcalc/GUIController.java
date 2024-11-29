//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.aicherlenja.integralcalc;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class GUIController {    //UI control logic

    public static float uiTextFieldA, uiTextFieldB, uiTextFieldC, uiTextFieldD, uiX1, uiX2;
    public static String valueTextArea;
    public static String[] comboBoxOptions = {"Polynomfunktion" /*ganzrationale Funktionen*/, "Logarithmische/ Exponential", "Trigonometrische", "1/x", "Zusammengesetzte"};

    @FXML
    private Label labelA, labelB, labelC, labelX1, labelX2, labelSolution;

    @FXML
    private TextField textFieldA, textFieldB, textFieldC, textFieldD, textFieldX1, textFieldX2;

    @FXML
    ComboBox comboBox = new ComboBox();

    @FXML
    private void initialize() {
        //labelSolution.setText("Your solution");
        labelSolution = new Label("Your solution");
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
    }

    @FXML
    public void displayErrorX1X2(String valueTextArea) {

    }

    public void displayErrorLinTooMuch(String valueTextArea) {

    }

    @FXML
    public void showSolution(float solution) {
        System.out.println(solution + "hi");
        labelSolution.setText(Float.toString(solution));

    }
}
