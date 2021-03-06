package org.moxieapps.gwt.highcharts.showcase.client.stock;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.smartgwt.client.widgets.Canvas;
import org.moxieapps.gwt.highcharts.client.*;
import org.moxieapps.gwt.highcharts.client.plotOptions.FlagPlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.SplinePlotOptions;
import org.moxieapps.gwt.highcharts.showcase.client.BaseChartExample;
import org.moxieapps.gwt.highcharts.showcase.client.ExampleFactory;


public class SplineScrollbarChartExample extends BaseChartExample {

    public SplineScrollbarChartExample(String title, String icon) {
        super(title, icon);
    }

    @Override
    public String getSourcePath() {
        return "stock/SplineScrollbarChartExample.java.html";
    }

    public static ExampleFactory getFactory() {
        return new ExampleFactory() {
            @Override
            public Canvas createChartCanvas() {
                return new SplineScrollbarChartExample(getTitle(), getIcon());
            }

            @Override
            public String getTitle() {
                return "Spline with stylized scrollbar";
            }

            @Override
            public String getIcon() {
                return "icons/16/stock_chart.png";
            }
        };
    }

    public static Number[][] getFutureHipsterData() {
        return new Number[][] {
                {t(2013, 6, 1), 94},
                {t(2013, 7, 1), 97},
                {t(2013, 8, 1), 98},
                {t(2013, 9, 1), 103},
                {t(2013, 10, 1), 100},
                {t(2013, 11, 1), 103},
                {t(2014, 0, 1), 102},
                {t(2014, 1, 1), 104},
                {t(2014, 2, 1), 107},
                {t(2014, 3, 1), 110},
                {t(2014, 4, 1), 106},
                {t(2014, 5, 1), 107},
                {t(2014, 6, 1), 109},
        };
    }

    public static Number[][] getHipsterData() {
        return new Number[][] {
            {t(2004, 0, 1), 8},
            {t(2004, 1, 1), 7},
            {t(2004, 2, 1), 7},
            {t(2004, 3, 1), 8},
            {t(2004, 4, 1), 8},
            {t(2004, 5, 1), 8},
            {t(2004, 6, 1), 8},
            {t(2004, 7, 1), 8},
            {t(2004, 8, 1), 7},
            {t(2004, 9, 1), 8},
            {t(2004, 10, 1), 8},
            {t(2004, 11, 1), 8},
            {t(2005, 0, 1), 8},
            {t(2005, 1, 1), 8},
            {t(2005, 2, 1), 8},
            {t(2005, 3, 1), 8},
            {t(2005, 4, 1), 8},
            {t(2005, 5, 1), 9},
            {t(2005, 6, 1), 10},
            {t(2005, 7, 1), 9},
            {t(2005, 8, 1), 8},
            {t(2005, 9, 1), 8},
            {t(2005, 10, 1), 9},
            {t(2005, 11, 1), 10},
            {t(2006, 0, 1), 9},
            {t(2006, 1, 1), 10},
            {t(2006, 2, 1), 8},
            {t(2006, 3, 1), 8},
            {t(2006, 4, 1), 8},
            {t(2006, 5, 1), 8},
            {t(2006, 6, 1), 9},
            {t(2006, 7, 1), 9},
            {t(2006, 8, 1), 8},
            {t(2006, 9, 1), 8},
            {t(2006, 10, 1), 8},
            {t(2006, 11, 1), 9},
            {t(2007, 0, 1), 8},
            {t(2007, 1, 1), 9},
            {t(2007, 2, 1), 9},
            {t(2007, 3, 1), 9},
            {t(2007, 4, 1), 9},
            {t(2007, 5, 1), 9},
            {t(2007, 6, 1), 9},
            {t(2007, 7, 1), 10},
            {t(2007, 8, 1), 10},
            {t(2007, 9, 1), 10},
            {t(2007, 10, 1), 10},
            {t(2007, 11, 1), 10},
            {t(2008, 0, 1), 9},
            {t(2008, 1, 1), 10},
            {t(2008, 2, 1), 10},
            {t(2008, 3, 1), 10},
            {t(2008, 4, 1), 11},
            {t(2008, 5, 1), 11},
            {t(2008, 6, 1), 12},
            {t(2008, 7, 1), 14},
            {t(2008, 8, 1), 13},
            {t(2008, 9, 1), 13},
            {t(2008, 10, 1), 13},
            {t(2008, 11, 1), 14},
            {t(2009, 0, 1), 13},
            {t(2009, 1, 1), 13},
            {t(2009, 2, 1), 14},
            {t(2009, 3, 1), 20},
            {t(2009, 4, 1), 24},
            {t(2009, 5, 1), 21},
            {t(2009, 6, 1), 22},
            {t(2009, 7, 1), 22},
            {t(2009, 8, 1), 20},
            {t(2009, 9, 1), 21},
            {t(2009, 10, 1), 20},
            {t(2009, 11, 1), 22},
            {t(2010, 0, 1), 23},
            {t(2010, 1, 1), 25},
            {t(2010, 2, 1), 25},
            {t(2010, 3, 1), 30},
            {t(2010, 4, 1), 29},
            {t(2010, 5, 1), 28},
            {t(2010, 6, 1), 30},
            {t(2010, 7, 1), 34},
            {t(2010, 8, 1), 44},
            {t(2010, 9, 1), 46},
            {t(2010, 10, 1), 46},
            {t(2010, 11, 1), 46},
            {t(2011, 0, 1), 47},
            {t(2011, 1, 1), 52},
            {t(2011, 2, 1), 55},
            {t(2011, 3, 1), 57},
            {t(2011, 4, 1), 56},
            {t(2011, 5, 1), 56},
            {t(2011, 6, 1), 62},
            {t(2011, 7, 1), 66},
            {t(2011, 8, 1), 64},
            {t(2011, 9, 1), 77},
            {t(2011, 10, 1), 73},
            {t(2011, 11, 1), 76},
            {t(2012, 0, 1), 79},
            {t(2012, 1, 1), 79},
            {t(2012, 2, 1), 81},
            {t(2012, 3, 1), 89},
            {t(2012, 4, 1), 86},
            {t(2012, 5, 1), 91},
            {t(2012, 6, 1), 94},
            {t(2012, 7, 1), 91},
            {t(2012, 8, 1), 93},
            {t(2012, 9, 1), 97},
            {t(2012, 10, 1), 93},
            {t(2012, 11, 1), 96},
            {t(2013, 0, 1), 94},
            {t(2013, 1, 1), 95},
            {t(2013, 2, 1), 98},
            {t(2013, 3, 1), 99},
            {t(2013, 4, 1), 100},
            {t(2013, 5, 1), 95}
        };
    }

    @Override
    public BaseChart createChart() {

        final StockChart chart = new StockChart();

        final Series presentHipsterSeries = chart.createSeries()
            .setType(Series.Type.SPLINE)
            .setName("Interest Over Time")
            .setPoints(getHipsterData());
        chart.setLegend(
                    new Legend()
                        .setEnabled(true)
        )
            .setToolTip(
                    new ToolTip()
                        .setCrosshairs(true, true)
            )
            .setShadow(true)
            .setZoomType(BaseChart.ZoomType.X)
            .setScrollbar(
                    new Scrollbar()
                            .setBarBackgroundColor("gray")
                            .setBarBorderRadius(7)
                            .setBarBorderWidth(0)
                            .setButtonBackgroundColor("gray")
                            .setButtonBorderWidth(0)
                            .setButtonBorderRadius(7)
                            .setTrackBackgroundColor("none")
                            .setTrackBorderWidth(1)
                            .setTrackBorderRadius(8)
                            .setTrackBorderColor("#CCC")
            )
            .setTitle(
                    new ChartTitle()
                            .setText("Web search interest: hipster"),
                    new ChartSubtitle()
                            .setText("GWT Highcharts")
            )
            .addSeries(
                presentHipsterSeries
            )
            .addSeries(
                    chart.createSeries()
                            .setType(Series.Type.SPLINE)
                            .setName("Future interest")
                            .setPoints(getFutureHipsterData())
                            .setPlotOptions(
                                    new SplinePlotOptions()
                                            .setDashStyle(PlotLine.DashStyle.DASH)
                            )
            )
            .addSeries(
                    chart.createSeries()
                        .setType(Series.Type.FLAGS)
                            .addPoint(t(2010, 9, 1), "G", "Telegraph.co.uk: Superman, the 20-year-old hoodie-wearing hipster")
                            .addPoint(t(2011, 9, 1), "F", "National Post; The world according to Primus: 'One person's hipster is another's cheeseball'")
                            .addPoint(t(2012, 0, 1), "E", "Zee News: Social logic behind hipster trend revealed")
                            .addPoint(t(2012, 3, 1), "D", "Seattle Post Intelligencer: Is Seattle the hipster capital of the nation?")
                            .addPoint(t(2012, 6, 1), "C", "Getty Images: Hipster Olympics 2012")
                            .addPoint(t(2013, 3, 1), "B", "CBC.ca: Brooklyn Church promotes Jesus as 'The Original Hipster'")
                            .addPoint(t(2013, 4, 1), "A", "NEWS.com.au: Are you a hipster? Take our test")
                    .setPlotOptions(
                            new FlagPlotOptions()
                                    .setOnSeries(presentHipsterSeries.getId())
                                    .setLinkedTo(presentHipsterSeries.getId())
                    )
            )
            .getYAxis()
                .setAxisTitleText("The number 100 represents peak interest")
        ;

        return chart;
    }

    static final DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("yyyy-MM-dd");

    private static long t(int year, int month, int day) {
        return dateTimeFormat.parse(year + "-" + (month + 1) + "-" + day).getTime();
    }
}
