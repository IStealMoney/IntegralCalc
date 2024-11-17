package com.aicherlenja.integralcalc;

public class Troubleshooter {

    public boolean correctUserInput()  {
        GUIController guiCon = new GUIController();

        System.out.println(guiCon.uiX1 + " " + guiCon.uiX2);

        // x2 smaller than x1
        if(guiCon.uiX2 < guiCon.uiX1) {
            System.out.println("hola");
            guiCon.displayErrorX1X2("Error: The value of X2 needs to be greater than the value of X1!");
            return false;
        }

        // too much entries for linear function
        if (guiCon.uiLin && guiCon.uiTextFieldC == 0) {
            guiCon.displayErrorLinTooMuch("You just need to fill in values for a and b!");
            return false;
        }


        return true;

    }
}
