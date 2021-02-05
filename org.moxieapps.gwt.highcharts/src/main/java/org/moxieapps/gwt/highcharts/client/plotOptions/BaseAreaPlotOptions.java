/*
 * Copyright (c) 2012 Moxie Group
 */

package org.moxieapps.gwt.highcharts.client.plotOptions;

import org.moxieapps.gwt.highcharts.client.Color;

/**
 * A common base class for both {@link AreaPlotOptions} and {@link AreaRangePlotOptions} to prevent code duplication
 * while still maintaining a cleaner way for the user to utilize the method chaining with the generics
 * in place.  You should not use this class directly, but instead use one of the base classes.
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.0.0
 */
public abstract class BaseAreaPlotOptions<T extends BaseAreaPlotOptions> extends PlotOptions<T> {

    /**
     * Convenience method for setting the 'connectNulls' option of the area plot options.  Equivalent to:
     * <pre><code>
     *     areaPlotOptions.setOption("connectNulls", true);
     * </code></pre>
     * Whether to connect a graph line across null points. Defaults to false.
     * @param connectNulls 'true' to connect the graph across null points.
     * @return A reference to this {@link AreaPlotOptions} instance for convenient method chaining.
     * @since 1.6.0
     */
    public T setConnectNulls(boolean connectNulls) {
        return this.setOption("connectNulls", connectNulls);
    }

    /**
     * Convenience method for setting the 'fillColor' option of the area plot options
     * to a RGB hex value.  Equivalent to:
     * <pre><code>
     *     areaPlotOptions.setOption("fillColor", "#CCCCCC");
     * </code></pre>
     * Fill color or gradient for the area. When null, the series' color is used with the series' fillOpacity. Defaults to null.
     * <p/>
     * Note that this method is intended for setting the color to a simple RBG hex value.  If you instead
     * want to set a color to include an alpha channel or a gradient, use the {@link #setFillColor(Color)}
     * version instead.
     *
     * @param fillColor The value to set as the 'fillColor' option of the area plots.
     * @return A reference to this {@link AreaPlotOptions} instance for convenient method chaining.
     */
    public T setFillColor(String fillColor) {
        return this.setOption("fillColor", fillColor);
    }

    /**
     * Convenience method for setting the 'fillColor' option of the area plot options, allowing for
     * colors with opacity or gradients.  Equivalent to:
     * <pre><code>
     *     areaPlotOptions.setOption("fillColor", new Color()
     *        .setLinearGradient(0.0, 0.0, 1.0, 1.0)
     *        .addStop(new Color(255, 255, 255))
     *        .addStop(new Color(200, 200, 255))
     *     );
     * </code></pre>
     * Fill color or gradient for the area. When null, the series' color is used with the series' fillOpacity. Defaults to null.
     * <p/>
     * Note that this method is intended for setting the color to a gradient or color that includes
     * an alpha channel.  If you instead just want to set the color to a normal RGB hex value
     * you can use the {@link #setFillColor(String)} version instead.
     *
     * @param fillColor The color gradient or color with an alpha channel to set as the 'fillColor' option of the area plot.
     * @return A reference to this {@link AreaPlotOptions} instance for convenient method chaining.
     */
    public T setFillColor(Color fillColor) {
        return this.setOption("fillColor", fillColor != null ? fillColor.getOptionValue() : null);
    }

    /**
     * Convenience method for setting the 'fillOpacity' option of the area plot options.  Equivalent to:
     * <pre><code>
     *     areaPlotOptions.setOption("fillOpacity", 0.5);
     * </code></pre>
     * Fill opacity for the area. Defaults to .75.
     *
     * @param fillOpacity Fill opacity for the area.
     * @return A reference to this {@link AreaPlotOptions} instance for convenient method chaining.
     */
    public T setFillOpacity(Number fillOpacity) {
        return this.setOption("fillOpacity", fillOpacity);
    }

    /**
     * Convenience Method for setting the "gapSize" option of the plot options.  Equivalent to:
     * <pre><code>
     *     areaPlotOptions.setOption("gapSize", 5);
     * </code></pre>
     * Defines when to display a gap in the graph. A gap size of 5 means that if the distance between two points is
     * greater than five times that of the two closest points, the graph will be broken.In practice, this option is
     * most often used to visualize gaps in time series. In a stock chart, intraday data is available for daytime hours,
     * while gaps will appear in nights and weekends.. Defaults to 0.
     * @param gapSize The distance between points needed to display a gap in the series.
     * @return A reference to this {@link AreaPlotOptions} instance for convenient method chaining.
     * @since 1.6.0
     */
    public T setGapSize(Number gapSize) {
        return this.setOption("gapSize", gapSize);
    }

    /**
     * Convenience method for setting the 'lineColor' option of the area plot options to a RGB hex value.  Equivalent to:
     * <pre><code>
     *     areaPlotOptions.setOption("lineColor", "#CCCCCC");
     * </code></pre>
     * A separate color for the graph line. By default the line takes the color of the series, but the
     * lineColor setting allows setting a separate color for the line without altering the fillColor. Defaults to null.
     * <p/>
     * Note that this method is intended for setting the color to a simple RBG hex value.  If you instead
     * want to set a color to include an alpha channel or a gradient, use the {@link #setLineColor(Color)}
     * version instead.
     *
     * @param lineColor The value to set as the 'lineColor' option of the area plots.
     * @return A reference to this {@link AreaPlotOptions} instance for convenient method chaining.
     */
    public T setLineColor(String lineColor) {
        return this.setOption("lineColor", lineColor);
    }

    /**
     * Convenience method for setting the 'lineColor' option of the area plot options, allowing for
     * colors with opacity or gradients.  Equivalent to:
     * <pre><code>
     *     areaPlotOptions.setOption("lineColor", new Color()
     *        .setLinearGradient(0.0, 0.0, 1.0, 1.0)
     *        .addStop(new Color(255, 255, 255))
     *        .addStop(new Color(200, 200, 255))
     *     );
     * </code></pre>
     * A separate color for the graph line. By default the line takes the color of the series, but the
     * lineColor setting allows setting a separate color for the line without altering the fillColor. Defaults to null.
     * <p/>
     * Note that this method is intended for setting the color to a gradient or color that includes
     * an alpha channel.  If you instead just want to set the color to a normal RGB hex value
     * you can use the {@link #setLineColor(String)} version instead.
     *
     * @param lineColor The color gradient or color with an alpha channel to set as the 'lineColor' option of the area plots.
     * @return A reference to this {@link AreaPlotOptions} instance for convenient method chaining.
     */
    public T setLineColor(Color lineColor) {
        return this.setOption("lineColor", lineColor != null ? lineColor.getOptionValue() : null);
    }

    /**
     * Convenience method for setting the "negativeFillColor" option for area charts.  Equivalent to:
     * <pre><code>
     *     areaPlotOptions.setOption("negativeFillColor", "#CCCCCC");
     * </code></pre>
     * A separate color for the negative part of the area.
     * <p/>
     * Note that this method is intended for setting the color to a simple RBG hex value.  If you instead
     * want to set a color to include an alpha channel or a gradient, use the {@link #setNegativeFillColor(Color)}
     * version instead.
     * @param negativeFillColor The value to set as the 'negativeFillColor' option of the area plots.
     * @return A reference to this {@link AreaPlotOptions} instance for convenient method chaining.
     * @since 1.6.0
     */
    public T setNegativeFillColor(String negativeFillColor) {
        return this.setOption("negativeFillColor", negativeFillColor);
    }

    /**
     * <pre><code>
     *     areaPlotOptions.setOption("negativeFillColor", new Color()
     *        .setLinearGradient(0.0, 0.0, 1.0, 1.0)
     *        .addStop(new Color(255, 255, 255))
     *        .addStop(new Color(200, 200, 255))
     *     );
     * </code></pre>
     * A separate color for the negative part of the area.
     * <p/>
     * Note that this method is intended for setting the color to a gradient or color that includes
     * an alpha channel.  If you instead just want to set the color to a normal RGB hex value
     * you can use the {@link #setNegativeFillColor(String)} version instead.
     * @param negativeFillColor The color gradient or color with an alpha channel to set as the 'negativeFillColor' option of the area plot.
     * @return A reference to this {@link AreaPlotOptions} instance for convenient method chaining.
     * @since 1.6.0
     */
    public T setNegativeFillColor(Color negativeFillColor) {
        return this.setOption("negativeFillColor", negativeFillColor != null ? negativeFillColor.getOptionValue() : negativeFillColor);
    }

    /**
     * Convenience method for setting the 'trackByArea' option for area charts.  Equivalent to:
     * <pre><code>
     *     areaPlotOptions.setOption("trackByArea", true);
     * </code></pre>
     * If true, the whole area will respond to mouseover events.  If false, just the line will respond.
     * Defaults to false.
     * @param trackByArea Whether the whole area or just the line should respond to mouseover tooltips and other mouse or touch events.
     * @return A reference to this {@link AreaPlotOptions} instance for convenient method chaining.
     * @since 1.6.0
     */
    public T setTrackByArea (boolean trackByArea) {
        return this.setOption("trackByArea", trackByArea);
    }
}
