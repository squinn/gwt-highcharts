package org.moxieapps.gwt.highcharts.showcase.client.stock;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.smartgwt.client.widgets.Canvas;
import org.moxieapps.gwt.highcharts.client.*;
import org.moxieapps.gwt.highcharts.client.plotOptions.CandlestickPlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.DataGrouping;
import org.moxieapps.gwt.highcharts.showcase.client.BaseChartExample;
import org.moxieapps.gwt.highcharts.showcase.client.ExampleFactory;

public class CandlestickSplineChartExample extends BaseChartExample {
    public CandlestickSplineChartExample(String title, String icon) {
        super(title, icon);
    }

    @Override
    public String getSourcePath() {
        return "stock/CandlestickSplineChartExample.java.html";
    }

    public static ExampleFactory getFactory() {
        return new ExampleFactory() {
            @Override
            public Canvas createChartCanvas() {
                return new CandlestickSplineChartExample(getTitle(), getIcon());
            }

            @Override
            public String getTitle() {
                return "Dual Pane: Candlestick";
            }

            @Override
            public String getIcon() {
                return "icons/16/stock_chart.png";
            }
        };
    }

    @Override
    public BaseChart createChart() {

        final StockChart chart = new StockChart();
        final AAPLStockData AAPLStockData = new AAPLStockData();

        chart.setCandlestickPlotOptions(
            new CandlestickPlotOptions()
                .setDataGrouping(
                    new DataGrouping()
                        .setUnits(
                            new DataGrouping.Unit("week", 1),
                            new DataGrouping.Unit("month", 1, 2, 3, 4, 6)
                        )
                )
        )
            .setRangeSelector(
                new RangeSelector()
                    .setSelected(1)
            )
            .setTitle(
                new ChartTitle()
                    .setText("AAPL Historical"),
                new ChartSubtitle()
                    .setText("GWT Highcharts")
            )
        ;

        chart.getYAxis(0)
            .setAxisTitleText("OHLC")
            .setHeight(150)
            .setLineWidth(2)
        ;

        chart.getYAxis(1)
            .setAxisTitleText("Volume")
            .setTop(250)
            .setHeight(50)
            .setOffset(0)
            .setLineWidth(2)
        ;

        chart.addSeries(
            chart.createSeries()
                .setType(Series.Type.CANDLESTICK)
                .setName("AAPL")
                .setPoints(AAPLStockData.getOHLC())

        )
            .addSeries(
                chart.createSeries()
                    .setType(Series.Type.SPLINE)
                    .setName("Volume")
                    .setYAxis(1)
                    .setPoints(AAPLStockData.getVolume())
            )
        ;

        return chart;
    }

    static final DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("yyyy-MM-dd");

    private long t(int year, int month, int day) {
        return dateTimeFormat.parse(year + "-" + (month + 1) + "-" + day).getTime();
    }
}

