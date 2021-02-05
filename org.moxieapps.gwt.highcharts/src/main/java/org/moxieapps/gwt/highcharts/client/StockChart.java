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

import org.moxieapps.gwt.highcharts.client.plotOptions.CandlestickPlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.OHLCPlotOptions;

/**
 * The main GWT widget that can be constructed and then configured in order to add a Highstock
 * chart into a GWT layout container.  Note that for more basic chart types just make use of the
 * {@link Chart} widget instead.
 * Basic usage is as follows:
 * <pre><code>
 * StockChart stockChart = new StockChart()
 *    .setChartTitleText("NYSE")
 *    .setMarginRight(10);
 * Series series = stockChart.createSeries()
 *   .addPoint(40)
 *   .addPoint(35)
 *   .addPoint(60);
 * stockChart.addSeries(series);
 * RootPanel.get().add(stockChart);
 * </code></pre>
 * For details on available options see the <a href="http://api.highcharts.com/">Highcharts reference</a>.
 * <p/>
 * Note that in order for this widget to function you must have included the Highstock javascript
 * library and any of its dependencies in the page that the widget will run inside of.  E.g.:
 * <pre><code>
 * &lt;script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"&gt;&lt;/script&gt;
 * &lt;script type="text/javascript" src="js/highstock.js"&gt;&lt;/script&gt;
 * </code></pre><pre><code>
 * &lt;!-- Optionally, add a highcharts theme file --&gt;
 * &lt;script type="text/javascript" src="js/themes/gray.js"&gt;&lt;/script&gt;
 * </code></pre><pre><code>
 * &lt;!-- Optionally, include the highcharts exporting module --&gt;
 * &lt;script type="text/javascript" src="js/modules/exporting.js"&gt;&lt;/script&gt;
 * </code></pre>
 * Note that the "highstock.js" file includes all of the capabilities of the "highcharts.js" file.
 * So if you plan on using both {@link StockChart}'s and regular {@link Chart}'s simultaneously, then
 * you only need to include the "highstock.js" file in your page.
 * <p/>
 * Also note that Highcharts supports other JS frameworks besides jQuery for its internal DOM manipulation
 * functionality.  So, if jQuery isn't your cup of tea check the
 * <a href="http://www.highcharts.com/docs/getting-started/installation">installation docs</a>
 * on the Highcharts site for more details.
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.0.0
 */
public class StockChart extends BaseChart<StockChart> {
    
    private final Navigator navigator;

    /**
     * Create a new Highstock chart instance as a GWT Widget that can then be added to
     * a GWT layout like any other widget. Note that the various methods that support
     * setting properties of the chart (e.g. {@link #setType(org.moxieapps.gwt.highcharts.client.Series.Type)},
     * {@link #setBackgroundColor(String)}, {@link #setOption(String, Object)}, etc.)
     * then support method chaining, allowing for syntax like the following:
     * <pre><code>
     * StockChart chart = new StockChart()
     *    .setChartTitleText("Nice Chart")
     *    .setMarginRight(10);
     * RootPanel.get().add(chart);
     * </code></pre>
     */
    public StockChart() {
        super();
        Series navigatorSeries = createSeries();
        this.navigator = new Navigator(this, navigatorSeries);
        this.setOption("/navigator", this.navigator);
    }

    @Override
    protected String getChartTypeName() {
        return "StockChart";
    }
    
    /**
     * Access the StockChart's {@link Navigator}, for customization.
     * @return A reference to the stock chart's {@link Navigator}
     * @since 1.5.0
     */
    public Navigator getNavigator() {
        return navigator;
    }

    /**
     * Convenience method for setting the 'rangeSelector' chart options.  Equivalent to:
     * <pre><code>
     *     stockChart.setOption("/rangeSelector/selected", 1);
     *     stockChart.setOption("/rangeSelector/inputEnabled", false);
     *     etc...
     * </code></pre>
     *
     * @param rangeSelector Sets the chart range selector options.
     * @return A reference to this {@link StockChart} instance for convenient method chaining.
     */
    public StockChart setRangeSelector(RangeSelector rangeSelector) {
        return this.setOption("/rangeSelector", rangeSelector != null ? rangeSelector.getOptions() : null);
    }

    /**
     * Convenience method for setting the 'scrollbar' chart options.  Equivalent to:
     * <pre><code>
     *     stockChart.setOption("/scrollbar/enabled", false);
     *     stockChart.setOption("/scrollbar/height", 2);
     *     etc...
     * </code></pre>
     * @param scrollbar Sets the scrollbar options
     * @return A reference to this {@link StockChart} instance for convenient method chaining.
     * @since 1.6.0
     */
    public StockChart setScrollbar(Scrollbar scrollbar) {
        return this.setOption("/scrollbar", scrollbar != null ? scrollbar.getOptions() : null);
    }

    /**
     * Updates the options that all OHLC type series within the chart will use by default.  The settings can then
     * be overridden for each individual series via the {@link Series#setPlotOptions(org.moxieapps.gwt.highcharts.client.plotOptions.PlotOptions)} method.
     * <p/>
     * Note that changing the plot options on a chart that has already been rendered will only affect
     * series that are subsequently added to the chart (and will not impact any of the series that are already
     * rendered in the chart.)
     *
     * @param ohlcPlotOptions The options to set on the chart as the default settings for all OHLC type series
     *                        that are part of this chart.
     * @return A reference to this {@link StockChart} instance for convenient method chaining.
     * @since 1.4.0
     */
    public StockChart setOHLCPlotOptions(OHLCPlotOptions ohlcPlotOptions) {
        this.ohlcPlotOptions = ohlcPlotOptions;
        if (ohlcPlotOptions != null) {
            this.setOption("/plotOptions/ohlc", ohlcPlotOptions.getOptions());
        }
        return this;
    }

    /**
     * Updates the options that all candlestick type series within the chart will use by default.  The settings can then
     * be overridden for each individual series via the {@link Series#setPlotOptions(org.moxieapps.gwt.highcharts.client.plotOptions.PlotOptions)} method.
     * <p/>
     * Note that changing the plot options on a chart that has already been rendered will only affect
     * series that are subsequently added to the chart (and will not impact any of the series that are already
     * rendered in the chart.)
     *
     * @param candlestickPlotOptions The options to set on the chart as the default settings for all candlestick type series
     *                        that are part of this chart.
     * @return A reference to this {@link StockChart} instance for convenient method chaining.
     * @since 1.6.0
     */
    public StockChart setCandlestickPlotOptions(CandlestickPlotOptions candlestickPlotOptions) {
        this.candlestickPlotOptions = candlestickPlotOptions;
        if (candlestickPlotOptions != null) {
            this.setOption("/plotOptions/candlestick", candlestickPlotOptions.getOptions());
        }
        return this;
    }
}
