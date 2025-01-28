package com.aicherlenja.integralcalc;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.fx.ChartViewer;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;

import static com.aicherlenja.integralcalc.CompositeFunction.antideriCoeff;
import static com.aicherlenja.integralcalc.CompositeFunction.antideriExpo;


public class CartCoordSys {

    public static ChartViewer cViewer = new ChartViewer();
    private static XYSeriesCollection dataset;
    private static JFreeChart chart;
    private static String evaluatedFunction;
    private static double y, coefficient, exponent;

    public CartCoordSys() {
    }

    public CartCoordSys(String evaluatedFunction) {
        this.evaluatedFunction = evaluatedFunction;
    }

    public void drawCoordSys() {
        dataset = new XYSeriesCollection();
        chart = ChartFactory.createXYLineChart(
                evaluatedFunction,
                "x",
                "y",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        XYPlot plot = chart.getXYPlot();
        NumberAxis domainAxis = (NumberAxis) plot.getDomainAxis();
        domainAxis.setRange(-10, 10);
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setRange(-10, 10);
        plot.setDomainGridlinesVisible(true);
        plot.setRangeGridlinesVisible(true);
        domainAxis.setAxisLinePaint(Color.WHITE);
        domainAxis.setTickMarkPaint(Color.WHITE);
        rangeAxis.setAxisLinePaint(Color.BLACK);
        rangeAxis.setTickMarkPaint(Color.BLACK);
        plot.setBackgroundPaint(Color.GRAY);
        cViewer = new ChartViewer(chart);
    }

    public static void drawFunc(String evaluatedFunction) {
        dataset.removeAllSeries();
        XYSeries series = new XYSeries(evaluatedFunction);
        double start = -10.0;
        double end = 10.0;
        double step = 0.1;

        for (double x = start; x <= end; x += step) {
            y = calculateYCoord(x);
            series.add(x, y);
        }
        dataset.addSeries(series);
    }

    private static double calculateYCoord(double x) {
        y = antideriCoeff * Math.pow(x, antideriExpo);
        return y;
    }
}
