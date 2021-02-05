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
 * Represents the general dial options available for for the gauge's dial, which can be set either generically
 * on the chart via the {@link org.moxieapps.gwt.highcharts.client.Chart#setGaugePlotOptions(GaugePlotOptions)} method or directly on a
 * series via the {@link org.moxieapps.gwt.highcharts.client.Series#setPlotOptions(PlotOptions)} method.
 * <p/>
 * Sample usage:
 * <pre><code>
 *     Chart.setGaugePlotOptions(
 *          new GaugePlotOptions()
 *              .setPivotOptions(
 *                  new Pivot()
 *                      .setRadius("75%")
 *              )
 *     );
 * </code></pre>
 * @author cskowron@moxiegroup.com (Cory Skowronek)
 * @since 1.6.0
 */

public class Pivot extends BaseGaugePart<Pivot> {

    // Everything we need is inherited from our base class, so this class is really only needed to
    // handle setting the correct generic type (so the user doesn't need to deal with the type manually)

}
