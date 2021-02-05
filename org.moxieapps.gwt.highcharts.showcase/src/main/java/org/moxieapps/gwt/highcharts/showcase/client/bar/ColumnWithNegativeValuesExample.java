package org.moxieapps.gwt.highcharts.showcase.client.bar;

import com.smartgwt.client.widgets.Canvas;
import org.moxieapps.gwt.highcharts.client.*;
import org.moxieapps.gwt.highcharts.showcase.client.BaseChartExample;
import org.moxieapps.gwt.highcharts.showcase.client.ExampleFactory;

public class ColumnWithNegativeValuesExample extends BaseChartExample {

    public ColumnWithNegativeValuesExample(String title, String icon) {
        super(title, icon);
    }

    @Override
    public String getSourcePath() {
        return "bar/ColumnWithNegativeValuesExample.java.html";
    }

    public static ExampleFactory getFactory() {
        return new ExampleFactory() {
            @Override
            public Canvas createChartCanvas() {
                return new ColumnWithNegativeValuesExample(getTitle(), getIcon());
            }

            @Override
            public String getTitle() {
                return "Column with Negative Values";
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
            .setChartTitleText("Column chart with negative values")
            .setCredits(new Credits()
                .setEnabled(false)
            )
            .setToolTip(new ToolTip()
                .setFormatter(new ToolTipFormatter() {
                    public String format(ToolTipData toolTipData) {
                        return toolTipData.getSeriesName() + ": " + toolTipData.getXAsLong();
                    }
                })
            );

        chart.getXAxis()
            .setCategories("Apples", "Oranges", "Pears", "Grapes", "Bananas");

        chart.addSeries(chart.createSeries()
            .setName("John")
            .setPoints(new Number[]{5, 3, 4, 7, 2})
        );
        chart.addSeries(chart.createSeries()
            .setName("Jane")
            .setPoints(new Number[]{2, -2, -3, 2, 1})
        );
        chart.addSeries(chart.createSeries()
            .setName("Joe")
            .setPoints(new Number[]{3, 4, 4, -2, 5})
        );

        return chart;
    }
}
