package com.aicherlenja.integralcalc;

import javafx.application.Platform;

import static com.aicherlenja.integralcalc.GUIController.uiX1;
import static com.aicherlenja.integralcalc.GUIController.uiX2;

public class CompositeFunction { // manages function components
    public static float coefficient, exponent, xVar;

    public static void separateFunction() {
        String[] functionSplit = GUIController.function.split("(?=[+-])");

        for (String s : functionSplit) {
            //s = s.trim();
            s = s.replaceAll("\\s", "");

            System.out.println("Verarbeite Summand: " + s);
            if (s.contains("x")) {
                System.out.println("enthält x");
                coefficient = Float.parseFloat(s.substring(0, s.indexOf("x")));
                System.out.println("Coefficient: " + coefficient);
                xVar = Float.parseFloat(s.substring(s.indexOf("x"), s.length()-1));
                exponent = Float.parseFloat(s.substring(s.indexOf("x")+1, s.length()-1));
                System.out.println("Exponent: " + exponent);
            } else if (!s.contains("x")) {
                System.out.println("Summand ohne x: " + s);
                s = (s + "x");
                System.out.println("Summand mit x: " + s);
                coefficient = Float.parseFloat(s.substring(0, s.indexOf("x")));
                System.out.println("Coefficient: " + coefficient);
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
