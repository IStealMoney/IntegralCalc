package com.aicherlenja.integralcalc;

import static java.lang.Math.pow;

public class Polynomial implements FunctionComponent { //subclass

    // f(x) = a_n * x^n + a_n-1 * x^n-1 ...

    private double coefficient, exponent;
    private String evaluatedFuncPart, s, exponentPart;

    public Polynomial(double coefficient, double exponent, String s) {
        this.coefficient = coefficient;
        this.exponent = exponent;
        this.s = s;
    }

    @Override
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

    @Override
    public double getExponent(String s) {
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

    @Override
    public void integrateComp() {
        CompositeFunction compFunc = new CompositeFunction(exponent, coefficient);
        exponent = compFunc.addOneExpo(exponent);
        coefficient = compFunc.divideWithNewExpo(coefficient, exponent);
    }

    @Override
    public String getEvaluatedFunction() {
        evaluatedFuncPart = coefficient + "x^" + exponent;
        return evaluatedFuncPart;
    }

    @Override
    public double calculateFuncPartX1(double solutionAreaPartX1, double uiX1) {
        solutionAreaPartX1 = (coefficient * pow(uiX1, exponent));
        return solutionAreaPartX1;
    }

    @Override
    public double calculateFuncPartX2(double solutionAreaPartX2, double uiX2) {
        solutionAreaPartX2 = (coefficient * pow(uiX2, exponent));
        return solutionAreaPartX2;
    }

    public String simplifyFunc(String evaluatedFunction, String simpEvalFunc) { // interface or move in CompositeFunc?
        return simpEvalFunc;
    }
}
