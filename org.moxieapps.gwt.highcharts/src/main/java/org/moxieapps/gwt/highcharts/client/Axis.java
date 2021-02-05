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

import org.moxieapps.gwt.highcharts.client.events.AxisSetExtremesEventHandler;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Document;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

/**
 * The base class for both the X and Y axis types, which allows for general options to be set via
 * the inherited {@link Configurable#setOption(String, Object)} method.  But also exposes type
 * specific methods that the caller is encouraged to use instead,  such as
 * {@link #setAllowDecimals(boolean)}, {@link #setAlternateGridColor(String)}, etc.
 * <p/>
 * Note that you won't normally work with this class directly, but instead one of it's sub-types
 * such as {@link XAxis} or {@link YAxis}.
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.0.0
 */
public abstract class Axis<T extends Axis> extends Configurable<T> {

    /**
     * An enumeration of supported axis types, which can be passed to methods such as
     * {@link Axis#setType(Axis.Type)}.
     */
    public enum Type {

        /**
         * Display the point names as categories for the axis
         */
        CATEGORY("category"),

        /**
         * Default axis type showing the values in a linear structure.
         */
        LINEAR("linear"),

        /**
         * Scale the axis tick values logarithmically instead of linearly.
         * @since 1.2.0
         */
        LOGARITHMIC("logarithmic"),

        /**
         * In a datetime axis, the numbers are given in milliseconds, and tick
         * marks are placed on appropriate values like full hours or days.
         */
        DATE_TIME("datetime");

        private Type(String optionValue) {
            this.optionValue = optionValue;
        }

        private final String optionValue;

        public String toString() {
            return optionValue;
        }

    }

    /**
     * An enumeration of supported tick positions, which can be passed to methods such as
     * {@link Axis#setMinorTickPosition(Axis.TickPosition)} and {@link Axis#setTickPosition(Axis.TickPosition)}
     */
    public enum TickPosition {

        /**
         * Display the ticks inside of the axis line
         */
        INSIDE("inside"),

        /**
         * Display the ticks outside of the axis line
         */
        OUTSIDE("outside");

        private TickPosition(String optionValue) {
            this.optionvalue = optionValue;
        }

        private final String optionvalue;

        public String toString() {
            return optionvalue;
        }

    }

    /**
     * An enumeration of supported week days, which can be passed to methods such as
     * {@link Axis#setStartOfWeek(Axis.WeekDay)}.
     */
    public enum WeekDay {

        SUNDAY(0),
        MONDAY(1),
        TUESDAY(2),
        WEDNESDAY(3),
        THURSDAY(4),
        FRIDAY(5),
        SATURDAY(6);

        private WeekDay(Number optionValue) {
            this.optionvalue = optionValue;
        }

        private final Number optionvalue;

        public Number toNumber() {
            return optionvalue;
        }

    }

    // Maintain an internal reference to the chart instance that this axis is a part of
    private BaseChart chart;

    // The unique id for this axis, that we can use to access the native axis instance later if changes
    // come into the axis after it is rendered
    private String id;
    
    private AxisSetExtremesEventHandler axisSetExtremesEventHandler;

    /**
     * Use the {@link Chart#getXAxis()} or {@link Chart#getYAxis()} methods to get access
     * to the axis instances on the chart.
     *
     * @param chart The chart instance that this axis is being created within.
     */
    Axis(BaseChart chart) {
        this.chart = chart;
        id = Document.get().createUniqueId();
        setOption("id", id);
    }
    
    /**
     * Set a callback handler that will be invoked whenever the minimum and maximum is set for the axis, either by calling the 
     * {@link #setExtremes(Number, Number)} method or by selecting an area in the chart.
     * 
     * Additional information about the new extremes value (such as the new minimum and maximum) can be
     * found via the {@link org.moxieapps.gwt.highcharts.client.events.AxisSetExtremesEvent} instance
     * that is passed to the handler's {@link org.moxieapps.gwt.highcharts.client.events.AxisSetExtremesEventHandler#onSetExtremes(org.moxieapps.gwt.highcharts.client.events.AxisSetExtremesEvent)} method.
     *
     * @param axisSetExtremesEventHandler The handler that should be invoked whenever a set extremes event occurs.
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     *
     * @since 1.3.0
     */
    public T setAxisSetExtremesEventHandler(AxisSetExtremesEventHandler axisSetExtremesEventHandler) {
        this.axisSetExtremesEventHandler = axisSetExtremesEventHandler;
        return getThis();
    }

    /**
     * Returns the custom event handler that has been set on the axis, or null if no event
     * handler has been set.
     *
     * @return The custom event handler that has been applied, or null if it has not been set.
     *
     * @since 1.3.0
     */
    public AxisSetExtremesEventHandler getAxisSetExtremesEventHandler() {
        return this.axisSetExtremesEventHandler;
    }

    /**
     * Create a new plot line that can be configured, and then added to this axis instance via the
     * {@link #setPlotLines(PlotLine...)} method.
     *
     * @return The plot line that was created (which will need to be added to the axis after it is configured
     *         via {@link #setPlotLines(PlotLine...)}.
     */
    public PlotLine createPlotLine() {
        return new PlotLine(this);
    }

    /**
     * Create a new plot band that can be configured, and then added to this axis instance via the
     * {@link #setPlotBands(PlotBand...)} method.
     *
     * @return The plot babd that was created (which will need to be added to the axis after it is configured
     *         via {@link #setPlotBands(PlotBand...)}.
     */
    public PlotBand createPlotBand() {
        return new PlotBand(this);
    }

    /**
     * Convenience method for setting the 'allowDecimals' option for the axis.  Equivalent to:
     * <pre><code>
     *     axis.setOption("allowDecimals", false);
     * </code></pre>
     * Whether to allow decimals in this axis' ticks. When counting integers, like persons or
     * hits on a web page, decimals must be avoided in the axis tick labels. Defaults to true.
     *
     * @param allowDecimals Whether to allow decimals in this axis' ticks.
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     */
    public T setAllowDecimals(boolean allowDecimals) {
        return this.setOption("allowDecimals", allowDecimals);
    }

    /**
     * Convenience method for setting the 'alternateGridColor' option for the axis.  Equivalent to:
     * <pre><code>
     *     axis.setOption("alternateGridColor", "#CC0000");
     * </code></pre>
     * When using an alternate grid color, a band is painted across the plot area between every
     * other grid line. Defaults to null.
     *
     * @param alternateGridColor The color to use as the alternate grid color.
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     */
    public T setAlternateGridColor(String alternateGridColor) {
        return this.setOption("alternateGridColor", alternateGridColor);
    }

    /**
     * Convenience method for setting the 'dateTimeLabelFormats' options of the axis.  Equivalent to code like:
     * <pre><code>
     *     axis.setOption("/dateTimeLabelFormats/second", "%H:%M:%S");
     *     axis.setOption("/dateTimeLabelFormats/minute", "%H:%M");
     * </code></pre>
     * For a datetime axis, the scale will automatically adjust to the appropriate unit. This configuration
     * option sets the default string format representations used for each unit. For an overview of the
     * replacement codes available see the javadoc on the {@link DateTimeLabelFormats} class.  Defaults to:
     * <ul>
     * <li>second: '%H:%M:%S'</li>
     * <li>minute: '%H:%M'</li>
     * <li>hour: '%H:%M'</li>
     * <li>day: '%e. %b'</li>
     * <li>week: '%e. %b'</li>
     * <li>month: '%b \'%y'</li>
     * <li>year: '%Y</li>
     * </ul>
     * Example usage:
     * <code><pre>
     *   axis.setDateTimeLabelFormats(
     *     new DateTimeLabelFormats()
     *       .setHour("%I %p")
     *       .setMinute("%I:%M %p")
     *   );
     * </pre></code>
     *
     * @param dateTimeLabelFormats The formats to use for time series information on this axis.
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     */
    public T setDateTimeLabelFormats(DateTimeLabelFormats dateTimeLabelFormats) {
        return this.setOption("dateTimeLabelFormats", dateTimeLabelFormats != null ? dateTimeLabelFormats.getOptions() : null);
    }

    /**
     * Convenience method for setting the 'endOnTick' option for the axis.  Equivalent to:
     * <pre><code>
     *     axis.setOption("endOnTick", true);
     * </code></pre>
     * Whether to force the axis to end on a tick. Use this option with the maxPadding option to
     * control the axis end. Defaults to false.
     *
     * @param endOnTick Whether to force the axis to end on a tick.
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     */
    public T setEndOnTick(boolean endOnTick) {
        return this.setOption("endOnTick", endOnTick);
    }

    // TODO: Add support for events

    /**
     * Set the minimum and maximum of the axes after render time using the default animation options.
     * If the startOnTick and endOnTick options are true, the minimum and maximum values are rounded
     * off to the nearest tick. To prevent this, these options can be set to false before calling this method.
     * <p/>
     * Also note that this method will use the default chart animation options when changing the extremes.
     * To control the animation more specifically use the {@link #setExtremes(Number, Number, boolean, boolean)}
     * or {@link #setExtremes(Number, Number, boolean, Animation)} method instead.
     *
     * @param min The new minimum value.
     * @param max The new maximum value.
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     */
    public T setExtremes(Number min, Number max) {
        return this.setExtremes(min, max, true, true);
    }

    /**
     * Set the minimum and maximum of the axes after render time, controlling the redraw and animation
     * status. If the startOnTick and endOnTick options are true, the minimum and maximum values are
     * rounded off to the nearest tick. To prevent this, these options can be set to false before calling this method.
     * <p/>
     * The gain more control over the animation used when the extremes are changed, use the
     * {@link #setExtremes(Number, Number, boolean, Animation)} method instead.
     *
     * @param min       The new minimum value.
     * @param max       The new maximum value.
     * @param redraw    'true' to force the chart to redraw immediately, or 'false' to wait until the
     *                  {@link Chart#redraw()} method is invoked.
     * @param animation When 'true', the chart updating will be animated with default animation options.
     *                  Note, use the {@link #setExtremes(Number, Number, boolean, Animation)} method
     *                  for more control over the animation options.
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     */
    public T setExtremes(Number min, Number max, boolean redraw, boolean animation) {
        return setExtremes(min, max, redraw, animation ? new Animation() : null);
    }

    /**
     * Set the minimum and maximum of the axes after render time, controlling the redraw and animation
     * options. If the startOnTick and endOnTick options are true, the minimum and maximum values are
     * rounded off to the nearest tick. To prevent this, these options can be set to false before calling this method.
     * <p/>
     * This method is intended to be used for callers that need tight control over the animation that
     * will run when the chart extremes are applied.  If you don't need tight control over the animation
     * you can use the {@link #setExtremes(Number, Number)} or {@link #setExtremes(Number, Number, boolean, boolean)}
     * method instead.
     *
     * @param min       The new minimum value.
     * @param max       The new maximum value.
     * @param redraw    'true' to force the chart to redraw immediately, or 'false' to wait until the
     *                  {@link Chart#redraw()} method is invoked.
     * @param animation Custom animation to use when the chart extremes are being updated.
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     */
    public T setExtremes(Number min, Number max, boolean redraw, Animation animation) {
        if (chart.isRendered()) {
            // We'll update the axis live in the DOM if we've already been rendered
            final JavaScriptObject nativeAxis = getNativeAxis();
            if (nativeAxis != null) {
                if (animation == null || animation.getOptions() == null) {
                    final boolean animationFlag = animation != null;
                    nativeSetExtremes(nativeAxis, min.doubleValue(), max.doubleValue(), redraw, animationFlag);
                } else {
                    final JavaScriptObject animationOptions = animation.getOptions().getJavaScriptObject();
                    nativeSetExtremes(nativeAxis, min.doubleValue(), max.doubleValue(), redraw, animationOptions);
                }
            }
        } else {
            // If we're called before the chart has been rendered, then just track the min/max as a configuration option
            this.setMin(min).setMax(max);
        }
        return getThis();
    }

    /**
     * Return a non-null object that represents the current extremes for the axis.  Note that if this method
     * is invoked before the chart has been rendered, only the configured min/max values will be known.
     *
     * @return The current extremes for the axis.
     */
    public Extremes getExtremes() {

        Extremes extremes = null;

        if (chart.isRendered()) {
            // If we've already been rendered, we can ask the running chart for it's actual extremes
            final JavaScriptObject nativeAxis = getNativeAxis();
            if (nativeAxis != null) {
                final JavaScriptObject nativeExtremes = nativeGetExtremes(nativeAxis);
                if (nativeExtremes != null) {
                    JSONObject jsonExtremes = new JSONObject(nativeExtremes);
                    extremes = new Extremes(
                        getNumberFromJSONObject(jsonExtremes, "dataMin"),
                        getNumberFromJSONObject(jsonExtremes, "dataMax"),
                        getNumberFromJSONObject(jsonExtremes, "min"),
                        getNumberFromJSONObject(jsonExtremes, "max")
                    );
                }
            }
        }

        // If we haven't been rendered (or for some reason we can't get to the native object), then
        // all we know if whatever configuration options were set manually
        if (extremes == null) {
            extremes = new Extremes(null, null, this.min, this.max);
        }
        return extremes;
    }

    /**
     * Returns a pointer to the native Highchart's Axis instance that this GWT Axis instance
     * is associated with.  Note that this method will only return a non-null value if it
     * is called after the chart has been rendered.  For advanced use-cases only.
     *
     * @return The native Highcharts axis instance that this Axis is associated with, or
     *         null if the chart has not yet been rendered.
     * @since 1.4.0
     */
    public JavaScriptObject getNativeAxis() {
        if(chart != null) {
            return chart.get(this.id);
        }
        return null;
    }
    
    /* package */ String getId() {
        return this.id;
    }

    // Save some typing in the getExtremes() method
    private Number getNumberFromJSONObject(JSONObject jsonObject, String key) {
        JSONValue jsonValue = jsonObject.get(key);
        if (jsonValue != null && jsonValue.isNumber() != null) {
            return jsonValue.isNumber().doubleValue();
        }
        return null;
    }

    /**
     * Convenience method for setting the 'gridLineColor' option for the axis.  Equivalent to:
     * <pre><code>
     *     axis.setOption("gridLineColor", "#CCCCCC");
     * </code></pre>
     * Color of the grid lines extending the ticks across the plot area. Defaults to "#C0C0C0".
     *
     * @param gridLineColor Color of the grid lines extending the ticks across the plot area.
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     */
    public T setGridLineColor(String gridLineColor) {
        return this.setOption("gridLineColor", gridLineColor);
    }

    /**
     * Convenience method for setting the 'gridLineDashStyle' axis option.  Equivalent to:
     * <pre><code>
     *     plotOptions.setOption("gridLineDashStyle", PlotOptions.DashStyle.LONG_DASH);
     * </code></pre>
     * The dash or dot style of the grid lines. Defaults to DashStyle.DOT.  See this
     * <a href="http://jsfiddle.net/cSrgA/">demonstration</a> for a visible reference
     * of the available dash styles.
     *
     * @param gridLineDashStyle Sets the dash or dot style of the grid lines, or null to return to the default.
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     */
    public T setGridLineDashStyle(PlotLine.DashStyle gridLineDashStyle) {
        return this.setOption("gridLineDashStyle", gridLineDashStyle != null ? gridLineDashStyle.toString() : null);
    }

    /**
     * Convenience method for setting the 'gridLineWidth' option for the axis.  Equivalent to:
     * <pre><code>
     *     axis.setOption("gridLineWidth", 2);
     * </code></pre>
     * The width of the grid lines extending the ticks across the plot area. Defaults to 0.
     *
     * @param gridLineWidth The new width of the grid lines extending the ticks across the plot area.
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     */
    public T setGridLineWidth(Number gridLineWidth) {
        return this.setOption("gridLineWidth", gridLineWidth);
    }

    /**
     * Convenience method for setting the 'lineColor' option for the axis.  Equivalent to:
     * <pre><code>
     *     axis.setOption("lineColor", "#00CC00");
     * </code></pre>
     * The color of the line marking the axis itself. Defaults to "#C0D0E0".
     *
     * @param lineColor The new color of the line marking the axis itself.
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     */
    public T setLineColor(String lineColor) {
        return this.setOption("lineColor", lineColor);
    }

    /**
     * Convenience method for setting the 'lineWidth' option for the axis.  Equivalent to:
     * <pre><code>
     *     axis.setOption("lineWidth", 2);
     * </code></pre>
     * The width of the line marking the axis itself. Defaults to 1.
     *
     * @param lineWidth The new width of the line marking the axis itself.
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     */
    public T setLineWidth(Number lineWidth) {
        return this.setOption("lineWidth", lineWidth);
    }

    /**
     * Convenience method for setting the 'linkedTo' option for the axis.  Equivalent to:
     * <pre><code>
     *     axis.setOption("linkedTo", 2);
     * </code></pre>
     * Index of another axis that this axis is linked to. When an axis is linked to a master
     * axis, it will take the same extremes as the master, but as assigned by
     * {@link #setMin(Number)} or {@link #setMax(Number)} or
     * by {@link #setExtremes(Number, Number)}. It can be used to show additional info, or
     * to ease reading the chart by duplicating the scales. Defaults to null.
     *
     * @param linkedTo The index of another axis that this axis is linked to.
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     */
    public T setLinkedTo(Number linkedTo) {
        return this.setOption("linkedTo", linkedTo);
    }

    private Number max;

    /**
     * Convenience method for setting the 'max' option for the axis.  Equivalent to:
     * <pre><code>
     *     axis.setOption("max", 100);
     * </code></pre>
     * The maximum value of the axis. If null, the max value is automatically calculated. If
     * the {@link #setEndOnTick(boolean)} option is true, the max value might be rounded up.
     * The actual maximum value is also influenced by {@link Chart#setAlignTicks(boolean)}
     * setting. Defaults to null.
     * <p/>
     * Note that this method will only affect the maximum value of the chart before it is rendered.
     * To change the min/max value of the chart after render time use the {@link #setExtremes(Number, Number)}
     * method instead.
     *
     * @param max The maximum value of the axis, or null to automatically calculate the maximum.
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     */
    public T setMax(Number max) {
        this.max = max;
        return this.setOption("max", max);
    }

    /**
     * Convenience method for setting the 'maxPadding' option for the axis.  Equivalent to:
     * <pre><code>
     *     axis.setOption("maxPadding", 0.05);
     * </code></pre>
     * Padding of the max value relative to the length of the axis. A padding of 0.05 will make a
     * 100px axis 5px longer. This is useful when you don't want the highest data value to appear
     * on the edge of the plot area. When the axis' max option is set or a max extreme is set
     * using {@link #setExtremes(Number, Number)}, the maxPadding will be ignored. Defaults to 0.01.
     *
     * @param maxPadding The new padding of the max value relative to the length of the axis.
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     */
    public T setMaxPadding(Number maxPadding) {
        return this.setOption("maxPadding", maxPadding);
    }

    /**
     * Convenience method for setting the 'maxZoom' option for the axis.  Equivalent to:
     * <pre><code>
     *     axis.setOption("maxZoom", 5);
     * </code></pre>
     * The maximum amount of zoom on this axis. The entire axis will not be allowed to span over
     * a smaller interval than this. For example, for a datetime axis the main unit is milliseconds.
     * If maxZoom is set to 3600000, you can't zoom in more than to one hour.
     *
     * @param maxZoom The new maximum amount of zoom on this axis.
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     */
    public T setMaxZoom(Number maxZoom) {
        return this.setOption("maxZoom", maxZoom);
    }

    private Number min;

    /**
     * Convenience method for setting the 'min' option for the axis.  Equivalent to:
     * <pre><code>
     *     axis.setOption("min", 10);
     * </code></pre>
     * The minimum value of the axis. If null, the min value is automatically calculated. If
     * the {@link #setStartOnTick(boolean)} option is true, the min value might be rounded down.
     * Defaults to null.
     * <p/>
     * Note that this method will only affect the minimum value of the chart before it is rendered.
     * To change the min/max value of the chart after render time use the {@link #setExtremes(Number, Number)}
     * method instead.
     *
     * @param min The minimum value of the axis, or null to automatically calculate the minimum.
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     */
    public T setMin(Number min) {
        this.min = min;
        return this.setOption("min", min);
    }

    /**
     * Convenience method for setting the 'minorGridLineColor' option for the axis.  Equivalent to:
     * <pre><code>
     *     axis.setOption("minorGridLineColor", "#00CC00");
     * </code></pre>
     * Color of the minor, secondary grid lines. Defaults to #E0E0E0.
     *
     * @param minorGridLineColor The new color of the minor, secondary grid lines.
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     */
    public T setMinorGridLineColor(String minorGridLineColor) {
        return this.setOption("minorGridLineColor", minorGridLineColor);
    }

    /**
     * Convenience method for setting the 'minorGridLineDashStyle' axis option.  Equivalent to:
     * <pre><code>
     *     plotOptions.setOption("minorGridLineDashStyle", PlotOptions.DashStyle.LONG_DASH);
     * </code></pre>
     * The dash or dot style of the grid lines. Defaults to DashStyle.SOLID.  See this
     * <a href="http://jsfiddle.net/cSrgA/">demonstration</a> for a visible reference
     * of the available dash styles.
     *
     * @param minorGridLineDashStyle Sets the dash or dot style of the minor grid lines, or null to return to the default.
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     */
    public T setMinorGridLineDashStyle(PlotLine.DashStyle minorGridLineDashStyle) {
        return this.setOption("minorGridLineDashStyle", minorGridLineDashStyle != null ? minorGridLineDashStyle.toString() : null);
    }

    /**
     * Convenience method for setting the 'minorGridLineWidth' option for the axis.  Equivalent to:
     * <pre><code>
     *     axis.setOption("minorGridLineWidth", 2);
     * </code></pre>
     * The width of the minor, secondary grid lines. Defaults to 1.
     *
     * @param minorGridLineWidth The new width of the minor, secondary grid lines.
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     */
    public T setMinorGridLineWidth(Number minorGridLineWidth) {
        return this.setOption("minorGridLineWidth", minorGridLineWidth);
    }

    /**
     * Convenience method for setting the 'minorTickColor' option for the axis.  Equivalent to:
     * <pre><code>
     *     axis.setOption("minorTickColor", "#00CC00");
     * </code></pre>
     * Color for the minor tick marks. Defaults to #A0A0A0.
     *
     * @param minorTickColor The new color for the minor tick marks.
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     */
    public T setMinorTickColor(String minorTickColor) {
        return this.setOption("minorTickColor", minorTickColor);
    }

    /**
     * Convenience method for setting the 'minorTickInterval' option for the axis.  Equivalent to:
     * <pre><code>
     *     axis.setOption("minorTickInterval", 2);
     * </code></pre>
     * Tick interval in scale units for the minor ticks. If null, minor ticks are not shown. Defaults to null.
     * Note that if you instead call the {@link #setMinorTickIntervalAuto()} method
     * the minor tick interval is calculated as a fifth of the tickInterval.
     *
     * @param minorTickInterval The new tick interval in scale units for the minor ticks.
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     */
    public T setMinorTickInterval(Number minorTickInterval) {
        return this.setOption("minorTickInterval", minorTickInterval);
    }

    /**
     * Convenience method for setting the 'minorTickInterval' option for the axis to auto.  Equivalent to:
     * <pre><code>
     *     axis.setOption("minorTickInterval", "auto");
     * </code></pre>
     * Note, if you instead want to set the tick interval to a specific numeric value (or disable the
     * ticks completely), you'll want to use the {@link #setMinorTickInterval(Number)} method.
     *
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     */
    public T setMinorTickIntervalAuto() {
        return this.setOption("minorTickInterval", "auto");
    }

    /**
     * Convenience method for setting the 'minorTickLength' option for the axis.  Equivalent to:
     * <pre><code>
     *     axis.setOption("minorTickLength", 4);
     * </code></pre>
     * The pixel length of the minor tick marks. Defaults to 2.
     *
     * @param minorTickLength The new pixel length of the minor tick marks.
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     */
    public T setMinorTickLength(Number minorTickLength) {
        return this.setOption("minorTickLength", minorTickLength);
    }

    /**
     * Convenience method for setting the 'minorTickPosition' option for the axis.  Equivalent to:
     * <pre><code>
     *     axis.setOption("minorTickPosition", TickPosition.INSIDE);
     * </code></pre>
     * The position of the minor tick marks relative to the axis line. Defaults to {@link Axis.TickPosition#OUTSIDE}.
     *
     * @param minorTickPosition The new position of the minor tick marks relative to the axis line,
     *                          or null to return to the default.
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     */
    public T setMinorTickPosition(TickPosition minorTickPosition) {
        return this.setOption("minorTickPosition", minorTickPosition != null ? minorTickPosition.toString() : null);
    }

    /**
     * Convenience method for setting the 'minorTickWidth' option for the axis.  Equivalent to:
     * <pre><code>
     *     axis.setOption("minorTickWidth", 4);
     * </code></pre>
     * The pixel width of the minor tick mark. Defaults to 0.
     *
     * @param minorTickWidth The new pixel width of the minor tick mark.
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     */
    public T setMinorTickWidth(Number minorTickWidth) {
        return this.setOption("minorTickWidth", minorTickWidth);
    }

    /**
     * Convenience method for setting the 'minPadding' option for the axis.  Equivalent to:
     * <pre><code>
     *     axis.setOption("minPadding", 0.05);
     * </code></pre>
     * Padding of the min value relative to the length of the axis. A padding of 0.05 will make a
     * 100px axis 5px longer. This is useful when you don't want the highest data value to appear
     * on the edge of the plot area. When the axis' min option is set or a max extreme is set
     * using {@link #setExtremes(Number, Number)}, the minPadding will be ignored. Defaults to 0.01.
     *
     * @param minPadding The new padding of the min value relative to the length of the axis.
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     */
    public T setMinPadding(Number minPadding) {
        return this.setOption("minPadding", minPadding);
    }

    /**
     * Convenience method for setting the 'offset' option for the axis.  Equivalent to:
     * <pre><code>
     *     axis.setOption("offset", 60);
     * </code></pre>
     * The distance in pixels from the plot area to the axis line. A positive offset moves
     * the axis with it's line, labels and ticks away from the plot area. This is typically
     * used when two or more axes are displayed on the same side of the plot. Defaults to 0.
     *
     * @param offset The new distance in pixels from the plot area to the axis line.
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     */
    public T setOffset(Number offset) {
        return this.setOption("offset", offset);
    }

    /**
     * Convenience method for setting the 'opposite' option for the axis.  Equivalent to:
     * <pre><code>
     *     axis.setOption("opposite", true);
     * </code></pre>
     * Whether to display the axis on the opposite side of the normal. The normal is on the
     * left side for vertical axes and bottom for horizontal, so the opposite sides will be
     * right and top respectively. This is typically used with dual or multiple axes. Defaults to false.
     *
     * @param opposite 'true' to display the axis on the opposite side of the normal, 'false'
     *                 to show the axis on the normal side.
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     */
    public T setOpposite(boolean opposite) {
        return this.setOption("opposite", opposite);
    }

    /**
     * Sets the 'plotLines' array for the axis.  A plot line is a line stretching across the plot area,
     * marking a specific value on one of the axes.  Example usage:
     * <code><pre>
     *   XAxis xAxis = chart.getXAxis()
     *   xAxis.getXAxis()
     *     .setPlotLines(
     *       xAxis.createPlotLine()
     *          .setColor("#CC0000")
     *          .setValue(40),
     *       xAxis.createPlotLine()
     *          .setColor("#009900")
     *          .setValue(60)
     *     )
     *   );
     * </pre></code>
     *
     * @param plotLines One or more PlotLine instances that represent the options of each line to render
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     */
    public T setPlotLines(PlotLine... plotLines) {
        return this.setOption("plotLines", plotLines);
    }

    /**
     * Sets the 'plotBands' array for the axis.  A plot band is a colored band stretching across the plot
     * area marking an interval on the axis.  Example usage:
     * <code><pre>
     *   XAxis xAxis = chart.getXAxis()
     *     .setPlotBands(
     *       xAxis.createPlotBand()
     *          .setColor("#CC0000")
     *          .setFrom(40)
     *          .setTo(80),
     *       xAxis.createPlotBand()
     *          .setColor("#009900")
     *          .setFrom(90)
     *          .setTo(120),
     *     )
     *   );
     * </pre></code>
     *
     * @param plotBands One or more PlotBand instances that represent the options of each band to render
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     */
    public T setPlotBands(PlotBand... plotBands) {
        return this.setOption("plotBands", plotBands);
    }

    /**
     * Convenience method for setting the 'reversed' option for the axis.  Equivalent to:
     * <pre><code>
     *     axis.setOption("reversed", true);
     * </code></pre>
     * Whether to reverse the axis so that the highest number is closest to origin. If the chart
     * is inverted, the x axis is reversed by default. Defaults to false.
     *
     * @param reversed 'true' to reverse the axis so that the highest number is closest to origin, 'false'
     *                 to show the axis in its default orientation.
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     */
    public T setReversed(boolean reversed) {
        return this.setOption("reversed", reversed);
    }

    /**
     * Convenience method for setting the 'showEmpty' option for the axis.  Equivalent to:
     * <pre><code>
     *     axis.setOption("showEmpty", false);
     * </code></pre>
     * Whether to show the axis line and title when the axis has no data. Defaults to true.
     * @param showEmpty 'true' to show the axis line when the axis has no data (default,) false
     *                  to hide the axis line when the series has no data
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     */
    public T setShowEmpty(boolean showEmpty) {
        return this.setOption("showEmpty", showEmpty);
    }

    /**
     * Convenience method for setting the 'showFirstLabel' option for the axis.  Equivalent to:
     * <pre><code>
     *     axis.setOption("showFirstLabel", false);
     * </code></pre>
     * Whether to show the first tick label. Defaults to true.
     *
     * @param showFirstLabel 'true' to show the first tick label (the default), 'false' to hide it.
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     */
    public T setShowFirstLabel(boolean showFirstLabel) {
        return this.setOption("showFirstLabel", showFirstLabel);
    }

    /**
     * Convenience method for setting the 'showLastLabel' option for the axis.  Equivalent to:
     * <pre><code>
     *     axis.setOption("showLastLabel", true);
     * </code></pre>
     * Whether to show the last tick label. Defaults to false.
     *
     * @param showLastLabel 'true' to show the first tick label, 'false' to hide it (the default).
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     */
    public T setShowLastLabel(boolean showLastLabel) {
        return this.setOption("showLastLabel", showLastLabel);
    }

    /**
     * Convenience method for setting the 'startOfWeek' option for the axis.  Equivalent to:
     * <pre><code>
     *     axis.setOption("startOfWeek", WeekDay.SUNDAY);
     * </code></pre>
     * For datetime axes, this decides where to put the tick between weeks. Defaults to 1 {@link Axis.WeekDay#MONDAY}.
     *
     * @param startOfWeek The day of the week where tick marks should be placed between weeks.
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     */
    public T setStartOfWeek(WeekDay startOfWeek) {
        return this.setOption("startOfWeek", startOfWeek != null ? startOfWeek.toNumber() : null);
    }

    /**
     * Convenience method for setting the 'startOnTick' option for the axis.  Equivalent to:
     * <pre><code>
     *     axis.setOption("startOnTick", true);
     * </code></pre>
     * Whether to force the axis to start on a tick. Use this option with the
     * {@link #setMaxPadding(Number)} option to control the axis start. Defaults to false.
     *
     * @param startOnTick 'true' to force the axis to start on a tick, 'false' for the default behavior.
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     */
    public T setStartOnTick(boolean startOnTick) {
        return this.setOption("startOnTick", startOnTick);
    }

    /**
     * Convenience method for setting the 'tickColor' option for the axis.  Equivalent to:
     * <pre><code>
     *     axis.setOption("tickColor", "#00CC00");
     * </code></pre>
     * Color for the main tick marks. Defaults to #C0D0E0.
     *
     * @param tickColor The new color for the main tick marks.
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     */
    public T setTickColor(String tickColor) {
        return this.setOption("tickColor", tickColor);
    }

    /**
     * Convenience method for setting the 'tickInterval' option for the axis.  Equivalent to:
     * <pre><code>
     *     axis.setOption("tickInterval", 5);
     * </code></pre>
     * The interval of the tick marks in axis units. When null, the tick interval is computed to
     * approximately follow the tickPixelInterval on linear and datetime axes. On categorized axes, a
     * null tickInterval will default to 1, one category. Note that datetime axes are based on milliseconds,
     * so for example an interval of one day is expressed as 24 * 3600 * 1000. Defaults to null.
     *
     * @param tickInterval The interval of the tick marks in axis units, or null to follow the default interval logic.
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     */
    public T setTickInterval(Number tickInterval) {
        return this.setOption("tickInterval", tickInterval);
    }

    /**
     * Convenience method for setting the 'tickLength' option for the axis.  Equivalent to:
     * <pre><code>
     *     axis.setOption("tickLength", 20);
     * </code></pre>
     * The pixel length of the main tick marks. Defaults to 5.
     *
     * @param tickLength The new pixel length of the main tick marks.
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     */
    public T setTickLength(Number tickLength) {
        return this.setOption("tickLength", tickLength);
    }

    /**
     * Convenience method for setting the 'tickPixelInterval' option for the axis.  Equivalent to:
     * <pre><code>
     *     axis.setOption("tickPixelInterval", 50);
     * </code></pre>
     * If tickInterval is null (the default) this option sets the approximate pixel interval of the tick marks.
     * Not applicable to categorized axis. Defaults to 72 for the Y axis and 100 for the X axis.
     *
     * @param tickPixelInterval The new approximate pixel interval of the tick marks.
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     */
    public T setTickPixelInterval(Number tickPixelInterval) {
        return this.setOption("tickPixelInterval", tickPixelInterval);
    }

    /**
     * Convenience method for setting the 'tickPosition' option for the axis.  Equivalent to:
     * <pre><code>
     *     axis.setOption("tickPosition", TickPosition.INSIDE);
     * </code></pre>
     * The position of the major tick marks relative to the axis line.  Defaults to {@link Axis.TickPosition#OUTSIDE}.
     *
     * @param tickPosition The new position of the major tick marks relative to the axis line.
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     */
    public T setTickPosition(TickPosition tickPosition) {
        return this.setOption("tickPosition", tickPosition != null ? tickPosition.toString() : null);
    }

    /**
     * Convenience method for setting the 'tickWidth' option for the axis.  Equivalent to:
     * <pre><code>
     *     axis.setOption("tickWidth", 10);
     * </code></pre>
     * The pixel width of the major tick marks. Defaults to 1.
     *
     * @param tickWidth The new pixel width of the major tick marks.
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     */
    public T setTickWidth(Number tickWidth) {
        return this.setOption("tickWidth", tickWidth);
    }

    /**
     * Convenience method for setting the 'title/text' axis option, before or after
     * the chart is rendered.  Before the chart is rendered this is equivalent to:
     * <pre><code>
     *     axis.setOption("/title/text", "A Fine Axis Indeed");
     * </code></pre>
     * After the chart is rendered this is equivalent to a direct JS call like
     * <pre><code>
     *     Axis.setTitle({text: "A Fine Axis Indeed"});
     * </code></pre>
     *
     * The actual text of the axis title. It can contain basic HTML text markup like
     * &lt;b&gt;, &lt;i&gt; and spans with style. Defaults to null for the x-axis
     * and "Y-values" for the y-axis.
     * <p/>
     * Note that for more control over the title, utilize the {@link #setAxisTitle(AxisTitle)}
     * method instead.
     * <p/>
     * Also note that to hide an axis title completely, simply set the text to null.
     *
     * @param title Sets the title of axis, or null to hide the title.
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     */
    public T setAxisTitleText(String title) {
        return this.setAxisTitleText(title, true);
    }

    /**
     * Convenience method for setting the 'title/text' axis option, before or after
     * the chart is rendered (explicitly controlling whether or not the new title will
     * be immediately drawn in the case of being called after the chart is rendered).
     * Before the chart is rendered this is equivalent to:
     * <pre><code>
     *     axis.setOption("/title/text", "A Fine Axis Indeed");
     * </code></pre>
     * After the chart is rendered this is equivalent to a JS call like:
     * <pre><code>
     *     Axis.setTitle({text: "A Fine Axis Indeed"}, true);
     * </code></pre>
     *
     * The actual text of the axis title. It can contain basic HTML text markup like
     * &lt;b&gt;, &lt;i&gt; and spans with style. Defaults to null for the x-axis
     * and "Y-values" for the y-axis.
     * <p/>
     * Note that for more control over the title, utilize the {@link #setAxisTitle(AxisTitle)}
     * method instead.
     * <p/>
     * Also note that to hide an axis title completely, simply set the text to null.
     *
     * @param title Sets the title of axis, or null to hide the title.
     * @param redraw Whether to redraw the chart now or hold until the next {@link org.moxieapps.gwt.highcharts.client.BaseChart#redraw()}
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     * @since 1.2.0
     */
    public T setAxisTitleText(String title, boolean redraw) {
        if(getNativeAxis() != null) {
            this.setAxisTitle(new AxisTitle().setText(title), redraw);
        } else {
            this.setOption("/title/text", title);
        }
        return getThis();
    }

    /**
     * Convenience method for setting the 'title/text' axis option, before or after
     * the chart is rendered.  Before the chart is rendered this is equivalent to:
     * <pre><code>
     *     axis.setOption("/title/text", "A Fine Axis Indeed");
     *     axis.setOption("/title/align", AxisTitle.Align.HIGH);
     * </code></pre>
     * After the chart is rendered this is equivalent to a JS call like:
     * <pre><code>
     *     Axis.setTitle({text: "A Fine Axis Indeed", align: "high"});
     * </code></pre>
     * <p/>
     * Note that if you call this method it will overwrite any existing
     * settings that have already been applied to the title (e.g. if you
     * had previously called the {@link #setAxisTitleText(String)} method that change
     * will get overwritten by this call.)
     * <p/>
     * Note that if you only want to change the text of the axis, you can simply
     * use the {@link #setAxisTitleText(String)} method instead.
     *
     * @param title Sets the axis title options, or null to hide the title.
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     */
    public T setAxisTitle(AxisTitle title) {
        return this.setAxisTitle(title, true);
    }

    /**
     * Convenience method for setting the 'title/text' axis option, before or after
     * the chart is rendered (explicitly controlling whether or not the new title will
     * be immediately drawn in the case of being called after the chart is rendered).
     * Before the chart is rendered this is equivalent to:
     * <pre><code>
     *     axis.setOption("/title/text", "A Fine Axis Indeed");
     *     axis.setOption("/title/align", AxisTitle.Align.HIGH);
     * </code></pre>
     * After the chart is rendered this is equivalent to a JS call like:
     * <pre><code>
     *     Axis.setTitle({text: "A Fine Axis Indeed", align: "high"});
     * </code></pre>
     * <p/>
     * Note that if you call this method it will overwrite any existing
     * settings that have already been applied to the title (e.g. if you
     * had previously called the {@link #setAxisTitleText(String)} method that change
     * will get overwritten by this call.)
     * <p/>
     * Note that if you only want to change the text of the axis, you can simply
     * use the {@link #setAxisTitleText(String)} method instead.
     *
     * @param title Sets the axis title options, or null to hide the title.
     * @param redraw Whether to redraw the chart now or hold until the next {@link org.moxieapps.gwt.highcharts.client.BaseChart#redraw()}
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     * @since 1.2.0
     */
    public T setAxisTitle(AxisTitle title, boolean redraw) {
        if(getNativeAxis() != null) {
            nativeSetTitle(getNativeAxis(), title != null ? title.getOptions().getJavaScriptObject() : null, redraw);
        }
        return this.setOption("/title", title != null ? title.getOptions() : null);
    }

    /**
     * Convenience method for setting the 'type' axis option.  Equivalent to:
     * <pre><code>
     *     axis.setOption("type", Axis.Type.DATE_TIME);
     * </code></pre>
     * The type of axis. Can be one of "linear" or "datetime". In a datetime axis, the numbers are
     * given in milliseconds, and tick marks are placed on appropriate values like full hours or days.
     * Defaults to {@link Axis.Type#LINEAR}.
     *
     * @param type Sets the type of axis.
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     */
    public T setType(Type type) {
        return this.setOption("type", type != null ? type.toString() : null);
    }

    /**
     * Allows plot lines to be added to an axis after the chart is rendered.  If you want to add
     * plot lines to chart before it is rendered, please utilize the {@link #setPlotLines(PlotLine...)}
     * method instead.
     *
     * @param plotLines One or more PlotLine instances that represent the options of each line to render
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     * @since 1.1.3
     */
    public T addPlotLines(PlotLine... plotLines) {
        if (getNativeAxis() != null) {
            for (PlotLine plotLine : plotLines) {
                nativeAddPlotLine(getNativeAxis(), plotLine.getOptions().getJavaScriptObject());
            }
        } else {
            setPlotLines(plotLines);
        }
        return getThis();
    }

    /**
     * Allows plot bands to be added to an axis after the chart is rendered.  If you want to add
     * plot bands to chart before it is rendered, please utilize the {@link #setPlotBands(PlotBand...)}
     * method instead.
     *
     * @param plotBands One or more PlotBand instances that represent the options of each band to render
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     * @since 1.1.3
     */
    public T addPlotBands(PlotBand... plotBands) {
        if (getNativeAxis() != null) {
            for (PlotBand plotBand : plotBands) {
                nativeAddPlotBand(getNativeAxis(), plotBand.getOptions().getJavaScriptObject());
            }
        } else {
            setPlotBands(plotBands);
        }
        return getThis();
    }

    /**
     * Remove the given plot line from the chart after it has been rendered, automatically
     * redrawing the chart after the plot line has been removed.
     *
     * @param plotLine The PlotLine instance to remove from the chart.
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     * @since 1.1.3
     */
    public T removePlotLine(PlotLine plotLine) {
        if (getNativeAxis() != null) {
            nativeRemovePlotLine(getNativeAxis(), plotLine.getId());
        } else {
            // TODO: Add support for removing a plot line for the set before the chart is rendered
        }
        return getThis();
    }

    /**
     * Remove the given plot band from the chart after it has been rendered, automatically
     * redrawing the chart after the plot band has been removed.
     *
     * @param plotBand The PlotBand instance to remove from the chart.
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     * @since 1.1.3
     */
    public T removePlotBand(PlotBand plotBand) {
        if (getNativeAxis() != null) {
            nativeRemovePlotBand(getNativeAxis(), plotBand.getId());
        } else {
            // TODO: Add support for removing a plot band for the set before the chart is rendered
        }
        return getThis();
    }

    /**
     * Update an axis object with a new set of options. The options are merged with the existing options, so only new
     * or altered options need to be specified.
     * @param axisOptions The new options that will be merged in with existing options on the axis.
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     * @since 1.6.1
     */
    public T update(Axis axisOptions) {
        return this.update(axisOptions, true);
    }

    /**
     * Update an axis object with a new set of options. The options are merged with the existing options, so only new
     * or altered options need to be specified.
     * @param axisOptions The new options that will be merged in with existing options on the axis.
     * @param redraw Defaults to true. Whether to redraw the chart after the new options are set.
     * @return A reference to this {@link Axis} instance for convenient method chaining.
     * @since 1.6.1
     */
    public T update(Axis axisOptions, boolean redraw) {
        JavaScriptObject nativeAxis = getNativeAxis();
        if (nativeAxis != null) {
            nativeUpdateAxis(nativeAxis, convertAxisToJavaScriptObject(axisOptions), redraw);
        }
        return getThis();
    }

    private JavaScriptObject convertAxisToJavaScriptObject(Axis axis) {
        final JSONObject options = axis.getOptions() != null ? axis.getOptions() : new JSONObject();
        return options.getJavaScriptObject();
    }

    // Handle the unchecked cast limitation with generics in one place
    private T getThis() {
        @SuppressWarnings({"unchecked", "UnnecessaryLocalVariable"})
        final T instance = (T) this;
        return instance;
    }

    private static native void nativeSetExtremes(JavaScriptObject axis, double min, double max, boolean redraw, boolean animation) /*-{
        axis.setExtremes(min, max, redraw, animation);
    }-*/;

    private static native void nativeSetExtremes(JavaScriptObject axis, double min, double max, boolean redraw, JavaScriptObject animationOptions) /*-{
        axis.setExtremes(min, max, redraw, animationOptions);
    }-*/;

    private static native JavaScriptObject nativeGetExtremes(JavaScriptObject axis) /*-{
        return axis.getExtremes();
    }-*/;

    private native void nativeAddPlotLine(JavaScriptObject axis, JavaScriptObject plotLineOptions)/*-{
        axis.addPlotLine(plotLineOptions);
    }-*/;

    private native void nativeAddPlotBand(JavaScriptObject axis, JavaScriptObject plotBandOptions)/*-{
        axis.addPlotBand(plotBandOptions);
    }-*/;

    private native void nativeRemovePlotLine(JavaScriptObject axis, String id)/*-{
        axis.removePlotLine(id);
    }-*/;

    private native void nativeRemovePlotBand(JavaScriptObject axis, String id)/*-{
        axis.removePlotBand(id);
    }-*/;

    private native void nativeSetTitle(JavaScriptObject axis, JavaScriptObject titleOptions, boolean redraw)/*-{
        axis.setTitle(titleOptions, redraw);
    }-*/;

    private native void nativeUpdateAxis(JavaScriptObject axis, JavaScriptObject axisOptions, boolean redraw) /*-{
        axis.update(axisOptions, redraw);
    }-*/;
}
