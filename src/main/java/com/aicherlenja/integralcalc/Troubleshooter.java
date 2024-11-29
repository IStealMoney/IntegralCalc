package com.aicherlenja.integralcalc;

public class Troubleshooter {

    public boolean correctUserInput()  {
        GUIController guiCon = new GUIController();

        // x2 smaller than x1
        if(guiCon.uiX2 < guiCon.uiX1) {
            guiCon.displayErrorX1X2("Error: The value of X2 needs to be greater than the value of X1!");
            return false;
        }

        // too much entries for linear function
        if (guiCon.uiTextFieldC == 0) {
            //guiCon.displayErrorLinTooMuch("You just need to fill in values for a and b!");
            return false;
        }

        return true;
    }
}
