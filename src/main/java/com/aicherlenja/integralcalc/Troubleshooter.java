package com.aicherlenja.integralcalc;

public class Troubleshooter {

    public static String errorMessage = "";
    private static boolean X2greaterX1, stringIsNull;

    public boolean correctUserInput(double uiX1, double uiX2)  {
        GUIController guiCon = new GUIController();

        // x1 greater x2
        if(uiX1 > uiX2) {
            X2greaterX1 = true;
            return false;
        }

        return true;
    }

    public static boolean isStringNull(String s) {
        if (s == null || s.isEmpty()) {
            stringIsNull = true;
            return true;
        }
        return false;
    }

    public String getErrorMessage() {
        if (X2greaterX1) {
             return "Error: x2 needs to be\ngreater than x1";
        }
        if (stringIsNull) {
            return "Input string 's' (evaluated) cannot be null or empty";
        }
        return "lol";
    }
}
