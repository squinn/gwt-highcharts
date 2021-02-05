package org.moxieapps.gwt.highcharts.showcase.client.stock;

import com.smartgwt.client.widgets.Canvas;
import org.moxieapps.gwt.highcharts.client.*;
import org.moxieapps.gwt.highcharts.client.plotOptions.AreaPlotOptions;
import org.moxieapps.gwt.highcharts.showcase.client.BaseChartExample;
import org.moxieapps.gwt.highcharts.showcase.client.ExampleFactory;


public class AreaVolumeChartExample extends BaseChartExample {

    public AreaVolumeChartExample(String title, String icon) {
        super(title, icon);
    }

    @Override
    public String getSourcePath() {
        return "stock/AreaVolumeChartExample.java.html";
    }

    public static ExampleFactory getFactory() {
        return new ExampleFactory() {
            @Override
            public Canvas createChartCanvas() {
                return new AreaVolumeChartExample(getTitle(), getIcon());
            }

            @Override
            public String getTitle() {
                return "Dual Pane: Area Chart";
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
        final NFLXStockData NFLXStockData = new NFLXStockData();

        chart.setRangeSelector(
                new RangeSelector()
                        .setSelected(2)
        )
                .setTitle(
                        new ChartTitle()
                                .setText("NFLX Historical"),
                        new ChartSubtitle()
                                .setText("GWT Highcharts")
                )
                .setZoomType(BaseChart.ZoomType.X)
                .setAreaPlotOptions(
                        new AreaPlotOptions()
                                .setFillColor(
                                        new Color()
                                                .setLinearGradient(0.0, 0.0, 0.0, 1.0)
                                                .addColorStop(0, 69, 114, 167)
                                                .addColorStop(1, 2, 0, 0, 0)
                                )
                )
        ;

        chart.getYAxis(0)
                .setAxisTitleText("Closing Price")
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
                        .setType(Series.Type.AREA)
                        .setName("NFLX")
                        .setPoints(NFLXStockData.getClose())
        )
                .addSeries(
                        chart.createSeries()
                                .setType(Series.Type.COLUMN)
                                .setName("Volume")
                                .setYAxis(1)
                                .setPoints(NFLXStockData.getVolume())
                )
        ;

        return chart;
    }

}
