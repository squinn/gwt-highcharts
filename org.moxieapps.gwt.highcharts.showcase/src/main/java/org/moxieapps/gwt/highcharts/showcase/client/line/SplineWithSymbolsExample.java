package org.moxieapps.gwt.highcharts.showcase.client.line;

import com.smartgwt.client.widgets.Canvas;
import org.moxieapps.gwt.highcharts.client.*;
import org.moxieapps.gwt.highcharts.client.labels.AxisLabelsData;
import org.moxieapps.gwt.highcharts.client.labels.AxisLabelsFormatter;
import org.moxieapps.gwt.highcharts.client.labels.XAxisLabels;
import org.moxieapps.gwt.highcharts.client.labels.YAxisLabels;
import org.moxieapps.gwt.highcharts.client.plotOptions.Marker;
import org.moxieapps.gwt.highcharts.client.plotOptions.SplinePlotOptions;
import org.moxieapps.gwt.highcharts.showcase.client.BaseChartExample;
import org.moxieapps.gwt.highcharts.showcase.client.ExampleFactory;

public class SplineWithSymbolsExample extends BaseChartExample {

    public SplineWithSymbolsExample(String title, String icon) {
        super(title, icon);
    }

    @Override
    public String getSourcePath() {
        return "line/SplineWithSymbolsExample.java.html";
    }

    public static ExampleFactory getFactory() {
        return new ExampleFactory() {
            @Override
            public Canvas createChartCanvas() {
                return new SplineWithSymbolsExample(getTitle(), getIcon());
            }

            @Override
            public String getTitle() {
                return "Spline With Symbols";
            }

            @Override
            public String getIcon() {
                return "icons/16/spline_chart.png";
            }
        };
    }

    @Override
    public Chart createChart() {

        final Chart chart = new Chart()
                .setType(Series.Type.SPLINE)
                .setTitle(
                        new ChartTitle()
                                .setText("Monthly Average Temperature"),
                        new ChartSubtitle()
                                .setText("Source: WorldClimate.com")
                )
                .setToolTip(
                        new ToolTip()
                                .setCrosshairs(true)
                                .setShared(true)
                )
                .setSplinePlotOptions(
                        new SplinePlotOptions()
                                .setMarker(
                                        new Marker()
                                                .setRadius(4)
                                                .setLineColor("#666666")
                                                .setLineWidth(1)
                                )
                );

        chart.getXAxis()
                .setCategories("January", "February", "March", "April", "May", "June",
                               "July", "August", "September", "October", "November", "December")
                .setLabels(
                        new XAxisLabels()
                            .setFormatter(
                                    new AxisLabelsFormatter() {
                                        public String format(AxisLabelsData axisLabelsData) {
                                            return axisLabelsData.getValueAsString().length() > 3 ? axisLabelsData.getValueAsString().substring(0, 3) : axisLabelsData.getValueAsString();
                                        }
                                    }
                            )
                )
        ;

        chart.getYAxis()
                .setAxisTitleText("Temperature")
                .setLabels(
                        new YAxisLabels()
                                .setFormatter(
                                        new AxisLabelsFormatter() {
                                            public String format(AxisLabelsData axisLabelsData) {
                                                return axisLabelsData.getValueAsLong() + "°";
                                            }
                                        }
                                )
                )
        ;

        chart.addSeries(
                chart.createSeries()
                        .setName("Tokyo")
                        .setPlotOptions(
                                new SplinePlotOptions()
                                        .setMarker(
                                                new Marker()
                                                        .setSymbol(Marker.Symbol.SQUARE)
                                        )
                        )
                        .setPoints(
                                new Point[]{
                                        new Point(7.0),
                                        new Point(6.9),
                                        new Point(9.5),
                                        new Point(14.5),
                                        new Point(18.2),
                                        new Point(21.5),
                                        new Point(25.2),
                                        new Point(26.5)
                                                .setMarker(
                                                        new Marker()
                                                                .setSymbol("http://highcharts.com/demo/gfx/sun.png")
                                                ),
                                        new Point(23.3),
                                        new Point(18.3),
                                        new Point(13.9),
                                        new Point(9.6)
                                }
                        )
        );
        chart.addSeries(
                chart.createSeries()
                        .setName("London")
                        .setPlotOptions(
                                new SplinePlotOptions()
                                        .setMarker(
                                                new Marker()
                                                        .setSymbol(Marker.Symbol.DIAMOND)
                                        )
                        )
                        .setPoints(
                                new Point[]{
                                        new Point(3.9)
                                                .setMarker(
                                                        new Marker()
                                                                .setSymbol("http://highcharts.com/demo/gfx/snow.png")
                                                ),
                                        new Point(4.2),
                                        new Point(5.7),
                                        new Point(8.5),
                                        new Point(11.9),
                                        new Point(15.2),
                                        new Point(17.0),
                                        new Point(16.6),
                                        new Point(14.2),
                                        new Point(10.3),
                                        new Point(6.6),
                                        new Point(4.8),
                                }

                        )
        );

        return chart;
    }
}
