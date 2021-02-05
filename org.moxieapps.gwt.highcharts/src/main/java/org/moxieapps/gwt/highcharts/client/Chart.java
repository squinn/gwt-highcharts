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

/**
 * The main GWT widget that can be constructed and then configured in order to add a Highcharts
 * chart into a GWT layout container.  Note that only standard chart types can be created with
 * this widget.  See the {@link StockChart} for other available chart types.
 * Basic usage is as follows:
 * <pre><code>
 * Chart chart = new Chart()
 *    .setType(Series.Type.SPLINE)
 *    .setChartTitleText("Nice Chart")
 *    .setMarginRight(10);
 * Series series = chart.createSeries()
 *   .addPoint(40)
 *   .addPoint(35)
 *   .addPoint(60);
 * chart.addSeries(series);
 * RootPanel.get().add(chart);
 * </code></pre>
 * For details on available options see the <a href="http://api.highcharts.com/">Highcharts reference</a>.
 * <p/>
 * Note that in order for this widget to function you must have included the Highcharts javascript
 * library and any of its dependencies in the page that the widget will run inside of.  E.g.:
 * <pre><code>
 * &lt;script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"&gt;&lt;/script&gt;
 * &lt;script type="text/javascript" src="js/highcharts.js"&gt;&lt;/script&gt;
 * </code></pre><pre><code>
 * &lt;!-- Optionally, add a highcharts theme file --&gt;
 * &lt;script type="text/javascript" src="js/themes/gray.js"&gt;&lt;/script&gt;
 * </code></pre><pre><code>
 * &lt;!-- Optionally, include the highcharts exporting module --&gt;
 * &lt;script type="text/javascript" src="js/modules/exporting.js"&gt;&lt;/script&gt;
 * </code></pre>
 * Note that Highcharts supports other JS frameworks besides jQuery for its internal DOM manipulation
 * functionality.  So, if jQuery isn't your cup of tea check the
 * <a href="http://www.highcharts.com/docs/getting-started/installation">installation docs</a>
 * on the Highcharts site for more details.
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.0.0
 */
public class Chart extends BaseChart<Chart> {

    /**
     * An enumeration of supported chart zoom types, which can be passed to the
     * {@link Chart#setZoomType(ZoomType)} method.  The zoom type controls in what
     * dimensions the user can zoom by dragging the mouse
     */
    public enum ZoomType {

        /**
         * Allow zoom horizontally on the X axis only.
         */
        X("x"),

        /**
         * Allow zoom vertically on the Y axis only.
         */
        Y("y"),

        /**
         * Allow zooming both horizontally and vertically (both axes).
         */
        X_AND_Y("xy");

        private ZoomType(String optionValue) {
            this.optionValue = optionValue;
        }

        private final String optionValue;

        public String toString() {
            return optionValue;
        }

    }

    /**
     * An enumeration of the known supported keys which are passed to the {@link Chart#setPanKey(PanKey)}used as
     * a "panKey" which, when down, switches from zooming to panning.
     */
    public enum PanKey {
        /**
         * Pan the chart while holding "alt"
         */
        ALT("alt"),

    /**
         * Pan the chart while holding "ctrl"
         */
        CTRL("ctrl"),

        /**
         *  Pan the chart while holding "shift"
         */
        SHIFT("shift");

        private PanKey(String optionValue) {
            this.optionValue = optionValue;
        }

        private final String optionValue;

        public String toString() {
            return optionValue;
        }
    }


    /**
     * Create a new Highcharts chart instance as a GWT Widget that can then be added to
     * a GWT layout like any other widget. Note that the various methods that support
     * setting properties of the chart (e.g. {@link #setType(org.moxieapps.gwt.highcharts.client.Series.Type)},
     * {@link #setBackgroundColor(String)}, {@link #setOption(String, Object)}, etc.)
     * then support method chaining, allowing for syntax like the following:
     * <pre><code>
     * Chart chart = new Chart()
     *    .setType(Series.Type.SPLINE)
     *    .setChartTitleText("Nice Chart")
     *    .setMarginRight(10);
     * RootPanel.get().add(chart);
     * </code></pre>
     */
    public Chart() {
        super();
    }

    /**
     * Convenience method for setting the 'drilldown' options for the chart which represents a collection of options
     * that apply to standard charts.
     * @param drilldown The drilldown options to apply to the chart.
     * @return A reference to this {@link Chart} instance for convenient method chaining.
     */
    public Chart setDrilldown(Drilldown drilldown) {
        return this.setOption("/drilldown", drilldown != null ? drilldown.getOptions() : null);
    }

    /**
     * Convenience method for setting the 'noData' option of the chart.
     * @param noData The noData options to apply to the chart.
     * @return A reference to this {@link Chart} instance for convenient method chaining.
     */
    public Chart setNoData(NoData noData) {
        return this.setOption("/noData", noData != null ? noData.getOptions() : null);
    }

    /**
     * Convenience method for setting the 'options3d' options for the chart, which represents a collection of options
     * that apply only to standard charts.
     * @param options3d The 3D options to apply to the chart.
     * @return A reference to this {@link Chart} instance for convenient method chaining.
     */
    public Chart setOptions3D(Options3D options3d) {
        return this.setOption("/chart/options3d", options3d != null ? options3d.getOptions() : null);
    }

    /**
     * Convenience method for setting the 'pane' options of the chart, which represents
     * a collection of options that apply only to polar charts and angular gauges.
     * <p/>
     * Note: many of the pane options are only available if the highcharts-more.js script is included in your GWT module. E.g.:
     * </p>
     * &lt;script type="text/javascript" src="js/highcharts-more.js"&gt;&lt;/script&gt;
     *
     * @param pane The pane options to apply to the chart.
     * @return A reference to this {@link Chart} instance for convenient method chaining.
     * @since 1.5.0
     */
    public Chart setPane(Pane pane) {
        return this.setOption("/pane", pane != null ? pane.getOptions() : null);
    }

    /**
     * Convenience method for setting the 'panKey' option of the chart.  Equivalent to:
     * <pre><code>
     *     chart.setOption("panKey", "shift");
     * </code></pre>
     * Allows setting a key to switch between zooming and panning.
     * @param panKey the key used to switch zooming to panning.
     * @return A reference to this {@link Chart} instance for convenient method chaining.
     * @since 1.7.0
     */
    public Chart setPanKey(PanKey panKey) {
        return this.setOption("pankey", panKey != null ? panKey.toString() : null);
    }

    /**
     * Convenience method for setting the 'panning' option of the chart.  Equivalent to:
     * <pre><code>
     *     chart.setOption("panning", true);
     * </code></pre>
     * Allow panning in a chart. Best used with panKey to combine zooming and panning. Defaults to false.
     * @param panning the value to set as the 'panning' option on the chart.
     * @return A reference to this {@link Chart} instance for convenient method chaining.
     * @since 1.7.0
     */
    public Chart setPanning(Boolean panning) {
        return this.setOption("panning", panning);
    }

    /**
     * Convenience method for setting the 'polar' option of the chart.  Equivalent to:
     * <pre><code>
     *     chart.setOption("/chart/polar", true);
     * </code></pre>
     * When true, cartesian charts like line, spline, area and column are transformed
     * into the polar coordinate system. Defaults to false.
     * <p>
     * Note: this option is only available if the highcharts-more.js script is included in your GWT module.
     * </p>
     *
     * @param polar The value to set as the 'polar' option on the chart.
     * @return A reference to this {@link Chart} instance for convenient method chaining.
     * @since 1.6.0
     */
    public Chart setPolar(boolean polar) {
        return this.setOption("/chart/polar", polar);
    }

    /**
     * Sets which dimensions the user can zoom by dragging the mouse.
     * Can be one of {@link Chart.ZoomType#X}, {@link Chart.ZoomType#Y} or
     * {@link Chart.ZoomType#X_AND_Y}. Defaults to null.
     * This is equivalent to setting the option manually with code like:
     * <pre><code>
     *     chart.setOption("/chart/zoomType", Chart.ZoomType.X);
     * </code></pre>
     *
     * @param zoomType One of the allowed zoom types.
     * @return A reference to this {@link Chart} instance for convenient method chaining.
     * @deprecated Use {@link BaseChart#setZoomType(BaseChart.ZoomType)}
     */
    public Chart setZoomType(Chart.ZoomType zoomType) {
        return this.setOption("/chart/zoomType", zoomType != null ? zoomType.toString() : null);
    }



    @Override
    protected String getChartTypeName() {
        return "Chart";
    }

}
