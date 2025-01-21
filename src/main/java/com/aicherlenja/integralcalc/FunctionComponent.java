package com.aicherlenja.integralcalc;

interface FunctionComponent {    // interface between function types
    double getCoefficient(String s);

    double getExponent(String s);

    void integrateComp();

    String getEvaluatedFunction();

    double calculateFuncPartX1(double solutionAreaPartX1, double uiX1);

    double calculateFuncPartX2(double solutionAreaPartX2, double uiX2);
}

