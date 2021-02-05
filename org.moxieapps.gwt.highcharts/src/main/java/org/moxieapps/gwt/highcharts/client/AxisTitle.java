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
 * A configurable class that can be used to represent custom title options for an
 * axis, which can then be set on a specific axis (via the {@link Axis#setAxisTitle(AxisTitle)} method.)
 * Example usage:
 * <code><pre>
 *   chart.getXAxis().setAxisTitle(
 *     new AxisTitle()
 *       .setText("Sales by Month")
 *       .setAlign(AxisTitle.Align.MIDDLE)
 *   );
 * </pre></code>
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.0.0
 */
public class AxisTitle extends Configurable<AxisTitle> {

    /**
     * An enumeration of supported axis title alignment types, which can be passed to methods
     * like {@link AxisTitle#setAlign(AxisTitle.Align)} method.
     */
    public enum Align {

        /**
         * Align the title to the bottom (for a y-axis) or to the left (for an x-axis)
         */
        LOW("low"),

        /**
         * Align the title to the middle (for a y-axis) or to the center (for an x-axis)
         */
        MIDDLE("middle"),

        /**
         * Align the title to the top (for a y-axis) or to the right (for an x-axis)
         */
        HIGH("high");

        private Align(String optionValue) {
            this.optionValue = optionValue;
        }

        private final String optionValue;

        public String toString() {
            return optionValue;
        }

    }

    /**
     * Convenience method for setting the 'align' option of the title.  Equivalent to:
     * <pre><code>
     *     axisTitle.setOption("align", AxisTitle.Align.LOW);
     * </code></pre>
     * Alignment of the title relative to the axis values. Possible values are "low", "middle" or "high".
     * Defaults to {@link AxisTitle.Align#MIDDLE}.
     *
     * @param align The alignment of the title relative to the axis values.
     * @return A reference to this {@link AxisTitle} instance for convenient method chaining.
     */
    public AxisTitle setAlign(Align align) {
        return this.setOption("align", align != null ? align.toString() : null);
    }



    /**
     * Convenience method for setting the 'margin' option of the title.  Equivalent to:
     * <pre><code>
     *     axisTitle.setOption("margin", 60);
     * </code></pre>
     * The pixel distance between the axis labels or line and the title. Defaults
     * to 0 for horizontal axis, 10 for vertical axis.
     *
     * @param margin The pixel distance between the axis labels or line and the title.
     * @return A reference to this {@link AxisTitle} instance for convenient method chaining.
     */
    public AxisTitle setMargin(Number margin) {
        return this.setOption("margin", margin);
    }

    /**
     * Convenience method for setting the 'margin' option of the title.  Equivalent to:
     * <pre><code>
     *     axisTitle.setOption("margin", 60);
     * </code></pre>
     * The rotation of the text in degrees. 0 is horizontal, 270 is vertical reading
     * from bottom to top. Defaults to 0.
     *
     * @param rotation The rotation of the text in degrees.
     * @return A reference to this {@link AxisTitle} instance for convenient method chaining.
     */
    public AxisTitle setRotation(Number rotation) {
        return this.setOption("rotation", rotation);
    }

    /**
     * Convenience method for setting the 'style' options of the axis title.  Equivalent to:
     * <pre><code>
     *     axisTitle.setOption("/style/fontWeight", "bold");
     *     axisTitle.setOption("/style/fontFamily", "serif");
     *     etc.
     * </code></pre>
     * CSS styles for the title. When titles are rotated they are rendered using vector graphic techniques
     * and not all styles are applicable. Most noteworthy, a bug in IE8 renders all rotated strings bold
     * and italic. Defaults to:
     * <ul>
     * <li>color: '#6D869F'</li>
     * <li>fontWeight: 'bold'</li>
     * </ul>
     *
     * @param style CSS styles for the axis title.
     * @return A reference to this {@link AxisTitle} instance for convenient method chaining.
     */
    public AxisTitle setStyle(Style style) {
        return this.setOption("style", style != null ? style.getOptions() : null);
    }

    /**
     * Convenience method for setting the 'text' option of the title.  Equivalent to:
     * <pre><code>
     *     axisTitle.setOption("text", "Sales by Month");
     * </code></pre>
     * The actual text of the axis title. It can contain basic HTML text markup
     * like &lt;b&gt;, &lt;i&gt; and spans with style. Defaults to null.
     * <p/>
     * Note to disable an axis title from being displayed completely, simply set the text
     * to "null".  (This can also be accomplished more simply by just setting the title
     * text to null directly on the axis via the {@link Axis#setAxisTitleText(String)} method.)
     *
     * @param text The actual text of the axis title.
     * @return A reference to this {@link AxisTitle} instance for convenient method chaining.
     */
    public AxisTitle setText(String text) {
        return this.setOption("text", text);
    }

    /**
     * Convenience method for setting the 'y' option of the title.  Equivalent to:
     * <pre><code>
     *     axisTitle.setOption("y", 25);
     * </code></pre>
     * @param y The number of pixels that the y-axis will be offset
     * @return A reference to this {@link AxisTitle} instance for convenient method chaining.
     */
    public AxisTitle setY(Number y) {
        return this.setOption("y", y);
    }

}
