package org.moxieapps.gwt.highcharts.showcase.client.combination;

import com.smartgwt.client.widgets.Canvas;
import org.moxieapps.gwt.highcharts.client.*;
import org.moxieapps.gwt.highcharts.client.labels.AxisLabelsData;
import org.moxieapps.gwt.highcharts.client.labels.AxisLabelsFormatter;
import org.moxieapps.gwt.highcharts.client.labels.YAxisLabels;
import org.moxieapps.gwt.highcharts.client.plotOptions.ColumnPlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.Marker;
import org.moxieapps.gwt.highcharts.client.plotOptions.SplinePlotOptions;
import org.moxieapps.gwt.highcharts.showcase.client.BaseChartExample;
import org.moxieapps.gwt.highcharts.showcase.client.ExampleFactory;

public class MultipleAxesExample extends BaseChartExample {

    public MultipleAxesExample(String title, String icon) {
        super(title, icon);
    }

    @Override
    public String getSourcePath() {
        return "combination/MultipleAxesExample.java.html";
    }

    public static ExampleFactory getFactory() {
        return new ExampleFactory() {
            @Override
            public Canvas createChartCanvas() {
                return new MultipleAxesExample(getTitle(), getIcon());
            }

            @Override
            public String getTitle() {
                return "Multiple Axes";
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
            .setChartTitleText("Average Monthly Weather Data for Tokyo")
            .setChartSubtitleText("Source: WorldClimate.com")
            .setZoomType(Chart.ZoomType.X_AND_Y)
            .setToolTip(new ToolTip()
                .setFormatter(new ToolTipFormatter() {
                    public String format(ToolTipData toolTipData) {
                        String unit = "mm";
                        if ("Temperature".equals(toolTipData.getSeriesName())) {
                            unit = "°C";
                        } else if ("Sea-Level Pressure".equals(toolTipData.getSeriesName())) {
                            unit = "mb";
                        }
                        return toolTipData.getXAsString() + ": " + toolTipData.getYAsDouble() + " " + unit;
                    }
                })
            )
            .setLegend(new Legend()
                .setLayout(Legend.Layout.VERTICAL)
                .setAlign(Legend.Align.LEFT)
                .setVerticalAlign(Legend.VerticalAlign.TOP)
                .setX(120)
                .setY(80)
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
            .setLabels(new YAxisLabels()
                .setStyle(new Style()
                    .setColor("#89A54E")
                )
                .setFormatter(new AxisLabelsFormatter() {
                    public String format(AxisLabelsData axisLabelsData) {
                        return axisLabelsData.getValueAsLong() + "°C";
                    }
                })
            )
            .setAxisTitle(new AxisTitle()
                .setText("Temperature")
                .setStyle(new Style()
                    .setColor("#89A54E")
                )
            )
            .setOpposite(true);

        // Secondary yAxis
        chart.getYAxis(1)
            .setLabels(new YAxisLabels()
                .setStyle(new Style()
                    .setColor("#4572A7")
                )
                .setFormatter(new AxisLabelsFormatter() {
                    public String format(AxisLabelsData axisLabelsData) {
                        return axisLabelsData.getValueAsLong() + " mm";
                    }
                })
            )
            .setAxisTitle(new AxisTitle()
                .setText("Rainfall")
                .setStyle(new Style()
                    .setColor("#4572A7")
                )
            )
            .setGridLineWidth(1);

        // Tertiary yAxis
        chart.getYAxis(2)
            .setLabels(new YAxisLabels()
                .setStyle(new Style()
                    .setColor("#AA4643")
                )
                .setFormatter(new AxisLabelsFormatter() {
                    public String format(AxisLabelsData axisLabelsData) {
                        return axisLabelsData.getValueAsLong() + " mb";
                    }
                })
            )
            .setAxisTitle(new AxisTitle()
                .setText("Sea-Level Pressure")
                .setStyle(new Style()
                    .setColor("#AA4643")
                )
            )
            .setGridLineWidth(0)
            .setOpposite(true);

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
            .setName("Sea-Level Pressure")
            .setType(Series.Type.SPLINE)
            .setPlotOptions(new SplinePlotOptions()
                .setColor("#AA4643")
                .setMarker(new Marker()
                    .setEnabled(false)
                )
                .setDashStyle(PlotLine.DashStyle.SHORT_DOT)
            )
            .setYAxis(2)
            .setPoints(new Number[]{
                1016, 1016, 1015.9, 1015.5, 1012.3, 1009.5, 1009.6, 1010.2, 1013.1, 1016.9, 1018.2, 1016.7
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
