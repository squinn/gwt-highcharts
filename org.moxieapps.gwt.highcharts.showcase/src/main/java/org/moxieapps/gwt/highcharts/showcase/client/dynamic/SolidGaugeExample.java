package org.moxieapps.gwt.highcharts.showcase.client.dynamic;


import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.Timer;
import com.smartgwt.client.widgets.Canvas;
import org.moxieapps.gwt.highcharts.client.*;
import org.moxieapps.gwt.highcharts.client.labels.*;
import org.moxieapps.gwt.highcharts.client.plotOptions.Dial;
import org.moxieapps.gwt.highcharts.client.plotOptions.GaugePlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.Pivot;
import org.moxieapps.gwt.highcharts.client.plotOptions.SolidGaugePlotOptions;
import org.moxieapps.gwt.highcharts.showcase.client.BaseChartExample;
import org.moxieapps.gwt.highcharts.showcase.client.ExampleFactory;


public class SolidGaugeExample extends BaseChartExample {

    public SolidGaugeExample(String title, String icon) {
        super(title, icon);
    }

    @Override
    public String getSourcePath() {
        return "dynamic/SpeedometerExample.java.html";
    }

    public static ExampleFactory getFactory() {
        return new ExampleFactory() {
            @Override
            public Canvas createChartCanvas() {
                return new SolidGaugeExample(getTitle(), getIcon());
            }

            @Override
            public String getTitle() {
                return "Solid Gauge Speedometer";
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
                .setType(Series.Type.SOLID_GAUGE)
                .setPane(new Pane()
                        .setCenter("50%", "50%")
                        .setSize("140%")
                        .setStartAngle(-90)
                        .setEndAngle(90)
                        .setBackground(new PaneBackground()
                                .setBackgroundColor("#EEE")
                                .setInnerRadius("60%")
                                .setOuterRadius("100%")
                                .setOption("shape", "arc")
                        )
                );

        chart.setGaugePlotOptions(new GaugePlotOptions()
                .setDataLabels(new DataLabels()
                        .setEnabled(true)
                        .setY(30)
                        .setFormat("{point.y} km/h")
                )
                .setPivotOptions(
                        new Pivot()
                                .setRadius("2%")
                )
                .setDialOptions(
                        new Dial()
                                .setRearLength("0%")
                                .setBaseWidth(10)
                )
        );

        // Primary axis
        chart.getYAxis(0)
                .setLineWidth(0)
                .setMinorTickInterval(null)
                .setTickPixelInterval(400)
                .setTickWidth(0)
                .setAxisTitle(new AxisTitle()
                    .setY(-70)
                )
                .setLabels(new YAxisLabels()
                    .setY(16)
                );

        chart.setSolidGaugePlotOptions(new SolidGaugePlotOptions()
            .setDataLabels(new DataLabels()
                    .setY(5)
                    .setBorderWidth(0)
                    .setUseHTML(true)
            )
        );



        final Series series = chart.createSeries();
        chart.addSeries(series
                .setName("Random speed")
                .addPoint(80)
        );

        final Timer tempTimer = new Timer() {
            @Override
            public void run() {
                long inc = Math.round((Random.nextDouble() - .5) * 20);
                long cur = series.getPoints()[0].getY().longValue();
                series.getPoints()[0]
                        .update(cur + inc);

            }
        };

        tempTimer.scheduleRepeating(1500);

        return chart;
    }


}
