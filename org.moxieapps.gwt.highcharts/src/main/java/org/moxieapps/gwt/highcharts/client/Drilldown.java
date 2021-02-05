/*
 * Copyright 2015 Moxie Group
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

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;

/**
 * A configurable class that can be used to drill down into a series or point, the concept of inspecting
 * increasingly high resolution data through clicking on chart items like columns or pie slices.
 * Sample Usage:
 * <pre><code>
 *      Series animalSeries = chart.createSeries()
 *          .setPoints(new Point[] {
 *              new Point("Cats", 4),
 *              new Point("Dogs", 2),
 *              new Point("Cows", 2),
 *              new Point("Sheep", 2)
 *              new Point("Pigs", 1)
 *          });
 *
 *      Series fruitSeries = chart.createSeries()
 *          .setPoints(new Point[] {
 *              new Point("Apples", 4),
 *              new Point("Oranges", 2)
 *          });
 *
 *      Series carSeries = chart.createSeries()
 *          .setPoints(new Point[] {
 *              new Point("Toyota", 4),
 *              new Point("Opel", 2),
 *              new Point("Volkswagen", 2)
 *          });
 *
 *      chart.setDrilldown(new Drilldown()
 *          .setSeries(animalSeries, fruitSeries, carSeries)
 *      );
 * </code></pre>
 * The previously created series can be set to be displayed when a specific point is clicked via the
 * {@link Point#setDrilldownSeries(Series)} method as follows:
 * <pre><code>
 *     chart.addSeries(chart.createSeries()
 *          .setName("Random Series")
 *          .setPoints(new Point[]{
 *              new Point("Animals", 5)
 *                  .setDrilldown(animalSeries)
 *          })
 *     );
 * </code></pre>
 * Note that the drilldown feature requires the drilldown.js file to be loaded, found in the modules directory
 * of the download package, or online at code.highcharts.com/modules/drilldown.js.
 */
public class Drilldown extends Configurable<Drilldown> {

    Chart chart = new Chart();

    /**
     * Convenience method for setting the 'activeAxisLabelStyle' option of the drilldown.  Equivalent to:
     * <pre><code>
     *     drilldown.setOption("activeAxisLabelStyle", new Style());
     * </code></pre>
     * Additional styles to apply to the X axis label for a point that has drilldown data. By default it is underlined
     * and blue to invite to interaction. Defaults to:
     * <pre><code>
     *      activeAxisLabelStyle: {
     *          cursor: 'pointer',
     *          color: '#0d233a',
     *          fontWeight: 'bold',
     *          textDecoration: 'underline'
     *      }
     * </code></pre>
     *
     * @param activeAxisLabelStyle The style to apply to the axis label
     * @return A reference to this {@link Drilldown} instance for convenient method chaining.
     */
    public Drilldown setActiveAxisLabelStyle(Style activeAxisLabelStyle) {
        return this.setOption("activeAxisLabelStyle", activeAxisLabelStyle != null ? activeAxisLabelStyle.getOptions() : null);
    }

    /**
     * Convenience method for setting the 'activeDataLabelStyle' option of the drilldown.  Equivalent to:
     * <pre><code>
     *     drilldown.setOption("activeDataLabelStyle", new Style());
     * </code></pre>
     * Additional styles to apply to the data label of a point that has drilldown data. By default it is underlined and
     * blue to invite to interaction. Defaults to:
     * <pre><code>
     *      activeAxisLabelStyle: {
     *          cursor: 'pointer',
     *          color: '#0d233a',
     *          fontWeight: 'bold',
     *          textDecoration: 'underline'
     *      }
     * </code></pre>
     *
     * @param activeDataLabelStyle the style to apply to the active data label.
     * @return A reference to this {@link Drilldown} instance for convenient method chaining.
     */
    public Drilldown setActiveDataLabelStyle(Style activeDataLabelStyle) {
        return this.setOption("activeDataLabelStyle", activeDataLabelStyle != null ? activeDataLabelStyle.getOptions() : null);
    }

    /**
     * Convenience method for setting the 'animation' option of the drilldown.  Equivalent to:
     * <pre><code>
     *     drilldown.setOption("animation", false);
     * </code></pre>
     * Set the animation for all drilldown animations. Animation of a drilldown occurs when drilling between a column
     * point and a column series, or a pie slice and a full pie series. Drilldown can still be used between series
     * and points of different types, but animation will not occur.
     * <p/>
     * Note that this method is intended for setting the animation to a boolean value.  If true, it will use the
     * 'swing' jQuery easing and a duration of 500 ms.
     * If you want to set the animation to a configuration object, use the {@link Drilldown#setAnimation(Animation)}
     * version instead.
     * @param animation 'true' to enable animation for drilldowns
     * @return A reference to this {@link Drilldown} instance for convenient method chaining.
     */
    public Drilldown setAnimation(Boolean animation) {
        return this.setOption("animation", animation);
    }

    /**
     * Convenience method for setting the 'animation' option of the drilldown.  Equivalent to:
     * <pre><code>
     *     drilldown.setOption("animation", false);
     * </code></pre>
     * Set the animation for all drilldown animations. Animation of a drilldown occurs when drilling between a column
     * point and a column series, or a pie slice and a full pie series. Drilldown can still be used between series
     * and points of different types, but animation will not occur.
     * <p/>
     * Note that this method is intended for setting the animation to a configuration object. If used as a
     * configuration object, the following properties are supported:
     * <pre>
     * duration
     *      The duration of the animation in milliseconds.
     * easing
     *      When using jQuery as the general framework, the easing can be set to linear or swing. More easing functions
     *      are available with the use of jQuery plug-ins, most notably the jQuery UI suite. See the jQuery docs. When
     *      using MooTools as the general framework, use the property name transition instead of easing.
     * </pre>
     * If you want to set the animation to a boolean value, use the {@link Drilldown#setAnimation(Boolean)} version
     * instead.
     * @param animation The animation options to assign to the drilldown
     * @return A reference to this {@link Drilldown} instance for convenient method chaining.
     */
    public Drilldown setAnimation(Animation animation) {
        return this.setOption("animation", animation != null ? animation.getOptions() : null);
    }

    /**
     * Convenience method for setting the 'buttonPosition' option of the drillUpButton.  Equivalent to:
     * <pre><code>
     *     drilldown.setOption("/drillUpButton/position", new Position());
     * </code></pre>
     * Positioning options for the button within the relativeTo box.  Available properties are x, y, align
     * and verticalAlign.
     * @param buttonPosition A set of options representing the position of the drillUp button
     * @return A reference to this {@link Drilldown} instance for convenient method chaining.
     */
    public Drilldown setDrillUpButtonPosition(Position buttonPosition) {
        return this.setOption("/drillUpButton/position", buttonPosition != null ? buttonPosition.getOptions() : null);
    }

    /**
     * Convenience method for setting the 'relativeTo' option of the drillUpButton.  Equivalent to:
     * <pre><code>
     *     drilldown.setOption("/drillUpButton/relativeTo", "plotBox");
     * </code></pre>
     * What box to align the button to. Can be either "plotBox" or "spacingBox". Defaults to plotBox.
     * @param drillUpButtonRelativeTo The box to which the position of the drillUpButton is relative
     * @return A reference to this {@link Drilldown} instance for convenient method chaining.
     */
    public Drilldown setDrillUpButtonRelativeTo(MapNavigation.AlignTo drillUpButtonRelativeTo) {
        return this.setOption("/drillUpButton/relativeTo", drillUpButtonRelativeTo != null ? drillUpButtonRelativeTo.toString() :null);
    }

    /**
     * Convenience method for setting the 'theme' option of the drillUpButton.  Equivalent to:
     * <pre><code>
     *     drilldown.setOption("/drillUpButton/theme", new Theme());
     * </code></pre>
     * A collection of attributes for the button. The object takes SVG attributes like fill, stroke, stroke-width
     * or r, the border radius. The theme also supports style, a collection of CSS properties for the text.
     * @param drillUpButtonTheme The theme options for the drillUpButton
     * @return A reference to this {@link Drilldown} instance for convenient method chaining.
     */
    public Drilldown setDrillUpButtonTheme(Theme drillUpButtonTheme) {
        return this.setOption("/drillUpButton/theme", drillUpButtonTheme != null ? drillUpButtonTheme.getOptions() : null);
    }

    /**
     * Convenience method for setting the 'series' option of the drilldown.  Equivalent to:
     * <pre><code>
     *     drilldown.setOption("series", new Series());
     * </code></pre>
     *  Each series configuration uses the same syntax as the series option set.
     *  These drilldown series are hidden by default. The drilldown series is linked to the parent series' point by its id.
     * @param series An array of series objects for the drilldown.
     * @return A reference to this {@link Drilldown} instance for convenient method chaining.
     */
    public Drilldown setSeries(Series... series) {
        // TODO: Consider converting to maintain a reference to the series so that it can be changed after render time,
        // instead of converting to an array here
        JSONArray drilldownSeriesArray = new JSONArray();
        int seriesCount = 0;
        for (Series drilldownSeries : series) {
            drilldownSeriesArray.set(seriesCount++, chart.convertSeriesToJSON(drilldownSeries));
        }
        return this.setOption("series", drilldownSeriesArray);
    }

}
