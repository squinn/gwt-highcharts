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

package org.moxieapps.gwt.highcharts.client.labels;

/**
 * A configurable class that can be used to represent custom data label display options for pie charts and funnel charts, which
 * can then be set as the default data label display approach and applied to the ProportionalPlotOptions
 * (via the {@link org.moxieapps.gwt.highcharts.client.plotOptions.FunnelPlotOptions#setFunnelDataLabels(FunnelDataLabels)}
 * or {@link org.moxieapps.gwt.highcharts.client.plotOptions.PiePlotOptions#setPieDataLabels(PieDataLabels)}  methods).
 * <p/>
 * Example usage:
 * <code><pre>
 *   chart.setPiePlotOptions(
 *     new PiePlotOptions()
 *       .setPieDataLabels(
 *           new ProportionalDataLabels()
 *              .setEnabled(true)
 *              .setConnectorColor("#FF0000)
 *              .setConnectorWidth(4.0)
 *       )
 *   );
 * </pre></code>
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.0.0
 */
public abstract class ProportionalDataLabels<T extends ProportionalDataLabels> extends BaseDataLabels<T> {

    /**
     * Convenience method for setting the 'connectorColor' option for the data labels.  Equivalent to:
     * <pre><code>
     *     labels.setOption("connectorColor", "#CC0000");
     * </code></pre>
     * The color of the line connecting the data label to the pie slice. Defaults to #606060.
     *
     * @param connectorColor The color of the line connecting the data label to the pie slice.
     * @return A reference to this {@link ProportionalDataLabels} instance for convenient method chaining.
     */
    public T setConnectorColor(String connectorColor) {
        return this.setOption("connectorColor", connectorColor);
    }

    /**
     * Convenience method for setting the 'connectorPadding' option for the data labels.  Equivalent to:
     * <pre><code>
     *     labels.setOption("connectorPadding", 2.0);
     * </code></pre>
     * The distance from the data label to the connector. Defaults to 5.
     *
     * @param connectorPadding The The distance from the data label to the connector.
     * @return A reference to this {@link ProportionalDataLabels} instance for convenient method chaining.
     */
    public T setConnectorPadding(Number connectorPadding) {
        return this.setOption("connectorPadding", connectorPadding);
    }

    /**
     * Convenience method for setting the 'connectorWidth' option for the data labels.  Equivalent to:
     * <pre><code>
     *     labels.setOption("connectorWidth", 2.0);
     * </code></pre>
     * The width of the line connecting the data label to the pie slice. Defaults to 1.
     *
     * @param connectorWidth The width of the line connecting the data label to the pie slice.
     * @return A reference to this {@link ProportionalDataLabels} instance for convenient method chaining.
     */
    public T setConnectorWidth(Number connectorWidth) {
        return this.setOption("connectorWidth", connectorWidth);
    }

    /**
     * Convenience method for setting the 'distance' option for the data labels.  Equivalent to:
     * <pre><code>
     *     labels.setOption("distance", 24);
     * </code></pre>
     * The distance of the data label from the pie's edge. Negative numbers put the data label
     * on top of the pie slices. Connectors are only shown for data labels outside the pie.
     * Defaults to 30.
     *
     * @param distance The distance of the data label from the pie's edge.
     * @return A reference to this {@link ProportionalDataLabels} instance for convenient method chaining.
     */
    public T setDistance(Number distance) {
        return this.setOption("distance", distance);
    }

}
