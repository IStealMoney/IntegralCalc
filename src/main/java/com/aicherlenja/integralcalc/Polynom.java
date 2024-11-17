package com.aicherlenja.integralcalc;

public class Polynom extends Function { //subclass

    // f(x) = a_n * x^n + a_n-1 * x^n-1 ...

    GUIController guiCon = new GUIController();

    public void calculateArea() {
        // aufleiten

        solution = 2;
        showSolution();
    }

    public void showSolution() {
        guiCon.showSolution(solution);
    }
}
