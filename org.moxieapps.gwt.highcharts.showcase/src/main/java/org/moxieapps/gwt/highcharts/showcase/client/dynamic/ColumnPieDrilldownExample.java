package org.moxieapps.gwt.highcharts.showcase.client.dynamic;


import com.google.gwt.user.client.Window;
import com.smartgwt.client.widgets.Canvas;
import org.moxieapps.gwt.highcharts.client.*;
import org.moxieapps.gwt.highcharts.client.labels.DataLabels;
import org.moxieapps.gwt.highcharts.client.plotOptions.SeriesPlotOptions;
import org.moxieapps.gwt.highcharts.showcase.client.BaseChartExample;
import org.moxieapps.gwt.highcharts.showcase.client.ExampleFactory;
import org.moxieapps.gwt.highcharts.showcase.client.threeD.Column3DExample;

public class ColumnPieDrilldownExample extends BaseChartExample {

    public ColumnPieDrilldownExample(String title, String icon) {
        super(title, icon);
    }

    @Override
    public String getSourcePath() {
        return "dynamic/ColumnPieDrilldownExample.java.html";
    }

    public static ExampleFactory getExampleFactory() {
        return new ExampleFactory() {
            @Override
            public Canvas createChartCanvas() {
                return new ColumnPieDrilldownExample(getTitle(), getIcon());
            }

            @Override
            public String getTitle() {
                return "Drilldown Across Series Types";
            }

            @Override
            public String getIcon() {
                return "icons/16/column_chart.png";
            }
        };
    }

    @Override
    public BaseChart createChart() {
        Chart chart = new Chart()
            .setType(Series.Type.COLUMN)
            .setChartTitleText("Drilldown from Column to Pie")
            .setBorderWidth(0);

        chart.getXAxis()
            .setType(Axis.Type.CATEGORY)
            .setShowEmpty(false);

        chart.getYAxis()
            .setShowEmpty(false);

        chart.setLegend(new Legend()
            .setEnabled(true)
        );

        chart.setSeriesPlotOptions(new SeriesPlotOptions()
            .setDataLabels(new DataLabels()
                    .setEnabled(true)
            )
        );

        final Series animalSeries = chart.createSeries()
            .setType(Series.Type.PIE)
            .setPoints(
                new Point[]{
                    new Point("Cats", 4),
                    new Point("Dogs", 2),
                    new Point("Cows", 2),
                    new Point("Sheep", 2),
                    new Point("Pigs", 1)
            });

        final Series fruitSeries = chart.createSeries()
            .setType(Series.Type.PIE)
            .setPoints(new Point[]{
                    new Point("Apples", 4),
                    new Point("Oranges", 2)
            });

        final Series carSeries = chart.createSeries()
            .setType(Series.Type.PIE)
            .setPoints(new Point[]{
                    new Point("Toyota", 4),
                    new Point("Opel", 2),
                    new Point("Volkswagen", 2)
            });

        chart.setDrilldown(new Drilldown()
            .setSeries(animalSeries, fruitSeries, carSeries)
        );

        chart.addSeries(chart.createSeries()
            .setName("Things")
            .setColorByPoint(true)
            .setPoints(new Point[]{
                new Point("Animals", 5)
                    .setDrilldownSeries(animalSeries),
                new Point("Fruits", 2)
                    .setDrilldownSeries(fruitSeries),
                new Point("Cars", 3)
                    .setDrilldownSeries(carSeries)
            })
        );

        Highcharts.setOptions(
            new Highcharts.Options().setLang(
                new Lang()
                    .setOption("drillUpText", "Back to Things")
                )
        );

        return chart;
    }

}
