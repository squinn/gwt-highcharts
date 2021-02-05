package org.moxieapps.gwt.highcharts.showcase.client;


import com.smartgwt.client.widgets.Canvas;

/**
 * Serves as a factory to create the example chart panels
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.0
 */
public abstract class ExampleFactory {

    public abstract Canvas createChartCanvas();

    public abstract String getTitle();

    public abstract String getIcon();

}
