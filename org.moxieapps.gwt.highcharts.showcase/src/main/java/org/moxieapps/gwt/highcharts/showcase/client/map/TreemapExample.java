package org.moxieapps.gwt.highcharts.showcase.client.map;

import com.smartgwt.client.widgets.Canvas;
import org.moxieapps.gwt.highcharts.client.*;
import org.moxieapps.gwt.highcharts.client.labels.DataLabels;
import org.moxieapps.gwt.highcharts.client.labels.Labels;
import org.moxieapps.gwt.highcharts.client.plotOptions.TreemapPlotOptions;
import org.moxieapps.gwt.highcharts.showcase.client.BaseChartExample;
import org.moxieapps.gwt.highcharts.showcase.client.ExampleFactory;

public class TreemapExample extends BaseChartExample {

    public TreemapExample(String title, String icon) {
        super(title, icon);
    }

    @Override
    public String getSourcePath() {
        return "map/TreemapExample.java.html";
    }

    public static ExampleFactory getFactory() {
        return new ExampleFactory() {
            @Override
            public Canvas createChartCanvas() {
                return new TreemapExample(getTitle(), getIcon());
            }

            @Override
            public String getTitle() {
                return "Treemap";
            }

            @Override
            public String getIcon() {
                return "icons/16/map_chart.png";
            }
        };
    }

    public BaseChart createChart() {

        final Chart chart = new Chart()
                .setChartTitleText("Fruit Consumption");

        //Defining points to act as parents
        final Point appleParent = new Point("Apples")
                .setColor("#EC2500");
        final Point bananaParent = new Point("Bananas")
                .setColor("#ECE100");
        final Point orangeParent = new Point("Oranges")
                .setColor("#EC9800");

        chart.addSeries(chart.createSeries()
                .setType(Series.Type.TREEMAP)
                .setPlotOptions(new TreemapPlotOptions()
                        .setAlternateStartingDirection(true)
                        .setLayoutAlgorithm(TreemapPlotOptions.LayoutAlgorithm.STRIPES)
                        .setLevels(new TreemapPlotOptions.Level()
                                .setLevel(1)
                                .setLayoutAlgorithm(TreemapPlotOptions.LayoutAlgorithm.SLICE_AND_DICE)
                                .setDataLabels(new DataLabels()
                                        .setEnabled(true)
                                        .setAlign(Labels.Align.LEFT)
                                        .setVerticalAlign(Labels.VerticalAlign.TOP)
                                        .setStyle(new Style()
                                                .setFontSize("15px")
                                                .setFontWeight("bold")
                                        )
                                )
                        )
                )
                .setPoints(new Point[]{
                        appleParent,
                        bananaParent,
                        orangeParent,
                        new Point("Anne", 5)
                                .setParent(appleParent),
                        new Point("Rick", 3)
                                .setParent(appleParent),
                        new Point("Peter", 4)
                                .setParent(appleParent),
                        new Point("Anne", 4)
                                .setParent(bananaParent),
                        new Point("Rick", 10)
                                .setParent(bananaParent),
                        new Point("Peter", 1)
                                .setParent(bananaParent),
                        new Point("Anne", 1)
                                .setParent(orangeParent),
                        new Point("Rick", 3)
                                .setParent(orangeParent),
                        new Point("Peter", 3)
                                .setParent(orangeParent),
                        new Point("Susanne", 2)
                                .setParent("Kiwi")
                                .setColor("#9EDE00")
                })
        );

        return chart;
    }
}
