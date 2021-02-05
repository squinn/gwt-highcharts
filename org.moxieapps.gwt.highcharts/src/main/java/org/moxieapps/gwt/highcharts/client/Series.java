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

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.Document;
import com.google.gwt.json.client.*;
import org.moxieapps.gwt.highcharts.client.plotOptions.PlotOptions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Manages a data series (and its options) that can then be added to a {@link org.moxieapps.gwt.highcharts.client.Chart}.  As an extension
 * of {@link org.moxieapps.gwt.highcharts.client.Configurable} each series instance can also optionally have configuration options set on it.
 * In order to create a new series, utilize the {@link org.moxieapps.gwt.highcharts.client.Chart#createSeries()} method, configure it, add data
 * to it, and then add it to the chart via the {@link org.moxieapps.gwt.highcharts.client.Chart#addSeries(org.moxieapps.gwt.highcharts.client.Series)} method.  Note that a series
 * can be modified after the chart has been rendered as well, which allows for support of dynamic charts or series
 * that change in some way based on user behavior.  Simple example of setting up a series on a chart:
 * <code><pre>
 * Series series = chart.createSeries()
 *   .setName("Random Stuff")
 *   .addPoint(40)
 *   .addPoint(35)
 *   .addPoint(60);
 * chart.addSeries(series);
 * </pre></code>
 * Example of updating all of the points in a series at once:
 * <code><pre>
 * chart.addSeries(chart.createSeries()
 *   .setName("Random Stuff")
 *   .setPoints(new Number[] { 40, 35, 60 })
 * );
 * </pre></code>
 * Example of changing the options for one point in the series:
 * <code><pre>
 * chart.addSeries(chart.createSeries()
 *   .setName("Random Stuff")
 *   .addPoint(40)
 *   .addPoint(new Point(35).setColor("#BF0B23"))
 *   .addPoint(60)
 * );
 * </pre></code>
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.0.0
 */
public class Series extends Configurable<Series> {

    /**
     * An enumeration of supported series types, which can be passed to methods such as
     * {@link org.moxieapps.gwt.highcharts.client.Series#setType(org.moxieapps.gwt.highcharts.client.Series.Type)} or {@link org.moxieapps.gwt.highcharts.client.Chart#setType(org.moxieapps.gwt.highcharts.client.Series.Type)}.
     */
    public enum Type {

        /**
         * Show the series as an area filled in beneath a non-curved line
         */
        AREA("area"),

        /**
         * Show the series as an area filled between two non-curved lines.<p>
         * Only available if the highcharts-more.js script is included in your GWT module.
         *
         * @since 1.5.0
         */
        AREA_RANGE("arearange"),

        /**
         * Show the series as an area filled in beneath a curved line
         */
        AREA_SPLINE("areaspline"),

        /**
         * Show the series as an area filled between two curved lines.<p>
         * Only available if the highcharts-more.js script is included in your GWT module.
         *
         * @since 1.5.0
         */
        AREA_SPLINE_RANGE("areasplinerange"),

        /**
         * Show the series as horizontal bars
         */
        BAR("bar"),

        /**
         * Show the series as a box plot
         * @since 1.6.0
         */
        BOXPLOT("boxplot"),

        /**
         * Show the series as bubbles
         * @since 1.6.0
         */
        BUBBLE("bubble"),

        /**
         * Show the series as vertical bars
         */
        COLUMN("column"),

        /**
         * Show the series as vertical bars each designating a low to high range.<p>
         * Only available if the highcharts-more.js script is included in your GWT module.
         */
        COLUMN_RANGE("columnrange"),

        /**
         * Shows the Series as an Error bar
         * @since 1.6.0
         */
        ERRORBAR("errorbar"),

        /**
         * Show the series as flags
         * @since 1.6.0
         */
        FLAGS("flags"),

        /**
         * Show the series as a funnel</p>
         * Only available if the highcharts-more.js script is included in your GWT module.
         * @since 1.6.0
         */
        FUNNEL("funnel"),
        /**
         * @since 1.7.0
         * Show the series as a heatmap
         */
        HEATMAP("heatmap"),

        /**
         * @since 1.6.0
         * Show the series as a gauge
         */
        GAUGE("gauge"),

        /**
         * Show the series as a sequence of connected straight lines
         */
        LINE("line"),

        /**
         * Show the series as a pie chart
         */
        PIE("pie"),

        /**
         * Show the series as a pyramid
         */
        PYRAMID("pyramid"),

        /**
         * Show the series as a scatter plot
         */
        SCATTER("scatter"),

        /**
         * Show the series as a solid gauge
         * @since 1.7.0
         */
        SOLID_GAUGE("solidgauge"),

        /**
         * Show the series as a sequence of lines that are rendered as a spline to appear as a smooth curve
         */
        SPLINE("spline"),

        /**
         * Show the series as a treemap
         * @since 1.7.0
         */
        TREEMAP("treemap"),

        /**
         * Show the series as a waterfall
         * @since 1.6.0
         */
        WATERFALL("waterfall"),

        /**
         * Show the series as a sequence of bars that show the open, high, low, and close values.
         * Only available when you're using the {@link org.moxieapps.gwt.highcharts.client.StockChart} widget type.
         *
         * @since 1.1.0
         */
        OHLC("ohlc"),

        /**
         * Show the series as a sequence of candlesticks, where each candlestick represents four values.
         * Only available when you're using the {@link org.moxieapps.gwt.highcharts.client.StockChart} widget type.
         *
         * @since 1.1.0
         */
        CANDLESTICK("candlestick");

        private Type(String optionName) {
            this.optionName = optionName;
        }

        private final String optionName;

        public String toString() {
            return optionName;
        }

    }

    // Purposefully set to package scope
    BaseChart chart;

    // The unique id for this series, that we can use to access the native series instance later if changes
    // come into the series after it is rendered
    private String id;

    /**
     * Use the {@link org.moxieapps.gwt.highcharts.client.Chart#createSeries()} method to create new series instances.
     *
     * @param chart The chart instance that this series is being created within.
     */
    protected Series(BaseChart chart) {
        this.chart = chart;
        id = Document.get().createUniqueId();
        setOption("id", id);
    }

    /**
     * Convenience method for setting the 'colorByPoint' option of the series.  Equivalent to:
     * <pre><code>
     *     series.setOption("colorByPoint", true);
     * </code></pre>
     * When using automatic point colors pulled from the options.colors collection, this option determines
     * whether the chart should receive one color per series or one color per point. Defaults to false.
     * @param colorByPoint Whether the chart should receive one color per series or one color per point.
     * @return  reference to this {@link org.moxieapps.gwt.highcharts.client.Series} instance for convenient method chaining.
     */
    public Series setColorByPoint(boolean colorByPoint) {
        return this.setOption("colorByPoint", colorByPoint);
    }

    /**
     * Convenience method for setting the 'index' option of the series.  Equivalent to:
     * <pre><code>
     *     series.setOption("index", 1);
     * </code></pre>
     * The index of the series in the chart, affecting the internal index in the chart.series array,
     * the visible Z index as well as the order in the legend.
     * @param index The series' index in the internal chart.series array.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.Series} instance for convenient method chaining.
     */
    public Series setIndex(Number index) {
        return this.setOption("index", index);
    }

    /**
     * Convenience method for setting the 'index' option of the series.  Equivalent to:
     * <pre><code>
     *     series.setOption("index", 1);
     * </code></pre>
     * The sequential index of the series in the legend.
     * @param legendIndex A number representing the position of the series in the legend.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.Series} instance for convenient method chaining.
     */
    public Series setLegendIndex(Number legendIndex) {
        return this.setOption("legendIndex", legendIndex);
    }


    /**
     * Convenience method for setting the 'name' option of the series.  Equivalent to:
     * <pre><code>
     *     series.setOption("name", "My Chart");
     * </code></pre>
     * The name of the series as shown in the legend, tooltip etc. Defaults to "".
     *
     * @param name The string to set as the series name.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.Series} instance for convenient method chaining.
     */
    public Series setName(String name) {
       // ((JSONString)this.getOptions().get("name")).stringValue(); //check for null
        return this.setOption("name", name);
    }

    /**
     * /**
     * Convenience method for getting the 'name' of a particular series. Equivalent to:
     * <pre><code>
     *     series.getName()
     * </code></pre>
     * @return The name of a Series as a String, or null if no name is set by {@link #setName(String)}.
     * @since 1.6.0
     */
    public String getName() {
        return ((JSONString)this.getOptions().get("name")).stringValue() != null ? ((JSONString)this.getOptions().get("name")).stringValue() : null;
    }

    /**
     * Convenience method for setting the 'stack' option of the series to a string.  Equivalent to:
     * <pre><code>
     *     series.setOption("stack", "Stack 1");
     * </code></pre>
     * The 'stack' option allows grouping series in a stacked chart. Defaults to null.  Note
     * that you can also set this option to a number instead via the {@link #setStack(Number)} method.
     *
     * @param stack The string to set as the 'stack' option on the series.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.Series} instance for convenient method chaining.
     */
    public Series setStack(String stack) {
        return this.setOption("stack", stack);
    }

    /**
     * Convenience method for setting the 'stack' option of the series to a number.  Equivalent to:
     * <pre><code>
     *     series.setOption("stack", 1);
     * </code></pre>
     * The 'stack' option allows grouping series in a stacked chart. Defaults to null.  Note
     * that you can also set this option to a string instead via the {@link #setStack(String)} method.
     *
     * @param stack The number to set as the 'stack' option on the series.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.Series} instance for convenient method chaining.
     */
    public Series setStack(Number stack) {
        return this.setOption("stack", stack);
    }

    // We need to maintain a local reference to tooltip to deal with the formatter function
    private ToolTip toolTip;

    /**
     * Convenience method for setting the 'tooltip' option of the series.  Equivalent to:
     * <pre><code>
     *     series.setOption("/tooltip/borderColor", "#CCCCCC");
     *     series.setOption("/tooltip/shadow", true);
     *     etc..
     * </code></pre>
     * The tooltip appears when the user hovers over a series or point.
     *
     * @param toolTip The options to apply to the tooltip of the chart.
     * @return A reference to this {@link BaseChart} instance for convenient method chaining.
     */
    public Series setToolTip(ToolTip toolTip) {
        this.toolTip = toolTip;
        return this.setOption("/tooltip", toolTip != null ? toolTip.getOptions() : null);
    }

    private Type type;

    /**
     * Sets the type of this series (which controls the way the series will be rendered), using
     * an enumeration type in order to ensure a correct value is passed.  This is equivalent to
     * setting the option manually with code like:
     * <pre><code>
     *     series.setOption("type", "line");
     * </code></pre>
     * Note that if you don't set this explicitly the default series type is {@link org.moxieapps.gwt.highcharts.client.Series.Type#LINE}.
     *
     * @param type One of the supported series types.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.Series} instance for convenient method chaining.
     */
    public Series setType(Type type) {
        this.type = type;
        return this.setOption("type", type != null ? type.toString() : null);
    }

    // Purposefully package scope, may return null
    // @since 1.6.1
    Type getType() {
        if(this.type != null) {
            return this.type;
        } else {
            return this.chart.defaultSeriesType;
        }
    }

    /**
     * Convenience method for setting the 'xAxis' property of the series to a number.  Equivalent to:
     * <pre><code>
     *     series.setOption("xAxis", 1);
     * </code></pre>
     * When using dual or multiple x axes, this number defines which xAxis the particular series is
     * connected to. It refers to the index of the axis in the xAxis array, with 0 being the first.
     * Defaults to 0.
     *
     * @param xAxis The number to set as the 'xAxis' option on the series.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.Series} instance for convenient method chaining.
     */
    public Series setXAxis(Number xAxis) {
        return this.setOption("xAxis", xAxis);
    }

    /**
     * Convenience method for setting the 'yAxis' property of the series to a number.  Equivalent to:
     * <pre><code>
     *     series.setOption("yAxis", 1);
     * </code></pre>
     * When using dual or multiple y axes, this number defines which yAxis the particular series is
     * connected to. It refers to the index of the axis in the yAxis array, with 0 being the first.
     * Defaults to 0.
     *
     * @param yAxis The number to set as the 'yAxis' option on the series.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.Series} instance for convenient method chaining.
     */
    public Series setYAxis(Number yAxis) {
        return this.setOption("yAxis", yAxis);
    }

    // Need to maintain a refernce to the plot options set on us in order to deal with potential custom data label formatters
    private PlotOptions plotOptions;

    /**
     * Updates the plot options for this series to reflect the given options.  The default
     * options for all series in the chart (of each type) can be set on the {@link org.moxieapps.gwt.highcharts.client.Chart} instance,
     * and therefore you only need to use this method if you want to override the plot options for
     * this series only.
     * <p/>
     * Note that the general {@link org.moxieapps.gwt.highcharts.client.plotOptions.PlotOptions} type only represents the abstract base class of all the
     * different series types.  To call this method you need to instantiate one of the concrete
     * sub-classes instead (e.g. {@link org.moxieapps.gwt.highcharts.client.plotOptions.AreaPlotOptions},
     * {@link org.moxieapps.gwt.highcharts.client.plotOptions.BarPlotOptions}, etc.).
     * <p/>
     * Also note that changing the plot options for a series after it has been rendered to the screen
     * does not change the way the live series will appear.  If you need to change the plot options
     * after the series is rendered, you'd instead need to first {@link #remove()} the series from
     * the chart and then re-add it to the chart via the {@link org.moxieapps.gwt.highcharts.client.Chart#addSeries(org.moxieapps.gwt.highcharts.client.Series)} method.
     *
     * @param plotOptions The plot options to use for this series (or one of its sub-types)
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.Series} instance for convenient method chaining.
     */
    public Series setPlotOptions(PlotOptions plotOptions) {

        this.plotOptions = plotOptions;

        if (plotOptions == null) {
            return this;
        }

        // Applying plot options directly to a series is a little different as the optoins
        // get applied directly to the root configuration object, instead of off within their
        // own sub object like almost everything else works.  So, we need to merge the given
        // options with our root options
        JSONObject plotOptionsJSON = plotOptions.getOptions();

        if (plotOptionsJSON != null) {
            for (String key : plotOptionsJSON.keySet()) {
                this.setOption(key, plotOptionsJSON.get(key));
            }
        }

        return this;
    }

    // Purposefully package scope
    PlotOptions getPlotOptions() {
        return this.plotOptions;
    }

    /**
     * Simplest way to add a point using the default options, and setting only the Y value
     * that the point should be rendered at within the series.  See the various overloaded
     * versions of the <code>addPoint()</code> method for more control over the way the
     * point is rendered.
     *
     * @param y The value on the Y axis that the point should be drawn at within the series.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.Series} instance for convenient method chaining.
     */
    public Series addPoint(Number y) {
        return this.addPoint(new Point(y));
    }

    /**
     * Add a point to the series that is to be used as a flag.
     * @param x Point where the flag appears
     * @param title Title of flag displayed on the chart
     * @param text Text displayed when the flag are highlighted.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.Series} instance for convenient method chaining.
     */
    public Series addPoint(Number x, String title, String text) {
        return this.addPoint(new Point(x, title, text));
    }

    /**
     * Add a point to the series with a specific value on the Y axis, controlling the
     * options on how the change will be drawn to the series.
     *
     * @param y         The value on the Y axis that the point should be drawn at within the series.
     * @param redraw    Whether to redraw the chart after the point is added. When adding more than one
     *                  point, it is highly recommended that the redraw option be set to false, and instead
     *                  {@link org.moxieapps.gwt.highcharts.client.Chart#redraw()} is explicitly called
     *                  after the adding of points is finished.
     * @param shift     Defaults to false. When shift is true, one point is shifted off the start of the
     *                  series as one is appended to the end. Use this option for live charts monitoring
     *                  a value over time.
     * @param animation Defaults to true. When true, the graph will be animated with default animation options.
     *                  Note, see the {@link #addPoint(Number, boolean, boolean, org.moxieapps.gwt.highcharts.client.Animation)} method
     *                  for more control over how the animation will run.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.Series} instance for convenient method chaining.
     */
    public Series addPoint(Number y, boolean redraw, boolean shift, boolean animation) {
        return this.addPoint(new Point(y), redraw, shift, animation);
    }

    /**
     * Add a point to the series with a specific value on the Y axis, controlling the
     * options on how the change will be drawn to the series.
     *
     * @param y         The value on the Y axis that the point should be drawn at within the series.
     * @param redraw    Whether to redraw the chart after the point is added. When adding more than one
     *                  point, it is highly recommended that the redraw option be set to false, and instead
     *                  {@link org.moxieapps.gwt.highcharts.client.Chart#redraw()} is explicitly called
     *                  after the adding of points is finished.
     * @param shift     Defaults to false. When shift is true, one point is shifted off the start of the
     *                  series as one is appended to the end. Use this option for live charts monitoring
     *                  a value over time.
     * @param animation The custom animation to use when adding the point to the series.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.Series} instance for convenient method chaining.
     */
    public Series addPoint(Number y, boolean redraw, boolean shift, Animation animation) {
        return this.addPoint(new Point(y), redraw, shift, animation);
    }

    /**
     * Simple way to add a point using the default options, and setting only the X and Y value
     * that the point should be rendered at within the series.  See the various overloaded
     * versions of the <code>addPoint()</code> method for more control over the way the
     * point is rendered.
     *
     * @param x The value on the X axis that the point should be drawn at within the series.
     * @param y The value on the Y axis that the point should be drawn at within the series.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.Series} instance for convenient method chaining.
     */
    public Series addPoint(Number x, Number y) {
        return this.addPoint(new Point(x, y));
    }

    /**
     * Simple way to add a point using the default options, and setting only the X, Low, and High
     * values that the point should be rendered at within the series (for Area Range
     * charts).  See the various overloaded  versions of the <code>addPoint()</code> method for
     * more control over the way the point is rendered.
     *
     * @param x    The value on the X axis that the point should be drawn at within the series.
     * @param low  The "low" Y value that the point should be rendered at within the series.
     * @param high The "high" Y value that the point should be rendered at within the series.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.Series} instance for convenient method chaining.
     * @since 1.5.0
     */
    public Series addPoint(Number x, Number low, Number high) {
        return this.addPoint(new Point(x, low, high));
    }

    /**
     * Simple way to add a point using the default options, and setting only the X, Open, High,
     * Low, and Close values that the point should be rendered at within the series (for OHLC
     * charts).  See the various overloaded  versions of the <code>addPoint()</code> method for
     * more control over the way the point is rendered.
     *
     * @param x     The value on the X axis that the point should be drawn at within the series.
     * @param open  The "open" Y value that the point should be rendered at within the series.
     * @param high  The "high" Y value that the point should be rendered at within the series.
     * @param low   The "low" Y value that the point should be rendered at within the series.
     * @param close The "close" Y value that the point should be rendered at within the series.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.Series} instance for convenient method chaining.
     * @since 1.2.0
     */
    public Series addPoint(Number x, Number open, Number high, Number low, Number close) {
        return this.addPoint(new Point(x, open, high, low, close));
    }

    /**
     * Add a point to the series with a specific value on the X and Y axis, controlling the
     * options on how the change will be drawn to the series.
     *
     * @param x         The value on the X axis that the point should be drawn at within the series.
     * @param y         The value on the Y axis that the point should be drawn at within the series.
     * @param redraw    Whether to redraw the chart after the point is added. When adding more than one
     *                  point, it is highly recommended that the redraw option be set to false, and instead
     *                  {@link org.moxieapps.gwt.highcharts.client.Chart#redraw()} is explicitly called
     *                  after the adding of points is finished.
     * @param shift     Defaults to false. When shift is true, one point is shifted off the start of the
     *                  series as one is appended to the end. Use this option for live charts monitoring
     *                  a value over time.
     * @param animation Defaults to true. When true, the graph will be animated with default animation options.
     *                  Note, see the {@link #addPoint(Number, Number, boolean, boolean, org.moxieapps.gwt.highcharts.client.Animation)} method
     *                  for more control over how the animation will run.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.Series} instance for convenient method chaining.
     */
    public Series addPoint(Number x, Number y, boolean redraw, boolean shift, boolean animation) {
        return this.addPoint(new Point(x, y), redraw, shift, animation);
    }

    /**
     * Add a point to the series with a specific value on the X and Y axis, controlling the
     * options on how the change will be drawn to the series.
     *
     * @param x         The value on the X axis that the point should be drawn at within the series.
     * @param y         The value on the Y axis that the point should be drawn at within the series.
     * @param redraw    Whether to redraw the chart after the point is added. When adding more than one
     *                  point, it is highly recommended that the redraw option be set to false, and instead
     *                  {@link org.moxieapps.gwt.highcharts.client.Chart#redraw()} is explicitly called
     *                  after the adding of points is finished.
     * @param shift     Defaults to false. When shift is true, one point is shifted off the start of the
     *                  series as one is appended to the end. Use this option for live charts monitoring
     *                  a value over time.
     * @param animation The custom animation to use when adding the point to the series.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.Series} instance for convenient method chaining.
     */
    public Series addPoint(Number x, Number y, boolean redraw, boolean shift, Animation animation) {
        return this.addPoint(new Point(x, y), redraw, shift, animation);
    }

    /**
     * Add a point to the series with a specific value on the X and Y axis (in OHLC format), controlling the
     * options on how the change will be drawn to the series.
     *
     * @param x         The value on the X axis that the point should be drawn at within the series.
     * @param open      The "open" Y value that the point should be rendered at within the series.
     * @param high      The "high" Y value that the point should be rendered at within the series.
     * @param low       The "low" Y value that the point should be rendered at within the series.
     * @param close     The "close" Y value that the point should be rendered at within the series.
     * @param redraw    Whether to redraw the chart after the point is added. When adding more than one
     *                  point, it is highly recommended that the redraw option be set to false, and instead
     *                  {@link org.moxieapps.gwt.highcharts.client.Chart#redraw()} is explicitly called
     *                  after the adding of points is finished.
     * @param shift     Defaults to false. When shift is true, one point is shifted off the start of the
     *                  series as one is appended to the end. Use this option for live charts monitoring
     *                  a value over time.
     * @param animation The custom animation to use when adding the point to the series.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.Series} instance for convenient method chaining.
     * @since 1.2.0
     */
    public Series addPoint(Number x, Number open, Number high, Number low, Number close, boolean redraw, boolean shift, Animation animation) {
        return this.addPoint(new Point(x, open, high, low, close), redraw, shift, animation);
    }

    /**
     * Add a point to the series accepting the default options on how the point will be drawn.
     *
     * @param point The point to add to the series (which, in turn, can have its own configuration options).
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.Series} instance for convenient method chaining.
     */
    public Series addPoint(Point point) {
        return this.addPoint(point, true, false, true);
    }

    /**
     * Add a point to the series with a specific value on the X and Y axis, controlling the
     * options on how the change will be drawn to the series.
     *
     * @param point     The point to add to the series (which, in turn, can have its own configuration options).
     * @param redraw    Whether to redraw the chart after the point is added. When adding more than one
     *                  point, it is highly recommended that the redraw option be set to false, and instead
     *                  {@link org.moxieapps.gwt.highcharts.client.Chart#redraw()} is explicitly called
     *                  after the adding of points is finished.
     * @param shift     Defaults to false. When shift is true, one point is shifted off the start of the
     *                  series as one is appended to the end. Use this option for live charts monitoring
     *                  a value over time.
     * @param animation Defaults to true. When true, the graph will be animated with default animation options.
     *                  Note, see the {@link #addPoint(org.moxieapps.gwt.highcharts.client.Point, boolean, boolean, org.moxieapps.gwt.highcharts.client.Animation)} method
     *                  for more control over how the animation will run.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.Series} instance for convenient method chaining.
     */
    public Series addPoint(Point point, boolean redraw, boolean shift, boolean animation) {
        return this.addPoint(point, redraw, shift, animation ? new Animation() : null);
    }

    /**
     * Add a point to the series with a specific value on the X and Y axis, controlling the
     * options on how the change will be drawn to the series.
     *
     * @param point     The point to add to the series (which, in turn, can have its own configuration options).
     * @param redraw    Whether to redraw the chart after the point is added. When adding more than one
     *                  point, it is highly recommended that the redraw option be set to false, and instead
     *                  {@link org.moxieapps.gwt.highcharts.client.Chart#redraw()} is explicitly called
     *                  after the adding of points is finished.
     * @param shift     Defaults to false. When shift is true, one point is shifted off the start of the
     *                  series as one is appended to the end. Use this option for live charts monitoring
     *                  a value over time.
     * @param animation The custom animation to use when adding the point to the series.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.Series} instance for convenient method chaining.
     */
    public Series addPoint(Point point, boolean redraw, boolean shift, Animation animation) {

        // If we haven't been rendered, then just store the point in ourselves for now. Or,
        // if persistence is enabled than we need to store the point locally as well (so we have it if
        // the chart is dynamically moved to another panel).
        if (!isRendered() || chart.isPersistent()) {

            // Need to manually shift the item off the list if we haven't been rendered yet (after
            // we're rendered Highcharts handles the shift on its own)
            if (shift && points.size() > 0) {
                points.remove(0);
            }

            // If we haven't been rendered, then just store the point in ourselves for now.
            points.add(point);

        }

        if (isRendered()) {
            // We'll store the point directly in the DOM if we've already been rendered
            final JavaScriptObject nativeSeries = chart.get(this.id);
            if (nativeSeries != null) {
                if (animation == null || animation.getOptions() == null) {
                    final boolean animationFlag = animation != null;
                    if (point == null || (point.isSingleValue() && point.getY() == null)) {
                        nativeAddPoint(nativeSeries, null, redraw, shift, animationFlag);
                    } else if (point.isSingleValue() && !chart.isPersistent() && !point.hasNativeProperties()) {
                        nativeAddPoint(nativeSeries, point.getY().doubleValue(), redraw, shift, animationFlag);
                    } else {
                        nativeAddPoint(nativeSeries, convertPointToJavaScriptObject(point), redraw, shift, animationFlag);
                    }
                } else {
                    final JavaScriptObject animationOptions = animation.getOptions().getJavaScriptObject();
                    if (point == null || (point.isSingleValue() && point.getY() == null)) {
                        nativeAddPoint(nativeSeries, null, redraw, shift, animationOptions);
                    } else if (point.isSingleValue() && !chart.isPersistent() && !point.hasNativeProperties()) {
                        nativeAddPoint(nativeSeries, point.getY().doubleValue(), redraw, shift, animationOptions);
                    } else {
                        nativeAddPoint(nativeSeries, convertPointToJavaScriptObject(point), redraw, shift, animationOptions);
                    }
                }
            }
        }
        return this;
    }

    private JavaScriptObject convertPointToJavaScriptObject(Point point) {
        final JSONObject options = point.getOptions() != null ? point.getOptions() : new JSONObject();
        Chart.addPointScalarValues(point, options, getType());
        if (point.hasNativeProperties()) {
            Point.addPointNativeProperties(point, options);
        }
        if (chart != null) {
            chart.addPointId(point, options);
        }
        return options.getJavaScriptObject();
    }

    private JavaScriptObject convertSeriesToJavaScriptObject(Series series) {
        final JSONObject options = series.getOptions() != null ? series.getOptions() : new JSONObject();
        return options.getJavaScriptObject();
    }

    /**
     * Apply a new set of data (Y values only) to the series and automatically redraw it.  If you need
     * more control than just simply setting the y values of each data point, then use the
     * {@link #setPoints(org.moxieapps.gwt.highcharts.client.Point[])} method instead.
     *
     * @param yValues The array of Y values to set on the data series (replacing any data already in place)
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.Series} instance for convenient method chaining.
     */
    public Series setPoints(Number[] yValues) {
        return this.setPoints(yValues, true);
    }

    /**
     * Apply a new set of data (Y values only) to the series and optionally redraw it.  If you need
     * more control than just simply setting the y values of each data point, then use the
     * {@link #setPoints(org.moxieapps.gwt.highcharts.client.Point[], boolean)} method instead.
     *
     * @param yValues The array of Y values to set on the data series (replacing any data already in place)
     * @param redraw  Whether to redraw the chart after the series is altered. If doing more operations
     *                on the chart, it is a good idea to set redraw to false and then call
     *                {@link org.moxieapps.gwt.highcharts.client.Chart#redraw()} after.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.Series} instance for convenient method chaining.
     */
    public Series setPoints(Number[] yValues, boolean redraw) {
        this.points.clear();

        // If persistence is enabled than we need to store the point locally as well (so we have it if
        // the chart is dynamically moved to another panel).
        if (!isRendered() || chart.isPersistent()) {
            for (Number yValue : yValues) {
                this.addPoint(yValue);
            }
        }

        if (isRendered()) {
            final JavaScriptObject nativeSeries = chart.get(this.id);
            if (nativeSeries != null) {
                JSONArray jsonArray = new JSONArray();
                for (int i = 0, pointsLength = yValues.length; i < pointsLength; i++) {
                    if ((yValues[i] != null)) {
                        jsonArray.set(i, new JSONNumber(yValues[i].doubleValue()));
                    } else {
                        jsonArray.set(i, JSONNull.getInstance());
                    }
                }
                nativeSetData(nativeSeries, jsonArray.getJavaScriptObject(), redraw);
            }
        }

        return this;
    }

    /**
     * Apply a new set of data to the series and automatically redraw it. The format of the data values
     * should match the chart type of the Series:
     * <ul>
     * <li>[x, y] - for standard line or area charts</li>
     * <li>[x, low, high] - for area range charts</li>
     * <li>[x, open, high, low, close] - for OHLC charts</li>
     * </ul>
     * <p/>
     * <p>If you need more control than just simply setting the x and y values of each data point, then
     * use the {@link #setPoints(org.moxieapps.gwt.highcharts.client.Point[])} method instead.
     *
     * @param values A two dimensional array of values, where the main array is the list of points and
     *               each inner array contains values matching the series data type, described above.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.Series} instance for convenient method chaining.
     */
    public Series setPoints(Number[][] values) {
        return this.setPoints(values, true);
    }

    /**
     * Apply a new set of data to the series and optionally redraw it. The format of the data values
     * should match the chart type of the Series:
     * <ul>
     * <li>[x, y] - for standard line or area charts</li>
     * <li>[x, low, high] - for area range charts</li>
     * <li>[x, open, high, low, close] - for OHLC charts</li>
     * </ul>
     * <p/>
     * <p>If you need more control than just simply setting the x and y values of each data point, then
     * use the {@link #setPoints(org.moxieapps.gwt.highcharts.client.Point[])} method instead.
     *
     * @param values A two dimensional array of values, where the main array is the list of points and
     *               each inner array contains values matching the series data type, described above.
     * @param redraw Whether to redraw the chart after the series is altered. If doing more operations
     *               on the chart, it is a good idea to set redraw to false and then call
     *               {@link org.moxieapps.gwt.highcharts.client.Chart#redraw()} after.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.Series} instance for convenient method chaining.
     */
    public Series setPoints(Number[][] values, boolean redraw) {
        this.points.clear();

        // If persistence is enabled than we need to store the point locally as well (so we have it if
        // the chart is dynamically moved to another panel).
        if (!isRendered() || chart.isPersistent()) {
            for (Number[] xyValue : values) {
                if (xyValue.length == 5) {
                    // For OHLC/Candlestick/Box charts
                    this.addPoint(xyValue[0], xyValue[1], xyValue[2], xyValue[3], xyValue[4]);
                } else if (xyValue.length == 3) {
                    // For area range charts
                    this.addPoint(xyValue[0], xyValue[1], xyValue[2]);
                } else {
                    this.addPoint(xyValue[0], xyValue[1]);
                }
            }
        }

        if (isRendered()) {
            final JavaScriptObject nativeSeries = chart.get(this.id);
            if (nativeSeries != null) {
                JSONArray jsonArray = new JSONArray();
                for (int i = 0, pointsLength = values.length; i < pointsLength; i++) {
                    Number[] point = values[i];
                    JSONValue jsonValue;
                    if (point == null) {
                        jsonValue = JSONNull.getInstance();
                    } else if (point.length > 0) {
                        JSONArray pointArray = new JSONArray();
                        for (int j = 0; j < point.length; j++) {
                            pointArray.set(j, BaseChart.convertNumberToJSONValue(point[j]));
                        }
                        jsonValue = pointArray;
                    } else {
                        jsonValue = BaseChart.convertNumberToJSONValue(point[0]);
                    }
                    jsonArray.set(i, jsonValue);
                }
                nativeSetData(nativeSeries, jsonArray.getJavaScriptObject(), redraw);
            }
        }

        return this;
    }

    /**
     * Apply a new set of data to the series and automatically redraw it.
     *
     * @param points The array of points to set on the data series (replacing any data already in place)
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.Series} instance for convenient method chaining.
     */
    public Series setPoints(Point[] points) {
        return this.setPoints(points, true);
    }

    /**
     * Apply a new set of data to the series and optionally redraw it.
     *
     * @param points The array of points to set on the data series (replacing any data already in place)
     * @param redraw Whether to redraw the chart after the series is altered. If doing more operations
     *               on the chart, it is a good idea to set redraw to false and then call
     *               {@link org.moxieapps.gwt.highcharts.client.Chart#redraw()} after.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.Series} instance for convenient method chaining.
     */
    public Series setPoints(Point[] points, boolean redraw) {
        this.points.clear();

        // If persistence is enabled than we need to store the point locally as well (so we have it if
        // the chart is dynamically moved to another panel).
        if (!isRendered() || chart.isPersistent()) {
            Collections.addAll(this.points, points);
        }

        if (isRendered()) {
            final JavaScriptObject nativeSeries = chart.get(this.id);
            if (nativeSeries != null) {
                JSONArray jsonArray = new JSONArray();
                for (int i = 0, pointsLength = points.length; i < pointsLength; i++) {
                    jsonArray.set(i, chart.convertPointToJSON(points[i], this.getType()));
                }
                nativeSetData(nativeSeries, jsonArray.getJavaScriptObject(), redraw);
            }
        }

        return this;
    }

    /**
     * Apply a new set of data to a series with the option to redraw the chart. Intended for use when asynchronously
     * loading data into the chart.
     * @param points A set of points represented as a JSONArray
     * @param redraw Whether to redraw the chart after the series is altered. If doing more operations
     *               on the chart, it is a good idea to set redraw to false and then call
     *               {@link org.moxieapps.gwt.highcharts.client.Chart#redraw()} after.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.Series} instance for convenient method chaining.
     */
    public Series setPoints(JSONArray points, boolean redraw) {
        final JavaScriptObject nativeSeries = chart.get(this.id);
        if (nativeSeries != null) {
            nativeSetData(nativeSeries, points.getJavaScriptObject(), redraw);
        }
        return this;
    }

    /**
     * Retrieve the array of points that have been added to this series.  If this method is invoked
     * before the series is rendered to a chart, then it will simply return the points that have been
     * added so far.  If it is invoked after the series has been rendered, then it will retrieve
     * the JS point instances from the live Highcharts element and convert them to GWT points.
     *
     * @return The array of points, or an empty array (non null) if no points have been added to the series yet.
     */
    public Point[] getPoints() {
        ArrayList<Point> convertedPoints = points;
        if (isRendered() && !chart.isPersistent()) {
            convertedPoints = new ArrayList<Point>();
            // After the series has been rendered, convert the live JS data series back into GWT objects
            final JavaScriptObject nativeSeries = chart.get(this.id);
            if (nativeSeries != null) {
                JsArray<JavaScriptObject> nativePoints = nativeGetData(nativeSeries);
                for (int i = 0; i < nativePoints.length(); i++) {
                    JavaScriptObject nativePoint = nativePoints.get(i);
                    convertedPoints.add(new Point(nativePoint));
                }
            }
        }
        return convertedPoints.toArray(new Point[convertedPoints.size()]);
    }

    /**
     * Remove the point from the series, automatically redrawing the chart using the default
     * animation options. <p/>
     * Note that this method is only relevant given Point instances that are obtained from the chart
     * after it has been rendered, such as via an event or dynamically retrieving the points of
     * a series.<p/>
     * Also note that this method is primarily intended to ensure compatibility with chart's
     * that have been set in persistent mode via the {@link org.moxieapps.gwt.highcharts.client.BaseChart#setPersistent(boolean)} method.
     * If you're using non-persistent charts, you can instead simply use the
     * {@link org.moxieapps.gwt.highcharts.client.Point#remove()} method to achieve the same affect.
     *
     * @param point The point instance (obtained dynamically from the chart) to remove from the series.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.Series} instance for convenient method chaining.
     * @since 1.3.0
     */
    public Series removePoint(Point point) {
        return this.removePoint(point, true, true);
    }

    /**
     * Remove the point from the series, explicitly controlling whether the chart is redrawn
     * and/or animated or not. <p/>
     * Note that this method is only relevant given Point instances that are obtained from the chart
     * after it has been rendered, such as via an event or dynamically retrieving the points of
     * a series. <p/>
     * Also note that this method is primarily intended to ensure compatibility with chart's
     * that have been set in persistent mode via the {@link org.moxieapps.gwt.highcharts.client.BaseChart#setPersistent(boolean)} method.
     * If you're using non-persistent charts, you can instead simply use the
     * {@link org.moxieapps.gwt.highcharts.client.Point#remove(boolean, boolean)} method to achieve the same affect.
     *
     * @param point     The point instance (obtained dynamically from the chart) to remove from the series.
     * @param redraw    Whether to redraw the chart after the point is removed. When removing more than one
     *                  point, it is highly recommended that the redraw option be set to false, and instead
     *                  {@link org.moxieapps.gwt.highcharts.client.Chart#redraw()} is explicitly called after the removing of points is finished.
     * @param animation Defaults to true. When true, the graph will be animated with default animation options.
     *                  Note, see the {@link #removePoint(org.moxieapps.gwt.highcharts.client.Point, boolean, org.moxieapps.gwt.highcharts.client.Animation)} method
     *                  for more control over how the animation will run.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.Series} instance for convenient method chaining.
     * @since 1.3.0
     */
    public Series removePoint(Point point, boolean redraw, boolean animation) {
        return this.removePoint(point, redraw, animation ? new Animation() : null);
    }

    /**
     * Remove the point from the series, explicitly controlling whether the chart is redrawn
     * and the details of the animation options. <p/>
     * Note that this method is only relevant given Point instances that are obtained from the chart
     * after it has been rendered, such as via an event or dynamically retrieving the points of
     * a series.<p/>
     * Also note that this method is primarily intended to ensure compatibility with chart's
     * that have been set in persistent mode via the {@link org.moxieapps.gwt.highcharts.client.BaseChart#setPersistent(boolean)} method.
     * If you're using non-persistent charts, you can instead simply use the
     * {@link org.moxieapps.gwt.highcharts.client.Point#remove(boolean, org.moxieapps.gwt.highcharts.client.Animation)} method to achieve the same affect.
     *
     * @param point     The point instance (obtained dynamically from the chart) to remove from the series.
     * @param redraw    Whether to redraw the chart after the point is removed. When removing more than one
     *                  point, it is highly recommended that the redraw option be set to false, and instead
     *                  {@link org.moxieapps.gwt.highcharts.client.Chart#redraw()} is explicitly called after the removing of points is finished.
     * @param animation The custom animation to use when removing the point from the series.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.Series} instance for convenient method chaining.
     * @since 1.3.0
     */
    public Series removePoint(Point point, boolean redraw, Animation animation) {
        String id = point.getId(false);

        // First, tell the point to remove itself from the underlying Highcharts instance
        point.remove(redraw, animation);

        // Second, find the matching point within the series, and remove it.
        // Note that this logic is purposefully only functional for chart's that are using the "setPersistent()"
        // option.  Removing a point from a non-persistent chart can be achieved by simply using
        // the "Point.remove()" methods.
        if (id != null && points != null) {
            for (Iterator<Point> iterator = points.iterator(); iterator.hasNext(); ) {
                Point existingPoint = iterator.next();
                if (id.equals(existingPoint.getId(false))) {
                    iterator.remove();
                }
            }
        }
        return this;
    }

    /**
     * Remove this series from the chart it is a part of.
     *
     * @return 'true' if the series was a part of an active chart and successfully removed, or 'false' if the
     *         given series had not yet been added to any chart.
     */
    public boolean remove() {
        return chart.removeSeries(this);
    }

    /**
     * Shows the series if hidden.  Only applies after the chart has been rendered.
     * Note that if you need show many series at once consider using the {@link #setVisible(boolean, boolean)} method instead.
     *
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.Series} instance for convenient method chaining.
     * @since 1.1.0
     */
    public Series show() {
        if (isRendered()) {
            final JavaScriptObject nativeSeries = chart.get(this.id);
            if (nativeSeries != null) {
                nativeShow(nativeSeries);
            }
        }
        return this;
    }

    /**
     * Hides the series if visible. If the {@link org.moxieapps.gwt.highcharts.client.BaseChart#setIgnoreHiddenSeries(boolean)} option is true,
     * the chart is automatically redrawn without this series. Only applies after the chart has been rendered.
     * Note that if you need hide many series at once consider using the {@link #setVisible(boolean, boolean)} method instead.
     *
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.Series} instance for convenient method chaining.
     * @since 1.1.0
     */
    public Series hide() {
        if (isRendered()) {
            final JavaScriptObject nativeSeries = chart.get(this.id);
            if (nativeSeries != null) {
                nativeHide(nativeSeries);
            }
        }
        return this;
    }

    /**
     * Either shows or hides the series, and then automatically redraws the chart.
     * Only applies after the chart has been rendered.  Note that if you need to show/hide many series
     * at once consider using the {@link #setVisible(boolean, boolean)} method instead.
     *
     * @param visible Whether or not to show or hide the series.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.Series} instance for convenient method chaining.
     * @since 1.6.0
     */
    public Series setVisible(boolean visible) {
        return this.setVisible(visible, true);
    }

    /**
     * Either shows or hides the series, and then optionally redraws the chart.
     * Only applies after the chart has been rendered.  Note that if you need
     * to show/hide many series at once use this method passing "false" for the 'redraw' parameter, and
     * then use the {@link org.moxieapps.gwt.highcharts.client.BaseChart#redraw()} method to update the
     * chart once you're ready.
     *
     * @param visible Whether or not to show or hide the series.
     * @param redraw Whether or not to automatically redraw the chart, or wait until the Chart.redraw() method is called.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.Series} instance for convenient method chaining.
     * @since 1.6.0
     */
    public Series setVisible(boolean visible, boolean redraw) {
        if (isRendered()) {
            final JavaScriptObject nativeSeries = chart.get(this.id);
            if (nativeSeries != null) {
                nativeSetVisible(nativeSeries, visible, redraw);
            }
        }
        return this;
    }

    /**
     * Select or unselect the series. This means it's selected property is set, the checkbox in the legend is
     * toggled and when selected, the series is returned in the {@link org.moxieapps.gwt.highcharts.client.BaseChart#getSelectedSeries()} method.
     *
     * @param select When true, the series is selected. When false it is unselected.  See the {@link #selectToggle()}
     *               method to instead toggle the selection state.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.Series} instance for convenient method chaining.
     * @since 1.1.0
     */
    public Series select(boolean select) {
        if (isRendered()) {
            final JavaScriptObject nativeSeries = chart.get(this.id);
            if (nativeSeries != null) {
                nativeSelect(nativeSeries, select);
            }
        }
        return this;
    }

    /**
     * Select the series if it is currently unselected, or unselect the series if it is currently selected.
     * See the {@link #select(boolean)} method for more explicit control over the selection state of a series.
     *
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.Series} instance for convenient method chaining.
     * @since 1.1.0
     */
    public Series selectToggle() {
        if (isRendered()) {
            final JavaScriptObject nativeSeries = chart.get(this.id);
            if (nativeSeries != null) {
                nativeSelectToggle(nativeSeries);
            }
        }
        return this;
    }

    /**
     * Retrieve the series' visibility state as set by {@link #show()}, {@link #hide()}, or the initial configuration.
     *
     * @return true if the series is visible, false if hidden or the chart has not yet been rendered.
     */
    public boolean isVisible() {
        final JavaScriptObject nativeSeries = getNativeSeries();
        return nativeSeries != null && nativeIsVisible(nativeSeries);
    }

    /**
     * For advanced use-cases only.  Returns a pointer to the native Highchart's JS series instance
     * that this GWT Series instance is associated with.  Note that this method will only return
     * a non-null value if it is called on a Series instance after the chart has been rendered.
     *
     * @return The native Highcharts JS series instance that this Series is associated with, or
     *         null if the chart has not yet been rendered.
     * @since 1.4.0
     */
    public JavaScriptObject getNativeSeries() {
        if (isRendered()) {
            return chart.get(this.id);
        }
        return null;
    }

    /**
     * The internally generated unique id for this series
     *
     * @return The unique id of this series
     * @since 1.6.0
     */
    public String getId() {
        return id;
    }

    // Purposefully not using the generic "List" interface here in order optimize GWT performance.
    private ArrayList<Point> points = new ArrayList<Point>();

    // Purposefully setting to package scope
    void clearInternalPointsList() {
        if (!chart.isPersistent()) {
            this.points.clear();
        }
    }

    boolean rendered = false;

    // Purposefully restricting to package scope
    void setRendered(boolean flag) {
        this.rendered = flag;
    }

    private boolean isRendered() {
        return this.rendered;
    }

    /**
     * Update the series with a new set of options, automatically redrawing the chart.
     * @param seriesOptions New options that will be merged into the series' existing options.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.Series} instance for convenient method chaining.
     * @since 1.6.1
     */
    public Series update(Series seriesOptions) {
        return this.update(seriesOptions, true);
    }

    /**
     * Update the series with a new set of options. For a clean and precise handling of new options, all methods and
     * elements from the series is removed, and it is initiated from scratch. Therefore, this method is more performance
     * expensive than some other utility methods like setData or setVisible.
     * @param seriesOptions New options that will be merged into the series' existing options.
     * @param redraw Whether to redraw the chart after the series is altered. If doing more operations on the chart,
     *               it is a good idea to set redraw to false and call chart.redraw() after.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.Series} instance for convenient method chaining.
     * @since 1.6.1
     */
    public Series update(Series seriesOptions, boolean redraw) {
        final JavaScriptObject nativeSeries = this.getNativeSeries();
        if (nativeSeries != null) {
            nativeUpdateSeries(nativeSeries, convertSeriesToJavaScriptObject(seriesOptions), redraw);
        } else {

        }
        return this;
    }

    private static native JavaScriptObject nativeAddPoint(JavaScriptObject series, JavaScriptObject options, boolean redraw, boolean shift, JavaScriptObject animation) /*-{
        series.addPoint(options, redraw, shift, animation);
    }-*/;

    private static native JavaScriptObject nativeAddPoint(JavaScriptObject series, JavaScriptObject options, boolean redraw, boolean shift, boolean animation) /*-{
        series.addPoint(options, redraw, shift, animation);
    }-*/;

    private static native JavaScriptObject nativeAddPoint(JavaScriptObject series, double value, boolean redraw, boolean shift, JavaScriptObject animation) /*-{
        series.addPoint(value, redraw, shift, animation);
    }-*/;

    private static native JavaScriptObject nativeAddPoint(JavaScriptObject series, double value, boolean redraw, boolean shift, boolean animation) /*-{
        series.addPoint(value, redraw, shift, animation);
    }-*/;

    private static native void nativeSetData(JavaScriptObject series, JavaScriptObject data, boolean redraw) /*-{
        series.setData(data, redraw);
    }-*/;

    private static native void nativeShow(JavaScriptObject series) /*-{
        series.show();
    }-*/;

    private static native void nativeHide(JavaScriptObject series) /*-{
        series.hide();
    }-*/;

    private static native void nativeSetVisible(JavaScriptObject series, boolean visible, boolean redraw) /*-{
        series.setVisible(visible, redraw);
    }-*/;

    private static native void nativeSelect(JavaScriptObject series, boolean select) /*-{
        series.select(select);
    }-*/;

    private static native void nativeSelectToggle(JavaScriptObject series) /*-{
        series.select(null);
    }-*/;

    private static native JsArray<JavaScriptObject> nativeGetData(JavaScriptObject series) /*-{
        return series.data;
    }-*/;

    private static native boolean nativeIsVisible(JavaScriptObject series) /*-{
        return series.visible;
    }-*/;

    private static native void nativeUpdateSeries(JavaScriptObject series, JavaScriptObject options, boolean redraw) /*-{
        series.update(options, redraw);
    }-*/;
}
