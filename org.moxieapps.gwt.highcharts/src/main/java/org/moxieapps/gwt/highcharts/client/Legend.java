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

import org.moxieapps.gwt.highcharts.client.labels.LegendLabelsFormatter;

/**
 * A configurable class that can be used to represent custom legend options for the
 * chart, which can then be set on the chart (via the {@link Chart#setLegend(Legend)} method.)
 * The legend is a box containing a symbol and name for each series item or point item in the chart.
 * Example usage:
 * <code><pre>
 *   chart.setLegend(
 *     new Legend()
 *       .setBorderColor("#CC0000")
 *       .setLayout(Legend.Layout.HORIZONTAL)
 *   );
 * </pre></code>
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.0.0
 */
public class Legend extends Configurable<Legend> {

    /**
     * An enumeration of supported legend horizontal alignment types, which can be passed to methods
     * like {@link Legend#setAlign(Legend.Align)} method.
     */
    public enum Align {

        /**
         * Left align the legend
         */
        LEFT("left"),

        /**
         * Center the legend
         */
        CENTER("center"),

        /**
         * Right align the legend
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
     * An enumeration of supported legend vertical alignment types, which can be passed to methods
     * like {@link Legend#setVerticalAlign(Legend.VerticalAlign)} method.
     */
    public enum VerticalAlign {

        /**
         * Show the legend at the top of the chart
         */
        TOP("top"),

        /**
         * Show the legend in the middle of the chart
         */
        MIDDLE("middle"),

        /**
         * Show the legend at the bottom of the chart
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
     * An enumeration of supported legend layout types, which can be passed to methods
     * like {@link Legend#setLayout(Layout)} method.
     */
    public enum Layout {

        /**
         * Lay the legend items out in a horizontal row
         */
        HORIZONTAL("horizontal"),

        /**
         * Lay the legend items out in a vertical stack
         */
        VERTICAL("vertical");

        private Layout(String optionValue) {
            this.optionValue = optionValue;
        }

        private final String optionValue;

        public String toString() {
            return optionValue;
        }

    }


    /**
     * Convenience method for setting the 'align' option of the legend.  Equivalent to:
     * <pre><code>
     *     legend.setOption("align", Legend.Align.LEFT);
     * </code></pre>
     * The horizontal alignment of the legend box within the chart area. Can be one of "left", "center" and "right".
     * Defaults to {@link Legend.Align#CENTER}.
     *
     * @param align The horizontal alignment of the legend box within the chart area.
     * @return A reference to this {@link Legend} instance for convenient method chaining.
     */
    public Legend setAlign(Align align) {
        return this.setOption("align", align != null ? align.toString() : null);
    }

    /**
     * Convenience method for setting the 'backgroundColor' option of the legend.  Equivalent to:
     * <pre><code>
     *     legend.setOption("backgroundColor", "#CCCCCC");
     * </code></pre>
     * The background color of the legend, filling the rounded corner border. Defaults to null.
     *
     * @param backgroundColor The value to set as the 'backgroundColor' option on the legend.
     * @return A reference to this {@link Legend} instance for convenient method chaining.
     */
    public Legend setBackgroundColor(String backgroundColor) {
        return this.setOption("backgroundColor", backgroundColor);
    }

    /**
     * Convenience method for setting the 'borderColor' option of the legend.  Equivalent to:
     * <pre><code>
     *     legend.setOption("borderColor", "#CCCCCC");
     * </code></pre>
     * The color of the drawn border around the legend. Defaults to #909090.
     *
     * @param borderColor The color of the drawn border around the legend.
     * @return A reference to this {@link Legend} instance for convenient method chaining.
     */
    public Legend setBorderColor(String borderColor) {
        return this.setOption("borderColor", borderColor);
    }

    /**
     * Convenience method for setting the 'borderRadius' option of the legend.  Equivalent to:
     * <pre><code>
     *     legend.setOption("borderRadius", 8);
     * </code></pre>
     * The border corner radius of the legend. Defaults to 5.
     *
     * @param borderRadius The border corner radius of the legend.
     * @return A reference to this {@link Legend} instance for convenient method chaining.
     */
    public Legend setBorderRadius(Number borderRadius) {
        return this.setOption("borderRadius", borderRadius);
    }

    /**
     * Convenience method for setting the 'borderWidth' option of the legend.  Equivalent to:
     * <pre><code>
     *     legend.setOption("borderWidth", 3);
     * </code></pre>
     * The width of the drawn border around the legend. Defaults to 1.
     *
     * @param borderWidth The width of the drawn border around the legend.
     * @return A reference to this {@link Legend} instance for convenient method chaining.
     */
    public Legend setBorderWidth(Number borderWidth) {
        return this.setOption("borderWidth", borderWidth);
    }

    /**
     * Convenience method for setting the 'floating' option of the legend.  Equivalent to:
     * <pre><code>
     *     legend.setOption("floating", true);
     * </code></pre>
     * When the legend is floating, the plot area ignores it and is allowed to be placed below it. Defaults to false.
     *
     * @param floating 'true' to float the legend above the plot area, or 'false' (the default) to make space for it.
     * @return A reference to this {@link Legend} instance for convenient method chaining.
     */
    public Legend setFloating(boolean floating) {
        return this.setOption("floating", floating);
    }

    /**
     * Convenience method for setting the 'enabled' option for the legend.  Equivalent to:
     * <pre><code>
     *     legend.setOption("enabled", true);
     * </code></pre>
     * Enable or disable the legend. Defaults to true.
     *
     * @param enabled Whether or not to enable or disable the legend.
     * @return A reference to this {@link Legend} instance for convenient method chaining.
     */
    public Legend setEnabled(boolean enabled) {
        return this.setOption("enabled", enabled);
    }

    /**
     * Convenience method for setting the 'itemHiddenStyle' options of the legend.  Equivalent to:
     * <pre><code>
     *     legend.setOption("/itemHiddenStyle/fontWeight", "bold");
     *     legend.setOption("/itemHiddenStyle/fontFamily", "serif");
     *     etc.
     * </code></pre>
     * CSS styles for each legend item when the corresponding series or point is hidden. Properties are inherited
     * from {@link #setStyle(Style)} unless overridden here. Defaults to:
     * <ul>
     * <li>color: '#CCC'</li>
     * </ul>
     *
     * @param itemHiddenStyle CSS styles for each legend item when the corresponding series or point is hidden.
     * @return A reference to this {@link Legend} instance for convenient method chaining.
     */
    public Legend setItemHiddenStyle(Style itemHiddenStyle) {
        return this.setOption("itemHiddenStyle", itemHiddenStyle != null ? itemHiddenStyle.getOptions() : null);
    }

    /**
     * Convenience method for setting the 'itemHoverStyle' options of the legend.  Equivalent to:
     * <pre><code>
     *     legend.setOption("/itemHoverStyle/fontWeight", "bold");
     *     legend.setOption("/itemHoverStyle/fontFamily", "serif");
     *     etc.
     * </code></pre>
     * CSS styles for each legend item in hover mode. Properties are inherited from {@link #setStyle(Style)}
     * unless overridden here. Defaults to:
     * <ul>
     * <li>color: '#000'</li>
     * </ul>
     *
     * @param itemHoverStyle CSS styles for each legend item in hover mode.
     * @return A reference to this {@link Legend} instance for convenient method chaining.
     */
    public Legend setItemHoverStyle(Style itemHoverStyle) {
        return this.setOption("itemHoverStyle", itemHoverStyle != null ? itemHoverStyle.getOptions() : null);
    }

    /**
     * Convenience method for setting the 'itemMarginBottom' options of the legend. Equivalent to:
     * <pre><code>
     *     legend.setOption("itemMarginBottom", 0);
     * </code></pre>
     * The pixel bottom margin for each legend item. Defaults to 0.
     * @param itemMarginBottom The distance in pixels from the last legend item to the bottom border of the legend.
     * @return A reference to this {@link Legend} instance for convenient method chaining.
     */
    public Legend setItemMarginBottom(Number itemMarginBottom) {
        return this.setOption("itemMarginBottom", itemMarginBottom);
    }

    /**
     * Convenience method for setting the 'itemMarginTop' options of the legend. Equivalent to:
     * <pre><code>
     *     legend.setOption("itemMarginTop", 0);
     * </code></pre>
     * The pixel top margin for each legend item. Defaults to 0.
     * @param itemMarginTop The distance in pixels from the top border of the legend to the first legend item.
     * @return A reference to this {@link Legend} instance for convenient method chaining.
     */
    public Legend setItemMarginTop(Number itemMarginTop) {
        return this.setOption("itemMarginTop", itemMarginTop);
    }

        /**
         * Convenience method for setting the 'itemStyle' options of the legend.  Equivalent to:
         * <pre><code>
         *     legend.setOption("/itemStyle/fontWeight", "bold");
         *     legend.setOption("/itemStyle/fontFamily", "serif");
         *     etc.
         * </code></pre>
         * CSS styles for each legend item. Defaults to:
         * <ul>
         * <li>cursor: 'pointer'</li>
         * <li>color: '#3E576F'</li>
         * </ul>
         *
         * @param itemStyle CSS styles for each legend item.
         * @return A reference to this {@link Legend} instance for convenient method chaining.
         */
    public Legend setItemStyle(Style itemStyle) {
        return this.setOption("itemStyle", itemStyle != null ? itemStyle.getOptions() : null);
    }

    /**
     * Convenience method for setting the 'itemWidth' option of the legend.  Equivalent to:
     * <pre><code>
     *     legend.setOption("itemWidth", 150);
     * </code></pre>
     * The width for each legend item. This is useful in a horizontal layout with many items
     * when you want the items to align vertically. Defaults to null.
     *
     * @param itemWidth The width for each legend item, or null to automatically calculate.
     * @return A reference to this {@link Legend} instance for convenient method chaining.
     */
    public Legend setItemWidth(Number itemWidth) {
        return this.setOption("itemWidth", itemWidth);
    }

    /**
     * Convenience method for setting the 'layout' option of the legend.  Equivalent to:
     * <pre><code>
     *     legend.setOption("layout", Layout.VERTICAL);
     * </code></pre>
     * The layout of the legend items. Can be one of "horizontal" or "vertical".
     * Defaults to {@link Layout#HORIZONTAL}.
     *
     * @param layout The layout of the legend items.
     * @return A reference to this {@link Legend} instance for convenient method chaining.
     */
    public Legend setLayout(Layout layout) {
        return this.setOption("layout", layout != null ? layout.toString() : null);
    }

    private LegendLabelsFormatter legendLabelsFormatter;

    /**
     * Sets a custom formatter for the labels that can be used to control how the text of the
     * legend labels will be displayed.  See the {@link LegendLabelsFormatter} interface, and
     * in particular the {@link LegendLabelsFormatter#format(org.moxieapps.gwt.highcharts.client.labels.LegendLabelsData)}
     * method for more details on the capabilities available to custom legend formatters.
     *
     * @param legendLabelsFormatter The custom formatter to use for the labels (if not given a built-in
     *                            generic formatter is used which simply returns the name of the series
     *                            or, for pie charts, the name of the point).
     * @return A reference to this {@link Legend} instance for convenient method chaining.
     * @since 1.3.0
     */
    public Legend setLabelsFormatter(LegendLabelsFormatter legendLabelsFormatter) {
        this.legendLabelsFormatter = legendLabelsFormatter;
        return this;
    }

    /**
     * Returns the custom labels formatter that has been applied to the legend, or null if the
     * built-in generic formatter is being used instead.
     *
     * @return The custom data labels formatter that has been applied, or null if it has not been set.
     * @since 1.3.0
     */
    public LegendLabelsFormatter getLabelsFormatter() {
        return this.legendLabelsFormatter;
    }

    /**
     * Convenience method for setting the 'margin' option of the legend.  Equivalent to:
     * <pre><code>
     *     legend.setOption("margin", 60);
     * </code></pre>
     * If the plot area sized is calculated automatically and the legend is not floating, the
     * legend margin is the space between the legend and the axis labels or plot area. Defaults to 15.
     *
     * @param margin The space between the legend and the axis labels or plot area.
     * @return A reference to this {@link Legend} instance for convenient method chaining.
     */
    public Legend setMargin(Number margin) {
        return this.setOption("margin", margin);
    }

    /**
     * Convenience method for setting the 'reversed' option of the legend.  Equivalent to:
     * <pre><code>
     *     legend.setOption("maxHeight", 60);
     * </code></pre>
     * Maximum pixel height for the legend. When the maximum height is extended, navigation will show.
     * @param maxHeight The Maximum height of the Legend
     * @return A reference to this {@link Legend} instance for convenient method chaining.
     */
    public Legend setMaxHeight(Number maxHeight) {
        return this.setOption("maxHeight", maxHeight);
    }

    /**
     * Convenience method for setting the "activeColor" option for the legend navigation. Equivalent to:
     * <pre><code>
     *     legend.setOption("/navigation/activeColor", #3E576F);
     * </code></pre>
     * The color for the active up or down arrow in the legend page navigation. Defaults to #3E576F
     * @param activeColor
     * @return A reference to this {@link Legend} instance for convenient method chaining.
     */
    public Legend setNavigationActiveColor(Color activeColor) {
        return this.setOption("/navigation/activeColor", activeColor);
    }

    /**
     * Convenience method for setting the "activeColor" option for the legend navigation. Equivalent to:
     * <pre><code>
     *     legend.setOption("/navigation/activeColor", );
     * </code></pre>
     * The color for the active up or down arrow in the legend page navigation. Defaults to #3E576F
     * @param color
     * @return A reference to this {@link Legend} instance for convenient method chaining.
     */
    public Legend setNavigationActiveColor(Number color) {
        return this.setOption("/navigation/activeColor", color);
    }

    /**
     * Convenience method for setting the "animation" option for the legend navigation. Equivalent to:
     * <pre><code>
     *     legend.setOption(("/navigation/animation", true);
     * </code></pre>
     * How to animate the pages when navigating up or down. A value of true applies the default navigation given in the chart.
     * animation option. Additional options can be given as an object containing values for easing and duration. Defaults to true.
     * @param animation
     * @return A reference to this {@link Legend} instance for convenient method chaining.
     */
    public Legend setNavigationAnimation(boolean animation) {
        return this.setOption("/navigation/animation", animation);
    }

    /**
     * Convenience method for setting the "animation" option for the legend navigation. Equivalent to:
     * <pre><code>
     *     legend.setOption("/navigation/animation", );
     * </code></pre>
     * How to animate the pages when navigating up or down. A value of true applies the default navigation given in the chart.
     * animation option. Additional options can be given as an object containing values for easing and duration. Defaults to true.
     * @param animation
     * @return A reference to this {@link Legend} instance for convenient method chaining.
     */
    public Legend setNavigationAnimation(Animation animation) {
        return this.setOption("/navigation/animation", animation);
    }

    /**
     * Convenience method for setting the "arrowSize" option for the legend navigation. Equivalent to:
     * <pre><code>
     *     legend.setOption("/navigation/arrowSize", 12);
     * </code></pre>
     * The pixel size of the up and down arrows in the legend paging navigation. . Defaults to 12.
     * @param arrowSize
     * @return A reference to this {@link Legend} instance for convenient method chaining.
     */
    public Legend setNavigationArrowSize(Number arrowSize) {
        return this.setOption("/navigation/arrowSize", arrowSize);
    }

    /**
     * Convenience method for setting the "inactiveColor" option for the legend navigation. Equivalent to:
     * <pre><code>
     *     legend.setOption("/navigation/inactiveColor", #CCC);
     * </code></pre>
     * The color of the inactive up or down arrow in the legend page navigation. . Defaults to #CCC.
     * @param inactiveColor
     * @return A reference to this {@link Legend} instance for convenient method chaining.
     */
    public Legend setNavigationInactiveColor(Color inactiveColor) {
        return this.setOption("/navigation/inactiveColor", inactiveColor);
    }

    /**
     * Convenience method for setting the "inactiveColor" option for the legend navigation. Equivalent to:
     * <pre><code>
     *     legend.setOption("/navigation/inactiveColor", );
     * </code></pre>
     * The color of the inactive up or down arrow in the legend page navigation. . Defaults to #CCC.
     * @param inactiveColor
     * @return A reference to this {@link Legend} instance for convenient method chaining.
     */
    public Legend setNavigationInactiveColor(Number inactiveColor) {
        return this.setOption("/navigation/inactiveColor", inactiveColor);
    }

    /**
     * Convenience method for setting the "style" option for the legend navigation. Equivalent to:
     * <pre><code>
     *     legend.setOption("/navigation/style", null);
     * </code></pre>
     * Text styles for the legend page navigation.
     * @param style
     * @return A reference to this {@link Legend} instance for convenient method chaining.
     */
    public Legend setNavigationStyle(Style style) {
        return this.setOption("/navigation/style", style);
    }

    /**
     * Convenience method for setting the 'reversed' option of the legend.  Equivalent to:
     * <pre><code>
     *     legend.setOption("padding", 8);
     * </code></pre>
     * The inner padding of the legend box. Defaults to 8.
     * @param padding the distance in pixels of legend items to the legend border.
     * @return A reference to this {@link Legend} instance for convenient method chaining.
     */
    public Legend setPadding(Number padding) {
        return this.setOption("padding", padding);
    }
    /**
     * Convenience method for setting the 'reversed' option of the legend.  Equivalent to:
     * <pre><code>
     *     legend.setOption("reversed", true);
     * </code></pre>
     * Whether to reverse the order of the legend items compared to the order of the series
     * or points as defined in the configuration object. Defaults to false.
     *
     * @param reversed 'true' to reverse the order of the legend items.
     * @return A reference to this {@link Legend} instance for convenient method chaining.
     */
    public Legend setReversed(boolean reversed) {
        return this.setOption("reversed", reversed);
    }

    /**
     * Convenience method for setting the 'reversed' option of the legend.  Equivalent to:
     * <pre><code>
     *     legend.setOption("rtl", true);
     * </code></pre>
     * Whether to show the symbol on the right side of the text rather than the left side. This is common in Arabic and Hebraic. Defaults to false
     * @param rtl 'true' to show the symbol to the right of the text of the legend item.
     * @return A reference to this {@link Legend} instance for convenient method chaining.
     */
    public Legend setRtl(boolean rtl) {
        return this.setOption("rtl", rtl);
    }

    /**
     * Convenience method for setting the 'shadow' option of the legend.  Equivalent to:
     * <pre><code>
     *     legend.setOption("shadow", true);
     * </code></pre>
     * Whether to apply a drop shadow to the legend. A {@link #setBackgroundColor(String)}
     * also needs to be applied for this to take effect. Defaults to false.
     *
     * @param shadow 'true' to apply a drop shadow to the legend.
     * @return A reference to this {@link Legend} instance for convenient method chaining.
     */
    public Legend setShadow(boolean shadow) {
        return this.setOption("shadow", shadow);
    }

    /**
     * Convenience method for setting the 'style' options of the legend.  Equivalent to:
     * <pre><code>
     *     legend.setOption("/style/fontWeight", "bold");
     *     legend.setOption("/style/fontFamily", "serif");
     *     etc.
     * </code></pre>
     * CSS styles for the legend area. In the 1.x versions the position of the legend area was
     * determined by CSS. In 2.x, the position is determined by properties like
     * {@link #setAlign(org.moxieapps.gwt.highcharts.client.Legend.Align)},
     * {@link #setVerticalAlign(org.moxieapps.gwt.highcharts.client.Legend.VerticalAlign)},
     * {@link #setX(Number)} and {@link #setY(Number)}, but the styles are still parsed for backwards compatibility.
     *
     * @param style CSS styles for the legend area.
     * @return A reference to this {@link Legend} instance for convenient method chaining.
     */
    public Legend setStyle(Style style) {
        return this.setOption("style", style != null ? style.getOptions() : null);
    }

    /**
     * Convenience method for setting the 'symbolHeight' option of the lagend.  Equivalent to:
     * <pre><code>
     *     legend.setOption("symbolHeight", 25);
     * </code></pre>
     * The pixel height of the symbol for series types that use a rectangle in the legend. Defaults to 12.
     * @param symbolHeight The pixel height of the symbol.
     * @return A reference to this {@link Legend} instance for convenient method chaining.
     * @since 1.7.0
     */
    public Legend setSymbolHeight(Number symbolHeight) {
        return this.setOption("symbolHeight", symbolHeight);
    }

    /**
     * Convenience method for setting the 'symbolPadding' option of the legend.  Equivalent to:
     * <pre><code>
     *     legend.setOption("symbolPadding", 4);
     * </code></pre>
     * The pixel padding between the legend item symbol and the legend item text. Defaults to 5.
     *
     * @param symbolPadding The pixel padding between the legend item symbol and the legend item text.
     * @return A reference to this {@link Legend} instance for convenient method chaining.
     */
    public Legend setSymbolPadding(Number symbolPadding) {
        return this.setOption("symbolPadding", symbolPadding);
    }

    /**
     * Convenience method for setting the 'symbolHeight' option of the lagend.  Equivalent to:
     * <pre><code>
     *     legend.setOption("symbolRadius", 5);
     * </code></pre>
     * The border radius of the symbol for series types that use a rectangle in the legend. Defaults to 2.
     * @param symbolRadius The border radius of the symbol.
     * @return A reference to this {@link Legend} instance for convenient method chaining.
     * @since 1.7.0
     */
    public Legend setSymbolRadius(Number symbolRadius) {
        return this.setOption("symbolHeight", symbolRadius);
    }

    /**
     * Convenience method for setting the 'symbolWidth' option of the legend.  Equivalent to:
     * <pre><code>
     *     legend.setOption("symbolWidth", 40);
     * </code></pre>
     * The pixel width of the legend item symbol. Defaults to 30.
     *
     * @param symbolWidth The pixel width of the legend item symbol.
     * @return A reference to this {@link Legend} instance for convenient method chaining.
     */
    public Legend setSymbolWidth(Number symbolWidth) {
        return this.setOption("symbolWidth", symbolWidth);
    }

    /**
     * Convenience method for setting the "style" option for the legend title. Equivalent to:
     * <pre><code>
     *     legend.setOption("/title/style", "fontWeight: 'bold'");
     * </code></pre>
     * Generic CSS styles for the legend title. Defaults to:
     * <pre><code>
     * style: {
     *     fontWeight: 'bold'
     * }
     * </code></pre>
     * @param style
     * @return A reference to this {@link Legend} instance for convenient method chaining.
     */
    public Legend setTitleStyle(Style style) {
        return this.setOption("/title/style", style);
    }

    /**
     * Convenience method for setting the "text" option for the legend title. Equivalent to:
     * <pre><code>
     *     legend.setOption("/title/text", null);
     * </code></pre>
     * A text or HTML string for the title. Defaults to null.
     * @param text
     * @return A reference to this {@link Legend} instance for convenient method chaining.
     */
    public Legend setTitleText(String text) {
        return this.setOption("/title/text", text);
    }

    /**
     * Convenience method for setting the 'useHTML' option of the legend.  Equivalent to:
     * <pre><code>
     *     legend.setOption("useHTML", false);
     * </code></pre>
     * Whether to use HTML to render the legend item texts.
     * Using HTML allows for advanced formatting, images and reliable bi-directional text rendering.
     * Note that exported images won't respect the HTML, and that HTML won't respect Z-index settings.
     * When using HTML, legend.navigation is disabled.
     * @param useHTML 'true' to use HTML to render Legend texts.
     * @return A reference to this {@link Legend} instance for convenient method chaining.
     */
    public Legend setUseHTML(boolean useHTML) {
        return this.setOption("useHTML", useHTML);
    }


    /**
     * Convenience method for setting the 'verticalAlign' option of the legend.  Equivalent to:
     * <pre><code>
     *     legend.setOption("verticalAlign", Legend.VerticalAlign.BOTTOM);
     * </code></pre>
     * The vertical alignment of the legend box. Can be one of "top", "middle" or "bottom".
     * Vertical position can be further determined by the y option.
     * Defaults to {@link Legend.VerticalAlign#BOTTOM}.
     *
     * @param verticalAlign The vertical alignment of the legend.
     * @return A reference to this {@link Legend} instance for convenient method chaining.
     */
    public Legend setVerticalAlign(VerticalAlign verticalAlign) {
        return this.setOption("verticalAlign", verticalAlign != null ? verticalAlign.toString() : null);
    }

    /**
     * Convenience method for setting the 'width' option of the legend.  Equivalent to:
     * <pre><code>
     *     legend.setOption("width", 150);
     * </code></pre>
     * The width of the legend box, not including and padding set on the style. Defaults to null.
     *
     * @param width The width of the legend box (not including padding).
     * @return A reference to this {@link Legend} instance for convenient method chaining.
     */
    public Legend setWidth(Number width) {
        return this.setOption("width", width);
    }

    /**
     * Convenience method for setting the 'x' position option of the legend.  Equivalent to:
     * <pre><code>
     *     legend.setOption("x", 70);
     * </code></pre>
     * The x offset of the legend relative to it's horizontal alignment align within
     * {@link Chart#setSpacingLeft(Number)} and {@link Chart#setSpacingRight(Number)}. Negative x
     * moves it to the left, positive x moves it to the right. The default value of 15 together
     * with {@link Align#CENTER} puts it in the center of the plot area. Defaults to 15.
     *
     * @param x The x offset of the legend, relative to the chart's spacing.
     * @return A reference to this {@link Legend} instance for convenient method chaining.
     */
    public Legend setX(Number x) {
        return this.setOption("x", x);
    }

    /**
     * Convenience method for setting the 'y' position option of the legend.  Equivalent to:
     * <pre><code>
     *     legend.setOption("y", -20);
     * </code></pre>
     * The vertical offset of the legend relative to it's vertical alignment (@link VerticalAlign}
     * within {@link Chart#setSpacingTop(Number)} and {@link Chart#setSpacingBottom(Number)}.
     * Negative y moves it up, positive y moves it down. Defaults to 0.
     *
     * @param y The y position of the legend, relative to the chart's spacing.
     * @return A reference to this {@link Legend} instance for convenient method chaining.
     */
    public Legend setY(Number y) {
        return this.setOption("y", y);
    }

}
