package com.aicherlenja.integralcalc;

public class Troubleshooter {

    public String x1, x2;

    public boolean correctUserInput()  {
        GUIController guiCon = new GUIController();

        try {
            x1 = guiCon.textFieldX1.getText();
            x2 = guiCon.textFieldX2.getText();
        } catch (NullPointerException e) {
            System.out.println("can not get text");
        }


        if(Double.parseDouble(x2) < Double.parseDouble(x1) ||
                guiCon.textFieldX1.getText().isEmpty() ||
                guiCon.textFieldX2.getText().isEmpty()) {
            guiCon.textArea.setText("please reconsider x1 or x2 value");
        }


        return true;
    }
}
