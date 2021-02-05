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

public class SplineWithInvertedAxesExample extends BaseChartExample {

    public SplineWithInvertedAxesExample(String title, String icon) {
        super(title, icon);
    }

    @Override
    public String getSourcePath() {
        return "line/SplineWithInvertedAxesExample.java.html";
    }

    public static ExampleFactory getFactory() {
        return new ExampleFactory() {
            @Override
            public Canvas createChartCanvas() {
                return new SplineWithInvertedAxesExample(getTitle(), getIcon());
            }

            @Override
            public String getTitle() {
                return "Spline With Inverted Axes";
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
            .setInverted(true)
            .setChartTitleText("Atmosphere Temperature by Altitude")
            .setChartSubtitleText("According to the Standard Atmosphere Model")
            .setStyle(new Style()
                .setMargin("0 auto")
            )
            .setLegend(new Legend()
                .setEnabled(false)
            )
            .setSplinePlotOptions(new SplinePlotOptions()
                .setMarker(new Marker()
                    .setEnabled(true)
                )
            )
            .setToolTip(new ToolTip()
                .setFormatter(new ToolTipFormatter() {
                    public String format(ToolTipData toolTipData) {
                        return toolTipData.getXAsLong() + " km: " + toolTipData.getYAsDouble() + "°C";
                    }
                })
            );

        chart.getXAxis()
            .setReversed(false)
            .setAxisTitleText("Altitude")
            .setMaxPadding(0.05)
            .setShowLastLabel(true)
            .setLabels(new XAxisLabels()
                .setFormatter(
                    new AxisLabelsFormatter() {
                        public String format(AxisLabelsData axisLabelsData) {
                            return axisLabelsData.getValueAsLong() + "km";
                        }
                    }
                )
            );

        chart.getYAxis()
            .setAxisTitleText("Temperature")
            .setLineWidth(2)
            .setLabels(new YAxisLabels()
                .setFormatter(
                    new AxisLabelsFormatter() {
                        public String format(AxisLabelsData axisLabelsData) {
                            return axisLabelsData.getValueAsLong() + "°";
                        }
                    }
                )
            );

        chart.addSeries(chart.createSeries()
            .setName("Temperature")
            .setPoints(new Number[][]{
                {0, 15}, {10, -50}, {20, -56.5}, {30, -46.5}, {40, -22.1},
                {50, -2.5}, {60, -27.7}, {70, -55.7}, {80, -76.5}
            })
        );

        return chart;
    }

}
