package org.moxieapps.gwt.highcharts.showcase.client.misc;


import com.smartgwt.client.widgets.Canvas;
import org.moxieapps.gwt.highcharts.client.*;
import org.moxieapps.gwt.highcharts.client.labels.DataLabels;
import org.moxieapps.gwt.highcharts.client.plotOptions.SeriesPlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.WaterfallPlotOptions;
import org.moxieapps.gwt.highcharts.showcase.client.BaseChartExample;
import org.moxieapps.gwt.highcharts.showcase.client.ExampleFactory;

public class WaterfallChartExample extends BaseChartExample {

    public WaterfallChartExample(String title, String icon) {
        super(title, icon);
    }

    @Override
    public String getSourcePath() {
        return "misc/WaterfallChartExample.java.html";
    }

    public static ExampleFactory getFactory() {
        return new ExampleFactory() {
            @Override
            public Canvas createChartCanvas() {
                return new WaterfallChartExample(getTitle(), getIcon());
            }

            @Override
            public String getTitle() {
                return "GWT Highcharts Waterfall";
            }

            @Override
            public String getIcon() {
                return "icons/16/combination_chart.png";
            }
        };
    }

    @Override
    public Chart createChart() {

        final String[] colors = new String[]{
                "#8BBC21",
                "#910000",
                "#FFFFFF",
                "#0D233A"
        };

        final Chart chart = new Chart()
                .setType(Series.Type.WATERFALL)
                .setChartTitle(new ChartTitle()
                        .setText("GWT Highcharts Waterfall")
                )
                .setLegend(new Legend()
                        .setEnabled(false)
                )
                .setToolTip(new ToolTip()
                        .setPointFormat("<b>${point.y:,.2f}<t/b> USD")
                )
        ;

        chart.getXAxis()
                .setType(Axis.Type.CATEGORY)
        ;


        chart.getYAxis()
                .setAxisTitleText("USD")
        ;


        chart.setWaterfallPlotOptions(
                new WaterfallPlotOptions()
                        .setDataLabels(
                                new DataLabels()
                                        .setEnabled(true)
                                        .setColor(colors[2])
                        )
                        .setUpColor(colors[0])
                        .setColor(colors[1])

        );

        chart.addSeries(
                chart.createSeries()
                        .setPoints(new Point[]{
                                new Point("Start", 120000),
                                new Point("Product Revenue", 569000),
                                new Point("Service Revenue", 231000),
                                new Point("Positive Balance")
                                        .setIsIntermediateSum(true)
                                        .setColor(colors[3]),
                                new Point("Fixed Costs", -342000),
                                new Point("Variable Costs", -233000),
                                new Point("Balance", 345000)
                                        .setIsSum(true)
                                        .setColor(colors[3])
                        })
        );


        return chart;
    }
}
