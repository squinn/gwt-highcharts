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
 * A configurable class that can be used to represent custom CSS style options for the
 * chart, which can then be set on various other configuration objects (e.g.
 * {@link Chart#setStyle(Style)}, {@link ChartTitle#setStyle(Style)}, etc.).
 * Example usage:
 * <code><pre>
 *   chart.setStyle(
 *     new Style()
 *       .setOption("fontFamily", "serif")
 *   );
 * </pre></code>
 * Note that some convenience methods are provided on this class for setting commonly used
 * CSS options (such as {@link #setColor(String)}, {@link #setFontFamily(String)},
 * {@link #setFontSize(String)}, etc).  But, any arbitrary CSS option can be set by
 * simply using the {@link #setOption(String, Object)} method. E.g., the following two
 * lines are equivalent:
 * <code><pre>
 *   style.setFontFamily("serif");
 *   style.setOption("fontFamily", "serif");
 * </pre></code>
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.0.0
 */
public class Style extends Configurable<Style> {

    /**
     * Convenience method for setting the "bottom" CSS style option.  Equivalent to:
     * <pre><code>
     *     chart.setOption("bottom", "10px");
     * </code></pre>
     *
     * @param bottom The value to use for the CSS style option.
     * @return A reference to this {@link Style} instance for convenient method chaining.
     */
    public Style setBottom(String bottom) {
        return this.setOption("bottom", bottom);
    }

    /**
     * Convenience method for setting the "color" CSS style option.  Equivalent to:
     * <pre><code>
     *     chart.setOption("color", "#FF0000");
     * </code></pre>
     *
     * @param color The value to use for the CSS style option.
     * @return A reference to this {@link Style} instance for convenient method chaining.
     */
    public Style setColor(String color) {
        return this.setOption("color", color);
    }

    /**
     * Convenience method for setting the "cursor" CSS style option.  Equivalent to:
     * <pre><code>
     *     chart.setOption("cursor", "pointer");
     * </code></pre>
     *
     * @param cursor The value to use for the CSS style option.
     * @return A reference to this {@link Style} instance for convenient method chaining.
     */
    public Style setCursor(String cursor) {
        return this.setOption("cursor", cursor);
    }

    /**
     * Convenience method for setting the "font" CSS style option.  Equivalent to:
     * <pre><code>
     *     chart.setOption("font", "normal 13px Verdana, sans-serif");
     * </code></pre>
     *
     * @param font The value to use for the CSS style option.
     * @return A reference to this {@link Style} instance for convenient method chaining.
     */
    public Style setFont(String font) {
        return this.setOption("font", font);
    }

    /**
     * Convenience method for setting the "fontFamily" CSS style option.  Equivalent to:
     * <pre><code>
     *     chart.setOption("fontFamily", "serif");
     * </code></pre>
     *
     * @param fontFamily The value to use for the CSS style option.
     * @return A reference to this {@link Style} instance for convenient method chaining.
     */
    public Style setFontFamily(String fontFamily) {
        return this.setOption("fontFamily", fontFamily);
    }

    /**
     * Convenience method for setting the "fontSize" CSS style option.  Equivalent to:
     * <pre><code>
     *     chart.setOption("fontSize", "16px");
     * </code></pre>
     *
     * @param fontSize The value to use for the CSS style option.
     * @return A reference to this {@link Style} instance for convenient method chaining.
     */
    public Style setFontSize(String fontSize) {
        return this.setOption("fontSize", fontSize);
    }

    /**
     * Convenience method for setting the "fontStyle" CSS style option.  Equivalent to:
     * <pre><code>
     *     chart.setOption("fontStyle", "italic");
     * </code></pre>
     *
     * @param fontStyle The value to use for the CSS style option.
     * @return A reference to this {@link Style} instance for convenient method chaining.
     */
    public Style setFontStyle(String fontStyle) {
        return this.setOption("fontStyle", fontStyle);
    }

    /**
     * Convenience method for setting the "fontWeight" CSS style option.  Equivalent to:
     * <pre><code>
     *     chart.setOption("fontWeight", "bold");
     * </code></pre>
     *
     * @param fontWeight The value to use for the CSS style option.
     * @return A reference to this {@link Style} instance for convenient method chaining.
     */
    public Style setFontWeight(String fontWeight) {
        return this.setOption("fontWeight", fontWeight);
    }

    /**
     * Convenience method for setting the "left" CSS style option.  Equivalent to:
     * <pre><code>
     *     chart.setOption("left", "10px");
     * </code></pre>
     *
     * @param left The value to use for the CSS style option.
     * @return A reference to this {@link Style} instance for convenient method chaining.
     */
    public Style setLeft(String left) {
        return this.setOption("left", left);
    }

    /**
     * Convenience method for setting the "margin" CSS style option.  Equivalent to:
     * <pre><code>
     *     chart.setOption("margin", "0px");
     * </code></pre>
     *
     * @param margin The value to use for the CSS style option.
     * @return A reference to this {@link Style} instance for convenient method chaining.
     */
    public Style setMargin(String margin) {
        return this.setOption("margin", margin);
    }

    /**
     * Convenience method for setting the "position" CSS style option.  Equivalent to:
     * <pre><code>
     *     chart.setOption("position", "absolute");
     * </code></pre>
     *
     * @param position The value to use for the CSS style option.
     * @return A reference to this {@link Style} instance for convenient method chaining.
     */
    public Style setPosition(String position) {
        return this.setOption("position", position);
    }

    /**
     * Convenience method for setting the "right" CSS style option.  Equivalent to:
     * <pre><code>
     *     chart.setOption("right", "10px");
     * </code></pre>
     *
     * @param right The value to use for the CSS style option.
     * @return A reference to this {@link Style} instance for convenient method chaining.
     */
    public Style setRight(String right) {
        return this.setOption("right", right);
    }

    /**
     * Convenience method for setting the "top" CSS style option.  Equivalent to:
     * <pre><code>
     *     chart.setOption("top", "10px");
     * </code></pre>
     *
     * @param top The value to use for the CSS style option.
     * @return A reference to this {@link Style} instance for convenient method chaining.
     */
    public Style setTop(String top) {
        return this.setOption("top", top);
    }

}
