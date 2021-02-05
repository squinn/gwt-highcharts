package org.moxieapps.gwt.highcharts.client;

/**
 * A configurable class that will allow you to control the options for exporting module.  An instance of
 * this class can be constructed and then  set on the chart via the
 * {@link BaseChart#setExporting(Exporting)} method.
 * <p/>
 * Note that the "exporting" module must be included in the page in order for the exporting
 * navigation options to apply.  E.g.:
 * <p/>
 * &lt;script type="text/javascript" src="js/modules/exporting.js"&gt;&lt;/script&gt;
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.1.0
 */
public class Exporting extends Configurable<Exporting> {

    /**
     * An enumeration of supported exporting file types, which can be passed to the
     * {@link Exporting#setType(Exporting.Type)} method.
     */
    public enum Type {

        /**
         * Portable Network Graphics file type
         */
        PNG("image/png"),

        /**
         * Joint Photographic Experts Group file type
         */
        JPEG("image/jpeg"),

        /**
         * Portable Document Format file type
         */
        PDF("application/pdf"),

        /**
         * Scalable Vector Graphics file type
         */
        SVG("image/svg+xml");

        private Type(String optionValue) {
            this.optionValue = optionValue;
        }

        private final String optionValue;

        public String toString() {
            return optionValue;
        }

    }

    /**
     * Convenience method for directly setting the options for the context button. Equivalent to:
     * <pre><code>
     *     exporting.setOption("/buttons/contextButton/align", "right");
     * </code></pre>
     * @param contextButton An instance of the ContextButton class
     * @return A reference to this {@link Exporting} instance for convenient method chaining.
     * @since 1.6.0
     */
    public Exporting setContextButton(ContextButton contextButton) {
        return this.setOption("/buttons/contextButton", contextButton);
    }

    /**
     * Convenience method for setting the 'enabled' option for the exporting module.  Equivalent to:
     * <pre><code>
     *     exporting.setOption("enabled", true);
     * </code></pre>
     * Whether to enable the exporting module. Defaults to true, but note that the exporting module
     * Javascript file must be included in the source of the page in order for the exporting
     * functionality to appear.
     *
     * @param enabled Whether or not to enable or disable the exporting module for the chart.
     * @return A reference to this {@link Exporting} instance for convenient method chaining.
     */
    public Exporting setEnabled(boolean enabled) {
        return this.setOption("enabled", enabled);
    }

    /**
     * Convenience method for setting the 'filename' option for the exporting module.  Equivalent to:
     * <pre><code>
     *     exporting.setOption("filename", "chart");
     * </code></pre>
     * The filename, without extension, to use for the exported chart. Defaults to "chart".
     *
     * @param fileName The filename, without extension, to use for the exported chart.
     * @return A reference to this {@link Exporting} instance for convenient method chaining.
     */
    public Exporting setFilename(String fileName) {
        return this.setOption("filename", fileName);
    }

    /**
     * Convenience method for setting the 'scale' option for exporting module.  Equivalent to:
     * <pre><code>
     *       exporting.setOption("scale", 2)
     * </pre></code>
     * Defines the scale or zoom factor for the exported image compared to the on-screen display.
     * While for instance a 600px wide chart may look good on a website, it will look bad in print.
     * The default scale of 2 makes this chart export to a 1200px PNG or JPG. Defaults to 2.
     * @param scale The scale to use for the exported chart.
     * @return A reference to this {@link Exporting} instance for convenient method chaining.
     * @since 1.6.0
     */
    public Exporting setScale(Number scale) {
        return this.setOption("scale", scale);
    }

    /**
     * Convenience method for setting the 'sourceHeight' option for the exporting module.  Equivalent to:
     * <pre><code>
     *     exporting.setOption("sourceHeight", 400);
     * </code></pre>
     * The height of the original chart when exported, unless an explicit chart.height is set.
     * The height exported raster image is then multiplied by scale.
     * @param sourceHeight The height of the original chart to be used for exporting.
     * @return  A reference to this {@link Exporting} instance for convenient method chaining.
     * @since 1.6.0
     */
    public Exporting setSourceHeight(Number sourceHeight) {
        return this.setOption("height", sourceHeight);
    }

    /**
     * Convenience method for setting the 'sourceWidth' option for the exporting module.  Equivalent to:
     * <pre><code>
     *     exporting.setOption("sourceWidth", 600);
     * </code></pre>
     * The width of the original chart when exported, unless an explicit chart.width is set.
     * The width exported raster image is then multiplied by scale.
     * @param sourceWidth The width of the original chart to be used for exporting.
     * @return A reference to this {@link Exporting} instance for convenient method chaining.
     * @since 1.6.0
     */
    public Exporting setSourceWidth(Number sourceWidth) {
       return this.setOption("sourceWidth", sourceWidth);
    }

    /**
     * Convenience method for setting the 'type' option for the exporting module.  Equivalent to:
     * <pre><code>
     *     exporting.setOption("type", "image/jpeg");
     * </code></pre>
     * Default MIME type for exporting if chart.exportChart() is called without specifying a type option.
     * Possible values are image/png, image/jpeg, application/pdf and image/svg+xml. Defaults to "image/png".
     *
     * @param type The default file format that exported charts should be created as.
     * @return A reference to this {@link Exporting} instance for convenient method chaining.
     */

    public Exporting setType(Type type) {
        return this.setOption("type", type != null ? type.toString() : null);
    }

    /**
     * Convenience method for setting the 'url' option for the exporting module.  Equivalent to:
     * <pre><code>
     *     exporting.setOption("url", "http://export.highcharts.com");
     * </code></pre>
     * The URL for the server module converting the SVG string to an image format. By default this
     * points to Highslide Software's free web service. Defaults to http://export.highcharts.com.
     *
     * @param url The URL for the server module converting the SVG string to an image format.
     * @return A reference to this {@link Exporting} instance for convenient method chaining.
     */
    public Exporting setUrl(String url) {
        return this.setOption("url", url);
    }

    /**
     * Convenience method for setting the 'width' option for the exporting module.  Equivalent to:
     * <pre><code>
     *     exporting.setOption("width", 600);
     * </code></pre>
     * The pixel width of charts exported to PNG or JPG. Defaults to 800.
     * As of Highcharts 3.0, the default pixel width is a function of the chart.width or exporting.sourceWidth
     * and the exporting.scale. Defaults to undefined.
     *
     * @param width The pixel width of charts exported to PNG or JPG.
     * @return A reference to this {@link Exporting} instance for convenient method chaining.
     */
    public Exporting setWidth(Number width) {
        return this.setOption("width", width);
    }

}
