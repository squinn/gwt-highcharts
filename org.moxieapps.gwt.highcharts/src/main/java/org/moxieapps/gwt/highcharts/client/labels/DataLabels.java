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

import org.moxieapps.gwt.highcharts.client.plotOptions.PlotOptions;

/**
 * A simple configurable class that can be used to represent custom data label display options, which
 * can then be set as the default data label display approach which can then be applied to a PlotOptions
 * (via the {@link PlotOptions#setDataLabels(org.moxieapps.gwt.highcharts.client.labels.DataLabels)} method).
 * <p/>
 * Note that PlotOptions can then be applied either to the entire chart (via the
 * {@link org.moxieapps.gwt.highcharts.client.Chart#setSeriesPlotOptions(org.moxieapps.gwt.highcharts.client.plotOptions.SeriesPlotOptions)}
 * method), or to a specific data series (via the {@link org.moxieapps.gwt.highcharts.client.Series#setPlotOptions(PlotOptions)}
 * method).
 * <p/>
 * Example usage:
 * <code><pre>
 *   chart.setSeriesPlotOptions(
 *     new SeriesPlotOptions()
 *       .setDataLabels(
 *           new DataLabels()
 *              .setEnabled(true)
 *              .setAlign(Labels.Align.CENTER)
 *              .setColor("#CC0000")
 *       )
 *   );
 * </pre></code>
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.0.0
 */
public class DataLabels extends BaseDataLabels<DataLabels> {

    // Everything we need is inherited from our base class, so this class is really only needed to
    // handle setting the correct generic type (so the user doesn't need to deal with the type manually)

}
