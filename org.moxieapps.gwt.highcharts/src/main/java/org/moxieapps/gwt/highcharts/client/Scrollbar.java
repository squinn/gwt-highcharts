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
 * A configurable class that can be used to represent custom scrollbar options within a {@link StockChart},
 * which can then be set on the chart (via the {@link StockChart#setScrollbar(Scrollbar)} method.)
 * The scrollbar is a means of panning over the X axis of a chart.
 * Example usage:
 * <code><pre>
 *   stockChart.setScrollbar(
 *     new Scrollbar()
 *       .setBarBorderColor("#CC0000")
 *       .setMinWidth(5)
 *   );
 * </pre></code>
 * @author cskowron@moxiegroup.com (Cory Skowronek)
 * @since 1.6.0
 */
public class Scrollbar extends Configurable<Scrollbar>{

    /**
     * Convenience method for setting the "barBackgroundColor" option for the scrollbar.  Equivalent to:
     * <pre><code>
     *     scrollbar.setOption("barBackgroundColor", "#666" );
     * </code></pre>
     * The background color of the scrollbar itself. Defaults to a gray gradient.
     * @param barBackgroundColor The background color, as a string, of the scrollbar.
     * @return A reference to this {@link Scrollbar} instance for convenient method chaining.
     */
    public Scrollbar setBarBackgroundColor(String barBackgroundColor) {
        return this.setOption("barBackgroundColor", barBackgroundColor);
    }

    /**
     * Convenience method for setting the "borderColor" option for the scrollbar.  Equivalent to:
     * <pre><code>
     *     scrollbar.setOption("borderColor", "#666");
     * </code></pre>
     * The color of the bar's border. Defaults to #666.
     * @param borderColor The color, as a string, of the bar's border.
     * @return A reference to this {@link Scrollbar} instance for convenient method chaining.
     */
    public Scrollbar setBorderColor(String borderColor) {
        return this.setOption("borderColor", borderColor);
    }

    /**
     * Convenience method for setting the "borderRadius" option for the scrollbar.  Equivalent to:
     * <pre><code>
     *     scrollbar.setOption("borderRadius", 3);
     * </code></pre>
     * The border rounding radius of the bar. Defaults to 2.
     * @param borderRadius The length, in pixels, of the border's radius.
     * @return A reference to this {@link Scrollbar} instance for convenient method chaining.
     */
    public Scrollbar setBarBorderRadius(Number borderRadius) {
        return this.setOption("barBorderRadius", borderRadius);
    }

    /**
     * Convenience method for setting the "barBorderWidth" option for the scrollbar.  Equivalent to:
     * <pre><code>
     *     scrollbar.setOption("barBorderWidth", 2);
     * </code></pre>
     * The width of the bar's border. Defaults to 1.
     * @param barBorderWidth The width, in pixels, of the bar's border.
     * @return A reference to this {@link Scrollbar} instance for convenient method chaining.
     */
    public Scrollbar setBarBorderWidth(Number barBorderWidth) {
        return this.setOption("barBorderWidth", barBorderWidth);
    }

    /**
     * Convenience method for setting the "buttonArrowColor" option for the scrollbar.  Equivalent to:
     * <pre><code>
     *     scrollbar.setOption("buttonArrowColor", "#666");
     * </code></pre>
     * The color of the small arrow inside the scrollbar buttons. Defaults to #666.
     * @param buttonArrowColor The color, as a string, of the arrows in the scrollbar button.
     * @return A reference to this {@link Scrollbar} instance for convenient method chaining.
     */
    public Scrollbar setButtonArrowColor(String buttonArrowColor) {
        return this.setOption("buttonArrowColor", buttonArrowColor);
    }

    /**
     * Convenience method for setting the "buttonBackgroundColor" option for the scrollbar.  Equivalent to:
     * <pre><code>
     *     scrollbar.setOption("buttonBackgroundColor", "#666");
     * </code></pre>
     * The color of scrollbar buttons. Defaults to a gray gradient.
     * @param buttonBackgroundColor The color, as a string, of the scrollbar's button.
     * @return A reference to this {@link Scrollbar} instance for convenient method chaining.
     */
    public Scrollbar setButtonBackgroundColor(String buttonBackgroundColor) {
        return this.setOption("buttonBackgroundColor", buttonBackgroundColor);
    }

    /**
     * Convenience method for setting the "buttonBorderColor" option for the scrollbar.  Equivalent to:
     * <pre><code>
     *     scrollbar.setOption("buttonBorderColor", "#666");
     * </code></pre>
     * The color of the border of the scrollbar buttons. Defaults to #666.
     * @param buttonBorderColor The color, as a string, of the border of the scrollbar buttons.
     * @return A reference to this {@link Scrollbar} instance for convenient method chaining.
     */
    public Scrollbar setButtonBorderColor(String buttonBorderColor) {
        return this.setOption("buttonBorderColor", buttonBorderColor);
    }

    /**
     * Convenience method for setting the "buttonBorderRadius" option for the scrollbar.  Equivalent to:
     * <pre><code>
     *     scrollbar.setOption("buttonBorderRadius", 3);
     * </code></pre>
     * The corner radius of the scrollbar buttons. Defaults to 2.
     * @param buttonBorderRadius The radius, in pixels, of the scrollbar buttons.
     * @return A reference to this {@link Scrollbar} instance for convenient method chaining.
     */
    public Scrollbar setButtonBorderRadius(Number buttonBorderRadius) {
        return this.setOption("buttonBorderRadius", buttonBorderRadius);
    }

    /**
     * Convenience method for setting the "buttonBorderWidth" option for the scrollbar.  Equivalent to:
     * <pre><code>
     *     scrollbar.setOption("buttonBorderWidth", 2);
     * </code></pre>
     * The border width of the scrollbar buttons. Defaults to 1.
     * @param buttonBorderWidth The width, in pixels, of the scrollbar button's border.
     * @return A reference to this {@link Scrollbar} instance for convenient method chaining.
     */
    public Scrollbar setButtonBorderWidth(Number buttonBorderWidth) {
        return this.setOption("buttonBorderWidth", buttonBorderWidth);
    }

    /**
     * Convenience method for setting the "enabled" option for the scrollbar.  Equivalent to:
     * <pre><code>
     *     scrollbar.setOption("enabled", false);
     * </code></pre>
     * Enable or disable the scrollbar. Defaults to true.
     * @param enabled False to disable the scrollbar.
     * @return A reference to this {@link Scrollbar} instance for convenient method chaining.
     */
    public Scrollbar setEnabled(boolean enabled) {
        return this.setOption("enabled", enabled);
    }

    /**
     * Convenience method for setting the "height" option for the scrollbar.  Equivalent to:
     * <pre><code>
     *     scrollbar.setOption("height", 10);
     * </code></pre>
     * The height of the scrollbar. The height also applies to the width of the scroll arrows so that
     * they are always squares. Defaults to 20 for touch devices and 14 for mouse devices.
     * @param height The height, in pixels, of the scrollbar.
     * @return A reference to this {@link Scrollbar} instance for convenient method chaining.
     */
    public Scrollbar setHeight(Number height) {
        return this.setOption("height", height);
    }

    /**
     * Convenience method for setting the "liveRedraw" option for the scrollbar.  Equivalent to:
     * <pre><code>
     *     scrollbar.setOption("liveRedraw", false);
     * </code></pre>
     * Whether to redraw the main chart as the scrollbar or the navigator zoomed window is moved.
     * Defaults to true for modern browsers and false for legacy IE browsers.
     * @param liveRedraw True to redraw the chart as the navigator is moved.
     * @return A reference to this {@link Scrollbar} instance for convenient method chaining.
     */
    public Scrollbar setLiveRedraw(boolean liveRedraw) {
        return this.setOption("liveRedraw", liveRedraw);
    }

    /**
     * Convenience method for setting the "minWidth" option for the scrollbar.  Equivalent to:
     * <pre><code>
     *     scrollbar.setOption("minWidth", 4);
     * </code></pre>
     * The minimum width of the scrollbar. Defaults to 6.
     * @param minWidth The minimum width, in pixels, of the scrollbar.
     * @return A reference to this {@link Scrollbar} instance for convenient method chaining.
     */
    public Scrollbar setMinWidth(Number minWidth) {
        return this.setOption("minWidth", minWidth);
    }

    /**
     * Convenience method for setting the "rifleColor" option for the scrollbar.  Equivalent to:
     * <pre><code>
     *     scrollbar.setOption("rifleColor", "#666");
     * </code></pre>
     * The color of the small rifles in the middle of the scrollbar. Defaults to #666.
     * @param rifleColor The color, as a atring, of the rifles inside the scrollbar.
     * @return A reference to this {@link Scrollbar} instance for convenient method chaining.
     */
    public Scrollbar setRifleColor(String rifleColor) {
        return this.setOption("rifleColor", rifleColor);
    }

    /**
     * Convenience method for setting the "trackBackgroundColor" option for the scrollbar.  Equivalent to:
     * <pre><code>
     *     scrollbar.setOption("trackBackgroundColor", "#666");
     * </code></pre>
     * The color of the track background. The default is a gray gradient.
     * @param trackBackgroundColor The color, as a string, of the track's background.
     * @return A reference to this {@link Scrollbar} instance for convenient method chaining.
     */
    public Scrollbar setTrackBackgroundColor(String trackBackgroundColor) {
        return this.setOption("trackBackgroundColor", trackBackgroundColor);
    }

    /**
     * Convenience method for setting the "trackBorderColor" option for the scrollbar.  Equivalent to:
     * <pre><code>
     *     scrollbar.setOption("trackBorderColor", "#666");
     * </code></pre>
     * The color of the border of the scrollbar track.
     * @param trackBorderColor The color, as a string, of the track's border.
     * @return A reference to this {@link Scrollbar} instance for convenient method chaining.
     */
    public Scrollbar setTrackBorderColor(String trackBorderColor){
        return this.setOption("trackBorderColor", trackBorderColor);
    }

    /**
     * Convenience method for setting the "trackBorderRadius" option for the scrollbar.  Equivalent to:
     * <pre><code>
     *     scrollbar.setOption("trackBorderRadius", 1);
     * </code></pre>
     * The corner radius of the border of the scrollbar track. Defaults to 0.
     * @param trackBorderRadius The radius, in pixels, of the track's border.
     * @return A reference to this {@link Scrollbar} instance for convenient method chaining.
     */
    public Scrollbar setTrackBorderRadius(Number trackBorderRadius) {
        return this.setOption("trackBorderRadius", trackBorderRadius);
    }

    /**
     * Convenience method for setting the "trackBorderWidth" option for the scrollbar.  Equivalent to:
     * <pre><code>
     *     scrollbar.setOption("trackBorderWidth", 2);
     * </code></pre>
     * The width of the border of the scrollbar track. Defaults to 1.
     * @param trackBorderWidth The width, in pixels, of the track's border.
     * @return A reference to this {@link Scrollbar} instance for convenient method chaining.
     */
    public Scrollbar setTrackBorderWidth(Number trackBorderWidth) {
        return this.setOption("trackBorderWidth", trackBorderWidth);
    }

}

