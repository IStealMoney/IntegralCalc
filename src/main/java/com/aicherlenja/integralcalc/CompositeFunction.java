package com.aicherlenja.integralcalc;

import javafx.application.Platform;

import static com.aicherlenja.integralcalc.GUIController.uiX1;
import static com.aicherlenja.integralcalc.GUIController.uiX2;

public class CompositeFunction { // manages function components
    public static double coefficient, exponent;
    public static String exponentPart;

    public static void separateFunction() {
        String[] functionSplit = GUIController.function.split("(?=[+-])");

        for (String s : functionSplit) {
            s = s.trim();

            System.out.println("Eingegeben: " + s);

            coefficient = findCoefficient(s);
            exponent = findExponent(s);


            // calculate integral for specific function type
            switch (GUIController.selectedComboBox) {
                case "Polynomial":
                    Polynomial polynomial = new Polynomial(coefficient, exponent);
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

    private static double findCoefficient(String s) {
        if (s.substring(0,1).equals("x") ||
                (s.substring(0,1).equals("+") && s.substring(1,2).equals("x"))) {
            coefficient = 1;
        } else if (s.substring(0,1).equals("-") && s.substring(1,2).equals("x")) {
            coefficient = -1;
        } else {
            coefficient = Float.parseFloat(s.substring(0, s.indexOf("x")));
        }
//        //test
//        System.out.println("Coefficient: " + coefficient);
//        for (int i = 0; i < s.length(); i++) {
//            System.out.println(s.charAt(i) + " ");
//        }
        return coefficient;
    }

    private static double findExponent(String s) {
        if (s.contains("x")) {
            if (s.contains("^")) {
                exponentPart = s.substring(s.indexOf("^")+1, s.length()); // whole exponent (e.g. 2x)
                //if (exponentPart.matches("[-+]?\\d*\\.?\\d+")) {
                    //exponent = Float.parseFloat(exponentPart);
                //} else {
                    //throw new NumberFormatException("Invalid exponent format: " + exponentPart);
                //}
                exponent = Float.parseFloat(exponentPart);
            } else {
                exponent = 1;
            }
        } else {
//            System.out.println("Summand ohne x: " + s);
//            coefficient = Float.parseFloat(s);
//            s = (s + "x");
//            System.out.println("Summand mit x: " + s);
//            System.out.println("Coefficient: " + coefficient);
            exponent = 1;
        }
        return exponent;
    }

    public void evaluateWholeFunction() {

    }
}
