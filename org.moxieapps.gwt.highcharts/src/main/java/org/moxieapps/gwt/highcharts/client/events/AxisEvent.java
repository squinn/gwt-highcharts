package org.moxieapps.gwt.highcharts.client.events;

import org.moxieapps.gwt.highcharts.client.Axis;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * The base class of all events that are triggered on a axis, and includes methods for accessing the axis
 * instance directly.
 *
 * @author myersj@gmail.com (Jeff Myers)
 * @since 1.3.0
 */
public abstract class AxisEvent {

    protected JavaScriptObject event;
    
    protected Axis<?> axis;

    /**
     * We can only be created by instantiating one of our sub classes.
     *
     * @param event The native javascript object containing the details of the original event that was fired.
     * @param axis The axis instance that the event was triggered on.
     */
    protected AxisEvent(JavaScriptObject event, Axis<?> axis) {
        this.event = event;
        this.axis = axis;
    }
        
    /**
     * Get the axis instance that received the event. This axis may be a {@link org.moxieapps.gwt.highcharts.client.XAxis} 
     * or a {@link org.moxieapps.gwt.highcharts.client.YAxis}.
     * @return the axis that the event was triggered on
     */
    public Axis<?> getAxis() {
        return axis;
    }

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
