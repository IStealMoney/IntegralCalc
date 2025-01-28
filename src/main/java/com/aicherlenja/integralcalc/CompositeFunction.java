package com.aicherlenja.integralcalc;

import static com.aicherlenja.integralcalc.GUIController.uiX1;
import static com.aicherlenja.integralcalc.GUIController.uiX2;

public class CompositeFunction { // manages function components
    public static double coefficient, antideriCoeff, antideriExpo, exponent, solutionArea, solutionAreaPartX1, solutionAreaPartX2;
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
    public static void manageFunction() {
        solutionArea = 0;
        String[] functionSplit = GUIController.function.split("(?=[+-])");

        for (String s : functionSplit) {
            s = s.trim();

            System.out.println("Eingegeben: " + s);

            // calculate integral for specific function type
            if (s.contains("x") && !s.contains("^x") && !Trigonometric.isTrigo(s)) { // polynomial
                Polynomial poly = new Polynomial(coefficient, exponent, s);
                coefficient = poly.getCoefficient(s);
                exponent = poly.getExponent(s);
                antideriExpo = addOneExpo(exponent);
                antideriCoeff = divideWithNewExpo(coefficient, antideriExpo);
                solutionAreaPartX1 += poly.calculateFuncPartX1(solutionAreaPartX1, uiX1, antideriCoeff, antideriExpo); // area
                solutionAreaPartX2 += poly.calculateFuncPartX2(solutionAreaPartX2, uiX2, antideriCoeff, antideriExpo);
                evaluatedFunction = (evaluatedFunction + " " + poly.getEvaluatedFunction(antideriCoeff, antideriExpo, s));  // integrated function
                solutionArea = poly.calculateArea(solutionAreaPartX1, solutionAreaPartX2);
                //simpEvalFunc = poly.simplifyFunc(evaluatedFunction, simpEvalFunc); // simplify
            } else if (Trigonometric.isTrigo(s)) {  // trigonometric
                Trigonometric trigo = new Trigonometric(coefficient, s);
                coefficient = trigo.getCoefficient(s);
                evaluatedFunction += trigo.integrateComp(s);
                solutionAreaPartX1 += trigo.calculateFuncPartX1(solutionAreaPartX1, uiX1, antideriCoeff, antideriExpo);
                solutionAreaPartX2 += trigo.calculateFuncPartX2(solutionAreaPartX2, uiX2, antideriCoeff, antideriExpo);
                //evaluatedFunction = (evaluatedFunction + " " + trigo.getEvaluatedFunction(antideriCoeff, antideriExpo, s));
                solutionArea = trigo.calculateArea(solutionAreaPartX1, solutionAreaPartX2);
            }
        }
        CartCoordSys evalFuncCartCoord = new CartCoordSys(evaluatedFunction);
        evalFuncCartCoord.drawFunc(evaluatedFunction);
    }

    public static double addOneExpo(double exponent) {
        exponent++;
        return exponent;
    }

    public static double divideWithNewExpo(double coefficient, double exponent) {
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
