package com.aicherlenja.integralcalc;

import javafx.fxml.FXML;

import java.io.IOException;

public class HelpMenuController {
    public static void main(String[] args) {

    }

    @FXML
    public void handleGoBack() throws IOException {
        Main main = new Main();
        main.switchScene("GUI.fxml");
    }
}
