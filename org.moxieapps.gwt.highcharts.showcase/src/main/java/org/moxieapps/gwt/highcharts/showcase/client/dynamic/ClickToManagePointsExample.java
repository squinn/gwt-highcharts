package org.moxieapps.gwt.highcharts.showcase.client.dynamic;

import com.smartgwt.client.widgets.Canvas;
import org.moxieapps.gwt.highcharts.client.*;
import org.moxieapps.gwt.highcharts.client.events.ChartClickEvent;
import org.moxieapps.gwt.highcharts.client.events.ChartClickEventHandler;
import org.moxieapps.gwt.highcharts.client.events.PointClickEvent;
import org.moxieapps.gwt.highcharts.client.events.PointClickEventHandler;
import org.moxieapps.gwt.highcharts.client.plotOptions.SeriesPlotOptions;
import org.moxieapps.gwt.highcharts.showcase.client.BaseChartExample;
import org.moxieapps.gwt.highcharts.showcase.client.ExampleFactory;

public class ClickToManagePointsExample extends BaseChartExample {

    public ClickToManagePointsExample(String title, String icon) {
        super(title, icon);
    }

    @Override
    public String getSourcePath() {
        return "dynamic/ClickToManagePointsExample.java.html";
    }

    public static ExampleFactory getFactory() {
        return new ExampleFactory() {
            @Override
            public Canvas createChartCanvas() {
                return new ClickToManagePointsExample(getTitle(), getIcon());
            }

            @Override
            public String getTitle() {
                return "Click to Add & Remove Points";
            }

            @Override
            public String getIcon() {
                return "icons/16/line_chart.png";
            }
        };
    }

    @Override
    public Chart createChart() {

        final Chart chart = new Chart()
            .setType(Series.Type.SCATTER)
            .setMargin(70, 50, 60, 80)
            .setChartTitleText("User supplied data")
            .setChartSubtitleText("Click the plot area to add a point. Click a point to remove it.")
            .setExporting(new Exporting()
                .setEnabled(false)
            )
            .setLegend(new Legend()
                .setEnabled(false)
            );

        chart.getXAxis()
            .setMinPadding(0.2)
            .setMaxPadding(0.2)
            .setMaxZoom(60);

        final YAxis yAxis = chart.getYAxis();
        yAxis.setAxisTitleText("Value")
            .setMinPadding(0.2)
            .setMaxPadding(0.2)
            .setMaxZoom(60)
            .setPlotLines(yAxis.createPlotLine()
                .setValue(0)
                .setWidth(1)
                .setColor("#808080")
            );

        final Series series = chart.createSeries()
            .setPoints(new Number[][] {{20, 20}, {80, 80}});
        chart.addSeries(series);

        chart.setClickEventHandler(new ChartClickEventHandler() {
            public boolean onClick(ChartClickEvent chartClickEvent) {
                // Either reference the series instance that you created previously
                series.addPoint(chartClickEvent.getXAxisValue(), chartClickEvent.getYAxisValue());
                return true;
            }
        });

        chart.setSeriesPlotOptions(new SeriesPlotOptions()
            .setLineWidth(1)
            .setPointClickEventHandler(new PointClickEventHandler() {
                public boolean onClick(PointClickEvent pointClickEvent) {
                    // Or, you can look up the series dynamically based on the information in the event
                    Series series = chart.getSeries(pointClickEvent.getSeriesId());
                    if(series.getPoints().length > 1) {
                        pointClickEvent.getPoint().remove();
                    }
                    return true;
                }
            })
        );

        return chart;
    }
}