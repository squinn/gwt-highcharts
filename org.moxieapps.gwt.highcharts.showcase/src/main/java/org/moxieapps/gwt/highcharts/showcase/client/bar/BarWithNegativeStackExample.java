package org.moxieapps.gwt.highcharts.showcase.client.bar;

import com.google.gwt.i18n.client.NumberFormat;
import com.smartgwt.client.widgets.Canvas;
import org.moxieapps.gwt.highcharts.client.*;
import org.moxieapps.gwt.highcharts.client.labels.AxisLabelsData;
import org.moxieapps.gwt.highcharts.client.labels.AxisLabelsFormatter;
import org.moxieapps.gwt.highcharts.client.labels.YAxisLabels;
import org.moxieapps.gwt.highcharts.client.plotOptions.PlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.SeriesPlotOptions;
import org.moxieapps.gwt.highcharts.showcase.client.BaseChartExample;
import org.moxieapps.gwt.highcharts.showcase.client.ExampleFactory;

public class BarWithNegativeStackExample extends BaseChartExample {

    public BarWithNegativeStackExample(String title, String icon) {
        super(title, icon);
    }

    @Override
    public String getSourcePath() {
        return "bar/BarWithNegativeStackExample.java.html";
    }

    public static ExampleFactory getFactory() {
        return new ExampleFactory() {
            @Override
            public Canvas createChartCanvas() {
                return new BarWithNegativeStackExample(getTitle(), getIcon());
            }

            @Override
            public String getTitle() {
                return "Bar With Negative Stack";
            }

            @Override
            public String getIcon() {
                return "icons/16/bar_chart.png";
            }
        };
    }

    @Override
    public Chart createChart() {

        final Chart chart = new Chart()
            .setType(Series.Type.BAR)
            .setChartTitleText("Population pyramid for Germany, midyear 2010")
            .setChartSubtitleText("Source: www.census.gov")
            .setSeriesPlotOptions(new SeriesPlotOptions()
                .setStacking(PlotOptions.Stacking.NORMAL)
            )
            .setToolTip(new ToolTip()
                .setFormatter(new ToolTipFormatter() {
                    public String format(ToolTipData toolTipData) {
                        return "<b>" + toolTipData.getSeriesName() + ", age " +
                            toolTipData.getXAsString() + "</b><br/>" +
                            "Population: " +  NumberFormat.getFormat("#,###").format(toolTipData.getYAsDouble());
                    }
                })
            );

        String[] categories = new String[]{
            "0-4", "5-9", "10-14", "15-19",
            "20-24", "25-29", "30-34", "35-39", "40-44",
            "45-49", "50-54", "55-59", "60-64", "65-69",
            "70-74", "75-79", "80-84", "85-89", "90-94",
            "95-99", "100 +"
        };

        chart.getXAxis(0)
            .setCategories(categories)
            .setReversed(false);

        chart.getXAxis(1)
            .setCategories(categories)
            .setLinkedTo(0)
            .setOpposite(true)
            .setReversed(false);

        chart.getYAxis()
            .setAxisTitleText(null)
            .setMin(-4000000)
            .setMax(4000000)
            .setLabels(new YAxisLabels()
                .setFormatter(new AxisLabelsFormatter() {
                    public String format(AxisLabelsData axisLabelsData) {
                        return NumberFormat.getFormat("0.#").format(
                            Math.abs(axisLabelsData.getValueAsDouble()) / 1000000
                        ) + "M";
                    }
                })
            );

        chart.addSeries(chart.createSeries()
            .setName("Male")
            .setPoints(new Number[]{
                -1746181, -1884428, -2089758, -2222362, -2537431, -2507081, -2443179,
                -2664537, -3556505, -3680231, -3143062, -2721122, -2229181, -2227768,
                -2176300, -1329968, -836804, -354784, -90569, -28367, -3878
            })
        );
        chart.addSeries(chart.createSeries()
            .setName("Female")
            .setPoints(new Number[]{
                1656154, 1787564, 1981671, 2108575, 2403438, 2366003, 2301402, 2519874,
                3360596, 3493473, 3050775, 2759560, 2304444, 2426504, 2568938, 1785638,
                1447162, 1005011, 330870, 130632, 21208
            })
        );

        return chart;
    }
}