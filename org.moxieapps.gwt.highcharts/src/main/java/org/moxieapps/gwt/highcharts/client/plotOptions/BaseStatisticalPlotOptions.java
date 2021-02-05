package org.moxieapps.gwt.highcharts.client.plotOptions;

import org.moxieapps.gwt.highcharts.client.Color;
import org.moxieapps.gwt.highcharts.client.PlotLine;

/**
 * A common base class for both {@link BoxPlotOptions} and {@link ErrorBarPlotOptions} to prevent code duplication
 * while still maintaining a cleaner way for the user to utilize the method chaining with the generics
 * in place.  You should not use this class directly, but instead use one of the base classes.
 *
 * @author cskowron@moxiegroup.com (Cory Skowronek)
 * @since 1.6.0
 */
public abstract class BaseStatisticalPlotOptions <T extends BaseStatisticalPlotOptions> extends BaseColumnPlotOptions<T> {

    /**
     * Convenience method for setting the 'fillColor' option of the box plot options
     * to a RGB hex value.  Equivalent to:
     * <pre><code>
     *     boxPlotOptions.setOption("fillColor", "#CCCCCC");
     * </code></pre>
     * Fill color or gradient for the area. When null, the series' color is used with the series' fillOpacity. Defaults to null.
     * <p/>
     * Note that this method is intended for setting the color to a simple RBG hex value.  If you instead
     * want to set a color to include an alpha channel or a gradient, use the {@link #setFillColor(org.moxieapps.gwt.highcharts.client.Color)}
     * version instead.
     *
     * @param fillColor The value to set as the 'fillColor' option of the box plots.
     * @return A reference to this {@link BoxPlotOptions} instance for convenient method chaining.
     */
    public T setFillColor(String fillColor) {
        return this.setOption("fillColor", fillColor);
    }

    /**
     * Convenience method for setting the 'fillColor' option of the box plot options, allowing for
     * colors with opacity or gradients.  Equivalent to:
     * <pre><code>
     *     boxPlotOptions.setOption("fillColor", new Color()
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
     * @param fillColor The color gradient or color with an alpha channel to set as the 'fillColor' option of the box plot.
     * @return A reference to this {@link BoxPlotOptions} instance for convenient method chaining.
     */
    public T setFillColor(Color fillColor) {
        return this.setOption("fillColor", fillColor != null ? fillColor.getOptionValue() : null);
    }



    /**
     * Convenience method for setting the 'medianColor' option of the box plot options
     * to a RGB hex value.  Equivalent to:
     * <pre><code>
     *     boxPlotOptions.setOption("medianColor", "#CCCCCC");
     * </code></pre>
     * The color of the median line. If null, the general series color applies. Defaults to null.
     * <p/>
     * Note that this method is intended for setting the color to a simple RBG hex value.  If you instead
     * want to set a color to include an alpha channel or a gradient, use the {@link #setMedianColor(Color)}
     * version instead.
     * @param medianColor The value to set as the 'medianColor' option of the box plots.
     * @return A reference to this {@link BoxPlotOptions} instance for convenient method chaining.
     */
    public T setMedianColor(String medianColor) {
        return this.setOption("medianColor", medianColor);
    }

    /**
     * Convenience method for setting the 'medianColor' option of the box plot options, allowing for
     * colors with opacity or gradients.  Equivalent to:
     * <pre><code>
     *     boxPlotOptions.setOption("medianColor", new Color()
     *        .setLinearGradient(0.0, 0.0, 1.0, 1.0)
     *        .addStop(new Color(255, 255, 255))
     *        .addStop(new Color(200, 200, 255))
     *     );
     * </code></pre>
     * The color of the median line. If null, the general series color applies. Defaults to null.
     * <p/>
     * Note that this method is intended for setting the color to a gradient or color that includes
     * an alpha channel.  If you instead just want to set the color to a normal RGB hex value
     * you can use the {@link #setMedianColor(String)} version instead.
     * @param medianColor The color gradient or color with an alpha channel to set as the 'medianColor' option of the box plot.
     * @return A reference to this {@link BoxPlotOptions} instance for convenient method chaining.
     */
    public T setMedianColor(Color medianColor) {
        return this.setOption("medianColor", medianColor != null ? medianColor.getOptionValue() : null);
    }

    /**
     * Convenience method for setting the 'medianWidth' option of the box plot options.  Equivalent to:
     * <pre><code>
     *     boxPlotOptions.setOption("medianWidth", 4);
     * </code></pre>
     * The pixel width of the median line. If null, the lineWidth is used. Defaults to 2.
     * @param medianWidth The width in pixels of the median line.
     * @return A reference to this {@link BoxPlotOptions} instance for convenient method chaining.
     */
    public T setMedianWidth(Number medianWidth) {
        return  this.setOption("medianWidth", medianWidth);
    }

    /**
     * Convenience method for setting the 'stemColor' option of the box plot options.  Equivalent to:
     * <pre><code>
     *     boxPlotOptions.setOption("stemColor", "#CCCCCC");
     * </code></pre>
     * The color of the stem, the vertical line extending from the box to the whiskers. If null, the series color is used. Defaults to null.
     * <p/>
     * Note that this method is intended for setting the color to a simple RBG hex value.  If you instead
     * want to set a color to include an alpha channel or a gradient, use the {@link #setWhiskerColor(Color)}
     * version instead.
     * @param stemColor The value to set as the 'stemColor' option of the box plots.
     * @return A reference to this {@link BoxPlotOptions} instance for convenient method chaining.
     */
    public T setStemColor(String stemColor) {
        return this.setOption("setmColor", stemColor);
    }

    /**
     * Convenience method for setting the 'stemColor' option of the box plot options.  Equivalent to:
     * <pre><code>
     *     boxPlotOptions.setOption("stemColor", new Color()
     *        .setLinearGradient(0.0, 0.0, 1.0, 1.0)
     *        .addStop(new Color(255, 255, 255))
     *        .addStop(new Color(200, 200, 255))
     *     );
     * </code></pre>
     * The color of the stem, the vertical line extending from the box to the whiskers. If null, the series color is used. Defaults to null.
     * @param stemColor The color gradient or color with an alpha channel to set as the 'stemColor' option of the box plot.
     * @return A reference to this {@link BoxPlotOptions} instance for convenient method chaining.
     */
    public T setStemColor(Color stemColor) {
        return this.setOption("stemColor", stemColor != null ? stemColor.getOptionValue() : null);
    }

    /**
     * Convenience method for setting the 'dashStyle' option of the box plot options.  Equivalent to:
     * <pre><code>
     *     boxPlotOptions.setOption("stemDashStyle", PlotOptions.DashStyle.DOT);
     * </code></pre>
     * The dash style of the stem, the vertical line extending from the box to the whiskers. Defaults to Solid.
     * @param stemDashStyle The dash style to use for this series, or null to use the default.
     * @return A reference to this {@link BoxPlotOptions} instance for convenient method chaining.
     */
    public T setStemDashStyle(PlotLine.DashStyle stemDashStyle) {
        return this.setOption("stemDashStyle", stemDashStyle);
    }

    /**
     * Convenience method for setting the 'dashStyle' option of the box plot options.  Equivalent to:
     * <pre><code>
     *     boxPlotOptions.setOption("stemDashWidth", 5);
     * </code></pre>
     * The width of the stem, the vertical line extending from the box to the whiskers. If null, the width is inherited from the lineWidth option. Defaults to null.
     * @param stemWidth The width in pixels to use for the stem width
     * @return A reference to this {@link BoxPlotOptions} instance for convenient method chaining.
     */
    public T setStemWidth(Number stemWidth) {
        return this.setOption("stemWidth", stemWidth);
    }

    /**
     * Convenience method for setting the 'whiskerColor' option of the box plot options.  Equivalent to:
     * <pre><code>
     *     boxPlotOptions.setOption("whiskerColor", "#CCCCCC");
     * </code></pre>
     * The color of the whiskers, the horizontal lines marking low and high values. When null, the general series color is used. Defaults to null.
     * @param whiskerColor The value to set as the 'whiskerColor' option of the box plots.
     * @return A reference to this {@link BoxPlotOptions} instance for convenient method chaining.
     */
    public T setWhiskerColor(String whiskerColor) {
        return this.setOption("whiskerColor", whiskerColor);
    }

    /**
     * Convenience method for setting the 'whiskerColor' option of the box plot options.  Equivalent to:
     * <pre><code>
     *     boxPlotOptions.setOption("whiskerColor", new Color()
     *        .setLinearGradient(0.0, 0.0, 1.0, 1.0)
     *        .addStop(new Color(255, 255, 255))
     *        .addStop(new Color(200, 200, 255))
     *     );
     * </code></pre>
     * The color of the whiskers, the horizontal lines marking low and high values. When null, the general series color is used. Defaults to null.
     * <p/>
     *  Note that this method is intended for setting the color to a gradient or color that includes
     * an alpha channel.  If you instead just want to set the color to a normal RGB hex value
     * you can use the {@link #setWhiskerColor(String)} version instead.
     * @param whiskerColor The color gradient or color with an alpha channel to set as the 'whiskerColor' option of the box plot.
     * @return A reference to this {@link BoxPlotOptions} instance for convenient method chaining.
     */
    public T setWhiskerColor(Color whiskerColor) {
        return this.setOption("whiskerColor",  whiskerColor != null ? whiskerColor.getOptionValue() : null);
    }

    /**
     * Convenience method for setting the 'whiskerLength' option of the box plot options.  Equivalent to:
     * <pre><code>
     *     boxPlotOptions.setOption("whiskerLength", "25");
     * </code></pre>
     * The length of the whiskers, the horizontal lines marking low and high values.
     * It can be a numerical pixel value, or a percentage value of the box width.
     * Set 0 to disable whiskers. Defaults to 50%.
     * <p/>
     * Note: This method is for denoting the whisker length as a number of pixels.  If you wish to set its length as a
     * percentage of the box width, use this {@link #setWhiskerLength(String)}.
     * @param whiskerLength The length, in pixels, of the whisker.
     * @return A reference to this {@link BoxPlotOptions} instance for convenient method chaining.
     */
    public T setWhiskerLength(Number whiskerLength) {
        return this.setOption("whiskerLength", whiskerLength);
    }

    /**
     * Convenience method for setting the 'whiskerColor' option of the box plot options.  Equivalent to:
     * <pre><code>
     *     boxPlotOptions.setOption("whiskerLength", "25%);
     * </code></pre>
     * The length of the whiskers, the horizontal lines marking low and high values.
     * It can be a numerical pixel value, or a percentage value of the box width.
     * Set 0 to disable whiskers. Defaults to 50%.
     * <p/>
     * Note: This method is for denoting the whisker length as a percentage of box width.  If you wish to set its length as a
     * number of pixels, use this {@link #setWhiskerLength(Number)}.
     * @param whiskerLength The length, as a percentage, of the whisker.
     * @return A reference to this {@link BoxPlotOptions} instance for convenient method chaining.
     */
    public T setWhiskerLength(String whiskerLength) {
        return this.setOption("whiskerLength", whiskerLength);
    }

    /**
     * Convenience method for setting the 'whiskerWidth' option of the box plot options.  Equivalent to:
     * <pre><code>
     *     boxPlotOptions.setOption("whiskerWidth", 25);
     * </code></pre>
     * The line width of the whiskers, the horizontal lines marking low and high values. When null, the general lineWidth applies. Defaults to null.
     * @param whiskerWidth
     * @return A reference to this {@link BoxPlotOptions} instance for convenient method chaining.
     */
    public T setWhiskerWidth(Number whiskerWidth) {
        return this.setOption("whiskerWidth", whiskerWidth);
    }
}
