package org.moxieapps.gwt.highcharts.showcase.client.area;

import com.smartgwt.client.widgets.Canvas;
import org.moxieapps.gwt.highcharts.client.*;
import org.moxieapps.gwt.highcharts.showcase.client.BaseChartExample;
import org.moxieapps.gwt.highcharts.showcase.client.ExampleFactory;

public class AreaWithNegativeValuesExample extends BaseChartExample {

    public AreaWithNegativeValuesExample(String title, String icon) {
        super(title, icon);
    }

    @Override
    public String getSourcePath() {
        return "area/AreaWithNegativeValuesExample.java.html";
    }

    public static ExampleFactory getFactory() {
        return new ExampleFactory() {
            @Override
            public Canvas createChartCanvas() {
                return new AreaWithNegativeValuesExample(getTitle(), getIcon());
            }

            @Override
            public String getTitle() {
                return "Area with Negative Values";
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
            .setChartTitleText("Area chart with negative values")
            .setToolTip(new ToolTip()
                .setFormatter(
                    new ToolTipFormatter() {
                        public String format(ToolTipData toolTipData) {
                            return toolTipData.getSeriesName() + ": " + toolTipData.getYAsLong();
                        }
                    }
                )
            )
            .setCredits(new Credits()
                .setEnabled(false)
            );

        chart.getXAxis()
            .setCategories(
                "Apples", "Oranges", "Pears", "Grapes", "Bananas"
            );

        chart.addSeries(chart.createSeries()
            .setName("John")
            .setPoints(new Number[] { 5, 3, 4, 7, 2 })
        );
        chart.addSeries(chart.createSeries()
            .setName("Jane")
            .setPoints(new Number[] { 2, -2, -3, 2, 1 })
        );
        chart.addSeries(chart.createSeries()
            .setName("Joe")
            .setPoints(new Number[] { 3, 4, 4, -2, 5 })
        );

        return chart;
    }
}