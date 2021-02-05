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
 * Provides the option to draw a frame around the chart by defining a bottom, front and back panel.
 * Note that this class should only be instantiated as a parameter of the
 * {@link Options3D#setFrame(Frame)} method.
 * Sample usage:
 * <pre><code>
 *     chart.setOptions3d(
 *          new Options3d()
 *              .setFrame(
 *                  new Frame()
 *              )
 *     );
 * </code></pre>
 * @author cskowron@moxiegroup.com
 * @since 1.7.0
 */
public class Frame extends Configurable<Frame> {
    /**
     * Convenience method for setting the 'back' attribute of a 3d chart's frame.  Equivalent to:
     * <pre><code>
     *      frame.setOption("back", new FramePanel());
     * </code></pre>
     * @param backFramePanel an instance of {@link FramePanel}
     *                       Defines the back panel of the frame around 3D charts.
     * @return A reference to this {@link Frame} instance for convenient method chaining.
     */
    public Frame setBack(FramePanel backFramePanel) {
        return this.setOption("back", backFramePanel);
    }

    /**
     * Convenience method for setting the 'bottom' attribute of a 3d chart's frame.  Equivalent to:
     * <pre><code>
     *      frame.setOption("bottom", new FramePanel());
     * </code></pre>
     * @param bottomFramePanel an instance of {@link FramePanel}
     *                         The bottom of the frame around a 3D chart.
     * @return A reference to this {@link Frame} instance for convenient method chaining.
     */
    public Frame setBottom(FramePanel bottomFramePanel) {
        return this.setOption("bottom", bottomFramePanel);
    }

    /**
     * Convenience method for setting the 'side' attribute of a 3d chart's frame Equivalent to:
     * <pre><code>
     *      frame.setOption("side", new FramePanel());
     * </code></pre>
     * @param sideFramePanel an instance of {@link FramePanel}
     *                       The side for the frame around a 3D chart.
     *
     * @return A reference to this {@link Frame} instance for convenient method chaining.
     */
    public Frame setSide(FramePanel sideFramePanel) {
        return this.setOption("side", sideFramePanel);
    }

    /**
     * Inner class to support setting 'frame' attributes in a 3d chart.  This class should not be instantiated
     * on its own, but as a parameter to a method of the {@link Frame} class.  Suggested usage:
     * <pre><code>
     *     chart.setOptions3d()
     *          .setFrame(new Frame()
     *              .setSide(new FramePanel()
     *                  .setColor(new Color(0, 0, 0, .5))
     *                  .setSize(2)
     *              )
     *          )
     *      ;
     * </code></pre>
     */
    public static class FramePanel extends Configurable<FramePanel> {
        /**
         * Convenience method for setting the 'color' attribute of a panel.  Equivalent to:
         * <pre><code>
         *      framePanel.setOption("color", new Color());
         * </code></pre>
         * @param color The color of the panel. Defaults to transparent.
         * @return A reference to this {@link FramePanel} instance for convenient method chaining.
         */
        public FramePanel setColor(Color color) {
            return this.setOption("color", color != null ? color.getOptionValue() : null);
        }

        /**
         * Convenience method for setting the 'size' attribute of a panel. Equivalent to:
         * <pre><code>
         *       framePanel.setOption("size", 5);
         * </code></pre>
         * @param size Thickness of the panel. Defaults to 1.
         * @return A reference to this {@link FramePanel} instance for convenient method chaining.
         */
        public FramePanel setSize(Number size) {
            return this.setOption("size", size);
        }
    }
}
