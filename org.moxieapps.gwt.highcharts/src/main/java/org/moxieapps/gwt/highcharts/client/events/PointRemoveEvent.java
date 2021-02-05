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

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Provides access to the raw information provided by Highcharts when a specific point in a series
 * is removed via the Point.remove() method.  This class should not be instantiated directly, but
 * instead you should create a {@link PointRemoveEventHandler} and register it via the
 * {@link org.moxieapps.gwt.highcharts.client.plotOptions.SeriesPlotOptions#setPointRemoveEventHandler(PointRemoveEventHandler)}
 * method in order to access remove events.
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.1.0
 */
public class PointRemoveEvent extends PointEvent {

    /**
     * This constructor is intended for internal use only.  You should not create remove events
     * directly, but instead should register a {@link PointRemoveEventHandler}.
     *
     * @param event The native javascript object containing the details of the original event that was fired.
     * @param point The native javascript object that represents the point instance that the event was triggered on.
     */
    public PointRemoveEvent(JavaScriptObject event, JavaScriptObject point) {
        super(event, point);
    }

}
