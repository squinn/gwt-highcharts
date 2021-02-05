/*
 * Copyright 2015 Moxie Group
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

import org.moxieapps.gwt.highcharts.client.labels.PyramidDataLabels;

/**
 *Represents the general plot options available for all pyramid type series, which can be set either generically
 * on the chart via the {@link org.moxieapps.gwt.highcharts.client.Chart#setPyramidPlotOptions(PyramidPlotOptions)} )} method or directly on a
 * series via the {@link org.moxieapps.gwt.highcharts.client.Series#setPlotOptions(PlotOptions)} method.
 * <p/>
 * Note that these options are only needed if you want to specifically control the general options
 * for all pyramid type series in the entire chart.  If you instead want to control the options for all
 * series in the chart (not just those of a pyramid type), then you can use the {@link SeriesPlotOptions}
 * class instead.  Or, if you want to control the plot options for just one series (and not all column type
 * series in the chart), use the {@link org.moxieapps.gwt.highcharts.client.Series#setPlotOptions(PlotOptions)} method.
 *
 * @author cskowron@moxiegroup.com (Cory Skowronek)
 * @since 1.7.0
 */
public class PyramidPlotOptions extends BaseProportionalPlotOptions<PyramidPlotOptions> {

    /**
     * Convenience method for setting the 'height' option of a funnel chart.  Equivalent to:
     * <pre><code>
     *     pyramidPlotOptions.setOption("height", 12);
     * </code></pre>
     * The height of the funnel or pyramid. If it is a number it defines the pixel height,
     * if it is a percentage string it is the percentage of the plot area height.
     * <p/>
     * Note that this method is intended for setting the height to a fixed pixel amount.  If instead you want to
     * set the height as percentage of the plot siz you can use the {@link #setHeight(String)} instead.
     * <p/>
     * @param height The height of a funnel in pixels
     * @return A reference to this {@link PyramidPlotOptions} instance for convenient method chaining.
     * @see PyramidPlotOptions#setHeight(String)
     * @since 1.7.0
     */
    public PyramidPlotOptions setHeight(Number height) {
        return this.setOption("height", height);
    }

    /**
     * Convenience method for setting the 'height' option of a funnel chart.  Equivalent to:
     * <pre><code>
     *     pyramidPlotOptions.setOption("height", "12%");
     * </code></pre>
     * The height of the funnel or pyramid. If it is a number it defines the pixel height,
     * if it is a percentage string it is the percentage of the plot area height.
     * <p/>
     * Note that this method is intended for setting the height to a percentage of the plot size.
     * If instead you want to set the height as a set number of pixels you can use the {@link #setHeight(Number)}
     * instead.
     * <p/>
     * @param height The height of a funnel as a percentage of the plot size
     * @return A reference to this {@link PyramidPlotOptions} instance for convenient method chaining.
     * @see PyramidPlotOptions#setHeight(Number)
     * @since 1.7.0
     */
    public PyramidPlotOptions setHeight(String height) {
        return this.setOption("height", height);
    }

    /**
     * Convenience method for setting the 'dataLabels' plot option to a configuration object
     * that is more specific to funnel charts. Equivalent to:
     * <pre><code>
     *      pyramidPlotOptions.setOption("/dataLabels/connectorWidth", 2.0);
     *      pyramidPlotOptions.setOption("/dataLabels/connectorPadding", 5.0);
     *      etc...
     * </code></pre>
     * Defines the appearance of the data labels of the pie, which are the static labels for each point.
     * @param pyramidDataLabels The configuration of how the pie's data labels should appear.
     * @return A reference to this {@link PiePlotOptions} instance for convenient method chaining.
     */
    public PyramidPlotOptions setPyramidDataLabels(PyramidDataLabels pyramidDataLabels) {
        return super.setBaseDataLabels(pyramidDataLabels);

    }

}
