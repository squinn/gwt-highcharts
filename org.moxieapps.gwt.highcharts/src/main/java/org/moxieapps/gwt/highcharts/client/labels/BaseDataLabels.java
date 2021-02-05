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
 * A common base class for both {@link DataLabels} and {@link ProportionalDataLabels} to prevent code duplication
 * while still maintaining a cleaner way for the user to utilize the method chaining with the generics
 * in place.  You should not use this class directly, but instead use one of the base classes.
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.0.0
 */
public abstract class BaseDataLabels<T extends BaseDataLabels> extends Labels<T> {

    /**
     * Convenience method for setting the 'backgroundColor' option for the data labels.  Equivalent to:
     * <pre><code>
     *     labels.setOption("backgroundColor", "#CC0000");
     * </code></pre>
     * The background color or gradient for the data label. Defaults to undefined.
     *
     * @param backgroundColor The background color or gradient for the data label.
     * @return A reference to this {@link BaseDataLabels} instance for convenient method chaining.
     * @since 1.3.0
     */
    public T setBackgroundColor(String backgroundColor) {
        return this.setOption("backgroundColor", backgroundColor);
    }

    /**
     * Convenience method for setting the 'borderColor' option for the data labels.  Equivalent to:
     * <pre><code>
     *     labels.setOption("borderColor", "#CC0000");
     * </code></pre>
     * The border color for the data label. Defaults to undefined.
     *
     * @param borderColor The border color for the data label.
     * @return A reference to this {@link BaseDataLabels} instance for convenient method chaining.
     * @since 1.3.0
     */
    public T setBorderColor(String borderColor) {
        return this.setOption("borderColor", borderColor);
    }

    /**
     * Convenience method for setting the 'borderRadius' option for the data labels.  Equivalent to:
     * <pre><code>
     *     labels.setOption("borderRadius", 3);
     * </code></pre>
     * The border radius in pixels for the data label. Defaults to 0.
     *
     * @param borderRadius The border radius in pixels for the data label.
     * @return A reference to this {@link BaseDataLabels} instance for convenient method chaining.
     * @since 1.3.0
     */
    public T setBorderRadius(Number borderRadius) {
        return this.setOption("borderRadius", borderRadius);
    }

    /**
     * Convenience method for setting the 'borderWidth' option for the data labels.  Equivalent to:
     * <pre><code>
     *     labels.setOption("borderWidth", 3);
     * </code></pre>
     * The border width in pixels for the data label. Defaults to 0.
     *
     * @param borderWidth The border width in pixels for the data label.
     * @return A reference to this {@link BaseDataLabels} instance for convenient method chaining.
     * @since 1.3.0
     */
    public T setBorderWidth(Number borderWidth) {
        return this.setOption("borderWidth", borderWidth);
    }

    /**
     * Convenience method for setting the 'padding' option for the data labels.  Equivalent to:
     * <pre><code>
     *     labels.setOption("padding", 3);
     * </code></pre>
     * When either the borderWidth or the backgroundColor is set, this is the padding within the box. Defaults to 2.
     *
     * @param padding The padding within the box (only visible when 'borderWidth' is non-zero).
     * @return A reference to this {@link BaseDataLabels} instance for convenient method chaining.
     * @since 1.3.0
     */
    public T setPadding(Number padding) {
        return this.setOption("padding", padding);
    }

    /**
     * Convenience method for setting the 'shadow' option for the data labels.  Equivalent to:
     * <pre><code>
     *     labels.setOption("shadow", true);
     * </code></pre>
     * The shadow of the box. Works best with borderWidth or backgroundColor Defaults to false.
     *
     * @param shadow 'true' to disable a shadow around the box.
     * @return A reference to this {@link BaseDataLabels} instance for convenient method chaining.
     * @since 1.3.0
     */
    public T setShadow(boolean shadow) {
        return this.setOption("shadow", shadow);
    }

    /**
     * Convenience method for setting the 'useHTML' option for the data labels.  Equivalent to:
     * <pre><code>
     *     labels.setOption("useHTML", false);
     * </code></pre>
     * Whether to use HTML to render the data label text.
     * Using HTML allows for advanced formatting, images and reliable bi-directional text rendering.
     * Note that exported images won't respect the HTML, and that HTML won't respect Z-index settings.
     * @param useHTML 'true' to use HTML to render label texts.
     * @return A reference to this {@link BaseDataLabels} instance for convenient method chaining.
     */
    public T setUseHTML(Boolean useHTML) {
        return this.setOption("useHTML", useHTML);
    }

    /**
     * Convenience method for setting the 'format' option for a dataLabel.  Equivalent to:
     * <pre><code>
     *     dataLabel.setOption("format", "{y} mm");
     * </code></pre>
     * A format string for the data label. Available variables are the same as for formatter. Defaults to {y}.
     * @param format A format string used to set the format for s series on a chart.
     * @return A reference to this {@link BaseDataLabels} instance for convenient method chaining.
     * @since 1.6.0
     */
    public T setFormat(String format) {
        return this.setOption("format", format);
    }

    private DataLabelsFormatter dataLabelsFormatter;

    /**
     * Sets a custom formatter for the labels that can be used to control how the text of the
     * data labels will be displayed.  See the {@link DataLabelsFormatter} interface, and
     * in particular the {@link DataLabelsFormatter#format(DataLabelsData)} method for more details on
     * the capabilities available to custom formatters.
     *
     * @param dataLabelsFormatter The custom formatter to use for the labels (if not given a built-in
     *                            generic formatter is used which simply returns the Y value of the point).
     * @return A reference to this {@link DataLabels} instance for convenient method chaining.
     */
    public T setFormatter(DataLabelsFormatter dataLabelsFormatter) {
        this.dataLabelsFormatter = dataLabelsFormatter;
        @SuppressWarnings({"unchecked", "UnnecessaryLocalVariable"})
        final T instance = (T) this;
        return instance;
    }

    /**
     * Returns the custom data labels formatter that has been applied to the labels, or null if the
     * built-in generic formatter is being used instead.
     *
     * @return The custom data labels formatter that has been applied, or null if it has not been set.
     */
    public DataLabelsFormatter getFormatter() {
        return this.dataLabelsFormatter;
    }

}
