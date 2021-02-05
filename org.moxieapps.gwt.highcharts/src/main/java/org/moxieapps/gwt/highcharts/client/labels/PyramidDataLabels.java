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

package org.moxieapps.gwt.highcharts.client.labels;

/**
 * A configurable class that can be used to represent custom data label display options for funnel charts, which
 * can then be set as the default data label display approach and applied to the FunnelPlotOptions
 * (via the {@link org.moxieapps.gwt.highcharts.client.plotOptions.FunnelPlotOptions#setFunnelDataLabels(FunnelDataLabels)} method).
 * <p/>
 * Example usage:
 * <code><pre>
 * chart.setPiePlotOptions(
 *      new PiePlotOptions()
 *          .setPieDataLabels(
 *              new PieDataLabels()
 *                  .setEnabled(true)
 *                  .setConnectorColor("#FF0000)
 *                  .setConnectorWidth(4.0)
 *          )
 * );
 * </pre></code>
 *
 * @since 1.7.0
 * @author cskowron@moxiegroup.com (Cory Skowronek
 */
public class PyramidDataLabels extends ProportionalDataLabels<PyramidDataLabels> {

    // All needed methods are inherited from {@link ProportionalDataLabels}

}
