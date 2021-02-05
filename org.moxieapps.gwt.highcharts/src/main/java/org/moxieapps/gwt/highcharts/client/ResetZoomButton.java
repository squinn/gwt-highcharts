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
 * A configurable class that will allow you to control the reset zoom button options of the chart.
 * This configuration object holds general options for the position and theme of the button. An instance of this class can be
 * constructed and then set on the pane via the {@link Chart#setResetZoomButton(ResetZoomButton)} method.
 * <p/>
 * Note: The setTheme method is not yet implemented, however, the options can still be set using {@link Chart#setOption(String, Object)}
 * Although undocumented in Highcharts API, the reset zoom button also appears to accept options similar to the export button, such as 'align.'
 * Sample usage:
 * <pre><code>
 *    chart.setResetZoomButton(
 *       new ResetZoomButton()
 *          .setRelativeTo("plot")
 *          .setOption("align", "right")
 *          .setOption("/theme/fill", "white")
 *          .setOption("/theme/states/hover/style/color", "white")
 *     );
 * </code></pre>
 * @author cskowron@moxiegroup.com (Cory Skowronek)
 * @since 1.6.0
 *
 */
public class ResetZoomButton extends Configurable<ResetZoomButton> {

    /**
     * An enumeration of the supported frames that the reset zoom button's position can be relative to.
     * {@link #setRelativeTo(RelativeTo)}
     */
    public enum RelativeTo {

        /**
         * Relative to the plot.
         */
        PLOT("plot"),

        /**
         * Relative to the chart.
         */
        CHART("chart");

        private RelativeTo(String optionValue) {
            this.optionValue = optionValue;
        }

        private final String optionValue;

        public String toString() {
            return optionValue;
        }
    }

    /**
     * Convenience method for setting the 'x' position of the reset zoom button.  Equivalent to:
     * <pre><code>
     *     chart.setOption("resetZoomButton/position/x", -10);
     * </code></pre>
     * @param x the 'x' position of the resetZoomButton relative to {@link #setRelativeTo(RelativeTo)}
     * @return A reference to this {@link ResetZoomButton} instance for convenient method chaining.
     */
    public ResetZoomButton setPositionX(Number x) {
        return this.setOption("/position/x", x);
    }

    /**
     * Convenience method for setting the 'y' position of the reset zoom button.  Equivalent to:
     * <pre><code>
     *     chart.setOption("resetZoomButton/position/y", 10);
     * </code></pre>
     * @param y the 'y' position of the resetZoomButton relative to {@link #setRelativeTo(RelativeTo)}
     * @return A reference to this {@link ResetZoomButton} instance for convenient method chaining.
     */
    public ResetZoomButton setPositionY(Number y) {
        return this.setOption("/position/y", y);
    }

    /**
     * Convenience method for setting the frame that the reset zoom button's position is relative to.  Equivalent to:
     * <pre><code>
     *     resetZoomButton.setOption("relativeTo", "chart");
     * </code></pre>
     * What frame the button should be placed related to. Can be either "plot" or "chart". Defaults to "plot".
     * @param relativeTo The frame that the button's position is relative to.
     * @return A reference to this {@link ResetZoomButton} instance for convenient method chaining.
     */
    public ResetZoomButton setRelativeTo(RelativeTo relativeTo) {
        return this.setOption("relativeTo", relativeTo != null ? relativeTo.toString() : null);
    }

    //TODO Implement setTheme
}
