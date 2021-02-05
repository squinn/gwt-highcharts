package org.moxieapps.gwt.highcharts.showcase.client.area;

import com.smartgwt.client.widgets.Canvas;
import org.moxieapps.gwt.highcharts.client.*;
import org.moxieapps.gwt.highcharts.client.labels.AxisLabelsData;
import org.moxieapps.gwt.highcharts.client.labels.AxisLabelsFormatter;
import org.moxieapps.gwt.highcharts.client.labels.XAxisLabels;
import org.moxieapps.gwt.highcharts.client.labels.YAxisLabels;
import org.moxieapps.gwt.highcharts.client.plotOptions.AreaPlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.Marker;
import org.moxieapps.gwt.highcharts.showcase.client.BaseChartExample;
import org.moxieapps.gwt.highcharts.showcase.client.ExampleFactory;

public class BasicAreaExample extends BaseChartExample {

    public BasicAreaExample(String title, String icon) {
        super(title, icon);
    }

    @Override
    public String getSourcePath() {
        return "area/BasicAreaExample.java.html";
    }

    public static ExampleFactory getFactory() {
        return new ExampleFactory() {
            @Override
            public Canvas createChartCanvas() {
                return new BasicAreaExample(getTitle(), getIcon());
            }

            @Override
            public String getTitle() {
                return "Basic Area Chart";
            }

            @Override
            public String getIcon() {
                return "icons/16/area_chart.png";
            }
        };
    }

    @Override
    public Chart createChart() {

        final Chart chart = new Chart()
            .setType(Series.Type.AREA)
            .setChartTitleText("US and USSR nuclear stockpiles")
            .setChartSubtitleText(
                "Source: " +
                    "<a href=\"http://thebulletin.metapress.com/content/c4120650912x74k7/fulltext.pdf\">" +
                    "thebulletin.metapress.com</a>"
            )
            .setAreaPlotOptions(new AreaPlotOptions()
                .setPointStart(1940)
                .setMarker(new Marker()
                    .setEnabled(false)
                    .setSymbol(Marker.Symbol.CIRCLE)
                    .setRadius(2)
                    .setHoverState(new Marker()
                        .setEnabled(true)
                    )
                )

            )
            .setToolTip(new ToolTip()
                .setFormatter(
                    new ToolTipFormatter() {
                        public String format(ToolTipData toolTipData) {
                            return toolTipData.getSeriesName() +
                                " produced <b>" +
                                toolTipData.getYAsLong() +
                                "</b><br/>warheads in " +
                                toolTipData.getXAsLong();
                        }
                    }
                )
            );

        chart.getXAxis()
            .setLabels(new XAxisLabels()
                .setFormatter(
                    new AxisLabelsFormatter() {
                        public String format(AxisLabelsData axisLabelsData) {
                            // clean, unformatted number for year
                            return String.valueOf(axisLabelsData.getValueAsLong());
                        }
                    }
                )
            );

        chart.getYAxis()
            .setAxisTitleText("Nuclear weapon states")
            .setLabels(new YAxisLabels()
                .setFormatter(
                    new AxisLabelsFormatter() {
                        public String format(AxisLabelsData axisLabelsData) {
                            return axisLabelsData.getValueAsLong() / 1000 + "k";
                        }
                    }
                )
            );

        chart.addSeries(chart.createSeries()
            .setName("USA")
            .setPoints(new Number[]{
                0, 0, 0, 0, 0, 6, 11, 32, 110, 235, 369, 640,
                1005, 1436, 2063, 3057, 4618, 6444, 9822, 15468, 20434, 24126,
                27387, 29459, 31056, 31982, 32040, 31233, 29224, 27342, 26662,
                26956, 27912, 28999, 28965, 27826, 25579, 25722, 24826, 24605,
                24304, 23464, 23708, 24099, 24357, 24237, 24401, 24344, 23586,
                22380, 21004, 17287, 14747, 13076, 12555, 12144, 11009, 10950,
                10871, 10824, 10577, 10527, 10475, 10421, 10358, 10295, 10104
            })
        );
        chart.addSeries(chart.createSeries()
            .setName("USSR/Russia")
            .setPoints(new Number[]{
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                5, 25, 50, 120, 150, 200, 426, 660, 869, 1060, 1605, 2471, 3322,
                4238, 5221, 6129, 7089, 8339, 9399, 10538, 11643, 13092, 14478,
                15915, 17385, 19055, 21205, 23044, 25393, 27935, 30062, 32049,
                33952, 35804, 37431, 39197, 45000, 43000, 41000, 39000, 37000,
                35000, 33000, 31000, 29000, 27000, 25000, 24000, 23000, 22000,
                21000, 20000, 19000, 18000, 18000, 17000, 16000
            })
        );

        return chart;
    }
}
