package com.aicherlenja.integralcalc;

public class Polynom extends Function { //subclass
    GUIController guiCon = new GUIController();

    public void calculateArea() {

        solution = 2;
        showSolution();
    }

    public void showSolution() {
        guiCon.showSolution(solution);
    }
}
