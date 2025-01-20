package com.aicherlenja.integralcalc;

import static com.aicherlenja.integralcalc.CompositeFunction.getPreSign;

public class Trigonometric implements FunctionComponent {

    private double coefficient;
    private double exponent;
    private String s;
    private static String evaluatedFuncPart;
    private boolean isSin;

    public Trigonometric(double coefficient, double exponent, String s) {
        this.coefficient = coefficient;
        this.exponent = exponent;
        this.s = s;
    }

    @Override
    public void integrateComp() {
        CompositeFunction compFunc = new CompositeFunction(exponent, coefficient);
        if (isSin(s) && getPreSign(s) == '+') { // if +sin(x) -> -cos(x)
            System.out.println("is +sin");
            s = s.replace("sin", "-cos");
        } else if (isSin(s) && getPreSign(s) == '-') {  // if -sin(x) -> cos(x)
            System.out.println("is -sin");
            s = s.replace("-", "");
            s = s.replace("cos", "");
        } else if (!isSin(s) && getPreSign(s) == '+') {  // if +cos(x) -> +sin(x)
            System.out.println("is +cos");
            s = s.replace("cos", "sin");
        } else if (!isSin(s) && getPreSign(s) == '-') {  // if -cos(x) -> -sin(x)
            System.out.println("is -cos");
            s = s.replace("cos", "sin");
        }
    }

    @Override
    public String getEvaluatedFunction() {
        evaluatedFuncPart = s;
        System.out.println(evaluatedFuncPart);
        return evaluatedFuncPart;
    }

    @Override
    public double calculateFuncPartX1(double solutionAreaPartX1, double uiX1) {
        if (isSin(s)) {
            solutionAreaPartX1 = Math.sin(uiX1);
        } else if (!isSin(s)) {
            solutionAreaPartX1 = Math.cos(uiX1);
        }
        return solutionAreaPartX1;
    }

    @Override
    public double calculateFuncPartX2(double solutionAreaPartX2, double uiX2) {
        if (isSin(s)) {
            solutionAreaPartX2 = Math.sin(uiX2);
        } else if (!isSin(s)) {
            solutionAreaPartX2 = Math.cos(uiX2);
        }
        return solutionAreaPartX2;
    }

    public static boolean isTrigo(String s) {
        if (s.contains("sin") || s.contains("cos")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isSin(String s) {
        if (s.contains("sin")) {
            isSin = true;
        }  else if (s.contains("cos")) {
            isSin = false;
        }
        return isSin;
    }
}
