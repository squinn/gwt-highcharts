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
 * A configurable class that can be used to represent custom credits options for the
 * chart, which can then be set on the chart (via the {@link Chart#setCredits(Credits)} method.)
 * Highchart by default puts a credits label in the lower right corner of the chart.
 * This can be changed using these options. Example usage:
 * <code><pre>
 *   chart.setCredits(
 *     new Credits()
 *       .setText("Presented by Snoopy")
 *       .setHref("http://www.peanuts.com/")
 *   );
 * </pre></code>
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.0.0
 */
public class Credits extends Configurable<Credits> {

    /**
     * An enumeration of supported credits horizontal alignment types, which can be passed to methods
     * like {@link Credits#setAlign(Credits.Align)} method.
     */
    public enum Align {

        /**
         * Left align the credits
         */
        LEFT("left"),

        /**
         * Center the credits
         */
        CENTER("center"),

        /**
         * Right align the credits
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
     * An enumeration of supported credits vertical alignment types, which can be passed to methods
     * like {@link Credits#setVerticalAlign(Credits.VerticalAlign)} method.
     */
    public enum VerticalAlign {

        /**
         * Show the credits at the top of the chart
         */
        TOP("top"),

        /**
         * Show the credits in the middle of the chart
         */
        MIDDLE("middle"),

        /**
         * Show the credits at the bottom of the chart
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
     * Convenience method for setting the 'align' option of the credits.  Equivalent to:
     * <pre><code>
     *     credits.setOption("/position/align", Credit.Align.LEFT);
     * </code></pre>
     * The horizontal alignment of the credits text within the chart area. Can be one of "left", "center" and "right".
     * Defaults to {@link Credits.Align#RIGHT}.
     *
     * @param align The horizontal alignment of the credits text within the chart area.
     * @return A reference to this {@link Credits} instance for convenient method chaining.
     */
    public Credits setAlign(Align align) {
        return this.setOption("/position/align", align != null ? align.toString() : null);
    }

    /**
     * Convenience method for setting the 'enabled' option for the credits.  Equivalent to:
     * <pre><code>
     *     credits.setOption("enabled", true);
     * </code></pre>
     * Whether to show the credits text. Defaults to true.
     *
     * @param enabled Whether or not to enable or disable the credits text.
     * @return A reference to this {@link Credits} instance for convenient method chaining.
     */
    public Credits setEnabled(boolean enabled) {
        return this.setOption("enabled", enabled);
    }

    /**
     * Convenience method for setting the 'href' option of the credits.  Equivalent to:
     * <pre><code>
     *     credits.setOption("href", "http://www.peanuts.com/");
     * </code></pre>
     * The URL for the credits label. Defaults to "http://www.highcharts.com".
     *
     * @param href The URL for the credits label.
     * @return A reference to this {@link Credits} instance for convenient method chaining.
     */
    public Credits setHref(String href) {
        return this.setOption("href", href);
    }

    /**
     * Convenience method for setting the 'style' options of the credits.  Equivalent to:
     * <pre><code>
     *     credits.setOption("/style/fontWeight", "bold");
     *     credits.setOption("/style/fontFamily", "serif");
     *     etc.
     * </code></pre>
     * CSS styles for the credits label. . Defaults to:
     * <ul>
     *     <li>cursor: 'pointer'</li>
     *     <li>color: '#909090'</li>
     *     <li>fontSize: '10px'</li>
     * </ul>
     *
     * @param style An object containing the style properties to set on the credits.
     * @return A reference to this {@link Credits} instance for convenient method chaining.
     */
    public Credits setStyle(Style style) {
        return this.setOption("style", style != null ? style.getOptions() : null);
    }

    /**
     * Convenience method for setting the 'text' option of the credits.  Equivalent to:
     * <pre><code>
     *     credits.setOption("text", "Thanks to Snoopy");
     * </code></pre>
     * The text for the credits label. Defaults to "Highcharts.com".
     *
     * @param text The text for the credits label.
     * @return A reference to this {@link Credits} instance for convenient method chaining.
     */
    public Credits setText(String text) {
        return this.setOption("text", text);
    }


    /**
     * Convenience method for setting the 'verticalAlign' option of the credits.  Equivalent to:
     * <pre><code>
     *     legend.setOption("/position/verticalAlign", Credits.VerticalAlign.BOTTOM);
     * </code></pre>
     * The vertical alignment of the legend box. Can be one of "top", "middle" or "bottom".
     * Vertical position can be further determined by the y option.
     * Defaults to {@link Legend.VerticalAlign#BOTTOM}.
     *
     * @param verticalAlign The vertical alignment of the credits.
     * @return A reference to this {@link Credits} instance for convenient method chaining.
     * @since 1.6.0
     */
    public Credits setVerticalAlign(VerticalAlign verticalAlign) {
        return this.setOption("/position/verticalAlign", verticalAlign != null ? verticalAlign.toString() : null);
    }

    /**
     * Convenience method for setting the 'x' position option of the credits.  Equivalent to:
     * <pre><code>
     *     legend.setOption("/position/x", 70);
     * </code></pre>
     * The x offset of the credits relative to it's horizontal alignment align within
     * {@link Chart#setSpacingLeft(Number)} and {@link Chart#setSpacingRight(Number)}. Negative x
     * moves it to the left, positive x moves it to the right. The default value of -10 together
     * with {@link Align#RIGHT} puts it near the right side of the plot area. Defaults to -10.
     *
     * @param x The x offset of the credits, relative to the chart's spacing.
     * @return A reference to this {@link Credits} instance for convenient method chaining.
     */
    public Credits setX(Number x) {
        return this.setOption("/position/x", x);
    }

    /**
     * Convenience method for setting the 'y' position option of the credits.  Equivalent to:
     * <pre><code>
     *     legend.setOption("/position/y", -20);
     * </code></pre>
     * The vertical offset of the legend relative to it's vertical alignment (@link VerticalAlign}
     * within {@link Chart#setSpacingTop(Number)} and {@link Chart#setSpacingBottom(Number)}.
     * Negative y moves it up, positive y moves it down. Defaults to -5.
     *
     * @param y The y position of the credits, relative to the chart's spacing.
     * @return A reference to this {@link Credits} instance for convenient method chaining.
     */
    public Credits setY(Number y) {
        return this.setOption("/position/y", y);
    }

}
