package com.aicherlenja.integralcalc;

interface FunctionComponent {    // interface between function types
    double handleCalculation(double uiX1, double uiX2);
    void integrateComps();
    double calculateIntegratedFunctionX1X2(double uiX1, double uiX2);
    String evaluateFunction();
}

