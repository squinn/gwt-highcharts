package org.moxieapps.gwt.highcharts.showcase.client;

import com.smartgwt.client.types.SortArrow;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;
import org.moxieapps.gwt.highcharts.showcase.client.area.*;
import org.moxieapps.gwt.highcharts.showcase.client.bar.*;
import org.moxieapps.gwt.highcharts.showcase.client.combination.ColumnLinePieExample;
import org.moxieapps.gwt.highcharts.showcase.client.combination.DualAxesExample;
import org.moxieapps.gwt.highcharts.showcase.client.combination.MultipleAxesExample;
import org.moxieapps.gwt.highcharts.showcase.client.combination.ScatterWithRegressionExample;
import org.moxieapps.gwt.highcharts.showcase.client.dynamic.ClickToManagePointsExample;
import org.moxieapps.gwt.highcharts.showcase.client.dynamic.ColumnPieDrilldownExample;
import org.moxieapps.gwt.highcharts.showcase.client.dynamic.SplineUpdatingExample;
import org.moxieapps.gwt.highcharts.showcase.client.line.*;
import org.moxieapps.gwt.highcharts.showcase.client.map.HeatmapExample;
import org.moxieapps.gwt.highcharts.showcase.client.map.TreemapExample;
import org.moxieapps.gwt.highcharts.showcase.client.misc.*;
import org.moxieapps.gwt.highcharts.showcase.client.pie.BasicPieExample;
import org.moxieapps.gwt.highcharts.showcase.client.pie.DonutExample;
import org.moxieapps.gwt.highcharts.showcase.client.misc.FunnelChartExample;
import org.moxieapps.gwt.highcharts.showcase.client.pie.PieWithLegendExample;
import org.moxieapps.gwt.highcharts.showcase.client.stock.*;
import org.moxieapps.gwt.highcharts.showcase.client.stock.CandlestickChartExample;
import org.moxieapps.gwt.highcharts.showcase.client.threeD.Column3DExample;
import org.moxieapps.gwt.highcharts.showcase.client.threeD.Pie3DExample;
import org.moxieapps.gwt.highcharts.showcase.client.threeD.Scatter3DExample;

/**
 * Represents the left nav of the showcase
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.0
 */
public class ExampleTree extends TreeGrid {

    private static final String ROOT_NODE_ID = "root";

    public ExampleTree() {
        setWidth100();
        setHeight100();
        setCustomIconProperty("icon");
        setAnimateFolderTime(100);
        setAnimateFolders(true);
        setAnimateFolderSpeed(1000);
        setNodeIcon("icons/16/line_chart.png");
        setShowSortArrow(SortArrow.CORNER);
        setShowAllRecords(true);
        setLoadDataOnDemand(false);
        setCanSort(false);
        setLeaveScrollbarGap(false);

        TreeGridField field = new TreeGridField();
        field.setCanFilter(true);
        field.setName("nodeTitle");
        field.setTitle("<b>Samples</b>");
        setFields(field);

        Tree tree = new Tree();
        tree.setModelType(TreeModelType.PARENT);
        tree.setNameProperty("nodeTitle");
        tree.setOpenProperty("isOpen");
        tree.setIdField("nodeId");
        tree.setParentIdField("parentNodeId");
        tree.setRootValue(ROOT_NODE_ID);

        tree.setData(getExampleTreeNodes());

        setData(tree);
    }

    private ExampleTreeNode[] exampleTreeNodes;

    public ExampleTreeNode[] getExampleTreeNodes() {

        if(exampleTreeNodes == null) {
            exampleTreeNodes = new ExampleTreeNode[] {

                // Featured examples
                new ExampleTreeNode("featured-category", ROOT_NODE_ID, "Featured Examples", "icons/16/featured_chart.png"),
                new ExampleTreeNode("featured-multiple", "featured-category", MultipleAxesExample.getFactory()),
                new ExampleTreeNode("featured-donut", "featured-category", DonutExample.getFactory()),
                new ExampleTreeNode("featured-area", "featured-category", StackedAreaExample.getFactory()),
                new ExampleTreeNode("featured-bar", "featured-category", BarWithNegativeStackExample.getFactory()),
                new ExampleTreeNode("featured-column", "featured-category", StackedAndGroupedColumnExample.getFactory()),
                new ExampleTreeNode("featured-scatter", "featured-category", ScatterPlotExample.getFactory()),
                new ExampleTreeNode("featured-zoomable", "featured-category", ZoomableTimeSeriesExample.getFactory()),
                new ExampleTreeNode("featured-updating", "featured-category", SplineUpdatingExample.getFactory()),
                new ExampleTreeNode("featured-range", "featured-category", ColumnRangeExample.getFactory()),
                new ExampleTreeNode("featured-polar", "featured-category", PolarChartExample.getFactory()),
                new ExampleTreeNode("featured-multipleseries", "featured-category", MultipleSeriesExample.getFactory()),
                new ExampleTreeNode("featured-candlestickspline", "featured-category", CandlestickSplineChartExample.getFactory()),

                // Line and scatter charts
                new ExampleTreeNode("line-category", ROOT_NODE_ID, "Line and Scatter Charts", "icons/16/line_chart.png"),
                new ExampleTreeNode("line-basic", "line-category", BasicLineExample.getFactory()),
                new ExampleTreeNode("line-multiple-clickable", "line-category", DualAxesClickablePointsExample.getFactory()),
                new ExampleTreeNode("line-data-labels", "line-category", LineWithDataLabelsExample.getFactory()),
                new ExampleTreeNode("line-time-series", "line-category", ZoomableTimeSeriesExample.getFactory()),
                new ExampleTreeNode("line-inverted-axes", "line-category", SplineWithInvertedAxesExample.getFactory()),
                new ExampleTreeNode("line-spline-symbols", "line-category", SplineWithSymbolsExample.getFactory()),
                new ExampleTreeNode("line-spline-plotbands", "line-category", SplineWithPlotBandsExample.getFactory()),
                new ExampleTreeNode("line-spline-irregular", "line-category", IrregularTimeDataExample.getFactory()),
                new ExampleTreeNode("line-scatter", "line-category", ScatterPlotExample.getFactory()),
                new ExampleTreeNode("bubble-scatter", "line-category", BubbleChartExample.getFactory()),

                // Area charts
                new ExampleTreeNode("area-category", ROOT_NODE_ID, "Area Charts", "icons/16/area_chart.png"),
                new ExampleTreeNode("area-basic", "area-category", BasicAreaExample.getFactory()),
                new ExampleTreeNode("area-negative", "area-category", AreaWithNegativeValuesExample.getFactory()),
                new ExampleTreeNode("area-stacked", "area-category", StackedAreaExample.getFactory()),
                new ExampleTreeNode("area-percentage", "area-category", PercentageAreaExample.getFactory()),
                new ExampleTreeNode("area-missing", "area-category", AreaWithMissingPointsExample.getFactory()),
                new ExampleTreeNode("area-inverted", "area-category", InvertedAxesAreaExample.getFactory()),
                new ExampleTreeNode("area-spline", "area-category", AreaSplineExample.getFactory()),
                new ExampleTreeNode("area-range", "area-category", AreaRangeExample.getFactory()),
                new ExampleTreeNode("area-spline-range", "area-category", AreaSplineRangeExample.getFactory()),

                // Column and bar charts
                new ExampleTreeNode("bar-category", ROOT_NODE_ID, "Column and Bar Charts", "icons/16/column_chart.png"),
                new ExampleTreeNode("bar-basic", "bar-category", BasicBarExample.getFactory()),
                new ExampleTreeNode("bar-stacked", "bar-category", StackedBarExample.getFactory()),
                new ExampleTreeNode("bar-negative-stack", "bar-category", BarWithNegativeStackExample.getFactory()),
                new ExampleTreeNode("column-basic", "bar-category", BasicColumnExample.getFactory()),
                new ExampleTreeNode("column-negative-values", "bar-category", ColumnWithNegativeValuesExample.getFactory()),
                new ExampleTreeNode("column-stacked", "bar-category", StackedColumnExample.getFactory()),
                new ExampleTreeNode("column-stacked-grouped", "bar-category", StackedAndGroupedColumnExample.getFactory()),
                new ExampleTreeNode("column-stacked-percentage", "bar-category", StackedPercentageColumnExample.getFactory()),
                new ExampleTreeNode("column-labels-rotated", "bar-category", ColumnWithRotatedLabelsExample.getFactory()),
                new ExampleTreeNode("column-range", "bar-category", ColumnRangeExample.getFactory()),
                // TODO: Add remaining column chart examples

                // Pie charts
                new ExampleTreeNode("pie-category", ROOT_NODE_ID, "Pie Charts", "icons/16/pie_chart.png"),
                new ExampleTreeNode("pie-basic", "pie-category", BasicPieExample.getFactory()),
                new ExampleTreeNode("pie-donut", "pie-category", DonutExample.getFactory()),
                new ExampleTreeNode("pie-legend", "pie-category", PieWithLegendExample.getFactory()),

                // Dynamic charts
                new ExampleTreeNode("dynamic-category", ROOT_NODE_ID, "Dynamic Charts", "icons/16/dynamic_chart.png"),
                new ExampleTreeNode("dynamic-spline-updating", "dynamic-category", SplineUpdatingExample.getFactory()),
                new ExampleTreeNode("dynamic-manage-points", "dynamic-category", ClickToManagePointsExample.getFactory()),
                new ExampleTreeNode("dynamic-column-drilldown", "dynamic-category", ColumnPieDrilldownExample.getExampleFactory()),
                // TODO: Add remaining dynamic charts

                // Combination charts
                new ExampleTreeNode("combination-category", ROOT_NODE_ID, "Combination Charts", "icons/16/combination_chart.png"),
                new ExampleTreeNode("combination-column-line-pie", "combination-category", ColumnLinePieExample.getFactory()),
                new ExampleTreeNode("combination-dual-axes", "combination-category", DualAxesExample.getFactory()),
                new ExampleTreeNode("combination-multiple-axes", "combination-category", MultipleAxesExample.getFactory()),
                new ExampleTreeNode("combination-scatter-regression", "combination-category", ScatterWithRegressionExample.getFactory()),

                // Map charts
                new ExampleTreeNode("map-category", ROOT_NODE_ID, "Map Charts", "icons/16/map_chart.png"),
                new ExampleTreeNode("map-heatmap", "map-category", HeatmapExample.getFactory()),
                new ExampleTreeNode("map-treemap", "map-category", TreemapExample.getFactory()),

                // Stock charts
                new ExampleTreeNode("stockchart-category", ROOT_NODE_ID, "Stock Charts", "icons/16/stock_chart.png"),
                new ExampleTreeNode("stockchart-areavolume", "stockchart-category", AreaVolumeChartExample.getFactory()),
                new ExampleTreeNode("stockchart-candlestick", "stockchart-category", CandlestickChartExample.getFactory()),
                new ExampleTreeNode("stockchart-candlestickspline", "stockchart-category", CandlestickSplineChartExample.getFactory()),
                new ExampleTreeNode("stockchart.columnrange", "stockchart-category", ColumnRangeChartExample.getFactory()),
                new ExampleTreeNode("stockchart-multipleseries", "stockchart-category", MultipleSeriesExample.getFactory()),
                new ExampleTreeNode("stockchart-ohlc","stockchart-category", OHLCChartExample.getFactory()),
                new ExampleTreeNode("stockchart-plotband", "stockchart-category", PlotBandChartExample.getFactory()),
                new ExampleTreeNode("stockchart-spline", "stockchart-category", SplineScrollbarChartExample.getFactory()),

                // 3D Charts
                new ExampleTreeNode("3D-category", ROOT_NODE_ID, "3D Charts", "icons/16/3D_chart.png"),
                new ExampleTreeNode("3DChart-pie", "3D-category", Pie3DExample.getFactory()),
                new ExampleTreeNode("3DChart-scatter", "3D-category", Scatter3DExample.getFactory()),
                new ExampleTreeNode("3DChart-column", "3D-category", Column3DExample.getFactory()),


                // Misc charts
                new ExampleTreeNode("misc-category", ROOT_NODE_ID, "More Chart Types", "icons/16/windrose_chart.png"),
                new ExampleTreeNode("misc-box", "misc-category", BoxPlotExample.getFactory()),
                new ExampleTreeNode("misc-errorbar", "misc-category", ErrorbarExample.getFactory()),
                new ExampleTreeNode("misc-funnel", "misc-category", FunnelChartExample.getFactory()),
                new ExampleTreeNode("misc-pyramid", "misc-category", PyramidChartExample.getFactory()),
                new ExampleTreeNode("misc-polar", "misc-category", PolarChartExample.getFactory()),
                new ExampleTreeNode("misc-spider", "misc-category", SpiderChartExample.getFactory()),
                new ExampleTreeNode("misc-windrose", "misc-category", WindRoseChartExample.getFactory())

            };
        }

        return exampleTreeNodes;
    }





}
