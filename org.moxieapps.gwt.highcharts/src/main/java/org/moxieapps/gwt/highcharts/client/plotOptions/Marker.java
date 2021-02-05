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

package org.moxieapps.gwt.highcharts.client.plotOptions;

import org.moxieapps.gwt.highcharts.client.Color;
import org.moxieapps.gwt.highcharts.client.Configurable;

/**
 * Controls configuration options for the markers within a series.  Can be set as a plot option on a series
 * via the {@link PlotOptions#setMarker(Marker)} method.  Example usage:
 * <code><pre>
 *   chart.setSeriesPlotOptions(new SeriesPlotOptions()
 *      .setMarker(
 *         new Marker()
 *            .setEnabled(true)
 *            .setFillColor("#CC0000")
 *            .setRadius(4)
 *      )
 *   );
 * </pre></code>
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.0.0
 */
public class Marker extends Configurable<Marker> {

    /**
     * An enumeration of supported marker symbol types, which can be passed to methods
     * like {@link Marker#setSymbol(Marker.Symbol)} method.
     * <p/>Note that custom marker images are also supported by simply setting the
     * "symbol" option to a URL reference.  E.g.
     * <pre><code>
     *    marker.setOption("symbol", "url(/serverpath/image.png)");
     * </code></pre>
     */
    public enum Symbol {

        /**
         * Represent the marker with a circular shape
         */
        CIRCLE("circle"),

        /**
         * Represent the marker with a square shape
         */
        SQUARE("square"),

        /**
         * Represent the marker with a diamond shape
         */
        DIAMOND("diamond"),

        /**
         * Represent the marker with a triangular shape
         */
        TRIANGLE("triangle"),

        /**
         * Represent the marker with an upside down triangular shape
         */
        TRIANGLE_DOWN("triangle-down");

        private Symbol(String optionValue) {
            this.optionValue = optionValue;
        }

        private final String optionValue;

        public String toString() {
            return optionValue;
        }

    }

    /**
     * Convenience method for setting the 'enabled' option for the markers.  Equivalent to:
     * <pre><code>
     *     marker.setOption("enabled", true);
     * </code></pre>
     * Enable or disable the point marker. Defaults to true.
     *
     * @param enabled Enable or disable the point marker.
     * @return A reference to this {@link Marker} instance for convenient method chaining.
     */
    public Marker setEnabled(boolean enabled) {
        return this.setOption("enabled", enabled);
    }

    /**
     * Convenience method for setting the 'fillColor' option of the markers to a RGB hex value.  Equivalent to:
     * <pre><code>
     *     marker.setOption("fillColor", "#CCCCCC");
     * </code></pre>
     * The fill color of the point marker. When null, the series' or point's color is used. Defaults to null.
     * <p/>
     * Note that this method is intended for setting the color to a simple RBG hex value.  If you instead
     * want to set a color to include an alpha channel or a gradient, use the {@link #setFillColor(Color)}
     * version instead.
     *
     * @param fillColor The value to set as the 'fillColor' option of the markers.
     * @return A reference to this {@link Marker} instance for convenient method chaining.
     */
    public Marker setFillColor(String fillColor) {
        return this.setOption("fillColor", fillColor);
    }

    /**
     * Convenience method for setting the 'fillColor' option of the markers, allowing for
     * colors with opacity or gradients.  Equivalent to:
     * <pre><code>
     *     marker.setOption("fillColor", new Color()
     *        .setLinearGradient(0.0, 0.0, 1.0, 1.0)
     *        .addStop(new Color(255, 255, 255))
     *        .addStop(new Color(200, 200, 255))
     *     );
     * </code></pre>
     * The fill color of the point marker. When null, the series' or point's color is used. Defaults to null.
     * <p/>
     * Note that this method is intended for setting the color to a gradient or color that includes
     * an alpha channel.  If you instead just want to set the color to a normal RGB hex value
     * you can use the {@link #setFillColor(String)} version instead.
     *
     * @param fillColor The color gradient or color with an alpha channel to set as the 'fillColor' option of the markers.
     * @return A reference to this {@link Marker} instance for convenient method chaining.
     */
    public Marker setFillColor(Color fillColor) {
        return this.setOption("fillColor", fillColor != null ? fillColor.getOptionValue() : null);
    }

    /**
     * Convenience method for setting the 'lineColor' option of the markers to a RGB hex value.  Equivalent to:
     * <pre><code>
     *     marker.setOption("lineColor", "#CCCCCC");
     * </code></pre>
     * The color of the point marker's outline. When null, the series' or point's color is used. Defaults to "#FFFFFF".
     * <p/>
     * Note that this method is intended for setting the color to a simple RBG hex value.  If you instead
     * want to set a color to include an alpha channel or a gradient, use the {@link #setLineColor(Color)}
     * version instead.
     *
     * @param lineColor The value to set as the 'lineColor' option of the markers.
     * @return A reference to this {@link Marker} instance for convenient method chaining.
     */
    public Marker setLineColor(String lineColor) {
        return this.setOption("lineColor", lineColor);
    }

    /**
     * Convenience method for setting the 'lineColor' option of the markers, allowing for
     * colors with opacity or gradients.  Equivalent to:
     * <pre><code>
     *     marker.setOption("lineColor", new Color()
     *        .setLinearGradient(0.0, 0.0, 1.0, 1.0)
     *        .addStop(new Color(255, 255, 255))
     *        .addStop(new Color(200, 200, 255))
     *     );
     * </code></pre>
     * The color of the point marker's outline. When null, the series' or point's color is used. Defaults to "#FFFFFF".
     * <p/>
     * Note that this method is intended for setting the color to a gradient or color that includes
     * an alpha channel.  If you instead just want to set the color to a normal RGB hex value
     * you can use the {@link #setLineColor(String)} version instead.
     *
     * @param lineColor The color gradient or color with an alpha channel to set as the 'lineColor' option of the markers.
     * @return A reference to this {@link Marker} instance for convenient method chaining.
     */
    public Marker setLineColor(Color lineColor) {
        return this.setOption("lineColor", lineColor != null ? lineColor.getOptionValue() : null);
    }

    /**
     * Convenience method for setting the 'lineWidth' option for the markers.  Equivalent to:
     * <pre><code>
     *     marker.setOption("lineWidth", 4);
     * </code></pre>
     * The width of the point marker's outline. Defaults to 0.
     *
     * @param lineWidth The width of the point marker's outline.
     * @return A reference to this {@link Marker} instance for convenient method chaining.
     */
    public Marker setLineWidth(Number lineWidth) {
        return this.setOption("lineWidth", lineWidth);
    }

    /**
     * Convenience method for setting the 'radius' option for the markers.  Equivalent to:
     * <pre><code>
     *     marker.setOption("radius", 4);
     * </code></pre>
     * The radius of the point marker. Defaults to 0.
     *
     * @param radius The radius of the point marker.
     * @return A reference to this {@link Marker} instance for convenient method chaining.
     */
    public Marker setRadius(Number radius) {
        return this.setOption("radius", radius);
    }

    /**
     * Set the configuration options for the hovered point marker. Members are inherited
     * from the default line configuration, but single members can be overridden.  Equivalent to:
     * <pre><code>
     *     marker.setOption("/states/hover/enabled", true);
     *     marker.setOption("/states/hover/radius", 8);
     *     ...
     * </code></pre>
     *
     * @param hoverState The configuration options to use for the markers on mouse hover.
     * @return A reference to this {@link Marker} instance for convenient method chaining.
     */
    public Marker setHoverState(Marker hoverState) {
        return this.setOption("/states/hover", hoverState != null ? hoverState.getOptions() : null);

    }

    /**
     * Set the configuration options for the selected point marker. Members are inherited
     * from the default line configuration, but single members can be overridden.  Equivalent to:
     * <pre><code>
     *     marker.setOption("/states/select/enabled", true);
     *     marker.setOption("/states/select/radius", 8);
     *     ...
     * </code></pre>
     *
     * @param selectState The configuration options to use for the markers when selected.
     * @return A reference to this {@link Marker} instance for convenient method chaining.
     */
    public Marker setSelectState(Marker selectState) {
        return this.setOption("/states/select", selectState != null ? selectState.getOptions() : null);
    }

    /**
     * Convenience method for setting the 'symbol' option for the markers.  Equivalent to:
     * <pre><code>
     *     marker.setOption("symbol", Marker.Symbol.DIAMOND);
     * </code></pre>
     * A predefined shape or symbol for the marker. When null, the symbol is pulled from the default
     * {@link org.moxieapps.gwt.highcharts.client.Chart#setSymbols(org.moxieapps.gwt.highcharts.client.plotOptions.Marker.Symbol[])}
     * options. Defaults to null.
     * <p/>
     * Note that custom marker images are also supported by simply setting the "symbol" option to a URL reference.  E.g.
     * <pre><code>
     *     marker.setOption("symbol", "url(/serverpath/image.png)");
     * </code></pre>
     *
     * @param symbol The shape or symbol for the marker.
     * @return A reference to this {@link Marker} instance for convenient method chaining.
     */
    public Marker setSymbol(Symbol symbol) {
        return this.setOption("symbol", symbol != null ? symbol.toString() : null);
    }

    /**
     * Convenience method for setting the 'symbol' option for markers to a URL.  Equivalent to:
     * <pre><code>
     *     marker.setOption("symbol", "url('http://highcharts.com/demo/gfx/sun.png')");
     * </code></pre>
     * Sets the marker to use a custom symbol from a url. Note that only the url itself
     * is needed to be passed as a parameter. Sample usage:
     * <pre><code>
     *     chart.addSeries(
     *         chart.createSeries()
     *              .addPoint(
     *                  new Point(216.4)
     *                      .setMarker(
     *                          new Marker()
     *                              .setSymbol("http://highcharts.com/demo/gfx/sun.png")
     *     );
     * </code></pre>
     * @param symbolURL the url of the symbol to use for the marker.
     * @return A reference to this {@link Marker} instance for convenient method chaining.
     * @since 1.6.0
     */
    public Marker setSymbol(String symbolURL) {
        return this.setOption("symbol", "url(" + symbolURL + ")");
    }

}
