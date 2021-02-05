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
 * An interface that can be used as a callback handler when axis setExtremes events are fired on the axis.
 * General usage is as follows:
 * <code><pre>
 * chart.getXAxis().setAxisSetExtremesEventHandler(new AxisSetExtremesEventHandler() {
 *       public boolean onSetExtremes(AxisSetExtremesEvent event) {
 *          Window.alert("Axis extremes changed: " + event.getMin() + " - " + event.getMax());
 *          return true;
 *       }
 *    )
 * });
 * </pre></code>
 *
 * @author myersj@gmail.com (Jeff Myers)
 * @since 1.3.0
 */
public interface AxisSetExtremesEventHandler {

    /**
     * This method is fired whenever an axis's extremes are changed.
     *
     * @param axisSetExtremesEvent The details of the event that occurred.
     * @return The response to send back to the event handler function
     */
    public boolean onSetExtremes(AxisSetExtremesEvent axisSetExtremesEvent);

}
