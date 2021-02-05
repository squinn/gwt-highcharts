package org.moxieapps.gwt.highcharts.showcase.client.bar;

import com.smartgwt.client.widgets.Canvas;
import org.moxieapps.gwt.highcharts.client.*;
import org.moxieapps.gwt.highcharts.client.events.ChartClickEvent;
import org.moxieapps.gwt.highcharts.client.events.ChartClickEventHandler;
import org.moxieapps.gwt.highcharts.client.labels.DataLabels;
import org.moxieapps.gwt.highcharts.client.labels.DataLabelsData;
import org.moxieapps.gwt.highcharts.client.labels.DataLabelsFormatter;
import org.moxieapps.gwt.highcharts.client.plotOptions.ColumnPlotOptions;
import org.moxieapps.gwt.highcharts.showcase.client.BaseChartExample;
import org.moxieapps.gwt.highcharts.showcase.client.ExampleFactory;

public class BasicColumnExample extends BaseChartExample {

    public BasicColumnExample(String title, String icon) {
        super(title, icon);
    }

    @Override
    public String getSourcePath() {
        return "bar/BasicColumnExample.java.html";
    }

    public static ExampleFactory getFactory() {
        return new ExampleFactory() {
            @Override
            public Canvas createChartCanvas() {
                return new BasicColumnExample(getTitle(), getIcon());
            }

            @Override
            public String getTitle() {
                return "Basic Column Chart";
            }

            @Override
            public String getIcon() {
                return "icons/16/column_chart.png";
            }
        };
    }

    @Override
    public Chart createChart() {

        final Chart chart = new Chart()
            .setType(Series.Type.COLUMN)
            .setChartTitleText("Monthly Average Rainfall")
            .setChartSubtitleText("Source: WorldClimate.com")
            .setColumnPlotOptions(new ColumnPlotOptions()
                .setPointPadding(0.2)
                .setBorderWidth(0)
            )
            .setLegend(new Legend()
                .setLayout(Legend.Layout.VERTICAL)
                .setAlign(Legend.Align.LEFT)
                .setVerticalAlign(Legend.VerticalAlign.TOP)
                .setX(100)
                .setY(70)
                .setFloating(true)
                // TODO: Add support for getting the legend bg color from the theme.  E.g.: Highcharts.theme.legendBackgroundColor
                .setBackgroundColor("#FFFFFF")
                .setShadow(true)
            )
            .setToolTip(new ToolTip()
                .setFormatter(new ToolTipFormatter() {
                    public String format(ToolTipData toolTipData) {
                        return toolTipData.getXAsString() + ": " + toolTipData.getYAsLong() + " mm";
                    }
                })
            );

        chart.getXAxis()
            .setCategories("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");

        chart.getYAxis()
            .setAxisTitleText("Rainfall (mm)")
            .setMin(0);

        chart.addSeries(chart.createSeries()
            .setName("Tokyo")
            .setPoints(new Number[] { 49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4 })
            .setPlotOptions(
                    new ColumnPlotOptions()
                        .setDataLabels(
                                new DataLabels()
                                    .setColor("#2f7ed8")
                                    .setEnabled(true)
                                    .setFormatter(new DataLabelsFormatter() {
                                        public String format(DataLabelsData dataLabelsData) {
                                            return dataLabelsData.getYAsLong() + " mm";
                                        }
                                    })
                        )
            )
        );
        chart.addSeries(chart.createSeries()
            .setName("New York")
            .setPoints(new Number[] { 83.6, 78.8, 98.5, 93.4, 106.0, 84.5, 105.0, 104.3, 91.2, 83.5, 106.6, 92.3 })
        );
        chart.addSeries(chart.createSeries()
            .setName("London")
            .setPoints(new Number[] { 48.9, 38.8, 39.3, 41.4, 47.0, 48.3, 59.0, 59.6, 52.4, 65.2, 59.3, 51.2 })
        );
        chart.addSeries(chart.createSeries()
            .setName("Berlin")
            .setPoints(new Number[] { 42.4, 33.2, 34.5, 39.7, 52.6, 75.5, 57.4, 60.4, 47.6, 39.1, 46.8, 51.1 })
        );

        return chart;
    }
}

