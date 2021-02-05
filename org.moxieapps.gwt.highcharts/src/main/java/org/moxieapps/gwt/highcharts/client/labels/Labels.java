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

import org.moxieapps.gwt.highcharts.client.Configurable;
import org.moxieapps.gwt.highcharts.client.Style;

/**
 * Represents the common base class for all label configuration option types, which allows
 * for general options to be set via the inherited {@link org.moxieapps.gwt.highcharts.client.Configurable#setOption(String, Object)}
 * method.  But also exposes type specific methods that the caller is encouraged to use instead,
 * such as {@link #setAlign(org.moxieapps.gwt.highcharts.client.labels.Labels.Align)}, {@link #setColor(String)}, etc.
 * <p/>
 * Note that this class is abstract and therefore can't be instantiated directly.  Instead you
 * should create an instance of more specific sub type, such as {@link XAxisLabels}, {@link YAxisLabels},
 * or {@link DataLabels}.
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.0.0
 */
public abstract class Labels<T extends Labels> extends Configurable<T> {

    /**
     * An enumeration of supported label alignment types, which can be passed to methods
     * like {@link org.moxieapps.gwt.highcharts.client.labels.Labels#setAlign(org.moxieapps.gwt.highcharts.client.labels.Labels.Align)} method.
     */
    public enum Align {

        /**
         * Align the data label to the left of the point
         */
        LEFT("left"),

        /**
         * Align the data label to the right of the point
         */
        RIGHT("right"),

        /**
         * Align the data label on the center of the point
         */
        CENTER("center");

        private Align(String optionValue) {
            this.optionValue = optionValue;
        }

        private final String optionValue;

        public String toString() {
            return optionValue;
        }

    }

    public enum VerticalAlign {

        /**
         * Align the data label to the top of the point
         */
        TOP("top"),

        /**
         * Align the data label to the middle of the point
         */
        MIDDLE("middle"),

        /**
         * Align the data label on the bottom of the point
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
     * Convenience method for setting the 'align' option for the labels.  Equivalent to:
     * <pre><code>
     *     labels.setOption("align", Labels.Align.CENTER);
     * </code></pre>
     * The alignment of the data label compared to the point. Can be one of "left", "center" or "right". Defaults to "center".
     *
     * @param align The alignment of the label compared to the point.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.labels.Labels} instance for convenient method chaining.
     */
    public T setAlign(Align align) {
        return this.setOption("align", align != null ? align.toString() : null);
    }

    /**
     * Convenience method for setting the 'color' option for the data labels.  Equivalent to:
     * <pre><code>
     *     labels.setOption("color", "#CC0000");
     * </code></pre>
     * The text color for the data labels. Defaults to null.
     *
     * @param color The text color to use for the labels.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.labels.Labels} instance for convenient method chaining.
     */
    public T setColor(String color) {
        return this.setOption("color", color);
    }

    /**
     * Convenience method for setting the 'enabled' option for the data labels.  Equivalent to:
     * <pre><code>
     *     labels.setOption("enabled", true);
     * </code></pre>
     * Enable or disable the data labels. Defaults to false.
     *
     * @param enabled Whether or not to enable or disable the data labels.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.labels.Labels} instance for convenient method chaining.
     */
    public T setEnabled(boolean enabled) {
        return this.setOption("enabled", enabled);
    }

    /**
     * Convenience method for setting the 'rotation' option for the labels.  Equivalent to:
     * <pre><code>
     *     labels.setOption("rotation", 90.0f);
     * </code></pre>
     * Text rotation in degrees. Defaults to 0.
     *
     * @param rotation Text rotation in degrees.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.labels.Labels} instance for convenient method chaining.
     */
    public T setRotation(Number rotation) {
        return this.setOption("rotation", rotation);
    }

    /**
     * Convenience method for setting the 'style' options of the labels.  Equivalent to:
     * <pre><code>
     *     labels.setOption("/style/fontWeight", "bold");
     *     labels.setOption("/style/fontFamily", "serif");
     *     etc.
     * </code></pre>
     * CSS styles for the labels.  Defaults to:
     * <ul>
     * <li>color: '#6D869F'</li>
     * <li>fontWeight: 'bold'</li>
     * </ul>
     *
     * @param style CSS styles for the labels.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.labels.Labels} instance for convenient method chaining.
     */
    public T setStyle(Style style) {
        return this.setOption("style", style != null ? style.getOptions() : null);
    }

    /**
     * Convenience method for setting the 'verticalAlign' option for the labels.  Equivalent to:
     * <pre><code>
     *     labels.setOption("verticalAlign", Labels.VerticalAlign.TOP);
     * </code></pre>
     * The vertical alignment of the data label compared to the point. Can be one of "top", "middle" or "bottom". Defaults to "center".
     *
     * @param verticalAlign The vertical alignment of the label compared to the point.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.labels.Labels} instance for convenient method chaining.
     */
    public T setVerticalAlign(VerticalAlign verticalAlign) {
        return this.setOption("verticalAlign", verticalAlign != null ? verticalAlign.toString() : null);
    }

    /**
     * Convenience method for setting the 'x' position option of the label.  Equivalent to:
     * <pre><code>
     *     labels.setOption("x", 70);
     * </code></pre>
     * The x position offset of the label relative to the point. Defaults to 0 for series data labels,
     * -8 y-axis labels, and 0 x-axis labels.
     *
     * @param x The x position of the title, relative to the chart's spacing.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.labels.Labels} instance for convenient method chaining.
     */
    public T setX(Number x) {
        return this.setOption("x", x);
    }

    /**
     * Convenience method for setting the 'y' position option of the label.  Equivalent to:
     * <pre><code>
     *     labels.setOption("y", -20);
     * </code></pre>
     * The y position offset of the label relative to the point. Defaults to -6 for series data labels,
     * 3 for y-axis labels, and 0 for x-axis labels.
     *
     * @param y The y position of the title, relative to the chart's spacing.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.labels.Labels} instance for convenient method chaining.
     */
    public T setY(Number y) {
        return this.setOption("y", y);
    }

}
