package org.moxieapps.gwt.highcharts.showcase.client.pie;

import com.smartgwt.client.widgets.Canvas;
import org.moxieapps.gwt.highcharts.client.*;
import org.moxieapps.gwt.highcharts.client.labels.DataLabelsData;
import org.moxieapps.gwt.highcharts.client.labels.DataLabelsFormatter;
import org.moxieapps.gwt.highcharts.client.labels.PieDataLabels;
import org.moxieapps.gwt.highcharts.client.plotOptions.PiePlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.PlotOptions;
import org.moxieapps.gwt.highcharts.showcase.client.BaseChartExample;
import org.moxieapps.gwt.highcharts.showcase.client.ExampleFactory;

public class BasicPieExample extends BaseChartExample {

    public BasicPieExample(String title, String icon) {
        super(title, icon);
    }

    @Override
    public String getSourcePath() {
        return "pie/BasicPieExample.java.html";
    }

    public static ExampleFactory getFactory() {
        return new ExampleFactory() {
            @Override
            public Canvas createChartCanvas() {
                return new BasicPieExample(getTitle(), getIcon());
            }

            @Override
            public String getTitle() {
                return "Basic Pie Chart";
            }

            @Override
            public String getIcon() {
                return "icons/16/pie_chart.png";
            }
        };
    }

    @Override
    public Chart createChart() {

        final Chart chart = new Chart()
            .setType(Series.Type.PIE)
            .setChartTitleText("Browser market shares at a specific website, 2010")
            .setPlotBackgroundColor((String) null)
            .setPlotBorderWidth(null)
            .setPlotShadow(false)
            .setPiePlotOptions(new PiePlotOptions()
                .setAllowPointSelect(true)
                .setCursor(PlotOptions.Cursor.POINTER)
                .setPieDataLabels(new PieDataLabels()
                    .setConnectorColor("#000000")
                    .setEnabled(true)
                        // TODO: Add support for getting the colors from the theme.  E.g.: Highcharts.theme.textColor
                    .setColor("#000000")
                    .setFormatter(new DataLabelsFormatter() {
                        public String format(DataLabelsData dataLabelsData) {
                            return "<b>" + dataLabelsData.getPointName() + "</b>: " + dataLabelsData.getYAsDouble() + " %";
                        }
                    })
                )
            )
            .setLegend(new Legend()
                .setLayout(Legend.Layout.VERTICAL)
                .setAlign(Legend.Align.RIGHT)
                .setVerticalAlign(Legend.VerticalAlign.TOP)
                .setX(-100)
                .setY(100)
                .setFloating(true)
                .setBorderWidth(1)
                    // TODO: Add support for getting the legend bg color from the theme.  E.g.: Highcharts.theme.legendBackgroundColor
                .setBackgroundColor("#FFFFFF")
                .setShadow(true)
            )
            .setToolTip(new ToolTip()
                .setFormatter(new ToolTipFormatter() {
                    public String format(ToolTipData toolTipData) {
                        return "<b>" + toolTipData.getPointName() + "</b>: " + toolTipData.getYAsDouble() + " %";
                    }
                })
            );

        chart.addSeries(chart.createSeries()
            .setName("Browser share")
            .setPoints(new Point[]{
                new Point("Firefox", 45.0),
                new Point("IE", 26.8),
                new Point("Chrome", 12.8)
                    .setSliced(true)
                    .setSelected(true),
                new Point("Safari", 8.5),
                new Point("Opera", 6.2),
                new Point("Others", 0.7)
            })
        );

        return chart;
    }
}