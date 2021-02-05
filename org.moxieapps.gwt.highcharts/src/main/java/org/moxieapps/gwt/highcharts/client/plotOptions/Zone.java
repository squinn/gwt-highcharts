package org.moxieapps.gwt.highcharts.client.plotOptions;

import org.moxieapps.gwt.highcharts.client.Color;
import org.moxieapps.gwt.highcharts.client.Configurable;
import org.moxieapps.gwt.highcharts.client.PlotLine;

/**
 * A configurable class representing the general options for a plot's axis zones. These options
 * can be set on a chart's {@link PlotOptions} via the {@link PlotOptions#setZones(Zone...)}
 * method.
 * <p/>
 * Sample usage:
 * <pre><code>
 *     plotOptions.setZones(
 *          new Zone()
 *              .setDashStyle(PlotLine.DashStyle.SOLID)
 *              .setValue(3),
 *          new Zone()
 *              .setColor("#E0E0E0")
 *              .setValue(5)
 *     );
 * </code></pre>
 */
public class Zone extends Configurable<Zone> {

    /**
     * An enum used to define the Axis on which the zones are applied.
     */
    public enum Axis {
        X("x"),

        Y("y");

        private Axis(String optionValue) {
            this.optionValue = optionValue;
        }

        private String optionValue;

        public String toString() {
            return this.optionValue;
        }
    }

    /**
     * Convenience method for setting the 'color' option of the zone.  Equivalent to:
     * <pre><code>
     *     zone.setOption("color", new Color(0, 0, 0, .5));
     * </code></pre>
     * <p/>
     * Note that this method is intended for setting the color to a gradient or color that includes
     * an alpha channel.  If you instead just want to set the color to a normal RGB hex value
     * you can use the {@link #setColor(String)} version instead.
     * Defines the color of the series.
     * @param color Defines the color of the (non-area) series.
     * @return A link to this {@link Zone} instance for convenient method chaining.
     */
    public Zone setColor(Color color) {
        return this.setOption("color", color != null ? color.getOptionValue() : null);
    }

    /**
     * Convenience method for setting the 'color' option of the zone.  Equivalent to:
     * <pre><code>
     *     zone.setOption("color", "#f7a35c");
     * </code></pre>
     * <p/>
     * Note that this method is intended for setting the color to a simple RBG hex value.  If you instead
     * want to set a color to include an alpha channel or a gradient, use the {@link #setColor(Color)}
     * version instead.
     * Defines the color of the series.
     * @param color Defines the color of the (non-area) series.
     * @return A link to this {@link Zone} instance for convenient method chaining.
     */
    public Zone setColor(String color) {
        return this.setOption("color", color);
    }

    /**
     * Convenience method for setting the 'dashStyle' option of the zone.  Equivalent to:
     * <pre><code>
     *     zone.setOption("dashStyle", "Solid");
     * </code></pre>
     * A name for the dash style to use for the graph. See {@link PlotLine.DashStyle} for
     * available options
     * @param dashStyle The dash style to use for this zone.
     * @return A link to this {@link Zone} instance for convenient method chaining.
     */
    public Zone setDashStyle(PlotLine.DashStyle dashStyle) {
        return this.setOption("dashStyle", dashStyle != null ? dashStyle.toString() : null);
    }

    /**
     * Convenience method for setting the 'fillColor' option of the zone.  Equivalent to:
     * <pre><code>
     *     zone.setOption("fillColor", new Color(255, 255, 255, 0));
     * </code></pre>
     * <p/>
     * Note that this method is intended for setting the color to a gradient or color that includes
     * an alpha channel.  If you instead just want to set the color to a normal RGB hex value
     * you can use the {@link #setFillColor(String)} version instead.
     * @param fillColor Defines the fill color for the series (in an area type series)
     * @return A link to this {@link Zone} instance for convenient method chaining.
     */
    public Zone setFillColor(Color fillColor) {
        return this.setOption("fillColor", fillColor != null ? fillColor.getOptionValue() : null);
    }

    /**
     * Convenience method for setting the 'fillColor' option of the zone.  Equivalent to:
     * <pre><code>
     *     zone.setOption("fillColor", "#f7a35c");
     * </code></pre>
     * Defines the fill color for the series (in area type series)
     * <p/>
     * Note that this method is intended for setting the color to a simple RBG hex value.  If you instead
     * want to set a color to include an alpha channel or a gradient, use the {@link #setFillColor(Color)}
     * version instead.
     * @param fillColor Defines the fill color for the series (in an area type series)
     * @return A link to this {@link Zone} instance for convenient method chaining.
     */
    public Zone setFillColor(String fillColor) {
        return this.setOption("color", fillColor);
    }

    /**
     * Convenience method for setting the 'value' option of the zone.  Equivalent to:
     * <pre><code>
     *     zone.setOption("value", 5);
     * </code></pre>
     * The value up to where the zone extends, if undefined the zones stretches to the last value in the series.
     * Defaults to undefined.
     * @param value The axis value to which this zone will extend.
     * @return A link to this {@link Zone} instance for convenient method chaining.
     */
    public Zone setValue(Number value) {
        return this.setOption("value", value);
    }
}

