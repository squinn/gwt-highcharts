package org.moxieapps.gwt.highcharts.showcase.client.line;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import org.moxieapps.gwt.highcharts.client.*;
import org.moxieapps.gwt.highcharts.client.events.PointClickEvent;
import org.moxieapps.gwt.highcharts.client.events.PointClickEventHandler;
import org.moxieapps.gwt.highcharts.client.labels.*;
import org.moxieapps.gwt.highcharts.client.plotOptions.LinePlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.Marker;
import org.moxieapps.gwt.highcharts.client.plotOptions.PlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.SeriesPlotOptions;
import org.moxieapps.gwt.highcharts.showcase.client.BaseChartExample;
import org.moxieapps.gwt.highcharts.showcase.client.ExampleFactory;

import java.util.Date;

public class DualAxesClickablePointsExample extends BaseChartExample {

    public DualAxesClickablePointsExample(String title, String icon) {
        super(title, icon);
    }

    @Override
    public String getSourcePath() {
        return "line/DualAxesClickablePointsExample.java.html";
    }

    public static ExampleFactory getFactory() {
        return new ExampleFactory() {
            @Override
            public Canvas createChartCanvas() {
                return new DualAxesClickablePointsExample(getTitle(), getIcon());
            }

            @Override
            public String getTitle() {
                return "Dual Axes, Clickable Points";
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
            .setType(Series.Type.LINE)
            .setChartTitleText("Daily visits at www.highcharts.com")
            .setChartSubtitleText("Source: Google Analytics")
            .setLegend(new Legend()
                .setAlign(Legend.Align.LEFT)
                .setVerticalAlign(Legend.VerticalAlign.TOP)
                .setY(20)
                .setFloating(true)
                .setBorderWidth(0)
            )
            .setToolTip(new ToolTip()
                .setShared(true)
                .setCrosshairs(true)
            )
            .setSeriesPlotOptions(new SeriesPlotOptions()
                .setCursor(PlotOptions.Cursor.POINTER)
                .setMarker(new Marker()
                    .setLineWidth(1)
                )
                .setPointClickEventHandler(new PointClickEventHandler() {
                    public boolean onClick(PointClickEvent pointClickEvent) {
                        SC.say(pointClickEvent.getSeriesName(),
                            DateTimeFormat.getFormat("EEEE, MMMM d, yyyy").format(
                                new Date(pointClickEvent.getXAsLong())
                            ) + ": <b>" + pointClickEvent.getYAsLong() + " visits</b>");
                        return true;
                    }
                })
            );

        chart.getXAxis()
            .setType(Axis.Type.DATE_TIME)
            .setTickInterval(7 * 24 * 3600 * 1000)  // one week
            .setTickWidth(0)
            .setGridLineWidth(1)
            .setLabels(new XAxisLabels()
                .setAlign(Labels.Align.LEFT)
                .setX(3)
                .setY(-3)
            );

        // Left Y Axis
        chart.getYAxis(0)
            .setAxisTitleText(null)
            .setLabels(new YAxisLabels()
                .setAlign(Labels.Align.LEFT)
                .setX(3)
                .setY(16)
                .setFormatter(new AxisLabelsFormatter() {
                    public String format(AxisLabelsData axisLabelsData) {
                        return NumberFormat.getFormat("#,###").format(axisLabelsData.getValueAsDouble());
                    }
                })
            )
            .setShowFirstLabel(false);

        // Right Y Axis
        chart.getYAxis(1)
            .setAxisTitleText(null)
            .setLinkedTo(0)
            .setGridLineWidth(0)
            .setOpposite(true)
            .setLabels(new YAxisLabels()
                .setAlign(Labels.Align.RIGHT)
                .setX(-3)
                .setY(16)
                .setFormatter(new AxisLabelsFormatter() {
                    public String format(AxisLabelsData axisLabelsData) {
                        return NumberFormat.getFormat("#,###").format(axisLabelsData.getValueAsDouble());
                    }
                })
            )
            .setShowFirstLabel(false);

        chart.addSeries(chart.createSeries()
            .setName("All visits")
            .setPlotOptions(new LinePlotOptions()
                .setLineWidth(4)
                .setMarker(new Marker()
                    .setRadius(4)
                )
            )
            .setPoints(new Number[][]{
                {getTime("2010-09-05"), 966},
                {getTime("2010-09-06"), 2475},
                {getTime("2010-09-07"), 3336},
                {getTime("2010-09-08"), 3211},
                {getTime("2010-09-09"), 3229},
                {getTime("2010-09-10"), 2802},
                {getTime("2010-09-11"), 1168},
                {getTime("2010-09-12"), 1110},
                {getTime("2010-09-13"), 3112},
                {getTime("2010-09-14"), 3590},
                {getTime("2010-09-15"), 3529},
                {getTime("2010-09-16"), 3519},
                {getTime("2010-09-17"), 3696},
                {getTime("2010-09-18"), 1400},
                {getTime("2010-09-19"), 1302},
                {getTime("2010-09-20"), 3348},
                {getTime("2010-09-21"), 3606},
                {getTime("2010-09-22"), 3320},
                {getTime("2010-09-23"), 2677},
                {getTime("2010-09-24"), 2795},
                {getTime("2010-09-25"), 1299},
                {getTime("2010-09-26"), 1189},
                {getTime("2010-09-27"), 3189},
                {getTime("2010-09-28"), 3223},
                {getTime("2010-09-29"), 3231},
                {getTime("2010-09-30"), 3608},
                {getTime("2010-10-01"), 2945},
                {getTime("2010-10-02"), 1058},
                {getTime("2010-10-03"), 1114},
                {getTime("2010-10-04"), 2774},
                {getTime("2010-10-05"), 2679}
            })
        );

        chart.addSeries(chart.createSeries()
            .setName("New visitors")
            .setPoints(new Number[][]{
                {getTime("2010-09-05"), 433},
                {getTime("2010-09-06"), 983},
                {getTime("2010-09-07"), 1463},
                {getTime("2010-09-08"), 1316},
                {getTime("2010-09-09"), 1351},
                {getTime("2010-09-10"), 1270},
                {getTime("2010-09-11"), 604},
                {getTime("2010-09-12"), 498},
                {getTime("2010-09-13"), 1352},
                {getTime("2010-09-14"), 1626},
                {getTime("2010-09-15"), 1549},
                {getTime("2010-09-16"), 1574},
                {getTime("2010-09-17"), 1680},
                {getTime("2010-09-18"), 677},
                {getTime("2010-09-19"), 603},
                {getTime("2010-09-20"), 1472},
                {getTime("2010-09-21"), 1570},
                {getTime("2010-09-22"), 1438},
                {getTime("2010-09-23"), 1140},
                {getTime("2010-09-24"), 1256},
                {getTime("2010-09-25"), 589},
                {getTime("2010-09-26"), 533},
                {getTime("2010-09-27"), 1253},
                {getTime("2010-09-28"), 1266},
                {getTime("2010-09-29"), 1249},
                {getTime("2010-09-30"), 1684},
                {getTime("2010-10-01"), 1185},
                {getTime("2010-10-02"), 460},
                {getTime("2010-10-03"), 499},
                {getTime("2010-10-04"), 1131},
                {getTime("2010-10-05"), 1047}
            })
        );

        return chart;
    }

    private long getTime(String date) {
        return dateTimeFormat.parse(date).getTime();
    }

    static final DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("yyyy-MM-dd");

}