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
 * An interface that can be used to control the display of the labels displayed within a
 * legend.  General usage is as follows:
 * <code><pre>
 * chart.setLegend(
 *   new Legend()
 *     .setLegendLabelsFormatter(
 *         new LegendLabelsFormatter() {
 *            public String format(LegendLabelsData legendLabelsData) {
 *                return legendLabelsData.getSeriesName() + " (click to hide)";
 *            }
 *         }
 *     )
 * );
 * </pre></code>
 * See the documentation on the {@link #format(LegendLabelsData)} function for more details on the
 * capabilities available within custom formatters.
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.3.0
 */
public interface LegendLabelsFormatter {

    /**
     * Callback function to format the text of a label in the legend.
     * <p/>
     * A subset of HTML is supported. The HTML of the label is parsed and converted to SVG, therefore
     * this isn't a complete HTML renderer. The following tags are supported: &lt;b&gt;, &lt;strong&gt;, &lt;i&gt;,
     * &lt;em&gt;, &lt;br/&gt;, and &lt;span&gt;. Spans can be styled with a style attribute, but only text-related
     * CSS that is shared with SVG is handled.
     * <p/>
     * Access to information about the series that the label applies to is provided in the given "LegendLabelsData"
     * object, or in the case of pie chart access to information about the point.
     *
     * @param legendLabelsData An object containing all of the data available to the formatter that it can
     *                       use to determine which text and styling to use for the label.
     * @return The text to display for the label (including any styling).
     */
    public String format(LegendLabelsData legendLabelsData);

}
