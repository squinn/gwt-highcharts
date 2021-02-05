package org.moxieapps.gwt.highcharts.showcase.client;

import com.smartgwt.client.widgets.tree.TreeNode;

/**
 * A single node within an {@link ExampleTree}
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.0
 */
public class ExampleTreeNode extends TreeNode {

    public ExampleTreeNode(String nodeId, String parentNodeId, ExampleFactory exampleFactory) {
        this(nodeId, parentNodeId, exampleFactory.getTitle(), exampleFactory.getIcon(), exampleFactory);
    }

    public ExampleTreeNode(String nodeId, String parentNodeId, String nodeTitle, String icon) {
        this(nodeId, parentNodeId, nodeTitle, icon, null);
    }

    private ExampleTreeNode(String nodeId, String parentNodeId, String nodeTitle, String icon, ExampleFactory exampleFactory) {
        setAttribute("nodeTitle", nodeTitle);
        setAttribute("nodeId", nodeId);
        setAttribute("parentNodeId", parentNodeId);
        setAttribute("icon", icon);
        setAttribute("exampleFactory", exampleFactory);
    }

    public String getNodeTitle() {
        return getAttribute("nodeTitle");
    }

    public String getNodeId() {
        return getAttribute("nodeId");
    }

    public ExampleFactory getExampleFactory() {
        return (ExampleFactory) getAttributeAsObject("exampleFactory");
    }

}
