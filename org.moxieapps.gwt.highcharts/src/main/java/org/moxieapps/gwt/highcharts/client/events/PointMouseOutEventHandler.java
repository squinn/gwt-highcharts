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
 * An interface that can be used as a callback handler when mouse out events are fired on the individual
 * points in a series.  General usage is as follows:
 * <code><pre>
 * chart.setSeriesPlotOptions(new SeriesPlotOptions()
 *    .setPointMouseOutEventHandler(new PointMouseOutEventHandler() {
 *       public boolean onMouseOut(PointMouseOutEvent event) {
 *          Window.alert("User moused out of point: " + event.getXAsLong() + ", " + event.getYAsLong());
 *          return true;
 *       }
 *    )
 * });
 * </pre></code>
 * See the documentation on the {@link PointMouseOutEvent} class for more details on the data
 * available when a point mouse out event occurs.
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.1.0
 */
public interface PointMouseOutEventHandler {

    /**
     * This method is fired whenever a mouse out event occurs on an individual point.  See
     * the {@link PointMouseOutEvent} class for more details on the data available when this event is fired.
     * <p/>
     *
     * @param pointMouseOutEvent The details of the event that occurred.
     * @return The response to send back to the event handler function.
     */
    public boolean onMouseOut(PointMouseOutEvent pointMouseOutEvent);

}

