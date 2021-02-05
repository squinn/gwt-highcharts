package org.moxieapps.gwt.highcharts.showcase.client.threeD;


import com.smartgwt.client.widgets.Canvas;
import org.moxieapps.gwt.highcharts.client.*;
import org.moxieapps.gwt.highcharts.client.plotOptions.ColumnPlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.PlotOptions;
import org.moxieapps.gwt.highcharts.showcase.client.BaseChartExample;
import org.moxieapps.gwt.highcharts.showcase.client.ExampleFactory;

public class Column3DExample extends BaseChartExample {

    public Column3DExample(String title, String icon) {
        super(title, icon);
    }

    @Override
    public String getSourcePath() {
        return "threeD/column3DExample.java.html";
    }

    public static ExampleFactory getFactory() {
        return new ExampleFactory() {
            @Override
            public Canvas createChartCanvas() {
                return new Column3DExample(getTitle(), getIcon());
            }

            @Override
            public String getTitle() {
                return "3D Column Chart";
            }

            @Override
            public String getIcon() {
                return "icons/3D_chart.png";
            }
        };
    }

    @Override
    public BaseChart createChart() {

        final Chart chart = new Chart()
            .setType(Series.Type.COLUMN)
            .setOptions3D(new Options3D()
                    .setEnabled(true)
                    .setAlpha(15)
                    .setBeta(15)
                    .setViewDistance(25)
                    .setDepth(40)
            )
            .setMarginTop(80)
            .setMarginRight(40)
            .setChartTitleText("Total Fruit Consumption, grouped by gender");

        chart.getXAxis()
            .setCategories("Apples", "Oranges", "Pears", "Grapes", "Bananas");

        chart.getYAxis()
            .setAllowDecimals(false)
            .setMin(0)
            .setAxisTitle(new AxisTitle()
                .setText("Number of Fruits")
            );

        chart.setToolTip(new ToolTip()
            .setHeaderFormat("<b>{point.key}</b><br>")
            .setPointFormat("<span style=\"color:{series.color}\">\\u25CF</span> {series.name}: {point.y} / {point.stackTotal}")
        );

        chart.setColumnPlotOptions(new ColumnPlotOptions()
            .setStacking(PlotOptions.Stacking.NORMAL)
            .setDepth(40)
        );

        chart.addSeries(chart.createSeries()

                .setName("John")
                .setStack("male")
                .setPoints(new Number[] {5, 3, 4, 7, 2})
            )
            .addSeries(chart.createSeries()
                .setName("Joe")
                .setStack("male")
                .setPoints(new Number[] {3, 4, 4, 2, 5})
            )
            .addSeries(chart.createSeries()
               .setName("Jane")
               .setStack("female")
               .setPoints(new Number[] {2, 5, 6, 2, 1})
            )
            .addSeries(chart.createSeries()
               .setName("Janet")
               .setStack("female")
               .setPoints(new Number[] {3, 0, 4, 4, 3})
            );

        return chart;
    }

}
