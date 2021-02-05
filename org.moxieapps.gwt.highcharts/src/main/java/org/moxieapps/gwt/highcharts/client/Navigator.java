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

import com.google.gwt.json.client.JSONObject;

/**
 * The navigator is a small series below the main series, displaying a view of the entire data set. It provides tools
 * to zoom in and out on parts of the data as well as panning across the dataset. Applies only to {@link org.moxieapps.gwt.highcharts.client.StockChart}.
 *
 * @author myersj@gmail.com (Jeff Myers)
 * @since 1.5.0
 */
public class Navigator extends Configurable<Navigator> {

    private final Series series;
    private final XAxis xAxis;
    private final YAxis yAxis;

    /**
     * Use the {@link org.moxieapps.gwt.highcharts.client.StockChart#getNavigator()} method to get access to the Navigator of the chart.
     *
     * @param stockChart The chart instance that this navigator is being created within.
     * @param series     The chart series used for the navigator display
     */
    Navigator(StockChart stockChart, Series series) {
        this.series = series;
        this.xAxis = new XAxis(stockChart);
        this.yAxis = new YAxis(stockChart);

        // Link the internal configurable instances to be part of this configurable instance
        setOption("series", this.series);
        setOption("xAxis", this.xAxis);
        setOption("yAxis", this.yAxis);
    }

    /**
     * Access the navigator series, to allow for customization via the {@link Series#setPlotOptions(org.moxieapps.gwt.highcharts.client.plotOptions.PlotOptions)}
     * method.
     * <pre><code>
     * stockChart.getNavigator().getSeries()
     *   .setType(Series.Type.LINE)
     *   .setPlotOptions(new LinePlotOptions()
     *      .setColor("#0000ff")
     *      .setLineWidth(2));
     * </code></pre>
     *
     * @return the navigator series.
     */
    public Series getSeries() {
        return series;
    }

    /**
     * Access the navigator X axis, to allow for customization.
     * <pre><code>
     * stockChart.getNavigator().getXAxis()
     *    .setOpposite(true)
     *    .setTickWidth(1)
     *    .setTickColor("#eeeeee");
     * </code></pre>
     *
     * @return the navigator X axis.
     */
    public XAxis getXAxis() {
        return xAxis;
    }

    /**
     * Access the navigator Y axis, to allow for customization.
     * <pre><code>
     * stockChart.getNavigator().getYAxis()
     *    .setOpposite(true)
     *    .setTickWidth(1)
     *    .setTickColor("#eeeeee");
     * </code></pre>
     *
     * @return the navigator Y axis.
     */
    public YAxis getYAxis() {
        return yAxis;
    }

    /**
     * When this option is true, the navigator will redraw and reposition when data is updated in the main
     * chart. When loading data asynchronously from the server depending on zoomed range, this option
     * must be set to false in order to prevent looping. Defaults to <code>true</code>.
     *
     * @param adaptToUpdatedData true to redraw and reposition on data update, false to disable.
     * @return A reference to this {@link Navigator} instance for convenient method chaining.
     */
    public Navigator setAdaptToUpdatedData(boolean adaptToUpdatedData) {
        return this.setOption("adaptToUpdatedData", adaptToUpdatedData);
    }

    /**
     * Specify the index of the base series for the navigator. The base series will be used to provide
     * data for the navigator. Defaults to <code>0</code>.
     *
     * @param seriesIndex index of the base series
     * @return A reference to this {@link Navigator} instance for convenient method chaining.
     */
    public Navigator setBaseSeries(Number seriesIndex) {
        return this.setOption("baseSeries", seriesIndex);
    }

    /**
     * Specify the ID of the base series for the navigator. The base series will be used to provide
     * data for the navigator.
     *
     * @param seriesId ID of the base series
     * @return A reference to this {@link Navigator} instance for convenient method chaining.
     */
    public Navigator setBaseSeries(String seriesId) {
        return this.setOption("baseSeries", seriesId);
    }

    /**
     * Enable or disable the navigator. Defaults to <code>true</true>.
     *
     * @param enabled true to enable the range selector, false to disable.
     * @return A reference to this {@link Navigator} instance for convenient method chaining.
     */
    public Navigator setEnabled(boolean enabled) {
        return this.setOption("enabled", enabled);
    }

    /**
     * Set the background color of the navigator handles.
     *
     * @param color the background color to set
     * @return A reference to this {@link Navigator} instance for convenient method chaining.
     */
    public Navigator setHandlesBackgroundColor(String color) {
        return this.setOption("handles/backgroundColor", color);
    }

    /**
     * Set the border color of the navigator handles.
     *
     * @param color the border color to set
     * @return A reference to this {@link Navigator} instance for convenient method chaining.
     */
    public Navigator setHandlesBorderColor(String color) {
        return this.setOption("handles/borderColor", color);
    }

    /**
     * Set the height of the navigator. Defaults to <code>40</code>.
     *
     * @param height the height value to set (in pixels)
     * @return A reference to this {@link Navigator} instance for convenient method chaining.
     */
    public Navigator setHeight(Number height) {
        return this.setOption("height", height);
    }

    /**
     * Set the distance from the nearest element, the X axis or X axis labels. Defaults to <code>10</code>.
     *
     * @param margin the margin distance value to set (in pixels)
     * @return A reference to this {@link Navigator} instance for convenient method chaining.
     */
    public Navigator setMargin(Number margin) {
        return this.setOption("margin", margin);
    }

    /**
     * Set the color mask covering the areas of the navigator series that are currently not visible in the
     * main series. The default color is white with an opacity of 0.75 to see the series below. Defaults to
     * <code>"rgba(255, 255, 255, 0.75)"</code>
     *
     * @param maskFillColor the color of the mask fill to set
     * @return A reference to this {@link Navigator} instance for convenient method chaining.
     */
    public Navigator setMaskFill(String maskFillColor) {
        return this.setOption("maskFill", maskFillColor);
    }

    /**
     * Set the color of the line marking the currently zoomed area in the navigator. Defaults to <code>#444</code>.
     *
     * @param outlineColor the outline color to set
     * @return A reference to this {@link Navigator} instance for convenient method chaining.
     */
    public Navigator setOutlineColor(String outlineColor) {
        return this.setOption("outlineColor", outlineColor);
    }

    /**
     * Set the width of the line marking the currently zoomed area in the navigator. Defaults to <code>2</code>.
     *
     * @param outlineWidth the outlineWidth value to set (in pixels)
     * @return A reference to this {@link Navigator} instance for convenient method chaining.
     */
    public Navigator setOutlineWidth(Number outlineWidth) {
        return this.setOption("outlineWidth", outlineWidth);
    }

}