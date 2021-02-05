package org.moxieapps.gwt.highcharts.client;

/**
 * A configurable class that will allow you to control the options for buttons and menus
 * appearing in the exporting module.  An instance of this class can be constructed and then
 * set on the chart via the {@link BaseChart#setNavigation(Navigation)} method.
 * <p/>
 * Note that the "exporting" module must be included in the page in order for the exporting
 * navigation options to apply.  E.g.:
 * <p/>
 * &lt;script type="text/javascript" src="js/modules/exporting.js"&gt;&lt;/script&gt;
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.1.0
 */
public class Navigation extends Configurable<Navigation> {

    /**
     * Convenience method for setting the 'menuStyle' options of the navigation area.  Equivalent to:
     * <pre><code>
     *     navigation.setOption("/menuStyle/left", "100px");
     *     navigation.setOption("/menuStyle/top", "10px");
     *     etc.
     * </code></pre>
     * CSS styles for the popup menu appearing by default when the export icon is clicked. This menu is rendered in HTML.
     * Default options for the "menuStyle" are as follows:
     * <ul>
     * <li><b>border</b>: '1px solid #A0A0A0'</li>
     * <li><b>background</b>: '#FFFFFF</li>
     * </ul>
     *
     * @param menuStyle CSS styles for the popup menus of the exporting module
     * @return A reference to this {@link Navigation} instance for convenient method chaining.
     */
    public Navigation setMenuStyle(Style menuStyle) {
        return this.setOption("menuStyle", menuStyle != null ? menuStyle.getOptions() : null);
    }

    /**
     * Convenience method for setting the 'menuItemStyle' options of the navigation area.  Equivalent to:
     * <pre><code>
     *     navigation.setOption("/menuItemStyle/left", "100px");
     *     navigation.setOption("/menuItemStyle/top", "10px");
     *     etc.
     * </code></pre>
     * CSS styles for the individual items within the popup menu appearing by default when the export icon
     * is clicked. The menu items are rendered in HTML.  Default options for the "menuItemStyle" are as follows:
     * <ul>
     * <li><b>padding</b>: '0 5px'</li>
     * <li><b>background</b>: NONE</li>
     * <li><b>color</b>: '#303030'</li>
     * </ul>
     *
     * @param menuItemStyle CSS styles for the individual items in the popup menus of the exporting module.
     * @return A reference to this {@link Navigation} instance for convenient method chaining.
     */
    public Navigation setMenuItemStyle(Style menuItemStyle) {
        return this.setOption("menuItemStyle", menuItemStyle != null ? menuItemStyle.getOptions() : null);
    }

    /**
     * Convenience method for setting the 'menuItemHoverStyle' options of the navigation area.  Equivalent to:
     * <pre><code>
     *     navigation.setOption("/menuItemHoverStyle/left", "100px");
     *     navigation.setOption("/menuItemHoverStyle/top", "10px");
     *     etc.
     * </code></pre>
     * CSS styles for the hover state of the individual items within the popup menu appearing by default
     * when the export icon is clicked. The menu items are rendered in HTML.  Default options for
     * the "menuItemHoverStyle" are as follows:
     * <ul>
     * <li><b>background</b>: '#4572A5'</li>
     * <li><b>color</b>: '#FFFFFF'</li>
     * </ul>
     *
     * @param menuItemHoverStyle CSS styles for the hover style of the individual items in the popup menus
     *                           of the exporting module.
     * @return A reference to this {@link Navigation} instance for convenient method chaining.
     */
    public Navigation setMenuItemHoverStyle(Style menuItemHoverStyle) {
        return this.setOption("menuItemHoverStyle", menuItemHoverStyle != null ? menuItemHoverStyle.getOptions() : null);
    }

    /**
     * Convenience method for setting the "buttonOptions" for the export button.  Sample usage:
     * <pre><code>
     *     chart.setNavigation(
     *         new Navigation()
     *             .setButtonOptions(
     *                 new Button()
     *                     .setAlign(Button.Align.RIGHT)
     *                     .setSymbolFill("#E0E0E0")
     *             )
     *     );
     * </code></pre>
     * @param button The export button with options set using methods in {@link Button}.
     * @return A reference to this {@link Navigation} instance for convenient method chaining.
     * @since 1.6.0
     */
    public Navigation setButtonOptions(Button button) {
        return this.setOption("/buttonOptions", button);
    }
}
