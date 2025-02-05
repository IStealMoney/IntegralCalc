package com.aicherlenja.integralcalc;

interface FunctionComponent {    // interface between function types
    double calculateFuncPartX1(double solutionAreaPartX1, double uiX1, double antideriCoeff, double antideriExpo);

    double calculateFuncPartX2(double solutionAreaPartX2, double uiX2, double antideriCoeff, double antideriExpo);

    double calculateArea(double solutionAreaPartX1, double solutionAreaPartX2);
}

