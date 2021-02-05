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
 * Configurable class which allows one to control the various options for export buttons.
 * <pre><code>
 *    chart.setExporting(
 *      new Exporting()
 *          .setContextButton(
 *              newContextButton(
 *                  .setAlign("center")
 *                  .setVerticalAlign("middle")
 *              )
 *     );
 * </code></pre>
 * @author cskowron@moxiegroup.com (Cory Skowronek)
 * @since 1.6.0
 */
public class Button<T extends Button> extends Configurable<T> {

    /**
     * An enumeration of supported credits horizontal alignment types, which can be passed to methods
     * like {@link Credits#setAlign(Credits.Align)} method.
     */
    public enum Align {

        /**
         * Left align the credits
         */
        LEFT("left"),

        /**
         * Center the credits
         */
        CENTER("center"),

        /**
         * Right align the credits
         */
        RIGHT("right");

        private Align(String optionValue) {
            this.optionValue = optionValue;
        }

        private final String optionValue;

        public String toString() {
            return optionValue;
        }

    }

    /**
     * An enumeration of supported credits vertical alignment types, which can be passed to methods
     * like {@link Credits#setVerticalAlign(Credits.VerticalAlign)} method.
     */
    public enum VerticalAlign {

        /**
         * Show the credits at the top of the chart
         */
        TOP("top"),

        /**
         * Show the credits in the middle of the chart
         */
        MIDDLE("middle"),

        /**
         * Show the credits at the bottom of the chart
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
     * Convenience method for setting the 'align' option for the Button module.  Equivalent to:
     * <pre><code>
     *    button.setOption("align", right)
     * </code></pre>
     * The Horizontal alignment for the buttons. Can be one of "left," "center," or "right." Defaults to right
     * @param align The horizontal position of the export button
     * @return A reference to this {@link Button} instance for convenient method chaining.
     */
    public Button setAlign(Align align) {
        return this.setOption("align", align != null ? align.toString() : null);
    }

    /**
     * Convenience method for setting the 'enabled' option for the Button module.  Equivalent to:
     * <pre><code>
     *    button.setOption("enabled", true)
     * </code></pre>
     * Whether to enable buttons. Defaults to true.
     * @param enabled 'true' to enable the export button.
     * @return A reference to this {@link Button} instance for convenient method chaining.
     */
    public Button setEnabled(Boolean enabled) {
        return this.setOption("enabled", enabled);
    }

    /**
     * Convenience method for setting the 'height' option for the Button module.  Equivalent to:
     * <pre><code>
     *    button.setOption("height", 20)
     * </code></pre>
     * Pixel height of the buttons. Defaults to 20.
     * @param height The height in pixels of the export button.
     * @return A reference to this {@link Button} instance for convenient method chaining.
     */
    public Button setHeight(Number height) {
        return this.setOption("height", height);
    }

    /**
     * Convenience method for setting the 'symbolFill' option for the Button module.  Equivalent to:
     * <pre><code>
     *    button.setOption("symbolFill", "#E0E0E0")
     * </code></pre>
     * Fill color for the symbol within the button. Defaults to #E0E0E0
     * @param symbolFill The color with which to fill the export button.
     * @return A reference to this {@link Button} instance for convenient method chaining.
     */
    public Button setSymbolFill(String symbolFill) {
        return this.setOption("symbolFill", symbolFill);
    }

    /**
     * Convenience method for setting the 'symbolSize' option for the Button module.  Equivalent to:
     * <pre><code>
     *    button.setOption("symbolSize", 14)
     * </code></pre>
     * The pixel size of the symbol on the button. Defaults to 14.
     * @param symbolSize The size in pixels of the export button symbol.
     * @return A reference to this {@link Button} instance for convenient method chaining.
     */
    public Button setSymbolSize(Number symbolSize) {
        return this.setOption("symbolSize", symbolSize);
    }

    /**
     * Convenience method for setting the 'symbolStroke' option for the Button module.  Equivalent to:
     * <pre><code>
     *    button.setOption("symbolStroke", "#666")
     * </code></pre>
     * The color of the symbol's stroke or line. Defaults to #666
     * @param symbolStroke The color of the export button's lines.
     * @return A reference to this {@link Button} instance for convenient method chaining.
     */
    public Button setSymbolStroke(String symbolStroke) {
        return this.setOption("symbolStroke", symbolStroke);
    }

    /**
     * Convenience method for setting the 'symbolStrokeWidth' option for the Button module.  Equivalent to:
     * <pre><code>
     *    button.setOption("symbolStrokeWidth", 1)
     * </code></pre>
     * The pixel stroke width of the symbol on the button. Defaults to 1.
     * @param symbolStrokeWidth  The width in pixels of the lines on the export button.
     * @return A reference to this {@link Button} instance for convenient method chaining.
     */
    public Button setSymbolStrokeWidth(Number symbolStrokeWidth) {
        return this.setOption("symbolStrokeWidth", symbolStrokeWidth);
    }

    /**
     * Convenience method for setting the 'symbolX' option for the Button module.  Equivalent to:
     * <pre><code>
     *    button.setOption("symbolX", 12.5)
     * </code></pre>
     * The x position of the center of the symbol inside the button. Defaults to 12.5.
     * @param symbolX The distance in pixels of the export button from the left edge of the button.
     * @return A reference to this {@link Button} instance for convenient method chaining.
     */
    public Button setSymbolX(Number symbolX) {
        return this.setOption("symbolX", symbolX);
    }

    /**
     * Convenience method for setting the 'symbolY' option for the Button module.  Equivalent to:
     * <pre><code>
     *    button.setOption("symbolY", 10.5)
     * </code></pre>
     * The y position of the center of the symbol inside the button. Defaults to 10.5.
     * @param symbolY The distance in pixels of the export button symbol from the top edge of the button.
     * @return A reference to this {@link Button} instance for convenient method chaining.
     */
    public Button setSymbolY(Number symbolY) {
        return this.setOption("symbolY", symbolY);
    }

    /**
     * Convenience method for setting the 'text' option for the Button module.  Equivalent to:
     * <pre><code>
     *    button.setOption("text", null)
     * </code></pre>
     * A text string to add to the individual button. Defaults to null
     * @param text The text to display with the export button.
     * @return A reference to this {@link Button} instance for convenient method chaining.
     */
    public Button setText(String text) {
        return this.setOption("text", text);
    }

    /**
     * Convenience method for setting the 'verticalAlign' option for the Button module.  Equivalent to:
     * <pre><code>
     *    button.setOption("verticalAlign", "top")
     * </code></pre>
     * The vertical alignment of the buttons. Can be one of "top", "middle" or "bottom". Defaults to top.
     * @param verticalAlign The vertical position of the export button.
     * @return A reference to this {@link Button} instance for convenient method chaining.
     */
    public Button setVerticalAlign(VerticalAlign verticalAlign) {
        return this.setOption("verticalAlign", verticalAlign != null ? verticalAlign.toString() : null);
    }

    /**
     * Convenience method for setting the 'width' option for the Button module.  Equivalent to:
     * <pre><code>
     *    button.setOption("width", 24)
     * </code></pre>
     * The pixel width of the button. Defaults to 24.
     * @param width The width in pixels of the export button.
     * @return A reference to this {@link Button} instance for convenient method chaining.
     */
    public Button setWidth(Number width) {
        return this.setOption("width", width);
    }

    /**
     * Convenience method for setting the 'y' option for the Button module.  Equivalent to:
     * <pre><code>
     *    button.setOption("y", 0)
     * </code></pre>
     * The vertical offset of the button's position relative to its verticalAlign. . Defaults to 0.
     * @param y The number of pixels to offset the export button from the bottom of the chart.
     * @return A reference to this {@link Button} instance for convenient method chaining.
     */
    public Button setY(Number y) {
        return this.setOption("y", y);
    }
}

