package com.aicherlenja.integralcalc;

public class Linear extends Function {  //subclass
    // f(x) = ax + b
    GUIController guiCon = new GUIController();
    public double x1, x2, widthX, heightX, calculatedArea;

    public void calculateArea() {
        widthX = x2 - x1;
        calculatedArea = 0;
        float solution = 0;


        guiCon.showSolution(solution);
    }


}
