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

import org.moxieapps.gwt.highcharts.client.Axis;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Provides access to the raw information provided by Highcharts when a axis set extremes event occurs.
 *
 * @author myersj@gmail.com (Jeff Myers)
 * @since 1.3.0
 */
public class AxisSetExtremesEvent extends AxisEvent {

    /**
     * This constructor is intended for internal use only.  You should not create axis set extremes 
     * events directly, but instead should register a {@link org.moxieapps.gwt.highcharts.client.events.AxisSetExtremesEventHandler}.
     *
     * @param event The native javascript object containing the details of the original event that was fired.
     * @param axis The axis instance that the event was triggered on.
     */
    public AxisSetExtremesEvent(JavaScriptObject event, Axis<?> axis) {
        super(event, axis);
    }
    
    /**
     * Return the minimum value of the new axis extremes as a Number. An exception will be thrown
     * if the native value of the object is not a number.
     *
     * @return The new minimum value of the axis extremes as a Number.
     */
    public Number getMin() {
        return getMinAsPrimitive();
    }
    
    /**
     * Return the maximum value of the new axis extremes as a Number. An exception will be thrown
     * if the native value of the object is not a number.
     *
     * @return The new maximum value of the axis extremes as a Number.
     */
    public Number getMax() {
        return getMaxAsPrimitive();
    }
        
    /**
     * Return the minimum value of the new axis extremes as a double.
     *
     * @return The new minimum value of the axis extremes as a double.
     */
    private native double getMinAsPrimitive() /*-{
        return this.@org.moxieapps.gwt.highcharts.client.events.AxisEvent::event.min;
    }-*/;
        
    /**
     * Return the maximum value of the new axis extremes as a double.
     *
     * @return The new maximum value of the axis extremes as a double.
     */
    private native double getMaxAsPrimitive() /*-{
        return this.@org.moxieapps.gwt.highcharts.client.events.AxisEvent::event.max;
    }-*/;
}
