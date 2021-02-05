/*
 * Copyright 2013 Moxie Group
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
 * A configurable class that will allow you to control the pane background options of the charts, which
 * applies only to polar charts and angular gauges.  This configuration object holds general
 * options for the color, width and border of the pane's background. An instance of this class can be
 * constructed and then set on the pane via the {@link Pane#setBackground(PaneBackground...)} method.
 *
 * @author cskowron@moxiegroup.com (Cory Skowronek)
 * @since 1.6.0
 */
public class PaneBackground extends Configurable<PaneBackground> {
    /**
     * An enumeration of the available shapes for the pane background.
     */
    public enum Shape {

        /**
         * Show the background as solid.
         */
        SOLID("sollid"),
        /**
         * Show the background as an arc.
         */
        ARC("arc");

        private String optionValue;

        private Shape(String optionValue) {
            this.optionValue = optionValue;
        }

        public String toString() {
            return optionValue;
        }
    }

    /**
     * Convenience method for setting the 'borderColor' option of the pane's border to an RGB hex value.  Equivalent to:
     * <pre><code>
     *     chart.setOption("pane/background/borderColor", "#CCCCCC");
     * </code></pre>
     * The RGB background color for the border of the pane. Defaults to "#FFFFFF".
     * <p/>
     * Note that this method is intended for setting the color to a simple RBG hex value.  If you instead
     * want to set a color to include an alpha channel or a gradient, use the {@link #setBorderColor(Color)}
     * version instead
     * @param borderColor The value to set as the 'borderColor' option on the pane.
     * @return A reference to this {@link PaneBackground} instance for convenient method chaining
     */
    public PaneBackground setBorderColor(String borderColor) {
        return this.setOption("borderColor", borderColor);
    }

    /**
     * Convenience method for setting the 'borderColor' option of the pane's border, allowing for
     * colors with opacity or gradients.  Equivalent to:
     * <pre><code>
     *     chart.setOption("/pane/borderColor", new Color()
     *        .setLinearGradient(0.0, 0.0, 1.0, 1.0)
     *        .addStop(new Color(255, 255, 255))
     *        .addStop(new Color(200, 200, 255))
     *     );
     * </code></pre>
     * The background color or gradient for the outer chart area. Defaults to "#FFFFFF".
     * <p/>
     * Note that this method is intended for setting the color to a gradient or color that includes
     * an alpha channel.  If you instead just want to set the color to a normal RGB hex value
     * you can use the {@link #setBorderColor(String)} version instead.
     * @param borderColor The color gradient or color with an alpha channel to set as the 'backgroundBorderColor' option on the pane
     * @return A reference to this {@link PaneBackground} instance for convenient method chaining
     */
    public PaneBackground setBorderColor(Color borderColor) {
        return this.setOption("borderColor", borderColor != null ? borderColor.getOptionValue() : null);
    }

    /**
     * Convenience method for setting the 'borderWidth' option of the pane's background.  Equivalent to:
     * <pre><code>
     *     pane.setOption("pane/background/borderWidth", 10);
     * </code></pre>
     *
     * @param borderWidth Thickness of the background's border in pixels.
     * @return A reference to this {@link PaneBackground} instance for convenient method chaining.
     */
    public PaneBackground setBorderWidth(Number borderWidth) {
        return this.setOption("borderWidth", borderWidth);
    }

    /**
     * Convenience method for setting the 'borderWidth' option of the pane's background.  Equivalent to:
     * <pre><code>
     *     pane.setOption("pane/background/borderWidth", '10%');
     * </code></pre>
     *
     * @param borderWidth Thickness of the background's border as a percentage of the background.
     * @return A reference to this {@link PaneBackground} instance for convenient method chaining.
     */
    public PaneBackground setBorderWidth(String borderWidth) {
        return this.setOption("borderWidth", borderWidth);
    }

    /**
     * Convenience method for setting the 'backgroundColor' option of the pane's background to an RGB hex value.  Equivalent to:
     * <pre><code>
     *     chart.setOption("pane/background/backgroundColor", "#CCCCCC");
     * </code></pre>
     * The RGB background color for the outer chart area. Defaults to "#FFFFFF".
     * <p/>
     * Note that this method is intended for setting the color to a simple RBG hex value.  If you instead
     * want to set a color to include an alpha channel or a gradient, use the {@link #setBackgroundColor(Color)}
     * version instead
     * @param backgroundColor The value to set as the 'backgroundColor' option on the pane.
     * @return A reference to this {@link PaneBackground} instance for convenient method chaining
     */
    public PaneBackground setBackgroundColor(String backgroundColor) {
        return this.setOption("backgroundColor", backgroundColor);
    }

    /**
     * Convenience method for setting the 'backgroundColor' option of the pane's background, allowing for
     * colors with opacity or gradients.  Equivalent to:
     * <pre><code>
     *     chart.setOption("/pane//backgroundColor", new Color()
     *        .setLinearGradient(0.0, 0.0, 1.0, 1.0)
     *        .addStop(new Color(255, 255, 255))
     *        .addStop(new Color(200, 200, 255))
     *     );
     * </code></pre>
     * The background color or gradient for the outer chart area. Defaults to "#FFFFFF".
     * <p/>
     * Note that this method is intended for setting the color to a gradient or color that includes
     * an alpha channel.  If you instead just want to set the color to a normal RGB hex value
     * you can use the {@link #setBackgroundColor(String)} version instead.
     * @param backgroundColor The color gradient or color with an alpha channel to set as the 'backgroundColor' option on the pane
     * @return A reference to this {@link PaneBackground} instance for convenient method chaining
     */
    public PaneBackground setBackgroundColor(Color backgroundColor) {
        return this.setOption("backgroundColor", backgroundColor != null ? backgroundColor.getOptionValue() : null);
    }

    /**
     * Convenience method for setting the 'innerRadius' option of the pane's background.  Equivalent to:
     * <pre><code>
     *     chart.setOption("pane/background/innerRadius", '100%');
     * </code></pre>
     *
     * Note: The official Highcharts API reference refers to this as "innerRadius," however it is implemented as "innerRadius."
     * @param innerRadius The distance as a percentage of the size of the chart from its center to the inner edge of the background.
     * @return A reference to this {@link PaneBackground} instance for convenient method chaining
     */
    public PaneBackground setInnerRadius(String innerRadius) {
        return this.setOption("innerRadius", innerRadius);
    }

    /**
     * Convenience method for setting the 'innerRadius' option of the pane's background.  Equivalent to:
     * <pre><code>
     *     chart.setOption("pane/background/innerRadius", 100);
     * </code></pre>
     *
     * Note: The official Highcharts API reference refers to this as "innerRadius," however it is implemented as "innerRadius."
     * @param innerRadius The distance in pixels from the center of the chart to the outer edge of the background.
     * @return A reference to this {@link PaneBackground} instance for convenient method chaining
     */
    public PaneBackground setInnerRadius(Number innerRadius) {
        return this.setOption("backgroundInnerWidth", innerRadius);
    }

    /**
     * Convenience method for setting the 'outerRadius' option of the pane's background.  Equivalent to:
     * <pre><code>
     *     chart.setOption("background/outerRadius", '100%');
     * </code></pre>
     *
     * Note: The official Highcharts API reference refers to this as "outerWidth," however it is implemented as "outerRadius."
     * @param outerRadius The distance as a percentage of the size of the chart from its center to the outer edge of the background.
     * @return  A reference to this {@link PaneBackground} instance for convenient method chaining.
     */
    public PaneBackground setOuterRadius(String outerRadius) {
        return this.setOption("outerRadius", outerRadius);
    }

    /**
     * Convenience method for setting the 'outerRadius' option of the pane's background.  Equivalent to:
     * <pre><code>
     *     chart.setOption("background/outerRadius", 100);
     * </code></pre>
     *
     * Note: The official Highcharts API reference refers to this as "outerWidth," however it is implemented as "outerRadius."
     * @param outerRadius The distance in pixels from the center of the chart to the inner edge of the background.
     * @return A reference to this {@link PaneBackground} instance for convenient method chaining.
     */
    public PaneBackground setOuterRadius(Number outerRadius) {
        return this.setOption("outerRadius", outerRadius);
    }

    /**
     * Convenience method for setting the 'background' option of the pane.  Equivalent to:
     * <pre><code>
     *     chart.setOption("pane/background/shape", "arc");
     * </code></pre>
     * The shape of the pane's background.
     * @return A reference to this {@link PaneBackground} instance for convenient method chaining.
     */
    public PaneBackground setShape(Shape shape) {
        return this.setOption("shape", shape != null ? shape.toString() : null);
    }

}
