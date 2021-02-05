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

/**
 * Represents the general dial options available for for the gauge's dial, which can be set either generically
 * on the chart via the {@link org.moxieapps.gwt.highcharts.client.Chart#setGaugePlotOptions(GaugePlotOptions)} method or directly on a
 * series via the {@link org.moxieapps.gwt.highcharts.client.Series#setPlotOptions(PlotOptions)} method.
 * <p/>
 * Sample usage:
 * <pre><code>
 *     Chart.setGaugePlotOptions(
 *          new GaugePlotOptions()
 *              .setDialOptions(
 *                  new Dial()
 *                      .setBaseLength("75%")
 *              )
 *     );
 * </code></pre>
 * @author cskoworn@moxiegroup.com (Cory Skowronek)
 * @since 1.6.0
 */
public class Dial extends BaseGaugePart<Dial> {

    /**
     * Convenience method for setting the "baseLength" option for a gauge's dial. Equivalent to:
     * <pre><code>
     *     dial.setOption("baseLength", "75%");
     * </code></pre>
     * The length of the dial's base part, relative to the total radius or length of the dial. Defaults to 70%.
     * @param baseLength The length of the base of the dial as a percentage of its radius.
     * @return A reference to this {@link Dial} for convenient method chaining.
     */
    public Dial setBaseLength(String baseLength) {
        return this.setOption("baseLength", baseLength);
    }

    /**
     * Convenience method for setting the "baseWidth" option for a gauge's dial. Equivalent to:
     * <pre><code>
     *     dial.setOption("baseWidth", 5)
     * </code></pre>
     * The pixel width of the base of the gauge dial. The base is the part closest to the pivot, defined by baseLength. Defaults to 3.
     * @param baseWidth The width, in pixels, of the dial.
     * @return A reference to this {@link Dial} for convenient method chaining.
     */
    public Dial setBaseWidth(Number baseWidth) {
        return this.setOption("baseWidth", baseWidth);
    }

    /**
     * Convenience method for setting the "rearLength" option for a gauge's dial. Equivalent to:
     * <pre><code>
     *     dial.setOption("rearLength", "15%");
     * </code></pre>
     * The length of the dial's rear end, the part that extends out on the other side of the pivot. Relative to the dial's length. Defaults to 10%.
     * @param rearLength The length of the rear end of the dial as a percentage of the radius.
     * @return A reference to this {@link Dial} for convenient method chaining.
     */
    public Dial setRearLength(String rearLength) {
        return this.setOption("rearLength", rearLength);
    }

    /**
     * Convenience method for setting the "topLength" option for a gauge's dial. Equivalent to:
     * <pre><code>
     *     dial.setOption("topLength", 2);
     * </code></pre>
     * The width of the top of the dial, closest to the perimeter. The pivot narrows in from the base to the top. Defaults to 1.
     * @param topWidth The width, in pixels, of the tip of the dial.
     * @return A reference to this {@link Dial} for convenient method chaining.
     */
    public Dial setTopWidth(Number topWidth) {
        return this.setOption("topWidth", topWidth);
    }
    
}
