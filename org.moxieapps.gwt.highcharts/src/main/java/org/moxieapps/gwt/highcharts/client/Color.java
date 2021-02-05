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

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;

/**
 * Represents a color as either a solid RGB color, an RBG color with an alpha channel,
 * or a gradient of colors.  Many of the configurable chart objects support setting various
 * color options (backgrounds, borders, etc).  They all support a simply mechanism for
 * setting the color to a standard RGB hex value (such as {@link Chart#setBackgroundColor(String)}.
 * However, if they also support alpha channels or gradients an overloaded method will be
 * provided that takes a Color instance instead (e.g. {@link Chart#setBackgroundColor(Color)}.
 * <p/>
 * Example which sets the background color to a 10% opacity red color:
 * <pre><code>
 * chart.setBackgroundColor(new Color(255, 0, 0, .1));
 * </code></pre>
 * <p/>
 * Example which sets the background color to a linear gradient from white to
 * a 50% opaque blue:
 * <pre><code>
 * chart.setBackgroundColor(new Color()
 *   .setLinearGradient(0.0, 0.0, 1.0, 1.0)
 *   .addColorStop(0, "#FFFFFF")
 *   .addColorStop(0, 200, 200, 255, 0.5)
 * );
 * </code></pre>
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.0.0
 */
public class Color extends Configurable<Color> {

    /**
     * An empty constructor that can be used when creating a color as a gradient.  See the
     * {@link #setLinearGradient(double, double, double, double)} and {@link #addColorStop(double, String)}
     * methods (and their overloaded variants.)
     */
    public Color() {
    }

    /**
     * Create a color instance specifying the color in standard RGB hex notation (include the "#")
     *
     * @param rgbHexColor The RGB hex of the color (include the "#").
     */
    public Color(String rgbHexColor) {
        value = new JSONString(rgbHexColor);
    }

    /**
     * Create a color instance specifying the three components of the RGB color separately (will
     * result in a color that looks like "rgb(200, 255, 10)".
     *
     * @param r The red component of the color in the RGB color space (0 to 255)
     * @param g The green component of the color in the RGB color space (0 to 255)
     * @param b The blue component of the color in the RGB color space (0 to 255)
     */
    public Color(int r, int g, int b) {
        value = new JSONString(createRGB(r, g, b));

    }

    /**
     * Create a color instance specifying the three components of the RGB color separately as we
     * as the alpha channel (will result in a color that looks like "rgb(200, 255, 10, 0.5)".
     *
     * @param r The red component of the color in the RGB color space (0 to 255)
     * @param g The green component of the color in the RGB color space (0 to 255)
     * @param b The blue component of the color in the RGB color space (0 to 255)
     * @param a The alpha channel of the color (0.0 to 1.0)
     */
    public Color(int r, int g, int b, double a) {
        value = new JSONString(createRGBA(r, g, b, a));
    }

    private JSONValue value;

    /**
     * Sets up this color as a linear gradient from one location in space to another.
     * Coordinates can either be provided as whole numbers, in which case they are
     * treated as pixels.  Or, they can be provided as number with a "%" character on the
     * end, in which case they are treated in percentages. E.g.
     * <p/>
     * <pre><code>
     *   color.setLinearGradient("0", "0", "500", "500");
     * </code></pre>
     * Or:
     * <pre><code>
     *   color.setLinearGradient("20%", "20%", "80%", "80%");
     * </code></pre>
     * Note that you can also use the {@link #setLinearGradient(int, int, int, int)}
     * version if you know you're only going to be operating in pixels, or the
     * {@link #setLinearGradient(double, double, double, double)} if you're only operating
     * in percentages.
     *
     * @param x1 The x-coordinate of the start point of the gradient.
     * @param x2 The x-coordinate of the end point of the gradient.
     * @param y1 The y-coordinate of the start point of the gradient.
     * @param y2 The y-coordinate of the end point of the gradient.
     * @return A reference to this {@link Color} instance for convenient method chaining.
     */
    public Color setLinearGradient(String x1, String x2, String y1, String y2) {
        value = null;
        return this.setOption("linearGradient", new LinearGradient(x1, x2, y1, y2));
    }

    /**
     * Sets up this color as a linear gradient from one location in space to another, specifying
     * the coordinates in pixels.
     * <p/>
     * Note that you can also use the {@link #setLinearGradient(double, double, double, double)}
     * version if you know you instead want to operate in percentages, or the
     * {@link #setLinearGradient(String, String, String, String)} version if you need to
     * operate in both percentages and pixels concurrently.
     *
     * @param x1 The x-coordinate of the start point of the gradient (in pixels).
     * @param x2 The x-coordinate of the end point of the gradient (in pixels).
     * @param y1 The y-coordinate of the start point of the gradient (in pixels).
     * @param y2 The y-coordinate of the end point of the gradient (in pixels).
     * @return A reference to this {@link Color} instance for convenient method chaining.
     */
    public Color setLinearGradient(int x1, int x2, int y1, int y2) {
        value = null;
        return this.setOption("linearGradient", new LinearGradient(x1, x2, y1, y2));
    }

    /**
     * Sets up this color as a linear gradient from one location in space to another, specifying
     * the coordinates in percentages of the space the gradient will fill.  Note that the percentage
     * is specified by providing a floating point number in the range of 0.0 to 1.0, where 0.0 is
     * equivalent to "0%" and 1.0 is equivalent to "100%".
     * <p/>
     * Note that you can also use the {@link #setLinearGradient(int, int, int, int)}
     * version if you know you instead want to operate in pixels, or the
     * {@link #setLinearGradient(String, String, String, String)} version if you need to
     * operate in both percentages and pixels concurrently.
     *
     * @param x1 The x-percentage of the start point of the gradient (0.0 to 1.0)
     * @param x2 The x-percentage of the end point of the gradient (0.0 to 1.0)
     * @param y1 The y-percentage of the start point of the gradient (0.0 to 1.0)
     * @param y2 The y-percentage of the end point of the gradient (0.0 to 1.0)
     * @return A reference to this {@link Color} instance for convenient method chaining.
     */
    public Color setLinearGradient(double x1, double x2, double y1, double y2) {
        value = null;
        return this.setOption("linearGradient", new LinearGradient(x1, x2, y1, y2));
    }

    private JSONArray colorStops = new JSONArray();

    /**
     * Adds the specified color at some position within the gradient (to be used in
     * conjunction with the {@link #setLinearGradient(double, double, double, double)} method
     * or another one of its overloaded variants.)
     * <p/>
     * Example which sets the background color to a linear gradient from white to blue:
     * <pre><code>
     * chart.setBackgroundColor(new Color()
     *   .setLinearGradient(0.0, 0.0, 1.0, 1.0)
     *   .addColorStop(0.0, "#FFFFFF")
     *   .addColorStop(0.0, "#0000FF")
     * );
     * </code></pre>
     * Note that this method is intended to be used when you simply want to set the gradient
     * stop color to a standard RGB hex value.  If you need more control use the
     * {@link #addColorStop(double, int, int, int)} or {@link #addColorStop(double, int, int, int, double)}
     * method instead.
     *
     * @param offset      A floating point value between 0.0 and 1.0 that represents the position
     *                    between the start and end points in a gradient.
     * @param rgbHexColor The RGB hex color that the gradient should display at the given offset (include the "#").
     * @return A reference to this {@link Color} instance for convenient method chaining.
     */
    public Color addColorStop(double offset, String rgbHexColor) {
        return this.internalAddColorStop(offset, rgbHexColor);
    }

    /**
     * Adds the specified color at some position within the gradient (to be used in
     * conjunction with the {@link #setLinearGradient(double, double, double, double)} method
     * or another one of its overloaded variants.)
     * <p/>
     * Example which sets the background color to a linear gradient from white to blue:
     * <pre><code>
     * chart.setBackgroundColor(new Color()
     *   .setLinearGradient(0.0, 0.0, 1.0, 1.0)
     *   .addColorStop(0.0, 255, 255, 255)
     *   .addColorStop(0.0, 0, 0, 255)
     * );
     * </code></pre>
     * Note that this method is intended to be used when you simply want to set the gradient
     * stop color to a standard RGB hex value.  If you need more control use the
     * {@link #addColorStop(double, int, int, int, double)} method instead.
     *
     * @param offset A floating point value between 0.0 and 1.0 that represents the position
     *               between the start and end points in a gradient.
     * @param r      The red component of the color in the RGB color space (0 to 255)
     * @param g      The green component of the color in the RGB color space (0 to 255)
     * @param b      The blue component of the color in the RGB color space (0 to 255)
     * @return A reference to this {@link Color} instance for convenient method chaining.
     */
    public Color addColorStop(double offset, int r, int g, int b) {
        return this.internalAddColorStop(offset, createRGB(r, g, b));
    }

    /**
     * Adds the specified color at some position within the gradient allowing for the color
     * to be specified with an alpha channel (to be used in conjunction with the
     * {@link #setLinearGradient(double, double, double, double)} method or another one of its overloaded variants.)
     * <p/>
     * Example which sets the background color to a linear gradient from solid white to
     * a 50% opaque blue:
     * <pre><code>
     * chart.setBackgroundColor(new Color()
     *   .setLinearGradient(0.0, 0.0, 1.0, 1.0)
     *   .addColorStop(0.0, 255, 255, 255)
     *   .addColorStop(0.0, 0, 0, 255, 0.5)
     * );
     * </code></pre>
     *
     * @param offset A floating point value between 0.0 and 1.0 that represents the position
     *               between the start and end points in a gradient.
     * @param r      The red component of the color in the RGB color space (0 to 255)
     * @param g      The green component of the color in the RGB color space (0 to 255)
     * @param b      The blue component of the color in the RGB color space (0 to 255)
     * @param a      The alpha channel of the color (0.0 to 1.0)
     * @return A reference to this {@link Color} instance for convenient method chaining.
     */
    public Color addColorStop(double offset, int r, int g, int b, double a) {
        return this.internalAddColorStop(offset, createRGBA(r, g, b, a));
    }

    /**
     * This method will return the value of the object as a single value if it is
     * represented as just a solid color or as a JSONObject if it represents a gradient.
     * Note that this method is primarily intended for internal use.
     *
     * @return The value of this object as a single value (if appropriate), or a JSONObject
     *         if this color represents a gradient.
     */
    public JSONValue getOptionValue() {
        return value != null ? value : this.getOptions();
    }

    // Internal helper methods
    private Color internalAddColorStop(double offset, String color) {
        value = null;
        JSONArray colorStop = new JSONArray();
        colorStop.set(0, new JSONNumber(offset));
        colorStop.set(1, new JSONString(color));
        colorStops.set(colorStops.size(), colorStop);
        return this.setOption("stops", colorStops);
    }

    private String createRGB(int r, int g, int b) {
        return new StringBuilder()
            .append("rgb(")
            .append(r)
            .append(",")
            .append(g)
            .append(",")
            .append(b)
            .append(")").toString();
    }

    private String createRGBA(int r, int g, int b, double a) {
        return new StringBuilder()
            .append("rgba(")
            .append(r)
            .append(",")
            .append(g)
            .append(",")
            .append(b)
            .append(",")
            .append(a)
            .append(")").toString();
    }

    /**
     * Internal helper class for setting linear gradients.  This class has three constructors for the three
     * types of inputs for linear gradients. (i.e. String, int, double)
     */
    private class LinearGradient extends Configurable<LinearGradient> {

        private LinearGradient() {
            // Not called
        }

        private LinearGradient(String x1, String x2, String y1, String y2) {
            this.setOption("x1", x1)
                .setOption("x2", x2)
                .setOption("y1", y1)
                .setOption("y2", y2);
        }

        private LinearGradient(int x1, int x2, int y1, int y2) {
            this.setOption("x1", new JSONNumber(x1))
                .setOption("x2", new JSONNumber(x2))
                .setOption("y1", new JSONNumber(y1))
                .setOption("y2", new JSONNumber(y2));
        }

        private LinearGradient(double x1, double x2, double y1, double y2) {
            this.setOption("x1", new JSONString(((Double) (x1 * 100)).intValue() + "%"))
                .setOption("x2", new JSONString(((Double) (x2 * 100)).intValue() + "%"))
                .setOption("y1", new JSONString(((Double) (y1 * 100)).intValue() + "%"))
                .setOption("y2", new JSONString(((Double) (y2 * 100)).intValue() + "%"));
        }

    }

}
