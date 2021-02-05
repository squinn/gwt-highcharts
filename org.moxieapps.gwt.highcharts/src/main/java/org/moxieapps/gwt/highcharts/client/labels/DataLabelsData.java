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

package org.moxieapps.gwt.highcharts.client.labels;

import com.google.gwt.core.client.JavaScriptObject;
import org.moxieapps.gwt.highcharts.client.Point;

/**
 * An object that represents the state information that will be passed to any custom
 * {@link DataLabelsFormatter} to allow for custom strings to be rendered as the data labels of a series.
 * See the {@link DataLabelsFormatter#format(DataLabelsData)} method for more details on the capabilities
 * that custom formatters can provide.
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.0.0
 */
public class DataLabelsData {

    @SuppressWarnings({"FieldCanBeLocal"})
    private JavaScriptObject data;

    /**
     * This constructor needs to be public scope but you should not construct this object directly, but
     * instead simply implement a custom {@link DataLabelsFormatter} and this API will pass you the
     * appropriate instance of this object at runtime.
     *
     * @param data A reference to the native Highcharts javascript object.
     */
    public DataLabelsData(JavaScriptObject data) {
        this.data = data;
    }

    /**
     * Return the point's percentage of the total.  Stacked series and pies only.
     *
     * @return The percentage value of the total.
     */
    public native double getPercentage() /*-{
        return this.@org.moxieapps.gwt.highcharts.client.labels.DataLabelsData::data.percentage;
    }-*/;

    /**
     * Return the name of the series that the data label is a part of (e.g. "series.name").
     *
     * @return The name of the series that the data label is a part of
     */
    public native String getSeriesName() /*-{
        return this.@org.moxieapps.gwt.highcharts.client.labels.DataLabelsData::data.series.name;
    }-*/;

    /**
     * Return the name of the point (e.g. "point.name") that the data label is associated with.
     *
     * @return The name of the point that the data label is associated with.
     */
    public native String getPointName() /*-{
        return this.@org.moxieapps.gwt.highcharts.client.labels.DataLabelsData::data.point.name;
    }-*/;

    /**
     * Create a new GWT point instance that is connected to the Highcharts JS point instance associated
     * with this data label.
     *
     * @return A Point instance that is connected to the Highcharts data point associated with the data label.
     * @since 1.4.0
     */
    public Point getPoint() {
        return new Point(getNativePoint());
    }

    private native JavaScriptObject getNativePoint() /*-{
        return this.@org.moxieapps.gwt.highcharts.client.labels.DataLabelsData::data.point;
    }-*/;
    
    /**
     * Return the total value at this point's x value.  Stacked series only.
     *
     * @return The total value at this point's x value (only applicable in stacked series).
     */
    public native double getTotal() /*-{
        return this.@org.moxieapps.gwt.highcharts.client.labels.DataLabelsData::data.total;
    }-*/;

    /**
     * Return the total value at this point's x value as a long.  Stacked series only.
     *
     * @return Return the total value at this point's x value as a long.
     */
    public long getTotalAsLong() {
        return ((Double)getTotal()).longValue();
    }

    /**
     * Returns 'true' if the X value associated with this data label is non null.  This method
     * is useful when rendering data labels in a chart that may contain null point values.
     *
     * @return 'true' if the X value is non null, 'false' otherwise.
     * @since 1.1.3
     */
    public native boolean hasXValue() /*-{
        return this.@org.moxieapps.gwt.highcharts.client.labels.DataLabelsData::data.x != null;
    }-*/;

    /**
     * Return the x value of the point as a double.  An exception will be thrown
     * if the native value of the object is not a number.
     *
     * @return The x value of the point as a double.
     */
    public native double getXAsDouble() /*-{
        return this.@org.moxieapps.gwt.highcharts.client.labels.DataLabelsData::data.x;
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
        return this.@org.moxieapps.gwt.highcharts.client.labels.DataLabelsData::data.x;
    }-*/;

    /**
     * Returns 'true' if the Y value associated with this data label is non null.  This method
     * is useful when rendering data labels in a chart that may contain null point values.
     *
     * @return 'true' if the Y value is non null, 'false' otherwise.
     * @since 1.1.3
     */
    public native boolean hasYValue() /*-{
        return this.@org.moxieapps.gwt.highcharts.client.labels.DataLabelsData::data.y != null;
    }-*/;

    /**
     * Return the y value of the point as a double.  An exception will be thrown
     * if the native value of the object is not a number.
     *
     * @return The y value of the point as a double.
     */
    public native double getYAsDouble() /*-{
        return this.@org.moxieapps.gwt.highcharts.client.labels.DataLabelsData::data.y;
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
        return this.@org.moxieapps.gwt.highcharts.client.labels.DataLabelsData::data.y;
    }-*/;

    /**
     * Returns a pointer to the native Highchart's instance data object that this GWT
     * instance is wrapping.  For advanced JSNI use-cases only.
     *
     * @return The native Highcharts object instance that this GWT instance is associated with.
     * @since 1.5.0
     */
    public JavaScriptObject getNativeData() {
        return this.data;
    }

}
