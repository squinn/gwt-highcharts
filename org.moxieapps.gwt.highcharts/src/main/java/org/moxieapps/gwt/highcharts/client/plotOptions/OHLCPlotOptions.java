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

/**
 * Represents the general plot options available for all OHLC type series, which can be set either generically
 * on the chart via the {@link org.moxieapps.gwt.highcharts.client.StockChart#setOHLCPlotOptions(org.moxieapps.gwt.highcharts.client.plotOptions.OHLCPlotOptions)} )} method or directly on a
 * series via the {@link org.moxieapps.gwt.highcharts.client.Series#setPlotOptions(org.moxieapps.gwt.highcharts.client.plotOptions.PlotOptions)} method.
 * <p/>
 * Note that OHLC series types are only available when using the {@link org.moxieapps.gwt.highcharts.client.StockChart} widget.
 * <p/>
 * Note that these options are only needed if you want to specifically control the general options
 * for all OHLC type series in the entire chart.  If you instead want to control the options for all
 * series in the chart (not just those of an OHLC type), then you can use the {@link org.moxieapps.gwt.highcharts.client.plotOptions.SeriesPlotOptions}
 * class instead.  Or, if you want to control the plot options for just one series (and not all OHLC type
 * series in the chart), use the {@link org.moxieapps.gwt.highcharts.client.Series#setPlotOptions(org.moxieapps.gwt.highcharts.client.plotOptions.PlotOptions)} method.
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.4.0
 */
public class OHLCPlotOptions extends PlotOptions<OHLCPlotOptions> {

    /**
     * Convenience method for setting the 'grouping' option for the chart. Equivalent to:
     * <pre><code>
     *     OHLCPlotOptions.setOption("grouping", false);
     * </code></pre>
     * Whether to group non-stacked columns or to let them render independent of each other.
     * Non-grouped columns will be laid out individually and overlap each other. Defaults to true.
     * @param grouping False to disable grouping of columns
     * @return A reference to this {@link OHLCPlotOptions} for convenient method chaining.
     * @since 1.6.0
     */
    public OHLCPlotOptions setGrouping(boolean grouping) {
        return this.setOption("grouping", grouping);
    }

}

