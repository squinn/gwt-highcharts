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

/**
 * Represents the general plot options available for all gauge type series, which can be set either generically
 * on the chart via the {@link org.moxieapps.gwt.highcharts.client.Chart#setGaugePlotOptions(GaugePlotOptions)} )} method or directly on a
 * series via the {@link org.moxieapps.gwt.highcharts.client.Series#setPlotOptions(PlotOptions)} method.
 * <p/>
 * Note that these options are only needed if you want to specifically control the general options
 * for all gauge type series in the entire chart.  If you instead want to control the options for all
 * series in the chart (not just those of a gauge type), then you can use the {@link SeriesPlotOptions}
 * class instead.  Or, if you want to control the plot options for just one series (and not all gauge type
 * series in the chart), use the {@link org.moxieapps.gwt.highcharts.client.Series#setPlotOptions(PlotOptions)} method.
 * @author cskowron@moxiegroup.com (Cory Skowronek)
 * @since 1.6.0
 */
public class GaugePlotOptions extends BaseGaugePlotOptions<GaugePlotOptions> {

    /**
     * Convenience method for setting the "dial" option for gauge charts.  Equivalent to:
     * <pre><code>
     *     gaugePlotOptions.setOption("wrap", false)
     * </code></pre>
     * <pre><code>
     *     chart.setGaugePlotOptions(new GaugePlotOptions()
     *          .setPivotOptions(new Dial()
     *              .setRadius(10)
     *              .setBorderWidth(1)
     *           )
     *     );
     * </code></pre>
     * @param dial An instance of the Dial class which can be used to set the various dial options for the gauge.
     * @return A reference to this {@link GaugePlotOptions} for convenient method chaining.
     */
    public GaugePlotOptions setDialOptions(Dial dial) {
        return this.setOption("dial", dial);
    }

    /**
     * Convenience method for setting the "pivot" option for gauge charts.  Equivalent to:
     * <pre><code>
     *     gaugePlotOptions.setOption("/pivot/radius", "50%");
     * </code></pre>
     * Sample usage:
     * <pre><code>
     *     chart.setGaugePlotOptions(new GaugePlotOptions()
     *          .setDialOptions(new Dial()
     *              .setRadius("50%")
     *              .setBaseWidth(10)
     *           )
     *     );
     * </code></pre>
     * @param pivot An instance of the Pivot class which can be used to set various options pivot options for the gauge.
     * @return A reference to this {@link GaugePlotOptions} for convenient method chaining.
     */
    public GaugePlotOptions setPivotOptions(Pivot pivot) {
        return this.setOption("pivot", pivot);
    }

    /**
     * Convenience method for setting the "wrap" option for gauge charts.  Equivalent to:
     * <pre><code>
     *     gaugePlotOptions.setOption("wrap", false)
     * </code></pre>
     * When this option is true, the dial will wrap around the axes.
     * For instance, in a full-range gauge going from 0 to 360, a value of 400 will point to 40.
     * When wrap is false, the dial stops at 360. Defaults to true
     * @param wrap Whether the dial will wrap around its maximum value.
     * @return A reference to this {@link GaugePlotOptions} for convenient method chaining.
     */
    public GaugePlotOptions setWrap(boolean wrap) {
        return this.setOption("wrap", wrap);
    }
}
