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
    TextField textFieldA, textFieldB, textFieldC, textFieldX1, textFieldX2;

    @FXML
    RadioButton radioButtonLin, radioButtonQuad, radioButtonSin;

    @FXML
    TextArea textArea;



    public GUIController() {

    }

    @FXML
    private void initialize() {
        ToggleGroup tg = new ToggleGroup();
        radioButtonLin.setToggleGroup(tg);
        radioButtonQuad.setToggleGroup(tg);
        radioButtonSin.setToggleGroup(tg);
    }

    @FXML
    private void submitBtnPressed() {
        Troubleshooter troubleshooter = new Troubleshooter();
        troubleshooter.correctUserInput();
        if (radioButtonLin.isSelected()) {

        } else if (radioButtonQuad.isSelected()) {

        } else if (radioButtonSin.isSelected()) {

        }
    }
}
