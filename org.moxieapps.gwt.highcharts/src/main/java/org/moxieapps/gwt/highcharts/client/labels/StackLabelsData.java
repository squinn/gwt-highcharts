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

/**
 * An object that represents the state information that will be passed to any custom
 * {@link StackLabelsFormatter} to allow for custom strings to be rendered as the stack labels on a Y axis.
 * See the {@link StackLabelsFormatter#format(StackLabelsData)} method for more details on the capabilities
 * that custom formatters can provide.
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.0.0
 */
public class StackLabelsData {

    @SuppressWarnings({"FieldCanBeLocal"})
    private JavaScriptObject data;

    /**
     * This constructor needs to be public scope but you should not construct this object directly, but
     * instead simply implement a custom {@link StackLabelsFormatter} and this API will pass you the
     * appropriate instance of this object at runtime.
     *
     * @param data A reference to the native Highcharts javascript object.
     */
    public StackLabelsData(JavaScriptObject data) {
        this.data = data;
    }

    /**
     * Return the total value at this point's x value.  Stacked series only.
     *
     * @return The total value at this point's x value (only applicable in stacked series).
     */
    public native double getTotal() /*-{
        return this.@org.moxieapps.gwt.highcharts.client.labels.StackLabelsData::data.total;
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
