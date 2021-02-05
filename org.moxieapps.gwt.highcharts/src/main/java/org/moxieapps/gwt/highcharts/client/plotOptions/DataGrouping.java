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

package org.moxieapps.gwt.highcharts.client.plotOptions;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONString;
import org.moxieapps.gwt.highcharts.client.Configurable;
import org.moxieapps.gwt.highcharts.client.DateTimeLabelFormats;


/**
 * A configurable class to set the options for the data grouping of the plot.  Sample usage:
 * chart.setPlotOptions(
 *     new plotOptions()
 *         .setDataGrouping(
 *             .newDataGrouping()
 *                 .setEnabled(true)
 *                 .setGroupPixelWidth(10)
 *         )
 * );
 * @author cskowron@moxiegroup.com (Cory Skowronek)
 * @since 1.6.0
 */
public class DataGrouping extends Configurable<DataGrouping> {

    public enum Approximation {
        AVERAGE("average"),

        OPEN("open"),

        HIGH("high"),

        LOW("low"),

        CLOSE("close");

        private Approximation(String optionValue) {
            this.optionValue = optionValue;
        }

        private final String optionValue;

        public String toString() {
            return optionValue;
        }

    }

    /**
     * Basic class to support DataGrouping.  This class should not be instantiated on its own, but as a parameter
     * of {@link DataGrouping#setUnits(DataGrouping.Unit...)}
     * </p>
     * Sample usage:
     * <pre><code>
     *     chart.setPlotoptions(
     *          new PlotOptions()
     *              .setDataGrouping(
     *                  new DataGrouping()
     *                      .setUnits(
     *                          new Unit("week", 1),
     *                          new Unit("month", 1, 2, 3, 4, 6)
     *                      )
     *              )
     *      );
     * </code></pre>
     * @author cskowron@moxiegroup.com (Cory Skowronek)
     * @since 1.6.0
     */
    public static class Unit extends JSONArray {

        /**
         * Constructor for the Unit class. One should use only this constructor and not the default Unit().
         * </p>
         * Sample usage:
         * <pre><code>
         *      new Unit("millisecond", 1, 2, 5, 10, 20, 25, 50, 100, 200, 500)
         * </code></pre>
         * </p>
         * This will produce the following:
         * <pre><code>
         *      [['millisecond', // unit name
         *      [1, 2, 5, 10, 20, 25, 50, 100, 200, 500]] // allowed multiples
         * </code></pre>
         * @param unitName The Name of the unit for which you wish to set intervals.
         * @param intervals The intervals that the data is allowed to be grouped in
         * @see org.moxieapps.gwt.highcharts.client.plotOptions.DataGrouping#setUnits(org.moxieapps.gwt.highcharts.client.plotOptions.DataGrouping.Unit...)
         */
        public Unit(String unitName, Number... intervals) {

            final JSONArray intervalArray = new JSONArray();
            for (int i = 0; i < intervals.length; i++) {
                intervalArray.set(i, new JSONNumber(intervals[i].doubleValue()));
            }

            this.set(0, new JSONString(unitName));
            this.set(1, intervalArray);
        }

    }

    /**
     * Convenience method for setting the "approximation" option for the data grouping of the plot.  Equivalent to:
     * <pre><code>
     *     dataGrouping.setOption("approximation", "high");
     * </code></pre>
     * The method of approximation inside a group. When for example 30 days are grouped into one month, this determines
     * what value should represent the group. Possible values are "average", "open", "high", "low", "close" and "sum".
     * For OHLC and candlestick series the approximation is "ohlc" by default, which finds the open, high, low and close
     * values within all the grouped data. For ranges, the approximation is "range", which finds the low and high values.
     * <p/>
     * Defaults to average for line-type series, sum for columns, range for range series and ohlc for OHLC and candlestick.
     * @param approximation The approximation type to use for the grouping.
     * @return A reference to this {@link DataGrouping} for convenient method chaining.
     */
    public DataGrouping setApproximation(Approximation approximation) {
        return approximation != null ? this.setOption("approximation", approximation.toString()) : null;
    }

    // TODO: Add support for an approximation call back function to be provided

    /**
     * Convenience method for setting the 'dateTimeLabelFormats' options of the dataGrouping.  Equivalent to code like:
     * <pre><code>
     *     dataGrouping.setOption("/dateTimeLabelFormats/second", "%H:%M:%S");
     *     dataGrouping.setOption("/dateTimeLabelFormats/minute", "%H:%M");
     * </code></pre>
     * For each of these array definitions, the first item is the format used when the active time span is one unit.
     * For instance, if the current data applies to one week, the first item of the week array is used. The second
     * and third items are used when the active time span is more than two units. For instance, if the current data
     * applies to two weeks, the second and third item of the week array are used, and applied to the start and end
     * date of the time span. Defaults to:
     * <ul>
     * <li>millisecond: ['%A, %b %e, %H:%M:%S.%L', '%A, %b %e, %H:%M:%S.%L', '-%H:%M:%S.%L']</li>
     * <li>second: ['%A, %b %e, %H:%M:%S', '%A, %b %e, %H:%M:%S', '-%H:%M:%S']</li>
     * <li>minute: ['%A, %b %e, %H:%M', '%A, %b %e, %H:%M', '-%H:%M']</li>
     * <li>hour: ['%A, %b %e, %H:%M', '%A, %b %e, %H:%M', '-%H:%M']</li>
     * <li>day: ['%A, %b %e, %Y', '%A, %b %e', '-%A, %b %e, %Y']</li>
     * <li>week: ['Week from %A, %b %e, %Y', '%A, %b %e', '-%A, %b %e, %Y']</li>
     * <li>month: ['%B %Y', '%B', '-%B %Y']</li>
     * <li>year: ['%Y', '%Y', '-%Y']</li>
     * </ul>
     * Example usage:
     * <code><pre>
     *   axis.setDateTimeLabelFormats(
     *     new DateTimeLabelFormats()
     *       .setHour("%A, %b %e, %H:%M", "%A, %b %e, %H:%M", "-%H:%M")
     *       .setMinute("%A, %b %e, %H:%M", "%A, %b %e, %H:%M", "-%H:%M")
     *   );
     * </pre></code>
     * Note that for the DataGrouping instance of DateTimeLabelFormats, one should use the setter methods which
     * take multiple strings as a parameter, and not the ones with a single string parameter.
     * @see DateTimeLabelFormats
     * @param dateTimeLabelFormats The formats to use for time series information on this axis.
     * @return A reference to this {@link DataGrouping} instance for convenient method chaining.
     */
    public DataGrouping setDateTimeLabelFormats(DateTimeLabelFormats dateTimeLabelFormats) {
        return this.setOption("dateTimeLabelFormats", dateTimeLabelFormats != null ? dateTimeLabelFormats.getOptions() : null);
    }

    /**
     * Convenience method for setting the "enabled" option for the data grouping of the plot.  Equivalent to:
     * <pre><code>
     *     dataGrouping.setOption("enabled", false);
     * </code></pre>
     * Enable or disable data grouping. Defaults to true. Defaults to true.
     * @param enabled Whether to enable data grouping.
     * @return A reference to this {@link DataGrouping} for convenient method chaining.
     */
    public DataGrouping setEnabled(boolean enabled) {
        return this.setOption("enabled", enabled);
    }

    /**
     * Convenience method for setting the "forced" option for the data grouping of the plot.  Equivalent to:
     * <pre><code>
     *     dataGrouping.setOption("forced", true);
     * </code></pre>
     * When data grouping is forced, it runs no matter how small the intervals are. This can be handy for example,
     * when the sum should be calculated for values appearing at random times within each hour. Defaults to false.
     * @param forced Whether to force data grouping.
     * @return A reference to this {@link DataGrouping} for convenient method chaining.
     */
    public DataGrouping setForced(boolean forced) {
        return this.setOption("forced", forced);
    }

    /**
     * Convenience method for setting the "groupPixelWidth" option for the data grouping of the plot.  Equivalent to:
     * <pre><code>
     *     dataGrouping.setOption("groupPixelWidth", 10);
     * </code></pre>
     * The approximate pixel width of each group. If for example a series with 30 points is displayed over a 600 pixel
     * wide plot area, no grouping is performed. If however the series contains so many points that the spacing is less
     * than the groupPixelWidth, Highcharts will try to group it into appropriate groups so that each is more or less
     * two pixels wide. If multiple series with different group pixel widths are drawn on the same x axis, all series
     * will take the greatest width. For example, line series have 2px default group width, while column series have 10px.
     * If combined, both the line and the column will have 10px by default. Defaults to 2.
     * @param groupPixelWidth The width of area in which to group points.
     * @return A reference to this {@link DataGrouping} for convenient method chaining.
     */
    public DataGrouping setGroupPixelWidth(Number groupPixelWidth) {
        return this.setOption("groupPixelWidth", groupPixelWidth);
    }

    /**
     * Convenience method for setting the "smoothed" option for the data grouping of the plot.  Equivalent to:
     * <pre><code>
     *     dataGrouping.setOption("smoothed", true);
     * </code></pre>
     * Normally, a group is indexed by the start of that group, so for example when 30 daily values are grouped into
     * one month, that month's x value will be the 1st of the month. This apparently shifts the data to the left.
     * When the smoothed option is true, this is compensated for. The data is shifted to the middle of the group,
     * and min and max values are preserved. Internally, this is used in the Navigator series. Defaults to false.
     * Defaults to false.
     * @param smoothed Whether to smooth the data when it is shifted due to grouping.
     * @return A reference to this {@link DataGrouping} for convenient method chaining.
     */
    public DataGrouping setSmoothed(boolean smoothed) {
        return this.setOption("smoothed", smoothed);
    }

    /**
     * Convenience method for setting the "units" option for the data grouping of the plot.  Sample usage:
     * <pre><code>
     *      chart.setDataGrouping(
     *          new DataGrouping()
     *              .setUnits(
     *                  new Unit("minute", {1, 2, 5, 10, 15, 30}),
     *                  new Unit("hour", {1, 2, 3, 4, 6, 8})
     *              )
     *      );
     *
     * </code></pre>
     * An array determining what time intervals the data is allowed to be grouped to.
     * Each array item is an array where the first value is the time unit and the second value another array of allowed multiples.
     * <p/>
     * Defaults to:
     * <pre>
     * units: [
     *    ['millisecond', // unit name
     *     [1, 2, 5, 10, 20, 25, 50, 100, 200, 500] // allowed multiples
     * ], ['second',
     *     [1, 2, 5, 10, 15, 30]
     * ], ['minute',
     *     [1, 2, 5, 10, 15, 30]
     * ], ['hour',
     *     [1, 2, 3, 4, 6, 8, 12]
     * ], ['day',
     *     [1]
     * ], ['week',
     *     [1]
     * ], ['month',
     *     [1, 3, 6]
     * ], ['year',
     *     null
     * ]]
     * </pre>
     * * @param units
     * @return A reference to this {@link DataGrouping} for convenient method chaining.
     */
    public DataGrouping setUnits(Unit... units) {
        return this.setOption("units", units);
    }

}
