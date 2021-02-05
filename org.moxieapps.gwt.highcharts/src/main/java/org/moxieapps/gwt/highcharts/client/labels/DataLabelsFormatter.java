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
 * An interface that can be used to control the display of the data labels displayed within a
 * series.  General usage is as follows:
 * <code><pre>
 * chart.setSeriesPlotOptions(
 *   new SeriesPlotOptions()
 *     .setDataLabels(
 *       new DataLabels()
 *         .setFormatter(new DataLabelsFormatter() {
 *            public String format(DataLabelsData dataLabelsData) {
 *                return dataLabelsData.getYAsLong() + " degrees";
 *            }
 *         })
 *     )
 * );
 * </pre></code>
 * See the documentation on the {@link #format(DataLabelsData)} function for more details on the
 * capabilities available within custom formatters.
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.0.0
 */
public interface DataLabelsFormatter {

    /**
     * Callback function to format the text of a data label.
     * <p/>
     * A subset of HTML is supported. The HTML of the label is parsed and converted to SVG, therefore
     * this isn't a complete HTML renderer. The following tags are supported: &lt;b&gt;, &lt;strong&gt;, &lt;i&gt;,
     * &lt;em&gt;, &lt;br/&gt;, and &lt;span&gt;. Spans can be styled with a style attribute, but only text-related
     * CSS that is shared with SVG is handled.
     * <p/>
     * Available data provided in the given "DataLabelsData" object are:
     * <ul>
     * <li>
     * <b>percentage</b> : Stacked series and pies only. The point's percentage of the total.
     * </li>
     * <li>
     * <b>point.name</b> : The point objects name, if defined.
     * </li>
     * <li>
     * <b>series.name</b> : The name of the series that the data label is part of.
     * </li>
     * <li>
     * <b>total</b> : Stacked series only. The total value at this point's x value.
     * </li>
     * <li>
     * <b>x</b> : The X value of the point.
     * </li>
     * <li>
     * <b>y</b> : The Y value of the point.
     * </li>
     * </ul>
     *
     * @param dataLabelsData An object containing all of the data available to the formatter that it can
     *                       use to determine which text and styling to use for the label.
     * @return The text to display for the label (including any styling).
     */
    public String format(DataLabelsData dataLabelsData);

}
