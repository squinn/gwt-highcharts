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
 * The base class of all events that are triggered on a point, and includes methods for accessing the general
 * properties of the point, such as its name or X and Y values.
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.1.0
 */
public abstract class PointEvent extends MouseEvent {

    @SuppressWarnings({"FieldCanBeLocal", "UnusedDeclaration"})
    private JavaScriptObject point;

    /**
     * We can only be created by instantiating one of our sub classes.
     *
     * @param event The native javascript object containing the details of the original event that was fired.
     * @param point The native javascript object that represents the point instance that the event was triggered on.
     */
    protected PointEvent(JavaScriptObject event, JavaScriptObject point) {
        super(event);
        this.point = point;
    }

    /**
     * Create a new GWT point instance that is connected to the Highcharts JS point instance associated
     * with this event.
     *
     * @return A Point instance that is connected to the Highcharts data point associated with this event
     */
    public Point getPoint() {
        return new Point(point);
    }

    /**
     * Retrieve the unique id of the series that the point is a part of which received the event.
     * This id can then be used to obtain the Series instance itself via the
     * {@link org.moxieapps.gwt.highcharts.client.BaseChart#getSeries(String)} method.
     *
     * @return The unique id of the series that the point was a part of that the event was triggered on.
     */
    public native String getSeriesId() /*-{
        return this.@org.moxieapps.gwt.highcharts.client.events.PointEvent::point.series.options.id;
    }-*/;

    /**
     * Return the name of the series that the point is a part of which the event was received on.
     *
     * @return The name of the series that the point was a part of that the event was received on.
     */
    public native String getSeriesName() /*-{
        return this.@org.moxieapps.gwt.highcharts.client.events.PointEvent::point.series.name;
    }-*/;

    /**
     * Return the name of the point on which the event occurred.
     *
     * @return The name of the point on which the event occurred.
     */
    public native String getPointName() /*-{
        return this.@org.moxieapps.gwt.highcharts.client.events.PointEvent::point.name;
    }-*/;

    /**
     * Return the x value of the point as a double.  An exception will be thrown
     * if the native value of the object is not a number.
     *
     * @return The x value of the point as a double.
     */
    public native double getXAsDouble() /*-{
        return this.@org.moxieapps.gwt.highcharts.client.events.PointEvent::point.x;
    }-*/;

    /**
     * Return the x value of the point as a long.  An exception will be thrown
     * if the native value of the object is not a number.
     *
     * @return The x value of the point as a long.
     */
    public long getXAsLong() {
        return ((Double)getXAsDouble()).longValue();
    }

    /**
     * Return the x value of the point as a string.  An exception will be thrown
     * if the native value of the object is not a string.
     *
     * @return The x value of the point as a string.
     */
    public native String getXAsString() /*-{
        return this.@org.moxieapps.gwt.highcharts.client.events.PointEvent::point.x;
    }-*/;

    /**
     * Return the y value of the  point as a double.  An exception will be thrown
     * if the native value of the object is not a number.
     *
     * @return The y value of the  point as a double.
     */
    public native double getYAsDouble() /*-{
        return this.@org.moxieapps.gwt.highcharts.client.events.PointEvent::point.y;
    }-*/;

    /**
     * Return the y value of the point as a long.  An exception will be thrown
     * if the native value of the object is not a number.
     *
     * @return The y value of the point as a long.
     */
    public long getYAsLong() {
        return ((Double)getYAsDouble()).longValue();
    }

    /**
     * Return the y value of the point as a string.  An exception will be thrown
     * if the native value of the object is not a string.
     *
     * @return The y value of the point as a string.
     */
    public native String getYAsString() /*-{
        return this.@org.moxieapps.gwt.highcharts.client.events.PointEvent::point.y;
    }-*/;

}
