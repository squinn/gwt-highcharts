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
 * {@link LegendLabelsFormatter} to allow for custom strings to be rendered as the legend
 * labels.
 * <p/>
 * See the {@link LegendLabelsFormatter#format(LegendLabelsData)} method for more details on the capabilities
 * that custom formatters can provide.
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.3.0
 */
public class LegendLabelsData {

    @SuppressWarnings({"FieldCanBeLocal"})
    private JavaScriptObject data;

    /**
     * This constructor needs to be public scope but you should not construct this object directly, but
     * instead simply implement a custom {@link LegendLabelsFormatter} and this API will pass you the
     * appropriate instance of this object at runtime.
     *
     * @param data A reference to the native Highcharts javascript object.
     */
    public LegendLabelsData(JavaScriptObject data) {
        this.data = data;
    }

    /**
     * Retrieve the unique id of the series that the point is a part of which received the event.
     * This id can then be used to obtain the Series instance itself via the
     * {@link org.moxieapps.gwt.highcharts.client.BaseChart#getSeries(String)} method.
     *
     * @return The unique id of the series that the point was a part of that the event was triggered on.
     */
    public native String getSeriesId() /*-{
        return this.@org.moxieapps.gwt.highcharts.client.labels.LegendLabelsData::data.options.id;
    }-*/;

    /**
     * Return the name of the series that the legend label applies to (e.g. "series.name").
     *
     * @return The name of the series that the legend label applies to
     */
    public native String getSeriesName() /*-{
        return this.@org.moxieapps.gwt.highcharts.client.labels.LegendLabelsData::data.name;
    }-*/;

    /**
     * For pie charts, return the name of the point (e.g. "point.name") that the legend
     * label is associated with.
     *
     * @return The name of the point that the legend label is associated with.
     */
    public native String getPointName() /*-{
        return this.@org.moxieapps.gwt.highcharts.client.labels.LegendLabelsData::data.name;
    }-*/;

    /**
     * For pie charts, return a GWT point instance that is connected to the Highcharts JS
     * point instance associated with the legend label.
     *
     * @return A Point instance that is connected to the Highcharts data point associated with the legend label
     */
    public Point getPoint() {
        return new Point(data);
    }

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
