package com.aicherlenja.integralcalc;

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
        solution = calculateIntegratedFunctionX1X2();

        // integral
        //solution = calcualteIntegral(coefficient, exponent);

        return solution;
    }

    public double divideWithNewExpo(double baseA, double expoB) {
        baseA = baseA / expoB;
        return baseA;
    }

    @Override
    public void integrateComps() {
        System.out.println("Exponent von Polynomial.java: " + exponent);
        exponent = addOneExpo(exponent);
        coefficient = divideWithNewExpo(coefficient, exponent);
    }

    @Override
    public void linkComps() {

    }

    @Override
    public double calculateIntegratedFunctionX1X2() {

        return 0;
    }

    public double addOneExpo(double expoB) {
        expoB++;
        return expoB;
    }
}
