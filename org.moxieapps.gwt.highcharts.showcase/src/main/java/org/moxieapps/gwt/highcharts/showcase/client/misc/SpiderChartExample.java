package org.moxieapps.gwt.highcharts.showcase.client.misc;

import com.smartgwt.client.widgets.Canvas;
import org.moxieapps.gwt.highcharts.client.*;
import org.moxieapps.gwt.highcharts.showcase.client.BaseChartExample;
import org.moxieapps.gwt.highcharts.showcase.client.ExampleFactory;

public class SpiderChartExample extends BaseChartExample {

    public SpiderChartExample(String title, String icon) {
        super(title, icon);
    }

    @Override
    public String getSourcePath() {
        return "misc/SpiderChartExample.java.html";
    }

    public static ExampleFactory getFactory() {
        return new ExampleFactory() {
            @Override
            public Canvas createChartCanvas() {
                return new SpiderChartExample(getTitle(), getIcon());
            }

            @Override
            public String getTitle() {
                return "Spiderweb Chart";
            }

            @Override
            public String getIcon() {
                return "icons/16/spider_chart.png";
            }
        };
    }

    @Override
    public Chart createChart() {

        final Chart chart = new Chart()
            .setPolar(true)
            .setType(Series.Type.LINE)
            .setChartTitle(new ChartTitle()
                .setText("Budget vs spending")
                .setX(-80)
            )
            .setToolTip(new ToolTip()
                .setShared(true)
                .setValuePrefix("$")
            )
            .setLegend(new Legend()
                .setAlign(Legend.Align.RIGHT)
                .setVerticalAlign(Legend.VerticalAlign.TOP)
                .setY(100)
                .setLayout(Legend.Layout.VERTICAL)
            )
            .setPane(new Pane()
                .setOption("size", "80%")
            );

        chart.getXAxis()
            .setTickmarkPlacement(XAxis.TickmarkPlacement.ON)
            .setLineWidth(0)
            .setCategories(
                "Sales", "Marketing", "Development", "Customer Support",
                "Information Technology", "Administration"
            );

        chart.getYAxis()
            .setOption("gridLineInterpolation", "polygon")
            .setLineWidth(0)
            .setMin(0);

        chart.addSeries(chart.createSeries()
            .setName("Allocated Budget")
            .setPoints(new Number[]{43000, 19000, 60000, 35000, 17000, 10000})
            .setOption("pointPlacement", "on")
        );
        chart.addSeries(chart.createSeries()
            .setName("Actual Spending")
            .setPoints(new Number[]{50000, 39000, 42000, 31000, 26000, 14000})
            .setOption("pointPlacement", "on")
        );

        return chart;
    }
}

