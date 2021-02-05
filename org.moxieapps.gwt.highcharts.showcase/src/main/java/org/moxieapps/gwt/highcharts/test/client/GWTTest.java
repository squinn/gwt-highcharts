package org.moxieapps.gwt.highcharts.test.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import org.moxieapps.gwt.highcharts.client.*;
import org.moxieapps.gwt.highcharts.client.Legend.Align;
import org.moxieapps.gwt.highcharts.client.events.*;
import org.moxieapps.gwt.highcharts.client.labels.*;
import org.moxieapps.gwt.highcharts.client.plotOptions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 * A simple GWT test case for embedding a Highchart (without all of the SmartGWT framework pieces in play)
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.0
 */
@SuppressWarnings({"GwtToHtmlReferences", "UnusedDeclaration"})
public class GWTTest implements EntryPoint {

    public void onModuleLoad55() {
        RootPanel.get("container").add(createPersistenceChart());
    }

    public void onModuleLoad() {
        RootPanel.get("container").add(createColumnDrilldownChart());
    }

    public Chart createColumnDrilldownChart() {
        Chart chart = new Chart()
            .setType(Series.Type.COLUMN)
            .setChartTitleText("Drilldown from Column to Pie")
            .setBorderWidth(0);

        chart.getXAxis()
            .setType(Axis.Type.CATEGORY)
            .setShowEmpty(false);

        chart.getYAxis()
            .setShowEmpty(false);

        chart.setLegend(new Legend()
            .setEnabled(true)
        );

        chart.setSeriesPlotOptions(new SeriesPlotOptions()
            .setDataLabels(new DataLabels()
                    .setEnabled(true)
            )
        );

        final Series animalSeries = chart.createSeries()
            .setType(Series.Type.PIE)
            .setPoints(
                new Point[]{
                    new Point("Cats", 4),
                    new Point("Dogs", 2),
                    new Point("Cows", 2),
                    new Point("Sheep", 2),
                    new Point("Pigs", 1)
            });

        final Series fruitSeries = chart.createSeries()
            .setType(Series.Type.PIE)
            .setPoints(new Point[]{
                    new Point("Apples", 4),
                    new Point("Oranges", 2)
            });

        final Series carSeries = chart.createSeries()
            .setType(Series.Type.PIE)
            .setPoints(new Point[]{
                    new Point("Toyota", 4),
                    new Point("Opel", 2),
                    new Point("Volkswagen", 2)
            });

        chart.setDrilldown(new Drilldown()
            .setSeries(animalSeries, fruitSeries, carSeries)
        );

        chart.addSeries(chart.createSeries()
            .setName("Things")
            .setColorByPoint(true)
            .setPoints(new Point[]{
                new Point("Animals", 5)
                    .setDrilldownSeries(animalSeries),
                new Point("Fruits", 2)
                    .setDrilldownSeries(fruitSeries),
                new Point("Cars", 3)
                    .setDrilldownSeries(carSeries)
            })
        );

        return chart;

    }

    public Chart createTreeMapChart() {
        final Chart chart = new Chart()
                .setChartTitleText("Fruit Consumption");

        //Defining points to act as parents
        final Point appleParent = new Point("Apples")
                .setColor("#EC2500");
        final Point bananaParent = new Point("Bananas")
                .setColor("#ECE100");
        final Point orangeParent = new Point("Oranges")
                .setColor("#EC9800");

        chart.addSeries(chart.createSeries()
                .setType(Series.Type.TREEMAP)
                .setPlotOptions(new TreemapPlotOptions()
                        .setAlternateStartingDirection(true)
                        .setLayoutAlgorithm(TreemapPlotOptions.LayoutAlgorithm.STRIPES)
                        .setLevels(new TreemapPlotOptions.Level()
                                .setLevel(1)
                                .setLayoutAlgorithm(TreemapPlotOptions.LayoutAlgorithm.SLICE_AND_DICE)
                                .setDataLabels(new DataLabels()
                                        .setEnabled(true)
                                        .setAlign(Labels.Align.LEFT)
                                        .setVerticalAlign(Labels.VerticalAlign.TOP)
                                        .setStyle(new Style()
                                                .setFontSize("15px")
                                                .setFontWeight("bold")
                                        )
                                )
                        )
                )
                .setPoints(new Point[]{
                        appleParent,
                        bananaParent,
                        orangeParent,
                        new Point("Anne", 5)
                                .setParent(appleParent),
                        new Point("Rick", 3)
                                .setParent(appleParent),
                        new Point("Peter", 4)
                                .setParent(appleParent),
                        new Point("Anne", 4)
                                .setParent(bananaParent),
                        new Point("Rick", 10)
                                .setParent(bananaParent),
                        new Point("Peter", 1)
                                .setParent(bananaParent),
                        new Point("Anne", 1)
                                .setParent(orangeParent),
                        new Point("Rick", 3)
                                .setParent(orangeParent),
                        new Point("Peter", 3)
                                .setParent(orangeParent),
                        new Point("Susanne", 2)
                                .setParent("Kiwi")
                                .setColor("#9EDE00")
                })
        );

        return chart;

    }
    public Chart createPersistenceChart() {
        final Chart chart = new Chart()
            .setType(Series.Type.BOXPLOT)
            .setPersistent(true)
            .setChartTitleText("Box Plot Example")
            .setLegend(
                new Legend()
                    .setEnabled(false)
            );

        chart.getXAxis()
            .setCategories("1", "2", "3", "4", "5")
            .setAxisTitleText("Experiment No.")
        ;

        final YAxis yAxis = chart.getYAxis();

        yAxis.setAxisTitleText("Observations")
            .createPlotLine()
            .setColor("red")
            .setWidth(1)
            .setLabel(
                new PlotLineLabel()
                    .setText("Theeoretical Mean: 932")
                    .setAlign(PlotLineLabel.Align.CENTER)
                    .setStyle(
                        new Style()
                            .setColor("gray")
                    )
            );

        chart.addSeries(chart.createSeries()
            .setName("Observations")
            .setPoints(new Number[][]{
                {760, 801, 848, 895, 965},
                {733, 853, 939, 980, 1080},
                {714, 762, 817, 870, 918},
                {724, 802, 806, 871, 950},
                {834, 836, 864, 882, 910}
            })
//            .setPoints(new Point[]{
//                new Point(760, 801, 848, 895, 965).setName("foo"),
//                new Point(733, 853, 939, 980, 1080).setName("foo 1"),
//                new Point(714, 762, 817, 870, 918).setName("foo 2"),
//                new Point(724, 802, 806, 871, 950).setName("foo 3"),
//                new Point(834, 836, 864, 882, 910).setName("foo4")
//            })
        )
            .addSeries(chart.createSeries()
                .setName("Outlier")
                .setType(Series.Type.SCATTER)
                .setPoints(new Point[]{
                    new Point(0, 644),
                    new Point(4, 718),
                    new Point(4, 951),
                    new Point(4, 969)
                })

            )
            .setToolTip(
                new ToolTip()
                    .setPointFormat("Observation: {point.y}")
            );

        return chart;
    }

    public Chart createEventChart() {
        Chart chart = new Chart().setType(Series.Type.LINE);
        Series s = chart.createSeries();
        s.addPoint(new Point("label 1", 10));
        s.addPoint(new Point("label 2", 20));
        s.addPoint(new Point("label 3", 30));
        SeriesPlotOptions options = new SeriesPlotOptions();
        options.setAllowPointSelect(true);
        options.setPointSelectEventHandler(new PointSelectEventHandler() {
            public boolean onSelect(PointSelectEvent pointSelectEvent) {
                Window.alert("hi");
                return true;
            }
        });
        chart.setSeriesPlotOptions(options);
        chart.addSeries(s);
        return chart;
    }

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
                        /*
                    SC.say(pointClickEvent.getSeriesName(),
                        DateTimeFormat.getFormat("EEEE, MMMM d, yyyy").format(
                            new Date(pointClickEvent.getXAsLong())
                        ) + ": <b>" + pointClickEvent.getYAsLong() + " visits</b>");
                        */
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

    public Chart splineExample() {

        final Chart chart = new Chart()
            .setType(Series.Type.SPLINE)
            .setMarginRight(10)
            .setChartTitleText("Live random data")
            .setBarPlotOptions(new BarPlotOptions()
                .setDataLabels(new DataLabels()
                    .setEnabled(true)
                )
            )
            .setLegend(new Legend()
                .setEnabled(false)
            )
            .setCredits(new Credits()
                .setEnabled(false)
            )
            .setToolTip(new ToolTip()
                .setFormatter(new ToolTipFormatter() {
                    public String format(ToolTipData toolTipData) {
                        return "<b>" + toolTipData.getSeriesName() + "</b><br/>" +
                            DateTimeFormat.getFormat("yyyy-MM-dd HH:mm:ss").format(new Date(toolTipData.getXAsLong())) + "<br/>" +
                            NumberFormat.getFormat("0.00").format(toolTipData.getYAsDouble());
                    }
                })
            );

        chart.getXAxis()
            .setType(Axis.Type.DATE_TIME)
            .setTickPixelInterval(150);

        chart.getYAxis()
            .setAxisTitleText("Value")
            .setPlotLines(
                chart.getYAxis().createPlotLine()
                    .setValue(0)
                    .setWidth(1)
                    .setColor("#808080")
            );

        final Series series = chart.createSeries();
        chart.addSeries(series
            .setName("Random data")
        );

        // Generate an array of random data
        long time = new Date().getTime();
        for (int i = -20; i < 0; i++) {
            series.addPoint(time + i * 1000, com.google.gwt.user.client.Random.nextDouble());
        }

        for (int i = 0; i <= 10; i++) {
            series.addPoint(
                time + i * 1000,
                com.google.gwt.user.client.Random.nextDouble(),
                true, true, true
            );
        }

        Timer tempTimer = new Timer() {
            @Override
            public void run() {
                series.addPoint(
                    new Date().getTime() + 10000,
                    com.google.gwt.user.client.Random.nextDouble(),
                    true, true, true
                );
            }
        };
        tempTimer.scheduleRepeating(1000);

        return chart;
    }


    public Chart gaugeExample() {

        Chart chart = new Chart()
            .setAlignTicks(false)
            .setPlotBackgroundColor((String) null)
            .setPlotShadow(false)
            .setToolTip(new ToolTip()
                .setValueSuffix(" km/h")
            )
            .setPane(new Pane()
                .setStartAngle(-150)
                .setEndAngle(150)
            )
            .setSeriesPlotOptions(new SeriesPlotOptions()
                .setDataLabels(new DataLabels()
                    .setOption("backgroundColor", new BackgroundColor()
                        .setOption("linearGradient", new LinearGradient()
                            .setOption("x1", 0)
                            .setOption("y1", 0)
                            .setOption("x2", 0)
                            .setOption("y2", 1)
                        )
                        .setOption("stops", new Object[][]{
                            {0, "#DDD"},
                            {1, "#FFF"}
                        })
                    )
                )
            );

        chart.getYAxis()
            .setMin(0)
            .setMax(200)
            .setOffset(-25)
            .setLineColor("#339")
            .setLineWidth(2)
            .setLabels(new YAxisLabels()
                .setOption("distance", -20)
                .setOption("rotation", "auto")
            );

        chart.addSeries(chart.createSeries()
            .setOption("type", "gauge")
            .setName("Speed")
            .setPoints(new Number[]{80})
        );

        return chart;
    }

    class LinearGradient extends Configurable<LinearGradient> {
    }

    class BackgroundColor extends Configurable<BackgroundColor> {
    }

    public Chart chartSelectionExample() {

        final Chart chart = new Chart()
            .setType(Series.Type.SCATTER)
            .setZoomType(BaseChart.ZoomType.X_AND_Y);

        chart.setSelectionEventHandler(new ChartSelectionEventHandler() {

            public boolean onSelection(ChartSelectionEvent e) {
                if (hasProperty(e.getNativeEvent(), "xAxis")) {
                    rangeChange(e.getXAxisMin(), e.getXAxisMax());
                }
                return true;
            }

        });

        chart.addSeries(chart.createSeries()
            .setPoints(new Number[][]{
                {161.2, 51.6}, {167.5, 59.0}, {159.5, 49.2}, {157.0, 63.0}, {155.8, 53.6},

            })
        );

        return chart;
    }

    private static native boolean hasProperty(JavaScriptObject obj, String key) /*-{
        return (typeof obj[key] != "undefined");
    }-*/;

    private void rangeChange(double min, double max) {
        String message = "Min =" + min + " Max =" + max;
        Window.alert(message);
    }

    private boolean plotSeriesOne = true;

    private StockChart removeSeriesExample() {
        final StockChart stockChart = new StockChart();

        final Series seriesOne = stockChart.createSeries();
        final Series seriesTwo = stockChart.createSeries();

        stockChart.addSeries(seriesOne);
        stockChart.addSeries(seriesTwo);

        //Remove series one after 10 seconds
        new Timer() {
            @Override
            public void run() {
                plotSeriesOne = false;
                stockChart.removeSeries(seriesOne);
            }
        }.schedule(10000);

        //Plot random values every second
        new Timer() {
            @Override
            public void run() {
                try {
                    Long valueXParam = Long.valueOf(new Date().getTime());
                    Double valueYParam = Double.valueOf((Math.random() * 100.0));

                    if (plotSeriesOne) {
                        seriesOne.addPoint(valueXParam, valueYParam);
                    }

                    valueXParam = Long.valueOf(new Date().getTime());
                    valueYParam = Double.valueOf((Math.random() * 100.0));

                    seriesTwo.addPoint(valueXParam, valueYParam);
                } catch (Throwable t) {
                    Window.alert(t.getMessage());
                }
            }
        }.scheduleRepeating(1000);

        return stockChart;
    }

    private Chart chartRendererTest() {
        final Chart chart = new Chart()
            .setType(Series.Type.SPLINE)
            .setChartTitleText("Lawn Tunnels");
        Series series = chart.createSeries()
            .setName("Moles per Yard")
            .setPoints(new Number[]{163, 203, 276, 408, 547, 729, 628});
        chart.addSeries(series);
        Scheduler.get().scheduleDeferred(new Command() {
            public void execute() {
                renderText(chart.getNativeChart(), "Hello there", 10, 10);
            }
        });
        return chart;
    }

    private static native JavaScriptObject renderText(JavaScriptObject chart, String text, int plotX, int plotY) /*-{
        return chart.renderer.text(text, plotX, plotY).add();
    }-*/;

    private StockChart dataSetTest() {
        StockChart chart = new StockChart();
        chart.getXAxis()
            .setType(Axis.Type.DATE_TIME);

        long t = new Date().getTime();
        for (int j = 0; j < 5; j++) {
            Series series = chart.createSeries();
            for (int i = 0; i < 1000; i++) {
                series.addPoint(new Point(t + i * 1000, Random.nextDouble()));
            }
            chart.addSeries(series);
        }

        return chart;
    }

    public void onModuleLoad2() {
        // See http://code.google.com/webtoolkit/doc/latest/DevGuideUiCellWidgets.html#custom-cell
        // RootPanel.get().add(new CompositeTest("Test Chart"));
        //noinspection GwtToHtmlReferences
        RootPanel.get("container").add(simpleTest1());
    }

    public void onModuleLoad5() {
        // See http://code.google.com/webtoolkit/doc/latest/DevGuideUiCellWidgets.html#custom-cell
        // RootPanel.get().add(new CompositeTest("Test Chart"));
        //noinspection GwtToHtmlReferences
        RootPanel.get("container").add(exampleToolTipChart());
    }

    public void onModuleLoad7() {
        RootPanel.get("container").add(stockChartTest1());
    }

    private StockChart stockChartTest1() {

        StockChart chart = new StockChart()
            .setOption("zoom", "xy")
            .setWidth(500)
            .setHeight(500);
        chart.getXAxis();
        chart.getYAxis(0)
            .setOption("height", 150);
        chart.getYAxis(1)
            .setOption("top", 250)
            .setOption("height", 150);
        chart.addSeries(chart.createSeries()
            .setName("data1")
            .setPoints(new Number[]{1, 5, 6, 3, 1, 5, 6, 3, 1, 5, 6, 3})
        );
        chart.addSeries(chart.createSeries()
            .setName("data2")
            .setYAxis(1)
            .setPoints(new Number[]{1, 5, 6, 3, 1, 5, 6, 3, 1, 5, 6, 3})
        );

        return chart;
    }


    double x = 0;
    double y = 0;
    Chart spineChartExample1;
    VerticalPanel vp = new VerticalPanel();
    AbsolutePanel abs1 = new AbsolutePanel();
    AbsolutePanel abs2 = new AbsolutePanel();
    Button but = new Button("Switch to Other Panel");
    Button but2 = new Button("Add Value +");
    Button but3 = new Button("Add Value -");
    Button but4 = new Button("Remove Value");

    public void onModuleLoad8() {

        abs1.setSize("700px", "400px");
        abs2.setSize("700px", "400px");

        RootPanel.get("container").add(vp);
        // RootPanel.get().add(vp);
        vp.add(but);
        vp.add(but2);
        vp.add(but3);
        vp.add(but4);
        vp.add(abs1);
        vp.add(abs2);
        spineChartExample1 = new Chart()
            .setType(Series.Type.SPLINE)
            .setLinePlotOptions(new LinePlotOptions().setZIndex(500))
            .setHeight100()
            .setWidth100()
            .setZoomType(BaseChart.ZoomType.X)
            .setChartTitleText("")
            .setLegend(
                new Legend().setAlign(Align.RIGHT).setLayout(Legend.Layout.VERTICAL)
                    .setVerticalAlign(Legend.VerticalAlign.MIDDLE));

        spineChartExample1.getYAxis().setAxisTitleText("Value");
        spineChartExample1.setPersistent(true);
        abs1.add(spineChartExample1);
        Series series = spineChartExample1.createSeries().setName("Test");
        for (int i = 0; i < 3; i++) {
            series.addPoint(x, y);
            x++;
            y++;
        }
        spineChartExample1.addSeries(series, true, false);
        for (int i = 0; i < 3; i++) {
            series.addPoint(x, y);
            x++;
            y++;
        }

        //chart.getSeries()[0].addPoint(x, y, true, false, false); disable for better debuging

        but.addClickHandler(new ClickHandler() {

            public void onClick(ClickEvent event) {
                if (abs1.getWidgetCount() > 0) {
                    abs2.add(spineChartExample1);
                } else {
                    abs1.add(spineChartExample1);
                }
            }
        });
        but2.addClickHandler(new ClickHandler() {

            public void onClick(ClickEvent event) {
                int len = spineChartExample1.getSeries()[0].getPoints().length;
                y++;
                spineChartExample1.getSeries()[0].addPoint(len, y, true, false, false);
            }
        });
        but3.addClickHandler(new ClickHandler() {

            public void onClick(ClickEvent event) {
                int len = spineChartExample1.getSeries()[0].getPoints().length;
                y--;
                spineChartExample1.getSeries()[0].addPoint(len, y, true, false, false);
            }
        });
        but4.addClickHandler(new ClickHandler() {

            public void onClick(ClickEvent event) {
                int len = spineChartExample1.getSeries()[0].getPoints().length;
                if (len > 0) {
                    spineChartExample1.getSeries()[0].removePoint(spineChartExample1.getSeries()[0].getPoints()[len - 1]);
                }
            }
        });
    }

    public StockChart markerTest() {

        final StockChart chart = new StockChart()
            .setChartTitleText("Marker Test")
            .setSeriesPlotOptions(new SeriesPlotOptions()
                .setMarker(new Marker()
                    .setEnabled(true)
                    .setSymbol(Marker.Symbol.CIRCLE)
                    .setRadius(6)
                    .setHoverState(new Marker()
                        .setEnabled(true)
                        .setRadius(12)
                    )
                )
            );

        chart.addSeries(chart.createSeries()
            .setName("Data")
            .setPoints(new Number[]{
                1005, 1436, 2063, 3057, 4618, 6444, 9822, 15468, 20434, 24126
            })
        );

        return chart;
    }


    public StockChart createTickChart() {
        StockChart stockChart = new StockChart();

        stockChart.setType(Series.Type.SPLINE);

        stockChart.setMarginTop(100);

        stockChart.setChartTitleText("Test Stock Price");

        stockChart.setLegend(new Legend().setLayout(Legend.Layout.VERTICAL)
            .setAlign(Legend.Align.LEFT)
            .setVerticalAlign(Legend.VerticalAlign.TOP).setX(20).setY(25)
            .setFloating(true).setBackgroundColor("#FFFFFF")
            .setEnabled(true));

        stockChart.setCredits(new Credits().setEnabled(false));

        stockChart.getXAxis().setType(Axis.Type.DATE_TIME)
            .setTickPixelInterval(150);

        final Series tickChartSeries = stockChart.createSeries();
        stockChart
            .addSeries(tickChartSeries.setName("Random data").setYAxis(0));

        // Use a loop to add points
        long time = new Date().getTime();
        for (int i = -25; i <= 0; i++) {
            double yAxisValue = com.google.gwt.user.client.Random.nextDouble();

            //1000*60*60*24 means one day
            Point newPoint = new Point(time + ((long) i) * 1000l * 60l * 60l * 24l, yAxisValue)
                .setName("New Point Added");
            tickChartSeries.addPoint(newPoint);
        }
        return stockChart;
    }

    public void onModuleLoad6() {

        abs1.setSize("700px", "400px");
        abs2.setSize("700px", "400px");
        RootPanel.get("container").add(vp);
        vp.add(but);
        vp.add(but2);
        vp.add(but3);
        vp.add(abs1);
        vp.add(abs2);
        spineChartExample1 = new Chart()
            .setType(Series.Type.SPLINE)
            .setLinePlotOptions(new LinePlotOptions().setZIndex(500))
            .setHeight100()
            .setWidth100()
            .setPersistent(true)
            .setZoomType(BaseChart.ZoomType.X)
            .setChartTitleText("")
            .setLegend(
                new Legend().setAlign(Align.RIGHT).setLayout(Legend.Layout.VERTICAL)
                    .setVerticalAlign(Legend.VerticalAlign.MIDDLE));

        spineChartExample1.getYAxis().setAxisTitleText("Value");
        final Series series = spineChartExample1.createSeries().setName("Test");
        for (int i = 0; i < 3; i++) {
            series.addPoint(x, y);
            x++;
            y++;
        }
        spineChartExample1.addSeries(series, true, false);
        for (int i = 0; i < 3; i++) {
            series.addPoint(x, y);
            x++;
            y++;
        }
        spineChartExample1.setSeriesPlotOptions(new SeriesPlotOptions()
            .setPointClickEventHandler(new PointClickEventHandler() {
                public boolean onClick(PointClickEvent pointClickEvent) {
                    // pointClickEvent.getPoint().remove();
                    series.removePoint(pointClickEvent.getPoint());
                    return true;
                }
            })
        );
        spineChartExample1.setClickEventHandler(new ChartClickEventHandler() {
            public boolean onClick(ChartClickEvent chartClickEvent) {
                return true;
            }
        });

        //chart.getSeries()[0].addPoint(x, y, true, false, false); disable for better debuging

        but.addClickHandler(new ClickHandler() {

            public void onClick(ClickEvent event) {
                if (abs1.getWidgetCount() > 0) {
                    // chart.setPersistent(true);
                    abs2.add(spineChartExample1);
                    // chart.setPersistent(false);
                } else {
                    // chart.setPersistent(true);
                    abs1.add(spineChartExample1);
                    // chart.setPersistent(false);
                }
            }
        });
        but2.addClickHandler(new ClickHandler() {

            public void onClick(ClickEvent event) {
                x++;
                y++;
                spineChartExample1.getSeries()[0].addPoint(x, y, true, false, false);
            }
        });
        but3.addClickHandler(new ClickHandler() {

            public void onClick(ClickEvent event) {
                x++;
                y--;
                spineChartExample1.getSeries()[0].addPoint(x, y, true, false, false);
            }
        });
        abs1.add(spineChartExample1);

    }

    private Chart seriesChangeTest() {
        final Chart chart = new Chart()
            .setType(Series.Type.SPLINE)
            .setChartTitleText("Lawn Tunnels")
            .setMarginRight(10);
        chart.getXAxis().setAxisTitleText("Hello");
        final Series series = chart.createSeries()
            .setName("Moles per Yard")
            .setPoints(new Point[]{
                new Point(163).setName("A"),
                new Point(203).setName("B"),
                new Point(276).setName("C"),
                new Point(408).setName("D"),
                new Point(547).setName("E"),
                new Point(729).setName("F"),
                new Point(628).setName("G")
            });
        chart.addSeries(series);
        chart.setClickEventHandler(new ChartClickEventHandler() {
            public boolean onClick(ChartClickEvent chartClickEvent) {
                ArrayList<Point> newPoints = new ArrayList<Point>();
                Collections.addAll(newPoints, series.getPoints());
                newPoints.add(new Point(7, 600).setName("H"));
                series.setPoints(newPoints.toArray(new Point[newPoints.size()]));
                return true;
            }
        });
        return chart;
    }

    private Chart simpleTest() {
        final Chart chart = new Chart()
            .setType(Series.Type.SPLINE)
            .setChartTitleText("Lawn Tunnels")
            .setMarginRight(10);
        chart.getXAxis().setAxisTitleText("Hello");
        Series series = chart.createSeries()
            .setName("Moles per Yard")
            .setPoints(new Number[]{163, 203, 276, 408, 547, 729, 628});
        chart.addSeries(series);
        chart.setClickEventHandler(new ChartClickEventHandler() {
            public boolean onClick(ChartClickEvent chartClickEvent) {
                chart.getXAxis().setAxisTitleText("New Title Here");
                chart.getXAxis().setAxisTitle(new AxisTitle()
                    .setText("New Title Here")
                    .setStyle(new Style()
                        .setColor("#ff0000")
                    )
                );
                return true;
            }
        });
        return chart;
    }

    private Chart simpleTest1() {
        Chart chart = new Chart()
            .setType(Series.Type.COLUMN);
        Series series = chart.createSeries()
            .setPoints(new Point[]{
                new Point(10).setOption("low", 0),
                new Point(18).setOption("low", 10),
                new Point(25).setOption("low", 18)
            });
        chart.addSeries(series);
        chart.setLegend(new Legend()
            .setLabelsFormatter(new LegendLabelsFormatter() {
                public String format(LegendLabelsData legendLabelsData) {
                    return legendLabelsData.getSeriesName() + " (click to hide)";
                }
            })
        );
        return chart;
    }

    private Chart simpleTest2() {
        Chart chart = new Chart();
        final Series series = chart.createSeries()
            .setPoints(new Number[]{3.1, 2.7, 4.3});
        chart.addSeries(series);
        Timer tempTimer = new Timer() {
            @Override
            public void run() {
                Point[] points = series.getPoints();
                for (Point point : points) {
                    point.update(point.getX(), point.getY().floatValue() + 1.0);
                }
            }
        };
        tempTimer.schedule(2000);
        return chart;
    }

    private Chart simpleTest3() {
        Chart chart = new Chart().setType(Series.Type.COLUMN);
        chart.setSeriesPlotOptions(new SeriesPlotOptions()
            .setDataLabels(new DataLabels()
                .setEnabled(true)
                .setFormatter(new DataLabelsFormatter() {
                    public String format(DataLabelsData dataLabelsData) {
                        if (dataLabelsData.hasYValue()) {
                            return dataLabelsData.getYAsDouble() + "km";
                        } else {
                            return null;
                        }
                    }
                })
            )
        );
        Series series = chart.createSeries()
            .setPoints(new Number[]{163, null, 276, 408, 547, 729, 628});
        chart.addSeries(series);
        return chart;
    }

    private Chart simpleTest4() {
        Chart chart = new Chart()
            .setSeriesPlotOptions(new SeriesPlotOptions()
                .setAllowPointSelect(true)
                .setPointSelectEventHandler(new PointSelectEventHandler() {
                    public boolean onSelect(PointSelectEvent selectEvent) {
                        Window.alert("Point selected: " + selectEvent.getYAsLong());
                        return true;
                    }
                })
            );
        Series series = chart.createSeries()
            .setPoints(new Number[]{163, 203, 276, 408, 547, 729, 628});
        chart.addSeries(series);
        return chart;
    }

    private Chart simpleTest5() {
        Chart chart = new Chart()
            .setType(Series.Type.AREA_SPLINE)
            .setChartTitleText("Lawn Tunnels")
            .setMarginRight(10);
        final Series series = chart.createSeries()
            .setName("Moles per Yard")
            .setPoints(new Number[]{163, 203, 276, 408, 547, 729, 628});
        chart.setClickEventHandler(new ChartClickEventHandler() {
            public boolean onClick(ChartClickEvent chartClickEvent) {
                Point[] points = series.getPoints();
                for (Point point : points) {
                    if (point.getY().longValue() > 400 && point.getY().longValue() < 600) {
                        point.update((Number) null);
                    } else {
                        point.update(point.getY().longValue() + 10);
                    }
                }
                return false;
            }
        });
        chart.addSeries(series);
        return chart;
    }

    private Chart simpleTest6() {
        final Chart chart = new Chart();
        chart.addSeries(chart.createSeries()
            .setPoints(new Number[]{163, 203, 276, 408, 547, 729, 628})
        );
        chart.addSeries(chart.createSeries()
            .setPoints(new Number[]{263, 303, 376, 508, 647, 829, 728})
        );
        chart.setClickEventHandler(new ChartClickEventHandler() {
            public boolean onClick(ChartClickEvent chartClickEvent) {
                chart.removeAllSeries();
                chart.addSeries(chart.createSeries()
                    .setPoints(new Number[]{263, 303, 376, 508, 647, 829, 728})
                );
                return false;
            }
        });
        return chart;
    }

    private Chart simpleTest7() {
        Chart chart = new Chart()
            .setType(Series.Type.PIE)
            .setChartTitleText("Lawn Tunnels")
            .setMarginRight(10);
        Series series = chart.createSeries()
            .setName("Moles per Yard")
            .setPoints(new Number[]{163, 203, 276, 408, 547, 729, 628});
        chart.addSeries(series);
        chart.setPiePlotOptions(new PiePlotOptions()
            .setShowInLegend(true)
            .setPointLegendItemClickEventHandler(new PointLegendItemClickEventHandler() {
                public boolean onClick(PointLegendItemClickEvent pointLegendItemClickEvent) {
                    Window.alert(pointLegendItemClickEvent.getYAsDouble() + "");
                    return false;
                }
            })
        );
        return chart;
    }

    private boolean toggle;

    public Chart simpleTest8() {

        final Chart chart = new Chart()
            .setType(Series.Type.SPLINE);

        chart.getXAxis()
            .setType(Axis.Type.DATE_TIME)
            .setTickPixelInterval(150);

        chart.getYAxis()
            .setAxisTitleText("Value");
        final PlotLine plotLine = chart.getYAxis().createPlotLine()
            .setValue(.2)
            .setWidth(2)
            .setColor("#FF0000");

        chart.setClickEventHandler(new ChartClickEventHandler() {
            public boolean onClick(ChartClickEvent chartClickEvent) {
                if (!toggle) {
                    chart.getYAxis().addPlotLines(
                        plotLine
                    );
                } else {
                    chart.getYAxis().removePlotLine(
                        plotLine
                    );
                }
                toggle = !toggle;
                return false;
            }
        });

        final Series series = chart.createSeries();
        chart.addSeries(series
            .setName("Random data")
        );

        long time = new Date().getTime();
        for (int i = -19; i <= 0; i++) {
            series.addPoint(time + i * 1000, com.google.gwt.user.client.Random.nextDouble());
        }

        return chart;
    }

    private Chart eventTest1() {
        final Chart chart = new Chart().setType(Series.Type.PIE);
        Series s = chart.createSeries();
        s.addPoint(new Point("label 1", 10));
        s.addPoint(new Point("label 2", 20));
        s.addPoint(new Point("label 3", 30));

        SeriesPlotOptions options = new SeriesPlotOptions();
        options.setAllowPointSelect(true);
        options.setPointSelectEventHandler(new PointSelectEventHandler() {
            public boolean onSelect(PointSelectEvent pointSelectEvent) {
                chart.setSize(100, 100, true);
                return true;
            }
        });
        options.setPointUnselectEventHandler(new PointUnselectEventHandler() {
            public boolean onUnselect(PointUnselectEvent pointUnselectEvent) {
                chart.setSize(200, 200, true);
                return true;
            }
        });
        s.setPlotOptions(options);
        chart.setSeriesPlotOptions(options);
        chart.addSeries(s);
        return chart;
    }

    private Chart eventTest3() {
        Chart chart = new Chart();
        SeriesPlotOptions options = new SeriesPlotOptions()
            .setAllowPointSelect(true);
        options.setPointSelectEventHandler(new PointSelectEventHandler() {
            public boolean onSelect(PointSelectEvent pointSelectEvent) {
                Window.alert("select 3");
                return true;
            }
        });
        Series series = chart.createSeries();
        series.addPoint(new Point("label 1", 10));
        series.addPoint(new Point("label 2", 20));
        series.addPoint(new Point("label 3", 30));
        series.setPlotOptions(options);
        chart.setSeriesPlotOptions(options);
        chart.addSeries(series);
        return chart;
    }


    private Chart eventTest2() {
        Chart chart = new Chart().setType(Series.Type.SPLINE);
        Series s = chart.createSeries();
        s.addPoint(new Point("label 1", 10));
        s.addPoint(new Point("label 2", 20));
        s.addPoint(new Point("label 3", 30));

        SeriesPlotOptions seriesPlotOptions = new SeriesPlotOptions();
        seriesPlotOptions.setSeriesClickEventHandler(new SeriesClickEventHandler() {
            public boolean onClick(SeriesClickEvent seriesClickEvent) {
                Window.alert("Series clicked");
                return true;
            }
        });
        seriesPlotOptions.setSeriesHideEventHandler(new SeriesHideEventHandler() {
            public boolean onHide(SeriesHideEvent seriesHideEvent) {
                Window.alert("Series hidden");
                return true;
            }
        });
        chart.setSeriesPlotOptions(seriesPlotOptions);
        chart.addSeries(s);
        return chart;
    }


    private StockChart stockChartOHLC() {

        StockChart chart = new StockChart()
            .setType(Series.Type.OHLC)
            .setWidth(500)
            .setHeight(500);

        chart.addSeries(chart.createSeries()
            .setName("data1")
            .setPoints(new Point[]{
                new Point(1, 10, 15, 8, 12),
                new Point(2, 12, 13, 6, 13),
                new Point(3, 13, 16, 11, 15)
            })
        );

        chart.addSeries(chart.createSeries()
            .setName("data2")
            .setPoints(new Number[][]{
                {1, 110, 115, 18, 112},
                {2, 112, 113, 16, 113},
                {3, 113, 116, 111, 115}
            })
        );

        return chart;
    }


    private StockChart stockChartTest2() {

        final StockChart chart = new StockChart()
            .setHeight(500);

        chart.getYAxis(0)
            .setAxisTitleText("Closing")
            .setOption("height", 200)
            .setLineWidth(2);

        chart.getYAxis(1)
            .setAxisTitleText("Volume")
            .setOption("height", 100)
            .setOption("top", 300)
            .setOffset(0)
            .setLineWidth(2);

        chart.addSeries(chart.createSeries()
            .setName("ORCL")
            .setPoints(new Number[][]{{1, 3}, {2, 4}})
        );
        chart.addSeries(chart.createSeries()
            .setName("Volume")
            .setPoints(new Number[][]{{1, 2}, {2, 2}})
            .setYAxis(1)
        );

        return chart;
    }

    private Chart test() {
        Chart chart = new Chart()
            .setType(Series.Type.SPLINE)
            .setLinePlotOptions(new LinePlotOptions().setZIndex(500))
            .setHeight100()
            .setWidth100()
            .setZoomType(BaseChart.ZoomType.X)
            .setChartTitleText("")
            .setLegend(
                new Legend().setAlign(Legend.Align.RIGHT).setLayout(Legend.Layout.VERTICAL)
                    .setVerticalAlign(Legend.VerticalAlign.MIDDLE));

        chart.getYAxis().setAxisTitleText("Value");
        chart.getXAxis().setType(Axis.Type.DATE_TIME);
        Series series = chart.createSeries().setName("test");
        series.addPoint(1, 2.d);
        series.addPoint(2, 34.3);
        series.addPoint(3, 324.2);
        chart.addSeries(series, true, false);
        Point[] points = chart.getSeries()[0].getPoints();
        for (Point point : points) {
            Window.alert("Point: " + point.getX() + ", " + point.getY());
        }

        chart.getSeries()[0].addPoint(new Date().getTime(), 333.3, true, false, false);
        Point[] points2 = chart.getSeries()[0].getPoints();

        for (Point point : points2) {
            Window.alert("Point: " + point.getX() + ", " + point.getY());
        }

        return chart;
    }

    private StockChart stockChartTest3() {

        final StockChart chart = new StockChart()
            .setChartTitle(new ChartTitle()
                .setText("USD to EUR")
            );

        Series dataSeries = chart.createSeries()
            .setName("USD to EUR")
            .setPoints(getUSDtoEURData());
        chart.addSeries(dataSeries);

        chart.addSeries(chart.createSeries()
            .setOption("type", "flags")
            .setOption("onSeries", dataSeries.getOptions().get("id"))
            .setOption("shape", "circlepin")
            .setOption("width", 16)
            .setPoints(new Point[]{
                new Point(t(2011, 2, 28), 0)
                    .setOption("title", "A")
                    .setOption("text", "EURUSD: Bulls Clear Path to 1.50 Figure"),
                new Point(t(2011, 3, 4), 0)
                    .setOption("title", "B")
                    .setOption("text", "EURUSD: Rate Decision to End Standstill")
            })
        );


        return chart;
    }

    private StockChart stockChartTest4() {
        final StockChart stockChart = new StockChart()
            .setToolTip(new ToolTip()
                .setEnabled(true)
                .setFormatter(new ToolTipFormatter() {
                    public String format(ToolTipData toolTipData) {
                        return DateTimeFormat.getFormat("yyyy-MM-dd HH:mm:ss")
                            .format(new Date(toolTipData.getXAsLong(0))) + " " +
                            toolTipData.getYAsDouble(0);
                    }
                })
            );
        final Series series = stockChart.createSeries();
        stockChart.addSeries(series.setName("Random data"));
        long time = new Date().getTime();
        for (int i = -19; i <= 0; i++) {
            series.addPoint(time + i * 1000, com.google.gwt.user.client.Random.nextDouble());
        }
        return stockChart;
    }

    private Chart setPointsExample() {
        Chart chart = new Chart();
        final Series series = chart.createSeries()
            .setName("Random Data")
            .setPoints(randomData());
        chart.addSeries(series);
        chart.setClickEventHandler(new ChartClickEventHandler() {
            public boolean onClick(ChartClickEvent chartClickEvent) {
                try {
                    // series.setPoints(randomData());
                    series.addPoint(Math.random() * 100);
                    series.addPoint((Number) null);
                    series.addPoint(Math.random() * 100);
                    series.addPoint(Math.random() * 100);
                    series.addPoint(Math.random() * 100);
                    series.addPoint((Number) null);
                    series.addPoint(Math.random() * 100);
                    series.addPoint((Number) null);
                } catch (Throwable t) {
                    Window.alert(t.getMessage());
                    t.printStackTrace();
                }
                return true;
            }
        });
        return chart;
    }

    public Chart createColumnChart() {

        final Chart chart = new Chart()
            .setType(Series.Type.COLUMN)
            .setChartTitleText("Monthly Average Rainfall")
            .setChartSubtitleText("Source: WorldClimate.com")
            .setColumnPlotOptions(new ColumnPlotOptions()
                .setPointPadding(-0.2)
                .setBorderWidth(0)
            );

        chart.getXAxis()
            .setCategories("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");

        chart.getYAxis()
            .setAxisTitleText("Rainfall (mm)")
            .setMin(0);

        chart.addSeries(chart.createSeries()
            .setName("Tokyo")
            .setPoints(new Number[]{49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4})
        );
        chart.addSeries(chart.createSeries()
            .setName("New York")
            .setPoints(new Number[]{83.6, 78.8, 98.5, 93.4, 106.0, 84.5, 105.0, 104.3, 91.2, 83.5, 106.6, 92.3})
        );
        chart.addSeries(chart.createSeries()
            .setName("London")
            .setPoints(new Number[]{48.9, 38.8, 39.3, 41.4, 47.0, 48.3, 59.0, 59.6, 52.4, 65.2, 59.3, 51.2})
        );
        chart.addSeries(chart.createSeries()
            .setName("Berlin")
            .setPoints(new Number[]{42.4, 33.2, 34.5, 39.7, 52.6, 75.5, 57.4, 60.4, 47.6, 39.1, 46.8, 51.1})
        );

        return chart;
    }

    public Chart createBarChart() {

        final Chart chart = new Chart()
            .setType(Series.Type.BAR)
            .setBarPlotOptions(new BarPlotOptions()
                .setStacking(PlotOptions.Stacking.NORMAL)
                .setDataLabels(new DataLabels()
                    .setEnabled(true)
                    .setY(-16)
                )
            );

        chart.getXAxis()
            .setCategories("Apples", "Oranges", "Pears", "Grapes", "Bananas");

        chart.getYAxis()
            .setAxisTitleText("Total fruit consumption");

        chart.addSeries(chart.createSeries()
            .setName("John")
            .setPoints(new Number[]{5, 3, 4, 7, 2})
        );
        chart.addSeries(chart.createSeries()
            .setName("Jane")
            .setPoints(new Number[]{2, 2, 3, 2, 1})
        );
        chart.addSeries(chart.createSeries()
            .setName("Joe")
            .setPoints(new Number[]{3, 4, 4, 2, 5})
        );

        return chart;
    }

    public Chart changeCategoriesExample() {

        final Chart chart = new Chart()
            .setType(Series.Type.BAR)
            .setBarPlotOptions(new BarPlotOptions()
                .setStacking(PlotOptions.Stacking.NORMAL)
                .setDataLabels(new DataLabels()
                    .setEnabled(true)
                    .setY(-16)
                )
            );

        final XAxis xAxis = chart.getXAxis()
            .setCategories("Apples", "Oranges", "Pears", "Grapes", "Bananas");

        chart.addSeries(chart.createSeries()
            .setName("John")
            .setPoints(new Number[]{5, 3, 4, 7, 2})
        );
        chart.addSeries(chart.createSeries()
            .setName("Jane")
            .setPoints(new Number[]{2, 2, 3, 2, 1})
        );
        chart.addSeries(chart.createSeries()
            .setName("Joe")
            .setPoints(new Number[]{3, 4, 4, 2, 5})
        );

        chart.setClickEventHandler(new ChartClickEventHandler() {
            public boolean onClick(ChartClickEvent chartClickEvent) {
                xAxis.setCategories("Beans", "Pumpkins", "Corn", "Peas", "Squash");
                return true;
            }
        });

        return chart;
    }

    public Chart createClosingBalancesChart() {
        final Chart chart = new Chart()
            .setType(Series.Type.BAR)
            .setChartTitle(null)
            .setMarginTop(5)
            .setMarginRight(15)
            .setMarginBottom(10)
            .setMarginLeft(45)
            .setBorderWidth(0)
            .setLegend(new Legend().setEnabled(false))
            .setCredits(new Credits().setEnabled(false))
            .setExporting(new Exporting().setEnabled(false));

        chart.getXAxis(0)
            .setCategories("")
            .setTickLength(0)
            .setLineColor("#999")
            .setLineWidth(0)
            .setLabels(new XAxisLabels().setStyle(new Style().setFontWeight("bold")));

        chart.getYAxis(0)
            .setMin(0)
            .setMax(100)
            .setTickColor("#ccc")
            .setTickWidth(0)
            .setTickLength(0)
            .setGridLineWidth(0)
            .setTickInterval(25)
            .setEndOnTick(true)
            .setAxisTitle(new AxisTitle().setText(""))
            .setLabels(new YAxisLabels().setEnabled(false));

        chart.getYAxis(1)
            .setMin(0)
            .setMax(100)
            .setTickColor("#ccc")
            .setTickWidth(0)
            .setTickLength(0)
            .setGridLineWidth(0)
            .setTickInterval(25)
            .setEndOnTick(true)
            .setAxisTitle(new AxisTitle().setText(""))
            .setLabels(new YAxisLabels().setEnabled(false));

        chart.setToolTip(new ToolTip()
            .setEnabled(true)
            .setBackgroundColor(new Color(255, 255, 255, .85))
            .setBorderWidth(0)
            .setShadow(true)
            .setStyle(new Style()
                .setFontSize("10px")
                .setOption("padding", 2)
            )
            .setFormatter(new ToolTipFormatter() {
                public String format(ToolTipData toolTipData) {
                    return toolTipData.getSeriesName() + ": <strong>" + NumberFormat.getFormat("#.00").format(toolTipData.getYAsDouble()) + "</strong>";
                }
            })
        );

        chart.setBarPlotOptions(new BarPlotOptions()
            .setStacking(PlotOptions.Stacking.NORMAL)
            .setColor("#000")
            .setShadow(false)
            .setBorderWidth(2)
            .setBorderColor("#ccc")
        );

        Series measure1 = chart.createSeries();
        measure1
            .setName("Measure")
            .setPlotOptions(new BarPlotOptions()
                .setPointWidth(10)
                .setColor(new Color("#ddd")))
            .addPoint(20);

        Series measure2 = chart.createSeries();
        measure2
            .setName("Measure2")
            .setPlotOptions(new BarPlotOptions()
                .setPointWidth(10)
                .setColor(new Color("#fff")))
            .addPoint(60);

        Series measure3 = chart.createSeries();
        measure3
            .setName("Measure3")
            .setPlotOptions(new BarPlotOptions()
                .setPointWidth(10)
                .setColor(new Color("#ddd")))
            .addPoint(20);

        Series target = chart.createSeries();
        target.setType(Series.Type.SCATTER)
            .setName("Target")
            .setPlotOptions(new ScatterPlotOptions()
                .setMarker(new Marker()
                    .setLineWidth(2)
                    .setRadius(1)
                    .setLineColor(new Color("#000"))
                    .setSymbol(Marker.Symbol.SQUARE)
                )
            )
            .addPoint(51);

        Series colorShade = chart.createSeries();
        colorShade
            .setName("Measure3")
            .addPoint(50)
            .setYAxis(1)
            .setPlotOptions(new BarPlotOptions()
                .setPointWidth(10)
                .setColor(new Color(51, 204, 51, 0.3))
                .setBorderColor("#ccc"));

        chart
            .addSeries(measure1)
            .addSeries(measure2)
            .addSeries(measure3)
            .addSeries(target)
            .addSeries(colorShade);

        chart.setWidth("350px");
        chart.setHeight("40px");

        return chart;
    }

    public Chart exampleToolTipChart() {

        final Chart chart = new Chart()
            .setType(Series.Type.LINE)
            .setMarginRight(130)
            .setMarginBottom(25)
            .setChartTitle(new ChartTitle()
                .setText("Monthly Average Temperature")
                .setX(-20)  // center
            )
            .setChartSubtitle(new ChartSubtitle()
                .setText("Source: WorldClimate.com")
                .setX(-20)
            )
            .setLegend(new Legend()
                .setLayout(Legend.Layout.VERTICAL)
                .setAlign(Legend.Align.RIGHT)
                .setVerticalAlign(Legend.VerticalAlign.TOP)
                .setX(-10)
                .setY(100)
                .setBorderWidth(0)
            )
            .setSeriesPlotOptions(new SeriesPlotOptions()
                .setSeriesLegendItemClickEventHandler(new SeriesLegendItemClickEventHandler() {
                    public boolean onClick(SeriesLegendItemClickEvent seriesLegendItemClickEvent) {
                        return false;
                    }
                })
            )
            .setToolTip(new ToolTip()
                .setShared(true)
                .setCrosshairs(true)
                .setFormatter(new ToolTipFormatter() {
                    public String format(ToolTipData toolTipData) {
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < toolTipData.getPointsLength(); i++) {
                            sb.append("<b>")
                                .append(toolTipData.getSeriesName(i))
                                .append("</b>:")
                                .append(toolTipData.getPointName(i))
                                .append(", ")
                                .append(toolTipData.getYAsDouble(i))
                                .append("°C<br/>");
                        }
                        return sb.toString();
                    }
                })
            );

        chart.getXAxis()
            .setCategories(
                "Jan", "Feb", "Mar", "Apr", "May", "Jun",
                "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
            );

        chart.getYAxis()
            .setAxisTitleText("Temperature °C");

        chart.addSeries(chart.createSeries()
            .setName("Tokyo")
            .setPoints(new Point[]{
                new Point(163).setName("A"),
                new Point(203).setName("B"),
                new Point(276).setName("C"),
                new Point(408).setName("D"),
                new Point(547).setName("E"),
                new Point(729).setName("F"),
                new Point(628).setName("G")
            })
        );
        chart.addSeries(chart.createSeries()
            .setName("New York")
            .setPoints(new Point[]{
                new Point(263).setName("A"),
                new Point(303).setName("B"),
                new Point(176).setName("C"),
                new Point(308).setName("D"),
                new Point(347).setName("E"),
                new Point(629).setName("F"),
                new Point(528).setName("G")
            })
        );

        /*
        chart.addSeries(chart.createSeries()
            .setName("Tokyo")
            .setPoints(new Number[]{
                7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6
            })
        );
        chart.addSeries(chart.createSeries()
            .setName("New York")
            .setPoints(new Number[]{
                -0.2, 0.8, 5.7, 11.3, 17.0, 22.0, 24.8, 24.1, 20.1, 14.1, 8.6, 2.5
            })
        );
        chart.addSeries(chart.createSeries()
            .setName("Berlin")
            .setPoints(new Number[]{
                -0.9, 0.6, 3.5, 8.4, 13.5, 17.0, 18.6, 17.9, 14.3, 9.0, 3.9, 1.0
            })
        );
        chart.addSeries(chart.createSeries()
            .setName("London")
            .setPoints(new Number[]{
                3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8
            })
        );
        */

        return chart;
    }

    public Chart exampleToolTipChart2() {

        final Chart chart = new Chart()
            .setType(Series.Type.LINE)
            .setMarginRight(130)
            .setMarginBottom(25)
            .setChartTitle(new ChartTitle()
                .setText("Monthly Average Temperature")
                .setX(-20)  // center
            )
            .setChartSubtitle(new ChartSubtitle()
                .setText("Source: WorldClimate.com")
                .setX(-20)
            )
            .setLegend(new Legend()
                .setLayout(Legend.Layout.VERTICAL)
                .setAlign(Legend.Align.RIGHT)
                .setVerticalAlign(Legend.VerticalAlign.TOP)
                .setX(-10)
                .setY(100)
                .setBorderWidth(0)
            )
            .setSeriesPlotOptions(new SeriesPlotOptions()
                .setOption("compare", "percent")
            )
            .setToolTip(new ToolTip()
                .setShared(true)
                .setCrosshairs(true)
                .setPointFormat("<span style=\"color:{series.color}\">{series.name}</span>: <b>{point.y}</b> ({point.change}%)<br/>")
            );

        chart.getXAxis()
            .setCategories(
                "Jan", "Feb", "Mar", "Apr", "May", "Jun",
                "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
            );

        chart.getYAxis()
            .setAxisTitleText("Temperature °C");

        chart.addSeries(chart.createSeries()
            .setName("Tokyo")
            .setPoints(new Point[]{
                new Point(163).setName("A"),
                new Point(203).setName("B"),
                new Point(276).setName("C"),
                new Point(408).setName("D"),
                new Point(547).setName("E"),
                new Point(729).setName("F"),
                new Point(628).setName("G")
            })
        );
        chart.addSeries(chart.createSeries()
            .setName("New York")
            .setPoints(new Point[]{
                new Point(263).setName("A"),
                new Point(303).setName("B"),
                new Point(176).setName("C"),
                new Point(308).setName("D"),
                new Point(347).setName("E"),
                new Point(629).setName("F"),
                new Point(528).setName("G")
            })
        );

        return chart;
    }

    private static native boolean nativeGetBoolean(JavaScriptObject point, String key) /*-{
        return point[key];
    }-*/;

    private static native void nativeCallSVGMethod(JavaScriptObject point, String svgElement, String method) /*-{
        point[svgElement][method]();
    }-*/;

    public Chart multiplePieCharts() {

        final Chart chart = new Chart()
            .setChartTitleText("Two Pies");

        final Series series1 = chart.createSeries()
            .setName("Pie 1")
            .setType(Series.Type.PIE)
            .setPoints(new Point[]{
                new Point("Jane", 13).setColor("#20cbca"),
                new Point("John", 23).setColor("##0097dc"),
                new Point("Joe", 19).setColor("#738087")
            })
            .setPlotOptions(new PiePlotOptions()
                .setCenter(100, 80)
                .setSize(100)
                .setShowInLegend(true)
                .setDataLabels(new DataLabels()
                    .setEnabled(false)
                )
            );

        final Series series2 = chart.createSeries()
            .setName("Pie 2")
            .setType(Series.Type.PIE)
            .setPoints(new Point[]{
                new Point("Jane", 13).setColor("#20cbca"),
                new Point("John", 23).setColor("##0097dc"),
                new Point("Joe", 19).setColor("#738087")
            })
            .setPlotOptions(new PiePlotOptions()
                .setCenter(280, 80)
                .setSize(100)
                .setShowInLegend(false)
                .setDataLabels(new DataLabels()
                    .setEnabled(false)
                )
            );

        chart.addSeries(series1);
        chart.addSeries(series2);

        chart.setPiePlotOptions(new PiePlotOptions()
            .setPointLegendItemClickEventHandler(new PointLegendItemClickEventHandler() {
                public boolean onClick(PointLegendItemClickEvent event) {
                    Point point = series2.getPoints()[(int) event.getXAsLong()];
                    if (nativeGetBoolean(event.getPoint().getNativePoint(), "visible")) {
                        nativeCallSVGMethod(point.getNativePoint(), "graphic", "hide");
                    } else {
                        nativeCallSVGMethod(point.getNativePoint(), "graphic", "show");
                    }
                    return true;
                }

            })
        );

        return chart;
    }


    private static Number[] randomData() {
        int length = 20;
        Number[] data = new Number[length];
        for (int i = 0; i < length; i++) {
            data[i] = Math.random() * 100;
            if (data[i].floatValue() < 30f) {
                data[i] = null;
            }
        }
        return data;
    }

    private Number[][] getUSDtoEURData() {
        return new Number[][]{
/*
            {t(2007, 11, 11), 0.6822},
            {t(2007, 11, 12), 0.6797},
            {t(2007, 11, 13), 0.6837},
            {t(2007, 11, 14), 0.693},
            {t(2007, 11, 17), 0.694},
            {t(2007, 11, 18), 0.6936},
            {t(2007, 11, 19), 0.6954},
            {t(2007, 11, 20), 0.6978},
            {t(2007, 11, 21), 0.6955},
            {t(2007, 11, 24), 0.6947},
            {t(2007, 11, 25), 0.6947},
            {t(2007, 11, 26), 0.6905},
            {t(2007, 11, 27), 0.6845},
            {t(2007, 11, 28), 0.6793},
            {t(2007, 11, 31), 0.6856},
            {t(2008, 0, 1), 0.6841},
            {t(2008, 0, 2), 0.6796},
            {t(2008, 0, 3), 0.6783},
            {t(2008, 0, 4), 0.6784},
            {t(2008, 0, 7), 0.6812},
            {t(2008, 0, 8), 0.68},
            {t(2008, 0, 9), 0.6822},
            {t(2008, 0, 10), 0.6757},
            {t(2008, 0, 11), 0.6769},
            {t(2008, 0, 14), 0.6727},
            {t(2008, 0, 15), 0.6757},
            {t(2008, 0, 16), 0.6821},
            {t(2008, 0, 17), 0.6832},
            {t(2008, 0, 18), 0.684},
            {t(2008, 0, 20), 0.6851},
            {t(2008, 0, 21), 0.6936},
            {t(2008, 0, 22), 0.6829},
            {t(2008, 0, 23), 0.6837},
            {t(2008, 0, 24), 0.677},
            {t(2008, 0, 25), 0.6812},
            {t(2008, 0, 27), 0.6807},
            {t(2008, 0, 28), 0.6763},
            {t(2008, 0, 29), 0.6772},
            {t(2008, 0, 30), 0.6745},
            {t(2008, 0, 31), 0.6728},
            {t(2008, 1, 1), 0.6756},
            {t(2008, 1, 3), 0.6758},
            {t(2008, 1, 4), 0.6745},
            {t(2008, 1, 5), 0.6833},
            {t(2008, 1, 6), 0.6844},
            {t(2008, 1, 7), 0.6908},
            {t(2008, 1, 8), 0.6894},
            {t(2008, 1, 10), 0.6886},
            {t(2008, 1, 11), 0.6898},
            {t(2008, 1, 12), 0.6859},
            {t(2008, 1, 13), 0.6871},
            {t(2008, 1, 14), 0.6831},
            {t(2008, 1, 15), 0.6812},
            {t(2008, 1, 17), 0.6816},
            {t(2008, 1, 18), 0.6826},
            {t(2008, 1, 19), 0.679},
            {t(2008, 1, 20), 0.6793},
            {t(2008, 1, 21), 0.6751},
            {t(2008, 1, 22), 0.6745},
            {t(2008, 1, 24), 0.6741},
            {t(2008, 1, 25), 0.6743},
            {t(2008, 1, 26), 0.6668},
            {t(2008, 1, 27), 0.6616},
            {t(2008, 1, 28), 0.6582},
            {t(2008, 1, 29), 0.6588},
            {t(2008, 2, 2), 0.6576},
            {t(2008, 2, 3), 0.658},
            {t(2008, 2, 4), 0.6577},
            {t(2008, 2, 5), 0.6546},
            {t(2008, 2, 6), 0.6502},
            {t(2008, 2, 7), 0.6513},
            {t(2008, 2, 8), 0.6494},
            {t(2008, 2, 10), 0.6521},
            {t(2008, 2, 11), 0.6521},
            {t(2008, 2, 12), 0.6435},
            {t(2008, 2, 13), 0.6402},
            {t(2008, 2, 14), 0.6377},
            {t(2008, 2, 16), 0.6369},
            {t(2008, 2, 17), 0.6352},
            {t(2008, 2, 18), 0.6388},
            {t(2008, 2, 19), 0.6395},
            {t(2008, 2, 20), 0.6478},
            {t(2008, 2, 21), 0.648},
            {t(2008, 2, 24), 0.648},
            {t(2008, 2, 25), 0.6406},
            {t(2008, 2, 26), 0.6321},
            {t(2008, 2, 27), 0.6325},
            {t(2008, 2, 28), 0.633},
            {t(2008, 2, 31), 0.6346},
            {t(2008, 3, 1), 0.6403},
            {t(2008, 3, 2), 0.638},
            {t(2008, 3, 3), 0.6385},
            {t(2008, 3, 4), 0.6358},
            {t(2008, 3, 7), 0.6367},
            {t(2008, 3, 8), 0.6371},
            {t(2008, 3, 9), 0.6322},
            {t(2008, 3, 10), 0.6346},
            {t(2008, 3, 11), 0.6333},
            {t(2008, 3, 14), 0.6319},
            {t(2008, 3, 15), 0.6335},
            {t(2008, 3, 16), 0.6275},
            {t(2008, 3, 17), 0.6287},
            {t(2008, 3, 18), 0.6323},
            {t(2008, 3, 21), 0.6285},
            {t(2008, 3, 22), 0.6261},
            {t(2008, 3, 23), 0.6297},
            {t(2008, 3, 24), 0.638},
            {t(2008, 3, 25), 0.6398},
            {t(2008, 3, 28), 0.6388},
            {t(2008, 3, 29), 0.642},
            {t(2008, 3, 30), 0.64},
            {t(2008, 4, 1), 0.6461},
            {t(2008, 4, 2), 0.6483},
            {t(2008, 4, 5), 0.6451},
            {t(2008, 4, 6), 0.6445},
            {t(2008, 4, 7), 0.6518},
            {t(2008, 4, 8), 0.6492},
            {t(2008, 4, 9), 0.6456},
            {t(2008, 4, 12), 0.6439},
            {t(2008, 4, 13), 0.6465},
            {t(2008, 4, 14), 0.6466},
            {t(2008, 4, 15), 0.647},
            {t(2008, 4, 16), 0.6421},
            {t(2008, 4, 19), 0.644},
            {t(2008, 4, 20), 0.6391},
            {t(2008, 4, 21), 0.6337},
            {t(2008, 4, 22), 0.6357},
            {t(2008, 4, 23), 0.6344},
            {t(2008, 4, 26), 0.6338},
            {t(2008, 4, 27), 0.6374},
            {t(2008, 4, 28), 0.6387},
            {t(2008, 4, 29), 0.6445},
            {t(2008, 4, 30), 0.643},
            {t(2008, 5, 2), 0.6435},
            {t(2008, 5, 3), 0.6472},
            {t(2008, 5, 4), 0.648},
            {t(2008, 5, 5), 0.6412},
            {t(2008, 5, 6), 0.6337},
            {t(2008, 5, 9), 0.6391},
            {t(2008, 5, 10), 0.6469},
            {t(2008, 5, 11), 0.6428},
            {t(2008, 5, 12), 0.6474},
            {t(2008, 5, 13), 0.6502},
            {t(2008, 5, 16), 0.6466},
            {t(2008, 5, 17), 0.6445},
            {t(2008, 5, 18), 0.6433},
            {t(2008, 5, 19), 0.6453},
            {t(2008, 5, 20), 0.6406},
            {t(2008, 5, 23), 0.6443},
            {t(2008, 5, 24), 0.6421},
            {t(2008, 5, 25), 0.6384},
            {t(2008, 5, 26), 0.6345},
            {t(2008, 5, 27), 0.6335},
            {t(2008, 5, 30), 0.6345},
            {t(2008, 6, 1), 0.6334},
            {t(2008, 6, 2), 0.6298},
            {t(2008, 6, 3), 0.6376},
            {t(2008, 6, 4), 0.6367},
            {t(2008, 6, 7), 0.636},
            {t(2008, 6, 8), 0.6384},
            {t(2008, 6, 9), 0.6358},
            {t(2008, 6, 10), 0.6335},
            {t(2008, 6, 11), 0.6272},
            {t(2008, 6, 14), 0.6294},
            {t(2008, 6, 15), 0.6283},
            {t(2008, 6, 16), 0.6319},
            {t(2008, 6, 17), 0.6309},
            {t(2008, 6, 18), 0.631},
            {t(2008, 6, 21), 0.6285},
            {t(2008, 6, 22), 0.6338},
            {t(2008, 6, 23), 0.6377},
            {t(2008, 6, 24), 0.6376},
            {t(2008, 6, 25), 0.6365},
            {t(2008, 6, 28), 0.6352},
            {t(2008, 6, 29), 0.6415},
            {t(2008, 6, 30), 0.6418},
            {t(2008, 6, 31), 0.6418},
            {t(2008, 7, 1), 0.6425},
            {t(2008, 7, 4), 0.6425},
            {t(2008, 7, 5), 0.6466},
            {t(2008, 7, 6), 0.6485},
            {t(2008, 7, 7), 0.6531},
            {t(2008, 7, 8), 0.6663},
            {t(2008, 7, 11), 0.6706},
            {t(2008, 7, 12), 0.6715},
            {t(2008, 7, 13), 0.6713},
            {t(2008, 7, 14), 0.6769},
            {t(2008, 7, 15), 0.6803},
            {t(2008, 7, 18), 0.6805},
            {t(2008, 7, 19), 0.676},
            {t(2008, 7, 20), 0.6779},
            {t(2008, 7, 21), 0.6717},
            {t(2008, 7, 22), 0.6764},
            {t(2008, 7, 25), 0.6791},
            {t(2008, 7, 26), 0.6828},
            {t(2008, 7, 27), 0.6782},
            {t(2008, 7, 28), 0.6801},
            {t(2008, 7, 29), 0.6816},
            {t(2008, 8, 1), 0.6858},
            {t(2008, 8, 2), 0.6903},
            {t(2008, 8, 3), 0.689},
            {t(2008, 8, 4), 0.7014},
            {t(2008, 8, 5), 0.7013},
            {t(2008, 8, 8), 0.7075},
            {t(2008, 8, 9), 0.7096},
            {t(2008, 8, 10), 0.7175},
            {t(2008, 8, 11), 0.7139},
            {t(2008, 8, 12), 0.7033},
            {t(2008, 8, 15), 0.7021},
            {t(2008, 8, 16), 0.7058},
            {t(2008, 8, 17), 0.6975},
            {t(2008, 8, 18), 0.6993},
            {t(2008, 8, 19), 0.6913},
            {t(2008, 8, 22), 0.6756},
            {t(2008, 8, 23), 0.681},
            {t(2008, 8, 24), 0.6825},
            {t(2008, 8, 25), 0.6819},
            {t(2008, 8, 26), 0.6855},
            {t(2008, 8, 29), 0.6961},
            {t(2008, 8, 30), 0.7083},
            {t(2008, 9, 1), 0.7149},
            {t(2008, 9, 2), 0.7254},
            {t(2008, 9, 3), 0.7255},
            {t(2008, 9, 6), 0.74},
            {t(2008, 9, 7), 0.737},
            {t(2008, 9, 8), 0.7348},
            {t(2008, 9, 9), 0.7374},
            {t(2008, 9, 10), 0.7465},
            {t(2008, 9, 13), 0.7323},
            {t(2008, 9, 14), 0.7374},
            {t(2008, 9, 15), 0.7443},
            {t(2008, 9, 16), 0.7414},
            {t(2008, 9, 17), 0.7456},
            {t(2008, 9, 20), 0.7497},
            {t(2008, 9, 21), 0.7688},
            {t(2008, 9, 22), 0.783},
            {t(2008, 9, 23), 0.7753},
            {t(2008, 9, 24), 0.7923},
            {t(2008, 9, 27), 0.8022},
            {t(2008, 9, 28), 0.7809},
            {t(2008, 9, 29), 0.7719},
            {t(2008, 9, 30), 0.7769},
            {t(2008, 9, 31), 0.7855},
            {t(2008, 10, 3), 0.7928},
            {t(2008, 10, 4), 0.7703},
            {t(2008, 10, 5), 0.7744},
            {t(2008, 10, 6), 0.7881},
            {t(2008, 10, 7), 0.7864},
            {t(2008, 10, 10), 0.7846},
            {t(2008, 10, 11), 0.7993},
            {t(2008, 10, 12), 0.8028},
            {t(2008, 10, 13), 0.7821},
            {t(2008, 10, 14), 0.7933},
            {t(2008, 10, 17), 0.7911},
            {t(2008, 10, 18), 0.7915},
            {t(2008, 10, 19), 0.7999},
            {t(2008, 10, 20), 0.8041},
            {t(2008, 10, 21), 0.7945},
            {t(2008, 10, 24), 0.7744},
            {t(2008, 10, 25), 0.7676},
            {t(2008, 10, 26), 0.7756},
            {t(2008, 10, 27), 0.7754},
            {t(2008, 10, 28), 0.7881},
            {t(2008, 11, 1), 0.794},
            {t(2008, 11, 2), 0.787},
            {t(2008, 11, 3), 0.7872},
            {t(2008, 11, 4), 0.783},
            {t(2008, 11, 5), 0.7868},
            {t(2008, 11, 8), 0.7744},
            {t(2008, 11, 9), 0.7736},
            {t(2008, 11, 10), 0.7685},
            {t(2008, 11, 11), 0.7504},
            {t(2008, 11, 12), 0.7481},
            {t(2008, 11, 15), 0.7302},
            {t(2008, 11, 16), 0.711},
            {t(2008, 11, 17), 0.6942},
            {t(2008, 11, 18), 0.6996},
            {t(2008, 11, 19), 0.7189},
            {t(2008, 11, 22), 0.7166},
            {t(2008, 11, 23), 0.7177},
            {t(2008, 11, 24), 0.7142},
            {t(2008, 11, 25), 0.7136},
            {t(2008, 11, 26), 0.7129},
            {t(2008, 11, 29), 0.7127},
            {t(2008, 11, 30), 0.7073},
            {t(2008, 11, 31), 0.7156},
            {t(2009, 0, 1), 0.7143},
            {t(2009, 0, 2), 0.7184},
            {t(2009, 0, 5), 0.7334},
            {t(2009, 0, 6), 0.7406},
            {t(2009, 0, 7), 0.7346},
            {t(2009, 0, 8), 0.7301},
            {t(2009, 0, 9), 0.7421},
            {t(2009, 0, 12), 0.7487},
            {t(2009, 0, 13), 0.7576},
            {t(2009, 0, 14), 0.7569},
            {t(2009, 0, 15), 0.76},
            {t(2009, 0, 16), 0.7538},
            {t(2009, 0, 19), 0.764},
            {t(2009, 0, 20), 0.7762},
            {t(2009, 0, 21), 0.7692},
            {t(2009, 0, 22), 0.7691},
            {t(2009, 0, 23), 0.7708},
            {t(2009, 0, 26), 0.7584},
            {t(2009, 0, 27), 0.7569},
            {t(2009, 0, 28), 0.7603},
            {t(2009, 0, 29), 0.7731},
            {t(2009, 0, 30), 0.7805},
            {t(2009, 1, 2), 0.7805},
            {t(2009, 1, 3), 0.7686},
            {t(2009, 1, 4), 0.778},
            {t(2009, 1, 5), 0.7819},
            {t(2009, 1, 6), 0.7729},
            {t(2009, 1, 9), 0.7717},
            {t(2009, 1, 10), 0.7746},
            {t(2009, 1, 11), 0.7773},
            {t(2009, 1, 12), 0.7762},
            {t(2009, 1, 13), 0.7775},
            {t(2009, 1, 16), 0.7815},
            {t(2009, 1, 17), 0.7948},
            {t(2009, 1, 18), 0.7959},
            {t(2009, 1, 19), 0.7901},
            {t(2009, 1, 20), 0.7797},
            {t(2009, 1, 23), 0.7893},
            {t(2009, 1, 24), 0.777},
            {t(2009, 1, 25), 0.7864},
            {t(2009, 1, 26), 0.7865},
            {t(2009, 1, 27), 0.7896},
            {t(2009, 2, 2), 0.7962},
            {t(2009, 2, 3), 0.7982},
            {t(2009, 2, 4), 0.7916},
            {t(2009, 2, 5), 0.7972},
            {t(2009, 2, 6), 0.7904},
            {t(2009, 2, 9), 0.7925},
            {t(2009, 2, 10), 0.7865},
            {t(2009, 2, 11), 0.781},
            {t(2009, 2, 12), 0.7754},
            {t(2009, 2, 13), 0.7735},
            {t(2009, 2, 16), 0.7709},
            {t(2009, 2, 17), 0.7674},
            {t(2009, 2, 18), 0.7415},
            {t(2009, 2, 19), 0.7321},
            {t(2009, 2, 20), 0.7364},
            {t(2009, 2, 23), 0.7343},
            {t(2009, 2, 24), 0.7418},
            {t(2009, 2, 25), 0.7368},
            {t(2009, 2, 26), 0.7393},
            {t(2009, 2, 27), 0.7527},
            {t(2009, 2, 30), 0.7583},
            {t(2009, 2, 31), 0.7541},
            {t(2009, 3, 1), 0.7553},
            {t(2009, 3, 2), 0.7423},
            {t(2009, 3, 3), 0.7418},
            {t(2009, 3, 6), 0.7506},
            {t(2009, 3, 7), 0.7537},
            {t(2009, 3, 8), 0.7549},
            {t(2009, 3, 9), 0.7623},
            {t(2009, 3, 10), 0.7583},
            {t(2009, 3, 13), 0.7477},
            {t(2009, 3, 14), 0.7539},
            {t(2009, 3, 15), 0.7563},
            {t(2009, 3, 16), 0.7585},
            {t(2009, 3, 17), 0.7668},
            {t(2009, 3, 20), 0.775},
            {t(2009, 3, 21), 0.773},
            {t(2009, 3, 22), 0.7688},
            {t(2009, 3, 23), 0.762},
            {t(2009, 3, 24), 0.7552},
            {t(2009, 3, 27), 0.7679},
            {t(2009, 3, 28), 0.7616},
            {t(2009, 3, 29), 0.7539},
            {t(2009, 3, 30), 0.7552},
            {t(2009, 4, 1), 0.7534},
            {t(2009, 4, 4), 0.7454},
            {t(2009, 4, 5), 0.7517},
            {t(2009, 4, 6), 0.7519},
            {t(2009, 4, 7), 0.747},
            {t(2009, 4, 8), 0.7335},
            {t(2009, 4, 11), 0.7362},
            {t(2009, 4, 12), 0.7312},
            {t(2009, 4, 13), 0.7386},
            {t(2009, 4, 14), 0.7336},
            {t(2009, 4, 15), 0.7411},
            {t(2009, 4, 18), 0.738},
            {t(2009, 4, 19), 0.733},
            {t(2009, 4, 20), 0.7256},
            {t(2009, 4, 21), 0.7174},
            {t(2009, 4, 22), 0.7145},
            {t(2009, 4, 25), 0.7139},
            {t(2009, 4, 26), 0.7147},
            {t(2009, 4, 27), 0.723},
            {t(2009, 4, 28), 0.7171},
            {t(2009, 4, 29), 0.7065},
            {t(2009, 5, 1), 0.7052},
            {t(2009, 5, 2), 0.6999},
            {t(2009, 5, 3), 0.7072},
            {t(2009, 5, 4), 0.7059},
            {t(2009, 5, 5), 0.7163},
            {t(2009, 5, 8), 0.718},
            {t(2009, 5, 9), 0.7112},
            {t(2009, 5, 10), 0.7151},
            {t(2009, 5, 11), 0.708},
            {t(2009, 5, 12), 0.7136},
            {t(2009, 5, 14), 0.7155},
            {t(2009, 5, 15), 0.7261},
            {t(2009, 5, 16), 0.7239},
            {t(2009, 5, 17), 0.716},
            {t(2009, 5, 18), 0.7193},
            {t(2009, 5, 19), 0.7145},
            {t(2009, 5, 22), 0.7221},
            {t(2009, 5, 23), 0.7108},
            {t(2009, 5, 24), 0.7173},
            {t(2009, 5, 26), 0.7114},
            {t(2009, 5, 29), 0.7093},
            {t(2009, 5, 30), 0.7124},
            {t(2009, 6, 1), 0.707},
            {t(2009, 6, 2), 0.7164},
            {t(2009, 6, 3), 0.7161},
            {t(2009, 6, 6), 0.7147},
            {t(2009, 6, 7), 0.7196},
            {t(2009, 6, 8), 0.7214},
            {t(2009, 6, 9), 0.7138},
            {t(2009, 6, 10), 0.7178},
            {t(2009, 6, 13), 0.7141},
            {t(2009, 6, 14), 0.7154},
            {t(2009, 6, 15), 0.7096},
            {t(2009, 6, 16), 0.7076},
            {t(2009, 6, 17), 0.7095},
            {t(2009, 6, 20), 0.7038},
            {t(2009, 6, 21), 0.7044},
            {t(2009, 6, 22), 0.7041},
            {t(2009, 6, 23), 0.7062},
            {t(2009, 6, 24), 0.7041},
            {t(2009, 6, 27), 0.702},
            {t(2009, 6, 28), 0.7069},
            {t(2009, 6, 29), 0.7135},
            {t(2009, 6, 30), 0.71},
            {t(2009, 6, 31), 0.7015},
            {t(2009, 7, 3), 0.6941},
            {t(2009, 7, 4), 0.6938},
            {t(2009, 7, 5), 0.694},
            {t(2009, 7, 6), 0.6959},
            {t(2009, 7, 7), 0.7048},
            {t(2009, 7, 10), 0.7078},
            {t(2009, 7, 11), 0.7067},
            {t(2009, 7, 12), 0.7034},
            {t(2009, 7, 13), 0.7006},
            {t(2009, 7, 14), 0.7041},
            {t(2009, 7, 17), 0.7089},
            {t(2009, 7, 19), 0.7019},
            {t(2009, 7, 20), 0.7016},
            {t(2009, 7, 21), 0.6983},
            {t(2009, 7, 24), 0.6997},
            {t(2009, 7, 25), 0.6999},
            {t(2009, 7, 26), 0.7024},
            {t(2009, 7, 27), 0.6958},
            {t(2009, 7, 28), 0.6994},
            {t(2009, 7, 31), 0.6975},
            {t(2009, 8, 1), 0.7039},
            {t(2009, 8, 2), 0.7008},
            {t(2009, 8, 3), 0.7015},
            {t(2009, 8, 4), 0.6996},
            {t(2009, 8, 7), 0.6976},
            {t(2009, 8, 8), 0.6896},
            {t(2009, 8, 9), 0.6874},
            {t(2009, 8, 10), 0.6858},
            {t(2009, 8, 11), 0.6866},
            {t(2009, 8, 14), 0.6832},
            {t(2009, 8, 15), 0.6817},
            {t(2009, 8, 16), 0.6799},
            {t(2009, 8, 17), 0.6788},
            {t(2009, 8, 18), 0.6796},
            {t(2009, 8, 21), 0.6811},
            {t(2009, 8, 22), 0.6753},
            {t(2009, 8, 23), 0.679},
            {t(2009, 8, 24), 0.6826},
            {t(2009, 8, 25), 0.6806},
            {t(2009, 8, 28), 0.684},
            {t(2009, 8, 29), 0.6853},
            {t(2009, 8, 30), 0.6825},
            {t(2009, 9, 1), 0.689},
            {t(2009, 9, 2), 0.6863},
            {t(2009, 9, 5), 0.6823},
            {t(2009, 9, 6), 0.6793},
            {t(2009, 9, 7), 0.6797},
            {t(2009, 9, 8), 0.677},
            {t(2009, 9, 9), 0.6789},
            {t(2009, 9, 12), 0.676},
            {t(2009, 9, 13), 0.6734},
            {t(2009, 9, 14), 0.6697},
            {t(2009, 9, 15), 0.6687},
            {t(2009, 9, 16), 0.6709},
            {t(2009, 9, 19), 0.6681},
            {t(2009, 9, 20), 0.6698},
            {t(2009, 9, 21), 0.6661},
            {t(2009, 9, 22), 0.665},
            {t(2009, 9, 23), 0.6668},
            {t(2009, 9, 26), 0.6731},
            {t(2009, 9, 27), 0.6749},
            {t(2009, 9, 28), 0.6796},
            {t(2009, 9, 29), 0.6739},
            {t(2009, 9, 30), 0.6789},
            {t(2009, 10, 2), 0.677},
            {t(2009, 10, 3), 0.6789},
            {t(2009, 10, 4), 0.6727},
            {t(2009, 10, 5), 0.6722},
            {t(2009, 10, 6), 0.6736},
            {t(2009, 10, 9), 0.6665},
            {t(2009, 10, 10), 0.6671},
            {t(2009, 10, 11), 0.6675},
            {t(2009, 10, 12), 0.6732},
            {t(2009, 10, 13), 0.6712},
            {t(2009, 10, 16), 0.6676},
            {t(2009, 10, 17), 0.6723},
            {t(2009, 10, 18), 0.6687},
            {t(2009, 10, 19), 0.6706},
            {t(2009, 10, 20), 0.6729},
            {t(2009, 10, 23), 0.6687},
            {t(2009, 10, 24), 0.6682},
            {t(2009, 10, 25), 0.6612},
            {t(2009, 10, 26), 0.6682},
            {t(2009, 10, 27), 0.6673},
            {t(2009, 10, 30), 0.6651},
            {t(2009, 11, 1), 0.6627},
            {t(2009, 11, 2), 0.6638},
            {t(2009, 11, 3), 0.6639},
            {t(2009, 11, 4), 0.6731},
            {t(2009, 11, 7), 0.674},
            {t(2009, 11, 8), 0.6807},
            {t(2009, 11, 9), 0.6786},
            {t(2009, 11, 10), 0.6789},
            {t(2009, 11, 11), 0.6846},
            {t(2009, 11, 14), 0.6823},
            {t(2009, 11, 15), 0.6878},
            {t(2009, 11, 16), 0.6886},
            {t(2009, 11, 17), 0.6972},
            {t(2009, 11, 18), 0.6975},
            {t(2009, 11, 21), 0.7001},
            {t(2009, 11, 22), 0.7017},
            {t(2009, 11, 23), 0.6977},
            {t(2009, 11, 24), 0.6956},
            {t(2009, 11, 25), 0.6955},
            {t(2009, 11, 28), 0.6958},
            {t(2009, 11, 29), 0.6974},
            {t(2009, 11, 30), 0.6974},
            {t(2009, 11, 31), 0.6979},
            {t(2010, 0, 1), 0.6976},
            {t(2010, 0, 4), 0.6932},
            {t(2010, 0, 5), 0.6962},
            {t(2010, 0, 6), 0.6944},
            {t(2010, 0, 7), 0.6985},
            {t(2010, 0, 8), 0.694},
            {t(2010, 0, 11), 0.6893},
            {t(2010, 0, 12), 0.6908},
            {t(2010, 0, 13), 0.6886},
            {t(2010, 0, 14), 0.6897},
            {t(2010, 0, 15), 0.6951},
            {t(2010, 0, 18), 0.6943},
            {t(2010, 0, 19), 0.7003},
            {t(2010, 0, 20), 0.7086},
            {t(2010, 0, 21), 0.7093},
            {t(2010, 0, 22), 0.7074},
            {t(2010, 0, 25), 0.7069},
            {t(2010, 0, 26), 0.7101},
            {t(2010, 0, 27), 0.7128},
            {t(2010, 0, 28), 0.7162},
            {t(2010, 0, 29), 0.7214},
            {t(2010, 1, 1), 0.7184},
            {t(2010, 1, 2), 0.7156},
            {t(2010, 1, 3), 0.7195},
            {t(2010, 1, 4), 0.7278},
            {t(2010, 1, 5), 0.7312},
            {t(2010, 1, 8), 0.7324},
            {t(2010, 1, 9), 0.7256},
            {t(2010, 1, 10), 0.7274},
            {t(2010, 1, 11), 0.7307},
            {t(2010, 1, 12), 0.7336},
            {t(2010, 1, 15), 0.7355},
            {t(2010, 1, 16), 0.7267},
            {t(2010, 1, 17), 0.7349},
            {t(2010, 1, 18), 0.7431},
            {t(2010, 1, 19), 0.7348},
            {t(2010, 1, 22), 0.735},
            {t(2010, 1, 23), 0.7395},
            {t(2010, 1, 24), 0.7386},
            {t(2010, 1, 25), 0.7388},
            {t(2010, 1, 26), 0.7337},
            {t(2010, 2, 1), 0.7375},
            {t(2010, 2, 2), 0.7343},
            {t(2010, 2, 3), 0.7299},
            {t(2010, 2, 4), 0.7363},
            {t(2010, 2, 5), 0.7341},
            {t(2010, 2, 8), 0.7345},
            {t(2010, 2, 9), 0.735},
            {t(2010, 2, 10), 0.7331},
            {t(2010, 2, 11), 0.7309},
            {t(2010, 2, 12), 0.7264},
            {t(2010, 2, 15), 0.7313},
            {t(2010, 2, 16), 0.7264},
            {t(2010, 2, 17), 0.7281},
            {t(2010, 2, 18), 0.7348},
            {t(2010, 2, 19), 0.7391},
            {t(2010, 2, 22), 0.7371},
            {t(2010, 2, 23), 0.7425},
            {t(2010, 2, 24), 0.7503},
            {t(2010, 2, 25), 0.7516},
            {t(2010, 2, 26), 0.7458},
            {t(2010, 2, 29), 0.7413},
            {t(2010, 2, 30), 0.7444},
            {t(2010, 2, 31), 0.7393},
            {t(2010, 3, 1), 0.736},
            {t(2010, 3, 2), 0.7406},
            {t(2010, 3, 5), 0.7424},
            {t(2010, 3, 6), 0.7473},
            {t(2010, 3, 7), 0.7501},
            {t(2010, 3, 8), 0.7477},
            {t(2010, 3, 9), 0.7408},
            {t(2010, 3, 12), 0.7361},
            {t(2010, 3, 13), 0.7345},
            {t(2010, 3, 14), 0.7324},
            {t(2010, 3, 15), 0.7373},
            {t(2010, 3, 16), 0.7406},
            {t(2010, 3, 19), 0.7416},
            {t(2010, 3, 20), 0.745},
            {t(2010, 3, 21), 0.747},
            {t(2010, 3, 22), 0.7563},
            {t(2010, 3, 23), 0.7472},
            {t(2010, 3, 26), 0.7467},
            {t(2010, 3, 27), 0.7589},
            {t(2010, 3, 28), 0.7578},
            {t(2010, 3, 29), 0.7547},
            {t(2010, 3, 30), 0.7524},
            {t(2010, 4, 3), 0.7579},
            {t(2010, 4, 4), 0.7706},
            {t(2010, 4, 5), 0.7806},
            {t(2010, 4, 6), 0.7903},
            {t(2010, 4, 7), 0.7842},
            {t(2010, 4, 10), 0.7852},
            {t(2010, 4, 11), 0.7912},
            {t(2010, 4, 12), 0.7909},
            {t(2010, 4, 13), 0.7982},
            {t(2010, 4, 14), 0.8091},
            {t(2010, 4, 17), 0.8076},
            {t(2010, 4, 18), 0.8235},
            {t(2010, 4, 19), 0.8075},
            {t(2010, 4, 20), 0.7974},
            {t(2010, 4, 21), 0.7954},
            {t(2010, 4, 24), 0.8105},
            {t(2010, 4, 25), 0.8109},
            {t(2010, 4, 26), 0.821},
            {t(2010, 4, 27), 0.8087},
            {t(2010, 4, 28), 0.8143},
            {t(2010, 4, 31), 0.8149},
            {t(2010, 5, 1), 0.8167},
            {t(2010, 5, 2), 0.8163},
            {t(2010, 5, 3), 0.8214},
            {t(2010, 5, 4), 0.8357},
            {t(2010, 5, 7), 0.8389},
            {t(2010, 5, 8), 0.8364},
            {t(2010, 5, 9), 0.8342},
            {t(2010, 5, 10), 0.8244},
            {t(2010, 5, 11), 0.8257},
            {t(2010, 5, 14), 0.819},
            {t(2010, 5, 15), 0.8121},
            {t(2010, 5, 16), 0.8131},
            {t(2010, 5, 17), 0.8074},
            {t(2010, 5, 18), 0.8072},
            {t(2010, 5, 21), 0.8116},
            {t(2010, 5, 22), 0.8148},
            {t(2010, 5, 23), 0.8129},
            {t(2010, 5, 24), 0.8107},
            {t(2010, 5, 25), 0.808},
            {t(2010, 5, 28), 0.8141},
            {t(2010, 5, 29), 0.8207},
            {t(2010, 5, 30), 0.8179},
            {t(2010, 6, 1), 0.7993},
            {t(2010, 6, 2), 0.7967},
            {t(2010, 6, 5), 0.7995},
            {t(2010, 6, 6), 0.7923},
            {t(2010, 6, 7), 0.7921},
            {t(2010, 6, 8), 0.7881},
            {t(2010, 6, 9), 0.7911},
            {t(2010, 6, 12), 0.7935},
            {t(2010, 6, 13), 0.7862},
            {t(2010, 6, 14), 0.7854},
            {t(2010, 6, 15), 0.7741},
            {t(2010, 6, 16), 0.7735},
            {t(2010, 6, 19), 0.773},
            {t(2010, 6, 20), 0.7749},
            {t(2010, 6, 21), 0.7838},
            {t(2010, 6, 22), 0.7745},
            {t(2010, 6, 23), 0.775},
            {t(2010, 6, 26), 0.7703},
            {t(2010, 6, 27), 0.7699},
            {t(2010, 6, 28), 0.7694},
            {t(2010, 6, 29), 0.7653},
            {t(2010, 6, 30), 0.7663},
            {t(2010, 7, 2), 0.7592},
            {t(2010, 7, 3), 0.7564},
            {t(2010, 7, 4), 0.7603},
            {t(2010, 7, 5), 0.7588},
            {t(2010, 7, 6), 0.753},
            {t(2010, 7, 8), 0.7567},
            {t(2010, 7, 10), 0.7602},
            {t(2010, 7, 11), 0.7785},
            {t(2010, 7, 12), 0.7787},
            {t(2010, 7, 13), 0.7843},
            {t(2010, 7, 16), 0.7806},
            {t(2010, 7, 17), 0.7771},
            {t(2010, 7, 18), 0.7816},
            {t(2010, 7, 19), 0.7808},
            {t(2010, 7, 20), 0.787},
            {t(2010, 7, 23), 0.7918},
            {t(2010, 7, 24), 0.7914},
            {t(2010, 7, 25), 0.7891},
            {t(2010, 7, 26), 0.7872},
            {t(2010, 7, 27), 0.7836},
            {t(2010, 7, 30), 0.7896},
            {t(2010, 7, 31), 0.7891},
            {t(2010, 8, 1), 0.7816},
            {t(2010, 8, 2), 0.7804},
            {t(2010, 8, 3), 0.7755},
            {t(2010, 8, 6), 0.7802},
            {t(2010, 8, 7), 0.788},
            {t(2010, 8, 8), 0.7859},
            {t(2010, 8, 9), 0.7888},
            {t(2010, 8, 10), 0.7892},
            {t(2010, 8, 13), 0.7774},
            {t(2010, 8, 14), 0.7695},
            {t(2010, 8, 15), 0.7686},
            {t(2010, 8, 16), 0.7654},
            {t(2010, 8, 17), 0.7662},
            {t(2010, 8, 20), 0.7656},
            {t(2010, 8, 21), 0.7528},
            {t(2010, 8, 22), 0.7467},
            {t(2010, 8, 23), 0.7523},
            {t(2010, 8, 24), 0.7415},
            {t(2010, 8, 27), 0.7447},
            {t(2010, 8, 28), 0.7368},
            {t(2010, 8, 29), 0.734},
            {t(2010, 8, 30), 0.7337},
            {t(2010, 9, 1), 0.7253},
            {t(2010, 9, 4), 0.7328},
            {t(2010, 9, 5), 0.7219},
            {t(2010, 9, 6), 0.7186},
            {t(2010, 9, 7), 0.7182},
            {t(2010, 9, 8), 0.7173},
            {t(2010, 9, 11), 0.7212},
            {t(2010, 9, 12), 0.7184},
            {t(2010, 9, 13), 0.7152},
            {t(2010, 9, 14), 0.7131},
            {t(2010, 9, 15), 0.7155},
            {t(2010, 9, 18), 0.7162},
            {t(2010, 9, 19), 0.73},
            {t(2010, 9, 20), 0.7156},
            {t(2010, 9, 21), 0.7189},
            {t(2010, 9, 22), 0.7167},
            {t(2010, 9, 25), 0.7183},
            {t(2010, 9, 26), 0.7222},
            {t(2010, 9, 27), 0.725},
            {t(2010, 9, 28), 0.7172},
            {t(2010, 9, 29), 0.7171},
            {t(2010, 10, 1), 0.719},
            {t(2010, 10, 2), 0.7127},
            {t(2010, 10, 3), 0.7079},
            {t(2010, 10, 4), 0.7029},
            {t(2010, 10, 5), 0.7128},
            {t(2010, 10, 8), 0.7213},
            {t(2010, 10, 9), 0.7263},
            {t(2010, 10, 10), 0.726},
            {t(2010, 10, 11), 0.7342},
            {t(2010, 10, 12), 0.7305},
            {t(2010, 10, 15), 0.7369},
            {t(2010, 10, 16), 0.7411},
            {t(2010, 10, 17), 0.7379},
            {t(2010, 10, 18), 0.7323},
            {t(2010, 10, 19), 0.7315},
            {t(2010, 10, 22), 0.7354},
            {t(2010, 10, 23), 0.747},
            {t(2010, 10, 24), 0.7487},
            {t(2010, 10, 25), 0.7496},
            {t(2010, 10, 26), 0.7553},
            {t(2010, 10, 29), 0.7634},
            {t(2010, 10, 30), 0.7695},
            {t(2010, 11, 1), 0.762},
            {t(2010, 11, 2), 0.7569},
            {t(2010, 11, 3), 0.7455},
            {t(2010, 11, 6), 0.7526},
            {t(2010, 11, 7), 0.7552},
            {t(2010, 11, 8), 0.7549},
            {t(2010, 11, 9), 0.7553},
            {t(2010, 11, 10), 0.7561},
            {t(2010, 11, 13), 0.7466},
            {t(2010, 11, 14), 0.7487},
            {t(2010, 11, 15), 0.7561},
            {t(2010, 11, 16), 0.7553},
            {t(2010, 11, 17), 0.7584},
            {t(2010, 11, 20), 0.7624},
            {t(2010, 11, 21), 0.7639},
            {t(2010, 11, 22), 0.7626},
            {t(2010, 11, 23), 0.7621},
            {t(2010, 11, 24), 0.7622},
            {t(2010, 11, 27), 0.7583},
            {t(2010, 11, 28), 0.7642},
            {t(2010, 11, 29), 0.7562},
            {t(2010, 11, 30), 0.7519},
            {t(2010, 11, 31), 0.7473},*/
            {t(2011, 0, 3), 0.7488},
            {t(2011, 0, 4), 0.7509},
            {t(2011, 0, 5), 0.7602},
            {t(2011, 0, 6), 0.7705},
            {t(2011, 0, 7), 0.7748},
            {t(2011, 0, 10), 0.7714},
            {t(2011, 0, 11), 0.7736},
            {t(2011, 0, 12), 0.7618},
            {t(2011, 0, 13), 0.7491},
            {t(2011, 0, 14), 0.747},
            {t(2011, 0, 17), 0.753},
            {t(2011, 0, 18), 0.7475},
            {t(2011, 0, 19), 0.7434},
            {t(2011, 0, 20), 0.7427},
            {t(2011, 0, 21), 0.7343},
            {t(2011, 0, 24), 0.733},
            {t(2011, 0, 25), 0.7308},
            {t(2011, 0, 26), 0.7294},
            {t(2011, 0, 27), 0.7288},
            {t(2011, 0, 28), 0.7349},
            {t(2011, 0, 31), 0.7292},
            {t(2011, 1, 1), 0.7232},
            {t(2011, 1, 2), 0.7239},
            {t(2011, 1, 3), 0.7341},
            {t(2011, 1, 4), 0.7364},
            {t(2011, 1, 7), 0.7357},
            {t(2011, 1, 8), 0.734},
            {t(2011, 1, 9), 0.7289},
            {t(2011, 1, 10), 0.7351},
            {t(2011, 1, 11), 0.7377},
            {t(2011, 1, 14), 0.7419},
            {t(2011, 1, 15), 0.7409},
            {t(2011, 1, 16), 0.7367},
            {t(2011, 1, 17), 0.7341},
            {t(2011, 1, 18), 0.7304},
            {t(2011, 1, 21), 0.731},
            {t(2011, 1, 22), 0.7315},
            {t(2011, 1, 23), 0.7268},
            {t(2011, 1, 24), 0.7236},
            {t(2011, 1, 25), 0.7271},
            {t(2011, 1, 28), 0.7235},
            {t(2011, 2, 1), 0.7263},
            {t(2011, 2, 2), 0.7213},
            {t(2011, 2, 3), 0.7165},
            {t(2011, 2, 4), 0.715},
            {t(2011, 2, 7), 0.7162},
            {t(2011, 2, 8), 0.7198},
            {t(2011, 2, 9), 0.7192},
            {t(2011, 2, 10), 0.7246},
            {t(2011, 2, 11), 0.7194},
            {t(2011, 2, 14), 0.7148},
            {t(2011, 2, 15), 0.715},
            {t(2011, 2, 16), 0.7203},
            {t(2011, 2, 17), 0.7128},
            {t(2011, 2, 18), 0.7052},
            {t(2011, 2, 21), 0.7036},
            {t(2011, 2, 22), 0.7058},
            {t(2011, 2, 23), 0.7091},
            {t(2011, 2, 24), 0.7058},
            {t(2011, 2, 25), 0.71},
            {t(2011, 2, 28), 0.7107},
            {t(2011, 2, 29), 0.7082},
            {t(2011, 2, 30), 0.7079},
            {t(2011, 2, 31), 0.7064},
            {t(2011, 3, 1), 0.7026},
            {t(2011, 3, 4), 0.704},
            {t(2011, 3, 5), 0.7026},
            {t(2011, 3, 6), 0.6982},
            {t(2011, 3, 7), 0.6996},
            {t(2011, 3, 8), 0.6907},
            {t(2011, 3, 11), 0.6934},
            {t(2011, 3, 12), 0.6906},
            {t(2011, 3, 13), 0.692},
            {t(2011, 3, 14), 0.6896},
            {t(2011, 3, 15), 0.6931},
            {t(2011, 3, 18), 0.7024},
            {t(2011, 3, 19), 0.6961},
            {t(2011, 3, 20), 0.6888},
            {t(2011, 3, 21), 0.6869},
            {t(2011, 3, 22), 0.6869},
            {t(2011, 3, 25), 0.6874},
            {t(2011, 3, 26), 0.6801},
            {t(2011, 3, 27), 0.6763},
            {t(2011, 3, 28), 0.6738},
            {t(2011, 3, 29), 0.6753},
            {t(2011, 4, 2), 0.6759},
            {t(2011, 4, 3), 0.674},
            {t(2011, 4, 4), 0.6744},
            {t(2011, 4, 5), 0.687},
            {t(2011, 4, 6), 0.6983},
            {t(2011, 4, 8), 0.696},
            {t(2011, 4, 10), 0.6945}
        };
    }

    static final DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("yyyy-MM-dd");

    private long t(int year, int month, int day) {
        return dateTimeFormat.parse(year + "-" + (month + 1) + "-" + day).getTime();
    }
}
