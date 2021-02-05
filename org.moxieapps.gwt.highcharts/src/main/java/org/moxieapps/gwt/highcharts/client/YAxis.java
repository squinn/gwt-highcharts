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
import com.google.gwt.core.client.JsArrayString;
import org.moxieapps.gwt.highcharts.client.labels.StackLabels;
import org.moxieapps.gwt.highcharts.client.labels.YAxisLabels;

/**
 * Provides access to an object that can abe used to configure and manage the y-axis of the chart.
 * Note that you can not instance an instance of this object directly, and instead should use the
 * {@link Chart#getYAxis()} method to gain a reference to this
 * object.  Example usage:
 * <pre><code>
 * chart.getYAxis()
 *    .setType(Axis.Type.LINEAR)
 *    .setAxisTitleText("Sales")
 *    .setLineWidth(3);
 * </code></pre>
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.0.0
 */
public class YAxis extends Axis<YAxis> {

    /**
     * Use the {@link Chart#getYAxis()} method to get access to the YAxis of the chart.
     *
     * @param chart The chart instance that this axis is being created within.
     */
    YAxis(BaseChart chart) {
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
    public YAxis setCategories(String... categories) {
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
    public YAxis setCategories(boolean redraw, String... categories) {
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

    /**
     * Convenience method for setting the 'top' option of the axis.  Equivalent to:
     * <pre><code>
     *     axis.setOption("top", 300);
     * </code></pre>
     * The maximum value of the axis
     * @param height The height of the axis.
     * @return A reference to this {@link YAxis} instance for convenient method chaining.
     * @since 1.6.0
     */
    public YAxis setHeight(Number height) {
        return this.setOption("height", height);
    }

    /**
     * Convenience method for setting the 'top' option of the axis. Equivalent to:
     * <pre><code>
     *     axis.setOption("top", 300);
     * </code></pre>
     * The top pixel position of the Y axis relative to the chart. Defaults to null.
     * Note that this option is a fixed value and does not support setting the top of the
     * axis as a percentage of the pane.
     * @param top The top value of the axis.
     * @return A reference to this {@link YAxis} instance for convenient method chaining.
     * @since 1.6.0
     */
    public YAxis setTop(Number top) {
        return this.setOption("top", top);
    }

    private YAxisLabels yAxisLabels;

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
     * @return A reference to this {@link YAxis} instance for convenient method chaining.
     */
    public YAxis setLabels(YAxisLabels labels) {
        this.yAxisLabels = labels;
        return this.setOption("labels", labels != null ? labels.getOptions() : null);
    }

    // Purposefully restricted to package scope
    YAxisLabels getLabels() {
        return yAxisLabels;
    }

    private StackLabels stackLabels;

    /**
     * Convenience method for setting the 'stackLabels' options of the axis.  Equivalent to code like:
     * <pre><code>
     *     axis.setOption("/stackLabels/align", Labels.Align.LEFT);
     *     axis.setOption("/stackLabels/enabled", true);
     *     etc...
     * </code></pre>
     * The stack labels show the total value for each bar in a stacked column or bar chart. The label
     * will be placed on top of positive columns and below negative columns. In case of an inverted
     * column chart or a bar chart the label is placed to the right of positive bars and to the left
     * of negative bars.
     * <p/>
     * Example usage:
     * <code><pre>
     *   axis.setStackLabels(
     *     new StackLabels()
     *       .setAlign(Labels.Align.LEFT)
     *       .setEnabled(true)
     *   );
     * </pre></code>
     *
     * @param stackLabels The configuration object for the axis stack labels, or null to use the defaults.
     * @return A reference to this {@link YAxis} instance for convenient method chaining.
     */
    public YAxis setStackLabels(StackLabels stackLabels) {
        this.stackLabels = stackLabels;
        return this.setOption("stackLabels", stackLabels != null ? stackLabels.getOptions() : null);
    }

    // Purposefully restricted to package scope
    StackLabels getStackLabels() {
        return stackLabels;
    }

    private static native void nativeSetCategories(JavaScriptObject nativeAxis, JsArrayString categories, boolean redraw) /*-{
        return nativeAxis.setCategories(categories, redraw);
    }-*/;
}
