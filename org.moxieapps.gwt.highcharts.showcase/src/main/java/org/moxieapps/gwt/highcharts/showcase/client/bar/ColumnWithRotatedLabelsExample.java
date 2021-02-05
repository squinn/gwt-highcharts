package org.moxieapps.gwt.highcharts.showcase.client.bar;

import com.google.gwt.i18n.client.NumberFormat;
import com.smartgwt.client.widgets.Canvas;
import org.moxieapps.gwt.highcharts.client.*;
import org.moxieapps.gwt.highcharts.client.labels.*;
import org.moxieapps.gwt.highcharts.client.plotOptions.ColumnPlotOptions;
import org.moxieapps.gwt.highcharts.showcase.client.BaseChartExample;
import org.moxieapps.gwt.highcharts.showcase.client.ExampleFactory;

public class ColumnWithRotatedLabelsExample extends BaseChartExample {

    public ColumnWithRotatedLabelsExample(String title, String icon) {
        super(title, icon);
    }

    @Override
    public String getSourcePath() {
        return "bar/ColumnWithRotatedLabelsExample.java.html";
    }

    public static ExampleFactory getFactory() {
        return new ExampleFactory() {
            @Override
            public Canvas createChartCanvas() {
                return new ColumnWithRotatedLabelsExample(getTitle(), getIcon());
            }

            @Override
            public String getTitle() {
                return "Column with Rotated Labels";
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
            .setType(Series.Type.COLUMN)
            .setMargin(50, 50, 100, 80)
            .setChartTitleText("World's largest cities per 2008")
            .setLegend(new Legend()
                .setEnabled(false)
            )
            .setToolTip(new ToolTip()
                .setFormatter(new ToolTipFormatter() {
                    public String format(ToolTipData toolTipData) {
                        return "<b>" + toolTipData.getXAsString() + "</b><br/>" +
                            "Population in 2008: " +
                            NumberFormat.getFormat("0.0").format(toolTipData.getYAsDouble()) +
                            " millions";
                    }
                })
            );

        chart.getXAxis()
            .setCategories(
                "Tokyo",
                "Jakarta",
                "New York",
                "Seoul",
                "Manila",
                "Mumbai",
                "Sao Paulo",
                "Mexico City",
                "Dehli",
                "Osaka",
                "Cairo",
                "Kolkata",
                "Los Angeles",
                "Shanghai",
                "Moscow",
                "Beijing",
                "Buenos Aires",
                "Guangzhou",
                "Shenzhen",
                "Istanbul"
            )
            .setLabels(new XAxisLabels()
                .setRotation(-45)
                .setAlign(Labels.Align.RIGHT)
                .setStyle(new Style()
                    .setFont("normal 13px Verdana, sans-serif")
                )
            );

        chart.getYAxis()
            .setAxisTitleText("Population (millions")
            .setMin(0);

        chart.addSeries(chart.createSeries()
            .setName("Population")
            .setPoints(new Number[]{
                34.4, 21.8, 20.1, 20, 19.6, 19.5, 19.1, 18.4, 18,
                17.3, 16.8, 15, 14.7, 14.5, 13.3, 12.8, 12.4, 11.8,
                11.7, 11.2
            })
            .setPlotOptions(new ColumnPlotOptions()
                .setDataLabels(new DataLabels()
                    .setEnabled(true)
                    .setRotation(-90)
                        // TODO: Update to support retrieving color from the highcharts theme.  e.g. Highcharts.theme.dataLabelsColor
                    .setColor("#FFFFFF")
                    .setAlign(Labels.Align.RIGHT)
                    .setX(-3)
                    .setY(10)
                    .setFormatter(new DataLabelsFormatter() {
                        public String format(DataLabelsData dataLabelsData) {
                            return NumberFormat.getFormat("0.0").format(dataLabelsData.getYAsDouble());
                        }
                    })
                    .setStyle(new Style()
                        .setFont("normal 13px Verdana, sans-serif")
                    )
                )
            )
        );

        return chart;
    }
}
