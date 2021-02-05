package org.moxieapps.gwt.highcharts.showcase.client.dynamic;


import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.Timer;
import com.smartgwt.client.widgets.Canvas;
import org.moxieapps.gwt.highcharts.client.*;
import org.moxieapps.gwt.highcharts.client.labels.*;
import org.moxieapps.gwt.highcharts.client.plotOptions.Dial;
import org.moxieapps.gwt.highcharts.client.plotOptions.GaugePlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.Pivot;
import org.moxieapps.gwt.highcharts.showcase.client.BaseChartExample;
import org.moxieapps.gwt.highcharts.showcase.client.ExampleFactory;


public class SpeedometerExample extends BaseChartExample {

    public SpeedometerExample(String title, String icon) {
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
                return new SpeedometerExample(getTitle(), getIcon());
            }

            @Override
            public String getTitle() {
                return "Dual-Axis Speedometer";
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
                .setType(Series.Type.GAUGE)
                .setAlignTicks(false)
                .setPlotBackgroundImage(null)
                .setBorderWidth(0)
                .setPlotShadow(false)
                .setChartTitle(new ChartTitle()
                        .setText("Speedometer with dual axes")
                )
                .setPane(new Pane()
                        .setStartAngle(-150)
                        .setEndAngle(150)
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
                .setMin(0)
                .setMax(200)
                .setTickPosition(Axis.TickPosition.INSIDE)
                .setMinorTickPosition(Axis.TickPosition.INSIDE)
                .setLineColor("#339")
                .setTickColor("#339")
                .setMinorTickColor("#339")
                .setOffset(-25)
                .setLineWidth(2)
                .setTickLength(5)
                .setMinorTickLength(5)
                .setEndOnTick(false)
                .setLabels(
                        new YAxisLabels()
                                // There is no documented "distance" option for gauge chart axes
                                .setOption("distance", -20)
                )
        ;

        // Secondary axis
        chart.getYAxis(1)
                .setMin(0)
                .setMax(124)
                .setTickPosition(Axis.TickPosition.OUTSIDE)
                .setMinorTickPosition(Axis.TickPosition.OUTSIDE)
                .setLineColor("#933")
                .setTickColor("#933")
                .setMinorTickColor("#933")
                .setOffset(-20)
                .setLineWidth(2)
                .setTickLength(5)
                .setMinorTickLength(5)
                .setEndOnTick(false)
                .setLabels(
                        new YAxisLabels()
                                // There is no documented "distance" option for gauge chart axes
                                .setOption("distance", 12)
                )
        ;

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

        tempTimer.scheduleRepeating(2000);

        return chart;
    }


}
