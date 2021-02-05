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

package org.moxieapps.gwt.highcharts.client;

/**
 * a configurable class that represents a collection SVG and CSS attributes that are used for changing the look of
 * various chart elements that support the setTheme method (e.g. {@link Drilldown#setDrillUpButtonTheme(Theme)},
 * {@link MapNavigation.ButtonOptions#setTheme(Theme)}.)
 * The object takes SVG attributes like fill, stroke, stroke-width or r, the border radius. The theme also supports
 * style, a collection of CSS properties for the text.
 * @author cskowron@moxiegroup.com (Cory Skowronek)
 * @since 1.7.0
 */
public class Theme extends Configurable<Theme> {

    /**
     * Convenience method for setting the 'strokeWidth' option of the theme.  Equivalent to:
     * <pre><code>
     *     theme.setOption("strokeWidth", );
     * </code></pre>
     * The stroke-width property defines the thickness of a line, text or outline of an element.
     * @param strokeWidth The width of the outline on the current object.
     * @return A reference to this {@link Theme} instance for convenient method chaining.
     */
    public Theme setStrokeWidth(Number strokeWidth) {
        return this.setOption("stroke-width", strokeWidth);
    }

    /**
     * Convenience method for setting the 'stroke' option of the theme.  Equivalent to:
     * <pre><code>
     *     theme.setOption("stroke", "#0000FF");
     * </code></pre>
     * The stroke property defines the color of a line, text or outline of an element.
     * @param stroke The color of the outline on the current object.
     * @return A reference to this {@link Theme} instance for convenient method chaining.
     */
    public Theme setStroke(String stroke) {
        return this.setOption("stroke", stroke);
    }

    /**
     * Convenience method for setting the 'fill' option of the theme.  Equivalent to:
     * <pre><code>
     *     theme.setOption("fill", "#FF0000");
     * </code></pre> The fill property describes the color of the inside of an element.
     * @param fill The color inside the object
     * @return A reference to this {@link Theme} instance for convenient method chaining.
     */
    public Theme setFill(String fill) {
        return this.setOption("fill", fill);
    }

    /**
     * Convenience method for setting the 'r' option of the theme.  Equivalent to:
     * <pre><code>
     *     theme.setOption("r", 10);
     * </code></pre>
     * For a circle, this attribute defines the radius of the element.
     * A value of zero disables rendering of the circle.
     * @param r The radius of the element.
     * @return A reference to this {@link Theme} instance for convenient method chaining.
     */
    public Theme setR(Number r) {
        return this.setOption("r", r);
    }

    /**
     * Convenience method for setting the 'padding' option of the theme.  Equivalent to:
     * <pre><code>
     *     theme.setOption("padding", 15);
     * </code></pre>
     * The padding CSS property sets the required padding space on all sides of an element.
     * @param padding The padding space for the element
     * @return A reference to this {@link Theme} instance for convenient method chaining.
     */
    public Theme setPadding(Number padding) {
        return this.setOption("padding", padding);
    }

    /**
     * Convenience method for setting the 'style' option of the theme.  Equivalent to:
     * <pre><code>
     *     theme.setOption("style", new Style());
     * </code></pre>
     * @param style CSS styles for the axis theme.
     * @return A reference to this {@link Theme} instance for convenient method chaining.
     */
    public Theme setStyle(Style style) {
        return this.setOption("style", style != null ? style.getOptions() : null);
    }
}
