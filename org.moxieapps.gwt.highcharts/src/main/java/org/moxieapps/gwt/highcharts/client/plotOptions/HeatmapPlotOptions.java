/*
 * Copyright 2014 Moxie Group
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

import org.moxieapps.gwt.highcharts.client.Chart;
import org.moxieapps.gwt.highcharts.client.Series;

/**
 * represents the general plot options available for all heatmap type series, which can be set wither generically on
 * the chart via the {@link Chart#setHeatmapPlotOptions(HeatmapPlotOptions)} method or directly on a series via the
 * {@link Series#setPlotOptions(PlotOptions}
 * <p/>
 * Note that these options are only needed if you want to specifically control the general options for all heatmap type
 * series in the entire chart.  If you instead want to control the options for all series in the chart (not just those
 * of a spline type,) then you can use the {@link SeriesPlotOptions} class instead.  Or, if you want to control the plot
 * options for just one series (and not all spline type series in the chart,) use the {@link Series#setPlotOptions)}
 * method.
 *
 * @author cskowron@moxiegroup.com (Cory Skowronek)
 * @since 1.7.0
 */
public class HeatmapPlotOptions extends BaseMapOptions<HeatmapPlotOptions> {

    /**
     * Convenience method for setting the 'borderRadius' option of the heatmap.  Equivalent to:
     * <pre><code>
     *     heatmapPlotOptions.setOption("borderRadius", 25);
     * </code></pre>
     * The corner radius of the border surrounding each column or bar. Defaults to 0.
     * @param borderRadius The corner radius of the border surrounding each column or bar.
     * @return A reference to this {@link HeatmapPlotOptions} instance for convenient method chaining.
     */
    public HeatmapPlotOptions setBorderRadius(Number borderRadius) {
        return this.setOption("borderRadius", borderRadius);
    }

    /**
     * convenience method for setting the 'borderWidth' option of the heatmap.  Equivalent to:
     * <pre><code>
     *     heatmapPlotOptions.setOption("borderWidth", true);
     * </code></pre>
     * The width of the border surrounding each column or bar. Defaults to 1.
     * @param borderWidth The width of the border surrounding each column or bar.
     * @return A reference to this {@link HeatmapPlotOptions} instance for convenient method chaining.
     */
    public HeatmapPlotOptions setBorderWidth(Number borderWidth) {
        return this.setOption("borderWidth", borderWidth);
    }

    /**
     * convenience method for setting the 'colorByPoint' option of the heatmap.  Equivalent to:
     * <pre><code>
     *     heatmapPlotOptions.setOption("colorByPoint", true);
     * </code></pre>
     * When using automatic point colors pulled from the options.colors collection, this option determines whether the
     * chart should receive one color per series or one color per point. Defaults to false.
     * @param colorByPoint Whether the chart should receive one color per series or one color per point.
     * @return A reference to this {@link HeatmapPlotOptions} instance for convenient method chaining.
     */
    public HeatmapPlotOptions setColorByPoint(boolean colorByPoint) {
        return this.setOption("colorByPoint", colorByPoint);
    }

    /**
     * Convenience method for setting the 'colors' option of the heatmap.  Equivalent to:
     * <pre><code>
     *     heatmapPlotOptions.setOption("colors", "#EBEE00", "#FF00FF", "#0000FF");
     * </code></pre>
     * A series specific or series type specific color set to apply instead of the global colors when colorByPoint is true.
     * @param colors An array of strings representing the colors to apply to the heatmap.
     * @return A reference to this {@link HeatmapPlotOptions} instance for convenient method chaining.
     * @see #setColorByPoint(boolean)
     */
    public HeatmapPlotOptions setColors(String... colors) {
        return this.setOption("colors", colors);
    }

    /**
     * Convenience method for setting the 'colSize' option of the heatmap.  Equivalent to:
     * <pre><code>
     *     heatmapPlotOptions.setOption("colSize", 10);
     * </code></pre>
     * The column size - how many X axis units each column in the heatmap should span. Defaults to 1.
     * @param colSize The number of units on the x-axis the map will span.
     * @return A reference to this {@link HeatmapPlotOptions} instance for convenient method chaining.
     */
    public HeatmapPlotOptions setColSize(Number colSize) {
        return this.setOption("colsize", colSize);
    }

    /**
     * Convenience method for setting the 'rowsize' option of the heatmap.  Equivalent to:
     * <pre><code>
     *     heatmapPlotOptions.setOption("rowsize", 10);
     * </code></pre>
     * The row size - how many Y axis units each heatmap row should span. Defaults to 1.
     * @param rowSize The number of units on the y-axis the heatmap should span.
     * @return A reference to this {@link HeatmapPlotOptions} instance for convenient method chaining.
     */
    public HeatmapPlotOptions setRowSize(Number rowSize) {
        return this.setOption("rowsize", rowSize);
    }


}
