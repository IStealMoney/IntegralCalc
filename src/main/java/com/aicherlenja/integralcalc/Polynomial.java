package com.aicherlenja.integralcalc;

import static com.aicherlenja.integralcalc.CompositeFunction.solutionArea;
import static java.lang.Math.pow;

public class Polynomial implements FunctionComponent { //subclass

    // f(x) = a_n * x^n + a_n-1 * x^n-1 ...

    private double coefficient;
    private double exponent;

    public Polynomial(double coefficient, double exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }

    @Override
    public double handleCalculation(double uiX1, double uiX2) {
        integrateComps();
        solutionArea = calculateIntegratedFunctionX1X2(uiX1, uiX2);
        evaluateFunction();
        System.out.println("area: " + solutionArea);
        return solutionArea;
    }

    @Override
    public void integrateComps() {
        exponent = addOneExpo(exponent);
        coefficient = divideWithNewExpo(coefficient, exponent);
    }

    @Override
    public double calculateIntegratedFunctionX1X2(double uiX1, double uiX2) {
        solutionArea = (coefficient * pow(uiX2, exponent)) - (coefficient * pow(uiX1, exponent));
        return solutionArea;
    }

    @Override
    public String evaluateFunction() {
        return coefficient + "x^" + exponent;
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
