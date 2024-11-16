package com.aicherlenja.integralcalc;

public class Troubleshooter {

    public boolean correctUserInput()  {
        GUIController guiCon = new GUIController();


        // if value of x2 ist greater than value of x1
        if(guiCon.uiX2 < guiCon.uiX1) {
            guiCon.displayErrorX1X2();
        }

        // too much entries for linear function
        if (guiCon.uiLin && guiCon.uiTextFieldC == 0) {
            guiCon.displayErrorLinTooMuch();
        }

        return true;
    }
}
