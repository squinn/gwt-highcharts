package org.moxieapps.gwt.highcharts.showcase.client.bar;

import com.smartgwt.client.widgets.Canvas;
import org.moxieapps.gwt.highcharts.client.*;
import org.moxieapps.gwt.highcharts.client.labels.DataLabels;
import org.moxieapps.gwt.highcharts.client.labels.StackLabels;
import org.moxieapps.gwt.highcharts.client.plotOptions.ColumnPlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.PlotOptions;
import org.moxieapps.gwt.highcharts.showcase.client.BaseChartExample;
import org.moxieapps.gwt.highcharts.showcase.client.ExampleFactory;

public class StackedColumnExample extends BaseChartExample {

    public StackedColumnExample(String title, String icon) {
        super(title, icon);
    }

    @Override
    public String getSourcePath() {
        return "bar/StackedColumnExample.java.html";
    }

    public static ExampleFactory getFactory() {
        return new ExampleFactory() {
            @Override
            public Canvas createChartCanvas() {
                return new StackedColumnExample(getTitle(), getIcon());
            }

            @Override
            public String getTitle() {
                return "Stacked Columns";
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
            .setChartTitleText("Stacked column chart")
            .setColumnPlotOptions(new ColumnPlotOptions()
                .setStacking(PlotOptions.Stacking.NORMAL)
                .setDataLabels(new DataLabels()
                    .setEnabled(true)
                        // TODO: Add support for getting the color from the theme.  E.g.: Highcharts.theme.dataLabelsColor
                    .setColor("#FFFFFF")
                )
            )
            .setLegend(new Legend()
                .setAlign(Legend.Align.RIGHT)
                .setVerticalAlign(Legend.VerticalAlign.TOP)
                .setX(-100)
                .setY(20)
                .setFloating(true)
                    // TODO: Add support for getting the legend bg color from the theme.  E.g.: Highcharts.theme.legendBackgroundColorSolid
                .setBackgroundColor("#FFFFFF")
                .setBorderColor("#CCC")
                .setBorderWidth(1)
                .setShadow(false)
            )
            .setToolTip(new ToolTip()
                .setFormatter(new ToolTipFormatter() {
                    public String format(ToolTipData toolTipData) {
                        return "<b>" + toolTipData.getXAsString() + "</b><br/>" +
                            toolTipData.getSeriesName() + ": " + toolTipData.getYAsLong() + "<br/>" +
                            "Total: " + toolTipData.getTotal();
                    }
                })
            );

        chart.getXAxis()
            .setCategories("Apples", "Oranges", "Pears", "Grapes", "Bananas");

        chart.getYAxis()
            .setMin(0)
            .setAxisTitleText("Total fruit consumption")
            .setStackLabels(new StackLabels()
                .setEnabled(true)
                .setStyle(new Style()
                    .setFontWeight("bold")
                    // TODO: Add support for getting the default text color from the theme
                    .setColor("gray")
                )
            );

        chart.addSeries(chart.createSeries()
            .setName("John")
            .setPoints(new Number[] {5, 3, 4, 7, 2})
        );
        chart.addSeries(chart.createSeries()
            .setName("Jane")
            .setPoints(new Number[] {2, 2, 3, 2, 1})
        );
        chart.addSeries(chart.createSeries()
            .setName("Joe")
            .setPoints(new Number[] {3, 4, 4, 2, 5})
        );

        return chart;
    }
}