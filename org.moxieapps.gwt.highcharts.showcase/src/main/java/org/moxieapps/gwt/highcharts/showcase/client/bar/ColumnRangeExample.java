package org.moxieapps.gwt.highcharts.showcase.client.bar;

import com.google.gwt.i18n.client.NumberFormat;
import com.smartgwt.client.widgets.Canvas;
import org.moxieapps.gwt.highcharts.client.Chart;
import org.moxieapps.gwt.highcharts.client.Legend;
import org.moxieapps.gwt.highcharts.client.Series;
import org.moxieapps.gwt.highcharts.client.ToolTip;
import org.moxieapps.gwt.highcharts.client.labels.DataLabels;
import org.moxieapps.gwt.highcharts.client.labels.DataLabelsData;
import org.moxieapps.gwt.highcharts.client.labels.DataLabelsFormatter;
import org.moxieapps.gwt.highcharts.client.plotOptions.ColumnRangePlotOptions;
import org.moxieapps.gwt.highcharts.showcase.client.BaseChartExample;
import org.moxieapps.gwt.highcharts.showcase.client.ExampleFactory;

public class ColumnRangeExample extends BaseChartExample {

    public ColumnRangeExample(String title, String icon) {
        super(title, icon);
    }

    @Override
    public String getSourcePath() {
        return "bar/ColumnRangeExample.java.html";
    }

    public static ExampleFactory getFactory() {
        return new ExampleFactory() {
            @Override
            public Canvas createChartCanvas() {
                return new ColumnRangeExample(getTitle(), getIcon());
            }

            @Override
            public String getTitle() {
                return "Column Ranges";
            }

            @Override
            public String getIcon() {
                return "icons/16/column_chart.png";
            }
        };
    }

    @Override
    public Chart createChart() {

        final Chart chart = new Chart()
            .setType(Series.Type.COLUMN_RANGE)
            .setChartTitleText("Temperature variation by month")
            .setChartSubtitleText("Observed in Vik i Sogn, Norway, 2009")
            .setInverted(true)
            .setLegend(new Legend()
                .setEnabled(false)
            )
            .setToolTip(new ToolTip()
                .setValueSuffix("°C")
            )
            .setColumnRangePlotOptions(new ColumnRangePlotOptions()
                .setDataLabels(new DataLabels()
                    .setEnabled(true)
                    .setY(0)
                    .setFormatter(new DataLabelsFormatter() {
                        public String format(DataLabelsData dataLabelsData) {
                            return NumberFormat.getFormat("0.0").format(dataLabelsData.getYAsDouble()) + " °C";
                        }
                    })
                )
            );

        chart.getXAxis()
            .setCategories(
                "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
            );

        chart.getYAxis()
            .setAxisTitleText("Temperature ( °C )");

        chart.addSeries(chart.createSeries()
            .setName("Temperatures")
            .setPoints(new Number[][]{
                {-9.7, 9.4},
                {-8.7, 6.5},
                {-3.5, 9.4},
                {-1.4, 19.9},
                {0.0, 22.6},
                {2.9, 29.5},
                {9.2, 30.7},
                {7.3, 26.5},
                {4.4, 18.0},
                {-3.1, 11.4},
                {-5.2, 10.4},
                {-13.5, 9.8}
            })
        );

        return chart;
    }
}
