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
 * An interface that can be used as a callback handler when selection events are fired by the chart.
 * General usage is as follows:
 * <code><pre>
 * chart.setSelectionEventHandler(new ChartSelectionEventHandler() {
 *    public boolean onSelection(ChartSelectionEvent selectionEvent) {
 *       Window.alert("User selected from " + selectionEvent.getXAxisMin() + " to " + selectionEvent.getXAxisMax());
 *       return true;
 *    }
 * });
 * </pre></code>
 * See the documentation on the {@link ChartSelectionEvent} class for more details on the data
 * available when a selection event occurs.
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.1.0
 */
public interface ChartSelectionEventHandler {

    /**
     * This method is fired whenever a selection event occurs on the plot area of the chart.  See
     * the {@link ChartSelectionEvent} class for more details on the data available when this event is fired.
     *
     * @param chartSelectionEvent The details of the event that occurred.
     * @return The response to send back to the event handler function
     */
    public boolean onSelection(ChartSelectionEvent chartSelectionEvent);

}
