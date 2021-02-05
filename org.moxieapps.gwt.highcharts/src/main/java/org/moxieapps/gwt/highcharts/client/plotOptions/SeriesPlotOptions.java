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

import org.moxieapps.gwt.highcharts.client.Chart;
import org.moxieapps.gwt.highcharts.client.Series;
import org.moxieapps.gwt.highcharts.client.events.*;

/**
 * Represents the general plot options available for all series types, which can be set either generically
 * on the chart via the {@link Chart#setSeriesPlotOptions(SeriesPlotOptions)} method or directly on a
 * series via the {@link Series#setPlotOptions(PlotOptions)} method.
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.0.0
 */
public class SeriesPlotOptions extends PlotOptions<SeriesPlotOptions> {

    private SeriesClickEventHandler seriesClickEventHandler;

    /**
     * Set a callback handler that will be invoked whenever the user clicks on the series.
     * Additional information about the click (such as the point closest to the click) can be
     * found via the {@link org.moxieapps.gwt.highcharts.client.events.SeriesClickEvent} instance
     * that is passed to the handler's {@link org.moxieapps.gwt.highcharts.client.events.SeriesClickEventHandler#onClick(org.moxieapps.gwt.highcharts.client.events.SeriesClickEvent)} method.
     *
     * @param seriesClickEventHandler The handler that should be invoked whenever a series click event occurs.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.BaseChart} instance for convenient method chaining.
     *
     * @since 1.1.0
     */
    public SeriesPlotOptions setSeriesClickEventHandler(SeriesClickEventHandler seriesClickEventHandler) {
        this.seriesClickEventHandler = seriesClickEventHandler;
        return this;
    }

    /**
     * Returns the custom event handler that has been set on the plot options, or null if no event
     * handler has been set.
     *
     * @return The custom event handler that has been applied, or null if it has not been set.
     *
     * @since 1.1.0
     */
    public SeriesClickEventHandler getSeriesClickEventHandler() {
        return this.seriesClickEventHandler;
    }

    private SeriesCheckboxClickEventHandler seriesCheckboxClickEventHandler;

    /**
     * Set a callback handler that will be invoked whenever the user clicks on the checkbox next
     * to a series' name in the legend.  Additional information about the click (such as whether or
     * not the box was checked or unchecked) can be found via the
     * {@link org.moxieapps.gwt.highcharts.client.events.SeriesCheckboxClickEvent} instance
     * that is passed to the handler's
     * {@link org.moxieapps.gwt.highcharts.client.events.SeriesCheckboxClickEventHandler#onClick(org.moxieapps.gwt.highcharts.client.events.SeriesCheckboxClickEvent)}
     * method.
     *
     * @param seriesCheckboxClickEventHandler The handler that should be invoked whenever a series checkbox click event occurs.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.BaseChart} instance for convenient method chaining.
     *
     * @since 1.1.0
     */
    public SeriesPlotOptions setSeriesCheckboxClickEventHandler(SeriesCheckboxClickEventHandler seriesCheckboxClickEventHandler) {
        this.seriesCheckboxClickEventHandler = seriesCheckboxClickEventHandler;
        return this;
    }

    /**
     * Returns the custom event handler that has been set on the plot options, or null if no event
     * handler has been set.
     *
     * @return The custom event handler that has been applied, or null if it has not been set.
     *
     * @since 1.1.0
     */
    public SeriesCheckboxClickEventHandler getSeriesCheckboxClickEventHandler() {
        return this.seriesCheckboxClickEventHandler;
    }

    private SeriesHideEventHandler seriesHideEventHandler;

    /**
     * Set a callback handler that will be invoked whenever a series is hidden on the chart.
     *
     * @param seriesHideEventHandler The handler that should be invoked whenever a series hide event occurs.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.BaseChart} instance for convenient method chaining.
     *
     * @since 1.1.0
     */
    public SeriesPlotOptions setSeriesHideEventHandler(SeriesHideEventHandler seriesHideEventHandler) {
        this.seriesHideEventHandler = seriesHideEventHandler;
        return this;
    }

    /**
     * Returns the custom event handler that has been set on the plot options, or null if no event
     * handler has been set.
     *
     * @return The custom event handler that has been applied, or null if it has not been set.
     *
     * @since 1.1.0
     */
    public SeriesHideEventHandler getSeriesHideEventHandler() {
        return this.seriesHideEventHandler;
    }

    private SeriesLegendItemClickEventHandler seriesLegendItemClickEventHandler;

    /**
     * Set a callback handler that will be invoked whenever the legend item belonging to a series is clicked.
     *
     * @param seriesLegendItemClickEventHandler The handler that should be invoked whenever a series' legend item click event occurs.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.BaseChart} instance for convenient method chaining.
     *
     * @since 1.1.0
     */
    public SeriesPlotOptions setSeriesLegendItemClickEventHandler(SeriesLegendItemClickEventHandler seriesLegendItemClickEventHandler) {
        this.seriesLegendItemClickEventHandler = seriesLegendItemClickEventHandler;
        return this;
    }

    /**
     * Returns the custom event handler that has been set on the plot options, or null if no event
     * handler has been set.
     *
     * @return The custom event handler that has been applied, or null if it has not been set.
     *
     * @since 1.1.0
     */
    public SeriesLegendItemClickEventHandler getSeriesLegendItemClickEventHandler() {
        return this.seriesLegendItemClickEventHandler;
    }

    private SeriesMouseOverEventHandler seriesMouseOverEventHandler;

    /**
     * Set a callback handler that will be invoked whenever a mouse over event occurs on a series.
     *
     * @param seriesMouseOverEventHandler The handler that should be invoked whenever a series' legend item click event occurs.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.BaseChart} instance for convenient method chaining.
     *
     * @since 1.1.0
     */
    public SeriesPlotOptions setSeriesMouseOverEventHandler(SeriesMouseOverEventHandler seriesMouseOverEventHandler) {
        this.seriesMouseOverEventHandler = seriesMouseOverEventHandler;
        return this;
    }

    /**
     * Returns the custom event handler that has been set on the plot options, or null if no event
     * handler has been set.
     *
     * @return The custom event handler that has been applied, or null if it has not been set.
     *
     * @since 1.1.0
     */
    public SeriesMouseOverEventHandler getSeriesMouseOverEventHandler() {
        return this.seriesMouseOverEventHandler;
    }

    private SeriesMouseOutEventHandler seriesMouseOutEventHandler;

    /**
     * Set a callback handler that will be invoked whenever a mouse out event occurs on a series.
     *
     * @param seriesMouseOutEventHandler The handler that should be invoked whenever a series' legend item click event occurs.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.BaseChart} instance for convenient method chaining.
     *
     * @since 1.1.0
     */
    public SeriesPlotOptions setSeriesMouseOutEventHandler(SeriesMouseOutEventHandler seriesMouseOutEventHandler) {
        this.seriesMouseOutEventHandler = seriesMouseOutEventHandler;
        return this;
    }

    /**
     * Returns the custom event handler that has been set on the plot options, or null if no event
     * handler has been set.
     *
     * @return The custom event handler that has been applied, or null if it has not been set.
     *
     * @since 1.1.0
     */
    public SeriesMouseOutEventHandler getSeriesMouseOutEventHandler() {
        return this.seriesMouseOutEventHandler;
    }    

    private SeriesShowEventHandler seriesShowEventHandler;

    /**
     * Set a callback handler that will be invoked whenever a series is shown on the chart.
     *
     * @param seriesShowEventHandler The handler that should be invoked whenever a series show event occurs.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.BaseChart} instance for convenient method chaining.
     *
     * @since 1.1.0
     */
    public SeriesPlotOptions setSeriesShowEventHandler(SeriesShowEventHandler seriesShowEventHandler) {
        this.seriesShowEventHandler = seriesShowEventHandler;
        return this;
    }

    /**
     * Returns the custom event handler that has been set on the plot options, or null if no event
     * handler has been set.
     *
     * @return The custom event handler that has been applied, or null if it has not been set.
     *
     * @since 1.1.0
     */
    public SeriesShowEventHandler getSeriesShowEventHandler() {
        return this.seriesShowEventHandler;
    }    

    private PointClickEventHandler pointClickEventHandler;

    /**
     * Set a callback handler that will be invoked whenever the user clicks on a point in a series.
     *
     * @param pointClickEventHandler The handler that should be invoked whenever a point click event occurs.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.BaseChart} instance for convenient method chaining.
     *
     * @since 1.1.0
     */
    public SeriesPlotOptions setPointClickEventHandler(PointClickEventHandler pointClickEventHandler) {
        this.pointClickEventHandler = pointClickEventHandler;
        return this;
    }

    /**
     * Returns the custom event handler that has been set on the plot options, or null if no event
     * handler has been set.
     *
     * @return The custom event handler that has been applied, or null if it has not been set.
     *
     * @since 1.1.0
     */
    public PointClickEventHandler getPointClickEventHandler() {
        return this.pointClickEventHandler;
    }

    private PointMouseOverEventHandler pointMouseOverEventHandler;

    /**
     * Set a callback handler that will be invoked whenever the user mouses over a point in a series.
     *
     * @param pointMouseOverEventHandler The handler that should be invoked whenever a point mouse over event occurs.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.BaseChart} instance for convenient method chaining.
     *
     * @since 1.1.0
     */
    public SeriesPlotOptions setPointMouseOverEventHandler(PointMouseOverEventHandler pointMouseOverEventHandler) {
        this.pointMouseOverEventHandler = pointMouseOverEventHandler;
        return this;
    }

    /**
     * Returns the custom event handler that has been set on the plot options, or null if no event
     * handler has been set.
     *
     * @return The custom event handler that has been applied, or null if it has not been set.
     *
     * @since 1.1.0
     */
    public PointMouseOverEventHandler getPointMouseOverEventHandler() {
        return this.pointMouseOverEventHandler;
    }
    
    private PointMouseOutEventHandler pointMouseOutEventHandler;

    /**
     * Set a callback handler that will be invoked whenever the user mouses out of a point in a series.
     *
     * @param pointMouseOutEventHandler The handler that should be invoked whenever a point mouse out event occurs.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.BaseChart} instance for convenient method chaining.
     *
     * @since 1.1.0
     */
    public SeriesPlotOptions setPointMouseOutEventHandler(PointMouseOutEventHandler pointMouseOutEventHandler) {
        this.pointMouseOutEventHandler = pointMouseOutEventHandler;
        return this;
    }

    /**
     * Returns the custom event handler that has been set on the plot options, or null if no event
     * handler has been set.
     *
     * @return The custom event handler that has been applied, or null if it has not been set.
     *
     * @since 1.1.0
     */
    public PointMouseOutEventHandler getPointMouseOutEventHandler() {
        return this.pointMouseOutEventHandler;
    }    

    private PointRemoveEventHandler pointRemoveEventHandler;

    /**
     * Set a callback handler that will be invoked whenever the user removes on a point in a series.
     *
     * @param pointRemoveEventHandler The handler that should be invoked whenever a point remove event occurs.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.BaseChart} instance for convenient method chaining.
     *
     * @since 1.1.0
     */
    public SeriesPlotOptions setPointRemoveEventHandler(PointRemoveEventHandler pointRemoveEventHandler) {
        this.pointRemoveEventHandler = pointRemoveEventHandler;
        return this;
    }

    /**
     * Returns the custom event handler that has been set on the plot options, or null if no event
     * handler has been set.
     *
     * @return The custom event handler that has been applied, or null if it has not been set.
     *
     * @since 1.1.0
     */
    public PointRemoveEventHandler getPointRemoveEventHandler() {
        return this.pointRemoveEventHandler;
    }  
    
    private PointSelectEventHandler pointSelectEventHandler;

    /**
     * Set a callback handler that will be invoked whenever the user selects a point in a series.
     *
     * @param pointSelectEventHandler The handler that should be invoked whenever a point select event occurs.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.BaseChart} instance for convenient method chaining.
     *
     * @since 1.1.0
     */
    public SeriesPlotOptions setPointSelectEventHandler(PointSelectEventHandler pointSelectEventHandler) {
        this.pointSelectEventHandler = pointSelectEventHandler;
        return this;
    }

    /**
     * Returns the custom event handler that has been set on the plot options, or null if no event
     * handler has been set.
     *
     * @return The custom event handler that has been applied, or null if it has not been set.
     *
     * @since 1.1.0
     */
    public PointSelectEventHandler getPointSelectEventHandler() {
        return this.pointSelectEventHandler;
    }

    private PointUnselectEventHandler pointUnselectEventHandler;

    /**
     * Set a callback handler that will be invoked whenever the user unselects a point in a series.
     *
     * @param pointUnselectEventHandler The handler that should be invoked whenever a point unselect event occurs.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.BaseChart} instance for convenient method chaining.
     *
     * @since 1.1.0
     */
    public SeriesPlotOptions setPointUnselectEventHandler(PointUnselectEventHandler pointUnselectEventHandler) {
        this.pointUnselectEventHandler = pointUnselectEventHandler;
        return this;
    }

    /**
     * Returns the custom event handler that has been set on the plot options, or null if no event
     * handler has been set.
     *
     * @return The custom event handler that has been applied, or null if it has not been set.
     *
     * @since 1.1.0
     */
    public PointUnselectEventHandler getPointUnselectEventHandler() {
        return this.pointUnselectEventHandler;
    }
    
    private PointUpdateEventHandler pointUpdateEventHandler;

    /**
     * Set a callback handler that will be invoked whenever the a point in a series is updated programatically.
     *
     * @param pointUpdateEventHandler The handler that should be invoked whenever a point update event occurs.
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.BaseChart} instance for convenient method chaining.
     *
     * @since 1.1.0
     */
    public SeriesPlotOptions setPointUpdateEventHandler(PointUpdateEventHandler pointUpdateEventHandler) {
        this.pointUpdateEventHandler = pointUpdateEventHandler;
        return this;
    }

    /**
     * Returns the custom event handler that has been set on the plot options, or null if no event
     * handler has been set.
     *
     * @return The custom event handler that has been applied, or null if it has not been set.
     *
     * @since 1.1.0
     */
    public PointUpdateEventHandler getPointUpdateEventHandler() {
        return this.pointUpdateEventHandler;
    }    
      
}
