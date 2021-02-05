package org.moxieapps.gwt.highcharts.showcase.client.area;

import com.smartgwt.client.widgets.Canvas;
import org.moxieapps.gwt.highcharts.client.*;
import org.moxieapps.gwt.highcharts.client.plotOptions.AreaSplinePlotOptions;
import org.moxieapps.gwt.highcharts.showcase.client.BaseChartExample;
import org.moxieapps.gwt.highcharts.showcase.client.ExampleFactory;

public class AreaSplineExample extends BaseChartExample {

    public AreaSplineExample(String title, String icon) {
        super(title, icon);
    }

    @Override
    public String getSourcePath() {
        return "area/AreaSplineExample.java.html";
    }

    public static ExampleFactory getFactory() {
        return new ExampleFactory() {
            @Override
            public Canvas createChartCanvas() {
                return new AreaSplineExample(getTitle(), getIcon());
            }

            @Override
            public String getTitle() {
                return "Area Spline";
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
            .setType(Series.Type.AREA_SPLINE)
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
                            return toolTipData.getXAsString() + ": " + toolTipData.getYAsLong() + " units";
                        }
                    }
                )
            )
            .setAreaSplinePlotOptions(new AreaSplinePlotOptions()
                .setFillOpacity(0.5)
            )
            .setCredits(new Credits()
                .setEnabled(false)
            );

        final XAxis axis = chart.getXAxis();
        axis.setCategories("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
            .setPlotBands(  // Visualize the weekend
                axis.createPlotBand()
                    .setFrom(4.5)
                    .setTo(6.5)
                    .setColor(new Color(68, 170, 213, .2))
            );

        chart.getYAxis()
            .setAxisTitleText("Fruit units");

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