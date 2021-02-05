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
import org.moxieapps.gwt.highcharts.client.events.PointLegendItemClickEventHandler;
import org.moxieapps.gwt.highcharts.client.labels.PieDataLabels;

/**
 * Represents the general plot options available for all pie type series, which can be set either generically
 * on the chart via the {@link Chart#setPiePlotOptions(PiePlotOptions)} )} method or directly on a
 * series via the {@link Series#setPlotOptions(PlotOptions)} method.
 * <p/>
 * Note that these options are only needed if you want to specifically control the general options
 * for all pie type series in the entire chart.  If you instead want to control the options for all
 * series in the chart (not just those of a pie type), then you can use the {@link SeriesPlotOptions}
 * class instead.  Or, if you want to control the plot options for just one series (and not all pie type
 * series in the chart), use the {@link org.moxieapps.gwt.highcharts.client.Series#setPlotOptions(PlotOptions)} method.
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.0.0
 */
public class PiePlotOptions extends BaseProportionalPlotOptions<PiePlotOptions> {


    /**
     * Convenience method for setting the 'dataLabels' plot option to a configuration object
     * that is more specific to pie charts. Equivalent to:
     * <pre><code>
     * piePlotOptions.setOption("/dataLabels/connectorWidth", 2.0);
     * piePlotOptions.setOption("/dataLabels/connectorPadding", 5.0);
     * etc...
     * </code></pre>
     * Defines the appearance of the data labels of the pie, which are the static labels for each point.
     * @param pieDataLabels The configuration of how the pie's data labels should appear.
     * @return A reference to this {@link PiePlotOptions} instance for convenient method chaining.
     */
    public PiePlotOptions setPieDataLabels(PieDataLabels pieDataLabels) {
        return super.setBaseDataLabels(pieDataLabels);
    }

    private PointLegendItemClickEventHandler pointLegendItemClickEventHandler;

    /**
     * Set a callback handler that will be invoked whenever the user clicks on the legend item points
     * in a pie series.   Additional information about the click (such as the values of the point clicked) can be
     * found via the {@link org.moxieapps.gwt.highcharts.client.events.PointLegendItemClickEventHandler} instance
     * that is passed to the handler's {@link org.moxieapps.gwt.highcharts.client.events.PointLegendItemClickEventHandler#onClick(org.moxieapps.gwt.highcharts.client.events.PointLegendItemClickEvent)} method.
     *
     * @param pointLegendItemClickEventHandler The handler that should be invoked whenever a legend item click event occurs.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.BaseChart} instance for convenient method chaining.
     *
     * @since 1.1.2
     */
    public PiePlotOptions setPointLegendItemClickEventHandler(PointLegendItemClickEventHandler pointLegendItemClickEventHandler) {
        this.pointLegendItemClickEventHandler = pointLegendItemClickEventHandler;
        return this;
    }

    /**
     * Returns the custom event handler that has been set on the plot options, or null if no event
     * handler has been set.
     *
     * @return The custom event handler that has been applied, or null if it has not been set.
     *
     * @since 1.1.2
     */
    public PointLegendItemClickEventHandler getPointLegendItemClickEventHandler() {
        return this.pointLegendItemClickEventHandler;
    }
}

