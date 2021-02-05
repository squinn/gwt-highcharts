package org.moxieapps.gwt.highcharts.showcase.client.misc;

import com.smartgwt.client.widgets.Canvas;
import org.moxieapps.gwt.highcharts.client.*;
import org.moxieapps.gwt.highcharts.client.labels.FunnelDataLabels;
import org.moxieapps.gwt.highcharts.client.labels.PyramidDataLabels;
import org.moxieapps.gwt.highcharts.client.plotOptions.FunnelPlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.PyramidPlotOptions;
import org.moxieapps.gwt.highcharts.showcase.client.BaseChartExample;
import org.moxieapps.gwt.highcharts.showcase.client.ExampleFactory;

public class PyramidChartExample extends BaseChartExample {

    public PyramidChartExample(String title, String icon) {
        super(title, icon);
    }

    @Override
    public String getSourcePath() {
        return "misc/PyramidChartExample.java.html";
    }

    public static ExampleFactory getFactory() {
        return new ExampleFactory() {
            @Override
            public Canvas createChartCanvas() {
                return new PyramidChartExample(getTitle(), getIcon());
            }

            @Override
            public String getTitle() {
                return "Pyramid Chart";
            }

            @Override
            public String getIcon() {
                return "icons/16/pie_chart.png";
            }
        };
    }

    @Override
    public Chart createChart() {

        final Chart chart = new Chart();
        chart.setType(Series.Type.PYRAMID)
                .setZoomType(BaseChart.ZoomType.X_AND_Y)
                .setChartTitleText("Sales Pyramid")
                .setChartTitle(new ChartTitle()
                        .setText("Sales Pyramid")
                )
                .setSpacingLeft(100)
                .setSpacingRight(100)
                .setPyramidPlotOptions(new PyramidPlotOptions()
                        .setPyramidDataLabels(new PyramidDataLabels()
                                .setEnabled(true)
                                .setFormat("<b>{point.name}</b> ({point.y:,.0f})")
                                .setColor("black")
                        )
                )
                .setLegend(new Legend()
                        .setEnabled(false)
                )
                .addSeries(chart.createSeries()
                        .setName("Unique users")
                        .setPoints(new Point[]{
                                new Point("Website visits", 15654),
                                new Point("Downloads", 4064),
                                new Point("Requested price list", 1987),
                                new Point("Invoice sent", 976),
                                new Point("Finalized", 846),
                        })
                );

        return chart;
    }
}
