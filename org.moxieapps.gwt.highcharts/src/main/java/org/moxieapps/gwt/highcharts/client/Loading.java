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
 * A configurable class that can be used to represent custom loading options for the
 * chart, which can then be set on the chart (via the {@link Chart#setLoading(Loading)} method.)
 * The loading options control the appearance of the loading screen that covers the plot area
 * on chart operations. This screen only appears after an explicit call to
 * {@link Chart#showLoading(String)}. It is a utility for developers to communicate to
 * the end user that something is going on, for example while retrieving new data via GWT remoting
 * requests. The "Loading..." text itself is not part of this configuration object, but part of
 * the {@link Lang} object.
 * Example usage:
 * <code><pre>
 *   chart.setLoading(
 *     new Loading()
 *       .setShowDuration(500)
 *       .setStyle(
 *           new Style()
 *              .setColor("red")
 *              .setFontSize("16px")
 *       )
 *   );
 * </pre></code>
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.0.0
 */
public class Loading extends Configurable<Loading> {

    /**
     * Convenience method for setting the 'hideDuration' option of the loading options.  Equivalent to:
     * <pre><code>
     *     loading.setOption("hideDuration", 150);
     * </code></pre>
     * The duration in milliseconds of the fade out effect. Defaults to 100.
     *
     * @param hideDuration The duration in milliseconds of the fade out effect.
     * @return A reference to this {@link Loading} instance for convenient method chaining.
     */
    public Loading setHideDuration(Number hideDuration) {
        return this.setOption("hideDuration", hideDuration);
    }

    /**
     * Convenience method for setting the 'labelStyle' options of the loading options.  Equivalent to:
     * <pre><code>
     *     loading.setOption("labelStyle/fontSize", "16px");
     *     loading.setOption("labelStyle/color", "red");
     * </code></pre>
     * CSS styles for the loading label span. Defaults to:
     * <ul>
     *     <li>fontWeight: bold</li>
     *     <li>position: relative</li>
     *     <li>top: 1em</li>
     * </ul>
     *
     * @param labelStyle The CSS styles for the loading label span.
     * @return A reference to this {@link Loading} instance for convenient method chaining.
     */
    public Loading setLabelStyle(Style labelStyle) {
        return this.setOption("labelStyle", labelStyle != null ? labelStyle.getOptions() : null);
    }

    /**
     *
     * Convenience method for setting the 'showDuration' option of the loading options.  Equivalent to:
     * <pre><code>
     *     loading.setOption("showDuration", 150);
     * </code></pre>
     * The duration in milliseconds of the fade in effect. Defaults to 100.
     *
     * @param showDuration The duration in milliseconds of the fade in effect.
     * @return A reference to this {@link Loading} instance for convenient method chaining.
     */
    public Loading setShowDuration(Number showDuration) {
        return this.setOption("showDuration", showDuration);
    }

    /**
     * Convenience method for setting the 'labelStyle' options of the loading options.  Equivalent to:
     * <pre><code>
     *     loading.setOption("style/backgroundColor", "red");
     *     loading.setOption("style/opacity", "0.8
     * </code></pre>
     * CSS styles for the loading screen that covers the plot area. Defaults to:
     * <ul>
     *     <li>position: absolute</li>
     *     <li>backgroundColor: 'white'</li>
     *     <li>opacity: 0.5</li>
     *     <li>textAlign: center</li>
     * </ul>
     *
     * @param style The CSS styles for the loading screen that covers the plot area.
     * @return A reference to this {@link Loading} instance for convenient method chaining.
     */
    public Loading setStyle(Style style) {
        return this.setOption("style", style != null ? style.getOptions() : null);
    }

}
