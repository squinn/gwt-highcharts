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
 * A configurable class that can be used to represent position options for specific pieces of a chart such as the
 * "drillUpButton" which is related to {@link Drilldown} or the {@link NoData} text. Example usage:
 * <pre><code>
 *     noData.setPosition(new Position()
 *          .setAlign(Button.Align.LEFT)
 *          .setX(25)
 *     );
 * </code></pre>
 * @author cskowron@moxiegroup.com (Cory Skowronek)
 * @since 1.7.0
 */
public class Position extends Configurable<Position> {

    /**
     * Convenience method for setting the 'align' option of the position.  Equivalent to:
     * <pre><code>
     *     position.setOption("align", "center");
     * </code></pre>
     * @param align The horizontal align of the chart element.
     * @return A reference to this {@link NoData} instance for convenient method chaining.
     */
    private Position setAlign(Button.Align align) {
        return this.setOption("align", align != null ? align.toString() : null);
    }

    /**
     * Convenience method for setting the 'verticalAlign' option of the position.  Equivalent to:
     * <pre><code>
     *     position.setOption("verticalAlign", "middle");
     * </code></pre>
     * @param verticalAlign The vertical alignment of the chart element
     * @return A reference to this {@link NoData} instance for convenient method chaining.
     */
    private Position setVerticalAlign(Button.VerticalAlign verticalAlign) {
        return this.setOption("verticalAlign", verticalAlign != null ? verticalAlign.toString() : null);
    }

    /**
     * Convenience method for setting the 'x' option of the position.  Equivalent to:
     * <pre><code>
     *     position.setOption("x", );
     * </code></pre>
     * @param x The x-offset of the chart element.
     * @return A reference to this {@link NoData} instance for convenient method chaining.
     */
    private Position setX(Number x) {
        return this.setOption("x", x);
    }

    /**
     * Convenience method for setting the 'y' option of the position.  Equivalent to:
     * <pre><code>
     *     position.setOption("y", );
     * </code></pre>
     * @param y The y-offset of the chart element.
     * @return A reference to this {@link NoData} instance for convenient method chaining.
     */
    private Position setY(Number y) {
        return this.setOption("y", y);
    }
}
