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
 * An interface that can be used as a callback handler when click events are fired on the individual
 * points in a series.  General usage is as follows:
 * <code><pre>
 * chart.setSeriesPlotOptions(new SeriesPlotOptions()
 *    .setPointClickEventHandler(new PointClickEventHandler() {
 *       public boolean onClick(PointClickEvent clickEvent) {
 *          Window.alert("User clicked on point: " + clickEvent.getXAsLong() + ", " + clickEvent.getYAsLong());
 *          return true;
 *       }
 *    )
 * });
 * </pre></code>
 * See the documentation on the {@link PointClickEvent} class for more details on the data
 * available when a point click event occurs.
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.1.0
 */
public interface PointClickEventHandler {

    /**
     * This method is fired whenever a click event occurs on an individual point.  See
     * the {@link PointClickEvent} class for more details on the data available when this event is fired.
     * <p/>
     * If the {@link org.moxieapps.gwt.highcharts.client.plotOptions.SeriesPlotOptions#setAllowPointSelect(boolean)}
     * option is true, the default action for the point's click event is to toggle the point's select state.
     * Returning false cancel this action.
     *
     * @param pointClickEvent The details of the event that occurred.
     * @return The response to send back to the event handler function.  Return false to cancel the default
     *         action of selecting the point when the
     *         {@link org.moxieapps.gwt.highcharts.client.plotOptions.SeriesPlotOptions#setAllowPointSelect(boolean)}
     *         option is enabled.
     */
    public boolean onClick(PointClickEvent pointClickEvent);

}
