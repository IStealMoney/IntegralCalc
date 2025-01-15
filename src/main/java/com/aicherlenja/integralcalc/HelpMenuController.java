package com.aicherlenja.integralcalc;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

import java.io.IOException;

public class HelpMenuController {

    public static String[] comboBoxOptions = {"Dark theme", "Light theme", "Purple"};
    private String themeSwitcher = "Dark theme";

    @FXML
    ComboBox themeComboBox = new ComboBox();

    public static void main(String[] args) {

    }

    @FXML
    private void initialize() {
        themeComboBox.setItems(FXCollections.observableArrayList(comboBoxOptions));
        themeComboBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                switch (t1) {
                    case "Dark theme":
                        themeSwitcher = "Dark theme";
                        break;
                    case "Light theme":
                        themeSwitcher = "Light theme";
                        break;
                    case "Dark purple":
                        themeSwitcher = "purple";
                        break;
                    default:
                        themeSwitcher = "Dark theme";
                }
            }
        });
    }

    @FXML
    private void handleAppearanceApplyButton() {
        System.out.println("Appearance apply button clicked");
        switch (themeSwitcher) {
            case "Dark theme":
                // load css?
                break;
            case "Light theme":

                break;
            case "Purple":

                break;
        }
    }

    @FXML
    private void handleGoBack() throws IOException {
        Main main = new Main();
        main.switchScene("GUI.fxml");
    }
}
