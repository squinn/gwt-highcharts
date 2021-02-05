package org.moxieapps.gwt.highcharts.test.client;

import com.google.gwt.user.client.ui.Composite;
import org.moxieapps.gwt.highcharts.client.Chart;
import org.moxieapps.gwt.highcharts.client.Series;

public class CompositeTest extends Composite {
    public CompositeTest(String chartTitle) {
        Chart chart = new Chart()
            .setChartTitleText(chartTitle);
        Series series = chart.createSeries()
            .setName("Moles per Yard")
            .setPoints(new Number[]{163, 203, 276, 408, 547, 729, 628});
        chart.addSeries(series);
        initWidget(chart);
    }
}
