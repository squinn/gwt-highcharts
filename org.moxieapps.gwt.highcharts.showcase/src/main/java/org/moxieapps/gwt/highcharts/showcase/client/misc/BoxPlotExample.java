package org.moxieapps.gwt.highcharts.showcase.client.misc;

import com.smartgwt.client.widgets.Canvas;
import org.moxieapps.gwt.highcharts.client.*;
import org.moxieapps.gwt.highcharts.client.labels.PlotLineLabel;
import org.moxieapps.gwt.highcharts.showcase.client.BaseChartExample;
import org.moxieapps.gwt.highcharts.showcase.client.ExampleFactory;


public class BoxPlotExample extends BaseChartExample {

    public BoxPlotExample(String title, String icon) {
        super(title, icon);
    }

    @Override
    public String getSourcePath() {
        return "misc/BoxPlotExample.java.html";
    }

    public static ExampleFactory getFactory() {
        return new ExampleFactory() {
            @Override
            public Canvas createChartCanvas() {
                return new BoxPlotExample(getTitle(), getIcon());
            }

            @Override
            public String getTitle() {
                return "Box Plot Example";
            }

            @Override
            public String getIcon() {
                return "icons/16/combination_chart.png";
            }
        };
    }

    @Override
    public Chart createChart() {

        final Chart chart = new Chart()
                .setType(Series.Type.BOXPLOT)
                .setChartTitleText("Box Plot Example")
                .setLegend(
                        new Legend()
                                .setEnabled(false)
                );

        chart.getXAxis()
                .setCategories("1", "2", "3", "4", "5")
                .setAxisTitleText("Experiment No.")
        ;

        final YAxis yAxis = chart.getYAxis();

        yAxis.setAxisTitleText("Observations")
                .createPlotLine()
                .setColor("red")
                .setWidth(1)
                .setLabel(
                        new PlotLineLabel()
                                .setText("Theeoretical Mean: 932")
                                .setAlign(PlotLineLabel.Align.CENTER)
                                .setStyle(
                                        new Style()
                                                .setColor("gray")
                                )
                );

        chart.setPersistent(true)
                .addSeries(chart.createSeries()
                .setName("Observations")
//                .setOption("data", new Number[][] {{760, 801, 848, 895, 965},
//                        {733, 853, 939, 980, 1080},
//                        {714, 762, 817, 870, 918},
//                        {724, 802, 806, 871, 950},
//                        {834, 836, 864, 882, 910}})

                .setPoints(new Number[][]{
                        {760, 801, 848, 895, 965},
                        {733, 853, 939, 980, 1080},
                        {714, 762, 817, 870, 918},
                        {724, 802, 806, 871, 950},
                        {834, 836, 864, 882, 910}
                })
        )
                .addSeries(chart.createSeries()
                        .setName("Outlier")
                        .setType(Series.Type.SCATTER)
                        .setPoints(new Point[]{
                                new Point(0, 644),
                                new Point(4, 718),
                                new Point(4, 951),
                                new Point(4, 969)
                        })

                )
                .setToolTip(
                        new ToolTip()
                                .setPointFormat("Observation: {point.y}")
                );

        return chart;
    }
}
