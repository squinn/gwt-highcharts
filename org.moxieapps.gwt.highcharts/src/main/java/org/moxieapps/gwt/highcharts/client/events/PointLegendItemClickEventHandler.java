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

package org.moxieapps.gwt.highcharts.client.events;

/**
 * An interface that can be used as a callback handler when legend click events are fired on the individual
 * points in a pie series.  General usage is as follows:
 * <code><pre>
 * chart.setPiePlotOptions(new PiePlotOptions()
 *    .setPointLegendItemClickEventHandler(new PointLegendItemClickEventHandler() {
 *       public boolean onClick(PointLegendItemClickEvent event) {
 *          Window.alert("Legend item clicked: " + event.getXAsLong() + ", " + event.getYAsLong());
 *          return true;
 *       }
 *    )
 * });
 * </pre></code>
 * See the documentation on the {@link PointLegendItemClickEvent} class for more details on the data
 * available when a point legend item click event occurs on a pie series.
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.1.2
 */
public interface PointLegendItemClickEventHandler {

    /**
     * This method is fired whenever a click event occurs on an individual legend item in a pie series.  See
     * the {@link PointLegendItemClickEvent} class for more details on the data available when this event is fired.
     * <p/>
     * Return false to prevent the selection from occurring.
     *
     * @param pointLegendItemClickEvent The details of the event that occurred.
     * @return The response to send back to the event handler function.  Return false to prevent the action.
     */
    public boolean onClick(PointLegendItemClickEvent pointLegendItemClickEvent);

}
