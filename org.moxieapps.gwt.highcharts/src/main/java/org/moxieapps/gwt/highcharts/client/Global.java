package org.moxieapps.gwt.highcharts.client;

/**
 * A configurable class that can be used to globally configure options for Highcharts.
 * These options should be configured prior to the initialization of any chart instance.
 * <p/>
 * Example usage:
 * <code><pre>
 *   Highcharts.setOptions(
 *     new Highcharts.Options().setGlobal(
 *         new Global()
 *           .setUseUTC(false)
 *   ));
 * </pre></code>
 *
 * @author myersj@gmail.com (Jeff Myers)
 * @since 1.4.0
 */
public class Global extends Configurable<Global> {

    /**
     * Convenience method for setting the 'canvasToolsURL' global option.  Equivalent to:
     * <pre><code>
     *     global.setOption("canvasToolsURL", "http://localhost/js/canvas-tools.js");
     * </code></pre>
     * The URL to the additional file to lazy load for Android 2.x devices. These devices
     * don't support SVG, so we download a helper file that contains canvg, its dependency
     * rbcolor, and our own CanVG Renderer class. To avoid hot linking to the highcharts
     * web site, you can install canvas-tools.js on your own server and change this option
     * accordingly.
     * Defaults to "http://www.highcharts.com/js/canvas-tools.js".
     *
     * @param canvasToolsURL URL of the canvas tools library
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.Global} instance for convenient method chaining.
     */
    public Global setCanvasToolsURL(String canvasToolsURL) {
        return this.setOption("canvasToolsURL", canvasToolsURL);
    }

    /**
     * Convenience method for setting the 'useUTC' global option.  Equivalent to:
     * <pre><code>
     *     global.setOption("useUTC", false);
     * </code></pre>
     * Whether to use UTC time for axis scaling, tickmark placement and time display in
     * Highcharts.dateFormat. Advantages of using UTC is that the time displays equally
     * regardless of the user agent's time zone settings. Local time can be used when the
     * data is loaded in real time or when correct Daylight Saving Time transitions are
     * required. Defaults to true.
     *
     * @param useUTC Flag to indicate whether time displays using UTC or not
     * @return A reference to this {@link org.moxieapps.gwt.highcharts.client.Global} instance for convenient method chaining.
     */
    public Global setUseUTC(boolean useUTC) {
        return this.setOption("useUTC", useUTC);
    }

}
