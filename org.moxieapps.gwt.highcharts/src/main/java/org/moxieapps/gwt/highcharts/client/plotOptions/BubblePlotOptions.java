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
import org.moxieapps.gwt.highcharts.client.Color;
import org.moxieapps.gwt.highcharts.client.Series;

/**
 * Represents the general plot options available for all bubble type series, which can be set either generically
 * on the chart via the {@link Chart#setBubblePlotOptions(BubblePlotOptions)} )} method or directly on a
 * series via the {@link Series#setPlotOptions(PlotOptions)} method.
 * <p/>
 * Note that these options are only needed if you want to specifically control the general options
 * for all bar type series in the entire chart.  If you instead want to control the options for all
 * series in the chart (not just those of a bar type), then you can use the {@link SeriesPlotOptions}
 * class instead.  Or, if you want to control the plot options for just one series (and not all bar type
 * series in the chart), use the {@link org.moxieapps.gwt.highcharts.client.Series#setPlotOptions(PlotOptions)} method.
 *
 * @author cskowron@moxiegroup.com (Cory Skowronek)
 * @since 1.6.0
 */
public class BubblePlotOptions extends PlotOptions<BubblePlotOptions>{

    /**
     * Convenience method for setting the "displayNegative" option for the bubble plot options.  Equivalent to:
     * <pre><code>
     *     bubblePlotOptions.setOptions("displayNegative", true);
     * </code></pre>
     * Whether to display negative sized bubbles. The threshold is given by the zThreshold option,
     * and negative bubbles can be visualized by setting negativeColor. Defaults to true.
     * @param displayNegative 'true' to display negative-sized bubbles
     * @return A reference to this {@link BubblePlotOptions} instance for convenient method chaining.
     */
    public BubblePlotOptions setDisplayNegative(boolean displayNegative) {
        return this.setOption("displayNegative", displayNegative);
    }


    /**
     * Convenience method for setting the "zThreshold" option for the bubble plot options.  Equivalent to:
     * <pre><code>
     *     bubblePlotOptions.setOptions("zThreshold", 0);
     * </code></pre>
     * When displayNegative is false, bubbles with lower Z values are skipped.
     * When displayNegative is true and a negativeColor is given, points with lower Z is colored. Defaults to 0.
     * @param zThreshold The minimum z-value for a point to be shown in a bubble plot
     * @return A reference to this {@link BubblePlotOptions} instance for convenient method chaining.
     */
    public BubblePlotOptions setZThreshold(Number zThreshold) {
        return this.setOption("zThreshold", zThreshold);
    }
}
