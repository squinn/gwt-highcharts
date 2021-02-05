/*
 * Copyright 2013 Moxie Group
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

package org.moxieapps.gwt.highcharts.client.plotOptions;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONString;
import org.moxieapps.gwt.highcharts.client.Color;
import org.moxieapps.gwt.highcharts.client.events.PointLegendItemClickEventHandler;

/**
 * A common base class for both {@link FunnelPlotOptions} and {@link PiePlotOptions} to prevent code duplication
 * while still maintaining a cleaner way for the user to utilize the method chaining with the generics
 * in place.  You should not use this class directly, but instead use one of the base classes.
 *
 * @author cskowron@moxiegroup.com (Cory Skowronek)
 * @since 1.6.0
 */
public abstract class BaseProportionalPlotOptions<T extends BaseProportionalPlotOptions> extends PlotOptions<T> {

    /**
     * Convenience method for setting the "borderColor" option for the pie plot options to a RGB hex value.  Equivalent to:
     * <pre><code>
     *     piePlotOptions.setOption("borderColor", "#CCCCCC");
     * </code></pre>
     * The color of the border surrounding each slice. Defaults to #FFFFFF.
     * <p/>
     * Note that this method is intended for setting the color to a simple RBG hex value.  If you instead
     * want to set a color to include an alpha channel or a gradient, use the {@link #setBorderColor(Color)}
     * version instead.
     * @param borderColor The value to set as the 'borderColor' option of the box plots.
     * @return A reference to this {@link BaseProportionalPlotOptions} instance for convenient method chaining.
     * @see #setBorderColor(Color)
     */
    public T setBorderColor(String borderColor) {
        return this.setOption("borderColor", borderColor);
    }

    /**
     * Convenience method for setting the 'borderColor' option of the pie plot options, allowing for
     * colors with opacity or gradients.  Equivalent to:
     * <pre><code>
     *     piePlotOptions.setOption("borderColor", new Color()
     *        .setLinearGradient(0.0, 0.0, 1.0, 1.0)
     *        .addStop(new Color(255, 255, 255))
     *        .addStop(new Color(200, 200, 255))
     *     );
     * </code></pre>
     * The color of the border surrounding each slice. Defaults to #FFFFFF.
     * <p/>
     * Note that this method is intended for setting the color to a gradient or color that includes
     * an alpha channel.  If you instead just want to set the color to a normal RGB hex value
     * you can use the {@link #setBorderColor(String)} version instead.
     * @param borderColor The color gradient or color with an alpha channel to set as the 'borderColor' option of the box plot.
     * @return A reference to this {@link BaseProportionalPlotOptions} instance for convenient method chaining.
     * @see #setBorderColor(String)
     */
    public T setBorderColor(Color borderColor) {
        return this.setOption("borderCcolor", borderColor != null ? borderColor.getOptionValue() : null);
    }

    /**
     * Convenience method for setting the "borderWidth" option for the pie plot options.  Equivalent to:
     * <pre><code>
     *     piePlotOptions.setOptions("borderWidth", 2);
     * </code></pre>
     * The width of the border surrounding each slice. Defaults to 1.
     * @param borderWidth The width of the border
     * @return A reference to this {@link BaseProportionalPlotOptions} instance for convenient method chaining.
     */
    public T setBorderWidth(Number borderWidth) {
        return this.setOption("borderWidth", borderWidth);
    }

    /**
     * Convenience method for setting the 'center' option of the pie plot options
     * to pixel values.  Equivalent to:
     * <pre><code>
     *     piePlotOptions.setOption("center", new Number[] { 100, 120 });
     * </code></pre>
     * The center of the pie chart relative to the plot area (in pixels).  See the
     * {@link #setCenter(double, double)} method to set the center using percentages instead.
     * Defaults to 50%, 50%.
     *
     * @param x The horizontal center of the pie chart relative to the plot area (in pixels)
     * @param y The vertical center of the pie chart relative to the plot area (in pixels)
     * @return A reference to this {@link BaseProportionalPlotOptions} instance for convenient method chaining.
     */
    public T setCenter(int x, int y) {
        JSONArray center = new JSONArray();
        center.set(0, new JSONNumber(x));
        center.set(1, new JSONNumber(y));
        return this.setOption("center", center);
    }

    /**
     * Convenience method for setting the 'center' option of the pie plot options
     * to percentage values.  Equivalent to:
     * <pre><code>
     *     piePlotOptions.setOption("center", new String[] { "50%", "40%" });
     * </code></pre>
     * The center of the pie chart relative to the plot area (as a percentage).  See the
     * {@link #setCenter(int, int)} method to set the center using pixels instead.
     * Defaults to 50%, 50%.
     * <p/>
     * Note that the percentage is specified by providing a floating point number in the
     * range of 0.0 to 1.0, where 0.0 is equivalent to "0%" and 1.0 is equivalent to "100%".
     *
     * @param xPercent The horizontal percent center of the pie chart relative to the plot area (0.0 to 1.0)
     * @param yPercent The vertical percent center of the pie chart relative to the plot area (0.0 to 1.0)
     * @return A reference to this {@link BaseProportionalPlotOptions} instance for convenient method chaining.
     */
    public T setCenter(double xPercent, double yPercent) {
        JSONArray center = new JSONArray();
        center.set(0, new JSONString(((Double) (xPercent * 100)).intValue() + "%"));
        center.set(1, new JSONString(((Double) (yPercent * 100)).intValue() + "%"));
        return this.setOption("center", center);
    }

    /**
     * Convenience method for setting the 'depth option of the plot.  Equivalent to:
     * <pre><code>
     *     piePlotOptions.setOption("depth", 25);
     * </code></pre>
     * The thickness of a 3D pie. Defaults to 0.
     * Note: This option requires highcharts-3d.js
     * @param depth The thickness of a 3D pie.
     * @return  A reference to this {@link BaseProportionalPlotOptions} instance for convenient method chaining.
     */
    public T setDepth(Number depth) {
        return this.setOption("depth", depth);
    }

    /**
     * Convenience method for setting the "ignoreHiddenPoint" option for the pie plot options.  Equivalent to:
     * <pre><code>
     *     piePlotOptions.setOptions("ignoreHiddenPoint", false);
     * </code></pre>
     * Equivalent to {@link org.moxieapps.gwt.highcharts.client.BaseChart#setIgnoreHiddenSeries(boolean)}, this option tells whether the series shall be redrawn as if the hidden point were null.
     * <p/>
     * The default value changed from false to true with Highcharts 3.0.
     * <p/>
     * Defaults to true.
     * @param ignoreHiddenPoint Whether to redraw the chart if a hidden point is null.
     * @return A reference to this {@link BaseProportionalPlotOptions} instance for convenient method chaining.
     * @since 1.6.0
     */
    public T setIgnoreHiddenPoint(boolean ignoreHiddenPoint) {
        return this.setOption("ignoreHiddenPoint", ignoreHiddenPoint);
    }

    /**
     * Convenience method for setting the 'innerSize' option of the pie plot options
     * to pixel values.  Equivalent to:
     * <pre><code>
     *     piePlotOptions.setOption("innerSize", 100);
     * </code></pre>
     * The size of the inner diameter for the pie. A size greater than 0 renders a donut chart.
     * {@link #setInnerSize(double)} method to set the innerSize using percentages instead.
     * Defaults to 0.
     *
     * @param innerSize The size of the inner diameter for the pie.
     * @return A reference to this {@link BaseProportionalPlotOptions} instance for convenient method chaining.
     */
    public T setInnerSize(int innerSize) {
        return this.setOption("innerSize", innerSize);
    }

    /**
     * Convenience method for setting the 'innerSize' option of the pie plot options
     * to a percentage value.  Equivalent to:
     * <pre><code>
     *     piePlotOptions.setOption("innerSize", "50%");
     * </code></pre>
     * The size of the inner diameter for the pie. A size greater than 0 renders a donut chart.
     * See the {@link #setInnerSize(int)} method to set the innerSize using pixels instead.
     * Defaults to 0.
     * <p/>
     * Note that the percentage is specified by providing a floating point number in the
     * range of 0.0 to 1.0, where 0.0 is equivalent to "0%" and 1.0 is equivalent to "100%".
     *
     * @param innerSize The percentage size of the inner diameter for the pie. (0.0 to 1.0)
     * @return A reference to this {@link BaseProportionalPlotOptions} instance for convenient method chaining.
     */
    public T setInnerSize(double innerSize) {
        return this.setOption("innerSize", new JSONString(((Double) (innerSize * 100)).intValue() + "%"));
    }

    /**
     * Convenience method for setting the "minSize" option for the pie plot options.  Equivalent to:
     * <pre><code>
     *     piePlotOptions.setOptions("minSize", true);
     * </code></pre>
     * The minimum size for a pie in response to auto margins. The pie will try to shrink to make room
     * for data labels in side the plot area, but only to this size. Defaults to 80.
     * @param minSize The minimum size for a pie in response to auto margins
     * @return A reference to this {@link BaseProportionalPlotOptions} instance for convenient method chaining.
     * @since 1.6.0
     */
    public T setMinSize(Number minSize) {
        return this.setOption("minSize", minSize);
    }

    /**
     * Convenience method for setting the 'size' option of the pie plot options
     * to pixel values.  Equivalent to:
     * <pre><code>
     *     piePlotOptions.setOption("size", 100);
     * </code></pre>
     * The diameter of the pie relative to the plot area (in pixels).  See the
     * {@link #setSize(double)} method to set the size using percentages instead.
     * Defaults to 75%.
     *
     * @param size The diameter of the pie relative to the plot area.
     * @return A reference to this {@link BaseProportionalPlotOptions} instance for convenient method chaining.
     */
    public T setSize(int size) {
        return this.setOption("size", size);
    }

    /**
     * Convenience method for setting the 'size' option of the pie plot options
     * to a percentage value.  Equivalent to:
     * <pre><code>
     *     piePlotOptions.setOption("size", "50%");
     * </code></pre>
     * The diameter of the pie relative to the plot area (as a percentage).  See the
     * {@link #setSize(int)} method to set the size using pixels instead.
     * Defaults to 75%.
     * <p/>
     * Note that the percentage is specified by providing a floating point number in the
     * range of 0.0 to 1.0, where 0.0 is equivalent to "0%" and 1.0 is equivalent to "100%".
     *
     * @param size The percent diameter of the pie relative to the plot area. (0.0 to 1.0)
     * @return A reference to this {@link BaseProportionalPlotOptions} instance for convenient method chaining.
     */
    public T setSize(double size) {
        return this.setOption("size", new JSONString(((Double) (size * 100)).intValue() + "%"));
    }

    /**
     * Convenience method for setting the "slicedOffset" option for the pie plot options.  Equivalent to:
     * <pre><code>
     *     piePlotOptions.setOptions("slicedOffset", 25);
     * </code></pre>
     * If a point is sliced, moved out from the center, how many pixels should it be moved?. Defaults to 10.
     * @param slicedOffset The number of pixels the point should be moved if it is sliced.
     * @return A reference to this {@link BaseProportionalPlotOptions} instance for convenient method chaining.
     * @since 1.6.0
     */
    public T setSlicedOffset(Number slicedOffset) {
        return this.setOption("slicedOffset", slicedOffset);
    }

    /**
     * Convenience method for setting the "startAngle" option for the pie plot options.  Equivalent to:
     * <pre><code>
     *     piePlotOptions.setOptions("startAngle", 45);
     * </code></pre>
     * The start angle of the pie slices in degrees where 0 is top and 90 right. Defaults to 0.
     * @param startAngle The start angle of the pie slices in degrees where 0 is top and 90 right
     * @return A reference to this {@link BaseProportionalPlotOptions} instance for convenient method chaining.
     * @since 1.6.0
     */
    public T setStartAngle(Number startAngle) {
        return this.setOption("startAngle", startAngle);
    }

    private PointLegendItemClickEventHandler pointLegendItemClickEventHandler;

    /**
     * Set a callback handler that will be invoked whenever the user clicks on the legend item points
     * in a pie or funnel series.   Additional information about the click (such as the values of the point clicked) can be
     * found via the {@link org.moxieapps.gwt.highcharts.client.events.PointLegendItemClickEventHandler} instance
     * that is passed to the handler's {@link PointLegendItemClickEventHandler#onClick(org.moxieapps.gwt.highcharts.client.events.PointLegendItemClickEvent)} method.
     *
     * @param pointLegendItemClickEventHandler The handler that should be invoked whenever a legend item click event occurs.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.BaseChart} instance for convenient method chaining.
     */
    public BaseProportionalPlotOptions setPointLegendItemClickEventHandler(PointLegendItemClickEventHandler pointLegendItemClickEventHandler) {
        this.pointLegendItemClickEventHandler = pointLegendItemClickEventHandler;
        return this;
    }

    /**
     * Returns the custom event handler that has been set on the plot options, or null if no event
     * handler has been set.
     *
     * @return The custom event handler that has been applied, or null if it has not been set.
     */
    public PointLegendItemClickEventHandler getPointLegendItemClickEventHandler() {
        return this.pointLegendItemClickEventHandler;
    }
}
