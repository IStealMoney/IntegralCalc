package com.aicherlenja.integralcalc;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.fx.ChartViewer;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


public class CartCoordSys {

    public static ChartViewer cViewer = new ChartViewer();

    public void drawCoordSys() {
        XYSeries series = new XYSeries("Dataset");
        series.add(1.0, 2.0);
        series.add(2.0, 3.5);
        series.add(3.0, 5.0);
        series.add(4.0, 7.5);

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Your function",
                "x",
                "y",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
        cViewer = new ChartViewer(chart);
    }
}
