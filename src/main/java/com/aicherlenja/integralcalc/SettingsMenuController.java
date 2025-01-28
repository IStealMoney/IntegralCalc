package com.aicherlenja.integralcalc;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

import java.io.IOException;

public class SettingsMenuController {
    public static String[] comboBoxOptions = {"Dark theme", "Light theme", "Purple theme"};
    public static String themeSwitcher = "dark-theme.css";

    @FXML
    ComboBox themeComboBox = new ComboBox();

    @FXML
    private TextArea textAreaInstructions = new TextArea();

    @FXML
    private void initialize() {
        textAreaInstructions.setEditable(false);
        themeComboBox.setItems(FXCollections.observableArrayList(comboBoxOptions));
        themeComboBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                switch (t1) {
                    case "Dark theme":
                        themeSwitcher = "dark-theme.css";
                        break;
                    case "Light theme":
                        themeSwitcher = "light-theme.css";
                        break;
                    case "Purple theme":
                        themeSwitcher = "purple-theme.css";
                        break;
                    default:
                        themeSwitcher = "dark-theme.css";
                }
                System.out.println(themeSwitcher);
            }
        });
    }

    @FXML
    private void handleAppearanceApplyButton() throws IOException {
        Main main = new Main();
        main.updateTheme(themeSwitcher);
        main.switchScene("GUI.fxml");
    }

    @FXML
    private void handleGoBack() throws IOException {
        Main main = new Main();
        main.switchScene("GUI.fxml");
    }
}
