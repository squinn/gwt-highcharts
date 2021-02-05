package org.moxieapps.gwt.highcharts.showcase.client.misc;

import com.smartgwt.client.widgets.Canvas;
import org.moxieapps.gwt.highcharts.client.Chart;
import org.moxieapps.gwt.highcharts.client.Pane;
import org.moxieapps.gwt.highcharts.client.Series;
import org.moxieapps.gwt.highcharts.client.labels.AxisLabelsData;
import org.moxieapps.gwt.highcharts.client.labels.AxisLabelsFormatter;
import org.moxieapps.gwt.highcharts.client.labels.XAxisLabels;
import org.moxieapps.gwt.highcharts.client.plotOptions.ColumnPlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.SeriesPlotOptions;
import org.moxieapps.gwt.highcharts.showcase.client.BaseChartExample;
import org.moxieapps.gwt.highcharts.showcase.client.ExampleFactory;

public class PolarChartExample extends BaseChartExample {

    public PolarChartExample(String title, String icon) {
        super(title, icon);
    }

    @Override
    public String getSourcePath() {
        return "misc/PolarChartExample.java.html";
    }

    public static ExampleFactory getFactory() {
        return new ExampleFactory() {
            @Override
            public Canvas createChartCanvas() {
                return new PolarChartExample(getTitle(), getIcon());
            }

            @Override
            public String getTitle() {
                return "Polar Chart";
            }

            @Override
            public String getIcon() {
                return "icons/16/polar_chart.png";
            }
        };
    }

    @Override
    public Chart createChart() {

        final Chart chart = new Chart()
            .setPolar(true)
            .setChartTitleText("GWT Highcharts Polar Chart")
            .setPane(new Pane()
                .setStartAngle(0)
                .setEndAngle(360)
            )
            .setSeriesPlotOptions(new SeriesPlotOptions()
                .setPointStart(0)
                .setPointInterval(45)
            )
            .setColumnPlotOptions(new ColumnPlotOptions()
                .setPointPadding(0)
                .setGroupPadding(0)
            );

        chart.getXAxis()
            .setTickInterval(45)
            .setMin(0)
            .setMax(360)
            .setLabels(new XAxisLabels()
                .setFormatter(new AxisLabelsFormatter() {
                    public String format(AxisLabelsData axisLabelsData) {
                        return axisLabelsData.getValueAsLong() + "°";
                    }
                })
            );

        chart.getYAxis()
            .setMin(0);

        chart.addSeries(chart.createSeries()
            .setType(Series.Type.COLUMN)
            .setName("Column")
            .setPoints(new Number[]{8, 7, 6, 5, 4, 3, 2, 1})
            .setOption("pointPlacement", "between")
        );
        chart.addSeries(chart.createSeries()
            .setType(Series.Type.LINE)
            .setName("Line")
            .setPoints(new Number[]{1, 2, 3, 4, 5, 6, 7, 8})
        );
        chart.addSeries(chart.createSeries()
            .setType(Series.Type.AREA)
            .setName("Area")
            .setPoints(new Number[]{1, 8, 2, 7, 3, 6, 4, 5})
        );
        return chart;
    }
}

