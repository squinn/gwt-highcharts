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

import org.moxieapps.gwt.highcharts.client.Color;
import org.moxieapps.gwt.highcharts.client.Style;


/**
 * Represents the options for the Flags present on the chart.  The plot options for this class are to be instantiated
 * into a {@link org.moxieapps.gwt.highcharts.client.Series}.  Example usage:
 * <pre><code>
 *     chart.addSeries(
 *          chart.createSeries()
 *              .setType(Series.FLAGS)
 *              .addPoint(t(2011), 5, 10)
 *              .setPlotOptions(
 *                  new FlagPlotOptions()
 *                      .setOnSeries("data")
 *              )
 *      );
 * </code></pre>
 * @author cskowron@moxiegroup.com (Cory Skowronek)
 * @since 1.6.0
 */
public class FlagPlotOptions extends PlotOptions<FlagPlotOptions> {

    /**
     * An enumeration representing the shape of the flag. Possible options are FLAG, CIRCLE_PIN, or SQUARE_PIN.
     */
    public enum Shape {
        /**
         * represent the flag as a flag
         */
        FLAG("flag"),

        /**
         * Represent the flag as a circle pin.
         */
        CIRCLE_PIN("circlepin"),

        /**
         * Represent the flag as a square pin.
         */
        SQUARE_PIN("squarepin");

        private Shape(String optionValue) {
            this.optionValue = optionValue;
        }

        private final String optionValue;

        public String toString() {
            return optionValue;
        }
    }

    /**
     * Convenience method for setting the 'fillColor' option of the flag to an RGB hex value.  Equivalent to:
     * <pre><code>
     *     series.setOption("lineColor", "#CCCCCC");
     * </code></pre>
     * The RGB color of the flag. Defaults to "#4572A7".
     * <p/>
     * Note that this method is intended for setting the color to a simple RBG hex value.  If you instead
     * want to set a color to include an alpha channel or a gradient, use the {@link #setFillColor(Color)}
     * version instead.
     *
     * @param fillColor The value to set as the 'lineColor' option on the chart.
     * @return A reference to this {@link FlagPlotOptions} instance for convenient method chaining.
     * @see FlagPlotOptions#setFillColor(Color)
     * @since 1.6.0
     */
    public FlagPlotOptions setFillColor(String fillColor) {
        return this.setOption("fillColor", fillColor);
    }

    /**
     * Convenience method for setting the 'fillColor' option of the flag, allowing for
     * colors with opacity or gradients.  Equivalent to:
     * <pre><code>
     *     series.setOption("lineColor", new Color()
     *        .setLinearGradient(0.0, 0.0, 1.0, 1.0)
     *        .addStop(new Color(255, 255, 255))
     *        .addStop(new Color(200, 200, 255))
     *     );
     * </code></pre>
     * The color of the flag. Defaults to "#4572A7".
     * <p/>
     * Note that this method is intended for setting the color to a gradient or color that includes
     * an alpha channel.  If you instead just want to set the color to a normal RGB hex value
     * you can use the {@link #setFillColor(String)} version instead.
     *
     * @param fillColor The color gradient or color with an alpha channel to set as the 'borderColor' option on the chart.
     * @return A reference to this {@link FlagPlotOptions} instance for convenient method chaining.
     */
    public FlagPlotOptions setFillColor(Color fillColor) {
        return this.setOption("fillColor", fillColor != null ? fillColor.getOptionValue() : null);
    }


    /**
     * Convenience method for setting the 'lineColor' option of the flag to an RGB hex value.  Equivalent to:
     * <pre><code>
     *     series.setOption("lineColor", "#CCCCCC");
     * </code></pre>
     * The RGB color of the outer chart border. The border is painted using vector graphic techniques to allow
     * rounded corners. Defaults to "#4572A7".
     * <p/>
     * Note that this method is intended for setting the color to a simple RBG hex value.  If you instead
     * want to set a color to include an alpha channel or a gradient, use the {@link #setLineColor(Color)}
     * version instead.
     *
     * @param lineColor The value to set as the 'lineColor' option on the chart.
     * @return A reference to this {@link FlagPlotOptions} instance for convenient method chaining.
     * @see FlagPlotOptions#setLineColor(Color)
     * @since 1.6.0
     */
    public FlagPlotOptions setLineColor(String lineColor) {
        return this.setOption("lineColor", lineColor);
    }

    /**
     * Convenience method for setting the 'lineColor' option of the flag, allowing for
     * colors with opacity or gradients.  Equivalent to:
     * <pre><code>
     *     series.setOption("lineColor", new Color()
     *        .setLinearGradient(0.0, 0.0, 1.0, 1.0)
     *        .addStop(new Color(255, 255, 255))
     *        .addStop(new Color(200, 200, 255))
     *     );
     * </code></pre>
     * The color of the flag's line. Defaults to "#4572A7".
     * <p/>
     * Note that this method is intended for setting the color to a gradient or color that includes
     * an alpha channel.  If you instead just want to set the color to a normal RGB hex value
     * you can use the {@link #setLineColor(String)} version instead.
     *
     * @param lineColor The color gradient or color with an alpha channel to set as the 'borderColor' option on the chart.
     * @return A reference to this {@link FlagPlotOptions} instance for convenient method chaining.
     */
    public FlagPlotOptions setLineColor(Color lineColor) {
        return this.setOption("lineColor", lineColor != null ? lineColor.getOptionValue() : null);
    }

    /**
     * Convenience method for setting the 'onSeries' option of the flag.  Equivalent to:
     * <pre><code>
     *     series.setOption("onSeries", "seriesName")
     * </code></pre>
     * Attaches flags to the given series. If no id is given, the flags are drawn on the x axis. Defaults to undefined. Defaults to undefined.
     * @param onSeries The id of the series that the flags should be drawn on
     * @return A reference to this {@link FlagPlotOptions} instance for convenient method chaining.
     */
    public FlagPlotOptions setOnSeries(String onSeries) {
        return  this.setOption("onSeries", onSeries);
    }

    /**
     * Convenience method for setting the 'shape' option of the flag.  Equivalent to:
     * <pre><code>
     *     series.setOption("shape", "flag");
     * </code></pre>
     * Sets the shape of the flag.  Can be one of "circlepin", "squarepin", or "flag". Defaults to "flag".
     * @param shape The shape of the marker.
     * @return A reference to this {@link FlagPlotOptions} instance for convenient method chaining.
     */
    public FlagPlotOptions setShape(Shape shape) {
        return this.setOption("shape", shape != null ? shape.toString() : null);
    }

    /**
     * Convenience method for setting the 'style' options of the flag.  Equivalent to:
     * <pre><code>
     *     series.setOption("/style/fontWeight", "bold");
     *     series.setOption("/style/fontFamily", "serif");
     *     etc.
     * </code></pre>
     * CSS styles for the flag. When titles are rotated they are rendered using vector graphic techniques
     * and not all styles are applicable. Most noteworthy, a bug in IE8 renders all rotated strings bold
     * and italic. Defaults to:
     * <ul>
     * <li>color: '#6D869F'</li>
     * <li>fontWeight: 'bold'</li>
     * </ul>
     *
     * @param style CSS styles for the axis title.
     * @return A reference to this {@link FlagPlotOptions} instance for convenient method chaining.
     */
    public FlagPlotOptions setStyle(Style style) {
        return this.setOption("style", style != null ? style.getOptions() : null);
    }


    /**
     * Convenience method for setting the 'width' option of the flag.  Equivalent to:
     * <pre><code>
     *     series.setOption("width", 10);
     * </code></pre>
     * Manually sets the width of the flag.
     * @param width The width of the flag.
     * @return A reference to this {@link FlagPlotOptions} instance for convenient method chaining.
     */
    public FlagPlotOptions setWidth(Number width) {
        return this.setOption("width", width);
    }
}
