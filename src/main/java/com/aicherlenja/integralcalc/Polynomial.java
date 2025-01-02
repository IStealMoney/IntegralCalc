package com.aicherlenja.integralcalc;

import static java.lang.Math.pow;

public class Polynomial implements FunctionComponent { //subclass

    // f(x) = a_n * x^n + a_n-1 * x^n-1 ...

    private double coefficient;
    private double exponent;
    public static String evaluatedFuncPart, evaluatedFuncSX1, evaluatedFuncSX2;

    public Polynomial(double coefficient, double exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }

    @Override
    public void integrateComps() {
        CompositeFunction compFunc = new CompositeFunction(exponent, coefficient);
        exponent = compFunc.addOneExpo(exponent);
        coefficient = compFunc.divideWithNewExpo(coefficient, exponent);
    }

    @Override
    public String evaluateFunction() {
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
        System.out.println("ö");
        return simpEvalFunc;
    }
}
