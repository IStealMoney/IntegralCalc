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

    public Polynomial() {

    }


    public double calculateArea(double uiX1, double uiX2) {

        //array.length = hoechster Grad-1

        // aufleiten
        exponent = addOneExpo(exponent);
        coefficient = divideWithNewExpo(coefficient, exponent);

        // integral
        solution = calcualteIntegral(coefficient, exponent);

        return solution;
    }

    public double addOneExpo(double expoB) {
        expoB++;
        return expoB;
    }

    public double divideWithNewExpo(double baseA, double expoB) {
        baseA = baseA / expoB;
        return baseA;
    }

    public double calcualteIntegral(double baseA, double expoB) {
        double x2Solution = baseA * Math.pow(GUIController.uiX2, expoB);
        double x1Solution = baseA * Math.pow(GUIController.uiX1, expoB);
        solution = x2Solution - x1Solution;
        return solution;
    }

    @Override
    public void integrateComps() {

    }

    @Override
    public void linkComps() {

    }

    @Override
    public void calculateIntegratedFunctionX1X2() {

    }
}
