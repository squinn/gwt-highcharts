package org.moxieapps.gwt.highcharts.showcase.client.misc;

import com.smartgwt.client.widgets.Canvas;
import org.moxieapps.gwt.highcharts.client.*;
import org.moxieapps.gwt.highcharts.client.labels.AxisLabelsData;
import org.moxieapps.gwt.highcharts.client.labels.AxisLabelsFormatter;
import org.moxieapps.gwt.highcharts.client.labels.YAxisLabels;
import org.moxieapps.gwt.highcharts.client.plotOptions.ColumnPlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.ErrorBarPlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.SplinePlotOptions;
import org.moxieapps.gwt.highcharts.showcase.client.BaseChartExample;
import org.moxieapps.gwt.highcharts.showcase.client.ExampleFactory;


public class ErrorbarExample extends BaseChartExample {

    public ErrorbarExample(String title, String icon) {
        super(title, icon);
    }

    @Override
    public String getSourcePath() {
        return "misc/Errorbar.java.html";
    }

    public static ExampleFactory getFactory() {
        return new ExampleFactory() {
            @Override
            public Canvas createChartCanvas() {
                return new ErrorbarExample(getTitle(), getIcon());
            }

            @Override
            public String getTitle() {
                return "Errorbar Example";
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
                .setZoomType(Chart.ZoomType.X_AND_Y)
                .setChartTitle(new ChartTitle()
                        .setText("Temperature vs Rainfall")
                )
                .setToolTip(
                        new ToolTip()
                            .setShared(true)
                )
        ;

        chart.getXAxis()
                .setCategories("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec")
        ;

        chart.getYAxis(0)
                .setMin(0)
                .setMax(30)
                .setAxisTitle(new AxisTitle()
                        .setText("Temperature")
                        .setStyle(
                                new Style()
                                    .setColor("#89A54E")
                        )
                )
                .setLabels(
                        new YAxisLabels()
                            .setFormatter(
                                    new AxisLabelsFormatter() {
                                        public String format(AxisLabelsData axisLabelsData) {
                                            return axisLabelsData.getValueAsLong() + " °C";
                                        }
                                    }
                            )
                        .setStyle(
                                new Style()
                                    .setColor("#89A54E")
                        )
                )
        ;

        chart.getYAxis(1)
                .setMin(0)
                .setMax(300)
                .setAxisTitle(new AxisTitle()
                        .setText("Rainfall")
                        .setStyle(
                                new Style()
                                    .setColor("#4572A7")
                        )
                )
                .setLabels(
                        new YAxisLabels()
                            .setFormatter(
                                    new AxisLabelsFormatter() {
                                        public String format(AxisLabelsData axisLabelsData) {
                                            return axisLabelsData.getValueAsLong() + " mm";
                                        }
                                    }
                            )
                            .setStyle(
                                    new Style()
                                        .setColor("#4572A7")
                            )
                )
                .setOpposite(true)
        ;

        chart.addSeries(chart.createSeries()
                .setName("Temperature")
                .setPoints(new Number[]
                        {7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6})
                .setType(Series.Type.SPLINE)
                .setToolTip(
                        new ToolTip()
                            .setPointFormat("<span style=\"font-weight: bold; color: {series.color}\">{series.name}</span>: <b>{point.y:.1f}°C</b>")
                )
        )
                .setSplinePlotOptions(
                        new SplinePlotOptions()
                            .setColor("#89A54E")
                            .setZIndex(1)
                )
                .addSeries(chart.createSeries()
                        .setName("Temperature Error")
                        .setPoints(new Number[][]
                                {{6, 8}, {5.9, 7.6}, {9.4, 10.4}, {14.1, 15.9}, {18.0, 20.1}, {21.0, 24.0}, {23.2, 25.3}, {26.1, 27.8}, {23.2, 23.9}, {18.0, 21.1}, {12.9, 14.0}, {7.6, 10.0}}
                        )
                        .setType(Series.Type.ERRORBAR)
                        .setPlotOptions(
                                new ErrorBarPlotOptions()
                                    .setWhiskerWidth(2)
                        )
                        .setToolTip(
                                new ToolTip()
                                        .setPointFormat(" (error range: {point.low}-{point.high}°C)<br/>")
                        )
                )

                .addSeries(chart.createSeries()
                        .setName("Rainfall")
                        .setPoints(new Number[]
                                {49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4})
                        .setType(Series.Type.COLUMN)
                        .setYAxis(1)
                        .setToolTip(
                                new ToolTip()
                                        .setPointFormat("<span style=\"font-weight: bold; color: {series.color}\">{series.name}</span>: <b>{point.y:.1f} mm</b>")
                        )
                )
                .setColumnPlotOptions(
                        new ColumnPlotOptions()
                                .setColor("#4572A7")
                )
                .addSeries(chart.createSeries()
                        .setName("Rainfall Error")
                        .setPoints(new Number[][]
                                {{48, 51}, {68, 73}, {92, 110}, {128, 136}, {140, 150}, {171, 179}, {135, 143}, {142, 149}, {204, 220}, {189, 199}, {95, 110}, {52, 56}}
                        )
                        .setYAxis(1)
                        .setType(Series.Type.ERRORBAR)
                        .setPlotOptions(
                                new ErrorBarPlotOptions()
                                        .setWhiskerWidth(2)
                        )
                        .setToolTip(
                                new ToolTip()
                                    .setPointFormat(" (error range: {point.low}-{point.high} mm)<br/>")
                        )
                )
        ;

        return chart;
    }
}
