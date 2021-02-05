package org.moxieapps.gwt.highcharts.test.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import org.moxieapps.gwt.highcharts.client.AxisTitle;
import org.moxieapps.gwt.highcharts.client.Chart;
import org.moxieapps.gwt.highcharts.client.Series;
import org.moxieapps.gwt.highcharts.client.Style;
import org.moxieapps.gwt.highcharts.client.events.ChartClickEvent;
import org.moxieapps.gwt.highcharts.client.events.ChartClickEventHandler;

/**
 * Enter class description here.
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.0.0
 */
public class DragTest implements EntryPoint {
    public void onModuleLoad() {
        RootPanel.get().add(createDraggablePointChart());
    }

    private Chart createDraggablePointChart() {
        final Chart chart = new Chart()
            .setType(Series.Type.SPLINE)
            .setChartTitleText("Lawn Tunnels")
            .setAnimation(false)
            .setMarginRight(10);
        chart.getXAxis().setAxisTitleText("Hello");
        Series series = chart.createSeries()
            .setName("Moles per Yard")
            .setPoints(new Number[]{163, 203, 276, 408, 547, 729, 628})
            .setOption("draggableY", true)
            .setOption("dragMinY", 0)
            .setOption("minPointLength", 2);
        chart.addSeries(series);
        return chart;
    }
}
