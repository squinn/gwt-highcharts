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
 * A configurable class that will allow you to control the export button options of the chart.
 * This configuration object holds general options for the menu items. An instance of this class can be
 * constructed and then set on the pane via the {@link Pane#setBackground(PaneBackground...)} method.
 * <p/>
 * Sample usage:
 * <pre><code>
 *    chart.setExporting(
 *       new Exporting()
 *          .setContextButton(
 *              newContextButton(
 *                  .setAlign("center")
 *                  .setX(0)
 *              )
 *     );
 * </code></pre>
 * @author cskowron@moxiegroup.com (Cory Skowronek)
 * @since 1.6.0
 *
 */
public class ContextButton extends Button<ContextButton> {

    /**
     * An enumeration of supported marker symbol types, which can be passed to methods
     * like {@link ContextButton#setSymbol(ContextButton.Symbol)} method.
     * <p/>Note that custom marker images are also supported by simply setting the
     * "symbol" option to a URL reference.  E.g.
     * <pre><code>
     *    marker.setOption("symbol", "url(/serverpath/image.png)");
     * </code></pre>
     */
    public enum Symbol {

        /**
         * Represent the marker with a circular shape
         */
        CIRCLE("circle"),

        /**
         * Represent the marker with a square shape
         */
        SQUARE("square"),

        /**
         * Represent the marker with a diamond shape
         */
        DIAMOND("diamond"),

        /**
         * Represent the marker with a triangular shape
         */
        TRIANGLE("triangle"),

        /**
         * Represent the marker with an upside down triangular shape
         */
        TRIANGLE_DOWN("triangle-down");

        private Symbol(String optionValue) {
            this.optionValue = optionValue;
        }

        private final String optionValue;

        public String toString() {
            return optionValue;
        }

    }

    // TODO: Implement setMenuItems()

    /**
     * Convenience method for setting the "symbol" option for the export button.  Equivalent to:
     * <pre><code>
     *     contextButton.setOption("symbol", "menu");
     * </code></pre>
     * The symbol for the button. Points to a definition function in the Highcharts.Renderer.symbols collection.
     * The default exportIcon function is part of the exporting module. Defaults to menu.
     * @param symbol The shape to be used for the context button.
     * @return A reference to this {@link ContextButton} instance for convenient method chaining.
     */
    public ContextButton setSymbol(Symbol symbol) {
        return this.setOption("symbol", symbol != null ? symbol.toString() : null);
    }

    /**
     * Convenience method for setting the "symbolX" option for the export button.  Equivalent to:
     * <pre><code>
     *     contextButton.setOption("symbolX", 12.5)
     * </code></pre>
     * The x position of the center of the symbol inside the button. Defaults to 12.5.
     * @param x The distance n pixels from the left edge of the export button
     * @return A reference to this {@link ContextButton} instance for convenient method chaining.
     */
    public ContextButton setX(Number x) {
        return this.setOption("x", x);
    }

}
