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

import org.moxieapps.gwt.highcharts.client.Chart;
import org.moxieapps.gwt.highcharts.client.Series;

/**
 * Represents the general plot options available for all spline type series, which can be set either generically
 * on the chart via the {@link Chart#setSplinePlotOptions(SplinePlotOptions)} )} method or directly on a
 * series via the {@link Series#setPlotOptions(PlotOptions)} method.
 * <p/>
 * Note that these options are only needed if you want to specifically control the general options
 * for all spline type series in the entire chart.  If you instead want to control the options for all
 * series in the chart (not just those of a spline type), then you can use the {@link SeriesPlotOptions}
 * class instead.  Or, if you want to control the plot options for just one series (and not all spline type
 * series in the chart), use the {@link org.moxieapps.gwt.highcharts.client.Series#setPlotOptions(PlotOptions)} method.
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.0.0
 */
public class SplinePlotOptions extends PlotOptions<SplinePlotOptions> {

    /**
     * Convenience Method for setting the "gapSize" option of the plot options.  Equivalent to:
     * <pre><code>
     *     splinePlotOptions.setOption("gapSize", 5);
     * </code></pre>
     * Defines when to display a gap in the graph. A gap size of 5 means that if the distance between two points is
     * greater than five times that of the two closest points, the graph will be broken.In practice, this option is
     * most often used to visualize gaps in time series. In a stock chart, intraday data is available for daytime hours,
     * while gaps will appear in nights and weekends.. Defaults to 0.
     * @param gapSize The distance between points needed to display a gap in the series.
     * @return A reference to this {@link SplinePlotOptions} instance for convenient method chaining.
     * @since 1.6.0
     */
    public SplinePlotOptions setGapSize(Number gapSize) {
        return this.setOption("gapSize", gapSize);
    }

    /**
     * Convenience method for setting the 'connectNulls' option for the chart.  Equivalent to:
     * <pre><code>
     *     splinePlotOptions.setOption("connectNulls", true);
     * </code></pre>
     * Whether to draw a line between points on either side of a null point, or render a gap between them.
     * @param connectNulls 'true' to connect points on either side of a null point
     * @return A reference to this {@link SplinePlotOptions} instance for convenient method chaining.
     * @since 1.6.0
     */
    public SplinePlotOptions setConnectNulls(boolean connectNulls) {
        return this.setOption("connectNulls", connectNulls);
    }

}

