package org.moxieapps.gwt.highcharts.client;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONString;

/**
 * A configurable class that will allow you to control the pane options of the charts, which
 * applies only to polar charts and angular gauges.  This configuration object holds general
 * options for the combined X and Y axes set. Each xAxis or yAxis can reference the pane by index.
 * An instance of this class can be constructed and then
 * set on the chart via the {@link org.moxieapps.gwt.highcharts.client.Chart#setPane(Pane)} method.
 * <p/>
 * Note: many of the pane options are only available if the highcharts-more.js script is included in your GWT module. E.g.:
 * </p>
 * &lt;script type="text/javascript" src="js/highcharts-more.js"&gt;&lt;/script&gt;
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.5.0
 */
public class Pane extends Configurable<Pane> {
    /**
     * Convenience method for setting the "background" option of the pane.  Sample usage:
     * <pre><code>
     *     chart.setPane(
     *          newPane()
     *              .setBackground(
     *                  new PaneBackground()
     *                      .setBackgroundColor(#333)
     *              )
     *      );
     * </code></pre>
     * @param paneBackgrounds An Instance of the PaneBackground class that has been set using its supplied methods.
     * @return A reference to this {@link Pane} instance for convenient method chaining.
     */
    public Pane setBackground(PaneBackground... paneBackgrounds) {
        return this.setOption("background", paneBackgrounds);
    }

    /**
     * Convenience method for setting the "center" option of the pane.  Equivalent to:
     * <pre><code>
     *     pane.setOption("center", [50, 50]);
     * </code></pre>
     * The center of a polar chart or angular gauge, given as an array of [x, y] positions.
     * Positions is given as integers that transform to pixels. Defaults to ['50%', '50%'].
     * Note: This method is for denoting the center of the pane as a pair of (x, y) coordinates.
     * If you instead want to represent the center as a percentage of the plot area size,
     * use this {@link #setCenter(String, String)}.
     * @param centerX The x value of the center of the pane in pixels.
     * @param centerY The y value of the center of the pane in pixels.
     * @return A reference to this {@link Pane} instance for convenient method chaining.
     */
    public Pane setCenter(Number centerX, Number centerY) {
        JSONArray center = new JSONArray();
        center.set(0, new JSONNumber(centerX.doubleValue()));
        center.set(1, new JSONNumber(centerY.doubleValue()));
        return this.setOption("center", center);

    }

    /**
     * Convenience method for setting the "center" option of the pane.  Equivalent to:
     * <pre><code>
     *     pane.setOption("center", ['50%', '50%']);
     * </code></pre>
     * The center of a polar chart or angular gauge, given as an array of [x, y] positions.
     * Positions are given as percentages of the plot area size.  Defaults to ['50%', '50%'].
     * Note: this method is for denoting the location of the center as a string.  If you instead
     * want to represent the center as a pair of (x, y) coordinates, use this {@link #setCenter(Number, Number)}.
     * @param centerX The x coordinate of the center of the pane a percentage of the plot size area.
     * @param centerY The x coordinate of the center of the pane a percentage of the plot size area.
     * @return A reference to this {@link Pane} instance for convenient method chaining.
     */
    public Pane setCenter(String centerX, String centerY) {
        JSONArray center = new JSONArray();
        center.set(0, new JSONString(centerX));
        center.set(1, new JSONString(centerY));
        return this.setOption("center", center);
    }


    /**
     * Convenience method for setting the 'startAngle' option of the pane.  Equivalent to:
     * <pre><code>
     *     pane.setOption("startAngle", 90);
     * </code></pre>
     * The start angle of the polar X axis or gauge axis, given in degrees where 0 is north. Defaults to 0.
     *
     * @param startAngle The start angle fo the polar X axis of the chart.
     * @return A reference to this {@link Pane} instance for convenient method chaining.
     */
    public Pane setStartAngle(Number startAngle) {
        return this.setOption("startAngle", startAngle);
    }

    /**
     * Convenience method for setting the 'endAngle' option of the pane.  Equivalent to:
     * <pre><code>
     *     pane.setOption("endAngle", 180);
     * </code></pre>
     * The end angle of the polar X axis or gauge value axis, given in degrees where 0 is north. Defaults to startAngle + 360.
     *
     * @param endAngle The end angle of the polar X axis or gauge value axis.
     * @return A reference to this {@link Pane} instance for convenient method chaining.
     */
    public Pane setEndAngle(Number endAngle) {
        return this.setOption("endAngle", endAngle);
    }

    /**
     * Convenience method for setting the 'size' option of the pane.  Equivalent to:
     * <pre><code>
     *     pane.setOption("size", 140);
     * </code></pre>
     * The size of the pane, either as a number defining pixels, or a percentage defining a percentage of the plot are.
     * Defaults to 85%.
     * Note that this method is used for defining the size as a number. For defining the size as a percentage of the plot
     * area use {@link Pane#setSize(String)}
     * @param size A Number defining the size of the pane in pixels.
     * @return @return A reference to this {@link Pane} instance for convenient method chaining.
     * @since 1.7.0
     * @see Pane#setSize(String)
     */
    public Pane setSize(Number size) {
        return this.setOption("size", size);
    }

    /**
     * Convenience method for setting the 'size' option of the pane.  Equivalent to:
     * <pre><code>
     *     pane.setOption("size", "90%");
     * </code></pre>
     * The size of the pane, either as a number defining pixels, or a percentage defining a percentage of the plot are.
     * Defaults to 85%.
     * Note that this method is used for defining the size as a percentage of the plot area.
     * For defining the size as a specific number of pixels use {@link Pane#setSize(Number)}
     * @param size A String defining the size of the pane in pixels.
     * @return @return A reference to this {@link Pane} instance for convenient method chaining.
     * @since 1.7.0
     * @see Pane#setSize(String)
     */
    public Pane setSize(String size) {
        return this.setOption("size", size);
    }

}
