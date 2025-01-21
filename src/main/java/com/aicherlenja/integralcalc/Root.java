package com.aicherlenja.integralcalc;

public class Root implements FunctionComponent {
    private double coefficient;
    private static String s;

    public Root(double coefficient, String s) {
        this.coefficient = coefficient;
        this.s = s;
    }

    @Override
    public double getCoefficient(String s) {

        return coefficient;
    }

    @Override
    public double getExponent(String s) {
        return 0;
    }

    @Override
    public void integrateComp() {

    }

    @Override
    public String getEvaluatedFunction() {
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
}
