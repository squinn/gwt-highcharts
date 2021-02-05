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
 * An interface that can be used as a callback handler whenever the core chart's "redraw" event is fired.
 * General usage is as follows:
 * <code><pre>
 * chart.setRedrawEventHandler(new ChartRedrawEventHandler() {
 *    public boolean onRedraw(ChartRedrawEvent redrawEvent) {
 *       Window.alert("The chart has been redrawn");
 *       return true;
 *    }
 * });
 * </pre></code>
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.1.0
 */
public interface ChartRedrawEventHandler {

    /**
     * This method is fired whenever the chart's redraw event occurs.
     *
     * @param chartRedrawEvent The details of the event that occurred.
     * @return The response to send back to the event handler function
     */
    public boolean onRedraw(ChartRedrawEvent chartRedrawEvent);

}
