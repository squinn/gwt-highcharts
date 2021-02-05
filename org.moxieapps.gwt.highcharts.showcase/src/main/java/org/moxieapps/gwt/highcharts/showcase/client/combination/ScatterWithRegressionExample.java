package org.moxieapps.gwt.highcharts.showcase.client.combination;

import com.smartgwt.client.widgets.Canvas;
import org.moxieapps.gwt.highcharts.client.Chart;
import org.moxieapps.gwt.highcharts.client.Series;
import org.moxieapps.gwt.highcharts.client.plotOptions.LinePlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.Marker;
import org.moxieapps.gwt.highcharts.showcase.client.BaseChartExample;
import org.moxieapps.gwt.highcharts.showcase.client.ExampleFactory;

public class ScatterWithRegressionExample  extends BaseChartExample {

    public ScatterWithRegressionExample(String title, String icon) {
        super(title, icon);
    }

    @Override
    public String getSourcePath() {
        return "combination/ScatterWithRegressionExample.java.html";
    }

    public static ExampleFactory getFactory() {
        return new ExampleFactory() {
            @Override
            public Canvas createChartCanvas() {
                return new ScatterWithRegressionExample(getTitle(), getIcon());
            }

            @Override
            public String getTitle() {
                return "Scatter with Regression Line";
            }

            @Override
            public String getIcon() {
                return "icons/16/combination_chart.png";
            }
        };
    }

    @Override
    public Chart createChart() {

        final Chart chart = new Chart()
            .setChartTitleText("Scatter plot with regression line");

        chart.getXAxis()
            .setMin(-0.5)
            .setMax(5.5);

        chart.getYAxis()
            .setMin(0);

        chart.addSeries(chart.createSeries()
            .setName("Regression Line")
            .setType(Series.Type.LINE)
            .setPlotOptions(new LinePlotOptions()
                .setMarker(new Marker()
                    .setEnabled(false)
                )
                .setHoverStateLineWidth(0)
                .setEnableMouseTracking(false)
            )
            .setPoints(new Number[][]{
                {0, 1.11}, {5, 4.51}
            })
        );

        chart.addSeries(chart.createSeries()
            .setName("Observations")
            .setType(Series.Type.SCATTER)
            .setPoints(new Number[] {
                1, 1.5, 2.8, 3.5, 3.9, 4.2
            })
        );

        return chart;
    }
}
