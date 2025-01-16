package com.aicherlenja.integralcalc;

public class Trigonometric implements FunctionComponent {

    private double coefficient;
    private double exponent;

    public Trigonometric(double coefficient, double exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }

    @Override
    public void integrateComps() {
        CompositeFunction compFunc = new CompositeFunction();
    }

    @Override
    public String evaluateFunction() {
        return "";
    }

    @Override
    public double calculateFuncPartX1(double solutionAreaPartX1, double uiX1) {
        return 0;
    }

    @Override
    public double calculateFuncPartX2(double solutionAreaPartX2, double uiX2) {
        return 0;
    }

    public static boolean isTrigo(String s) {
        if (s.contains("sin") || s.contains("cos")) {
            return true;
        } else {
            return false;
        }
    }
}
