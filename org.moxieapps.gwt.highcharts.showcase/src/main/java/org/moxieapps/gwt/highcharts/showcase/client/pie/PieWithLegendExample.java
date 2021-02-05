package org.moxieapps.gwt.highcharts.showcase.client.pie;

import com.smartgwt.client.widgets.Canvas;
import org.moxieapps.gwt.highcharts.client.*;
import org.moxieapps.gwt.highcharts.client.labels.PieDataLabels;
import org.moxieapps.gwt.highcharts.client.plotOptions.PiePlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.PlotOptions;
import org.moxieapps.gwt.highcharts.showcase.client.BaseChartExample;
import org.moxieapps.gwt.highcharts.showcase.client.ExampleFactory;

public class PieWithLegendExample extends BaseChartExample {

    public PieWithLegendExample(String title, String icon) {
        super(title, icon);
    }

    @Override
    public String getSourcePath() {
        return "pie/PieWithLegendExample.java.html";
    }

    public static ExampleFactory getFactory() {
        return new ExampleFactory() {
            @Override
            public Canvas createChartCanvas() {
                return new PieWithLegendExample(getTitle(), getIcon());
            }

            @Override
            public String getTitle() {
                return "Pie with Legend";
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
            .setPlotShadow(true)
            .setPiePlotOptions(new PiePlotOptions()
                .setAllowPointSelect(true)
                .setCursor(PlotOptions.Cursor.POINTER)
                .setPieDataLabels(new PieDataLabels()
                    .setEnabled(false)
                )
                .setShowInLegend(true)
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