package com.aicherlenja.integralcalc;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

import java.io.IOException;

public class HelpMenuController {

    @FXML
    private TextArea textAreaHelp = new TextArea();

    @FXML
    private void initialize() {
        textAreaHelp.setEditable(false);
    }

    @FXML
    private void handleGoBack() throws IOException {
        Main main = new Main();
        main.switchScene("GUI.fxml");
    }
}
