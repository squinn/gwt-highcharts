package org.moxieapps.gwt.highcharts.showcase.client.area;

import com.smartgwt.client.widgets.Canvas;
import org.moxieapps.gwt.highcharts.client.*;
import org.moxieapps.gwt.highcharts.client.labels.AxisLabelsData;
import org.moxieapps.gwt.highcharts.client.labels.AxisLabelsFormatter;
import org.moxieapps.gwt.highcharts.client.labels.YAxisLabels;
import org.moxieapps.gwt.highcharts.client.plotOptions.AreaPlotOptions;
import org.moxieapps.gwt.highcharts.showcase.client.BaseChartExample;
import org.moxieapps.gwt.highcharts.showcase.client.ExampleFactory;

public class InvertedAxesAreaExample extends BaseChartExample {

    public InvertedAxesAreaExample(String title, String icon) {
        super(title, icon);
    }

    @Override
    public String getSourcePath() {
        return "area/InvertedAxesAreaExample.java.html";
    }

    public static ExampleFactory getFactory() {
        return new ExampleFactory() {
            @Override
            public Canvas createChartCanvas() {
                return new InvertedAxesAreaExample(getTitle(), getIcon());
            }

            @Override
            public String getTitle() {
                return "Inverted Axes";
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
            .setInverted(true)
            .setChartTitleText("Average fruit consumption during one week")
            .setChartSubtitle(new ChartSubtitle()
                .setStyle(new Style()
                    .setPosition("absolute")
                    .setRight("0px")
                    .setBottom("0px")
                )
            )
            .setLegend(new Legend()
                .setLayout(Legend.Layout.VERTICAL)
                .setAlign(Legend.Align.RIGHT)
                .setVerticalAlign(Legend.VerticalAlign.TOP)
                .setX(-150)
                .setY(100)
                .setFloating(true)
                .setBorderWidth(1)
                    // TODO: Add support for getting the legend bg color from the theme.  E.g.: Highcharts.theme.legendBackgroundColor
                .setBackgroundColor("#FFFFFF")
            )
            .setToolTip(new ToolTip()
                .setFormatter(
                    new ToolTipFormatter() {
                        public String format(ToolTipData toolTipData) {
                            return toolTipData.getXAsString() + ": " + toolTipData.getYAsLong();
                        }
                    }
                )
            )
            .setAreaPlotOptions(new AreaPlotOptions()
                .setFillOpacity(0.5)
            );

        chart.getXAxis()
            .setCategories(
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday"
            );

        chart.getYAxis()
            .setAxisTitleText("Number of units")
            .setMin(0)
            .setLabels(new YAxisLabels()
                .setFormatter(new AxisLabelsFormatter() {
                    public String format(AxisLabelsData axisLabelsData) {
                        return String.valueOf(axisLabelsData.getValueAsLong());
                    }
                })
            );

        chart.addSeries(chart.createSeries()
            .setName("John")
            .setPoints(new Number[]{3, 4, 3, 5, 4, 10, 12})
        );
        chart.addSeries(chart.createSeries()
            .setName("Jane")
            .setPoints(new Number[]{1, 3, 4, 3, 3, 5, 4})
        );

        return chart;
    }
}
