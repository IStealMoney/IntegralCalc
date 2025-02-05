package com.aicherlenja.integralcalc;

import static com.aicherlenja.integralcalc.CompositeFunction.evaluatedFunction;

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

//    @Override
//    public double getCoefficient(String s) {
//        if (s.charAt(0) == 's' || s.charAt(0) == 'c') {
//            coefficient = 1;
//        } else if (s.charAt(0) != 's' || s.charAt(0) != 'c') {
//            if (s.contains("-")) {
//                if (s.contains("sin")) {
//                    coefficient = Double.parseDouble(s.substring(1, s.indexOf("s")));
//                } else if (s.contains("cos")) {
//                    coefficient = Double.parseDouble(s.substring(1, s.indexOf("c")));
//                }
//                preSign = '-';
//            }
//        }
//        return coefficient;
//    }

    public String integrateComp(String s) {
        preSign = compFunc.getPreSign(s);
        if (isSin(s) && preSign == '+') { // if +sin(x) -> -cos(x)
            System.out.println("is +sin");
            s = "-" + s;
            evaluatedFunction = s.replace("sin", "cos");
            preSign = '-';
        } else if (isSin(s) && preSign == '-') {  // if -sin(x) -> cos(x)
            System.out.println("is -sin");
            s = s.replace("sin", "cos");
            evaluatedFunction = s.replace("-", "");
            preSign = '+';
        } else if (!isSin(s) && preSign == '+') {  // if +cos(x) -> +sin(x)
            System.out.println("is +cos");
            evaluatedFunction = s.replace("cos", "sin");
        } else if (!isSin(s) && preSign == '-') {  // if -cos(x) -> -sin(x)
            System.out.println("is -cos");
            evaluatedFunction = s.replace("cos", "sin");
        }
        return evaluatedFunction;
    }


    @Override
    public double calculateFuncPartX1(double solutionAreaPartX1, double uiX1, double antideriCoeff, double antideriExpo) {
        if (isSin(s)) {
            solutionAreaPartX1 = Math.sin(uiX1);
        } else if (!isSin(s)) {
            solutionAreaPartX1 = Math.cos(uiX1);
        }
        return solutionAreaPartX1;
    }

    @Override
    public double calculateFuncPartX2(double solutionAreaPartX2, double uiX2, double antideriCoeff, double antideriExpo) {
        if (isSin(s)) {
            solutionAreaPartX2 = Math.sin(uiX2);
        } else if (!isSin(s)) {
            solutionAreaPartX2 = Math.cos(uiX2);
        }
        return solutionAreaPartX2;
    }

    @Override
    public double calculateArea(double solutionAreaPartX1, double solutionAreaPartX2) {
        return coefficient * (solutionAreaPartX2 - solutionAreaPartX1);
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
