package org.moxieapps.gwt.highcharts.showcase.client.misc;

import com.smartgwt.client.widgets.Canvas;
import org.moxieapps.gwt.highcharts.client.*;
import org.moxieapps.gwt.highcharts.client.plotOptions.BubblePlotOptions;
import org.moxieapps.gwt.highcharts.showcase.client.BaseChartExample;
import org.moxieapps.gwt.highcharts.showcase.client.ExampleFactory;

public class BubbleChartExample extends BaseChartExample {

    public BubbleChartExample(String title, String icon) {
        super(title, icon);
    }

    @Override
    public String getSourcePath() {
        return "misc/BubbleChartExample.java.html";
    }

    public static ExampleFactory getFactory() {
        return new ExampleFactory() {
            @Override
            public Canvas createChartCanvas() {
                return new BubbleChartExample(getTitle(), getIcon());
            }

            @Override
            public String getTitle() {
                return "Zoomable Bubble Chart";
            }

            @Override
            public String getIcon() {
                return "icons/16/scatter_chart.png";
            }
        };
    }

    @Override
    public Chart createChart() {

        final Chart chart = new Chart()
                .setBubblePlotOptions(new BubblePlotOptions()
                        .setZThreshold(30)
                )
                .setType(Series.Type.BUBBLE)
                .setZoomType(Chart.ZoomType.X_AND_Y)
                .setChartTitleText("GWT HighCharts Bubbles")
                .setChartSubtitleText("moxiegroup.com");


        chart.addSeries(chart.createSeries()
                .setName("Series 1")
                .setPoints(new Number[][]{
                        {97, 36, 79}, {94, 74, 60}, {68, 76, 58}, {64, 87, 56}, {68, 27, 73},
                        {74, 99, 42}, {7, 93, 87}, {51, 69, 40}, {38, 23, 33}, {57, 86, 31}
                })

        );

        chart.addSeries(chart.createSeries()
                .setName("Series 2")
                .setPoints(new Number[][]{
                        {25, 10, 87}, {2, 75, 59}, {11, 54, 8}, {86, 55, 93}, {5, 3, 58},
                        {90, 63, 44}, {91, 33, 17}, {97, 3, 56}, {15, 67, 48}, {54, 25, 81}
                })
        );

        chart.addSeries(chart.createSeries()
                .setName("Series 3")
                .setPoints(new Number[][]{
                        {47, 47, 21}, {20, 12, 4}, {6, 76, 91}, {38, 30, 60}, {57, 98, 64},
                        {61, 17, 80}, {83, 60, 13}, {67, 78, 75}, {64, 12, 10}, {30, 77, 82}
                })
        );


        return chart;
    }
}
