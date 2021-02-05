package org.moxieapps.gwt.highcharts.showcase.client.area;

import com.google.gwt.i18n.client.NumberFormat;
import com.smartgwt.client.widgets.Canvas;
import org.moxieapps.gwt.highcharts.client.*;
import org.moxieapps.gwt.highcharts.client.labels.AxisLabelsData;
import org.moxieapps.gwt.highcharts.client.labels.AxisLabelsFormatter;
import org.moxieapps.gwt.highcharts.client.labels.YAxisLabels;
import org.moxieapps.gwt.highcharts.client.plotOptions.AreaPlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.Marker;
import org.moxieapps.gwt.highcharts.client.plotOptions.PlotOptions;
import org.moxieapps.gwt.highcharts.showcase.client.BaseChartExample;
import org.moxieapps.gwt.highcharts.showcase.client.ExampleFactory;

public class StackedAreaExample extends BaseChartExample {

    public StackedAreaExample(String title, String icon) {
        super(title, icon);
    }

    @Override
    public String getSourcePath() {
        return "area/StackedAreaExample.java.html";
    }

    public static ExampleFactory getFactory() {
        return new ExampleFactory() {
            @Override
            public Canvas createChartCanvas() {
                return new StackedAreaExample(getTitle(), getIcon());
            }

            @Override
            public String getTitle() {
                return "Stacked Area";
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
            .setChartTitleText("Historic and Estimated Worldwide Population Growth by Region")
            .setChartSubtitleText("Source: Wikipedia.org")
            .setAreaPlotOptions(new AreaPlotOptions()
                .setStacking(PlotOptions.Stacking.NORMAL)
                .setLineColor("#666666")
                .setLineWidth(1)
                .setMarker(new Marker()
                    .setLineWidth(1)
                    .setLineColor("#666666")
                )
            )
            .setToolTip(new ToolTip()
                .setFormatter(
                    new ToolTipFormatter() {
                        public String format(ToolTipData toolTipData) {
                            return toolTipData.getXAsDouble() + ": " +
                                NumberFormat.getFormat("#,###").format(toolTipData.getYAsDouble()) + " millions";
                        }
                    }
                )
            );

        chart.getXAxis()
            .setCategories(
                "1750", "1800", "1850", "1900", "1950", "1999", "2050"
            )
            .setTickmarkPlacement(XAxis.TickmarkPlacement.ON)
            .setAxisTitleText(null);

        chart.getYAxis()
            .setAxisTitleText("Billions")
            .setLabels(new YAxisLabels()
                .setFormatter(
                    new AxisLabelsFormatter() {
                        public String format(AxisLabelsData axisLabelsData) {
                            return String.valueOf(axisLabelsData.getValueAsLong() / 1000);
                        }
                    }
                )
            );

        chart.addSeries(chart.createSeries()
            .setName("Asia")
            .setPoints(new Number[] { 502, 635, 809, 947, 1402, 3634, 5268 })
        );
        chart.addSeries(chart.createSeries()
            .setName("Africa")
            .setPoints(new Number[] { 106, 107, 111, 133, 221, 767, 1766 })
        );
        chart.addSeries(chart.createSeries()
            .setName("Europe")
            .setPoints(new Number[] { 163, 203, 276, 408, 547, 729, 628 })
        );
        chart.addSeries(chart.createSeries()
            .setName("America")
            .setPoints(new Number[] { 18, 31, 54, 156, 339, 818, 1201 })
        );
        chart.addSeries(chart.createSeries()
            .setName("Oceania")
            .setPoints(new Number[] { 2, 2, 2, 6, 13, 30, 46 })
        );

        return chart;
    }
}

