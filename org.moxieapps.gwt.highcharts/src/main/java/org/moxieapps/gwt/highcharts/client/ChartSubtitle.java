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
 * A configurable class that can be used to represent custom sub title options for the
 * chart, which can then be set on the chart (via the {@link Chart#setChartSubtitle(ChartSubtitle)} method.)
 * Example usage:
 * <code><pre>
 *   chart.setChartSubTitle(
 *     new ChartSubtitle()
 *       .setText("Source: Wikipedia")
 *       .setAlign(ChartTitle.Align.MIDDLE)
 *   );
 * </pre></code>
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.0.0
 */
public class ChartSubtitle extends Configurable<ChartSubtitle> {    

    /**
     * Convenience method for setting the 'align' option of the subtitle.  Equivalent to:
     * <pre><code>
     *     chartSubtitle.setOption("align", chartSubtitle.Align.LEFT);
     * </code></pre>
     * The horizontal alignment of the subtitle. Can be one of "left", "center" and "right".
     * Defaults to {@link ChartTitle.Align#CENTER}.
     *
     * @param align The horizontal alignment of the subtitle.
     * @return A reference to this {@link ChartSubtitle} instance for convenient method chaining.
     */
    public ChartSubtitle setAlign(ChartTitle.Align align) {
        return this.setOption("align", align != null ? align.toString() : null);
    }

    /**
     * Convenience method for setting the 'floating' option of the subtitle.  Equivalent to:
     * <pre><code>
     *     chartSubtitle.setOption("floating", true);
     * </code></pre>
     * When the subtitle is floating, the plot area will not move to make space for it. Defaults to false.
     *
     * @param floating 'true' to float the subtitle above the plot area, or 'false' (the default) to make space for it.
     * @return A reference to this {@link ChartSubtitle} instance for convenient method chaining.
     */
    public ChartSubtitle setFloating(boolean floating) {
        return this.setOption("floating", floating);
    }

    /**
     * Convenience method for setting the 'style' options of the subtitle.  Equivalent to:
     * <pre><code>
     *     chartSubtitle.setOption("/style/fontWeight", "bold");
     *     chartSubtitle.setOption("/style/fontFamily", "serif");
     *     etc.
     * </code></pre>
     * CSS styles for the subtitle. Exact positioning of the title can be achieved by changing the
     * margin property, or by adding position: "absolute" and left and top properties. Defaults to:
     * <ul>
     * <li>color: '#3E576F'</li>
     * </ul>
     *
     * @param style CSS styles for the subtitle.
     * @return A reference to this {@link ChartSubtitle} instance for convenient method chaining.
     */
    public ChartSubtitle setStyle(Style style) {
        return this.setOption("style", style != null ? style.getOptions() : null);
    }

    /**
     * Convenience method for setting the 'text' option of the subtitle.  Equivalent to:
     * <pre><code>
     *     chartSubtitle.setOption("text", "Sales by Month");
     * </code></pre>
     * The actual text of the axis subtitle. It can contain basic HTML text markup
     * like &lt;b&gt;, &lt;i&gt; and spans with style. Defaults to null.
     * <p/>
     * Note to disable an axis subtitle from being displayed completely, simply set the text
     * to "null".  (This can also be accomplished more simply by just setting the subtitle
     * text to null directly on the axis via the {@link Axis#setAxisTitleText(String)} method.)
     *
     * @param text The actual text of the axis subtitle.
     * @return A reference to this {@link ChartSubtitle} instance for convenient method chaining.
     */
    public ChartSubtitle setText(String text) {
        return this.setOption("text", text);
    }

    /**
     * Convenience method for setting the 'verticalAlign' option of the subtitle.  Equivalent to:
     * <pre><code>
     *     chartSubtitle.setOption("verticalAlign", chartSubtitle.VerticalAlign.BOTTOM);
     * </code></pre>
     * The vertical alignment of the subtitle. Can be one of "top", "middle" and "bottom". Defaults to "top".
     * Defaults to {@link ChartTitle.VerticalAlign#TOP}.
     *
     * @param verticalAlign The vertical alignment of the subtitle.
     * @return A reference to this {@link ChartSubtitle} instance for convenient method chaining.
     */
    public ChartSubtitle setVerticalAlign(ChartTitle.VerticalAlign verticalAlign) {
        return this.setOption("verticalAlign", verticalAlign != null ? verticalAlign.toString() : null);
    }

    /**
     * Convenience method for setting the 'x' position option of the subtitle.  Equivalent to:
     * <pre><code>
     *     chartSubtitle.setOption("x", 70);
     * </code></pre>
     * The x position of the subtitle relative to the alignment within the spacing set on the chart
     * controlled via {@link Chart#setSpacingLeft(Number)} and {@link Chart#setSpacingRight(Number)}.
     * Defaults to 0.
     *
     * @param x The x position of the subtitle, relative to the chart's spacing.
     * @return A reference to this {@link ChartSubtitle} instance for convenient method chaining.
     */
    public ChartSubtitle setX(Number x) {
        return this.setOption("x", x);
    }

    /**
     * Convenience method for setting the 'y' position option of the subtitle.  Equivalent to:
     * <pre><code>
     *     chartSubtitle.setOption("y", -20);
     * </code></pre>
     * The y position of the subtitle relative to the alignment within the spacing set on the chart
     * controlled via {@link Chart#setSpacingTop(Number)} and {@link Chart#setSpacingBottom(Number)}.
     * Defaults to 25.
     *
     * @param y The y position of the subtitle, relative to the chart's spacing.
     * @return A reference to this {@link ChartSubtitle} instance for convenient method chaining.
     */
    public ChartSubtitle setY(Number y) {
        return this.setOption("y", y);
    }
    
}
