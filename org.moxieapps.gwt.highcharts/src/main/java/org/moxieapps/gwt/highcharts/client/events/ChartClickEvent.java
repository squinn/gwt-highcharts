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

/**
 * Provides access to the raw information provided by Highcharts when a user clicks on the
 * plot area of the chart, including the axis values of the click.  This class should
 * not be instantiated directly, but instead you should create a {@link ChartClickEventHandler} and
 * register it via the {@link org.moxieapps.gwt.highcharts.client.BaseChart#setClickEventHandler(ChartClickEventHandler)}
 * method in order to access click events.
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.1.0
 */
public class ChartClickEvent extends MouseEvent {

    /**
     * This constructor is intended for internal use only.  You should not create click events
     * directly, but instead should register a {@link ChartClickEventHandler}.
     *
     * @param event The native javascript object containing the details of the original event that was fired.
     */
    public ChartClickEvent(JavaScriptObject event) {
        super(event);
    }

    /**
     * Return the value of the first X axis at the click event location.  See the
     * {@link #getXAxisValue(int)} method if you need the value of a different X axis.
     *
     * @return The value of the first X axis at the click event location.
     */
    public double getXAxisValue() {
        return getXAxisValue(0);
    }

    /**
     * Return the value of the first X axis at the click event location, converting the
     * value to a long value first.  See the {@link #getXAxisValueAsLong(int)} method
     * if you need the value of a different X axis, or the {@link #getXAxisValue()}
     * method if you need a floating point value instead.
     *
     * @return The value of the first X axis at the click event location, as a long.
     */
    public long getXAxisValueAsLong() {
        return ((Double) getXAxisValue()).longValue();
    }

    /**
     * Return the value of the requested X axis at the click event location.  Will
     * throw an exception if the given axis index is invalid.
     *
     * @param axisIndex The index (zero based) of the X axis for which you'd like
     *                  to retrieve the value of the click event.
     * @return The value of the requested X axis at the click event location.
     */
    public native double getXAxisValue(int axisIndex) /*-{
        return this.@org.moxieapps.gwt.highcharts.client.events.MouseEvent::event.xAxis[axisIndex].value;
    }-*/;

    /**
     * Return the value of the requested X axis at the click event location, converting
     * the value to a long before returning it.  Will throw an exception if the given axis
     * index is invalid.  See the {@link #getXAxisValue(int)} method if you need the value
     * as a floating point number instead.
     *
     * @param axisIndex The index (zero based) of the X axis for which you'd like
     *                  to retrieve the value of the click event.
     * @return The value of the requested X axis at the click event location, as a long.
     */
    public long getXAxisValueAsLong(int axisIndex) {
        return ((Double) getXAxisValue(axisIndex)).longValue();
    }


    /**
     * Return the value of the first Y axis at the click event location.  See the
     * {@link #getYAxisValue(int)} method if you need the value of a different Y axis.
     *
     * @return The value of the first Y axis at the click event location.
     */
    public double getYAxisValue() {
        return getYAxisValue(0);
    }

    /**
     * Return the value of the first Y axis at the click event location, converting the
     * value to a long value first.  See the {@link #getYAxisValueAsLong(int)} method
     * if you need the value of a different Y axis, or the {@link #getYAxisValue()}
     * method if you need a floating point value instead.
     *
     * @return The value of the first Y axis at the click event location, as a long.
     */
    public long getYAxisValueAsLong() {
        return ((Double) getYAxisValue()).longValue();
    }

    /**
     * Return the value of the requested Y axis at the click event location.  Will
     * throw an exception if the given axis index is invalid.
     *
     * @param axisIndex The index (zero based) of the Y axis for which you'd like
     *                  to retrieve the value of the click event.
     * @return The value of the requested Y axis at the click event location.
     */
    public native double getYAxisValue(int axisIndex) /*-{
        return this.@org.moxieapps.gwt.highcharts.client.events.MouseEvent::event.yAxis[axisIndex].value;
    }-*/;

    /**
     * Return the value of the requested Y axis at the click event location, converting
     * the value to a long before returning it.  Will throw an exception if the given axis
     * index is invalid.  See the {@link #getYAxisValue(int)} method if you need the value
     * as a floating point number instead.
     *
     * @param axisIndex The index (zero based) of the Y axis for which you'd like
     *                  to retrieve the value of the click event.
     * @return The value of the requested Y axis at the click event location, as a long.
     */
    public long getYAxisValueAsLong(int axisIndex) {
        return ((Double) getYAxisValue(axisIndex)).longValue();
    }

}
