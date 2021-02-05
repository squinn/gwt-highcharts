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

import com.google.gwt.dom.client.Document;
import org.moxieapps.gwt.highcharts.client.labels.PlotLineLabel;

/**
 * A configurable class that can be used to represent plot lines on an axis of the chart, which can
 * then be set on an axis (via the {@link Axis#setPlotLines(PlotLine...)} method.)
 * Note that a plot line is a line stretching across the plot area, marking a specific value on one of the axes.
 * Example usage:
 * <code><pre>
 *   XAxis xAxis = chart.getXAxis();
 *   xAxis.setPlotLines(
 *     xAxis.createPlotLine()
 *        .setColor("#CC0000")
 *        .setValue(40),
 *     xAxis.createPlotLine()
 *        .setColor("#009900")
 *        .setValue(60)
 *   );
 * </pre></code>
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.0.0
 */
public class PlotLine extends Configurable<PlotLine> {

    /**
     * An enumeration of supported dash style types, which can be passed to the
     * {@link #setDashStyle(DashStyle)} method.  See this
     * <a href="http://jsfiddle.net/cSrgA/">demonstration</a> for a visible reference
     * of the available dash styles.
     */
    public enum DashStyle {

        /**
         * Solid line, no dashes
         */
        SOLID("Solid"),

        /**
         * Short dashes, "- - - -"
         */
        SHORT_DASH("ShortDash"),

        /**
         * Short (tightly spaced) dots, ". . . ."
         */
        SHORT_DOT("ShortDot"),

        /**
         * Short (tightly spaced) dash and dots, "- . - . - ."
         */
        SHORT_DASH_DOT("ShortDashDot"),

        /**
         * Short (tightly spaced) dash and two dots, "- . . - . . - . ."
         */
        SHORT_DASH_DOT_DOT("ShortDashDotDot"),

        /**
         * Large (widely spaced) dots, ".  .  .  .  ."
         */
        DOT("Dot"),

        /**
         * Medium size dashes, "-- -- -- --"
         */
        DASH("Dash"),

        /**
         * Long dashes, "--- --- --- ---"
         */
        LONG_DASH("LongDash"),

        /**
         * Medium size dashes and a dot, "-- . -- . -- . --"
         */
        DASH_DOT("DashDot"),

        /**
         * Long dashes and a dot, "--- . --- . --- . ---"
         */
        LONG_DASH_DOT("LongDashDot"),

        /**
         * Long dashes and two dots, "--- .. --- .. --- .. ---"
         */
        LONG_DASH_DOT_DOT("LongDashDotDot");

        private DashStyle(String optionValue) {
            this.optionValue = optionValue;
        }

        private final String optionValue;

        public String toString() {
            return optionValue;
        }

    }

    private Axis axis;
    private String id;

    /**
     * Use the {@link Axis#createPlotLine()} method to create new plot lines
     *
     * @param axis The axis instance that this plotline is being created within.
     */
    PlotLine(Axis axis) {
        this.axis = axis;
        id = Document.get().createUniqueId();
        setOption("id", id);
    }
    
    /**
     * Convenience method for setting the 'color' option of the plot line to an RGB hex value.  Equivalent to:
     * <pre><code>
     *     plotLine.setOption("color", "#CCCCCC");
     * </code></pre>
     * The RGB color for the plot line. Defaults to null.
     * <p/>
     * Note that this method is intended for setting the color to a simple RBG hex value.  If you instead
     * want to set a color to include an alpha channel or a gradient, use the {@link #setColor(Color)}
     * version instead.
     *
     * @param color The value to set as the 'color' option on the plot line.
     * @return A reference to this {@link PlotLine} instance for convenient method chaining.
     */
    public PlotLine setColor(String color) {
        return this.setOption("color", color);
    }

    /**
     * Convenience method for setting the 'color' option of the plot line, allowing for
     * colors with opacity or gradients.  Equivalent to:
     * <pre><code>
     *     plotLine.setOption("color", new Color()
     *        .setLinearGradient(0.0, 0.0, 1.0, 1.0)
     *        .addStop(new Color(255, 255, 255))
     *        .addStop(new Color(200, 200, 255))
     *     );
     * </code></pre>
     * The color or gradient for the plot line. Defaults to null.
     * <p/>
     * Note that this method is intended for setting the color to a gradient or color that includes
     * an alpha channel.  If you instead just want to set the color to a normal RGB hex value
     * you can use the {@link #setColor(String)} version instead.
     *
     * @param color The color gradient or color with an alpha channel to set as the 'color' option on the plot line.
     * @return A reference to this {@link PlotLine} instance for convenient method chaining.
     */
    public PlotLine setColor(Color color) {
        return this.setOption("color", color != null ? color.getOptionValue() : null);
    }   

    /**
     * Convenience method for setting the 'dashStyle' plot line optoin.  Equivalent to:
     * <pre><code>
     *     plotLine.setOption("dashStyle", DashStyle.DOT);
     * </code></pre>
     * The dashing or dot style for the plot line. Defaults to {@link DashStyle#SOLID}.  See this
     * <a href="http://jsfiddle.net/cSrgA/">demonstration</a> for a visible reference
     * of the available dash styles.
     *
     * @param dashStyle The dash style to use for this plot line, or null to use the default.
     * @return A reference to this {@link PlotLine} instance for convenient method chaining.
     */
    public PlotLine setDashStyle(PlotLine.DashStyle dashStyle) {
        return this.setOption("dashStyle", dashStyle != null ? dashStyle.toString() : null);
    }

    // TODO: Add events

    /**
     * Convenience method for setting the 'label' options of the plot line.  Equivalent to:
     * <pre><code>
     *     plotLine.setOption("/label/align", PlotLineLabel.Align.LEFT);
     *     plotLine.setOption("/label/x", 20);
     *     etc....
     * </code></pre>
     *
     * @param plotLineLabel The options for the label on the plot line.
     * @return A reference to this {@link PlotLine} instance for convenient method chaining.
     */
    public PlotLine setLabel(PlotLineLabel plotLineLabel) {
        return this.setOption("label", plotLineLabel != null ? plotLineLabel.getOptions() : null);
    }

    /**
     * Convenience method for setting the 'value' option of the plot line.  Equivalent to:
     * <pre><code>
     *     plotLine.setOption("value", 40);
     * </code></pre>
     * The position of the line in axis units. Defaults to null.
     *
     * @param value The position of the line in axis units.
     * @return A reference to this {@link PlotLine} instance for convenient method chaining.
     */
    public PlotLine setValue(Number value) {
        return this.setOption("value", value);
    }

    /**
     * Convenience method for setting the 'width' option of the plot line.  Equivalent to:
     * <pre><code>
     *     plotLine.setOption("width", 2);
     * </code></pre>
     * The width or thickness of the plot line. Defaults to null.
     *
     * @param width The width or thickness of the plot line.
     * @return A reference to this {@link PlotLine} instance for convenient method chaining.
     */
    public PlotLine setWidth(Number width) {
        return this.setOption("width", width);
    }

    /**
     * Convenience method for setting the 'zIndex' option of the plot line.  Equivalent to:
     * <pre><code>
     *     plotLine.setOption("zIndex", 100);
     * </code></pre>
     * The z index of the plot line within the chart. Defaults to null.
     *
     * @param zIndex The z index of the plot line within the chart.
     * @return A reference to this {@link PlotLine} instance for convenient method chaining.
     */
    public PlotLine setZIndex(Number zIndex) {
        return this.setOption("zIndex", zIndex);
    }

    /**
     * Internal method used to retrieve the unique id generated for this plot line.
     *
     * @return The unique id of this plot line
     * @since 1.1.3
     */
    String getId() {
        return id;
    }


}
