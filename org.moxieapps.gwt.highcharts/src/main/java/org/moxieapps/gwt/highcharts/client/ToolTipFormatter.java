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

package org.moxieapps.gwt.highcharts.client;

/**
 * An interface that can be used to control the information of the tooltip area to contain
 * custom text or formatting.  General usage is as follows:
 * <code><pre>
 * chart.setToolTip(
 *   new ToolTip()
 *     .setToolTipFormatter(new ToolTipFormatter() {
 *        public String format(ToolTipData toolTipData) {
 *            return toolTipData.getXAsLong() + " degrees";
 *        }
 *     })
 * );
 * </pre></code>
 * See the documentation on the {@link #format(ToolTipData)} function for more details on the
 * capabilities available within custom formatters.
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.0.0
 */
public interface ToolTipFormatter {

    /**
     * Callback function to format the text of the tooltip. Return null to disable tooltip for a specific
     * point on series.
     * <p/>
     * A subset of HTML is supported. The HTML of the tooltip is parsed and converted to SVG, therefore
     * this isn't a complete HTML renderer. The following tags are supported: &lt;b&gt;, &lt;strong&gt;, &lt;i&gt;,
     * &lt;em&gt;, &lt;br/&gt;, and &lt;span&gt;. Spans can be styled with a style attribute, but only text-related
     * CSS that is shared with SVG is handled.
     * <p/>
     * Since version 2.1 the tooltip can be shared between multiple series through the
     * {@link ToolTip#setShared(boolean)} option.  The available data in the formatter differ a bit depending
     * on whether the tooltip is shared or not. In a shared tooltip, all properties except x, which is common
     * for all points, are kept in an array, this.points.
     * <p/>
     * Available data provided in the given "ToolTipData" object are:
     * <ul>
     * <li>
     *     <b>percentage</b> (not shared) or <b>points[i].percentage</b> (shared) :
     *     Stacked series and pies only. The point's percentage of the total.
     * </li>
     * <!--
     * <li>
     *     <b>point</b> (not shared) or <b>points[i].point</b> (shared) :
     *     The point object. The point name, if defined, is available through {@link Point#getName()}.
     * </li>
     * <li>
     *     <b>points</b> :
     *     In a shared tooltip, this is an array containing all other properties for each point.
     * </li>
     * <li>
     *     <b>series</b> (not shared) or <b>points[i].series</b> (shared) :
     *     The series object. The series name is available through this.series.name.
     * </li>
     * -->
     * <li>
     *     <b>point.name</b> (not shared) or <b>points[i].point.name</b> (shared) :
     *     The "name" property of the point object that hte tooltip is hovering over.
     * </li>
     * <li>
     *     <b>series.name</b> (not shared) or <b>points[i].series.name</b> (shared) :
     *     The name of the series that the point is a part of.
     * </li>
     * <li>
     *     <b>total</b> (not shared) or <b>points[i].total</b> (shared) :
     *     Stacked series only. The total value at this point's x value.
     * </li>
     * <li>
     *     <b>x</b> :
     *     The x value. This property is the same regardless of the tooltip being shared or not.
     * </li>
     * <li>
     *     <b>y</b> (not shared) or <b>points[i].y</b> (shared) :
     *     The y value.
     * </li>
     * </ul>
     *
     * @param toolTipData An object containing all of the data available to the formatter that it can
     *                    use to determine which text and styling to use in the tooltip.
     * @return The text to include in the tooltip (including any styling), or null to disable the tooltip
     *         for the data point.
     */
    public String format(ToolTipData toolTipData);

}
