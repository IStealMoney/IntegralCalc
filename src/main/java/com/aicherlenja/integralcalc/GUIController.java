//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.aicherlenja.integralcalc;

import javafx.application.Platform;
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
    private TextArea textArea = new TextArea();

    @FXML
    private TextField textFieldX1, textFieldX2, functionField;

    @FXML
    private void initialize() {

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
            Platform.runLater(() -> textArea.setText("NumberFormatException"));
        }

        if (troubleshooter.correctUserInput(uiX1, uiX2)) {
            CompositeFunction compFunc = new CompositeFunction();
            compFunc.manageFunction();   //separates function and calls specific function method
            showSolution(CompositeFunction.solutionArea, CompositeFunction.evaluatedFunction);
        } else {
            errorMessage = troubleshooter.getErrorMessage();
            textArea.setText(errorMessage);
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
    public void handleCopyButton() {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection selection = new StringSelection(textArea.getText());
        clipboard.setContents(selection, null);
    }

    public void showSolution(double solutionArea, String evaluatedFunction) {
        System.out.println(evaluatedFunction);
        System.out.println(solutionArea);
        Platform.runLater(() -> textArea.setText("Area: " + (Double.toString(solutionArea)) + "\nAntiderivative: " + evaluatedFunction));
    }
}
