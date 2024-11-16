package com.aicherlenja.integralcalc;

public class Linear extends Function {  //subclass
    // f(x) = ax + b
    GUIController guiCon = new GUIController();
    public double x1, x2, widthX, heightX, calculatedArea;

    public void calculateArea() {


        try {
            x1 = Double.parseDouble(guiCon.textFieldX1.getText());
            x2 = Double.parseDouble(guiCon.textFieldX2.getText());

        } catch (NumberFormatException e) {
            System.out.println("Error in parsing fields");
        }



        widthX = x2 - x1;
        calculatedArea = 0;



        showSolution();
    }

    public void showSolution() {
        GUIController guiCon = new GUIController();
        guiCon.textArea.setText(String.valueOf(calculatedArea));
    }
}
