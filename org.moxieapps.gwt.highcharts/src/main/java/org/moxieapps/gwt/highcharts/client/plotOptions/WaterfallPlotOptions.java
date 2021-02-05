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

/**
 * Represents the general plot options available for all waterfall type series, which can be set either generically
 * on the chart via the {@link org.moxieapps.gwt.highcharts.client.plotOptions.WaterfallPlotOptions} method or directly on a
 * series via the {@link org.moxieapps.gwt.highcharts.client.Series#setPlotOptions(PlotOptions)} method.
 * <p/>
 * Note that these options are only needed if you want to specifically control the general options
 * for all waterfall type series in the entire chart.  If you instead want to control the options for all
 * series in the chart (not just those of a waterfall type), then you can use the {@link SeriesPlotOptions}
 * class instead.  Or, if you want to control the plot options for just one series (and not all waterfall type
 * series in the chart), use the {@link org.moxieapps.gwt.highcharts.client.Series#setPlotOptions(PlotOptions)} method.
 *
 * @author cskowron@moxiegroup.com (Cory Skowronek)
 * @since 1.6.0
 */
public class WaterfallPlotOptions extends PlotOptions<WaterfallPlotOptions> {

    /**
     * Convenience method for setting the 'upColor' option of the chart.  Equivalent to:
     * <pre><code>
     *     chart.setOption("upColor", "#8BBC21");
     * </code></pre>
     * The chart's upColor is the the color which represents any area on the chart which has a positive value.
     * </p>
     * Note that this method is intended for setting the color to a simple RBG hex value.  If you instead
     * want to set a color to include an alpha channel or a gradient, use the {@link #setUpColor(Color)}
     * version instead.
     * @param upColor The color to use for this series.
     * @return A reference to this {@link PlotOptions} instance for convenient method chaining.
     */
    public WaterfallPlotOptions setUpColor(String upColor) {
        return this.setOption("upColor", upColor);
    }

    /**
     * Convenience method for setting the 'upColor' plot option to a gradient or color with an alpha
     * value.  Equivalent to:
     * <pre><code>
     *     chart.setOption("upColor", new Color()
     *        .setLinearGradient(0.0, 0.0, 1.0, 1.0)
     *        .addStop(new Color(255, 255, 255))
     *        .addStop(new Color(200, 200, 255))
     *     );
     * </code></pre>
     * The chart's upColor is the the color which represents any area on the chart which has a positive value.
     * </p>
     * Note that this method is intended for setting the color to a gradient or color that includes
     * an alpha channel.  If you instead just want to set the color to a normal RGB hex value
     * you can use the {@link #setUpColor(String)} version instead.
     * @param upColor The color to use for the series.
     * @return A reference to this {@link PlotOptions} instance for convenient method chaining
     */
    public WaterfallPlotOptions setUpColor(Color upColor) {
        return this.setOption("upColor", upColor != null ? upColor.getOptionValue() : null);
    }


}
