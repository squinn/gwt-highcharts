package org.moxieapps.gwt.highcharts.showcase.client.stock;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.smartgwt.client.widgets.Canvas;
import org.moxieapps.gwt.highcharts.client.*;
import org.moxieapps.gwt.highcharts.client.events.ChartLoadEvent;
import org.moxieapps.gwt.highcharts.client.events.ChartLoadEventHandler;
import org.moxieapps.gwt.highcharts.showcase.client.BaseChartExample;
import org.moxieapps.gwt.highcharts.showcase.client.ExampleFactory;

public class OHLCChartExample extends BaseChartExample {

    public OHLCChartExample(String title, String icon) {
        super(title, icon);
    }

    @Override
    public String getSourcePath() {
        return "stock/OHLCChart.java.html";
    }

    public static ExampleFactory getFactory() {
        return new ExampleFactory() {
            @Override
            public Canvas createChartCanvas() {
                return new OHLCChartExample(getTitle(), getIcon());
            }

            @Override
            public String getTitle() {
                return "OHLC Chart";
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

        chart.setType(Series.Type.OHLC)
                .setChartTitleText("AAPL Stock Price")
                .setZoomType(BaseChart.ZoomType.X_AND_Y);

        final Series series = chart.createSeries()
                .setType(Series.Type.OHLC);

        // Asynchronously loading point data to keep file size down
        chart.setLoadEventHandler(new ChartLoadEventHandler() {
            @Override
            public boolean onLoad(ChartLoadEvent chartLoadEvent) {
                loadAsyncData(series, "js/data/OHLCData.js");
                return true;
            }
        });



        chart.setRangeSelector(
                new RangeSelector()
                        .setSelected(2)
        )
                .setScrollbar(
                        new Scrollbar()
                                .setBarBorderRadius(5)
                )
                .addSeries(series)
        ;

        return chart;
    }

    static final DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("yyyy-MM-dd");

    private long t(int year, int month, int day) {
        return dateTimeFormat.parse(year + "-" + (month + 1) + "-" + day).getTime();
    }
}
