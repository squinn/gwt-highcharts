/*
 * Copyright 2011 Moxie Group
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.moxieapps.gwt.highcharts.client.events;

import com.google.gwt.core.client.JavaScriptObject;
import org.moxieapps.gwt.highcharts.client.Point;

/**
 * Provides access to the raw information provided by Highcharts when a user clicks on a series
 * in the chart, including the nearest point to the click.  This class should
 * not be instantiated directly, but instead you should create a {@link SeriesClickEventHandler} and
 * register it via the {@link org.moxieapps.gwt.highcharts.client.plotOptions.SeriesPlotOptions#setSeriesClickEventHandler(SeriesClickEventHandler)}
 * method in order to access click events.
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.1.0
 */
public class SeriesClickEvent extends SeriesEvent {

    /**
     * This constructor is intended for internal use only.  You should not create click events
     * directly, but instead should register a {@link SeriesClickEventHandler}.
     *
     * @param event The native javascript object containing the details of the original event that was fired.
     * @param series The native javascript object that represents the series instance that the event was triggered on.
     */
    public SeriesClickEvent(JavaScriptObject event, JavaScriptObject series) {
        super(event, series);
    }

    /**
     * Create a new GWT point instance that is connected to the Highcharts JS point instance associated
     * with the nearest point to the click (e.g. "event.point").
     *
     * @return A Point instance that is connected to the Highcharts data point associated with this event
     */
    public Point getNearestPoint() {
        return new Point(nativeGetPoint());
    }

    /**
     * Return the name of the point nearest to the click (e.g. "event.point.name").
     *
     * @return The name of the point that was nearest to where the user clicked on the series.
     */
    public native String getNearestPointName() /*-{
        return this.@org.moxieapps.gwt.highcharts.client.events.MouseEvent::event.point.name;
    }-*/;

    /**
     * Return the x value of the nearest point as a double.  An exception will be thrown
     * if the native value of the object is not a number.
     *
     * @return The x value of the nearest point as a double.
     */
    public native double getNearestXAsDouble() /*-{
        return this.@org.moxieapps.gwt.highcharts.client.events.MouseEvent::event.point.x;
    }-*/;

    /**
     * Return the x value of the nearest point as a long.  An exception will be thrown
     * if the native value of the object is not a number.
     *
     * @return The x value of the nearest point as a long.
     */
    public long getNearestXAsLong() {
        return ((Double)getNearestXAsDouble()).longValue();
    }

    /**
     * Return the x value of the nearest point as a string.  An exception will be thrown
     * if the native value of the object is not a string.
     *
     * @return The x value of the nearest point as a string.
     */
    public native String getNearestXAsString() /*-{
        return this.@org.moxieapps.gwt.highcharts.client.events.MouseEvent::event.point.x;
    }-*/;

    /**
     * Return the y value of the nearest point as a double.  An exception will be thrown
     * if the native value of the object is not a number.
     *
     * @return The y value of the nearest point as a double.
     */
    public native double getNearestYAsDouble() /*-{
        return this.@org.moxieapps.gwt.highcharts.client.events.MouseEvent::event.point.y;
    }-*/;

    /**
     * Return the y value of the nearest point as a long.  An exception will be thrown
     * if the native value of the object is not a number.
     *
     * @return The y value of the nearest point as a long.
     */
    public long getNearestYAsLong() {
        return ((Double)getNearestYAsDouble()).longValue();
    }

    /**
     * Return the y value of the nearest point as a string.  An exception will be thrown
     * if the native value of the object is not a string.
     *
     * @return The y value of the nearest point as a string.
     */
    public native String getNearestYAsString() /*-{
        return this.@org.moxieapps.gwt.highcharts.client.events.MouseEvent::event.point.y;
    }-*/;

    private native JavaScriptObject nativeGetPoint()  /*-{
        return this.@org.moxieapps.gwt.highcharts.client.events.MouseEvent::event.point;
    }-*/;

}
