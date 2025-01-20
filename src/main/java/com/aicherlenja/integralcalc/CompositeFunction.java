package com.aicherlenja.integralcalc;

import static com.aicherlenja.integralcalc.GUIController.uiX1;
import static com.aicherlenja.integralcalc.GUIController.uiX2;

public class CompositeFunction { // manages function components
    public static double coefficient, exponent, solutionArea, solutionAreaPartX1, solutionAreaPartX2;
    public static String exponentPart, evaluatedFunction, simpEvalFunc;

    CompositeFunction() {
        coefficient = 0;
        exponent = 0;
        solutionArea = 0;
        solutionAreaPartX1 = 0;
        solutionAreaPartX2 = 0;
        exponentPart = "";
        evaluatedFunction = "";
    }

    CompositeFunction(double coefficient, double exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }
    public static void separateFunction() {
        solutionArea = 0;
        String[] functionSplit = GUIController.function.split("(?=[+-])");

        for (String s : functionSplit) {
            s = s.trim();

            System.out.println("Eingegeben: " + s);

            coefficient = findCoefficient(s);
            exponent = findExponent(s);

            // calculate integral for specific function type
            if (s.contains("x^")) { // polynomial
                Polynomial poly = new Polynomial(coefficient, exponent);
                poly.integrateComp();
                solutionAreaPartX1 += poly.calculateFuncPartX1(solutionAreaPartX1, uiX1); // area
                solutionAreaPartX2 += poly.calculateFuncPartX2(solutionAreaPartX2, uiX2);
                evaluatedFunction = (evaluatedFunction + " " + poly.getEvaluatedFunction());  // integrated function
                simpEvalFunc = poly.simplifyFunc(evaluatedFunction, simpEvalFunc); // simplify
            } else if (s.contains("^x")) {  // exponential
                Exponential exponential = new Exponential();
            } else if (Trigonometric.isTrigo(s) == true) {  // trigonometric
                Trigonometric trigo = new Trigonometric(coefficient, exponent, s);
                trigo.integrateComp();
                solutionAreaPartX1 += trigo.calculateFuncPartX1(solutionAreaPartX1, uiX1);
                solutionAreaPartX2 += trigo.calculateFuncPartX2(solutionAreaPartX2, uiX2);
                evaluatedFunction = (evaluatedFunction + " " + trigo.getEvaluatedFunction());
            } else if (s.contains("sqrt")) {    // root
                Root root = new Root();

            }
        }
        solutionArea = calculateSolutionArea(solutionAreaPartX1, solutionAreaPartX2);
    }

    private static double findCoefficient(String s) {   //move to specific class?
        if (!s.contains("x")) {
            coefficient = Double.parseDouble(s);
        } else if (s.contains("x") && Trigonometric.isTrigo(s) == false) {
            if (s.charAt(0) == 'x' ||
                    (s.charAt(0) == '+' && s.charAt(1) == 'x')) {
                coefficient = 1;
            } else if (s.charAt(0) == '-' && s.charAt(1) == 'x') {
                coefficient = -1;
            } else {
                coefficient = Double.parseDouble(s.substring(0, s.indexOf("x")));
            }
        } else if (Trigonometric.isTrigo(s) == true) {
            if (s.contains("sin")) { // s for sin and c for cos
                coefficient = Double.parseDouble(s.substring(0, s.indexOf("s")));
            } else if (s.contains("cos")) {
                coefficient = Double.parseDouble(s.substring(0, s.indexOf("c")));
            }
        }
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
                exponent = Double.parseDouble(exponentPart);
            } else {
                exponent = 1;
            }
        } else if (!s.contains("x")) {
            exponent = 0;   //will call addOneExpo() soon
        }
        return exponent;
    }

    public double addOneExpo(double exponent) {
        exponent++;
        return exponent;
    }

    public double divideWithNewExpo(double coefficient, double exponent) {
        coefficient = coefficient / exponent;
        return coefficient;
    }

    private static double calculateSolutionArea(double solutionAreaPartX1, double solutionAreaPartX2) {
        return solutionAreaPartX2 - solutionAreaPartX1;
    }

    public static char getPreSign(String s) {
        char preSign;
        if (s.substring(0, 1).equals("-")) {
            preSign = '-';
        } else {
            preSign = '+';
        }
        return preSign;
    }
}
