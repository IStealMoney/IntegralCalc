//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.aicherlenja.integralcalc;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class GUIController {    //UI control logic

    public float uiTextFieldA, uiTextFieldB, uiTextFieldC, uiX1, uiX2;
    public boolean uiLin, uiQuad, uiSin;
    public String valueTextArea;

    @FXML
    private Label labelA, labelB, labelC, labelX1, labelX2;

    @FXML
    private TextField textFieldA, textFieldB, textFieldC, textFieldX1, textFieldX2;

    @FXML
    private RadioButton radioButtonLin, radioButtonQuad, radioButtonSin;

    @FXML
    private TextArea textArea = new TextArea();

    @FXML
    private void initialize() {
        ToggleGroup tg = new ToggleGroup();
        radioButtonLin.setToggleGroup(tg);
        radioButtonQuad.setToggleGroup(tg);
        radioButtonSin.setToggleGroup(tg);
    }

    @FXML
    public void handleSubmitBtn() {
        Troubleshooter troubleshooter = new Troubleshooter();
        Linear linear = new Linear();
        Quad quad = new Quad();
        Sinus sinus = new Sinus();

        //user input
        try {
            uiTextFieldA = Float.parseFloat(textFieldA.getText());
            uiTextFieldB = Float.parseFloat(textFieldB.getText());
            uiTextFieldC = Float.parseFloat(textFieldC.getText());
            uiX1 = Float.parseFloat(textFieldX1.getText());
            uiX2 = Float.parseFloat(textFieldX2.getText());
            uiLin = radioButtonLin.isSelected();
            uiQuad = radioButtonQuad.isSelected();
            uiSin = radioButtonSin.isSelected();
        } catch(NumberFormatException e) {
            // nichts
        }

        if (troubleshooter.correctUserInput()) {
            if (radioButtonLin.isSelected()) {
                linear.calculateArea();
            } else if (radioButtonQuad.isSelected()) {
                quad.calculateArea();
            } else if (radioButtonSin.isSelected()) {
                sinus.calculateArea();
            }
        }
    }

    public void displayErrorX1X2() {
        valueTextArea = "Error: The value of X2 needs to be greater than the value of X1!";
        textArea.setText(valueTextArea);
    }

    public void displayErrorLinTooMuch() {
        valueTextArea = "You just need to fill in values for a and b!";
        textArea.setText(valueTextArea);
    }

    public void showSolution(float solution) {
        textArea.setText(String.valueOf(solution));

    }
}
