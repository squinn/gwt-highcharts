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

import org.moxieapps.gwt.highcharts.client.Chart;
import org.moxieapps.gwt.highcharts.client.Series;
import org.moxieapps.gwt.highcharts.client.labels.FunnelDataLabels;

/**
 * Represents the general plot options available for all funnel type series, which can be set either generically
 * on the chart via the {@link Chart#setFunnelPlotOptions(FunnelPlotOptions)} )} method or directly on a
 * series via the {@link Series#setPlotOptions(PlotOptions)} method.
 * <p/>
 * Note that these options are only needed if you want to specifically control the general options
 * for all funnel type series in the entire chart.  If you instead want to control the options for all
 * series in the chart (not just those of a funnel type), then you can use the {@link SeriesPlotOptions}
 * class instead.  Or, if you want to control the plot options for just one series (and not all column type
 * series in the chart), use the {@link org.moxieapps.gwt.highcharts.client.Series#setPlotOptions(PlotOptions)} method.
 *
 * @author cskowron@moxiegroup.com (Cory Skowronek)
 * @since 1.6.0
 */
public class FunnelPlotOptions extends BaseProportionalPlotOptions<FunnelPlotOptions>{

    /**
     * Convenience method for setting the 'dataLabels' plot option to a configuration object
     * that is more specific to funnel charts. Equivalent to:
     * <pre><code>
     * funnelPlotOptions.setOption("/dataLabels/connectorWidth", 2.0);
     * funnelPlotOptions.setOption("/dataLabels/connectorPadding", 5.0);
     * etc...
     * </code></pre>
     * Defines the appearance of the data labels of the pie, which are the static labels for each point.
     * @param funnelDataLabels The configuration of how the pie's data labels should appear.
     * @return A reference to this {@link PiePlotOptions} instance for convenient method chaining.
     */
    public FunnelPlotOptions setFunnelDataLabels(FunnelDataLabels funnelDataLabels) {
        return super.setBaseDataLabels(funnelDataLabels);
    }

    /**
     * Convenience method for setting the 'height' option of a funnel chart.  Equivalent to:
     * <pre><code>
     *     funnelPlotOptions.setOption("height", 12);
     * </code></pre>
     * The height of the funnel or pyramid. If it is a number it defines the pixel height,
     * if it is a percentage string it is the percentage of the plot area height.
     * <p/>
     * Note that this method is intended for setting the height to a fixed pixel amount.  If instead you want to
     * set the height as percentage of the plot siz you can use the {@link #setHeight(String)} instead.
     * <p/>
     * @param height The height of a funnel in pixels
     * @return A reference to this {@link PiePlotOptions} instance for convenient method chaining.
     * @see FunnelPlotOptions#setHeight(String)
     * @since 1.7.0
     */
    public FunnelPlotOptions setHeight(Number height) {
        return this.setOption("height", height);
    }

    /**
     * Convenience method for setting the 'height' option of a funnel chart.  Equivalent to:
     * <pre><code>
     *     funnelPlotOptions.setOption("height", "12%");
     * </code></pre>
     * The height of the funnel or pyramid. If it is a number it defines the pixel height,
     * if it is a percentage string it is the percentage of the plot area height.
     * <p/>
     * Note that this method is intended for setting the height to a percentage of the plot size.
     * If instead you want to set the height as a set number of pixels you can use the {@link #setHeight(Number)}
     * instead.
     * <p/>
     * @param height The height of a funnel as a percentage of the plot size
     * @return A reference to this {@link PiePlotOptions} instance for convenient method chaining.
     * @see FunnelPlotOptions#setHeight(Number)
     * @since 1.7.0
     */
    public FunnelPlotOptions setHeight(String height) {
        return this.setOption("height", height);
    }

    /**
     * Convenience method for setting the "height" option for the funnel plot options.  Equivalent to:
     * <pre><code>
     *     funnelPlotOptions.setOptions("height", 4.0);
     * </code></pre>
     * The height of the neck, the lower part of a funnel. If it is a number it defines the pixel height,
     * if it is a percentage string it is the percentage of the plot area height.
     * @param height The height, in pixels, of the neck.
     * @return A reference to this {@link FunnelPlotOptions} instance for convenient method chaining.
     */
    public FunnelPlotOptions setNeckHeight(Number height) {
        return this.setOption("neckHeight", height);
    }

    /**
     * Convenience method for setting the "height" option for the funnel plot options.  Equivalent to:
     * <pre><code>
     *     funnelPlotOptions.setOptions("height", "5%");
     * </code></pre>
     * The height of the neck, the lower part of a funnel. If it is a number it defines the pixel height,
     * if it is a percentage string it is the percentage of the plot area height.
     * @param neckHeight The height of the neck, as a percentage of the plot area height.
     * @return A reference to this {@link FunnelPlotOptions} instance for convenient method chaining.
     */
    public FunnelPlotOptions setNeckHeight(String neckHeight) {
        return this.setOption("neckHeight", neckHeight);
    }

    /**
     * Convenience method for setting the "neckWidth" option for the funnel plot options.  Equivalent to:
     * <pre><code>
     *     funnelPlotOptions.setOptions("neckWidth", 3.0);
     * </code></pre>
     * The width of the neck, the lower part of the funnel. A number defines pixel width, a percentage string defines a percentage of the plot area width.
     * @param neckWidth The width, in pixels, of the neck.
     * @return A reference to this {@link FunnelPlotOptions} instance for convenient method chaining.
     */
    public FunnelPlotOptions setNeckWidth(Number neckWidth) {
        return this.setOption("neckWidth", neckWidth);
    }

    /**
     * Convenience method for setting the "neckWidth" option for the funnel plot options.  Equivalent to:
     * <pre><code>
     *     funnelPlotOptions.setOptions("neckWidth", "10%");
     * </code></pre>
     * The width of the neck, the lower part of the funnel. A number defines pixel width, a percentage string defines a percentage of the plot area width.
     * @param neckWidth The width of the neck as a percentage of the plot width.
     * @return A reference to this {@link FunnelPlotOptions} instance for convenient method chaining.
     */
    public FunnelPlotOptions setNeckWidth(String neckWidth) {
        return this.setOption("neckWidth", neckWidth);
    }

    /**
     * Convenience method for setting the "width" option for the funnel plot options.  Equivalent to:
     * <pre><code>
     *     funnelPlotOptions.setOptions("width", 50);
     * </code></pre>
     * The width of the funnel compared to the width of the plot area, or the pixel width if it is a number. Defaults to 90%.
     * @param width The width, in pixels, of the funnel.
     * @return A reference to this {@link FunnelPlotOptions} instance for convenient method chaining.
     */
    public FunnelPlotOptions setWidth(Number width) {
        return this.setOption("width", width);
    }

    /**
     * Convenience method for setting the "width" option for the funnel plot options.  Equivalent to:
     * <pre><code>
     *     funnelPlotOptions.setOptions("width", "50%");
     * </code></pre>
     * The width of the funnel compared to the width of the plot area, or the pixel width if it is a number. Defaults to 90%.
     * @param width The width of the funnel as a percentage of the plot width.
     * @return A reference to this {@link FunnelPlotOptions} instance for convenient method chaining.
     */
    public FunnelPlotOptions setWidth(String width) {
        return this.setOption("width", width);
    }
}
