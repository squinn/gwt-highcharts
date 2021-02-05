package org.moxieapps.gwt.highcharts.showcase.client.bar;

import com.smartgwt.client.widgets.Canvas;
import org.moxieapps.gwt.highcharts.client.*;
import org.moxieapps.gwt.highcharts.client.plotOptions.ColumnPlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.PlotOptions;
import org.moxieapps.gwt.highcharts.showcase.client.BaseChartExample;
import org.moxieapps.gwt.highcharts.showcase.client.ExampleFactory;

public class StackedPercentageColumnExample extends BaseChartExample {

    public StackedPercentageColumnExample(String title, String icon) {
        super(title, icon);
    }

    @Override
    public String getSourcePath() {
        return "bar/StackedPercentageColumnExample.java.html";
    }

    public static ExampleFactory getFactory() {
        return new ExampleFactory() {
            @Override
            public Canvas createChartCanvas() {
                return new StackedPercentageColumnExample(getTitle(), getIcon());
            }

            @Override
            public String getTitle() {
                return "Stacked Percentage Columns";
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
            .setChartTitleText("Stacked percentage column chart")
            .setColumnPlotOptions(new ColumnPlotOptions()
                .setStacking(PlotOptions.Stacking.PERCENT)
            )
            .setToolTip(new ToolTip()
                .setFormatter(new ToolTipFormatter() {
                    public String format(ToolTipData toolTipData) {
                        return toolTipData.getSeriesName() + ": " + toolTipData.getYAsLong() + 
                            " ("+ Math.round(toolTipData.getPercentage()) + "%)";
                    }
                })
            );

        chart.getXAxis()
            .setCategories("Apples", "Oranges", "Pears", "Grapes", "Bananas");

        chart.getYAxis()
            .setMin(0)
            .setAxisTitleText("Total fruit consumption");

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