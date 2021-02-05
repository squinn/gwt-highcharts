package org.moxieapps.gwt.highcharts.showcase.client.combination;

import com.smartgwt.client.widgets.Canvas;
import org.moxieapps.gwt.highcharts.client.*;
import org.moxieapps.gwt.highcharts.client.labels.AxisLabelsData;
import org.moxieapps.gwt.highcharts.client.labels.AxisLabelsFormatter;
import org.moxieapps.gwt.highcharts.client.labels.YAxisLabels;
import org.moxieapps.gwt.highcharts.client.plotOptions.ColumnPlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.SplinePlotOptions;
import org.moxieapps.gwt.highcharts.showcase.client.BaseChartExample;
import org.moxieapps.gwt.highcharts.showcase.client.ExampleFactory;

public class DualAxesExample extends BaseChartExample {

    public DualAxesExample(String title, String icon) {
        super(title, icon);
    }

    @Override
    public String getSourcePath() {
        return "combination/DualAxesExample.java.html";
    }

    public static ExampleFactory getFactory() {
        return new ExampleFactory() {
            @Override
            public Canvas createChartCanvas() {
                return new DualAxesExample(getTitle(), getIcon());
            }

            @Override
            public String getTitle() {
                return "Dual Axes, Line and Column";
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
            .setChartTitleText("Average Monthly Temperature and Rainfall in Tokyo")
            .setChartSubtitleText("Source: WorldClimate.com")
            .setZoomType(Chart.ZoomType.X_AND_Y)
            .setToolTip(new ToolTip()
                .setFormatter(new ToolTipFormatter() {
                    public String format(ToolTipData toolTipData) {
                        return toolTipData.getXAsString() + ": " + toolTipData.getYAsDouble() +
                            ("Rainfall".equals(toolTipData.getSeriesName()) ? " mm" : "°C");
                    }
                })
            )
            .setLegend(new Legend()
                .setLayout(Legend.Layout.VERTICAL)
                .setAlign(Legend.Align.LEFT)
                .setVerticalAlign(Legend.VerticalAlign.TOP)
                .setX(120)
                .setY(100)
                .setFloating(true)
                    // TODO: Add support for getting the legend bg color from the theme.  E.g.: Highcharts.theme.legendBackgroundColor
                .setBackgroundColor("#FFFFFF")
            );

        chart.getXAxis()
            .setCategories(
                "Jan", "Feb", "Mar", "Apr", "May", "Jun",
                "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
            );

        // Primary yAxis
        chart.getYAxis(0)
            .setAxisTitle(new AxisTitle()
                .setText("Temperature")
            )
            .setLabels(new YAxisLabels()
                .setStyle(new Style()
                    .setColor("#89A54E")
                )
                .setFormatter(new AxisLabelsFormatter() {
                    public String format(AxisLabelsData axisLabelsData) {
                        return axisLabelsData.getValueAsLong() + "°C";
                    }
                })
            );

        // Secondary yAxis
        chart.getYAxis(1)
            .setAxisTitle(new AxisTitle()
                .setText("Rainfall")
            )
            .setOpposite(true)
            .setLabels(new YAxisLabels()
                .setStyle(new Style()
                    .setColor("#4572A7")
                )
                .setFormatter(new AxisLabelsFormatter() {
                    public String format(AxisLabelsData axisLabelsData) {
                        return axisLabelsData.getValueAsLong() + " mm";
                    }
                })
            );

        chart.addSeries(chart.createSeries()
            .setName("Rainfall")
            .setType(Series.Type.COLUMN)
            .setPlotOptions(new ColumnPlotOptions()
                .setColor("#4572A7")
            )
            .setYAxis(1)
            .setPoints(new Number[]{
                49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4
            })
        );
        chart.addSeries(chart.createSeries()
            .setName("Temperature")
            .setType(Series.Type.SPLINE)
            .setPlotOptions(new SplinePlotOptions()
                .setColor("#89A54E")
            )
            .setPoints(new Number[]{
                7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6
            })
        );

        return chart;
    }
}
