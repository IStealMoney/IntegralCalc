package com.aicherlenja.integralcalc;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class GUICS {    //coordinate system

    public Node createCoordinateSystem() {
        Pane root = new Pane();

        //cs
        Line xAxis = new Line(0, 300, 800, 300);
        Line yAxis = new Line(275, 0, 275, 800);
        root.getChildren().addAll(xAxis, yAxis);
        return root;
    }
}
