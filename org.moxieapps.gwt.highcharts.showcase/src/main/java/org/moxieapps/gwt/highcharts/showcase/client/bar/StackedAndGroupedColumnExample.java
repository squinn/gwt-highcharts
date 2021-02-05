package org.moxieapps.gwt.highcharts.showcase.client.bar;

import com.smartgwt.client.widgets.Canvas;
import org.moxieapps.gwt.highcharts.client.*;
import org.moxieapps.gwt.highcharts.client.plotOptions.ColumnPlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.PlotOptions;
import org.moxieapps.gwt.highcharts.showcase.client.BaseChartExample;
import org.moxieapps.gwt.highcharts.showcase.client.ExampleFactory;

public class StackedAndGroupedColumnExample extends BaseChartExample {

    public StackedAndGroupedColumnExample(String title, String icon) {
        super(title, icon);
    }

    @Override
    public String getSourcePath() {
        return "bar/StackedAndGroupedColumnExample.java.html";
    }

    public static ExampleFactory getFactory() {
        return new ExampleFactory() {
            @Override
            public Canvas createChartCanvas() {
                return new StackedAndGroupedColumnExample(getTitle(), getIcon());
            }

            @Override
            public String getTitle() {
                return "Stacked and Grouped Columns";
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
            .setChartTitleText("Total fruit consumption, grouped by gender")
            .setColumnPlotOptions(new ColumnPlotOptions()
                .setStacking(PlotOptions.Stacking.NORMAL)
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
            .setAllowDecimals(false)
            .setMin(0)
            .setAxisTitleText("Number of fruits");

        chart.addSeries(chart.createSeries()
            .setName("John")
            .setPoints(new Number[] {5, 3, 4, 7, 2})
            .setStack("male")
        );
        chart.addSeries(chart.createSeries()
            .setName("Joe")
            .setPoints(new Number[] {3, 4, 4, 2, 5})
            .setStack("male")
        );
        chart.addSeries(chart.createSeries()
            .setName("Jane")
            .setPoints(new Number[] {2, 2, 3, 2, 1})
            .setStack("female")
        );
        chart.addSeries(chart.createSeries()
            .setName("Janet")
            .setPoints(new Number[] {3, 0, 4, 4, 3})
            .setStack("female")
        );

        return chart;
    }
}