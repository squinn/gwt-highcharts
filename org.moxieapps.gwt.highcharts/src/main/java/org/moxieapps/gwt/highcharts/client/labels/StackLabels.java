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
 * Represents the configuration options that can be set for the stack labels on the y-axis of a chart, and
 * can then be passed to the {@link org.moxieapps.gwt.highcharts.client.YAxis#setStackLabels(StackLabels)}
 * method.  Example usage:
 * <code><pre>
 *   chart.getYAxis().setStackLabels(
 *     new StackLabels()
 *       .setAlign(Labels.Align.LEFT)
 *       .setColor("#CC0000")
 *   );
 * </pre></code>
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.0.0
 */
public class StackLabels extends Labels<StackLabels> {

    /**
     * An enumeration of supported stack labels vertical alignment types, which can be passed to methods
     * like {@link StackLabels#setVerticalAlign(StackLabels.VerticalAlign)} method.
     */
    public enum VerticalAlign {

        /**
         * Show the labels at the top of the column
         */
        TOP("top"),

        /**
         * Show the labels in the middle of the column
         */
        MIDDLE("middle"),

        /**
         * Show the labels at the bottom of the column
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

    private StackLabelsFormatter stackLabelsFormatter;

    /**
     * Sets a custom formatter for the stack labels on the axis that can be used to control how the text of the
     * stack labels will be displayed.  See the {@link StackLabelsFormatter} interface, and
     * in particular the {@link StackLabelsFormatter#format(StackLabelsData)} method for more details on
     * the capabilities available to custom formatters.
     *
     * @param stackLabelsFormatter The custom formatter to use for the stack labels (if not given a built-in
     *                            generic formatter is used which simply returns the total value of the stack).
     * @return A reference to this {@link StackLabels} instance for convenient method chaining.
     */
    public StackLabels setFormatter(StackLabelsFormatter stackLabelsFormatter) {
        this.stackLabelsFormatter = stackLabelsFormatter;
        return this;
    }

    /**
     * Returns the custom stack labels formatter that has been applied to the y-axis, or null if the
     * built-in generic formatter is being used instead.
     *
     * @return The custom axis labels formatter that has been applied to the y-axis, or null if it has not been set.
     */
    public StackLabelsFormatter getFormatter() {
        return this.stackLabelsFormatter;
    }

    /**
     * Convenience method for setting the 'textAlign' option for the labels.  Equivalent to:
     * <pre><code>
     *     stackLabels.setOption("textAlign", Labels.Align.CENTER);
     * </code></pre>
     * The text alignment for the label. While {@link StackLabels#setAlign(Align)} determines where the text's
     * anchor point is placed with regards to the stack, 'textAlign' determines how the text is aligned
     * against its anchor point. Possible values are "left", "center" and "right". The default value is
     * calculated at runtime and depends on orientation and whether the stack is positive or negative.
     *
     * @param textAlign The text alignment for the label.
     * @return A reference to this {@link StackLabels} instance for convenient method chaining.
     */
    public StackLabels setTextAlign(Align textAlign) {
        return this.setOption("textAlign", textAlign != null ? textAlign.toString() : null);
    }

    /**
     * Convenience method for setting the 'verticalAlign' option for the labels.  Equivalent to:
     * <pre><code>
     *     stackLabels.setOption("verticalAlign", StackLabels.VerticalAlign.MIDDLE);
     * </code></pre>
     * Defines the vertical alignment of the stack total label. Can be one of "top", "middle" or
     * "bottom". The default value is calculated at runtime and depends on orientation and whether
     * the stack is positive or negative.
     *
     * @param verticalAlign The vertical alignment of the stack total label.
     * @return A reference to this {@link StackLabels} instance for convenient method chaining.
     */
    public StackLabels setVerticalAlign(VerticalAlign verticalAlign) {
        return this.setOption("verticalAlign", verticalAlign != null ? verticalAlign.toString() : null);
    }

}
