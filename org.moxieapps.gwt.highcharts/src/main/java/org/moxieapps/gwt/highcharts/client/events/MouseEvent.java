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
import com.google.gwt.dom.client.Element;

/**
 * The base class of all events that are triggered by the user's mouse, and includes methods for accessing the general
 * state of the event, such as if the user was holding down the "Shift" or "Control" key,
 * or the x/y coordinates of the click.
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.1.0
 */
public abstract class MouseEvent {

    @SuppressWarnings({"FieldCanBeLocal", "UnusedDeclaration"})
    private JavaScriptObject event;

    /**
     * We can only be created by instantiating one of our sub classes.
     *
     * @param event The native javascript object containing the details of the original event that was fired.
     */
    protected MouseEvent(JavaScriptObject event) {
        this.event = event;
    }

    /**
     * Gets the mouse x-position within the browser window's client area.
     *
     * @return the mouse x-position
     */
    public native int getClientX() /*-{
        return this.@org.moxieapps.gwt.highcharts.client.events.MouseEvent::event.clientX || 0;
    }-*/;

    /**
     * Gets the mouse y-position within the browser window's client area.
     *
     * @return the mouse y-position
     */
    public native int getClientY() /*-{
        return this.@org.moxieapps.gwt.highcharts.client.events.MouseEvent::event.clientY || 0;
    }-*/;

    /**
     * Gets the button value. Compare it to
     * {@link com.google.gwt.dom.client.NativeEvent#BUTTON_LEFT},
     * {@link com.google.gwt.dom.client.NativeEvent#BUTTON_RIGHT},
     * {@link com.google.gwt.dom.client.NativeEvent#BUTTON_MIDDLE}
     *
     * @return the button value
     */
    public native int getNativeButton() /*-{
        return this.@org.moxieapps.gwt.highcharts.client.events.MouseEvent::event.button || 0;
    }-*/;

    /**
     * Gets the mouse x-position relative to a given element.
     *
     * @param target the element whose coordinate system is to be used
     * @return the relative x-position
     */
    public int getRelativeX(Element target) {
        return getClientX() - target.getAbsoluteLeft() + target.getScrollLeft() +
            target.getOwnerDocument().getScrollLeft();
    }

    /**
     * Gets the mouse y-position relative to a given element.
     *
     * @param target the element whose coordinate system is to be used
     * @return the relative y-position
     */
    public int getRelativeY(Element target) {
        return getClientY() - target.getAbsoluteTop() + target.getScrollTop() +
            target.getOwnerDocument().getScrollTop();
    }

    /**
     * Gets the mouse x-position on the user's display.
     *
     * @return the mouse x-position
     */
    public native int getScreenX() /*-{
        return this.@org.moxieapps.gwt.highcharts.client.events.MouseEvent::event.screenX || 0;
    }-*/;

    /**
     * Gets the mouse y-position on the user's display.
     *
     * @return the mouse y-position
     */
    public native int getScreenY() /*-{
        return this.@org.moxieapps.gwt.highcharts.client.events.MouseEvent::event.screenY || 0;
    }-*/;

    /**
     * Is <code>alt</code> key down.
     *
     * @return whether the alt key is down
     */
    public native boolean isAltKeyDown() /*-{
        return !!this.@org.moxieapps.gwt.highcharts.client.events.MouseEvent::event.altKey;
    }-*/;

    /**
     * Is <code>control</code> key down.
     *
     * @return whether the control key is down
     */
    public native boolean isControlKeyDown() /*-{
        return !!this.@org.moxieapps.gwt.highcharts.client.events.MouseEvent::event.ctrlKey;
    }-*/;

    /**
     * Is <code>meta</code> key down.
     *
     * @return whether the meta key is down
     */
    public native boolean isMetaKeyDown() /*-{
        return !!this.@org.moxieapps.gwt.highcharts.client.events.MouseEvent::event.metaKey;
    }-*/;

    /**
     * Is <code>shift</code> key down.
     *
     * @return whether the shift key is down
     */
    public native boolean isShiftKeyDown() /*-{
        return !!this.@org.moxieapps.gwt.highcharts.client.events.MouseEvent::event.shiftKey;
    }-*/;

    /**
     * Returns a pointer to the native Highchart's instance data object that this GWT
     * instance is wrapping.  For advanced JSNI use-cases only.
     *
     * @return The native Highcharts object instance that this GWT instance is associated with.
     * @since 1.5.0
     */
    public JavaScriptObject getNativeEvent() {
        return this.event;
    }


}
