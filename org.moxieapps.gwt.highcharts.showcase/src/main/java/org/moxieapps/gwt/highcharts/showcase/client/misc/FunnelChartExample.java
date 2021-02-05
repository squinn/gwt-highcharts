package org.moxieapps.gwt.highcharts.showcase.client.misc;

import com.smartgwt.client.widgets.Canvas;
import org.moxieapps.gwt.highcharts.client.*;
import org.moxieapps.gwt.highcharts.client.labels.FunnelDataLabels;
import org.moxieapps.gwt.highcharts.client.plotOptions.FunnelPlotOptions;
import org.moxieapps.gwt.highcharts.showcase.client.BaseChartExample;
import org.moxieapps.gwt.highcharts.showcase.client.ExampleFactory;

public class FunnelChartExample extends BaseChartExample {

    public FunnelChartExample(String title, String icon) {
        super(title, icon);
    }

    @Override
    public String getSourcePath() {
        return "misc/FunnelChartExample.java.html";
    }

    public static ExampleFactory getFactory() {
        return new ExampleFactory() {
            @Override
            public Canvas createChartCanvas() {
                return new FunnelChartExample(getTitle(), getIcon());
            }

            @Override
            public String getTitle() {
                return "Funnel Chart";
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
        chart.setType(Series.Type.FUNNEL)
            .setZoomType(BaseChart.ZoomType.X_AND_Y)
            .setChartTitleText("Sales Funnel")
            .setChartTitle(new ChartTitle()
                .setText("Sales Funnel")
                .setX(-50)
            )
                .setSpacingLeft(100)
                .setSpacingRight(100)
            .setFunnelPlotOptions(new FunnelPlotOptions()
            .setFunnelDataLabels(new FunnelDataLabels()
                .setEnabled(true)
                .setFormat("<b>{point.name}</b> ({point.y:,.0f})")
                .setColor("black")
            )
            .setNeckWidth("30%")
            .setNeckHeight("25%")
            )
            .setLegend(new Legend()
            .setEnabled(true)
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
