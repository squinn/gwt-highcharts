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

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONString;
import org.moxieapps.gwt.highcharts.client.labels.XAxisLabels;

/**
 * Provides access to an object that can be used to configure and manage the color axis of the chart.
 *
 * Visually, the color axis will appear as a gradient or as separate items inside the legend, depending on whether the
 * axis is scalar or based on data classes..
 *
 * A scalar color axis is represented by a gradient. The colors either range between the minColor and the maxColor, or
 * for more fine grained control the colors can be defined in stops. Often times, the color axis needs to be adjusted
 * to get the right color spread for the data. In addition to stops, consider using a logarithmic axis type, or setting
 * min and max to avoid the colors being determined by outliers.
 *
 * When dataClasses are used, the ranges are subdivided into separate classes like categories based on their values.
 * This can be used for ranges between two values, but also for a true category. However, when your data is categorized,
 * it may be as convenient to add each category to a separate series.
 *
 *
 * @author cskowron@moxiegroup.com (Cory Skowronek)
 * @since 1.7.0
 */
public class ColorAxis extends Configurable<ColorAxis> {

    public enum DataClassColor {
        /**
         * Pull colors from the global or chart-specific color array
         */
        CATEGORY("category"),

        /**
         * Compute intermediate colors between 'minColor' and 'maxColor'
         */
        TWEEN("tween");

        private DataClassColor(String optionValue) {
            this.optionValue = optionValue;
        }

        private final String optionValue;

        public String toString() {
            return optionValue;
        }
    }

    public enum TickPosition {

        /**
         * Position the minor tick to the inside of the axis line
         */
        INSIDE("inside"),

        /**
         * Position the minor tick to the outside of the axis line
         */
        OUTSIDE("outside");

        private TickPosition(String optionValue) {
            this.optionValue = optionValue;
        }

        private  final String optionValue;

        public String toString() {
            return optionValue;
        }
    }

    private XAxisLabels colorAxisLabels;

    /**
     * Convenience method for setting the 'colorAxis' option of the map.  Equivalent to:
     * <pre><code>
     *     colorAxis.setOption("dataClassColor", "category");
     * </code></pre>
     *
     * Determines how to set each data class' color if no individual color is set. The default value, tween, computes
     * intermediate colors between minColor and maxColor. The other possible value, category, pulls colors from the
     * global or chart specific colors array. Defaults to tween.
     *
     * @param dataClassColor Determines how to set each dataClass' color
     * @return A reference to this {@link ColorAxis} instance for convenient method chaining.
     */
    public ColorAxis setDataClassColor(DataClassColor dataClassColor) {
        return this.setOption("dataClassColor", dataClassColor != null ? dataClassColor.optionValue : null);
    }

//    public ColorAxis setDataClasses() {
//
//    }

    /**
     * Convenience method for setting the 'endOnTick' option of the map.  Equivalent to:
     * <pre><code>
     *     colorAxis.setOption("endOnTick", );
     * </code></pre>
     * Whether to force the axis to end on a tick. Use this option with the maxPadding option to control the axis end. Defaults to true.
     * @param endOnTick Whether to force the axis to end on a tick
     * @return A reference to this {@link ColorAxis} instance for convenient method chaining.
     */
    public ColorAxis setEndOnTick(Boolean endOnTick) {
        return this.setOption("endOnTick", endOnTick);
    }

    /**
     * Convenience method for setting the 'gridLineColor' option of the map.  Equivalent to:
     * <pre><code>
     *     colorAxis.setOption("gridLineColor", );
     * </code></pre>
     * Color of the grid lines extending from the axis across the gradient. Defaults to #C0C0C0.
     * @param gridLineColor Color of the grid lines
     * @return A reference to this {@link ColorAxis} instance for convenient method chaining.
     */
    public ColorAxis setGridLineColor(Color gridLineColor) {
        return this.setOption("gridLineColor", gridLineColor != null ? gridLineColor.getOptionValue() : null);
    }

    /**
     * Convenience method for setting the 'gridLineColor' option of the map.  Equivalent to:
     * <pre><code>
     *     colorAxis.setOption("gridLineColor", );
     * </code></pre>
     * Color of the grid lines extending from the axis across the gradient. Defaults to #C0C0C0.
     * @param gridLineColor Color of the grid lines.
     * @return A reference to this {@link ColorAxis} instance for convenient method chaining.
     */
    public ColorAxis setGridLineColor(String gridLineColor) {
        return this.setOption("gridLineColor", gridLineColor);
    }

    /**
     * Convenience method for setting the 'gridLineDashStyle' option of the map.  Equivalent to:
     * <pre><code>
     *     colorAxis.setOption("gridLineDashStyle", );
     * </code></pre>
     * The dash or dot style of the grid lines. For possible values, see this demonstration. Defaults to Solid.
     * @param gridLineDashStyle The dash or dot style of the grid lines.
     * @return A reference to this {@link ColorAxis} instance for convenient method chaining.
     */
    public ColorAxis setGridLineDashStyle(PlotLine.DashStyle gridLineDashStyle) {
        return this.setOption("gridLineDashStyle", gridLineDashStyle != null ? gridLineDashStyle.toString() : null);
    }

    /**
     * Convenience method for setting the 'gridLineWidth' option of the map.  Equivalent to:
     * <pre><code>
     *     colorAxis.setOption("gridLineWidth", );
     * </code></pre>
     * The width of the grid lines extending from the axis across the gradient of a scalar color axis. Defaults to 1.
     * @param gridLineWidth The width of the grid lines.
     * @return A reference to this {@link ColorAxis} instance for convenient method chaining.
     */
    public ColorAxis setGridLineWidth(Number gridLineWidth) {
        return this.setOption("colorWidth", gridLineWidth);
    }

    /**
     * Convenience method for setting the 'id' option of the map.  Equivalent to:
     * <pre><code>
     *     colorAxis.setOption("id", );
     * </code></pre>
     * An id for the axis. This can be used after render time to get a pointer to the axis object through chart.get().
     * @param id An id for the axis.
     * @return A reference to this {@link ColorAxis} instance for convenient method chaining.
     */
    public ColorAxis setId(String id) {
        return this.setOption("id", id);
    }

    /**
     * Convenience method for setting the 'labels' option of the map.  Equivalent to:
     * <pre><code>
     *     colorAxis.setOption("labels", );
     * </code></pre>
     * The axis labels show the number for each tick.
     * @param labels The axis labels show the number for each tick.
     * @return A reference to this {@link ColorAxis} instance for convenient method chaining.
     * @see XAxisLabels
     */
    public ColorAxis setLabels(XAxisLabels labels) {
        this.colorAxisLabels = labels;
        return this.setOption("labels", labels != null ? labels.getOptions() : null);
    }

    /**
     * Convenience method for setting the 'lineColor' option of the map.  Equivalent to:
     * <pre><code>
     *     colorAxis.setOption("lineColor", );
     * </code></pre>
     * The color of the line marking the axis itself. Defaults to #C0D0E0.
     * @param lineColor The color of the line marking the axis.
     * @return A reference to this {@link ColorAxis} instance for convenient method chaining.
     */
    public ColorAxis setLineColor(Color lineColor) {
        return this.setOption("color", lineColor != null ? lineColor.getOptionValue() : null);
    }

    /**
     * Convenience method for setting the 'lineColor' option of the map.  Equivalent to:
     * <pre><code>
     *     colorAxis.setOption("lineColor", );
     * </code></pre>
     * The color of the line marking the axis itself. Defaults to #C0D0E0.
     * @param lineColor The color of the line marking the axis itself.
     * @return A reference to this {@link ColorAxis} instance for convenient method chaining.
     */
    public ColorAxis setLineColor(String lineColor) {
        return this.setOption("color", lineColor);
    }

    /**
     * Convenience method for setting the 'lineWidth' option of the map.  Equivalent to:
     * <pre><code>
     *     colorAxis.setOption("lineWidth", );
     * </code></pre>
     * The width of the line marking the axis itself. Defaults to 0.
     * @param lineWidth The width of the line marking the axis itself.
     * @return A reference to this {@link ColorAxis} instance for convenient method chaining.
     */
    public ColorAxis setLineWidth(Number lineWidth) {
        return this.setOption("lineWidth", lineWidth);
    }

    /**
     * Convenience method for setting the 'markerAnimation' option of the map.  Equivalent to:
     * <pre><code>
     *     colorAxis.setOption("marker/animation", );
     * </code></pre>
     * Animation for the marker as it moves between values. Set to false to disable animation.
     * Defaults to { duration: 50 }
     * @param markerAnimation An instance of the {@link Animation} class which provides specific options for
     *                        configuring the animation
     * @return A reference to this {@link ColorAxis} instance for convenient method chaining.
     */
    public ColorAxis setMarkerAnimation(Animation markerAnimation) {
        return this.setOption("marker/animation", markerAnimation != null ? markerAnimation.getOptions() :null);
    }

    /**
     * Convenience method for setting the 'markerAnimation' option of the map.  Equivalent to:
     * <pre><code>
     *     colorAxis.setOption("marker/animation", true);
     * </code></pre>
     * Animation for the marker as it moves between values. Set to false to disable animation.
     * Defaults to { duration: 50 }.
     * @param markerAnimation Whether to allow or disable animations in color axis.
     * @return A reference to this {@link ColorAxis} instance for convenient method chaining.
     */
    public ColorAxis setMarkerAnimation(boolean markerAnimation) {
        return this.setOption("marker/animation", markerAnimation);
    }

    /**
     * Convenience method for setting the 'markerAnimation' option of the map.  Equivalent to:
     * <pre><code>
     *     colorAxis.setOption("marker/color", );
     * </code></pre>
     * The color of the marker. Defaults to gray
     * @param color An instance of the {@link Color} class which provides specific options for setting the
     *              color of the marker.
     * @return A reference to this {@link ColorAxis} instance for convenient method chaining.
     */
    public ColorAxis setMarkerColor(Color color) {
        return this.setOption("marker/color", color != null ? color.getOptionValue() : null);
    }

    /**
     * Convenience method for setting the 'max' option of the map.  Equivalent to:
     * <pre><code>
     *     colorAxis.setOption("max", );
     * </code></pre>
     * The maximum value of the axis in terms of map point values. If null, the max value is automatically calculated.
     * If the endOnTick option is true, the max value might be rounded up.
     * @param max The maximum value of the axis.
     * @return A reference to this {@link ColorAxis} instance for convenient method chaining.
     */
    public ColorAxis setMax(Number max) {
        return this.setOption("max", max);
    }

    /**
     * Convenience method for setting the 'maxColor' option of the map.  Equivalent to:
     * <pre><code>
     *     colorAxis.setOption("maxColor", );
     * </code></pre>
     * The color to represent the maximum of the color axis. Unless dataClasses or stops are set, the gradient ends
     * at this value.  If dataClasses are set, the color is based on minColor and maxColor unless a color is set for
     * each data class, or the dataClassColor is set.  Defaults to #102D4C.
     * @param maxColor The color to represent the maximum of the color axis.
     * @return A reference to this {@link ColorAxis} instance for convenient method chaining.
     */
    public ColorAxis setMaxColor(Color maxColor) {
        return this.setOption("maxColor", maxColor !=  null ? maxColor.getOptionValue() : null);
    }

    /**
     * Convenience method for setting the 'maxColor' option of the map.  Equivalent to:
     * <pre><code>
     *     colorAxis.setOption("maxColor", );
     * </code></pre>
     * The color to represent the maximum of the color axis. Unless dataClasses or stops are set, the gradient ends
     * at this value.  If dataClasses are set, the color is based on minColor and maxColor unless a color is set for
     * each data class, or the dataClassColor is set.  Defaults to #102D4C.
     * @param maxColor The color to represent the maximum of the color axis.
     * @return A reference to this {@link ColorAxis} instance for convenient method chaining.
     */
    public ColorAxis setMaxColor(String maxColor) {
        return this.setOption("maxColor", maxColor);
    }

    /**
     * Convenience method for setting the 'maxPadding' option of the map.  Equivalent to:
     * <pre><code>
     *     colorAxis.setOption("maxPadding", );
     * </code></pre>
     * Padding of the max value relative to the length of the axis. A padding of 0.05 will make a 100px axis 5px longer.
     * Defaults to 0.05.
     * @param maxPadding Padding of the max value relative to the length of the axis.
     * @return A reference to this {@link ColorAxis} instance for convenient method chaining.
     */
    public ColorAxis setMaxPadding(Number maxPadding) {
        return this.setOption("maxPadding", maxPadding);
    }

    /**
     * Convenience method for setting the '' option of the map.  Equivalent to:
     * <pre><code>
     *     colorAxis.setOption("", );
     * </code></pre>
     * The minimum value of the axis in terms of map point values. If null, the min value is automatically calculated.
     * If the startOnTick option is true, the min value might be rounded down.
     * @param min The minimum value of the axis.
     * @return A reference to this {@link ColorAxis} instance for convenient method chaining.
     */
    public ColorAxis setMin(Number min) {
        return this.setOption("min", min);
    }

    /**
     * Convenience method for setting the 'minColor' option of the map.  Equivalent to:
     * <pre><code>
     *     colorAxis.setOption("minColor", );
     * </code></pre>
     * The color to represent the minimum of the color axis. Unless dataClasses or stops are set, the gradient starts
     * at this value.  If dataClasses are set, the color is based on minColor and maxColor unless a color is set for
     * each data class, or the dataClassColor is set.  Defaults to #EFEFFF.
     * @param minColor The color to represent the minimum of the color axis.
     * @return A reference to this {@link ColorAxis} instance for convenient method chaining.
     */
    public ColorAxis setMinColor(Color minColor) {
        return this.setOption("minColor", minColor != null ? minColor.getOptionValue() : null);
    }

    /**
     * Convenience method for setting the 'minColor' option of the map.  Equivalent to:
     * <pre><code>
     *     colorAxis.setOption("minColor", );
     * </code></pre>
     * The color to represent the minimum of the color axis. Unless dataClasses or stops are set, the gradient starts
     * at this value.  If dataClasses are set, the color is based on minColor and maxColor unless a color is set for
     * each data class, or the dataClassColor is set.  Defaults to #EFEFFF.
     * @param minColor The color to represent the minimum of the color axis.
     * @return A reference to this {@link ColorAxis} instance for convenient method chaining.
     */
    public ColorAxis setMinColor(String minColor) {
        return this.setOption("minColor", minColor);
    }

    /**
     * Convenience method for setting the 'minPadding' option of the map.  Equivalent to:
     * <pre><code>
     *     colorAxis.setOption("minPadding", );
     * </code></pre>
     * Padding of the min value relative to the length of the axis. A padding of 0.05 will make a 100px axis 5px longer.
     * Defaults to 0.05.
     * @param minPadding Padding of the min value relative to the length of the axis.
     * @return A reference to this {@link ColorAxis} instance for convenient method chaining.
     */
    public ColorAxis setMinPadding(Number minPadding) {
        return this.setOption("minPadding", minPadding);
    }

    /**
     * Convenience method for setting the 'minorGridLineColor' option of the map.  Equivalent to:
     * <pre><code>
     *     colorAxis.setOption("minorGridLineColor", );
     * </code></pre>
     * Color of the minor, secondary grid lines. Defaults to #E0E0E0.
     * @param minorGridLineColor Color of the minor grid lines.
     * @return A reference to this {@link ColorAxis} instance for convenient method chaining.
     */
    public ColorAxis setMinorGridLineColor(Color minorGridLineColor) {
        return this.setOption("minorGridLineColor", minorGridLineColor != null ? minorGridLineColor.getOptionValue() : null);
    }

    /**
     * Convenience method for setting the 'minorGridLineColor' option of the map.  Equivalent to:
     * <pre><code>
     *     colorAxis.setOption("minorGridLineColor", );
     * </code></pre>
     * Color of the minor, secondary grid lines. Defaults to #E0E0E0.
     * @param minorGridLineColor Color of the minor grid lines.
     * @return A reference to this {@link ColorAxis} instance for convenient method chaining.
     */
    public ColorAxis setMinorGridLineColor(String minorGridLineColor) {
        return this.setOption("minorGridLineColor", minorGridLineColor);
    }

    /**
     * Convenience method for setting the 'minorGridLineDashStyle' option of the map.  Equivalent to:
     * <pre><code>
     *     colorAxis.setOption("minorGridLineDashStyle", );
     * </code></pre>
     * The dash or dot style of the minor grid lines. For possible values, see this demonstration. Defaults to Solid.
     * @param minorGridLineDashStyle The style of the grid lines.
     * @return A reference to this {@link ColorAxis} instance for convenient method chaining.
     */
    public ColorAxis setMinorGridLineDashStyle(PlotLine.DashStyle minorGridLineDashStyle) {
        return this.setOption("minorGridLineDashStyle", minorGridLineDashStyle != null ? minorGridLineDashStyle.toString(): null);
    }

    /**
     * Convenience method for setting the 'minorGridLineWidth' option of the map.  Equivalent to:
     * <pre><code>
     *     colorAxis.setOption("minorGridLineWidth", );
     * </code></pre>
     * Width of the minor, secondary grid lines. Defaults to 1.
     * @param minorGridLineWidth Width of the minor grid lines.
     * @return A reference to this {@link ColorAxis} instance for convenient method chaining.
     */
    public ColorAxis setMinorGridLineWidth(Number minorGridLineWidth) {
        return this.setOption("minorGridLineWidth", minorGridLineWidth);
    }

    /**
     * Convenience method for setting the 'minorTickColor' option of the map.  Equivalent to:
     * <pre><code>
     *     colorAxis.setOption("minorTickColor", );
     * </code></pre>
     * Color for the minor tick marks. Defaults to #A0A0A0.
     * @param minorTickColor Color for the minor tick marks.
     * @return A reference to this {@link ColorAxis} instance for convenient method chaining.
     */
    public ColorAxis setMinorTickColor(Color minorTickColor) {
        return this.setOption("minorTickColor", minorTickColor != null ? minorTickColor.getOptionValue() : null);
    }

    /**
     * Convenience method for setting the 'minorTickColor' option of the map.  Equivalent to:
     * <pre><code>
     *     colorAxis.setOption("minorTickColor", );
     * </code></pre>
     * Color for the minor tick marks. Defaults to #A0A0A0.
     * @param minorTickColor Color for the minor tick marks.
     * @return A reference to this {@link ColorAxis} instance for convenient method chaining.
     */
    public ColorAxis setMinorTickColor(String minorTickColor) {
        return this.setOption("minorTickColor", minorTickColor);
    }

    /**
     * Convenience method for setting the 'minorTickInterval' option of the map.  Equivalent to:
     * <pre><code>
     *     colorAxis.setOption("minorTickInterval", );
     * </code></pre>
     * Tick interval in scale units for the minor ticks. On a linear axis, if "auto", the minor tick interval is
     * calculated as a fifth of the tickInterval. If null, minor ticks are not shown.  On logarithmic axes, the unit
     * is the power of the value. For example, setting the minorTickInterval to 1 puts one tick on each of 0.1, 1, 10,
     * 100 etc. Setting the minorTickInterval to 0.1 produces 9 ticks between 1 and 10, 10 and 100 etc.
     * A minorTickInterval of "auto" on a log axis results in a best guess, attempting to enter approximately 5 minor
     * ticks between each major tick.
     * @param minorTickInterval Tick interval in scale units for the minor ticks.
     * @return A reference to this {@link ColorAxis} instance for convenient method chaining.
     */
    public ColorAxis setMinorTickInterval(Number minorTickInterval) {
        return this.setOption("minorTickInterval", minorTickInterval);
    }

    /**
     * Convenience method for setting the 'minorTickInterval' option of the map.  Equivalent to:
     * <pre><code>
     *     colorAxis.setOption("minorTickInterval", );
     * </code></pre>
     * Tick interval in scale units for the minor ticks. On a linear axis, if "auto", the minor tick interval is
     * calculated as a fifth of the tickInterval. If null, minor ticks are not shown.  On logarithmic axes, the unit
     * is the power of the value. For example, setting the minorTickInterval to 1 puts one tick on each of 0.1, 1, 10,
     * 100 etc. Setting the minorTickInterval to 0.1 produces 9 ticks between 1 and 10, 10 and 100 etc.
     * A minorTickInterval of "auto" on a log axis results in a best guess, attempting to enter approximately 5 minor
     * ticks between each major tick.
     * @param minorTickInterval Tick interval in scale units for the minor ticks.
     * @return A reference to this {@link ColorAxis} instance for convenient method chaining.
     */
    public ColorAxis setMinorTickInterval(String minorTickInterval) {
        return this.setOption("minorTickInterval", minorTickInterval);
    }

    /**
     * Convenience method for setting the 'minorTickLength' option of the map.  Equivalent to:
     * <pre><code>
     *     colorAxis.setOption("minorTickLength", );
     * </code></pre>
     * The pixel length of the minor tick marks. Defaults to 2.
     * @param minorTickLength The pixel length of the minor tick marks
     * @return A reference to this {@link ColorAxis} instance for convenient method chaining.
     */
    public ColorAxis setMinorTickLength(Number minorTickLength) {
        return this.setOption("minorTickLength", minorTickLength);
    }

    /**
     * Convenience method for setting the 'minorTickPosition' option of the colorAxis.  Equivalent to:
     * <pre><code>
     *     colorAxis.setOption("minortickPosition", "inside");
     * </code></pre>
     * The position of the minor tick marks relative to the axis line. Can be one of inside and outside.
     * Defaults to outside.
     * @param minorTickPosition The position of the minor tick marks relative to the axis line.
     * @return A reference to this {@link ColorAxis} instance for convenient method chaining.
     */
    public ColorAxis setMinorTickPosition(TickPosition minorTickPosition) {
        return this.setOption("minorTickPosition", minorTickPosition != null ? minorTickPosition.toString() : null);
    }



    /**
     * Convenience method for setting the 'minorTickWidth' option of the map.  Equivalent to:
     * <pre><code>
     *     colorAxis.setOption("minorTickWidth", );
     * </code></pre>
     * The pixel width of the minor tick mark. Defaults to 0.
     * @param minorTickWidth The pixel width of the minor tick mark.
     * @return A reference to this {@link ColorAxis} instance for convenient method chaining.
     */
    public ColorAxis setMinorTickWidth(Number minorTickWidth) {
        return this.setOption("minorTickWidth", minorTickWidth);
    }

    /**
     * Convenience method for setting the 'reversed' option of the map.  Equivalent to:
     * <pre><code>
     *     colorAxis.setOption("reversed", );
     * </code></pre>
     * Whether to reverse the axis so that the highest number is closest to the origin. Defaults to false in a
     * horizontal legend and true in a vertical legend, where the smallest value starts on top.
     * @param reversed Whether to reverse the axis.
     * @return A reference to this {@link ColorAxis} instance for convenient method chaining.
     */
    public ColorAxis setReversed(Boolean reversed)  {
        return this.setOption("reversed", reversed);
    }

    /**
     * Convenience method for setting the 'showFirstLabel' option of the map.  Equivalent to:
     * <pre><code>
     *     colorAxis.setOption("showFirstLabel", );
     * </code></pre>
     * If labels are enabled, whether to show the first tick label. Defaults to true.
     * @param showFirstLabel Whether to show the first tick label.
     * @return A reference to this {@link ColorAxis} instance for convenient method chaining.
     */
    public ColorAxis setShowFirstLabel(Boolean showFirstLabel) {
        return this.setOption("showFirstLabel", showFirstLabel);
    }

    /**
     * Convenience method for setting the 'showLastLabel' option of the map.  Equivalent to:
     * <pre><code>
     *     colorAxis.setOption("showLastLabel", );
     * </code></pre>
     * If labels are enabled, whether to show the last tick label. Defaults to true.
     * @param showLastLabel Whether to show the last tick label
     * @return A reference to this {@link ColorAxis} instance for convenient method chaining.
     */
    public ColorAxis setShowLastLabel(Boolean showLastLabel) {
        return this.setOption("showLastLabel", showLastLabel);
    }

    /**
     * Convenience method for setting the 'startOnTick' option of the map.  Equivalent to:
     * <pre><code>
     *     colorAxis.setOption("startOnTick", );
     * </code></pre>
     * Whether to force the axis to start on a tick. Use this option with the maxPadding option to control the
     * axis start. Defaults to true.
     * @param startOnTick Whether to force the axis to start on a tick.
     * @return A reference to this {@link ColorAxis} instance for convenient method chaining.
     */
    public ColorAxis setStartOnTick(Boolean startOnTick) {
        return this.setOption("startOnTick", startOnTick);
    }

    /**
     * Convenience method for setting the 'stops' option of the map.  Sample Usage:
     * <pre><code>
     *     colorAxis.setStops(
     *          ColorAxis.addStop(0, "#FF0000"),
     *          ColorAxis.addStop(.5, "#FFFFFF"),
     *          ColorAxis.addStop(.9, "#0000FF")
            ));
     * </code></pre>
     * Color stops for the gradient of a scalar color axis. Use this in cases where a linear gradient between a minColor
     * and maxColor is not sufficient. The stops is an array of tuples, where the first item is a float between 0 and 1
     * assigning the relative position in the gradient, and the second item is the color.
     * @param stops An array of tuples where the first item is a float between 0 and 1 assigning the relative position
     *              in the gradient, and the second item is the color.
     * @return A reference to this {@link ColorAxis} instance for convenient method chaining.
     * @see ColorAxis#addStop(Number, String)
     */
    public ColorAxis setStops(JSONArray... stops){
        return this.setOption("stops", stops);
    }

    /**
     * Convenience method for adding stops along the 'colorAxis' of a chart.  Note that this method is intended for
     * use in conjunction with the {@link ColorAxis#setStops(com.google.gwt.json.client.JSONArray...)} method.
     * @param stopNumber The relative position in the gradient.
     * @param stopColor The color
     * @return A tuple containing the stop number and stop color.
     * @see ColorAxis#setStops(com.google.gwt.json.client.JSONArray...)
     */
    public static JSONArray addStop(Number stopNumber, String stopColor) {
        JSONArray stop = new JSONArray();
        stop.set(0, new JSONNumber(stopNumber.doubleValue()));
        stop.set(1, new JSONString(stopColor));
        return stop;
    }


    /**
     * Convenience method for setting the 'tickColor' option of the map.  Equivalent to:
     * <pre><code>
     *     colorAxis.setOption("tickColor", new Color());
     * </code></pre>
     * Color for the main tick marks. Defaults to #C0D0E0.
     * @param tickColor Color for the main tick marks.
     * @return A reference to this {@link ColorAxis} instance for convenient method chaining.
     */
    public ColorAxis setTickColor(Color tickColor) {
        return this.setOption("tickColor", tickColor != null ? tickColor.getOptionValue() : null);
    }

    /**
     * Convenience method for setting the 'tickColor' option of the map.  Equivalent to:
     * <pre><code>
     *     colorAxis.setOption("tickColor", "#A0A0A0");
     * </code></pre>
     * Color for the main tick marks. Defaults to #C0D0E0.
     * @param tickColor Color for the main tick marks.
     * @return A reference to this {@link ColorAxis} instance for convenient method chaining.
     */
    public ColorAxis setTickColor(String tickColor) {
        return this.setOption("tickcolor", tickColor);
    }

    /**
     * Convenience method for setting the 'tickInterval' option of the map.  Equivalent to:
     * <pre><code>
     *     colorAxis.setOption("tickInterval", 12);
     * </code></pre>
     * If tickInterval is null this option sets the approximate pixel interval of the tick marks. Defaults to 72.
     * @param tickInterval The approximate pixel interval of the tick marks
     * @return A reference to this {@link ColorAxis} instance for convenient method chaining.
     */
    public ColorAxis setTickInterval(Number tickInterval) {
        return this.setOption("tickInterval", tickInterval);
    }

    /**
     * Convenience method for setting the 'tickLength' option of the map.  Equivalent to:
     * <pre><code>
     *     colorAxis.setOption("tickLength", 6);
     * </code></pre>
     * The pixel length of the main tick marks. Defaults to 10.
     * @param tickLength The pixel length of the main tick marks
     * @return A reference to this {@link ColorAxis} instance for convenient method chaining.
     */
    public ColorAxis setTickLength(Number tickLength) {
        return this.setOption("tickLangth", tickLength);
    }

    /**
     * Convenience method for setting the 'tickPixelInterval' option of the map.  Equivalent to:
     * <pre><code>
     *     colorAxis.setOption("tickPixelInterval", 28);
     * </code></pre>
     * If tickInterval is null this option sets the approximate pixel interval of the tick marks. Defaults to 72.
     * @param tickPixelInterval Tthe approximate pixel interval of the tick marks.
     * @return A reference to this {@link ColorAxis} instance for convenient method chaining.
     */
    public ColorAxis setTickPixelInterval(Number tickPixelInterval) {
        return this.setOption("tickPixelInterval", tickPixelInterval);
    }

    /**
     * Convenience method for setting the 'tickPosition' option of the color axis.  Equivalent to:
     * <pre><code>
     *     colorAxis.setOption("tickPosition", "inside"):
     * </code></pre>
     * The position of the major tick marks relative to the axis line. Can be one of inside and outside.
     * Defaults to outside.
     * @param tickPosition The position of the major tick marks
     * @return A reference to this {@link ColorAxis} instance for convenient method chaining.
     */
    public ColorAxis setTickPosition(TickPosition tickPosition) {
        return this.setOption("tickPosition", tickPosition != null ? tickPosition.toString() : null);
    }

    // TODO implement tickPositioner
    // TODO implement tickPositions

    /**
     * Convenience method for setting the 'tickWidth' option of the map.  Equivalent to:
     * <pre><code>
     *     colorAxis.setOption("tickWidth", 6);
     * </code></pre>
     * The pixel width of the major tick marks. Defaults to 0.
     * @param tickWidth The number of pixels a tick is wide.
     * @return A reference to this {@link ColorAxis} instance for convenient method chaining.
     */
    public ColorAxis setTickWidth(Number tickWidth) {
        return this.setOption("tickWidth", tickWidth);
    }
}
