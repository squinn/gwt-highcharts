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

/**
 * A common base class for {@link GaugePlotOptions} and {@link SolidGaugePlotOptions} to prevent code duplication
 * while still maintaining a cleaner way for the user to utilize the method chaining with the generics in place.
 * You should not use this class directly, but instead us one of the base classes.
 *
 * @author cskowron@moxiegroup.com (Cory Skowronek)
 * @since 1.7.0
 */
public abstract class BaseGaugePlotOptions<T extends BaseGaugePlotOptions> extends PlotOptions<T> {
    /**
     * Convenience method for setting the "overshoot" option for gauge charts.  Equivalent to:
     * <pre><code>
     *     gaugePlotOptions.setOption("overshoot,
     * </code></pre>
     * @param overshoot
     * @return
     */
    public T setOvershoot(Number overshoot) {
        return this.setOption("overshoot", overshoot);
    }

    /**
     * Convenience method for setting the "wrap" option for gauge charts.  Equivalent to:
     * <pre><code>
     *     gaugePlotOptions.setOption("wrap", false)
     * </code></pre>
     * When this option is true, the dial will wrap around the axes.
     * For instance, in a full-range gauge going from 0 to 360, a value of 400 will point to 40.
     * When wrap is false, the dial stops at 360. Defaults to true
     * @param wrap Whether the dial will wrap around its maximum value.
     * @return A reference to this {@link GaugePlotOptions} for convenient method chaining.
     */
    public T setWrap(Boolean wrap) {
        return this.setOption("wrap", wrap);
    }
}
