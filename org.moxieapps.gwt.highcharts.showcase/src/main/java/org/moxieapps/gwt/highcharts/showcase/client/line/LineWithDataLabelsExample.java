package org.moxieapps.gwt.highcharts.showcase.client.line;

import com.smartgwt.client.widgets.Canvas;
import org.moxieapps.gwt.highcharts.client.*;
import org.moxieapps.gwt.highcharts.client.labels.DataLabels;
import org.moxieapps.gwt.highcharts.client.plotOptions.LinePlotOptions;
import org.moxieapps.gwt.highcharts.showcase.client.BaseChartExample;
import org.moxieapps.gwt.highcharts.showcase.client.ExampleFactory;

public class LineWithDataLabelsExample extends BaseChartExample {

    public LineWithDataLabelsExample(String title, String icon) {
        super(title, icon);
    }

    @Override
    public String getSourcePath() {
        return "line/LineWithDataLabelsExample.java.html";
    }

    public static ExampleFactory getFactory() {
        return new ExampleFactory() {
            @Override
            public Canvas createChartCanvas() {
                return new LineWithDataLabelsExample(getTitle(), getIcon());
            }

            @Override
            public String getTitle() {
                return "Line Chart With Data Labels";
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
            .setChartTitle(new ChartTitle()
                .setText("Monthly Average Temperature")
            )
            .setChartSubtitle(new ChartSubtitle()
                .setText("Source: WorldClimate.com")
            )
            .setToolTip(new ToolTip()
                .setEnabled(false)
            );

        chart.getXAxis()
            .setCategories(
                "Jan", "Feb", "Mar", "Apr", "May", "Jun",
                "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
            );

        chart.getYAxis()
            .setAxisTitleText("Temperature °C");

        chart.setLinePlotOptions(new LinePlotOptions()
            .setEnableMouseTracking(true)
            .setDataLabels(new DataLabels()
                .setEnabled(true)
            )
        );

        chart.addSeries(chart.createSeries()
            .setName("Tokyo")
            .setPoints(new Number[] {
                7.0, 6.9, 9.5, 14.5, 18.4, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6
            })
        );
        chart.addSeries(chart.createSeries()
            .setName("London")
            .setPoints(new Number[] {
                3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8
            })
        );

        return chart;
    }
}
