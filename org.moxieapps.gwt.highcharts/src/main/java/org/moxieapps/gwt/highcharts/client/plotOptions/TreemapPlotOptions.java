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

package org.moxieapps.gwt.highcharts.client.plotOptions;

import org.moxieapps.gwt.highcharts.client.Color;
import org.moxieapps.gwt.highcharts.client.Configurable;
import org.moxieapps.gwt.highcharts.client.PlotLine;
import org.moxieapps.gwt.highcharts.client.labels.DataLabels;

/**
 * Represents the general plot options available for all treemap type series, which can be set either generically
 * on the chart via the {@link org.moxieapps.gwt.highcharts.client.Chart#setTreemapPlotOptions(TreemapPlotOptions)} method or directly on a
 * series via the {@link org.moxieapps.gwt.highcharts.client.Series#setPlotOptions(PlotOptions)} method.
 * <p/>
 * Note that these options are only needed if you want to specifically control the general options
 * for all treemap type series in the entire chart.  If you instead want to control the options for all
 * series in the chart (not just those of a treemap type), then you can use the {@link SeriesPlotOptions}
 * class instead.  Or, if you want to control the plot options for just one series (and not all treemap type
 * series in the chart), use the {@link org.moxieapps.gwt.highcharts.client.Series#setPlotOptions(PlotOptions)} method.
 *
 * @since 1.7.0
 * @author cskowron@moxiegroup.com (Cory Skowronek)
 */
public class TreemapPlotOptions extends BaseMapOptions<TreemapPlotOptions> {
    /**
     * An enum representing the available layout algorithms
     */
    public enum LayoutAlgorithm {

        SLICE_AND_DICE("sliceAndDice"),

        STRIPES("stripes"),

        SQUARIFIED("squarified"),

        STRIP("strip");

        private LayoutAlgorithm(String optionValue) {
            this.optionValue = optionValue;
        }

        private String optionValue;

        public String toString() {
            return this.optionValue;
        }

    }

    /**
     * A Enum representing the available directions that the layout algorithm will start drawing
     */
    public enum LayoutStartingDirection {
        HORIZONTAL("horizontal"),

        VERTICAL("vertical");

        private LayoutStartingDirection(String optionValue) {
            this.optionValue = optionValue;
        }

        private String optionValue;

        public String toString() {
            return this.optionValue;
        }
    }

    /**
     * Convenience method for setting the 'allowDrillToNode' option of the treemap.  Equivalent to:
     * <pre><code>
     *     treeMapPlotOptions.setOption("allowDrillToNode", true);
     * </code></pre>
     *
     * @param allowDrillToNode When true the user can click on a point which is a parent and zoom in on its children.
     *                         Defaults to false.
     * @return A reference to this {@link TreemapPlotOptions} for convenient method chaining.
     */
    public TreemapPlotOptions setAllowDrillToNode(boolean allowDrillToNode) {
        return this.setOption("allowDrillToNode", allowDrillToNode);
    }

    /**
     * Convenience method for setting the 'alternateStartingDirection' option of the treemap.  Equivalent to:
     * <pre><code>
     *     treeMapPlotOptions.setOption("alternateStartingDirection", true);
     * </code></pre>
     *
     * @param alternateStartingDirection Allow this series' points to be selected by clicking on the markers, bars or
     *                                   pie slices. Defaults to false.
     * @return A reference to this {@link TreemapPlotOptions} for convenient method chaining.
     */
    public TreemapPlotOptions setAlternateStartingDirection(boolean alternateStartingDirection) {
        return this.setOption("alternateStartingDirection", alternateStartingDirection);
    }

    /**
     * Convenience method for setting the 'interactByLeaf' option of the treemap. Equivalent to:
     * <pre><code>
     *     treemapPlotOptions.setOption("interactByLeaf", true);
     * </code></pre>
     * This option decides if the user can interact with the parent nodes or just the leaf nodes. When this option is
     * undefined, it will be true by default. However when allowDrillToNode is true, then it will be false by default.
     *
     * @param interactByLeaf 'true' to allow the user to interact with parent nodes.
     * @return A reference to this {@link TreemapPlotOptions} for convenient method chaining.
     */
    public TreemapPlotOptions setInteractByLeaf(boolean interactByLeaf) {
        return this.setOption("interactByLeaf", interactByLeaf);
    }

    /**
     * Convenience method for setting the 'layoutAlgorithm' option of the treemap.  Equivalent to:
     * <pre><code>
     *     treemapPlotOptions.setOption("layoutAlgorithm", "squarified");
     * </code></pre>
     * This option decides which algorithm is used for setting position and dimensions of the points.
     * See {@link LayoutAlgorithm} for possible options.
     *
     * @param layoutAlgorithm The algorithm used for setting position and dimension of the points.
     * @return A reference to this {@link TreemapPlotOptions} for convenient method chaining.
     */
    public TreemapPlotOptions setLayoutAlgorithm(LayoutAlgorithm layoutAlgorithm) {
        return this.setOption("layoutAlgorithm", layoutAlgorithm != null ? layoutAlgorithm.toString() : null);
    }

    /**
     * Convenience method for setting the 'layoutStartingDirection' option of the treemap.  Equivalent to:
     * <pre><code>
     *      treemapPlotOptions.setOption("layoutStartingDirection", "horizontal");
     * </code></pre>
     * Defines which direction the layout algorithm will start drawing. See {@link LayoutStartingDirection} for
     * possible options
     *
     * @param layoutStartingDirection The direction in which the layout algorithm will start drawing
     * @return A reference to this {@link TreemapPlotOptions} for convenient method chaining.
     */
    public TreemapPlotOptions setLayoutStartingDirection(LayoutStartingDirection layoutStartingDirection) {
        return this.setOption("layoutStartingDirection", layoutStartingDirection != null ? layoutStartingDirection.toString() : null);
    }

    /**
     * Convenience method for setting the 'levelIsConstant' option of the treemap.  Equivalent to:
     * <pre><code>
     *     treemapPlotOptions.setOption("levelIsConstant", false);
     * </code></pre>
     * Used together with the levels and allowDrillToNode options. When set to false the first level visible when
     * drilling is considered to be level one. Otherwise the level will be the same as the tree structure.
     * Defaults to true.
     *
     * @param levelIsConstant 'false' to make the first level visible when drilling is considered to be level one.
     * @return A reference to this {@link TreemapPlotOptions} for convenient method chaining.
     */
    public TreemapPlotOptions setLevelIsConstant(boolean levelIsConstant) {
        return this.setOption("levelIsConstant", levelIsConstant);
    }

    /**
     * Convenience method for setting the 'levels' option of the treemap.  Equivalent to:
     * <pre><code>
     *     treemapPlotOptions.setOption("levels", new Level());
     * </code></pre>
     * Set options on specific levels. Takes precedence over series options, but not point options.
     * @param levels An object of the {@link Level} class containing configuration options
     *               for the series on each particular level
     * @return A reference to this {@link TreemapPlotOptions} for convenient method chaining.
     */
    public TreemapPlotOptions setLevels(Level... levels) {
        return this.setOption("levels", levels != null ? levels : null);
    }

    /**
     * Configurable inner class used to set options on specific levels.  These options take precedence over series
     * options, but not point options.
     * <p/>
     * Example usage:
     * <pre><code>
     *      final TreemapPlotOptions.Level level = new TreemapPlotOptions.Level()
     *           .setLevel(1)
     *           .setLayoutAlgorithm(TreemapPlotOptions.LayoutAlgorithm.SLICE_AND_DICE)
     *      );
     *
     *      chart.setLevels(level);
     * </code></pre>
     */
    public static class Level extends Configurable<Level> {

        /**
         * Convenience method for setting the 'borderColor' option of the level.  Equivalent to:
         * <pre><code>
         *     level.setOption("borderColor", );
         * </code></pre>
         * Can set borderColor on all points which lies on the same level.
         * <p/>
         * Note that this method is intended for setting the color to a simple RBG hex value.  If you instead
         * want to set a color to include an alpha channel or a gradient, use the {@link #setBorderColor(Color)}
         * version instead.
         *
         * @param borderColor The color of the border surrounding each tree map item.
         * @return A reference to this {@link Level} instance for convenient method chaining.
         */
        public Level setBorderColor(String borderColor) {
            return this.setOption("borderColor", borderColor);
        }

        /**
         * Convenience method for setting the 'borderColor' option of the level.  Equivalent to:
         * <pre><code>
         *     level.setOption("borderColor", );
         * </code></pre>
         * Can set borderColor on all points which lies on the same level.
         * <p/>
         * Note that this method is intended for setting the color to a gradient or color that includes
         * an alpha channel.  If you instead just want to set the color to a normal RGB hex value
         * you can use the {@link #setBorderColor(String)} version instead.
         *
         * @param borderColor The color of the border surrounding each tree map item.
         * @return A reference to this {@link Level} instance for convenient method chaining.
         */
        public Level setBorderColor(Color borderColor) {
            return this.setOption("borderColor", borderColor != null ? borderColor.getOptionValue() : null);
        }

        /**
         * Convenience method for setting the 'borderDashStyle' option of the level.  Equivalent to:
         * <pre><code>
         *     level.setOption("borderDashStyle", );
         * </code></pre>
         * Set the dash style of the border of all the point which lies on the level. See {@link PlotLine.DashStyle} for
         * possible options.
         * @param borderDashStyle The dash style of point borders.
         * @return A reference to this {@link Level} instance for convenient method chaining.
         */
        public Level setBorderDashStyle(PlotLine.DashStyle borderDashStyle) {
            return this.setOption("borderDashStyle", borderDashStyle != null ? borderDashStyle.toString() : null);
        }

        /**
         * Convenience method for setting the 'borderWidth' option of the level.  Equivalent to:
         * <pre><code>
         *     level.setOption("borderWidth", );
         * </code></pre>
         * Can set the borderWidth on all points which lies on the same level.
         * @param borderWidth The width of point borders
         * @return A reference to this {@link Level} instance for convenient method chaining.
         */
        public Level setBorderWidth(Number borderWidth) {
            return this.setOption("borderWidth", borderWidth);
        }

        /**
         * Convenience method for setting the 'color' option of the level.  Equivalent to:
         * <pre><code>
         *     level.setOption("color", );
         * </code></pre>
         * Can set a color on all points which lies on the same level.
         * <p/>
         * Note that this method is intended for setting the color to a gradient or color that includes
         * an alpha channel.  If you instead just want to set the color to a normal RGB hex value
         * you can use the {@link #setBorderColor(String)} version instead.
         * @param color The color for all points that are on the same level.
         * @return A reference to this {@link Level} instance for convenient method chaining.
         */
        public Level setColor(Color color) {
            return this.setOption("color", color != null ? color.getOptionValue() : null);
        }

        /**
         * Convenience method for setting the 'color' option of the level.  Equivalent to:
         * <pre><code>
         *     level.setOption("color", );
         * </code></pre>
         * Can set a color on all points which lies on the same level.
         * <p/>
         * Note that this method is intended for setting the color to a simple RBG hex value.  If you instead
         * want to set a color to include an alpha channel or a gradient, use the {@link #setColor(Color)}
         * version instead.
         * @param color The color for all points that are on the same level.
         * @return A reference to this {@link Level} instance for convenient method chaining.
         */
        public Level setColor(String color) {
            return this.setOption("color", color);
        }

        /**
         * Convenience method for setting the 'dataLabels' option of the level.  Equivalent to:
         * <pre><code>
         *     level.setOption("/dataLabels/enabled", true);
         *     level.setOption("/dataLabels/align", Labels.Align.CENTER);
         *     level.setOption("/dataLabels/color", "#CC0000");
         * </code></pre>
         * Defines the appearance of the data labels, static labels for each point.
         * <p/>
         * Sample usage:
         * <pre><code>
         * level.setDataLabels(
         *     new DataLabels()
         *        .setColor("#FF0000")
         * );
         * </code></pre>
         * @param dataLabels The configuration of how the data labels should appear.
         * @return A reference to this {@link Level} instance for convenient method chaining.
         */
        public Level setDataLabels(DataLabels dataLabels) {
            return this.setOption("dataLabels", dataLabels != null ? dataLabels.getOptions() : null);
        }

        /**
         * Convenience method for setting the 'layoutAlgorithm' option of the level.  Equivalent to:
         * <pre><code>
         *     level.setOption("layoutAlgorithm", );
         * </code></pre>
         * This option decides which algorithm is used for setting position and dimensions of the points.
         * See {@link LayoutAlgorithm} for possible options.
         *
         * @param layoutAlgorithm The algorithm used for setting position and dimension of the points.
         * @return A reference to this {@link Level} instance for convenient method chaining.
         */
        public Level setLayoutAlgorithm(LayoutAlgorithm layoutAlgorithm) {
            return this.setOption("layoutAlgorithm", layoutAlgorithm != null ? layoutAlgorithm.toString() : null);
        }

        /**
         * Convenience method for setting the 'layoutStartingDirection' option of the level.  Equivalent to:
         * <pre><code>
         *     level.setOption("layoutStartingDirection", );
         * </code></pre>
         * Defines which direction the layout algorithm will start drawing. See {@link LayoutStartingDirection} for
         * possible options
         *
         * @param layoutStartingDirection The direction in which the layout algorithm will start drawing
         * @return A reference to this {@link Level} instance for convenient method chaining.
         */
        public Level setLayoutStartingDirection(LayoutStartingDirection layoutStartingDirection) {
            return this.setOption("layoutStartingDirection", layoutStartingDirection != null ? layoutStartingDirection.toString() : null);
        }

        /**
         * Convenience method for setting the 'level' option of the level.  Equivalent to:
         * <pre><code>
         *     level.setOption("level", 1);
         * </code></pre>
         * Decides which level takes effect from the options set in the levels object.
         * @param level The level for which the particular options will affect
         * @return A reference to this {@link Level} instance for convenient method chaining.
         */
        public Level setLevel(Number level) {
            return this.setOption("level", level);
        }

    }

}
