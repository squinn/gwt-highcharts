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
 * A configurable class that can be used to represent custom animation options, which
 * can then be set as the default animation approach for the entire chart via the
 * {@link Chart#setAnimation(Animation)} method, or just set for certain operations (such as
 * when adding a new point to a series in {@link Series#addPoint(Number, boolean, boolean, Animation)}.
 * Example usage:
 * <code><pre>
 *   chart.setAnimation(
 *     new Animation()
 *       .setDuration(100)
 *       .setEasing(Animation.Easing.LINEAR)
 *   );
 * </pre></code>
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.0.0
 */
public class Animation extends Configurable<Animation> {

    /**
     * An enumeration of supported animation easing types, which can be passed to methods such as
     * {@link Animation#setEasing(Animation.Easing)}.  Note that more easing functions are
     * supported via <a href="http://gsgd.co.uk/sandbox/jquery/easing/">jQuery plugins</a>, in
     * which case you'll want to use the general {@link Animation#setEasing(String)} method
     * instead to set the easing to a specific string (instead of being restricted to the easing
     * types included in this enumeration.)
     */
    public enum Easing {

        /**
         * Displays a constant pace transition.
         */
        LINEAR("linear"),

        /**
         * Displays the default jQuery easing transition.
         */
        SWING("swing");

        private Easing(String optionValue) {
            this.optionValue = optionValue;
        }

        private final String optionValue;

        public String toString() {
            return optionValue;
        }

    }

    /**
     * Convenience method for setting the 'duration' option of the animation.  Equivalent to:
     * <pre><code>
     *     animation.setOption("duration", 500);
     * </code></pre>
     *
     * @param duration The duration of the animation in milliseconds.
     * @return A reference to this {@link Animation} instance for convenient method chaining.
     */
    public Animation setDuration(Number duration) {
        return this.setOption("duration", duration);
    }

    /**
     * Convenience method for setting the 'easing' option of the animation.  Equivalent to:
     * <pre><code>
     *     animation.setOption("easing", "linear");
     * </code></pre>
     * Note that more easing functions are available using
     * <a href="http://gsgd.co.uk/sandbox/jquery/easing/">jQuery plugins</a>, in which case
     * you'll want to use the {@link #setEasing(String)} method instead.
     *
     * @param easing The type of easing transition that you would like animations to use (the default is {@link Animation.Easing#SWING});
     * @return A reference to this {@link Animation} instance for convenient method chaining.
     */
    public Animation setEasing(Easing easing) {
        return this.setOption("easing", easing.toString());
    }

    /**
     * Convenience method for setting the 'easing' option of the animation.  Equivalent to:
     * <pre><code>
     *     animation.setOption("easing", "linear");
     * </code></pre>
     * Note that this method is primarily intended to be used when you're using a
     * <a href="http://gsgd.co.uk/sandbox/jquery/easing/">jQuery plugin</a> to support additional
     * easing types.  If you're just using standard jQuery easing types you'll want to use the
     * {@link #setEasing(Animation.Easing)} method instead.
     *
     * @param easing The type of easing transition that you would like animations to use (the default is "swing");
     * @return A reference to this {@link Animation} instance for convenient method chaining.
     */
    public Animation setEasing(String easing) {
        return this.setOption("easing", easing);
    }

}
