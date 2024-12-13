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
            //s = s.trim();
            s = s.replaceAll("\\s", ""); // for spaces

            System.out.println("Verarbeite Summand: " + s);

            //without coefficient
            if (s.substring(0,1).equals("x")) {
                coefficient = 1;
            } else {    //with coefficient
                coefficient = Float.parseFloat(s.substring(0, s.indexOf("x")));
            }

            System.out.println("Coefficient: " + coefficient);

            for (int i = 0; i < s.length(); i++) {
                System.out.println(s.charAt(i) + " ");
            }

            //exponent
            if (s.contains("x")) {
                System.out.println("enthält x");
                if (s.contains("^")) {
                    if(s.indexOf("^")+1 < s.length()) {
                        exponentPart = s.substring(s.indexOf("^")+1, s.lastIndexOf("^"));

                        if (exponentPart.matches("[-+]?\\d*\\.?\\d+")) {
                            exponent = Float.parseFloat(exponentPart);
                        } else {
                            throw new NumberFormatException("Invalid exponent format: " + exponentPart);
                        }
                    } else {
                        throw new NumberFormatException("Invalid exponent format: " + exponentPart);
                    }
                } else {
                    exponent = 1;
                }


                exponent = Float.parseFloat(s.substring(s.indexOf("x")+1, s.indexOf("x")+2));
                System.out.println("Exponent: " + exponent);
            } else if (!s.contains("x")) {
                System.out.println("Summand ohne x: " + s);
                s = (s + "x");
                System.out.println("Summand mit x: " + s);
                coefficient = Float.parseFloat(s.substring(0, s.indexOf("x")));
                System.out.println("Coefficient: " + coefficient);
                exponent = 0;
            }

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
    public void evaluateWholeFunction() {

    }

}
