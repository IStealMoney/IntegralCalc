package com.aicherlenja.integralcalc;

public class Troubleshooter {

    public static String errorMessage = "";
    private boolean X2greaterX1;

    public boolean correctUserInput()  {
        GUIController guiCon = new GUIController();

        // x1 greater x2
        if(guiCon.uiX1 > guiCon.uiX2) {
            X2greaterX1 = true;
            return false;
        }

        // too many entries for linear function
        if (guiCon.uiTextFieldC == 0) {
            //guiCon.displayErrorLinTooMuch("You just need to fill in values for a and b!");
            return false;
        }

        return true;
    }

    public String getErrorMessage() {
        if (X2greaterX1) {
            errorMessage = "Error: X2 needs to be greater than X1!";
        }
        return errorMessage;
    }
}
