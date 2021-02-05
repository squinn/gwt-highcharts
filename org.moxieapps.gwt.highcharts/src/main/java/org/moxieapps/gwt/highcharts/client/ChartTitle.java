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
 * A configurable class that can be used to represent custom title options for the
 * chart, which can then be set the chart (via the {@link Chart#setChartTitle(ChartTitle)} method.)
 * Example usage:
 * <code><pre>
 *   chart.setChartTitle(
 *     new ChartTitle()
 *       .setText("Sales by Month")
 *       .setAlign(ChartTitle.Align.MIDDLE)
 *   );
 * </pre></code>
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.0.0
 */
public class ChartTitle extends Configurable<ChartTitle> {

    /**
     * An enumeration of supported chart title horizontal alignment types, which can be passed to methods
     * like {@link ChartTitle#setAlign(ChartTitle.Align)}.
     */
    public enum Align {

        /**
         * Left align the chart's title
         */
        LEFT("left"),

        /**
         * Center the chart's title
         */
        CENTER("center"),

        /**
         * Right align the chart's title
         */
        RIGHT("right");

        private Align(String optionValue) {
            this.optionValue = optionValue;
        }

        private final String optionValue;

        public String toString() {
            return optionValue;
        }

    }

    /**
     * An enumeration of supported chart title vertical alignment types, which can be passed to methods
     * like {@link ChartTitle#setVerticalAlign(ChartTitle.VerticalAlign)}.
     */
    public enum VerticalAlign {

        /**
         * Show the title at the top of the chart
         */
        TOP("top"),

        /**
         * Show the title in the middle of the chart
         */
        MIDDLE("middle"),

        /**
         * Show the title at the bottom of the chart
         */
        BOTTOM("bottom");

        private VerticalAlign(String optionValue) {
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
     *     chartTitle.setOption("align", ChartTitle.Align.LEFT);
     * </code></pre>
     * The horizontal alignment of the title. Can be one of "left", "center" and "right".
     * Defaults to {@link ChartTitle.Align#CENTER}.
     *
     * @param align The horizontal alignment of the title.
     * @return A reference to this {@link ChartTitle} instance for convenient method chaining.
     */
    public ChartTitle setAlign(Align align) {
        return this.setOption("align", align != null ? align.toString() : null);
    }

    /**
     * Convenience method for setting the 'floating' option of the title.  Equivalent to:
     * <pre><code>
     *     chartTitle.setOption("floating", true);
     * </code></pre>
     * When the title is floating, the plot area will not move to make space for it. Defaults to false.
     *
     * @param floating 'true' to float the title above the plot area, or 'false' (the default) to make space for it.
     * @return A reference to this {@link ChartTitle} instance for convenient method chaining.
     */
    public ChartTitle setFloating(boolean floating) {
        return this.setOption("floating", floating);
    }

    /**
     * Convenience method for setting the 'margin' option of the title.  Equivalent to:
     * <pre><code>
     *     chartTitle.setOption("margin", 60);
     * </code></pre>
     * The margin between the title and the plot area, or if a subtitle is present,
     * the margin between the subtitle and the plot area. Defaults to 15.
     *
     * @param margin The margin between the title and the plot area, or if a subtitle is present,
     *               the margin between the subtitle and the plot area.
     * @return A reference to this {@link ChartTitle} instance for convenient method chaining.
     */
    public ChartTitle setMargin(Number margin) {
        return this.setOption("margin", margin);
    }

    /**
     * Convenience method for setting the 'style' options of the title.  Equivalent to:
     * <pre><code>
     *     chartTitle.setOption("/style/fontWeight", "bold");
     *     chartTitle.setOption("/style/fontFamily", "serif");
     *     etc.
     * </code></pre>
     * CSS styles for the title. Use this for font styling, but use {@link #setAlign(org.moxieapps.gwt.highcharts.client.ChartTitle.Align)},
     * {@link #setX(Number)}, and {@link #setY(Number)} for text alignment. Defaults to:
     * <ul>
     * <li>color: '#3E576F'</li>
     * <li>fontSize: '16px'</li>
     * </ul>
     *
     * @param style CSS styles for the title.
     * @return A reference to this {@link ChartTitle} instance for convenient method chaining.
     */
    public ChartTitle setStyle(Style style) {
        return this.setOption("style", style != null ? style.getOptions() : null);
    }

    /**
     * Convenience method for setting the 'text' option of the title.  Equivalent to:
     * <pre><code>
     *     chartTitle.setOption("text", "Sales by Month");
     * </code></pre>
     * The actual text of the axis title. It can contain basic HTML text markup
     * like &lt;b&gt;, &lt;i&gt; and spans with style. Defaults to null.
     * <p/>
     * Note to disable an axis title from being displayed completely, simply set the text
     * to "null".  (This can also be accomplished more simply by just setting the title
     * text to null directly on the axis via the {@link Axis#setAxisTitleText(String)} method.)
     *
     * @param text The actual text of the axis title.
     * @return A reference to this {@link ChartTitle} instance for convenient method chaining.
     */
    public ChartTitle setText(String text) {
        return this.setOption("text", text);
    }

    /**
     * Convenience method for setting the 'verticalAlign' option of the title.  Equivalent to:
     * <pre><code>
     *     chartTitle.setOption("verticalAlign", ChartTitle.VerticalAlign.BOTTOM);
     * </code></pre>
     * The vertical alignment of the title. Can be one of "top", "middle" and "bottom". Defaults to "top".
     * Defaults to {@link ChartTitle.VerticalAlign#TOP}.
     *
     * @param verticalAlign The vertical alignment of the title.
     * @return A reference to this {@link ChartTitle} instance for convenient method chaining.
     */
    public ChartTitle setVerticalAlign(VerticalAlign verticalAlign) {
        return this.setOption("verticalAlign", verticalAlign != null ? verticalAlign.toString() : null);
    }

    /**
     * Convenience method for setting the 'x' position option of the title.  Equivalent to:
     * <pre><code>
     *     chartTitle.setOption("x", 70);
     * </code></pre>
     * The x position of the title relative to the alignment within the spacing set on the chart
     * controlled via {@link Chart#setSpacingLeft(Number)} and {@link Chart#setSpacingRight(Number)}.
     * Defaults to 0.
     *
     * @param x The x position of the title, relative to the chart's spacing.
     * @return A reference to this {@link ChartTitle} instance for convenient method chaining.
     */
    public ChartTitle setX(Number x) {
        return this.setOption("x", x);
    }

    /**
     * Convenience method for setting the 'y' position option of the title.  Equivalent to:
     * <pre><code>
     *     chartTitle.setOption("y", -20);
     * </code></pre>
     * The y position of the title relative to the alignment within the spacing set on the chart
     * controlled via {@link Chart#setSpacingTop(Number)} and {@link Chart#setSpacingBottom(Number)}.
     * Defaults to 25.
     *
     * @param y The y position of the title, relative to the chart's spacing.
     * @return A reference to this {@link ChartTitle} instance for convenient method chaining.
     */
    public ChartTitle setY(Number y) {
        return this.setOption("y", y);
    }

}
