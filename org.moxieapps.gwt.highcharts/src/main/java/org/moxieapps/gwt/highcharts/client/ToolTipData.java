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

package org.moxieapps.gwt.highcharts.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * An object that represents the state information that will be passed to any custom
 * {@link ToolTipFormatter} to allow for custom strings to be included within the tooltip area.
 * See the {@link ToolTipFormatter#format(ToolTipData)} method for more details on the capabilities
 * that custom formatters can provide.
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.0.0
 */
public class ToolTipData {

    @SuppressWarnings({"FieldCanBeLocal", "UnusedDeclaration"})
    private JavaScriptObject data;

    // Purposefully restricted to package scope
    ToolTipData(JavaScriptObject data) {
        this.data = data;
    }

    /**
     * Return the percentage value of the point (which represents the point's percentage
     * of the total).  Stacked series and pies only.
     *
     * @return The percentage value of the point.
     */
    public native double getPercentage() /*-{
        return this.@org.moxieapps.gwt.highcharts.client.ToolTipData::data.percentage;
    }-*/;

    /**
     * Return the percentage value of the point at a given index (for shared tooltips), which
     * represents the point's percentage of the total.  Stacked series and pies only.
     *
     * @param index The index of the point in the array to retrieve.
     * @return The percentage value of the point at the given index.
     * @since 1.1.3
     */
    public native double getPercentage(int index) /*-{
        return this.@org.moxieapps.gwt.highcharts.client.ToolTipData::data.points[index].percentage;
    }-*/;

    /**
     * Retrieve the unique id of the series that the point is a part of. This id can then be used
     * to obtain the Series instance itself via the
     * {@link org.moxieapps.gwt.highcharts.client.BaseChart#getSeries(String)} method.
     *
     * @return The unique id of the series that the event was triggered on.
     */
    public native String getSeriesId() /*-{
        return this.@org.moxieapps.gwt.highcharts.client.ToolTipData::data.series.options.id;
    }-*/;

    /**
     * Retrieve the unique id of the series that a point at the given index (for shared tooltips)
     * is a part of. This id can then be used to obtain the Series instance itself via the
     * {@link org.moxieapps.gwt.highcharts.client.BaseChart#getSeries(String)} method.
     *
     * @param index The index of the point in the array to retrieve the series from.
     * @return The unique id of the series that the event was triggered on for the given indexed point.
     * @since 1.1.3
     */
    public native String getSeriesId(int index) /*-{
        return this.@org.moxieapps.gwt.highcharts.client.ToolTipData::data.points[index].series.options.id;
    }-*/;

    /**
     * Return the name of the series that the point is a part of.
     *
     * @return The name of the series that the point is a part of
     */
    public native String getSeriesName() /*-{
        return this.@org.moxieapps.gwt.highcharts.client.ToolTipData::data.series.name;
    }-*/;

    /**
     * Return the name of the series that the point at a given index (for shared tooltips) is a part of.
     *
     * @param index The index of the point in the array to retrieve the series from.
     * @return The name of the series that the point at the given index is a part of
     * @since 1.1.3
     */
    public native String getSeriesName(int index) /*-{
        return this.@org.moxieapps.gwt.highcharts.client.ToolTipData::data.points[index].series.name;
    }-*/;

    /**
     * Create a new GWT point instance that is connected to the Highcharts JS point instance associated
     * with this tooltip.
     *
     * @return A Point instance that is connected to the Highcharts data point associated with the tooltip.
     */
    public Point getPoint() {
        return new Point(getNativePoint());
    }

    /**
     * Create a new GWT point instance that is connected to the Highcharts JS point instance at a
     * given index (for shared tooltips) associated with this tooltip.
     *
     * @param index The index of the point in the array to retrieve.
     * @return A Point instance that is connected to the Highcharts data point associated with the tooltip.
     * @since 1.1.3
     */
    public Point getPoint(int index) {
        JsArray<JavaScriptObject> nativePoints = getNativePoints();
        return new Point(getNativePointFromReference(nativePoints.get(index)));
    }

    /**
     * Create a new GWT point instance for each values in the array of values provided that are
     * connected to the Highcharts JS point instances associated with this tooltip (shared tooltips only).
     * Note that if you simply need to iterate over the data points to retrieve the values for
     * rendering the tooltip, it's more efficient to use the {@link #getPointsLength()} method instead.
     *
     * @return A Point instance that is connected to the Highcharts data point associated with the tooltip.
     * @since 1.1.3
     */
    public Point[] getPoints() {
        JsArray<JavaScriptObject> nativePoints = getNativePoints();
        Point[] points = new Point[nativePoints.length()];
        for (int i = 0; i < nativePoints.length(); i++) {
            points[i] = new Point(getNativePointFromReference(nativePoints.get(i)));
        }
        return points;
    }

    /**
     * For shared tool tips only, returns the number of points that are available in the collection
     * of data points that were passed to the tooltip (which should reflect the number of series
     * in the chart.)
     *
     * @return The number of points available as data to the tool tip
     */
    public int getPointsLength() {
        return getNativePoints().length();
    }

    private native JavaScriptObject getNativePoint() /*-{
        return this.@org.moxieapps.gwt.highcharts.client.ToolTipData::data.point;
    }-*/;

    private native JsArray<JavaScriptObject> getNativePoints() /*-{
        return this.@org.moxieapps.gwt.highcharts.client.ToolTipData::data.points;
    }-*/;

    private native JavaScriptObject getNativePointFromReference(JavaScriptObject reference) /*-{
        return reference.point;
    }-*/;

    /**
     * Return the name of the point (e.g. "point.name").
     *
     * @return The name of the point that the tooltip is over.
     */
    public native String getPointName() /*-{
        return this.@org.moxieapps.gwt.highcharts.client.ToolTipData::data.point.name;
    }-*/;

    /**
     * Return the name of the point (e.g. "point[i].name") at the given index (for shared tooltips).
     *
     * @param index The index of the point in the array to retrieve the name from.
     * @return The name of the point at the given index that the tooltip is over.
     * @since 1.1.3
     */
    public native String getPointName(int index) /*-{
        return this.@org.moxieapps.gwt.highcharts.client.ToolTipData::data.points[index].point.name;
    }-*/;

    /**
     * Return the total value at this point's x value.  Stacked series only.
     *
     * @return The total value at this point's x value (only applicable in stacked series).
     */
    public native double getTotal() /*-{
        return this.@org.moxieapps.gwt.highcharts.client.ToolTipData::data.total;
    }-*/;

    /**
     * Return the total value at a point at a given index's x value (for shared tooltips).  Stacked series only.
     *
     * @param index The index of the point in the array to retrieve the value from.
     * @return The total value at the given indexed point's x value (only applicable in stacked series).
     * @since 1.1.3
     */
    public native double getTotal(int index) /*-{
        return this.@org.moxieapps.gwt.highcharts.client.ToolTipData::data.points[index].total;
    }-*/;

    /**
     * Return the total value at this point's x value as a long.  Stacked series only.
     *
     * @return Return the total value at this point's x value as a long.
     */
    public long getTotalAsLong() {
        return ((Double) getTotal()).longValue();
    }

    /**
     * Return the total value at a point at a given index's x value as a long (for shared tooltips).
     * Stacked series only.
     *
     * @param index The index of the point in the array to retrieve the value from.
     * @return Return the total value at the given indexed point's x value as a long.
     * @since 1.1.3
     */
    public long getTotalAsLong(int index) {
        return ((Double) getTotal(index)).longValue();
    }

    /**
     * Return the x value of the point as a double.  An exception will be thrown
     * if the native value of the object is not a number.
     *
     * @return The x value of the point as a double.
     */
    public native double getXAsDouble() /*-{
        return this.@org.moxieapps.gwt.highcharts.client.ToolTipData::data.x;
    }-*/;

    /**
     * Return the x value of the point at the given index as a double.  An exception will be thrown
     * if the native value of the object is not a number. (For shared tool tips.)
     *
     * @param index The index of the point in the array to retrieve the value from.
     * @return The x value of the point at the given index as a double.
     * @since 1.1.3
     */
    public native double getXAsDouble(int index) /*-{
        return this.@org.moxieapps.gwt.highcharts.client.ToolTipData::data.points[index].x;
    }-*/;

    /**
     * Return the x value of the point as a long.  An exception will be thrown
     * if the native value of the object is not a number.
     *
     * @return The x value of the point as a long.
     */
    public long getXAsLong() {
        return ((Double) getXAsDouble()).longValue();
    }
    /**
     *
     * Return the x value of the point at the given index as a long.  An exception will be thrown
     * if the native value of the object is not a number. (For shared tool tips.)
     *
     * @param index The index of the point in the array to retrieve the value from.
     * @return The x value of the point at the given index as a long.
     * @since 1.1.3
     */
    public long getXAsLong(int index) {
        return ((Double) getXAsDouble(index)).longValue();
    }

    /**
     * Return the x value of the point as a string.  An exception will be thrown
     * if the native value of the object is not a string.
     *
     * @return The x value of the point as a string.
     */
    public native String getXAsString() /*-{
        return this.@org.moxieapps.gwt.highcharts.client.ToolTipData::data.x;
    }-*/;

    /**
     * Return the x value of the point at the given index as a string.  An exception will be thrown
     * if the native value of the object is not a string.  (For shared tool tips.)
     *
     * @param index The index of the point in the array to retrieve the value from.
     * @return The x value of the point at the given index as a string.
     * @since 1.1.3
     */
    public native String getXAsString(int index) /*-{
        return this.@org.moxieapps.gwt.highcharts.client.ToolTipData::data.points[index].x;
    }-*/;

    /**
     * Return the y value of the point as a double.  An exception will be thrown
     * if the native value of the object is not a number.
     *
     * @return The y value of the point as a double.
     */
    public native double getYAsDouble() /*-{
        return this.@org.moxieapps.gwt.highcharts.client.ToolTipData::data.y;
    }-*/;

    /**
     * Return the y value of the point as a double given the index of a specific
     * point to retrieve (shared tooltips only).  An exception will be thrown
     * if the native value of the object is not a number.
     *
     * @param index The index of the point in the array to retrieve.
     * @return The y value of the point as a double.
     * @since 1.1.3
     */
    public native double getYAsDouble(int index) /*-{
        return this.@org.moxieapps.gwt.highcharts.client.ToolTipData::data.points[index].y;
    }-*/;

    /**
     * Return the y value of the point as a long.  An exception will be thrown
     * if the native value of the object is not a number.
     *
     * @return The y value of the point as a long.
     */
    public long getYAsLong() {
        return ((Double) getYAsDouble()).longValue();
    }

    /**
     * Return the y value of the point at a given index as a long.  An exception will be thrown
     * if the native value of the object is not a number. (For shared tooltips only.)
     *
     * @param index The index of the point in the array to retrieve.
     * @return The y value of the point as a long.
     * @since 1.1.3
     */
    public long getYAsLong(int index) {
        return ((Double) getYAsDouble(index)).longValue();
    }

    /**
     * Return the y value of the point as a string.  An exception will be thrown
     * if the native value of the object is not a string.
     *
     * @return The y value of the point as a string.
     */
    public native String getYAsString() /*-{
        return this.@org.moxieapps.gwt.highcharts.client.ToolTipData::data.y;
    }-*/;

    /**
     * Return the y value of the point at a given index as a string.  An exception will be thrown
     * if the native value of the object is not a string.  (For shared tooltips only.)
     *
     * @param index The index of the point in the array to retrieve.
     * @return The y value of the point at the given index as a string.
     * @since 1.1.3
     */
    public native String getYAsString(int index) /*-{
        return this.@org.moxieapps.gwt.highcharts.client.ToolTipData::data.points[index].y;
    }-*/;

}
