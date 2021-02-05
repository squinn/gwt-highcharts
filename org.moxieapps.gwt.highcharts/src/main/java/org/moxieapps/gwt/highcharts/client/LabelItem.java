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
 * A simple configurable object that can be used to position arbitrary HTML labels
 * anywhere in the chart area.  After creating a LabelItem it can then be added to the
 * chart via the {@link Chart#setLabelItems(LabelItem...)} method. Example usage:
 * <code><pre>
 * chart.setLabelItems(
 *    new LabelItem()
 *      .setHtml("United States")
 *      .setStyle(new Style()
 *         .setColor("#FF0000")
 *         .setTop("10px")
 *         .setLeft("10px")
 *      ),
 *    new LabelItem()
 *      .setHtml("Europe")
 *      .setStyle(new Style()
 *         .setColor("#0000FF")
 *         .setTop("10px")
 *         .setLeft("210px")
 *      ),
 * );
 * </pre></code>
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.0.0
 */
public class LabelItem extends Configurable<LabelItem> {

    /**
     * Convenience method for setting the 'html' option of the label item.  Equivalent to:
     * <pre><code>
     *     labelItem.setOption("html", "Australia");
     * </code></pre>
     * Inner HTML or text for the label. Defaults to "".
     *
     * @param html Inner HTML or text for the label.
     * @return A reference to this {@link LabelItem} instance for convenient method chaining.
     */
    public LabelItem setHtml(String html) {
        return this.setOption("html", html);
    }

    /**
     * Convenience method for setting the 'style' options of the label item.  Equivalent to:
     * <pre><code>
     *     labelItem.setOption("/style/left", "100px");
     *     labelItem.setOption("/style/top", "10px");
     *     etc.
     * </code></pre>
     * CSS styles for each label. To position the label, use left and top like this:
     * <pre><code>
     *    new LabelItem()
     *      .setHtml("Antarctica")
     *      .setStyle(new Style()
     *         .setColor("#0000FF")
     *         .setTop("10px")
     *         .setLeft("100px")
     *      )
     * <p/>
     * </code></pre>
     *
     * @param style CSS styles for each label
     * @return A reference to this {@link LabelItem} instance for convenient method chaining.
     */
    public LabelItem setStyle(Style style) {
        return this.setOption("style", style != null ? style.getOptions() : null);
    }
}
