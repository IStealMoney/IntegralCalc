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
    TextField textFieldA = new TextField();

    @FXML
    TextField textFieldB = new TextField();

    @FXML
    TextField textFieldC = new TextField();

    @FXML
    TextField textFieldX1 = new TextField();

    @FXML
    TextField textFieldX2 = new TextField();

    @FXML
    RadioButton radioButtonLin, radioButtonQuad, radioButtonSin;

    @FXML
    TextArea textArea = new TextArea();

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
        Linear linear = new Linear();
        Quad quad = new Quad();
        Sinus sinus = new Sinus();

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
