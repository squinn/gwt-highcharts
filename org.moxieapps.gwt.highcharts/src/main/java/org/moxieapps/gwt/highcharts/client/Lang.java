package org.moxieapps.gwt.highcharts.client;

/**
 * A configurable class that can be used to globally configure the messages displayed by Highcharts.
 * These options should be configured prior to the initialization of any chart instance.
 * <p/>
 * Example usage:
 * <code><pre>
 *   Highcharts.setOptions(
 *     new Highcharts.Options().setLang(
 *         new Lang()
 *           .setMonths(new String[] { 'Janvier', 'Février', 'Mars', 'Avril', 'Mai', 'Juin',
 *             'Juillet', 'Août', 'Septembre', 'Octobre', 'Novembre', 'Décembre' })
 *           .setWeekdays(new String[] {'Dimanche', 'Lundi', 'Mardi', 'Mercredi', 'Jeudi', 'Vendredi', 'Samedi'})
 *   ));
 * </pre></code>
 *
 * @author myersj@gmail.com (Jeff Myers)
 * @since 1.4.0
 */
public class Lang extends Configurable<Lang> {

    /**
     * Expected array length of the months and shortMonths parameters.
     */
    private static final int MONTH_PARAM_LENGTH = 12;

    /**
     * Expected array length of the weekdays parameter.
     */
    private static final int WEEKDAYS_PARAM_LENGTH = 7;

    /**
     * Convenience method for setting the 'decimalPoint' lang option.  Equivalent to:
     * <pre><code>
     *     lang.setOption("decimalPoint", ",");
     * </code></pre>
     * The default decimal point used in the Highcharts.numberFormat method unless otherwise
     * specified in the function arguments. Defaults to ".".
     *
     * @param decimalPoint value to used as the decimal point by default when formatting numbers
     * @return A reference to this {@link Lang} instance for convenient method chaining.
     */
    public Lang setDecimalPoint(String decimalPoint) {
        return this.setOption("decimalPoint", decimalPoint);
    }

    /**
     * Convenience method for setting the 'downloadPNG' lang option.  Equivalent to:
     * <pre><code>
     *     lang.setOption("downloadPNG", "PNG");
     * </code></pre>
     * Exporting module only. The text for the PNG download menu item. Defaults to "Download PNG image".
     *
     * @param downloadPNG text for the PNG download menu item
     * @return A reference to this {@link Lang} instance for convenient method chaining.
     */
    public Lang setDownloadPNG(String downloadPNG) {
        return this.setOption("downloadPNG", downloadPNG);
    }

    /**
     * Convenience method for setting the 'downloadJPEG' lang option.  Equivalent to:
     * <pre><code>
     *     lang.setOption("downloadJPEG", "JPEG");
     * </code></pre>
     * Exporting module only. The text for the JPEG download menu item. Defaults to "Download JPEG image".
     *
     * @param downloadJPEG text for the JPEG download menu item
     * @return A reference to this {@link Lang} instance for convenient method chaining.
     */
    public Lang setDownloadJPEG(String downloadJPEG) {
        return this.setOption("downloadJPEG", downloadJPEG);
    }

    /**
     * Convenience method for setting the 'downloadPDF' lang option.  Equivalent to:
     * <pre><code>
     *     lang.setOption("downloadPDF", "PDF");
     * </code></pre>
     * Exporting module only. The text for the PDF download menu item. Defaults to "Download PDF document".
     *
     * @param downloadPDF text for the PDF download menu item
     * @return A reference to this {@link Lang} instance for convenient method chaining.
     */
    public Lang setDownloadPDF(String downloadPDF) {
        return this.setOption("downloadPDF", downloadPDF);
    }

    /**
     * Convenience method for setting the 'downloadSVG' lang option.  Equivalent to:
     * <pre><code>
     *     lang.setOption("downloadSVG", "SVG");
     * </code></pre>
     * Exporting module only. The text for the SVG download menu item. Defaults to "Download SVG vector image".
     *
     * @param downloadSVG text for the SVG download menu item
     * @return A reference to this {@link Lang} instance for convenient method chaining.
     */
    public Lang setDownloadSVG(String downloadSVG) {
        return this.setOption("downloadSVG", downloadSVG);
    }

    /**
     * Convenience method for setting the 'exportButtonTitle' lang option.  Equivalent to:
     * <pre><code>
     *     lang.setOption("exportButtonTitle", "Export");
     * </code></pre>
     * Exporting module only. The tooltip text for the export button. Defaults to "Export to raster or vector image".
     *
     * @param exportButtonTitle tooltip text for the export button
     * @return A reference to this {@link Lang} instance for convenient method chaining.
     */
    public Lang setExportButtonTitle(String exportButtonTitle) {
        return this.setOption("exportButtonTitle", exportButtonTitle);
    }

    /**
     * Convenience method for setting the 'loading' lang option.  Equivalent to:
     * <pre><code>
     *     lang.setOption("loading", "Loading");
     * </code></pre>
     * The loading text that appears when the chart is set into the loading state following a
     * call to chart.showLoading. Defaults to "Loading...".
     *
     * @param loading loading text message
     * @return A reference to this {@link Lang} instance for convenient method chaining.
     */
    public Lang setLoading(String loading) {
        return this.setOption("loading", loading);
    }

    /**
     * Convenience method for setting the 'months' lang option.  Equivalent to:
     * <pre><code>
     *     lang.setOption("months", months);
     * </code></pre>
     * An array containing the months names. Defaults to ['January', 'February', 'March',
     * 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'].
     *
     * @param months array containing the months names
     * @return A reference to this {@link Lang} instance for convenient method chaining.
     * @throws IllegalArgumentException if months param is null or not exactly 12 items.
     */
    public Lang setMonths(String[] months) {
        if (months == null || months.length != MONTH_PARAM_LENGTH) {
            throw new IllegalArgumentException("Month values incomplete");
        }

        return this.setOption("months", months);
    }

    /**
     * Convenience method for setting the 'noData' option of the chart. Equivalent to:
     * <pre><code>
     *     lsng.setOption("noData", "no data to display");
     * </code></pre>
     * The text to display when the chart has no data.  Defaults to "No data to display"
     * @param noData A String representing the message to be shown when a chart has no data
     * @return A reference to this {@link Lang} instance for convenient method chaining.
     */
    public Lang setNoData(String noData) {
        return this.setOption("noData", noData);
    }

    /**
     * Convenience method for setting the 'shortMonths' lang option.  Equivalent to:
     * <pre><code>
     *     lang.setOption("shortMonths", shortMonths);
     * </code></pre>
     * An array containing the months names in abbreviated form. Corresponds to the %b
     * format in Highcharts.dateFormat(). Defaults to ['Jan', 'Feb', 'Mar', 'Apr', 'May',
     * 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'].
     *
     * @param shortMonths array containing the months names in abbreviated form
     * @return A reference to this {@link Lang} instance for convenient method chaining.
     * @throws IllegalArgumentException if shortMonths param is null or not exactly 12 items.
     */
    public Lang setShortMonths(String[] shortMonths) {
        if (shortMonths == null || shortMonths.length != MONTH_PARAM_LENGTH) {
            throw new IllegalArgumentException("Short Month values incomplete");
        }

        return this.setOption("shortMonths", shortMonths);
    }

    /**
     * Convenience method for setting the 'printButtonTitle' lang option.  Equivalent to:
     * <pre><code>
     *     lang.setOption("printButtonTitle", "Print");
     * </code></pre>
     * Exporting module only. The tooltip text for the print button. Defaults to "Print the chart".
     *
     * @param printButtonTitle tooltip text for the print button
     * @return A reference to this {@link Lang} instance for convenient method chaining.
     */
    public Lang setPrintButtonTitle(String printButtonTitle) {
        return this.setOption("printButtonTitle", printButtonTitle);
    }

    /**
     * Convenience method for setting the 'rangeSelectorFrom' lang option.  Equivalent to:
     * <pre><code>
     *     lang.setOption("rangeSelectorFrom", "Start");
     * </code></pre>
     * StockChart only. The text for the label for the "from" input box in the range selector.
     * Defaults to "From".
     *
     * @param rangeSelectorFrom text for the label for the "from" input box
     * @return A reference to this {@link Lang} instance for convenient method chaining.
     */
    public Lang setRangeSelectorFrom(String rangeSelectorFrom) {
        return this.setOption("rangeSelectorFrom", rangeSelectorFrom);
    }

    /**
     * Convenience method for setting the 'rangeSelectorTo' lang option.  Equivalent to:
     * <pre><code>
     *     lang.setOption("rangeSelectorTo", "End");
     * </code></pre>
     * StockChart only. The text for the label for the "to" input box in the range selector.
     * Defaults to "To".
     *
     * @param rangeSelectorTo text for the label for the "to" input box
     * @return A reference to this {@link Lang} instance for convenient method chaining.
     */
    public Lang setRangeSelectorTo(String rangeSelectorTo) {
        return this.setOption("rangeSelectorTo", rangeSelectorTo);
    }

    /**
     * Convenience method for setting the 'rangeSelectorZoom' lang option.  Equivalent to:
     * <pre><code>
     *     lang.setOption("rangeSelectorZoom", "zoom");
     * </code></pre>
     * StockChart only. The text for the label for the range selector buttons. Defaults to "Zoom".
     *
     * @param rangeSelectorZoom text for the label for the range selector buttons
     * @return A reference to this {@link Lang} instance for convenient method chaining.
     */
    public Lang setRangeSelectorZoom(String rangeSelectorZoom) {
        return this.setOption("rangeSelectorZoom", rangeSelectorZoom);
    }

    /**
     * Convenience method for setting the 'resetZoom' lang option.  Equivalent to:
     * <pre><code>
     *     lang.setOption("resetZoom", "Reset");
     * </code></pre>
     * The text for the label appearing when a chart is zoomed. Defaults to "Reset zoom".
     *
     * @param resetZoom text for the label appearing when a chart is zoomed
     * @return A reference to this {@link Lang} instance for convenient method chaining.
     */
    public Lang setResetZoom(String resetZoom) {
        return this.setOption("resetZoom", resetZoom);
    }

    /**
     * Convenience method for setting the 'resetZoomTitle' lang option.  Equivalent to:
     * <pre><code>
     *     lang.setOption("resetZoomTitle", "Reset");
     * </code></pre>
     * The tooltip title for the label appearing when a chart is zoomed. Defaults to "Reset zoom level 1:1."
     *
     * @param resetZoomTitle tooltip title for the label appearing when a chart is zoomed
     * @return A reference to this {@link Lang} instance for convenient method chaining.
     */
    public Lang setResetZoomTitle(String resetZoomTitle) {
        return this.setOption("resetZoomTitle", resetZoomTitle);
    }

    /**
     * Convenience method for setting the 'thousandsSep' lang option.  Equivalent to:
     * <pre><code>
     *     lang.setOption("thousandsSep", ".");
     * </code></pre>
     * The default thousands separator used in the Highcharts.numberFormat method unless
     * otherwise specified in the function arguments. Defaults to ",".
     *
     * @param thousandsSep value to used as the thousands separator by default when formatting numbers
     * @return A reference to this {@link Lang} instance for convenient method chaining.
     */
    public Lang setThousandsSep(String thousandsSep) {
        return this.setOption("thousandsSep", thousandsSep);
    }

    /**
     * Convenience method for setting the 'weekdays' lang option.  Equivalent to:
     * <pre><code>
     *     lang.setOption("weekdays", weekdays);
     * </code></pre>
     * An array containing the weekday names. Defaults to ['Sunday', 'Monday', 'Tuesday',
     * 'Wednesday', 'Thursday', 'Friday', 'Saturday'].
     *
     * @param weekdays array containing the weekday names
     * @return A reference to this {@link Lang} instance for convenient method chaining.
     * @throws IllegalArgumentException if weekdays param is null or not exactly 7 items.
     */
    public Lang setWeekdays(String[] weekdays) {
        if (weekdays == null || weekdays.length != WEEKDAYS_PARAM_LENGTH) {
            throw new IllegalArgumentException("Weekdays values incomplete");
        }

        return this.setOption("weekdays", weekdays);
    }
}
