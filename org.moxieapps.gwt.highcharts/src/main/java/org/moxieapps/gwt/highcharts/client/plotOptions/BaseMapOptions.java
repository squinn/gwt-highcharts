/*
 * Copyright 2014 Moxie Group
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
package org.moxieapps.gwt.highcharts.client.plotOptions;

import org.moxieapps.gwt.highcharts.client.Animation;

/**
 * A common base class for {@link HeatmapPlotOptions} and other map plot types to prevent code duplication while still
 * maintaining a cleaner way for the user to utilize the method chaining with the generics in place.  You should not
 * instantiate this calss directly, but instead use one of its inheriting classes.
 * @author cskowron@moxiegroup.com  (Cory Skowronek)
 * @since 1.7.0
 */
public abstract class BaseMapOptions<T extends BaseMapOptions> extends PlotOptions<T> {

    /**
     * Convenience method for setting the 'borderColor' option of the map plotOptions.  Equivalent to:
     * <pre><code>
     *     mapPlotOptions.setOption("borderColor", "red");
     * </code></pre>
     * The border color of the map areas. Defaults to silver.
     * @param borderColor The value to set as the border color for map charts.
     * @return A reference to this {@link BaseMapOptions} instance for convenient method chaining.
     */
    public T setBorderColor(String borderColor) {
        return this.setOption("color", borderColor);
    }

    /**
     * Convenience method for setting the 'borderWidth' option of the map plotOptions.  Equivalent to:
     * <pre><code>
     *     mapPlotOptions.setOption("borderWidth", 2);
     * </code></pre>
     * The border width of each map area. Defaults to 1.
     * @param borderWidth The value to set as the width of the border of a map area.
     * @return A reference to this {@link BaseMapOptions} instance for convenient method chaining.
     */
    public T setBorderWidth(Number borderWidth) {
        return this.setOption("borderWidth", borderWidth);
    }

    // TODO setPoint

    /**
     * Convenience method for setting the 'borderColor' option of the hover state.  Equivalent to:
     * <pre><code>
     *     mapPlotOptions.setOption("states/hover/borderColor", "red");
     * </code></pre>
     * The border color of the point in this state.
     * @param hoverStateBorderColor The border color of the point in the hover state.
     * @return A reference to this {@link BaseMapOptions} instance for convenient method chaining.
     */
    public T setHoverStateBorderColor(String hoverStateBorderColor) {
        return this.setOption("states/hover/borderColor", hoverStateBorderColor);
    }

    /**
     * Convenience method for setting the 'borderWidth' option of the hover state.  Equivalent to:
     * <pre><code>
     *     mapPlotOptions.setOption("states/hover/borderWidth", 2);
     * </code></pre>
     * The border width of the point in this state.
     * @param hoverStateBorderWidth The border width of map areas in the 'hover' state.
     * @return A reference to this {@link BaseMapOptions} instance for convenient method chaining.
     */
    public T setHoverStateBorderWidth(Number hoverStateBorderWidth) {
        return this.setOption("states/hover/borderWidth", hoverStateBorderWidth);
    }

    /**
     * Convenience method for setting the 'brightness' option of the hover state.  Equivalent to:
     * <pre><code>
     *     mapPlotOptions.setOption("states/hover/brightness", 1);
     * </code></pre>
     * The relative brightness of the point when hovered, relative to the normal point color. Defaults to 0.2.
     * @param hoverStateBrightness The brightness of map areas in the 'hover' state
     * @return A reference to this {@link BaseMapOptions} instance for convenient method chaining.
     */
    public T setHoverStateBrightness(Number hoverStateBrightness) {
        return this.setOption("states/hover/brightness", hoverStateBrightness);
    }

    /**
     * Convenience method for setting the 'color' option of the hover state.  Equivalent to:
     * <pre><code>
     *     mapPlotOptions.setOption("states/hover/color", "red");
     * </code></pre>
     * The color of the shape in the 'hover' state.
     * @param color The color, as a String, of a map area in the 'hover' state.
     * @return A reference to this {@link BaseMapOptions} instance for convenient method chaining.
     */
    public T setHoverStateColor(String color) {
        return this.setOption("states/hover/color", color);
    }

    /**
     * Convenience method for setting the 'enabled' option of the hover state. Equivalent to:
     * <pre><code>
     *     mapPlotOptions.setOption("states/hover/enabled", false);
     * </code></pre>
     * Enable separate styles for the series in different states. Defaults to true.
     * @param hoverStateEnabled Whether to enable separate styles for map areas in the 'normal' state.
     * @return A reference to this {@link BaseMapOptions} instance for convenient method chaining.
     */
    public T setHoverStateEnabled(boolean hoverStateEnabled) {
        return this.setOption("states/hover/enabled", hoverStateEnabled);
    }

    /**
     * Convenience method for setting the 'animation' option of the select state.  Equivalent to:
     * <pre><code>
     *     mapPlotOptions.setOption("states/normal/animation", new Animation());
     * </code></pre>
     * Animation options for the fill color when returning from hover state to normal state. The animation adds some
     * latency in order to reduce the effect of flickering when hovering in and out of for example an uneven coastline.
     * @param normalStateAnimation An instance of the {@link Animation} class representing animation options
     *                             for the map area in the 'normal' state.
     * @return A reference to this {@link BaseMapOptions} instance for convenient method chaining.
     */
    public T setNormalStateAnimation(Animation normalStateAnimation) {
        return this.setOption("states/normal/animation", normalStateAnimation.getOptions());
    }

    /**
     * Convenience method for setting the 'animation' option of the select state.  Equivalent to:
     * <pre><code>
     *     mapPlotOptions.setOption("states/normal/animation", false);
     * </code></pre>
     * Animation options for the fill color when returning from hover state to normal state. The animation adds some
     * latency in order to reduce the effect of flickering when hovering in and out of for example an uneven coastline.
     * Defaults to true.
     * @param normalStateAnimation Whether to enable animation for a map area in the 'normal' state.
     * @return A reference to this {@link BaseMapOptions} instance for convenient method chaining.
     */
    public T setNormalStateAnimation(Boolean normalStateAnimation) {
        return this.setOption("states/normal/animation", normalStateAnimation);
    }

    /**
     * Convenience method for setting the 'borderColor' option of the select state.  Equivalent to:
     * <pre><code>
     *     mapPlotOptions.setOption("states/select/borderColor", "red");
     * </code></pre>
     * The border color of the point in this state
     * @param selectStateBorderColor The border color of the selected map area
     * @return A reference to this {@link BaseMapOptions} instance for convenient method chaining.
     */
    public T setSelectStateBorderColor(String selectStateBorderColor) {
        return this.setOption("states/select/borderColor", selectStateBorderColor);
    }

    /**
     * Convenience method for setting the 'borderWidth' option of the select state.  Equivalent to:
     * <pre><code>
     *     mapPlotOptions.setOption("states/select/borderWidth", 2);
     * </code></pre>
     * The border width of the point in this state
     * @param selectStateBorderWidth the width of the border of the selected map area.
     * @return A reference to this {@link BaseMapOptions} instance for convenient method chaining.
     */
    public T setSelectStateBorderWidth(Number selectStateBorderWidth) {
        return this.setOption("states/select/borderWidth", selectStateBorderWidth);
    }

    /**
     * Convenience method for setting the 'color' option of the select state.  Equivalent to:
     * <pre><code>
     *     mapPlotOptions.setOption("states/select/color", "silver");
     * </code></pre>
     * The color of the shape in this state.
     * @param selectStateColor The color of the map area in the 'select' state.
     * @return A reference to this {@link BaseMapOptions} instance for convenient method chaining.
     */
    public T setSelectStateColor(String selectStateColor) {
        return this.setOption("states/select/color", selectStateColor);
    }

    /**
     * Convenience method for setting the 'enabled' option of the select state.  Equivalent to:
     * <pre><code>
     *     mapPlotOptions.setOption("states/select/enabled", false);
     * </code></pre>
     * Enable separate styles for the series in different states. Defaults to true.
     * @param selectStateEnabled Whether to enable a separate style for map areas in the 'select' state.
     * @return A reference to this {@link BaseMapOptions} instance for convenient method chaining.
     */
    public T setSelectStateEnabled(Boolean selectStateEnabled) {
        return this.setOption("states/select/enabled", selectStateEnabled);
    }
}
