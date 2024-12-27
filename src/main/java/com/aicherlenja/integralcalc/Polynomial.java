package com.aicherlenja.integralcalc;

import static java.lang.Math.pow;

public class Polynomial implements FunctionComponent { //subclass

    // f(x) = a_n * x^n + a_n-1 * x^n-1 ...
    // a = coefficient
    // b = n = exponent

    private double coefficient;
    private double exponent;
    public static double solution;

    public Polynomial(double coefficient, double exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }


    public double calculateArea(double uiX1, double uiX2) {
        integrateComps();
        linkComps();
        solution = calculateIntegratedFunctionX1X2(uiX1, uiX2);
        System.out.println("area: " + solution);
        return solution;
    }

    @Override
    public void integrateComps() {
        exponent = addOneExpo(exponent);
        coefficient = divideWithNewExpo(coefficient, exponent);
    }

    @Override
    public void linkComps() {
        System.out.println("Integrated function: " + coefficient + "x^" + exponent);
    }

    @Override
    public double calculateIntegratedFunctionX1X2(double uiX1, double uiX2) {
        solution = (coefficient * pow(uiX2, exponent)) - (coefficient * pow(uiX1, exponent));
        return solution;
    }

    public double addOneExpo(double exponent) {
        exponent++;
        return exponent;
    }

    public double divideWithNewExpo(double coefficient, double exponent) {
        coefficient = coefficient / exponent;
        return coefficient;
    }
}
