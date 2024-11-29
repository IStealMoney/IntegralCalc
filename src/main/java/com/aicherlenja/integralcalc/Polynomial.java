package com.aicherlenja.integralcalc;

public class Polynomial extends Function { //subclass

    // f(x) = a_n * x^n + a_n-1 * x^n-1 ...
    // a = beginning
    // b = exponent

    GUIController guiCon = new GUIController();
    public static float baseA;
    public static float expoB;
    public static float solution;

    public Polynomial() {

    }

    public void calculateArea(float uiTextFieldA, float uiTextFieldB, float uiTextFieldC, float uiTextFieldD, float uiX1, float uiX2) {
        baseA = uiTextFieldA;
        expoB = uiTextFieldB;

        //array.length = hoechster Grad-1

        // aufleiten
        expoB = addOneExpo(expoB);
        baseA = divideWithNewExpo(baseA, expoB);

        // integral
        solution = calcualteIntegral(baseA, expoB);

        guiCon.showSolution(solution);
    }

    public float addOneExpo(float expoB) {
        expoB++;
        return expoB;
    }

    public float divideWithNewExpo(float baseA, float expoB) {
        baseA = baseA / expoB;
        System.out.println(expoB + " " + baseA);
        return baseA;
    }

    public float calcualteIntegral(float baseA, float expoB) {
        float x2Solution = (float) (baseA * Math.pow(guiCon.uiX2, expoB));
        float x1Solution = (float) (baseA * Math.pow(guiCon.uiX1, expoB));
        solution = x2Solution - x1Solution;
        return solution;
    }
}
