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
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.json.client.JSONArray;
import org.moxieapps.gwt.highcharts.client.labels.XAxisLabels;

/**
 * Provides access to an object that can abe used to configure and manage the x-axis of the chart.
 * Note that you can not instance an instance of this object directly, and instead should use the
 * {@link Chart#getXAxis()} method to gain a reference to this
 * object.  Example usage:
 * <pre><code>
 * XAxis xAxis = chart.getXAxis()
 *    .setType(Axis.Type.DATE_TIME)
 *    .setStartOfWeek(Axis.WeekDay.SUNDAY)
 *    .setAxisTitleText("Year")
 *    .setAlternateGridColor("#CCCCCC");
 * </code></pre>
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.0.0
 */
public class XAxis extends Axis<XAxis> {

    /**
     * An enumeration of supported tickmark placements for when categories are in use, which can be passed to
     * the {@link XAxis#setTickmarkPlacement(XAxis.TickmarkPlacement)} method.
     */
    public enum TickmarkPlacement {

        /**
         * Display the tick marks in the center of the category.
         */
        ON("on"),

        /**
         * Display the tick marks between categories.
         */
        BETWEEN("between");

        private TickmarkPlacement(String optionValue) {
            this.optionvalue = optionValue;
        }

        private final String optionvalue;

        public String toString() {
            return optionvalue;
        }

    }

    /**
     * Use the {@link Chart#getXAxis()} method to get access to the XAxis of the chart.
     *
     * @param chart The chart instance that this axis is being created within.
     */
    XAxis(BaseChart chart) {
        super(chart);
    }

    /**
     * Sets category names to use for the xAxis (instead of using numbers).  If categories are present for the
     * xAxis, names are used instead of numbers for that axis. Example: setCategories("Apples", "Bananas", "Oranges").
     * Defaults to an empty array, which will use numbers for the categories instead of names when categories
     * are present.
     * <p/>
     * Note that this method will automatically redraw the categories on the chart if invoked after the
     * chart has been rendered.  For more control over when the categories are redrawn, you can utilize
     * the {@link #setCategories(boolean, String...)} method instead.
     *
     * @param categories An array of category names to use for the axis.
     * @return A reference to this {@link XAxis} instance for convenient method chaining.
     */
    public XAxis setCategories(String... categories) {
        return this.setCategories(true, categories);
    }

    /**
     * Sets category names to use for the xAxis (instead of using numbers), explicitly controlling whether
     * or not the axis will be redrawn in the case that the chart has already been rendered to the DOM.
     * If categories are present for the xAxis, names are used instead of numbers for that axis.
     * Example: setCategories("Apples", "Bananas", "Oranges"). Defaults to an empty array, which will
     * use numbers for the categories instead of names when categories are present.
     * <p/>
     *
     * @param redraw     Whether to redraw the axis or wait for an explicit call to {@link org.moxieapps.gwt.highcharts.client.BaseChart#redraw()}
     * @param categories An array of category names to use for the axis.
     * @return A reference to this {@link XAxis} instance for convenient method chaining.
     * @since 1.1.1
     */
    public XAxis setCategories(boolean redraw, String... categories) {
        final JavaScriptObject nativeAxis = getNativeAxis();
        if (nativeAxis != null) {
            JsArrayString jsArray = JavaScriptObject.createArray().<JsArrayString>cast();
            for (int i = 0; i < categories.length; i++) {
                String category = categories[i];
                jsArray.set(i, category);
            }
            nativeSetCategories(nativeAxis, jsArray, redraw);
            return this;
        } else {
            return this.setOption("categories", categories);
        }
    }

    private XAxisLabels xAxisLabels;

    /**
     * Convenience method for setting the 'labels' options of the axis.  Equivalent to code like:
     * <pre><code>
     *     axis.setOption("/labels/align", Labels.Align.LEFT);
     *     axis.setOption("/labels/enabled", true);
     *     etc...
     * </code></pre>
     * Configuration object for the axis labels, usually displaying the number for each tick.
     * Example usage:
     * <code><pre>
     *   axis.setLabels(
     *     new XAxisLabels()
     *       .setAlign(Labels.Align.LEFT)
     *       .setEnabled(true)
     *   );
     * </pre></code>
     *
     * @param labels The configuration object for the axis labels, or null to use the defaults.
     * @return A reference to this {@link XAxis} instance for convenient method chaining.
     */
    public XAxis setLabels(XAxisLabels labels) {
        this.xAxisLabels = labels;
        return this.setOption("labels", labels != null ? labels.getOptions() : null);
    }

    // Purposefully restricted to package scope
    XAxisLabels getLabels() {
        return xAxisLabels;
    }

    /**
     * Convenience method for setting the 'tickmarkPlacement' option for the axis.  Equivalent to:
     * <pre><code>
     *     labels.setOption("tickmarkPlacement", TickmarkPlacement.ON);
     * </code></pre>
     * For categorized axes only. If {@link XAxis.TickmarkPlacement#ON} the tick mark is placed in the center of the category,
     * if {@link XAxis.TickmarkPlacement#BETWEEN} the tick mark is placed between categories. Defaults to {@link XAxis.TickmarkPlacement#BETWEEN}.
     *
     * @param tickmarkPlacement Whether or not to place the tickmark in the center or between categories.
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     */
    public XAxis setTickmarkPlacement(TickmarkPlacement tickmarkPlacement) {
        return this.setOption("tickmarkPlacement", tickmarkPlacement != null ? tickmarkPlacement.toString() : null);
    }

    private static native void nativeSetCategories(JavaScriptObject nativeAxis, JsArrayString categories, boolean redraw) /*-{
        return nativeAxis.setCategories(categories, redraw);
    }-*/;


}
