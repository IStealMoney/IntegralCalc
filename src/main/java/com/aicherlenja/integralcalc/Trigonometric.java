package com.aicherlenja.integralcalc;

import static com.aicherlenja.integralcalc.CompositeFunction.evaluatedFunction;
import static com.aicherlenja.integralcalc.CompositeFunction.getPreSign;

public class Trigonometric implements FunctionComponent {

    private double coefficient;
    private String s;
    private static String evaluatedFuncPart;
    private boolean isSin;
    private char preSign;
    CompositeFunction compFunc = new CompositeFunction();

    public Trigonometric(double coefficient, String s) {
        this.coefficient = coefficient;
        this.s = s;
    }

    @Override
    public double getCoefficient(String s) {
        if (s.charAt(0) == 's' || s.charAt(0) == 'c') {
            coefficient = 1;
        } else if (s.charAt(0) != 's' || s.charAt(0) != 'c') {
            if (s.contains("sin")) {
                coefficient = Double.parseDouble(s.substring(0, s.indexOf("s")));
            } else if (s.contains("cos")) {
                coefficient = Double.parseDouble(s.substring(0, s.indexOf("c")));
            }
        }
        return coefficient;
    }

    @Override
    public void integrateComp() {
        preSign = compFunc.getPreSign(s);
        if (isSin(s) && preSign == '+') { // if +sin(x) -> -cos(x)
            System.out.println("is +sin");
            s = s.replace("sin", "cos");
            preSign = '-';
        } else if (isSin(s) && preSign == '-') {  // if -sin(x) -> cos(x)
            System.out.println("is -sin");
            s = s.replace("-", "");
            s = s.replace("sin", "cos");
            preSign = '+';
        } else if (!isSin(s) && preSign == '+') {  // if +cos(x) -> +sin(x)
            System.out.println("is +cos");
            s = s.replace("cos", "sin");
            preSign = '+';
        } else if (!isSin(s) && preSign == '-') {  // if -cos(x) -> -sin(x)
            System.out.println("is -cos");
            s = s.replace("-", ""); // will be added again soon
            s = s.replace("cos", "sin");
            preSign = '-';
        }
    }

    @Override
    public String getEvaluatedFunction() {
        System.out.println(preSign);
        System.out.println(coefficient);
        System.out.println(s);
        if (coefficient == 1 && preSign == '+') {
            evaluatedFuncPart = s;
        } else if (coefficient == 1 && preSign == '-') {
            evaluatedFunction = preSign + s;
        } else if (coefficient != 1 && preSign == '+') {
            evaluatedFuncPart = s;
        } else if (coefficient != 1 && preSign == '-') {
            evaluatedFuncPart = preSign + s;
        }
        System.out.println("evaluatedFuncPart: " + evaluatedFuncPart);
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
        } else if (s.contains("cos")) {
            isSin = false;
        }
        return isSin;
    }
}
