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
 * A simple value object that is used to report the current extremes of an axis whenever
 * the {@link Axis#getExtremes()} method is invoked (normally after the chart has been rendered).
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.0.0
 */
public class Extremes {

    private Number dataMax;
    private Number dataMin;
    private Number max;
    private Number min;

    /**
     * Use the {@link Axis#getExtremes()} method to gain
     * access to 'Extremes' instance associated with the chart axis.
     *
     * @param dataMin The minimum value of the axis' associated series.
     * @param dataMax The maximum value of the axis' associated series.
     * @param min The minimum axis value, either automatic or set manually.
     * @param max The maximum axis value, either automatic or set manually.
     */
    Extremes(Number dataMin, Number dataMax, Number min, Number max) {
        this.dataMin = dataMin;
        this.dataMax = dataMax;
        this.min = min;
        this.max = max;
    }

    /**
     * Return the minimum value of the axis' associated series, or null if the extremes
     * are requested before the chart has been rendered.
     *
     * @return The maximum value of the axis' associated series.
     */
    public Number getDataMin() {
        return dataMin;
    }

    /**
     * Return the maximum value of the axis' associated series, or null if the extremes
     * are requested before the chart has been rendered.
     *
     * @return The maximum value of the axis' associated series.
     */
    public Number getDataMax() {
        return dataMax;
    }

    /**
     * Return the minimum axis value, either automatic or set manually. If the max option
     * is not set and minPadding is 0, this value will be the same as  {@link #getDataMin()}.   Will
     * return null if the extremes are requested before the chart has been rendered and
     * no manual minimum has been set via {@link Axis#setMin(Number)}.
     *
     * @return The minimum axis value, either automatic or set manually.
     */
    public Number getMin() {
        return min;
    }

    /**
     * Return the maximum axis value, either automatic or set manually. If the max option
     * is not set and maxPadding is 0, this value will be the same as {@link #getDataMax()}.   Will
     * return null if the extremes are requested before the chart has been rendered and
     * no manual maximum has been set via {@link Axis#setMax(Number)}.
     *
     * @return The maximum axis value, either automatic or set manually.
     */
    public Number getMax() {
        return max;
    }

}
