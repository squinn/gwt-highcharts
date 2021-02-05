package org.moxieapps.gwt.highcharts.showcase.client.pie;

import com.smartgwt.client.widgets.Canvas;
import org.moxieapps.gwt.highcharts.client.*;
import org.moxieapps.gwt.highcharts.client.labels.DataLabels;
import org.moxieapps.gwt.highcharts.client.labels.PieDataLabels;
import org.moxieapps.gwt.highcharts.client.plotOptions.PiePlotOptions;
import org.moxieapps.gwt.highcharts.showcase.client.BaseChartExample;
import org.moxieapps.gwt.highcharts.showcase.client.ExampleFactory;

public class DonutExample extends BaseChartExample {

    public DonutExample(String title, String icon) {
        super(title, icon);
    }

    @Override
    public String getSourcePath() {
        return "pie/DonutExample.java.html";
    }

    public static ExampleFactory getFactory() {
        return new ExampleFactory() {
            @Override
            public Canvas createChartCanvas() {
                return new DonutExample(getTitle(), getIcon());
            }

            @Override
            public String getTitle() {
                return "Donut Chart";
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
            .setChartTitleText("Browser market shares at a specific website")
            .setChartSubtitleText("Inner circle: 2008, outer circle: 2010")
            .setPlotBackgroundColor("none")
            .setPlotBorderWidth(0)
            .setPlotShadow(false)
            .setToolTip(new ToolTip()
                .setFormatter(new ToolTipFormatter() {
                    public String format(ToolTipData toolTipData) {
                        return "<b>" + toolTipData.getSeriesName() + "</b><br/>" +
                            toolTipData.getPointName() + ": " + toolTipData.getYAsDouble() + " %";
                    }
                })
            );

        chart.addSeries(chart.createSeries()
            .setName("2008")
            .setPlotOptions(new PiePlotOptions()
                .setCenter(.5, .5)
                .setSize(.45)
                .setInnerSize(.20)
                .setDataLabels(new DataLabels()
                    .setEnabled(false)
                )
            )
            .setPoints(new Point[]{
                new Point("Firefox", 44.2).setColor("#4572A7"),
                new Point("IE", 46.6).setColor("#AA4643"),
                new Point("Chrome", 3.1).setColor("#89A54E"),
                new Point("Safari", 2.7).setColor("#80699B"),
                new Point("Opera", 2.3).setColor("#3D96AE"),
                new Point("Others", 0.4).setColor("#DB843D")
            })
        );

        chart.addSeries(chart.createSeries()
            .setName("2010")
            .setPlotOptions(new PiePlotOptions()
                .setCenter(.5, .5)
                .setInnerSize(.45)
                .setPieDataLabels(new PieDataLabels()
                    .setEnabled(true)
                        // TODO: Add support for getting the colors from the theme.  E.g.: Highcharts.theme.textColor
                    .setColor("#000000")
                    .setConnectorColor("#000000")
                )
            )
            .setPoints(new Point[]{
                new Point("Firefox", 45.0).setColor("#4572A7"),
                new Point("IE", 26.8).setColor("#AA4643"),
                new Point("Chrome", 12.8).setColor("#89A54E"),
                new Point("Safari", 8.5).setColor("#80699B"),
                new Point("Opera", 6.2).setColor("#3D96AE"),
                new Point("Others", 0.2).setColor("#DB843D")
            })
        );

        return chart;
    }
}
