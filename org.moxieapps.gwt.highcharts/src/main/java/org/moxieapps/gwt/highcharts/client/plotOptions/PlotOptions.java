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

package org.moxieapps.gwt.highcharts.client.plotOptions;

import org.moxieapps.gwt.highcharts.client.*;
import org.moxieapps.gwt.highcharts.client.labels.BaseDataLabels;
import org.moxieapps.gwt.highcharts.client.labels.DataLabels;

/**
 * Represents the base class of all PlotOptions types.  This class should not be used directly, but instead
 * use one of the sub types such as {@link AreaPlotOptions}, {@link BarPlotOptions}, etc.  Note that general
 * plot options that should apply to all series can be set using the {@link SeriesPlotOptions}.  Also note
 * that plot options can be overridden on each individual series via the {@link Series#setPlotOptions(PlotOptions)}
 * mechanism.
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.0.0
 */
public abstract class PlotOptions<T extends PlotOptions> extends Configurable<T> {

    /**
     * An enumeration of supported cursor types, which can be passed to the
     * {@link #setCursor(org.moxieapps.gwt.highcharts.client.plotOptions.PlotOptions.Cursor)} method.
     */
    public enum Cursor {

        /**
         * Display no special cursor for this series
         */
        NONE(""),

        /**
         * Display the pointer cursor when the user hovers over this series
         */
        POINTER("pointer");

        private Cursor(String optionValue) {
            this.optionValue = optionValue;
        }

        private final String optionValue;

        public String toString() {
            return optionValue;
        }

    }

    /**
     * An enumeration of supported stacking types, which can be passed to the
     * {@link #setStacking(PlotOptions.Stacking)} method.
     */
    public enum Stacking {

        /**
         * Stack the series by linear value
         */
        NORMAL("normal"),

        /**
         * Stack the series by percent value
         */
        PERCENT("percent");

        private Stacking(String optionValue) {
            this.optionValue = optionValue;
        }

        private final String optionValue;

        public String toString() {
            return optionValue;
        }

    }

    /**
     * An enumeration of the supported placement types, which can be passed to the
     * {@link #setPointPlacement} method.  Possible options are: "on" and "between"
     * @since 1.6.0
     *
     */
    public enum PointPlacement {

        /**
         * In a column chart, when pointPlacement is "on", the point will not create any padding of the X axis.
         * In a polar column chart this means that the first column points directly north
         */
        ON("on"),

        /**
         * In a column chart, the columns will be laid out between ticks.
         */
        BETWEEN("between");

        private PointPlacement(String optionValue) {
            this.optionValue = optionValue;
        }

        private final String optionValue;

        public String toString() {
            return optionValue;
        }
    }


    /**
     * Convenience method for setting the 'allowPointSelect' plot option.  Equivalent to:
     * <pre><code>
     *     plotOptions.setOption("allowPointSelect", true);
     * </code></pre>
     * Allow the series' points to be selected by clicking on the markers, bars or pie slices.
     * Defaults to false.
     *
     * @param allowPointSelect 'true' to allow the series' points to be selected by clicking on the markers.
     * @return A reference to this {@link PlotOptions} instance for convenient method chaining.
     */
    public T setAllowPointSelect(boolean allowPointSelect) {
        return this.setOption("allowPointSelect", allowPointSelect);
    }

    /**
     * Convenience method for setting the 'animation' plot option.  Equivalent to:
     * <pre><code>
     *     plotOptions.setOption("animation", true);
     * </code></pre>
     * Enable or disable the initial animation when a series is displayed.  Note that for more
     * control over the way the series display animations will occurs utils the {@link #setAnimation(org.moxieapps.gwt.highcharts.client.Animation)}
     * method instead.
     *
     * @param animation 'true' to animate series when they are added to the chart
     * @return A reference to this {@link PlotOptions} instance for convenient method chaining.
     */
    public T setAnimation(boolean animation) {
        return this.setOption("animation", animation);
    }

    /**
     * Convenience method for setting the 'animation' plot option, controlling the details
     * of the animation more precisely. Equivalent to:
     * <pre><code>
     * plotOptions.setOption("/animation/duration", 500);
     * plotOptions.setOption("/animation/easing", "linear");
     * </code></pre>
     * Note that this is intended for users that want to have finite control over the way animations
     * behave.  To simply enable/disable animations, you can use the {@link #setAnimation(boolean)}
     * method instead.
     *
     * @param animation The custom animation to set as the default animation type for the chart.
     * @return A reference to this {@link PlotOptions} instance for convenient method chaining.
     */
    public T setAnimation(Animation animation) {
        return this.setOption("/animation", animation.getOptions());
    }

    /**
     * Convenience method for setting the 'color' plot option to an RGB value.  Equivalent to:
     * <pre><code>
     *     plotOptions.setOption("color", "#CC0000");
     * </code></pre>
     * The main color of the series. In line type series it applies to the line and the point markers
     * unless otherwise specified. In bar type series it applies to the bars unless a color is specified
     * per point.
     * <p/>
     * Note that this method is intended for setting the color to a simple RBG hex value.  If you instead
     * want to set a color to include an alpha channel or a gradient, use the {@link #setColor(Color)}
     * version instead.
     * <p/>
     * Also note that the default colors for all of the series in the chart can be set via the
     * {@link org.moxieapps.gwt.highcharts.client.Chart#setColors(String...)} method.
     *
     * @param color The color to use for this series (e.g. "#CC0000")
     * @return A reference to this {@link PlotOptions} instance for convenient method chaining.
     */
    public T setColor(String color) {
        return this.setOption("color", color);
    }

    /**
     * Convenience method for setting the 'color' plot option to a gradient or color with an alpha
     * value.  Equivalent to:
     * <pre><code>
     *     chart.setOption("color", new Color()
     *        .setLinearGradient(0.0, 0.0, 1.0, 1.0)
     *        .addStop(new Color(255, 255, 255))
     *        .addStop(new Color(200, 200, 255))
     *     );
     * </code></pre>
     * The main color of the series as a gradient or color with an alpha channel. In line type series it
     * applies to the line and the point markers unless otherwise specified. In bar type series it applies
     * to the bars unless a color is specified per point.
     * <p/>
     * Note that this method is intended for setting the color to a gradient or color that includes
     * an alpha channel.  If you instead just want to set the color to a normal RGB hex value
     * you can use the {@link #setColor(String)} version instead.
     * <p/>
     * Also note that the default colors for all of the series in the chart can be set via the
     * {@link org.moxieapps.gwt.highcharts.client.Chart#setColors(String...)} method.
     *
     * @param color The color to use for this series (e.g. "#CC0000")
     * @return A reference to this {@link PlotOptions} instance for convenient method chaining.
     */
    public T setColor(Color color) {
        return this.setOption("color", color != null ? color.getOptionValue() : null);
    }

    /**
     * Convenience method for setting the 'cropThreshold' option.  Equivalent to:
     * <pre><code>
     *     plotOptions.setOption("crpThreshold", 25);
     * </code></pre>
     * When the series contains less points than the crop threshold, all points are drawn, even if the points fall
     * outside the visible plot area at the current zoom. The advantage of drawing all points (including markers and
     * columns), is that animation is performed on updates. On the other hand, when the series contains more points
     * than the crop threshold, the series data is cropped to only contain points that fall within the plot area. The
     * advantage of cropping away invisible points is to increase performance on large series. Defaults to 50.
     * @param cropThreshold The limit of points to be displayed at any one time
     * @return A reference to this {@link PlotOptions} instance for convenient method chaining.
     */
    public T setCropThreshold(Number cropThreshold) {
        return this.setOption("cropThreshold", cropThreshold);
    }

    /**
     * Convenience method for setting the 'cursor' plot option.  Equivalent to:
     * <pre><code>
     *     plotOptions.setOption("cursor", PlotOptions.Cursor.POINTER);
     * </code></pre>
     * Tou can set the cursor to "pointer" if you have click events attached to the series, to signal
     * to the user that the points and lines can be clicked. Defaults to PlotOptions.Cursor.NONE.
     *
     * @param cursor The color to use for this series (e.g. "#CC0000"), or null to use the default.
     * @return A reference to this {@link PlotOptions} instance for convenient method chaining.
     */
    public T setCursor(Cursor cursor) {
        return this.setOption("cursor", cursor != null ? cursor.toString() : null);
    }

    /**
     * Convenience method for setting the 'dashStyle' plot option.  Equivalent to:
     * <pre><code>
     *     plotOptions.setOption("dashStyle", PlotOptions.DashStyle.DOT);
     * </code></pre>
     * A name for the dash style to use for the graph. Applies only to series type having a graph,
     * like line, spline, area and scatter in case it has a lineWidth. See this
     * <a href="http://jsfiddle.net/cSrgA/">demonstration</a> for a visible reference
     * of the available dash styles.
     *
     * @param dashStyle The dash style to use for this series, or null to use the default.
     * @return A reference to this {@link PlotOptions} instance for convenient method chaining.
     */
    public T setDashStyle(PlotLine.DashStyle dashStyle) {
        return this.setOption("dashStyle", dashStyle != null ? dashStyle.toString() : null);
    }

    /**
     * Convenience method for setting the 'dataLabels' plot option.  Equivalent to:
     * <pre><code>
     * plotOptions.setOption("/dataLabels/enabled", true);
     * plotOptions.setOption("/dataLabels/align", Labels.Align.CENTER);
     * plotOptions.setOption("/dataLabels/color", "#CC0000");
     * etc...
     * </code></pre>
     * Defines the appearance of the data labels, static labels for each point.
     * <p/>
     * Sample usage:
     * <pre><code>
     * plotOptions.setDataLabels(
     *     new DataLabels()
     *        .setColor("#FF0000")
     * );
     * </code></pre>
     *
     * @param dataLabels The configuration of how the data labels should appear.
     * @return A reference to this {@link PlotOptions} instance for convenient method chaining.
     */
    public T setDataLabels(DataLabels dataLabels) {
        return this.setBaseDataLabels(dataLabels);
    }

    // We need to maintain a reference to the data labels in order to handle the formatter call back methods
    private BaseDataLabels dataLabels;

    // Hidden implementation of the data labels setter to handle the different sub types
    protected T setBaseDataLabels(BaseDataLabels baseDataLabels) {
        this.dataLabels = baseDataLabels;
        return this.setOption("dataLabels", dataLabels != null ? dataLabels.getOptions() : null);
    }

    /**
     * Convenience method for setting the "dataGrouping" options for a stock chart.  Sample usage:
     * <pre><code>
     *     plotOptions.setDataGrouping(
     *         new DataGrouping()
     *             .setEnabled(true);
     *     );
     * </code></pre>
     * @param dataGrouping The dataGrouping options set using {@link DataGrouping}
     * @return A reference to this {@link PlotOptions} for convenient method chaining.
     * @since 1.6.0
     */
    public T setDataGrouping(DataGrouping dataGrouping) {
        return this.setOption("dataGrouping", dataGrouping);
    }

    /**
     * Returns a reference to the data labels configuration that was set on this plot options, or null if
     * none were set.  Note that this method returns an {@link org.moxieapps.gwt.highcharts.client.labels.BaseDataLabels} and not simply
     * a {@link DataLabels} in order to handle alternative labels types such as
     * {@link org.moxieapps.gwt.highcharts.client.labels.ProportionalDataLabels}.
     *
     * @return A reference to the data labels configuration that was set on this plot options, or null if
     *         none was set.
     */
    public BaseDataLabels getDataLabels() {
        return dataLabels;
    }

    /**
     * Convenience method for setting the 'enableMouseTracking' plot option.  Equivalent to:
     * <pre><code>
     *     plotOptions.setOption("enableMouseTracking", false);
     * </code></pre>
     * Enable or disable the mouse tracking for a specific series. This includes point tooltips
     * and click events on graphs and points. For large datasets it improves performance. Defaults to true.
     *
     * @param enableMouseTracking Enable or disable the mouse tracking for a specific series.
     * @return A reference to this {@link PlotOptions} instance for convenient method chaining.
     */
    public T setEnableMouseTracking(boolean enableMouseTracking) {
        return this.setOption("enableMouseTracking", enableMouseTracking);
    }

    /**
     * Convenience method for setting the 'id' option of the chart.  Equivalent to:
     * <pre><code>
     *     chart.setOption("id", "chart");
     * </code></pre>
     * This can be used after render time to get a pointer to the series object through chart.get().
     * @param id An id for the series.
     * @return A reference to this {@link PlotOptions} instance for convenient method chaining.
     * @since 1.6.0
     */
    public T setId(String id) {
        return this.setOption("id", id);
    }

    /**
     * Convenience method for setting the 'legendIndex' option of the plot options.  Equivalent to:
     * <pre><code>
     *     plotOptions.setOption("legendIndex", 3);
     * </code></pre>
     * The sequential index of the series in the legend.  Series default to being added to the
     * legend in the same index as they are added to the chart.
     *
     * @param legendIndex The sequential index of the series in the legend.
     * @return A reference to this {@link PlotOptions} instance for convenient method chaining.
     * @since 1.4.0
     */
    public T setLegendIndex(int legendIndex) {
        return this.setOption("legendIndex", legendIndex);
    }

    /**
     * Convenience method for setting the 'lineWidth' plot option.  Equivalent to:
     * <pre><code>
     *     plotOptions.setOption("lineWidth", 4);
     * </code></pre>
     * Pixel with of the graph line. Defaults to 2.
     *
     * @param lineWidth Pixel with of the graph line.
     * @return A reference to this {@link PlotOptions} instance for convenient method chaining.
     */
    public T setLineWidth(Number lineWidth) {
        return this.setOption("lineWidth", lineWidth);
    }

    /**
     * convenience method for setting the "linkedTo" option.  Equivalent to:
     * <pre><code>
     *     plotOptions.setOption("linkedTo", "seriesId");
     * </code></pre>
     * The id of another series to link to. Additionally, the value can be ":previous" to link to the previous series.
     * When two series are linked, only the first one appears in the legend.
     * Toggling the visibility of this also toggles the linked series.
     * <p>
     * Note: this method will set a link to another series based on its id. To link to the series itself instead of its
     * id, use {@link #setLinkedTo(Series)}
     * </p>
     * @param linkedTo The name of the series to be linked to.
     * @return A reference to this {@link PlotOptions} instance for convenient method chaining.
     * @see #setLinkedTo(Series)
     * @since 1.6.0
     */
    public T setLinkedTo(String linkedTo) {
        return this.setOption("linkedTo", linkedTo);
    }

    /**
     * convenience method for setting the "linkedTo" option.  Equivalent to:
     * <pre><code>
     *     plotOptions.setOption("linkedTo", "seriesId");
     * </code></pre>
     * The id of another series to link to. Additionally, the value can be ":previous" to link to the previous series.
     * When two series are linked, only the first one appears in the legend.
     * Toggling the visibility of this also toggles the linked series.
     * @param series The name of the series to be linked to.
     * @return A reference to this {@link PlotOptions} instance for convenient method chaining.
     * @see #setLinkedTo(String)
     * @since 1.6.0
     */
    public T setLinkedTo(Series series) {
        return this.setOption("linkedTo", series.getId());
    }

    /**
     * Convenience method for setting the 'marker' plot options.  Equivalent to:
     * <pre><code>
     * plotOptions.setOption("/marker/enabled", true);
     * plotOptions.setOption("/marker/fillColor", "#CCCCCC");
     * plotOptions.setOption("/dataLabels/radius", 4);
     * etc...
     * </code></pre>
     * Defines the appearance of the markers drawn for this series.
     *
     * @param marker The configuration of how the series markers should appear.
     * @return A reference to this {@link PlotOptions} instance for convenient method chaining.
     */
    public T setMarker(Marker marker) {
        return this.setOption("marker", marker != null ? marker.getOptions() : null);
    }

    /**
     * Convenience method for setting the "negativeColor" option for the plot options.  Equivalent to:
     * <pre><code>
     *     areaPlotOptions.setOption("negativeColor", new Color()
     *        .setLinearGradient(0.0, 0.0, 1.0, 1.0)
     *        .addStop(new Color(255, 255, 255))
     *        .addStop(new Color(200, 200, 255))
     *     );
     * </code></pre>
     * When a point's Z value is below the zThreshold setting, this color is used. Defaults to null.
     * <p/>
     * Note that this method is intended for setting the color to a gradient or color that includes
     * an alpha channel.  If you instead just want to set the color to a normal RGB hex value
     * you can use the {@link #setNegativeColor(String)} version instead.
     *
     * @param negativeColor The color for the parts of the graph or points that are below the threshold.
     * @return A reference to this {@link PlotOptions} instance for convenient method chaining.
     * @since 1.6.0
     */
    public PlotOptions setNegativeColor(Color negativeColor) {
        return this.setOption("negativeColor", negativeColor);
    }

    /**
     * Convenience method for setting the "negativeColor" option for the plot options.  Equivalent to:
     * <pre><code>
     *     PlotOptions.setOptions("negativeColor", "#CCCCCC");
     * </code></pre>
     * When a point's Z value is below the zThreshold setting, this color is used. Defaults to null.
     * <p/>
     * Note that this method is intended for setting the color to a simple RBG hex value.  If you instead
     * want to set a color to include an alpha channel or a gradient, use the {@link #setNegativeColor(Color)}
     * version instead.
     *
     * @param negativeColor The color for the parts of the graph or points that are below the threshold.
     * @return A reference to this {@link PlotOptions} instance for convenient method chaining.
     * @since 1.6.0
     */
    public PlotOptions setNegativeColor(String negativeColor) {
        return this.setOption("negativeColor", negativeColor);
    }

    /**
     * Convenience method for setting the 'pointStart' plot option.  Equivalent to:
     * <pre><code>
     *     plotOptions.setOption("pointStart", 10);
     * </code></pre>
     * If no x values are given for the points in a series, pointStart defines on what value to
     * start. For example, if a series contains one yearly value starting from 1945,
     * set pointStart to 1945. Defaults to 0.
     *
     * @param pointStart Which value to start the series at.
     * @return A reference to this {@link PlotOptions} instance for convenient method chaining.
     */
    public T setPointStart(Number pointStart) {
        return this.setOption("pointStart", pointStart);
    }

    /**
     * Convenience method for setting the 'pointInterval' plot option.  Equivalent to:
     * <pre><code>
     *     plotOptions.setOption("pointInterval", 5);
     * </code></pre>
     * If no x values are given for the points in a series, pointInterval defines the
     * interval of the x values. For example, if a series contains one value every decade
     * starting from year 0, set pointInterval to 10.
     *
     * @param pointInterval The interval of the x value in the series.
     * @return A reference to this {@link PlotOptions} instance for convenient method chaining.
     */
    public T setPointInterval(Number pointInterval) {
        return this.setOption("pointInterval", pointInterval);
    }

    /**
     * Convenience method for setting the 'pointPointPlacement' plot option.  Equivalent to:
     * <pre><code>
     *     plotOptions.setOption("pointPointPlacement", Stacking.NULL);
     * </code></pre>
     * Possible values: null, "on", "between".
     * <p/>
     * In a column chart, when pointPointPlacement is "on", the point will not create any padding of the X axis.
     * In a polar column chart this means that the first column points directly north.
     * If the pointPointPlacement is "between", the columns will be laid out between ticks.
     * This is useful for example for visualising an amount between two points in time or in a certain sector of a polar chart.
     * <p/>
     * Defaults to null in cartesian charts, "between" in polar charts.
     * @param pointPointPlacement Where to place points in relation to ticks on the axis.
     * @return A reference to this {@link PlotOptions} instance for convenient method chaining.
     * @since 1.6.0
     */
    public T setPointPlacement(PointPlacement pointPointPlacement) {
        return this.setOption("pointPointPlacement", pointPointPlacement != null ? pointPointPlacement.toString() : null);
    }

    /**
     * Convenience method for setting the 'selected' plot option.  Equivalent to:
     * <pre><code>
     *     plotOptions.setOption("selected", true);
     * </code></pre>
     * Whether to select the series initially. If {@link #setShowCheckbox(boolean)} is true,
     * the checkbox next to the series name will be checked for a selected series. Defaults to false.
     *
     * @param selected Whether to select the series initially.
     * @return A reference to this {@link PlotOptions} instance for convenient method chaining.
     */
    public T setSelected(boolean selected) {
        return this.setOption("selected", selected);
    }

    /**
     * Convenience method for setting the 'shadow' plot option.  Equivalent to:
     * <pre><code>
     *     plotOptions.setOption("shadow", false);
     * </code></pre>
     * Whether to apply a drop shadow to the graph line. Defaults to true.
     *
     * @param shadow Whether to apply a drop shadow to the graph line.
     * @return A reference to this {@link PlotOptions} instance for convenient method chaining.
     */
    public T setShadow(boolean shadow) {
        return this.setOption("shadow", shadow);
    }

    /**
     * Convenience method for setting the 'showCheckbox' plot option.  Equivalent to:
     * <pre><code>
     *     plotOptions.setOption("showCheckbox", true);
     * </code></pre>
     * If true, a checkbox is displayed next to the legend item to allow selecting the series.
     * The state of the checkbox is determined by the selected option. Defaults to false.
     *
     * @param showCheckbox Whether to display next to the legend item to allow selecting the series.
     * @return A reference to this {@link PlotOptions} instance for convenient method chaining.
     */
    public T setShowCheckbox(boolean showCheckbox) {
        return this.setOption("showCheckbox", showCheckbox);
    }

    /**
     * Convenience method for setting the 'showInLegend' plot option.  Equivalent to:
     * <pre><code>
     *     plotOptions.setOption("showInLegend", false);
     * </code></pre>
     * Whether to display this particular series or series type in the legend. Defaults to true.
     *
     * @param showInLegend Whether to display this particular series or series type in the legend.
     * @return A reference to this {@link PlotOptions} instance for convenient method chaining.
     */
    public T setShowInLegend(boolean showInLegend) {
        return this.setOption("showInLegend", showInLegend);
    }

    /**
     * Convenience method for setting the 'stacking' plot option.  Equivalent to:
     * <pre><code>
     *     plotOptions.setOption("stacking", Stacking.NORMAL);
     * </code></pre>
     * Whether to stack the values of each series on top of each other. Possible values are null to disable,
     * "normal" to stack by value or "percent". Defaults to null.
     *
     * @param stacking Whether to stack the values of each series on top of each other.
     * @return A reference to this {@link PlotOptions} instance for convenient method chaining.
     */
    public T setStacking(Stacking stacking) {
        return this.setOption("stacking", stacking != null ? stacking.toString() : null);
    }

    /**
     * Convenience method for setting the 'enabled' plot option for the hover state.  Equivalent to:
     * <pre><code>
     *     plotOptions.setOption("/states/hover/enable", true);
     * </code></pre>
     * Enable separate styles for the hovered series to visualize that the user hovers either the
     * series itself or the legend. Enabling it has a performance penalty as it requires that a second
     * layer be drawn as a double buffer. This means twice as much graphics to draw for each plot,
     * which can make a great difference for charts with a high number of series or points. Defaults to false.
     *
     * @param enabled Whether to enable separate styles for the hover state.
     * @return A reference to this {@link PlotOptions} instance for convenient method chaining.
     */
    public T setHoverStateEnabled(boolean enabled) {
        return this.setOption("/states/hover/enabled", enabled);
    }

    /**
     * Convenience method for setting the 'lineWidth' plot option for the hover state.  Equivalent to:
     * <pre><code>
     *     plotOptions.setOption("/states/hover/lineWidth", 4);
     * </code></pre>
     * Pixel with of the graph line when hovered over. Defaults to 2.
     *
     * @param lineWidth Pixel with of the graph line when hovered over.
     * @return A reference to this {@link PlotOptions} instance for convenient method chaining.
     */
    public T setHoverStateLineWidth(Number lineWidth) {
        return this.setOption("/states/hover/lineWidth", lineWidth);
    }

    /**
     * Convenience method for setting the 'marker' plot options for the hover state.  Equivalent to:
     * <pre><code>
     * plotOptions.setOption("/states/hover/marker/enabled", true);
     * plotOptions.setOption("/states/hover/marker/fillColor", "#CCCCCC");
     * plotOptions.setOption("/states/hover/dataLabels/radius", 4);
     * etc...
     * </code></pre>
     * Defines the appearance of the markers drawn for this series when hovered over.  Note that the
     * hover state need to be enabled with the {@link #setHoverStateEnabled(boolean)} method in order
     * for this option to have any effect.
     *
     * @param marker The configuration of how the series markers should appear when hover over.
     * @return A reference to this {@link PlotOptions} instance for convenient method chaining.
     */
    public T setHoverStateMarker(Marker marker) {
        return this.setOption("/states/hover/marker", marker != null ? marker.getOptions() : marker);
    }

    /**
     * Convenience method for setting the 'stickyTracking' plot option.  Equivalent to:
     * <pre><code>
     *     plotOptions.setOption("stickyTracking", false);
     * </code></pre>
     * Sticky tracking of mouse events. When true, the mouseOut event on a series isn't triggered
     * until the mouse moves over another series, or out of the plot area. When false, the mouseOut
     * event on a series is triggered when the mouse leaves the area around the series' graph or
     * markers. This also implies the tooltip. When stickyTracking is false, the tooltip will be
     * hidden when moving the mouse between series. Defaults to true.
     *
     * @param stickyTracking Whether to enable sticky tracking of mouse events.
     * @return A reference to this {@link PlotOptions} instance for convenient method chaining.
     */
    public T setStickyTracking(boolean stickyTracking) {
        return this.setOption("stickyTracking", stickyTracking);
    }

    /**
     * Convenience method for setting the "threshold" option for the plot options.  Equivalent to:
     * <pre><code>
     *     plotOptions.setOptions("threshold", 0);
     * </code></pre>
     * The threshold, also called zero level or base level. For line type series this is only used in conjunction with negativeColor. Defaults to 0
     * @param threshold A minimum z-value determine whether bubbles will be displayed if 'displayNegative' is false.
     * @return A reference to this {@link PlotOptions} instance for convenient method chaining.
     * @since 1.6.0
     */
    public T setThreshold(Number threshold) {
        return this.setOption("threshold", threshold);
    }

    /**
     * Convenience method for setting the "turboThreshold" optioin for the plot options.  Equivalent to:
     * <pre><code>
     *     plotOptions.setOptions("turboThreshold", 1000);
     * </code></pre>
     * When a series contains a data array that is longer than this, only one dimensional arrays of numbers,
     * or two dimensional arrays with x and y values are allowed. Also, only the first point is tested, and
     * the rest are assumed to be the same format. This saves expensive data checking and indexing in long series. Defaults to 1000
     * @param turboThreshold The maximum size of an array to be greater than two-dimensional and check the format of each entry.
     * @return A reference to this {@link PlotOptions} instance for convenient method chaining.
     * @since 1.6.0
     */
    public T setTurboThreshold(Number turboThreshold) {
        return this.setOption("turboThreshold", turboThreshold);
    }

    /**
     * Convenience method for setting the 'visible' plot option.  Equivalent to:
     * <pre><code>
     *     plotOptions.setOption("visible", false);
     * </code></pre>
     * Set the initial visibility of the series. Defaults to true.
     *
     * @param visible The initial visibility of the series.
     * @return A reference to this {@link PlotOptions} instance for convenient method chaining.
     */
    public T setVisible(boolean visible) {
        return this.setOption("visible", visible);
    }

    /**
     * Convenience method for setting the 'zIndex' plot option.  Equivalent to:
     * <pre><code>
     *     plotOptions.setOption("visible", false);
     * </code></pre>
     * Define the z index of the series. Defaults to null.
     *
     * @param zIndex The z index of the series.
     * @return A reference to this {@link PlotOptions} instance for convenient method chaining.
     */
    public T setZIndex(Number zIndex) {
        return this.setOption("zIndex", zIndex);
    }

    /**
     * Convenience method for setting the 'zoneAxis' plot option.  Equivalent to:
     * <pre><code>
     *     plotOption.setOption("zoneAxis", "y");
     * </code></pre>
     * Defines the Axis on which the zones are applied. Defaults to y.
     * @param zoneAxis
     * @return A reference to this {@link PlotOptions} instance for convenient method chaining.
     * @see Zone.Axis
     */
    public T setZoneAxis(Zone.Axis zoneAxis) {
        return this.setOption("zoneAxis", zoneAxis != null ? zoneAxis.toString() : null);
    }

    /**
     * Convenience method for setting the 'zone' plot option.  Equivalent to:
     * <pre><code>
     *     plotOption.setOption("zone", );
     * </code></pre>
     * @param zones An array defining zones within a series.
     * @return A reference to this {@link PlotOptions} instance for convenient method chaining.
     * @see Zone
     */
    public T setZones(Zone... zones) {
        return this.setOption("zones", zones);
    }

}
