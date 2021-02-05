package org.moxieapps.gwt.highcharts.showcase.client.area;

import com.smartgwt.client.widgets.Canvas;
import org.moxieapps.gwt.highcharts.client.*;
import org.moxieapps.gwt.highcharts.client.labels.AxisLabelsData;
import org.moxieapps.gwt.highcharts.client.labels.AxisLabelsFormatter;
import org.moxieapps.gwt.highcharts.client.labels.YAxisLabels;
import org.moxieapps.gwt.highcharts.client.plotOptions.AreaPlotOptions;
import org.moxieapps.gwt.highcharts.showcase.client.BaseChartExample;
import org.moxieapps.gwt.highcharts.showcase.client.ExampleFactory;

public class AreaWithMissingPointsExample extends BaseChartExample {

    public AreaWithMissingPointsExample(String title, String icon) {
        super(title, icon);
    }

    @Override
    public String getSourcePath() {
        return "area/AreaWithMissingPointsExample.java.html";
    }

    public static ExampleFactory getFactory() {
        return new ExampleFactory() {
            @Override
            public Canvas createChartCanvas() {
                return new AreaWithMissingPointsExample(getTitle(), getIcon());
            }

            @Override
            public String getTitle() {
                return "Area with Missing Points";
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
            .setChartTitleText("Fruit consumption *")
            .setChartSubtitle(new ChartSubtitle()
                .setText("* Jane's banana consumption is unknown")
                .setFloating(true)
                .setAlign(ChartTitle.Align.RIGHT)
                .setVerticalAlign(ChartTitle.VerticalAlign.BOTTOM)
                .setY(15)
            )
            .setSpacingBottom(30)
            .setLegend(new Legend()
                .setLayout(Legend.Layout.VERTICAL)
                .setAlign(Legend.Align.LEFT)
                .setVerticalAlign(Legend.VerticalAlign.TOP)
                .setX(150)
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
                            return "<b>" + toolTipData.getSeriesName() + "</b><br/>" +
                                toolTipData.getXAsString() + ": " + toolTipData.getYAsLong();
                        }
                    }
                )
            )
            .setCredits(new Credits()
                .setEnabled(false)
            )
            .setAreaPlotOptions(new AreaPlotOptions()
                .setFillOpacity(0.5)
            );

        chart.getXAxis()
            .setCategories(
                "Apples", "Pears", "Oranges", "Bananas", "Grapes", "Plums", "Strawberries", "Raspberries"
            );

        chart.getYAxis()
            .setAxisTitleText("Y-Axis")
            .setLabels(new YAxisLabels()
                .setFormatter(new AxisLabelsFormatter() {
                    public String format(AxisLabelsData axisLabelsData) {
                        return String.valueOf(axisLabelsData.getValueAsLong());
                    }
                })
            );

        chart.addSeries(chart.createSeries()
            .setName("John")
            .setPoints(new Number[] {0, 1, 4, 4, 5, 2, 3, 7})
        );
        chart.addSeries(chart.createSeries()
            .setName("Jane")
            .setPoints(new Number[] {1, 0, 3, null, 3, 1, 2, 1})
        );

        return chart;
    }
}
