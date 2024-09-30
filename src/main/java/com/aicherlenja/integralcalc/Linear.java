package com.aicherlenja.integralcalc;

public class Linear {
    public double a;
    public double b;
    public double xMin, xMax, breite, hoehe;

    public double berechneFktWert(double pX) {
        return a * pX + b;
    }

    public double berechneFlaeche(double pMin, double pMax, int anzahlAbschnitte) {
        breite = pMax - pMin;
        double flaeche = 0;
        for (int i = 0; i < anzahlAbschnitte; i++) {
            hoehe = pMin + i*breite;
            flaeche = flaeche + hoehe * breite;
        }
        return flaeche;
    }
}
