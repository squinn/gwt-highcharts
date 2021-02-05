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
 * The range selector is a tool for selecting ranges to display within a {@link org.moxieapps.gwt.highcharts.client.StockChart}. It provides buttons to select
 * preconfigured ranges in the chart, like 1 day, 1 week, 1 month, etc. It also provides input boxes where min
 * and max dates can be manually input.
 * Basic usage is as follows:
 * <pre><code>
 * stockChart.setRangeSelector(new RangeSelector()
 *    .setButtons(
 *       new RangeSelector.Button()
 *          .setButtonType(RangeSelector.ButtonType.DAY)
 *          .setCount(1)
 *          .setText("1d"),
 *       new RangeSelector.Button()
 *          .setButtonType(RangeSelector.ButtonType.WEEK)
 *          .setCount(2)
 *          .setText("2w"),
 *       new RangeSelector.Button()
 *          .setButtonType(RangeSelector.ButtonType.MONTH)
 *          .setCount(3)
 *          .setText("2m")
 *    )
 *    .setSelected(1)
 *    .setButtonSpacing(10));
 * </code></pre>
 *
 * @author myersj@gmail.com (Jeff Myers)
 * @since 1.5.0
 */
public class RangeSelector extends Configurable<RangeSelector> {

    /**
     * An enumeration of supported range selector horizontal alignment types, which can be passed to methods
     * like {@link RangeSelector#setInputPositionAlign(org.moxieapps.gwt.highcharts.client.RangeSelector.Align)} method.
     */
    public enum Align {

        /**
         * Left align the range selector input box
         */
        LEFT("left"),

        /**
         * Center the range selector input box
         */
        CENTER("center"),

        /**
         * Right align the range selector input box
         */
        RIGHT("right");

        private Align(String optionValue) {
            this.optionValue = optionValue;
        }

        private final String optionValue;

        public String toString() {
            return optionValue;
        }

    }

    /**
     * An enumeration of supported range selector vertical alignment types, which can be passed to methods
     * like {@link Credits#setVerticalAlign(Credits.VerticalAlign)} method.
     */
    public enum VerticalAlign {

        /**
         * Show the range selector input box at the top of the chart
         */
        TOP("top"),

        /**
         * Show the range selector input box in the middle of the chart
         */
        MIDDLE("middle"),

        /**
         * Show the range selector input box at the bottom of the chart
         */
        BOTTOM("bottom");

        private VerticalAlign(String optionValue) {
            this.optionValue = optionValue;
        }

        private final String optionValue;

        public String toString() {
            return optionValue;
        }

    }

    /**
     * An enumeration of supported range selector button types, which can be used with the {@link RangeSelector.Button#setType(RangeSelector.ButtonType)} method.
     */
    public static enum ButtonType {
        MILLISECOND("millisecond"),
        SECOND("second"), 
        MINUTE("minute"),
        DAY("day"), 
        WEEK("week"),
        MONTH("month"),
        YTD("ytd"),
        YEAR("year"),
        ALL("all");
        
        private final String optionName;
        
        private ButtonType(String optionName) {
            this.optionName = optionName;
        }
        
        @Override
        public String toString() {
            return optionName;
        }
    }
    
    /**
     * Manages the options for configuring the buttons to show within the {@link RangeSelector} of
     * a {@link org.moxieapps.gwt.highcharts.client.StockChart}. For example, to create a button to display a 6 month time selection:
     * <pre><code>
     *    new RangeSelector.Button()
     *       .setType(RangeSelector.ButtonType.MONTH)
     *       .setCount(6)
     *       .setText("6m");
     * </code></pre>
     *
     * @see RangeSelector#setButtons(RangeSelector.Button...)
     */
    public static class Button extends Configurable<Button> {
        /**
         * Defines the timespan unit of the button.
         * @param type the button type which defines the timespan unit of the button
         * @return A reference to this {@link RangeSelector.Button} instance for convenient method chaining.
         */
        public Button setType(ButtonType type) {
            return this.setOption("type", type);
        }
        
        /**
         * Defines how many units of the defined type to use.
         * @param count the count of the type unit 
         * @return A reference to this {@link RangeSelector.Button} instance for convenient method chaining.
         */
        public Button setCount(Number count) {
            return this.setOption("count", count);
        }
        
        /**
         * Set the text to display on the button
         * @param text the text to display on the button
         * @return A reference to this {@link RangeSelector.Button} instance for convenient method chaining.
         */
        public Button setText(String text) {
            return this.setOption("text", text);
        }
    }
    
    /**
     * Set the space in pixels between the buttons in the range selector. Defaults to <code>0</code>.
     * @param buttonSpacing the pixel space between the buttons
     * @return A reference to this {@link RangeSelector} instance for convenient method chaining.
     */
    public RangeSelector setButtonSpacing(Number buttonSpacing) {
        return this.setOption("buttonSpacing", buttonSpacing);
    }
    
    /**
     * Configure the buttons to show in the range selector. See {@link RangeSelector.Button} for button configuration
     * options.
     *  
     * @param buttons the buttons to display in the range selector.
     * @return A reference to this {@link RangeSelector} instance for convenient method chaining.
     */
    public RangeSelector setButtons(Button...buttons) {
        return this.setOption("buttons", buttons);
    }
    
    /**
     * Enable or disable the range selector. Defaults to <code>true</code>.
     * @param enabled true to enable the range selector, false to disable.
     * @return A reference to this {@link RangeSelector} instance for convenient method chaining.
     */
    public RangeSelector setEnabled(boolean enabled) {
        return this.setOption("enabled", enabled);
    }
    
    /**
     * The date format in the input boxes when not selected for editing. Defaults to "<code>%b %e, %Y</code>".
     * @param inputDateFormat the date format in the input boxes when not selected for editing.
     * @return A reference to this {@link RangeSelector} instance for convenient method chaining.
     */
    public RangeSelector setInputDateFormat(String inputDateFormat) {
        return this.setOption("inputDateFormat", inputDateFormat);
    }
    
    /**
     * The date format in the input boxes when they are selected for editing. 
     * This must be a format that is recognized by JavaScript <code>Date.parse</code>. Defaults to "<code>%Y-%m-%d</code>".
     * @param inputEditDateFormat The date format in the input boxes when they are selected for editing.
     * @return A reference to this {@link RangeSelector} instance for convenient method chaining.
     */
    public RangeSelector setInputEditDateFormat(String inputEditDateFormat) {
        return this.setOption("inputEditDateFormat", inputEditDateFormat);
    }
    
    /**
     * Enable or disable the date input boxes.
     * @param inputEnabled true to enable the date input boxes, false to disable.
     * @return A reference to this {@link RangeSelector} instance for convenient method chaining.
     */
    public RangeSelector setInputEnabled(boolean inputEnabled) {
        return this.setOption("inputEnabled", inputEnabled);
    }


    /**
     * Convenience method for setting the 'inputPosition' option for the rangeSelector.  Equivalent to:
     * <pre><code>
     *     stockChart.setOption("/inputPosition/VerticalAlign", center);
     * </code></pre>
     * Sample usage:
     * <pre><code>
     *     stockChart.setRangeSelector(
     *         new RangeSelector()
     *              .setInputPositionAlign(Align.LEFT)
     *     );
     * </code></pre>
     * Can be one of either 'left, 'center', or right'
     * @param align The horizontal alignment for the input box.
     * @return A reference to this {@link RangeSelector} instance for convenient method chaining.
     * @since 1.6.0
     */
    public RangeSelector setInputPositionAlign(Align align) {
        return this.setOption("/inputPosition/VerticalAlign", align != null ? align.toString() : null);
    }

    /**
     * Convenience method for setting the 'inputPosition' option for the rangeSelector.  Equivalent to:
     * <pre><code>
     *     stockChart.setOption("/inputPosition/verticalAlign", top);
     * </code></pre>
     * Sample usage:
     * <pre><code>
     *     stockChart.setRangeSelector(
     *         new RangeSelector()
     *              .setInputPositionAlign(VerticalAlign.TOP)
     *     );
     * </code></pre>
     * Can be one of either 'top, 'middle', or 'bottom'
     * @param verticalAlign The vertical position for the input box.
     * @return A reference to this {@link RangeSelector} instance for convenient method chaining.
     * @since 1.6.0
     */
    public RangeSelector setInputPositionVerticalAlign(VerticalAlign verticalAlign) {
        return this.setOption("/inputPosition/verticalAlign", verticalAlign != null ? verticalAlign.toString() : null);
    }

    /**
     * Convenience method for setting the 'inputPosition' option for the rangeSelector.  Equivalent to:
     * <pre><code>
     *     stockChart.setOption("/inputPosition/x", 15);
     * </code></pre>
     * Sample usage:
     * <pre><code>
     *     stockChart.setRangeSelector(
     *         new RangeSelector()
     *              .setInputPositionX(15)
     *     );
     * </code></pre>
     * @param x the x offset for the input box.
     * @return A reference to this {@link RangeSelector} instance for convenient method chaining.
     * @since 1.6.0
     */
    public RangeSelector setInputPositionX(Number x) {
        return this.setOption("/inputPosition/x", x);
    }

    /**
     * Convenience method for setting the 'inputPosition' option for the rangeSelector.  Equivalent to:
     * <pre><code>
     *     stockChart.setOption("/inputPosition/y", 10);
     * </code></pre>
     * Sample usage:
     * <pre><code>
     *     stockChart.setRangeSelector(
     *         new RangeSelector()
     *              .setInputPositionY(10)
     *     );
     * </code></pre>
     * @param y The y offset for the input box.
     * @return A reference to this {@link RangeSelector} instance for convenient method chaining.
     * @since 1.6.0
     */
    public RangeSelector setInputPositionY(Number y) {
        return this.setOption("/inputPosition/y", y);
    }

    /**
     * CSS for the HTML inputs in the range selector.
     * @param inputStyle The CSS style object containing the style for the range selector inputs.
     * @return A reference to this {@link RangeSelector} instance for convenient method chaining.
     * @since 1.6.0
     */
    public RangeSelector setInputStyle(Style inputStyle) {
        return this.setOption("inputStyle", inputStyle != null ? inputStyle.getOptions() : null);
    }

    /**
     * CSS styles for the labels - the Zoom, From and To texts.
     * @param labelStyle The CSS style object containing the style for the range selector label.
     * @return A reference to this {@link RangeSelector} instance for convenient method chaining.
     * @since 1.6.0
     */
    public RangeSelector setLabelStyle(Style labelStyle) {
        return this.setOption("labelStyle", labelStyle != null ? labelStyle.getOptions() : null);
    }

    /**
     * Set the index of the button to appear pre-selected. Defaults to <code>null</code>.
     * @param selected the index of the button to appear pre-selected.
     * @return A reference to this {@link RangeSelector} instance for convenient method chaining.
     */
    public RangeSelector setSelected(Number selected) {
        return this.setOption("selected", selected);
    }
}