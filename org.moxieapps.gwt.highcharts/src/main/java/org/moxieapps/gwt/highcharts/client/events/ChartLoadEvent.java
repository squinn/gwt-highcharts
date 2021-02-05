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
 * Provides access to the raw information provided by Highcharts when a load event occurs.
 * This class is really provided for symmetry and future proofing the API, as in the current
 * version no information is provided on load events.
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.1.0
 */
public class ChartLoadEvent {

    @SuppressWarnings({"FieldCanBeLocal", "UnusedDeclaration"})
    private JavaScriptObject event;

    /**
     * This constructor is intended for internal use only.  You should not create load events
     * directly, but instead should register a {@link ChartLoadEventHandler}.
     *
     * @param event The native javascript object containing the details of the original event that was fired.
     */
    public ChartLoadEvent(JavaScriptObject event) {
        this.event = event;
    }

}
