//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.aicherlenja.integralcalc;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;

public class GUIController {    //UI control logic

    public static double uiX1, uiX2;
    public static String function, errorMessage;

    @FXML
    private TextArea textAreaArea = new TextArea();

    @FXML
    private TextArea textAreaAntiderivative = new TextArea();

    @FXML
    private TextField textFieldX1, textFieldX2, functionField;

    @FXML
    private javafx.scene.control.Label labelErrorDisplay;

    @FXML
    private void initialize() {
        textAreaArea.setEditable(false);
        textAreaAntiderivative.setEditable(false);
        labelErrorDisplay.setVisible(true);
    }

    @FXML
    public void handleSubmitBtn() {
        Troubleshooter troubleshooter = new Troubleshooter();

        //user input
        try {
            function = functionField.getText();
            uiX1 = Double.parseDouble(textFieldX1.getText());
            uiX2 = Double.parseDouble(textFieldX2.getText());
        } catch(NumberFormatException e) {
            labelErrorDisplay.setText("NumberFormatException");
        }

        if (troubleshooter.correctUserInput(uiX1, uiX2)) {
            CompositeFunction compFunc = new CompositeFunction();
            compFunc.manageFunction();   //separates function and calls specific function method
            showSolution(CompositeFunction.solutionArea, CompositeFunction.evaluatedFunction);
        } else {
            errorMessage = troubleshooter.getErrorMessage();
            labelErrorDisplay.setText(errorMessage);
            System.out.println(errorMessage);
        }
    }

    @FXML
    public void handleHelpButton() throws IOException {
        Main main = new Main();
        main.switchScene("HelpPage.fxml");
    }

    @FXML
    public void handleSettingsButton() throws IOException {
        Main main = new Main();
        main.switchScene("SettingsMenu.fxml");
    }

    @FXML
    public void handleAreaCopyButton() {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection selection = new StringSelection(textAreaArea.getText());
        clipboard.setContents(selection, null);
    }

    @FXML
    public void handleAntiderivativeCopyButton() {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection selection = new StringSelection(textAreaAntiderivative.getText());
        clipboard.setContents(selection, null);
    }

    public void showSolution(double solutionArea, String evaluatedFunction) {
        textAreaAntiderivative.setText(evaluatedFunction);
        textAreaArea.setText(Double.toString(solutionArea));
    }
}
