package org.moxieapps.gwt.highcharts.showcase.client.bar;

import com.smartgwt.client.widgets.Canvas;
import org.moxieapps.gwt.highcharts.client.*;
import org.moxieapps.gwt.highcharts.client.labels.DataLabels;
import org.moxieapps.gwt.highcharts.client.plotOptions.BarPlotOptions;
import org.moxieapps.gwt.highcharts.showcase.client.BaseChartExample;
import org.moxieapps.gwt.highcharts.showcase.client.ExampleFactory;

public class BasicBarExample extends BaseChartExample {

    public BasicBarExample(String title, String icon) {
        super(title, icon);
    }

    @Override
    public String getSourcePath() {
        return "bar/BasicBarExample.java.html";
    }

    public static ExampleFactory getFactory() {
        return new ExampleFactory() {
            @Override
            public Canvas createChartCanvas() {
                return new BasicBarExample(getTitle(), getIcon());
            }

            @Override
            public String getTitle() {
                return "Basic Bar Chart";
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
            .setChartTitleText("Historic World Population by Region")
            .setChartSubtitleText("Source: Wikipedia.org")
            .setBarPlotOptions(new BarPlotOptions()
                .setDataLabels(new DataLabels()
                    .setEnabled(true)
                )
            )
            .setLegend(new Legend()
                .setLayout(Legend.Layout.VERTICAL)
                .setAlign(Legend.Align.RIGHT)
                .setVerticalAlign(Legend.VerticalAlign.TOP)
                .setX(-100)
                .setY(100)
                .setFloating(true)
                .setBorderWidth(1)
                // TODO: Add support for getting the legend bg color from the theme.  E.g.: Highcharts.theme.legendBackgroundColor
                .setBackgroundColor("#FFFFFF")
                .setShadow(true)
            )
            .setCredits(new Credits()
                .setEnabled(false)
            )
            .setToolTip(new ToolTip()
                .setFormatter(new ToolTipFormatter() {
                    public String format(ToolTipData toolTipData) {
                        return toolTipData.getSeriesName() + ": " + toolTipData.getYAsLong() +" million";
                    }
                })
            );

        chart.getXAxis()
            .setCategories("Africa", "America", "Asia", "Europe", "Oceania");

        chart.getYAxis()
            .setAxisTitle(new AxisTitle()
                .setText("Population (millions)")
                .setAlign(AxisTitle.Align.HIGH)
            );

        chart.addSeries(chart.createSeries()
            .setName("Year 1800")
            .setPoints(new Number[] { 107, 31, 635, 203, 2 })
        );
        chart.addSeries(chart.createSeries()
            .setName("Year 1900")
            .setPoints(new Number[] { 133, 156, 947, 408, 6 })
        );
        chart.addSeries(chart.createSeries()
            .setName("Year 2008")
            .setPoints(new Number[] { 973, 914, 4054, 732, 34 })
        );

        return chart;
    }
}
