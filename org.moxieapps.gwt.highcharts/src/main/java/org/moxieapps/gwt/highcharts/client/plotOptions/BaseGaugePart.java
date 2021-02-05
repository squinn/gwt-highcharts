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

package org.moxieapps.gwt.highcharts.client.plotOptions;

import org.moxieapps.gwt.highcharts.client.Color;
import org.moxieapps.gwt.highcharts.client.Configurable;

/**
 * A common base class for both {@link Dial} and {@link Pivot} to prevent code duplication
 * while still maintaining a cleaner way for the user to utilize the method chaining with the generics
 * in place.  You should not use this class directly, but instead use one of the base classes.
 *
 * @author cskowron@moxiegroup.com (Cory Skowronek)
 * @since 1.6.0
 */
public abstract class BaseGaugePart<T extends BaseGaugePart> extends Configurable<T> {

    /**
     * Convenience method for setting the "backgroundColor" option for a gauge's pivot. Equivalent to:
     * <pre><code>
     *     pivotOptions.setOption("backgroundColor", #CCCCCC)
     * </code></pre>
     * The background or fill color of the gauge's pivot. Defaults to black.
     * <p/>
     * Note that this method is intended for setting the color to a simple RBG hex value.  If you instead
     * want to set a color to include an alpha channel or a gradient, use the {@link #setBackgroundColor(org.moxieapps.gwt.highcharts.client.Color)}
     * version instead.
     * @param backgroundColor The value to set as the 'backgroundColor' option of the box plots.
     * @return A reference to this {@link BaseGaugePart} for convenient method chaining.
     */
    public T setBackgroundColor(String backgroundColor) {
        return this.setOption("backgroundColor", backgroundColor);
    }

    /**
     * Convenience method for setting the "backgroundColor" option for a gauge's pivot. Equivalent to:
     * <pre><code>
     *     pivotOptions.setOption("fillColor", new Color()
     *        .setLinearGradient(0.0, 0.0, 1.0, 1.0)
     *        .addStop(new Color(255, 255, 255))
     *        .addStop(new Color(200, 200, 255))
     *     );
     * </code></pre>
     * The background or fill color of the gauge's pivot. Defaults to black.
     * <p/>
     * Note that this method is intended for setting the color to a gradient or color that includes
     * an alpha channel.  If you instead just want to set the color to a normal RGB hex value
     * you can use the {@link #setBackgroundColor(String)} version instead.
     * @param backgroundColor The color gradient or color with an alpha channel to set as the 'backgroundColor' option of the box plot.
     * @return A reference to this {@link BaseGaugePart} for convenient method chaining
     */
    public T setBackgroundColor(Color backgroundColor) {
        return this.setOption("backgroundColor", backgroundColor != null ? backgroundColor.getOptionValue() : null);
    }

    /**
     * Convenience method for setting the "borderColor" option for a gauge's pivot. Equivalent to:
     * <pre><code>
     *     pivotOptions.setOption("borderColor", #CCCCCC);
     * </code></pre>
     * The border color or stroke of the gauge's pivot. By default, the borderWidth is 0, so this must be set in addition to a custom border color. Defaults to silver.
     * <p/>
     * Note that this method is intended for setting the color to a simple RBG hex value.  If you instead
     * want to set a color to include an alpha channel or a gradient, use the {@link #setBorderColor(Color)}
     * version instead.
     * @param borderColor The value to set as the 'borderColor' option of the box plots.
     * @return A reference to this {@link BaseGaugePart} for convenient method chaining
     */
    public T setBorderColor(String borderColor) {
        return this.setOption("borderColor", borderColor);
    }

    /**
     * Convenience method for setting the "borderColor" option for a gauge's pivot. Equivalent to:
     * <pre><code>
     *     pivotOptions.setOption("fillColor", new Color()
     *        .setLinearGradient(0.0, 0.0, 1.0, 1.0)
     *        .addStop(new Color(255, 255, 255))
     *        .addStop(new Color(200, 200, 255))
     *     );
     * </code></pre>
     * The border color or stroke of the gauge's pivot. By default, the borderWidth is 0,
     * so this must be set in addition to a custom border color. Defaults to silver.
     * <p/>
     * Note that this method is intended for setting the color to a gradient or color that includes
     * an alpha channel.  If you instead just want to set the color to a normal RGB hex value
     * you can use the {@link #setBorderColor(String)} version instead.
     * @param borderColor The color gradient or color with an alpha channel to set as the 'borderColor' option of the box plot.
     * @return A reference to this {@link BaseGaugePart} for convenient method chaining
     */
    public T setBorderColor(Color borderColor) {
        return this.setOption("borderColor", borderColor != null ? borderColor.getOptionValue() : null);
    }

    /**
     * Convenience method for setting the "borderWidth" option for a gauge's pivot. Equivalent to:
     * <pre><code>
     *     pivotOptions.setOption("borderWidth", 5);
     * </code></pre>
     * The width of the gauge pivot border in pixels. Defaults to 0.
     * @param borderWidth The width of the gauge pivot border in pixels.
     * @return A reference to this {@link BaseGaugePart} for convenient method chaining
     */
    public T setBorderWidth(Number borderWidth) {
        return this.setOption("borderWidth", borderWidth);
    }

    /**
     * Convenience method for setting the "radius" option for a gauge's pivot. Equivalent to:
     * <pre><code>
     *     pivotOptions.setOption("radius", "50%");
     * </code></pre>
     * The radius or length of the pivot, in percentages relative to the radius of the gauge itself. Defaults to 80%.
     * @param radius The radius of the pivot as a percentage of the radius of the gauge itself.
     * @return A reference to this {@link BaseGaugePart} for convenient method chaining
     */
    public T setRadius(String radius) {
        return this.setOption("radius", radius);
    }
}
