package org.moxieapps.gwt.highcharts.showcase.client.bar;

import com.smartgwt.client.widgets.Canvas;
import org.moxieapps.gwt.highcharts.client.*;
import org.moxieapps.gwt.highcharts.client.plotOptions.PlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.SeriesPlotOptions;
import org.moxieapps.gwt.highcharts.showcase.client.BaseChartExample;
import org.moxieapps.gwt.highcharts.showcase.client.ExampleFactory;

public class StackedBarExample extends BaseChartExample {

    public StackedBarExample(String title, String icon) {
        super(title, icon);
    }

    @Override
    public String getSourcePath() {
        return "bar/StackedBarExample.java.html";
    }

    public static ExampleFactory getFactory() {
        return new ExampleFactory() {
            @Override
            public Canvas createChartCanvas() {
                return new StackedBarExample(getTitle(), getIcon());
            }

            @Override
            public String getTitle() {
                return "Stacked Bars";
            }

            @Override
            public String getIcon() {
                return "icons/16/bar_chart.png";
            }
        };
    }

    @Override
    public Chart createChart() {

        final Chart chart = new Chart()
            .setType(Series.Type.BAR)
            .setChartTitleText("Stacked bar chart")
            .setSeriesPlotOptions(new SeriesPlotOptions()
                .setStacking(PlotOptions.Stacking.NORMAL)
            )
            .setLegend(new Legend()
                // TODO: Add support for getting the legend bg color from the theme.  E.g.: Highcharts.theme.legendBackgroundColorSolid
                .setBackgroundColor("#FFFFFF")
                .setReversed(true)
            )
            .setToolTip(new ToolTip()
                .setFormatter(new ToolTipFormatter() {
                    public String format(ToolTipData toolTipData) {
                        return toolTipData.getSeriesName() + ": " +
                            toolTipData.getYAsLong() + " " +
                            toolTipData.getXAsString();
                    }
                })
            );

        chart.getXAxis()
            .setCategories("Apples", "Oranges", "Pears", "Grapes", "Bananas");

        chart.getYAxis()
            .setMin(0)
            .setAxisTitleText("Total fruit consumption");

        chart.addSeries(chart.createSeries()
            .setName("John")
            .setPoints(new Number[] { 5, 3, 4, 7, 2 })
        );
        chart.addSeries(chart.createSeries()
            .setName("Jane")
            .setPoints(new Number[] { 2, 2, 3, 2, 1 })
        );
        chart.addSeries(chart.createSeries()
            .setName("Joe")
            .setPoints(new Number[] { 3, 4, 4, 2, 5 })
        );

        return chart;
    }
}