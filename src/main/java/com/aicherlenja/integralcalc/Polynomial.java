package com.aicherlenja.integralcalc;

import static java.lang.Math.exp;
import static java.lang.Math.pow;

public class Polynomial implements FunctionComponent { //subclass

    // f(x) = a_n * x^n + a_n-1 * x^n-1 ...

    private static double coefficient, exponent, antideriExpo, antideriCoeff;
    private String evaluatedFuncPart, s, exponentPart;

    public Polynomial(double coefficient, double exponent, String s) {
        this.coefficient = coefficient;
        this.exponent = exponent;
        this.s = s;
    }

    public double getCoefficient(String s) {
        if (s.charAt(0) == 'x' || (s.charAt(0) == '+' && s.charAt(1) == 'x')) {
            coefficient = 1;
        } else if (s.charAt(0) == '-' && s.charAt(1) == 'x') {
            coefficient = -1;
        } else {
            coefficient = Double.parseDouble(s.substring(0, s.indexOf("x")));
        }
        return coefficient;
    }

    public double getExponent(String s) {
        if (s.contains("x")) {
            if (s.contains("^")) {
                exponentPart = s.substring(s.indexOf("^")+1, s.length()); // whole exponent (e.g. 2x)
                exponent = Double.parseDouble(exponentPart);
            } else {
                exponent = 1;
            }
        } else if (!s.contains("x")) {
            exponent = 0;   //will call addOneExpo() soon
        }
        return exponent;
    }

    public String getEvaluatedFunction(double antideriCoeff, double antideriExpo, String s) {
        evaluatedFuncPart = antideriCoeff + "x^" + antideriExpo;
        return evaluatedFuncPart;
    }

    @Override
    public double calculateFuncPartX1(double uiX1, double antideriCoeff, double antideriExpo) {
        double solutionAreaPartX1 = 0;
        solutionAreaPartX1 = (antideriCoeff * pow(uiX1, antideriExpo));
        return solutionAreaPartX1;
    }

    @Override
    public double calculateFuncPartX2(double uiX2, double antideriCoeff, double antideriExpo) {
        double solutionAreaPartX2 = 0;
        solutionAreaPartX2 = (antideriCoeff * pow(uiX2, antideriExpo));
        return solutionAreaPartX2;
    }

    @Override
    public double calculateArea(double solutionAreaPartX1, double solutionAreaPartX2) {
        return solutionAreaPartX2 - solutionAreaPartX1;
    }

    public String simplifyFunc(String evaluatedFunction, String simpEvalFunc) { // interface or move in CompositeFunc?
        return simpEvalFunc;
    }
}
