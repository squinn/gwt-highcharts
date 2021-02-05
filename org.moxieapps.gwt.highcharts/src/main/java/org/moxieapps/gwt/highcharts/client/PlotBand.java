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

import com.google.gwt.dom.client.Document;
import org.moxieapps.gwt.highcharts.client.labels.PlotBandLabel;

/**
 * A configurable class that can be used to represent plot bands across an area of the chart, which can
 * then be set on an axis (via the {@link Axis#setPlotBands(PlotBand...)} method.)
 * Note that a plot band is a colored band stretching across the plot area marking an interval on the axis.
 * Example usage:
 * <code><pre>
 *   XAxis xAxis = chart.getXAxis();
 *   xAxis.setPlotBands(
 *     xAxis.createPlotBand()
 *        .setColor("#CC0000")
 *        .setFrom(40)
 *        .setTo(80),
 *     xAxis.createPlotBand()
 *        .setColor("#00CC00")
 *        .setFrom(80)
 *        .setTo(120),
 *   );
 * </pre></code>
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.0.0
 */
public class PlotBand extends Configurable<PlotBand> {

    private Axis axis;
    private String id;

    /**
     * Use the {@link Axis#createPlotBand()} method to create new plot bands
     *
     * @param axis The axis instance that this plot band is being created within.
     */
    PlotBand(Axis axis) {
        this.axis = axis;
        id = Document.get().createUniqueId();
        setOption("id", id);
    }

    /**
     * Convenience method for setting the 'color' option of the plot band to an RGB hex value.  Equivalent to:
     * <pre><code>
     *     plotBand.setOption("color", "#CCCCCC");
     * </code></pre>
     * The RGB color for the plot band. Defaults to null.
     * <p/>
     * Note that this method is intended for setting the color to a simple RBG hex value.  If you instead
     * want to set a color to include an alpha channel or a gradient, use the {@link #setColor(Color)}
     * version instead.
     *
     * @param color The value to set as the 'color' option on the plot band.
     * @return A reference to this {@link PlotBand} instance for convenient method chaining.
     */
    public PlotBand setColor(String color) {
        return this.setOption("color", color);
    }

    /**
     * Convenience method for setting the 'color' option of the plot band, allowing for
     * colors with opacity or gradients.  Equivalent to:
     * <pre><code>
     *     plotBand.setOption("color", new Color()
     *        .setLinearGradient(0.0, 0.0, 1.0, 1.0)
     *        .addStop(new Color(255, 255, 255))
     *        .addStop(new Color(200, 200, 255))
     *     );
     * </code></pre>
     * The color or gradient for the plot band. Defaults to null.
     * <p/>
     * Note that this method is intended for setting the color to a gradient or color that includes
     * an alpha channel.  If you instead just want to set the color to a normal RGB hex value
     * you can use the {@link #setColor(String)} version instead.
     *
     * @param color The color gradient or color with an alpha channel to set as the 'color' option on the plot band.
     * @return A reference to this {@link PlotBand} instance for convenient method chaining.
     */
    public PlotBand setColor(Color color) {
        return this.setOption("color", color != null ? color.getOptionValue() : null);
    }

    // TODO: Add events

    /**
     * Convenience method for setting the 'from' option of the plot band.  Equivalent to:
     * <pre><code>
     *     plotBand.setOption("from", 40);
     * </code></pre>
     * The start position of the plot band in axis units. Defaults to null.
     *
     * @param from The start position of the plot band in axis units.
     * @return A reference to this {@link PlotBand} instance for convenient method chaining.
     */
    public PlotBand setFrom(Number from) {
        return this.setOption("from", from);
    }

    /**
     * Convenience method for setting the 'label' options of the plot band.  Equivalent to:
     * <pre><code>
     *     plotBand.setOption("/label/align", PlotBandLabel.Align.LEFT);
     *     plotBand.setOption("/label/x", 20);
     *     etc....
     * </code></pre>
     *
     * @param plotBandLabel The options for the label on the plot band.
     * @return A reference to this {@link PlotBand} instance for convenient method chaining.
     */
    public PlotBand setLabel(PlotBandLabel plotBandLabel) {
        return this.setOption("label", plotBandLabel != null ? plotBandLabel.getOptions() : null);
    }

    /**
     * Convenience method for setting the 'to' option of the plot band.  Equivalent to:
     * <pre><code>
     *     plotBand.setOption("to", 40);
     * </code></pre>
     * The end position of the plot band in axis units. Defaults to null.
     *
     * @param to The end position of the plot band in axis units.
     * @return A reference to this {@link PlotBand} instance for convenient method chaining.
     */
    public PlotBand setTo(Number to) {
        return this.setOption("to", to);
    }

    /**
     * Convenience method for setting the 'zIndex' option of the plot band.  Equivalent to:
     * <pre><code>
     *     plotBand.setOption("zIndex", 100);
     * </code></pre>
     * The z index of the plot band within the chart. Defaults to null.
     *
     * @param zIndex The z index of the plot band within the chart.
     * @return A reference to this {@link PlotBand} instance for convenient method chaining.
     */
    public PlotBand setZIndex(Number zIndex) {
        return this.setOption("zIndex", zIndex);
    }

    /**
     * Internal method used to retrieve the unique id generated for this plot band.
     *
     * @return The unique id of this plot band
     * @since 1.1.3
     */
    String getId() {
        return id;
    }

}
