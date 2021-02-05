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
 * Represents the configuration options that can be set for the labels of a {@link org.moxieapps.gwt.highcharts.client.PlotBand}, and
 * can then be passed to the {@link org.moxieapps.gwt.highcharts.client.PlotBand#setLabel(PlotBandLabel)} method.  Example usage:
 * <code><pre>
 *   XAxis xAxis = chart.getXAxis();
 *   xAxis.setPlotBands(
 *     xAxis.createPlotBand()
 *        .setColor("#CC0000")
 *        .setFrom(40)
 *        .setTo(80)
 *        .setPlotBandLabel(
 *           new PlotBandLabel()
 *              .setAlign(PlotBandLabel.LEFT)
 *              .setX(20)
 *        ),
 *     xAxis.createPlotBand()
 *        .setColor("#009900")
 *        .setFrom(80)
 *        .setTo(120)
 *   );
 * </pre></code>
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.0.0
 */
public class PlotBandLabel extends Configurable<PlotBandLabel> {

    /**
     * An enumeration of supported plot band label alignment types, which can be passed to methods
     * like {@link PlotBandLabel#setAlign(Align)} method.
     */
    public enum Align {

        /**
         * Align the label to the left of the plot band
         */
        LEFT("left"),

        /**
         * Align the label to the right of the plot band
         */
        RIGHT("right"),

        /**
         * Align the label on the center of the plot band
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

    /**
     * An enumeration of supported plot band label text alignment types, which can be passed to methods
     * like {@link PlotBandLabel#setTextAlign(TextAlign)} method.
     */
    public enum TextAlign {

        /**
         * Left align the text within the label
         */
        LEFT("left"),

        /**
         * Right align the text within the label
         */
        RIGHT("right"),

        /**
         * Center the text within the label
         */
        CENTER("center");

        private TextAlign(String optionValue) {
            this.optionValue = optionValue;
        }

        private final String optionValue;

        public String toString() {
            return optionValue;
        }

    }

    /**
     * An enumeration of supported plot band label vertical alignment types, which can be passed to methods
     * like {@link PlotBandLabel#setVerticalAlign(PlotBandLabel.VerticalAlign)}.
     */
    public enum VerticalAlign {

        /**
         * Align the text at the top of the plot band
         */
        TOP("top"),

        /**
         * Align the text in the middle of the plot band
         */
        MIDDLE("middle"),

        /**
         * Align the text at the bottom of the plot band
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
     * Convenience method for setting the 'align' option for the label.  Equivalent to:
     * <pre><code>
     *     plotBandLabel.setOption("align", PlotBandLabel.Align.CENTER);
     * </code></pre>
     * Horizontal alignment of the label. Can be one of "left", "center" or "right". Defaults to "center".
     *
     * @param align The horizontal alignment of the label.
     * @return A reference to this {@link PlotBandLabel} instance for convenient method chaining.
     */
    public PlotBandLabel setAlign(Align align) {
        return this.setOption("align", align != null ? align.toString() : null);
    }

    /**
     * Convenience method for setting the 'rotation' option for the label.  Equivalent to:
     * <pre><code>
     *     plotBandLabel.setOption("rotation", 90.0f);
     * </code></pre>
     * Rotation of the text label in degrees. Defaults to 0 for horizontal plot lines and 90 for vertical lines.
     *
     * @param rotation Rotation of the text label in degrees.
     * @return A reference to this {@link PlotBandLabel} instance for convenient method chaining.
     */
    public PlotBandLabel setRotation(Number rotation) {
        return this.setOption("rotation", rotation);
    }

    /**
     * Convenience method for setting the 'style' options of the labels.  Equivalent to:
     * <pre><code>
     *     plotBandLabel.setOption("/style/fontWeight", "bold");
     *     plotBandLabel.setOption("/style/fontFamily", "serif");
     *     etc.
     * </code></pre>
     *
     * @param style CSS styles for the text labels.
     * @return A reference to this {@link PlotBandLabel} instance for convenient method chaining.
     */
    public PlotBandLabel setStyle(Style style) {
        return this.setOption("style", style != null ? style.getOptions() : null);
    }

    /**
     * Convenience method for setting the 'text' option of the label.  Equivalent to:
     * <pre><code>
     *     plotBandLabel.setOption("text", "Hi Mom!");
     * </code></pre>
     *
     * @param text The raw text to display as the label.
     * @return A reference to this {@link PlotBandLabel} instance for convenient method chaining.
     */
    public PlotBandLabel setText(String text) {
        return this.setOption("text", text);
    }

    /**
     * Convenience method for setting the 'textAlign' option for the label.  Equivalent to:
     * <pre><code>
     *     plotBandLabel.setOption("textAlign", PlotBandLabel.TextAlign.RIGHT);
     * </code></pre>
     * The text alignment for the label. While <code>align</code> determines where the texts anchor point
     * is placed within the plot band,  <code>textAlign</code> determines how the text is aligned against
     * its anchor point. Possible values are "left", "center" and "right".
     * Defaults to the same as the <code>align</code> option.
     *
     * @param textAlign The text alignment for the label.
     * @return A reference to this {@link PlotBandLabel} instance for convenient method chaining.
     */
    public PlotBandLabel setTextAlign(TextAlign textAlign) {
        return this.setOption("textAlign", textAlign != null ? textAlign.toString() : null);
    }

    /**
     * Convenience method for setting the 'verticalAlign' option for the label.  Equivalent to:
     * <pre><code>
     *     plotBandLabel.setOption("verticalAlign", PlotBandLabel.VerticalAlign.TOP);
     * </code></pre>
     * Vertical alignment of the label relative to the plot band. Can be one of "top", "middle" or "bottom". Defaults to "top".
     *
     * @param verticalAlign The vertical alignment of the label relative to the plot band.
     * @return A reference to this {@link PlotBandLabel} instance for convenient method chaining.
     */
    public PlotBandLabel setVerticalAlign(VerticalAlign verticalAlign) {
        return this.setOption("verticalAlign", verticalAlign != null ? verticalAlign.toString() : null);
    }

    /**
     * Convenience method for setting the 'x' position option of the label.  Equivalent to:
     * <pre><code>
     *     plotBandLabel.setOption("x", 70);
     * </code></pre>
     * Horizontal position relative the alignment. Default varies by orientation.
     *
     * @param x The horizontal position relative the alignment.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.labels.PlotBandLabel} instance for convenient method chaining.
     */
    public PlotBandLabel setX(Number x) {
        return this.setOption("x", x);
    }

    /**
     * Convenience method for setting the 'y' position option of the label.  Equivalent to:
     * <pre><code>
     *     plotBandLabel.setOption("y", -20);
     * </code></pre>
     * Vertical position of the text baseline relative to the alignment. Default varies by orientation.
     *
     * @param y The vertical position of the text baseline relative to the alignment.
     * @return A reference to this {@link PlotBandLabel} instance for convenient method chaining.
     */
    public PlotBandLabel setY(Number y) {
        return this.setOption("y", y);
    }

}
