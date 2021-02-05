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
 * An interface that can be used to control the display of the Y axis stack labels to contain
 * custom text or formatting.  General usage is as follows:
 * <code><pre>
 * chart.getYAxis().setStackLabels(
 *   new StackLabels()
 *     .setEnabled(true)
 *     .setFormatter(new StackLabelsFormatter() {
 *        public String format(StackLabelsData stackLabelsData) {
 *            return stackLabelsData.getTotalAsLong() + " degrees";
 *        }
 *     })
 * );
 * </pre></code>
 * See the documentation on the {@link #format(StackLabelsData)} function for more details on the
 * capabilities available within custom formatters.
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.0.0
 */
public interface StackLabelsFormatter {

    /**
     * Callback function to format the text of a stack label on a Y axis.
     * <p/>
     * A subset of HTML is supported. The HTML of the label is parsed and converted to SVG, therefore
     * this isn't a complete HTML renderer. The following tags are supported: &lt;b&gt;, &lt;strong&gt;, &lt;i&gt;,
     * &lt;em&gt;, &lt;br/&gt;, and &lt;span&gt;. Spans can be styled with a style attribute, but only text-related
     * CSS that is shared with SVG is handled.
     * <p/>
     * Available data provided in the given "StackLabelsData" object are:
     * <ul>
     * <li>
     * <b>total</b> : The total value of the stack at this point.
     * </li>
     * </ul>
     *
     * @param stackLabelsData An object containing all of the data available to the formatter that it can
     *                       use to determine which text and styling to use for the label.
     * @return The text to display for the label (including any styling).
     */
    public String format(StackLabelsData stackLabelsData);

}
