package com.aicherlenja.integralcalc;

import javafx.application.Platform;

import static com.aicherlenja.integralcalc.GUIController.uiX1;
import static com.aicherlenja.integralcalc.GUIController.uiX2;

public class CompositeFunction { // manages function components
    public static float coefficient, exponent;
    public static String exponentPart;

    public static void separateFunction() {
        String[] functionSplit = GUIController.function.split("(?=[+-])");

        for (String s : functionSplit) {
            s = s.trim();
            //s = s.replaceAll("\\s", "");

            System.out.println("Eingegeben: " + s);

            coefficient = findCoefficient(s);
            exponent = findExponent(s);


            // calculate integral for specific function type
            switch (GUIController.selectedComboBox) {
                case "Polynomfunktion":
                    Polynomial polynomial = new Polynomial();
                    polynomial.calculateArea(uiX1, uiX2);
                    break;
                case "Logarithmische/ Exponential":

                    break;
                case "Trigonometrische":

                    break;
                case "1/x":

                    break;
                case "Zusammengesetzte":

                    break;
            }
        }
    }

    private static float findCoefficient(String s) {
        if (s.substring(0,1).equals("x") ||
                (s.substring(0,1).equals("+") && s.substring(1,2).equals("x"))) {
            coefficient = 1;
        } else if (s.substring(0,1).equals("-") && s.substring(1,2).equals("x")) {
            coefficient = -1;
        } else {
            coefficient = Float.parseFloat(s.substring(0, s.indexOf("x")));
        }
        //test
        System.out.println("Coefficient: " + coefficient);
        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i) + " ");
        }
        return coefficient;
    }

    private static float findExponent(String s) {
        if (s.contains("x")) {
            System.out.println("enthält x");
            if (s.contains("^")) {
                System.out.println("yes");
                exponentPart = s.substring(s.indexOf("^")+1, s.length()); // whole exponent (e.g. 2x)
                System.out.println(s.indexOf("^"));
                System.out.println(s.length());
                System.out.println("ExponentPart: " + exponentPart);
                //if (exponentPart.matches("[-+]?\\d*\\.?\\d+")) {
                    //exponent = Float.parseFloat(exponentPart);
                //} else {
                    //throw new NumberFormatException("Invalid exponent format: " + exponentPart);
                //}
            } else {
                exponent = 1;
            }
            System.out.println("Exponent: " + exponent);
        } else {
            System.out.println("Summand ohne x: " + s);
            s = (s + "x");
            System.out.println("Summand mit x: " + s);
            coefficient = findCoefficient(s);
            coefficient = Float.parseFloat(s.substring(0, s.indexOf("x")));
            System.out.println("Coefficient: " + coefficient);
            exponent = 0;
        }
        return exponent;
    }

    public void evaluateWholeFunction() {

    }

    private float powerExponentToFloat(char s) {
        switch (s) {
            case '⁰':
                return 0;
            case '¹':
                return 1;
            case '²':
                return 2;
            case '³':
                return 3;
            case '⁴':
                return 4;
            case '⁵':
                return 5;
            case '⁶':
                return 6;
            case '⁷':
                return 7;
            case '⁸':
                return 8;
            case '⁹':
                return 9;
        }
        throw new NumberFormatException("Invalid exponent format: " + s);
    }
}
