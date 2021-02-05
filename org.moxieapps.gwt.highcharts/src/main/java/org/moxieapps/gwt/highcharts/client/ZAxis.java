package org.moxieapps.gwt.highcharts.client;

/**
 * Provides access to an object that can abe used to configure and manage the z-axis of the chart.
 * Note that you can not instance an instance of this object directly, and instead should use the
 * {@link Chart#getZAxis()} method to gain a reference to this
 * object.  Example usage:
 * <pre><code>
 * chart.getZAxis()
 *    .setType(Axis.Type.LINEAR)
 *    .setAxisTitleText("Sales")
 *    .setLineWidth(3);
 * </code></pre>
 *
 * @author cskowron@moxiegroup.com (Cory Skowronek
 * @since 1.7.0
 */
public class ZAxis extends Axis<ZAxis> {

    ZAxis(BaseChart chart) {
        super(chart);
    }

    // There are no options specifically listed for the Z-Axis in the Highcharts API Reference.
    // This class assumes the Z-Axis functions similarly to a base axis
}
