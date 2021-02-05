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
 * Provides access to the raw information provided by Highcharts when a user selects a portion
 * of the chart, including the axis values of the selection.  This class should
 * not be instantiated directly, but instead you should create a {@link ChartSelectionEventHandler} and
 * register it via the {@link org.moxieapps.gwt.highcharts.client.BaseChart#setSelectionEventHandler(ChartSelectionEventHandler)}
 * method in order to access selection events.
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.1.0
 */
public class ChartSelectionEvent extends MouseEvent {

    /**
     * This constructor is intended for internal use only.  You should not create selection events
     * directly, but instead should register a {@link ChartSelectionEventHandler}.
     *
     * @param event The native javascript object containing the details of the original event that was fired.
     */
    public ChartSelectionEvent(JavaScriptObject event) {
        super(event);
    }

    /**
     * Return the minimum value of the selection range of the first X axis.  See the
     * {@link #getXAxisMin(int)} method if you need the value of a different X axis.
     *
     * @return The minimum value of the selected range on the first X axis.
     */
    public double getXAxisMin() {
        return getXAxisMin(0);
    }

    /**
     * Return the minimum value of the selection range of the first X axis, converting the
     * value to a long value first.  See the {@link #getXAxisMinAsLong(int)} method
     * if you need the value of a different X axis, or the {@link #getXAxisMin()}
     * method if you need a floating point value instead.
     *
     * @return The minimum value of the selected range on the first X axis, as a long.
     */
    public long getXAxisMinAsLong() {
        return ((Double)getXAxisMin()).longValue();
    }

    /**
     * Return the minimum value of the selection range on the requested X axis.  Will
     * throw an exception if the given axis index is invalid.
     *
     * @param axisIndex The index (zero based) of the X axis for which you'd like
     *                  to retrieve the minimum value of the selection event.
     * @return The minimum value of the selection range on the requested X axis.
     */
    public native double getXAxisMin(int axisIndex) /*-{
        return this.@org.moxieapps.gwt.highcharts.client.events.MouseEvent::event.xAxis[axisIndex].min;
    }-*/;

    /**
     * Return the minimum value of the selection range on the requested X axis, converting
     * the value to a long value first.  Will throw an exception if the given axis index is
     * invalid.
     *
     * @param axisIndex The index (zero based) of the X axis for which you'd like
     *                  to retrieve the minimum value of the selection event.
     * @return The minimum value of the selection range on the requested X axis, as a long.
     */
    public long getXAxisMinAsLong(int axisIndex) {
        return ((Double)getXAxisMin(axisIndex)).longValue();
    }

    /**
     * Return the maximum value of the selection range of the first X axis.  See the
     * {@link #getXAxisMax(int)} method if you need the value of a different X axis.
     *
     * @return The maximum value of the selected range on the first X axis.
     */
    public double getXAxisMax() {
        return getXAxisMax(0);
    }

    /**
     * Return the maximum value of the selection range of the first X axis, converting the
     * value to a long value first.  See the {@link #getXAxisMaxAsLong(int)} method
     * if you need the value of a different X axis, or the {@link #getXAxisMax()}
     * method if you need a floating point value instead.
     *
     * @return The maximum value of the selected range on the first X axis, as a long.
     */
    public long getXAxisMaxAsLong() {
        return ((Double)getXAxisMax()).longValue();
    }

    /**
     * Return the maximum value of the selection range on the requested X axis.  Will
     * throw an exception if the given axis index is invalid.
     *
     * @param axisIndex The index (zero based) of the X axis for which you'd like
     *                  to retrieve the maximum value of the selection event.
     * @return The maximum value of the selection range on the requested X axis.
     */
    public native double getXAxisMax(int axisIndex) /*-{
        return this.@org.moxieapps.gwt.highcharts.client.events.MouseEvent::event.xAxis[axisIndex].max;
    }-*/;

    /**
     * Return the maximum value of the selection range on the requested X axis, converting
     * the value to a long value first.  Will throw an exception if the given axis index is
     * invalid.
     *
     * @param axisIndex The index (zero based) of the X axis for which you'd like
     *                  to retrieve the maximum value of the selection event.
     * @return The maximum value of the selection range on the requested X axis, as a long.
     */
    public long getXAxisMaxAsLong(int axisIndex) {
        return ((Double)getXAxisMax(axisIndex)).longValue();
    }  
    
    /**
     * Return the minimum value of the selection range of the first Y axis.  See the
     * {@link #getYAxisMin(int)} method if you need the value of a different Y axis.
     *
     * @return The minimum value of the selected range on the first Y axis.
     */
    public double getYAxisMin() {
        return getYAxisMin(0);
    }

    /**
     * Return the minimum value of the selection range of the first Y axis, converting the
     * value to a long value first.  See the {@link #getYAxisMinAsLong(int)} method
     * if you need the value of a different Y axis, or the {@link #getYAxisMin()}
     * method if you need a floating point value instead.
     *
     * @return The minimum value of the selected range on the first Y axis, as a long.
     */
    public long getYAxisMinAsLong() {
        return ((Double)getYAxisMin()).longValue();
    }

    /**
     * Return the minimum value of the selection range on the requested Y axis.  Will
     * throw an exception if the given axis index is invalid.
     *
     * @param axisIndex The index (zero based) of the Y axis for which you'd like
     *                  to retrieve the minimum value of the selection event.
     * @return The minimum value of the selection range on the requested Y axis.
     */
    public native double getYAxisMin(int axisIndex) /*-{
        return this.@org.moxieapps.gwt.highcharts.client.events.MouseEvent::event.yAxis[axisIndex].min;
    }-*/;

    /**
     * Return the minimum value of the selection range on the requested Y axis, converting
     * the value to a long value first.  Will throw an exception if the given axis index is
     * invalid.
     *
     * @param axisIndex The index (zero based) of the Y axis for which you'd like
     *                  to retrieve the minimum value of the selection event.
     * @return The minimum value of the selection range on the requested Y axis, as a long.
     */
    public long getYAxisMinAsLong(int axisIndex) {
        return ((Double)getYAxisMin(axisIndex)).longValue();
    }

    /**
     * Return the maximum value of the selection range of the first Y axis.  See the
     * {@link #getYAxisMax(int)} method if you need the value of a different Y axis.
     *
     * @return The maximum value of the selected range on the first Y axis.
     */
    public double getYAxisMax() {
        return getYAxisMax(0);
    }

    /**
     * Return the maximum value of the selection range of the first Y axis, converting the
     * value to a long value first.  See the {@link #getYAxisMaxAsLong(int)} method
     * if you need the value of a different Y axis, or the {@link #getYAxisMax()}
     * method if you need a floating point value instead.
     *
     * @return The maximum value of the selected range on the first Y axis, as a long.
     */
    public long getYAxisMaxAsLong() {
        return ((Double)getYAxisMax()).longValue();
    }

    /**
     * Return the maximum value of the selection range on the requested Y axis.  Will
     * throw an exception if the given axis index is invalid.
     *
     * @param axisIndex The index (zero based) of the Y axis for which you'd like
     *                  to retrieve the maximum value of the selection event.
     * @return The maximum value of the selection range on the requested Y axis.
     */
    public native double getYAxisMax(int axisIndex) /*-{
        return this.@org.moxieapps.gwt.highcharts.client.events.MouseEvent::event.yAxis[axisIndex].max;
    }-*/;

    /**
     * Return the maximum value of the selection range on the requested Y axis, converting
     * the value to a long value first.  Will throw an exception if the given axis index is
     * invalid.
     *
     * @param axisIndex The index (zero based) of the Y axis for which you'd like
     *                  to retrieve the maximum value of the selection event.
     * @return The maximum value of the selection range on the requested Y axis, as a long.
     */
    public long getYAxisMaxAsLong(int axisIndex) {
        return ((Double)getYAxisMax(axisIndex)).longValue();
    }     
}
