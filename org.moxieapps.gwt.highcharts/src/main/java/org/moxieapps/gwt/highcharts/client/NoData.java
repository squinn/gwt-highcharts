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
 * A set of options for setting the "noData" portion of the chart which represents options for displaying
 * a message like "No data to display".  This feature requires the file no-data-to-display.js to be loaded in the page.
 * The actual text to display is set in {@link Lang#setNoData(String)}
 * @since 1.7.0
 * @author cskowron@moxiegroup.com (Cory Skowronek)
 * @see Lang#setNoData(String)
 */
public class NoData extends Configurable<NoData> {
    /**
     * Convenience method for setting the 'position' option of the noData.  Equivalent to:
     * <pre><code>
     *     noData.setOption("position", new position());
     * </code></pre>
     * The position of the no-data label, relative to the plot area.
     * Defaults to { "x": 0, "y": 0, "align": "center", "verticalAlign": "middle" }.
     * @param position The position of the "noData' label
     * @return A reference to this {@link NoData} instance for convenient method chaining.
     */
    public NoData setPosition(Position position) {
        return this.setOption("position", position != null ? position.getOptions() : null);
    }

    /**
     * Convenience method for setting the 'style' option of the noData message.  Equivalent to:
     * <pre><code>
     *     noData.setOption("style", "fontSize": "12px");
     * </code></pre>
     *  CSS styles for the no-data label. Defaults to { "fontSize": "12px", "fontWeight": "bold", "color": "#60606a" }.
     * @param style CSS styles for the noData message.
     * @return A reference to this {@link NoData} instance for convenient method chaining.
            */
    public NoData setStyle(Style style) {
        return this.setOption("style", style!= null ? style.getOptions() : null);
    }

}
