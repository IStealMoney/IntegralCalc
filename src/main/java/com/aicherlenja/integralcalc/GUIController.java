//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.aicherlenja.integralcalc;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class GUIController {    //UI control logic

    @FXML
    private Label labelA, labelB, labelC, labelX1, labelX2;

    @FXML
    private TextField textFieldA, textFieldB, textFieldC, textFieldX1, textFieldX2;

    @FXML
    private RadioButton radioButtonLin, radioButtonQuad, radioButtonSin;

    @FXML
    private TextArea textArea;

    @FXML
    private void initialize() {
        ToggleGroup tg = new ToggleGroup();
        radioButtonLin.setToggleGroup(tg);
        radioButtonQuad.setToggleGroup(tg);
        radioButtonSin.setToggleGroup(tg);
    }

    @FXML
    private void handleSubmitBtn() {
        Troubleshooter troubleshooter = new Troubleshooter();
        Linear linear = new Linear();
        Quad quad = new Quad();
        Sinus sinus = new Sinus();

        float uiTextFieldA = Float.parseFloat(textFieldA.getText());
        float uiTextFieldB = Float.parseFloat(textFieldB.getText());
        float uiTextFieldC = Float.parseFloat(textFieldC.getText());
        float uiTextFieldX1 = Float.parseFloat(textFieldX1.getText());
        float uiTextFieldX2 = Float.parseFloat(textFieldX2.getText());
        boolean uiRadioButtonLin = radioButtonLin.isSelected();
        boolean uiRadioButtonQuad = radioButtonQuad.isSelected();
        boolean uiRadioButtonSin = radioButtonSin.isSelected();

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
}
