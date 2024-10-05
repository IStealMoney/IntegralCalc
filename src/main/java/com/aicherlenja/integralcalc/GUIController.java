//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.aicherlenja.integralcalc;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class GUIController {    //UI control logic
    @FXML
    private Label labelA, labelB, labelC, labelX1, labelX2;

    @FXML
    private TextField textFieldA, textFieldB, textFieldC, textFieldX1, textFieldX2;

    @FXML
    private RadioButton radioButtonLin, radioButtonQuad, radioButtonSin;

    ToggleGroup toggleGroup = new ToggleGroup();


    public GUIController() {

    }

    @FXML
    private void initialize() {

    }

    @FXML
    private void submitBtnPressed() {
        if (radioButtonLin.isSelected()) {

        } else if (radioButtonQuad.isSelected()) {

        } else if (radioButtonSin.isSelected()) {

        }
    }
}
