package org.moxieapps.gwt.highcharts.showcase.client.threeD;

import com.smartgwt.client.widgets.Canvas;
import org.moxieapps.gwt.highcharts.client.*;
import org.moxieapps.gwt.highcharts.client.labels.DataLabelsData;
import org.moxieapps.gwt.highcharts.client.labels.DataLabelsFormatter;
import org.moxieapps.gwt.highcharts.client.labels.PieDataLabels;
import org.moxieapps.gwt.highcharts.client.plotOptions.PiePlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.PlotOptions;
import org.moxieapps.gwt.highcharts.showcase.client.BaseChartExample;
import org.moxieapps.gwt.highcharts.showcase.client.ExampleFactory;
import org.moxieapps.gwt.highcharts.showcase.client.pie.BasicPieExample;

public class Pie3DExample extends BaseChartExample {

    public Pie3DExample(String title, String icon) {
        super(title, icon);
    }

    @Override
    public String getSourcePath() {
        return "threeD/pie3DExample.java.html";
    }

    public static ExampleFactory getFactory() {
        return new ExampleFactory() {
            @Override
            public Canvas createChartCanvas() {
                return new Pie3DExample(getTitle(), getIcon());
            }

            @Override
            public String getTitle() {
                return "3D Pie Chart";
            }

            @Override
            public String getIcon() {
                return "icons/16/3D_chart.png";
            }
        };
    }

    @Override
    public Chart createChart() {

        final Chart chart = new Chart()
                .setType(Series.Type.PIE)
                .setChartTitleText("What Pac-Man Eats")
                .setPlotBackgroundColor((String) null)
                .setPlotBorderWidth(null)
                .setPlotShadow(false)
                .setPiePlotOptions(new PiePlotOptions()
                        .setAllowPointSelect(true)
                        .setCursor(PlotOptions.Cursor.POINTER)
                        .setPieDataLabels(new PieDataLabels()
                                .setConnectorColor("#000000")
                                .setEnabled(true)
                                .setColor("#000000")
                                .setFormatter(new DataLabelsFormatter() {
                                    public String format(DataLabelsData dataLabelsData) {
                                        return "<b>" + dataLabelsData.getPointName() + "</b>: " + dataLabelsData.getYAsDouble() + " %";
                                    }
                                })
                        )
                        .setStartAngle(126)
                        .setDepth(75)
                )
                .setLegend(new Legend()
                        .setLayout(Legend.Layout.VERTICAL)
                        .setAlign(Legend.Align.RIGHT)
                        .setVerticalAlign(Legend.VerticalAlign.TOP)
                        .setX(-100)
                        .setY(100)
                        .setFloating(true)
                        .setBorderWidth(1)
                        .setBackgroundColor("#FFFFFF")
                        .setShadow(true)
                )
                .setToolTip(new ToolTip()
                        .setFormatter(new ToolTipFormatter() {
                            public String format(ToolTipData toolTipData) {
                                return "<b>" + toolTipData.getPointName() + "</b>: " + toolTipData.getYAsDouble() + " %";
                            }
                        })
                )
                .setColors("#EBEE00", "#FF00FF", "#0000FF")
                .setOptions3D(new Options3D()
                        .setEnabled(true)
                        .setAlpha(45)
                        .setBeta(0)
                        .setDepth(100)
                );

        chart.addSeries(chart.createSeries()
                .setName("Browser share")
                .setPoints(new Point[]{
                        new Point("Dots", 80.0),
                        new Point("Fruit", 10.0),
                        new Point("Ghosts", 10.0)
                })
        );


        return chart;
    }
}

