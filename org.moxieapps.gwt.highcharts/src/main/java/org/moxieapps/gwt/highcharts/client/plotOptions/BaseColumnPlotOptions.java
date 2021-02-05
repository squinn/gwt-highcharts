/*
 * Copyright (c) 2012 Moxie Group
 */

package org.moxieapps.gwt.highcharts.client.plotOptions;

import org.moxieapps.gwt.highcharts.client.Color;

/**
 * A common base class for {@link BoxPlotOptions}, {@link ColumnPlotOptions} and {@link ColumnRangePlotOptions} to prevent code duplication
 * while still maintaining a cleaner way for the user to utilize the method chaining with the generics
 * in place.  You should not use this class directly, but instead use one of the base classes.
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.0.0
 */
public abstract class BaseColumnPlotOptions<T extends BaseColumnPlotOptions> extends PlotOptions<T> {

    /**
     * Convenience method for setting the 'borderColor' option of the column plot options
     * to a RGB hex value.  Equivalent to:
     * <pre><code>
     *     columnPlotOptions.setOption("borderColor", "#CCCCCC");
     * </code></pre>
     * The color of the border surrounding each column or bar. Defaults to "#FFFFFF".
     * <p/>
     * Note that this method is intended for setting the color to a simple RBG hex value.  If you instead
     * want to set a color to include an alpha channel or a gradient, use the {@link #setBorderColor(org.moxieapps.gwt.highcharts.client.Color)}
     * version instead.
     *
     * @param borderColor The value to set as the 'borderColor' option of the column plots.
     * @return A reference to this {@link ColumnPlotOptions} instance for convenient method chaining.
     */
    public T setBorderColor(String borderColor) {
        return this.setOption("borderColor", borderColor);
    }

    /**
     * Convenience method for setting the 'borderColor' option of the column plot options, allowing for
     * colors with opacity or gradients.  Equivalent to:
     * <pre><code>
     *     columnPlotOptions.setOption("borderColor", new Color()
     *        .setLinearGradient(0.0, 0.0, 1.0, 1.0)
     *        .addStop(new Color(255, 255, 255))
     *        .addStop(new Color(200, 200, 255))
     *     );
     * </code></pre>
     * The color of the border surrounding each column or bar. Defaults to "#FFFFFF".
     * <p/>
     * Note that this method is intended for setting the color to a gradient or color that includes
     * an alpha channel.  If you instead just want to set the color to a normal RGB hex value
     * you can use the {@link #setBorderColor(String)} version instead.
     *
     * @param borderColor The color gradient or color with an alpha channel to set as the 'borderColor' option of the area plot.
     * @return A reference to this {@link ColumnPlotOptions} instance for convenient method chaining.
     */
    public T setBorderColor(Color borderColor) {
        return this.setOption("borderColor", borderColor != null ? borderColor.getOptionValue() : null);
    }

    /**
     * Convenience method for setting the 'borderRadius' option of the column plot options.  Equivalent to:
     * <pre><code>
     *     columnPlotOptions.setOption("borderRadius", 4);
     * </code></pre>
     * The corner radius of the border surrounding each column or bar. Defaults to 0.
     *
     * @param borderRadius The corner radius of the border surrounding each column or bar.
     * @return A reference to this {@link ColumnPlotOptions} instance for convenient method chaining.
     */
    public T setBorderRadius(Number borderRadius) {
        return this.setOption("borderRadius", borderRadius);
    }

    /**
     * Convenience method for setting the 'borderWidth' option of the column plot options.  Equivalent to:
     * <pre><code>
     *     columnPlotOptions.setOption("borderWidth", 4);
     * </code></pre>
     * The width of the border surrounding each column or bar. Defaults to 1.
     *
     * @param borderWidth The width of the border surrounding each column or bar.
     * @return A reference to this {@link ColumnPlotOptions} instance for convenient method chaining.
     */
    public T setBorderWidth(Number borderWidth) {
        return this.setOption("borderWidth", borderWidth);
    }

    /**
     * Convenience method for setting the 'colorByPoint' option of the column plot options.  Equivalent to:
     * <pre><code>
     *     columnPlotOptions.setOption("colorByPoint", true);
     * </code></pre>
     * When using automatic point colors pulled from the options.colors collection, this option determines
     * whether the chart should receive one color per series or one color per point. Defaults to false.
     *
     * TODO: Fix javadoc reference to "options.colors".
     *
     * @param colorByPoint Whether the chart should receive one color per series or one color per point.
     * @return A reference to this {@link ColumnPlotOptions} instance for convenient method chaining.
     */
    public T setColorByPoint(boolean colorByPoint) {
        return this.setOption("colorByPoint", colorByPoint);
    }

    /**
     * Convenience method for setting the 'depth' option of the column plot options.  Equivalent to:
     * <pre><code>
     *     columnPlotOptions.setOption("depth", 40);
     * </code></pre>
     * Depth of the columns in a 3D column chart. Requires highcharts-3d.js. Defaults to 25.
     *
     * @param depth A number representing the depth of the columns in the 3D chart.
     * @return A reference to this {@link ColumnPlotOptions} instance for convenient method chaining.
     */
    public T setDepth(Number depth) {
        return this.setOption("depth", depth);
    }

    /**
     * Convenience method for setting the 'groupPadding' option of the column plot options.  Equivalent to:
     * <pre><code>
     *     columnPlotOptions.setOption("groupPadding", 4);
     * </code></pre>
     * Padding between each value groups, in x axis units. Defaults to 0.2.
     *
     * @param groupPadding Padding between each value groups, in x axis units.
     * @return A reference to this {@link ColumnPlotOptions} instance for convenient method chaining.
     */
    public T setGroupPadding(Number groupPadding) {
        return this.setOption("groupPadding", groupPadding);
    }

    /**
     * Convenience method for setting the 'minPointLength' option of the column plot options.  Equivalent to:
     * <pre><code>
     *     columnPlotOptions.setOption("minPointLength", 4);
     * </code></pre>
     * The minimal height for a column or width for a bar. By default, 0 values are not shown. To visualize
     * a 0 (or close to zero) point, set the minimal point length to a pixel value like 3. In stacked column
     * charts, minPointLength might not be respected for tightly packed values. Defaults to 0.
     *
     * @param minPointLength The minimal height for a column or width for a bar.
     * @return A reference to this {@link ColumnPlotOptions} instance for convenient method chaining.
     */
    public T setMinPointLength(Number minPointLength) {
        return this.setOption("minPointLength", minPointLength);
    }

    /**
     * Convenience method for setting the 'pointPadding' option of the column plot options.  Equivalent to:
     * <pre><code>
     *     columnPlotOptions.setOption("pointPadding", 0.5);
     * </code></pre>
     * Padding between each column or bar, in x axis units. Defaults to 0.1.
     *
     * @param pointPadding Padding between each column or bar, in x axis units.
     * @return A reference to this {@link ColumnPlotOptions} instance for convenient method chaining.
     */
    public T setPointPadding(Number pointPadding) {
        return this.setOption("pointPadding", pointPadding);
    }

    /**
     * Convenience method for setting the 'pointWidth' option of the column plot options.  Equivalent to:
     * <pre><code>
     *     columnPlotOptions.setOption("pointWidth", 2.0);
     * </code></pre>
     * A pixel value specifying a fixed width for each column or bar. When null, the width is calculated
     * from the {@link #setPointPadding(Number)} and {@link #setGroupPadding(Number)}. Defaults to null.
     *
     * @param pointWidth A pixel value specifying a fixed width for each column or bar.
     * @return A reference to this {@link ColumnPlotOptions} instance for convenient method chaining.
     */
    public T setPointWidth(Number pointWidth) {
        return this.setOption("pointWidth", pointWidth);
    }
}
