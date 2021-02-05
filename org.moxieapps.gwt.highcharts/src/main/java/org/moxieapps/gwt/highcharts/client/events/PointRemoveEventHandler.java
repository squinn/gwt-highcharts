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
 * An interface that can be used as a callback handler when remove events are fired on the individual
 * points in a series.  General usage is as follows:
 * <code><pre>
 * chart.setSeriesPlotOptions(new SeriesPlotOptions()
 *    .setPointRemoveEventHandler(new PointRemoveEventHandler() {
 *       public boolean onRemove(PointRemoveEvent removeEvent) {
 *          Window.alert("Point removed: " + removeEvent.getXAsLong() + ", " + removeEvent.getYAsLong());
 *          return true;
 *       }
 *    )
 * });
 * </pre></code>
 * See the documentation on the {@link PointRemoveEvent} class for more details on the data
 * available when a point remove event occurs.
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.1.0
 */
public interface PointRemoveEventHandler {

    /**
     * This method is fired whenever a remove event occurs on an individual point.  See
     * the {@link PointRemoveEvent} class for more details on the data available when this event is fired.
     * <p/>
     * Return false to prevent the point from being removed.
     *
     * @param pointRemoveEvent The details of the event that occurred.
     * @return The response to send back to the event handler function.  Return false to prevent the action.
     */
    public boolean onRemove(PointRemoveEvent pointRemoveEvent);

}

