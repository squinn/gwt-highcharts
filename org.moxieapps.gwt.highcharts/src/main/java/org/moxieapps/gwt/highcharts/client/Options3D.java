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

/**
 * The Options3d class represents a set of options for a 3D chart.  This class should only be instantiated as part of
 * a call to {@link Chart#setOptions3D(Options3D)}
 * Example usage:
 * <pre><code>
 *     chart.setOptions3d(
 *          new Options3d()
 *              .setAlpha(50);
 * </code></code></pre>
 * Options to render charts in 3 dimensions.
 * Note that this feature requires highcharts-3d.js
 * @author cskowron@moxiegroup.com (Cory Skowronek)
 * @since 1.7.0
 */
public class Options3D extends Configurable<Options3D> {

    /**
     * Convenience method for setting the 'alpha' attribute of a 3d chart.  Equivalent to:
     * <pre><code>
     *      options3d.setOption("alpha", 0);
     * </code></pre>
     * @param alpha One of the two rotation angles for the chart. Defaults to 0.
     * @return A reference to this {@link Options3D} instance for convenient method chaining.
     */
    public Options3D setAlpha(Number alpha) {
        return this.setOption("alpha", alpha);
    }

    /**
     * Convenience method for setting the 'bets' attribute of a 3d chart.  Equivalent to:
     * <pre><code>
     *     options3d.setOption("beta", 0);
     * </code></pre>
     * @param beta One of the two rotation angles for the chart. Defaults to 0.
     * @return A reference to this {@link Options3D} instance for convenient method chaining.
     */
    public Options3D setBeta(Number beta) {
        return this.setOption("beta", beta);
    }

    /**
     * Convenience method for setting the 'depth' attribute of a 3d chart.  Equivalent to:
     * <pre><code>
     *      options3d.setOption("depth", 100);
     * </code></pre>
     * @param depth The total depth of the chart. Defaults to 100.
     * @return A reference to this {@link Options3D} instance for convenient method chaining.
     */
    public Options3D setDepth(Number depth) {
        return this.setOption("depth", depth);
    }

    /**
     * Convenience method for setting the 'enabled' attribute of a 3d chart.  Equivalent to:
     * <pre><code>
     *      options3d.setOption("enabled", false);
     * </code></pre>
     * @param enabled Whether to render the chart using the 3D functionality. Defaults to false.
     * @return A reference to this {@link Options3D} instance for convenient method chaining.
     */
    public Options3D setEnabled(Boolean enabled) {
        return this.setOption("enabled", enabled);
    }

    /**
     * Convenience method for setting the 'frame' attribute of a 3d chart. Note that this method makes use of the
     * {@link Frame} as well as its inner {@link Frame.FramePanel} class.  Equivalent to:
     * <pre><code>
     *      options3d.setOption("frame", new Frame());
     * </code></pre>
     * @param frame An instance of the {@link Frame} class.
     *              Provides the option to draw a frame around the charts by defining a bottom, front and back panel.
     * @return A reference to this {@link Options3D} instance for convenient method chaining.
     * @see Frame
     * @see Frame.FramePanel
     */
    public Options3D setFrame(Frame frame) {
        return this.setOption("frame", frame);
    }

    /**
     * Convenience method for setting the 'viewDistance' option of a 3d chart.  Eqiuvalent to:
     * <pre><code>
     *      options3d.setOption("viewDistance", 30);
     * </code></pre>
     * @param viewDistance Defines the distance the viewer is standing in front of the chart,
     *                     this setting is important to calculate the perspective effect in
     *                     column and scatter charts. It is not used for 3D pie charts. Defaults to 100.
     * @return A reference to this {@link Options3D} instance for convenient method chaining.
     */
    public Options3D setViewDistance(Number viewDistance) {
        return this.setOption("viewDistance", viewDistance);
    }
}
