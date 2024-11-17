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
    String[] comboBoxOptions = {"Polynomfunktionen" /*ganzrationale Funktionen*/, "Logarithmische/ Exponential", "Trigonometrische", "1/x", "Zusammengesetzte"};

    @FXML
    private Label labelA, labelB, labelC, labelX1, labelX2;

    @FXML
    private TextField textFieldA, textFieldB, textFieldC, textFieldD, textFieldX1, textFieldX2;

    @FXML
    private TextArea textArea = new TextArea();

    @FXML
    ComboBox comboBox = new ComboBox();

    @FXML
    private void initialize() {
        textArea.setEditable(false);
        textArea.setText("output");
        comboBox.setItems(FXCollections.observableArrayList(comboBoxOptions));
    }


    @FXML
    public void handleSubmitBtn() {
        Troubleshooter troubleshooter = new Troubleshooter();
        Polynom polynom = new Polynom();

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
            if(comboBox.getValue() == comboBoxOptions[0]) { //polynom
                polynom.calculateArea();
            }
        }
    }

    @FXML
    public void displayErrorX1X2(String valueTextArea) {
        System.out.println("here");
        textArea.setText("valueTextArea");
    }

    public void displayErrorLinTooMuch(String valueTextArea) {
        textArea.setText(valueTextArea);
    }

    public void showSolution(float solution) {
        textArea.setText(String.valueOf(solution));

    }
}
