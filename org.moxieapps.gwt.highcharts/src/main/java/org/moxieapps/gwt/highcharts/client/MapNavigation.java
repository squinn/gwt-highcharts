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
 * TODO: HIGHMAPS
 * A configurable class that represents the custom map mapNavigation options which can then be set on the
 * chart via {@link MapChart#setMapNavigation(MapNavigation)}  These options control the look and functionality
 * of buttons that allow panning and zooming on a map.  Example usage:
 * <pre><code>
 *     map.setMapNavigation(new MapNavigation()
 *          .setEnabled(true)
 *          .setZoomInButton(new ButtonOptions()
 *              .setWidth(10)
 *           )
 *     );
 * </code></pre>
 *
 * @author cskowron@moxiegrouop.com (Cory Skowronek)
 * @since 1.7.0
 */
public class MapNavigation extends Configurable<MapNavigation> {
    /**
     * An enumeration of supported 'alignTo' values, which can be passed to the method
     * {@link ButtonOptions#setAlignTo(org.moxieapps.gwt.highcharts.client.MapNavigation.AlignTo)}
     */
    public enum AlignTo {

        PLOT_BOX("plotBox"),

        SPACING_BOX("spacingBox");

        private AlignTo(String optionValue) {
            this.optionValue = optionValue;
        }

        private final String optionValue;

        public String toString() {
            return optionValue;
        }

    }

    /**
     * Convenience method for setting the 'enableButtons' option of the mapNavigation.  Equivalent to:
     * <pre><code>
     *     mapNavigation.setOption("enableButtons", false);
     * </code></pre>
     * Whether to enable navigation buttons. By default it inherits the enabled setting.
     * @param enableButtons Whether to enable navigation buttons.
     * @return A reference to this {@link MapNavigation} instance for convenient method chaining.
     */
    public MapNavigation setEnableButtons(boolean enableButtons) {
        return this.setOption("enableButtons", enableButtons);
    }

    /**
     * Convenience method for setting the 'enableDoubleClickZoom' option of the mapNavigation.  Equivalent to:
     * <pre><code>
     *     mapNavigation.setOption("enableDoubleClickZoom", false);
     * </code></pre>
     * Enables zooming in on an area on double clicking in the map. By default it inherits the enabled setting.
     * @param enableDoubleClickZoom Whether to enable zooming via double-clicks.
     * @return A reference to this {@link MapNavigation} instance for convenient method chaining.
     */
    public MapNavigation setEnableDoubleClickZoom(boolean enableDoubleClickZoom) {
        return this.setOption("enableDoubleClickZoom", enableDoubleClickZoom);
    }

    /**
     * Convenience method for setting the 'enableDoubleClickZoomTo' option of the mapNavigation.  Equivalent to:
     * <pre><code>
     *     mapNavigation.setOption("enableDoubleClickZoomTo", true);
     * </code></pre>
     * Whether to zoom in on an area when that area is double clicked. Defaults to false.
     * @param enableDoubleClickZoomTo Whether to zoom in on an area when that area is double clicked.
     * @return A reference to this {@link MapNavigation} instance for convenient method chaining.
     */
    public MapNavigation setEnableDoubleClickZoomTo(boolean enableDoubleClickZoomTo) {
        return this.setOption("enableDoubleClickZoomTo", enableDoubleClickZoomTo);
    }

    /**
     * Convenience method for setting the 'enableMouseWheelZoom' option of the mapNavigation.  Equivalent to:
     * <pre><code>
     *     mapNavigation.setOption("enableMouseWheelZoom", false);
     * </code></pre>
     * Enables zooming by mouse wheel. By default it inherits the enabled setting.
     * @param enableMouseWheelZoom Whether to enable zooming via the mouse wheel.
     * @return A reference to this {@link MapNavigation} instance for convenient method chaining.
     */
    public MapNavigation setEnableMouseWheelZoom(boolean enableMouseWheelZoom) {
        return this.setOption("enableMouseWheelZoom", enableMouseWheelZoom);
    }

    /**
     * Convenience method for setting the 'enableTouchZoom' option of the mapNavigation.  Equivalent to:
     * <pre><code>
     *     mapNavigation.setOption("enableTouchZoom", false);
     * </code></pre> Whether to enable multitouch zooming. Note that if the chart covers the viewport, this prevents
     * the user from using multitouch and touchdrag on the web page, so you should make sure the user is not trapped
     * inside the chart. By default it inherits the enabled setting.
     * @param enableTouchZoom Whether to enable multitouch zooming.
     * @return A reference to this {@link MapNavigation} instance for convenient method chaining.
     */
    public MapNavigation setEnableTouchZoom(boolean enableTouchZoom) {
        return this.setOption("enableTouchZoom", enableTouchZoom);
    }

    /**
     * Convenience method for setting the 'enabled' option of the mapNavigation.  Equivalent to:
     * <pre><code>
     *     mapNavigation.setOption("enabled", true);
     * </code></pre>
     * Whether to enable map navigation. The default is not to enable navigation, as many choropleth maps are simple
     * and don't need it. Additionally, when touch zoom and mousewheel zoom is enabled, it breaks the default behaviour
     * of these interactions in the website, and the implementer should be aware of this.
     * <p/>
     * Individual interactions can be enabled separately, namely buttons, multitouch zoom, double click zoom, double
     * click zoom to element and mousewheel zoom.
     * <p/>
     * Defaults to false.
     * @param enabled Whether to enable map navigation.
     * @return A reference to this {@link MapNavigation} instance for convenient method chaining.
     */
    public MapNavigation setEnabled(boolean enabled) {
        return this.setOption("enabled", enabled);
    }

    /**
     * Convenience method for setting the 'buttonOptions' option of the mapNavigation.  Equivalent to:
     * <pre><code>
     *     mapNavigation.setOption("buttonOptions", );
     * </code></pre>
     * @param buttonOptions
     * @return A reference to this {@link MapNavigation} instance for convenient method chaining.
     */
    public MapNavigation setButtonOptions(ButtonOptions buttonOptions) {
        return this.setOption("buttonOptions", buttonOptions);
    }

    /**
     * Convenience method for setting the 'zoomIn' button options of the mapNavigation.  Equivalent to:
     * <pre><code>
     *     mapNavigation.setOption("buttons/zoomIn", new ButtonOptions());
     * </code></pre>
     * The individual options for the 'zoomIn' button.  Properties for this button are normally inherited from those
     * set via mapNavigation.setButtonOptions(), while individual options can be overridden.  By default, the onclick,
     * text, and y options are individual.
     * @param buttonOptions A set of options for the zoomIn button.
     * @return A reference to this {@link MapNavigation} instance for convenient method chaining.
     */
    public MapNavigation setZoomInButton(ButtonOptions buttonOptions) {
        return this.setOption("buttons/zoomIn", buttonOptions != null ? buttonOptions.getOptions() : null);
    }

    /**
     * Convenience method for setting the 'zoomOut' button options of the mapNavigation.  Equivalent to:
     * <pre><code>
     *     mapNavigation.setOption("buttons/zoomOut", new ButtonOptions());
     * </code></pre>
     * The individual options for the 'zoomOut' button.  Properties for this button are normally inherited from those
     * set via mapNavigation.setButtonOptions(), while individual options can be overridden.  By default, the onclick,
     * text, and y options are individual.
     * @param buttonOptions A set of options for the zoomOut button.
     * @return A reference to this {@link MapNavigation} instance for convenient method chaining.
     */
    public MapNavigation setZoomOutButton(ButtonOptions buttonOptions) {
        return this.setOption("buttons/zoomOut", buttonOptions != null ? buttonOptions.getOptions() : null);
    }

    /**
     * A configurable inner class representing general options for the map navigation buttons..
     */
    private class ButtonOptions extends Configurable<ButtonOptions> {
        /**
         * Convenience method for setting the 'align' option of the buttonOptions.  Equivalent to:
         * <pre><code>
         *     buttonOptions.setOption("align", Button.Align.RIGHT);
         * </code></pre>
         * The alignment of the navigation buttons. Defaults to left.
         * @param align The horizontal alignment of the navigation buttons
         * @return A reference to this {@link ButtonOptions} instance for convenient method chaining.
         */
        private ButtonOptions setAlign(Button.Align align) {
            return this.setOption("align", align != null ? align.toString() : null);
        }

        /**
         * Convenience method for setting the 'alignTo' option of the buttonOptions.  Equivalent to:
         * <pre><code>
         *     buttonOptions.setOption("alignTo", AlignTo.PLOTBOX);
         * </code></pre>
         * What box to align the buttons to. Possible values are plotBox and spacingBox. Defaults to plotBox.
         * @param alignTo The chart area to which map navigation buttons will be aligned.
         * @return A reference to this {@link ButtonOptions} instance for convenient method chaining.
         */
        private ButtonOptions setAlignTo(AlignTo alignTo) {
            return this.setOption("align", alignTo != null ? alignTo.toString() : null);
        }

        /**
         * Convenience method for setting the 'height' option of the buttonOptions.  Equivalent to:
         * <pre><code>
         *     buttonOptions.setOption("height", 10);
         * </code></pre>
         * The pixel height of the map navigation buttons. Defaults to 18.
         * @param height The height of the map navigation button.
         * @return A reference to this {@link ButtonOptions} instance for convenient method chaining.
         */
        private ButtonOptions setHeight(Number height) {
            return this.setOption("height", height);
        }

        /**
         * Convenience method for setting the 'style' option of the buttonOptions.  Equivalent to:
         * <pre><code>
         *     buttonOptions.setOption("style", new Style());
         * </code></pre>
         * Text styles for the map navigation buttons. Defaults to
         * <pre>
         *     {
         *         fontSize: '15px',
         *         fontWeight: 'bold',
         *         textAlign: 'center'
         *     }
         * </pre>
         * @param style An instance of the {@link Style} class representing CSS styles for the navigation button.
         * @return A reference to this {@link ButtonOptions} instance for convenient method chaining.
         */
        private ButtonOptions setStyle(Style style) {
            return this.setOption("style", style != null ? style.getOptions() : null);
        }

        /**
         * Convenience method for setting the 'theme' option of the buttonOptions.  Equivalent to:
         * <pre><code>
         *     buttonOptions.setOption("theme", new Theme());
         * </code></pre>
         * A configuration object for the button theme. The object accepts SVG properties like stroke-width, stroke and
         * fill. Tri-state button styles are supported by the states.hover and states.select objects.
         * @param theme An instance of the {@link Theme} class representing various SVG attributes for the navigation button.
         * @return A reference to this {@link ButtonOptions} instance for convenient method chaining.
         */
        private  ButtonOptions setTheme(Theme theme) {
            return this.setOption("theme", theme != null ? theme.getOptions() : null);
        }

        /**
         * Convenience method for setting the 'verticalAlign' option of the buttonOptions.  Equivalent to:
         * <pre><code>
         *     buttonOptions.setOption("verticalAlign", Button.VerticalAlign.TOP);
         * </code></pre>
         * The vertical alignment of the buttons. Individual alignment can be adjusted by each button's y offset.
         * Defaults to bottom.
         * @param verticalAlign The vertical alignment of the navigation button.
         * @return A reference to this {@link ButtonOptions} instance for convenient method chaining.
         */
        private ButtonOptions setVerticalAlign(Button.VerticalAlign verticalAlign) {
            return this.setOption("verticalAlign", verticalAlign != null ? verticalAlign.toString() : null);
        }

        /**
         * Convenience method for setting the 'width' option of the buttonOptions.  Equivalent to:
         * <pre><code>
         *     buttonOptions.setOption("width", );
         * </code></pre>
         * The width of the map navigation buttons. Defaults to 18.
         * @param width The width of the map navigation buttons.
         * @return A reference to this {@link ButtonOptions} instance for convenient method chaining.
         */
        private ButtonOptions setWidth(Number width) {
            return this.setOption("width", width);
        }

        /**
         * Convenience method for setting the 'x' option of the buttonOptions.  Equivalent to:
         * <pre><code>
         *     buttonOptions.setOption("x", );
         * </code></pre>
         * The X offset of the buttons relative to its align setting. Defaults to 0.
         * @param x The X offset of the buttons relative to its align setting.
         * @return A reference to this {@link ButtonOptions} instance for convenient method chaining.
         */
        private ButtonOptions setX(Number x) {
            return this.setOption("x", x);
        }


    }
}
