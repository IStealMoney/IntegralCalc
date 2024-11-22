package com.aicherlenja.integralcalc;

public class Polynom extends Function { //subclass

    // f(x) = a_n * x^n + a_n-1 * x^n-1 ...

    GUIController guiCon = new GUIController();

    public Polynom() {

    }

    public void calculateArea() {
        // aufleiten
        System.out.println("asdf");

        solution = 2;
        showSolution();
    }

    public void showSolution() {
        guiCon.showSolution(solution);
    }
}
