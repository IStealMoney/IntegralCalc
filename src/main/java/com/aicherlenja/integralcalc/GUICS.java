package com.aicherlenja.integralcalc;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class GUICS {    //coordinate system

    public void drawCs() {
        Canvas canvas = new Canvas(600, 400);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawAxes(gc);
    }

    public void drawAxes(GraphicsContext gc) {
        gc.strokeLine(300, 0, 300, 400);    // y
        gc.strokeLine(0, 200, 600, 200);    // x
    }

    public void drawLinear(GraphicsContext gc) {

    }

    public void drawQuad(GraphicsContext gc) {

    }

    public void drawSinus(GraphicsContext gc) {

    }
}
