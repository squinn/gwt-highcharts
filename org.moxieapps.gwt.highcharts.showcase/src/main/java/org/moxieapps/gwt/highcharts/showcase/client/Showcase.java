package org.moxieapps.gwt.highcharts.showcase.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Node;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.RootPanel;
import com.smartgwt.client.types.Cursor;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;
import com.smartgwt.client.widgets.toolbar.ToolStripButton;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeNode;
import com.smartgwt.client.widgets.tree.events.LeafClickEvent;
import com.smartgwt.client.widgets.tree.events.LeafClickHandler;

import java.util.LinkedHashMap;

/**
 * The main GWT entry point for the module.
 * <p/>
 * TODO: Items to investigate
 * - Multiple Axes example doesn't appear to resize properly
 * - Resizing not working for most examples in Internet Explorer
 * - Pie Chart example not resizing properly
 * - Support for merging axis options with core chart options (see: https://sourceforge.net/p/gwt-highcharts/discussion/general/thread/6a633f63/)
 * - Add support for funnel charts
 * - Consider implementing the fix noted in this post: https://sourceforge.net/p/gwt-highcharts/discussion/general/thread/46979866/
 * - Have the Series.select() method auto handle the associated plot option?  See: https://sourceforge.net/p/gwt-highcharts/discussion/general/thread/e62a660a/ (seems to be fixed as of Highcharts 3.0.1)
 * - Add "exportChart" method. See: https://sourceforge.net/p/gwt-highcharts/discussion/general/thread/d571946f/
 *
 * @author squinn@moxiegroup.com (Shawn Quinn)
 * @since 1.0
 */
public class Showcase implements EntryPoint, ValueChangeHandler<String> {

    private ExampleTree exampleTree;
    private Canvas examplePaneContainer;
    private Canvas currentExamplePane;
    private boolean devMode = false;

    @SuppressWarnings({"GwtToHtmlReferences", "GWTStyleCheck"})
    public void onModuleLoad() {

        final String initToken = History.getToken();
        if (initToken.length() == 0) {
            if (!devMode) History.newItem("main");
        }

        VLayout main = new VLayout() {
            @Override
            protected void onInit() {
                super.onInit();
                if (initToken.length() != 0) {
                    onValueChange(new ValueChangeEvent<String>(initToken) {
                    });
                }
            }
        };

        ToolStrip topBar = new ToolStrip();
        topBar.setHeight(33);
        topBar.setWidth100();

        topBar.addSpacer(6);
        ImgButton gwtHighchartsHomeButton = new ImgButton();
        gwtHighchartsHomeButton.setSrc("icons/24/highcharts.png");
        gwtHighchartsHomeButton.setWidth(24);
        gwtHighchartsHomeButton.setHeight(24);
        gwtHighchartsHomeButton.setPrompt("GWT Highcharts Project Page");
        gwtHighchartsHomeButton.setHoverStyle("interactImageHover");
        gwtHighchartsHomeButton.setShowRollOver(false);
        gwtHighchartsHomeButton.setShowDownIcon(false);
        gwtHighchartsHomeButton.setShowDown(false);
        gwtHighchartsHomeButton.addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler() {
            public void onClick(ClickEvent event) {
                com.google.gwt.user.client.Window.open("http://www.moxiegroup.com/moxieapps/gwt-highcharts/", "gwthighcharts", null);
            }
        });
        topBar.addMember(gwtHighchartsHomeButton);
        topBar.addSpacer(6);

        Label title = new Label("GWT Highcharts Showcase");
        title.setStyleName("gwtHighchartsTitle");
        title.setWidth(300);
        title.setCursor(Cursor.POINTER);
        title.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                showPane(new HomePane());
            }
        });
        topBar.addMember(title);

        topBar.addFill();

        ToolStripButton devConsoleButton = new ToolStripButton();
        devConsoleButton.setTitle("Project Page");
        devConsoleButton.setIcon("icons/16/moxiegroup.png");
        devConsoleButton.addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler() {
            public void onClick(ClickEvent event) {
                com.google.gwt.user.client.Window.open("http://www.moxiegroup.com/moxieapps/gwt-highcharts/", "gwthighcharts", null);
            }
        });

        topBar.addButton(devConsoleButton);

        topBar.addSpacer(6);

        SelectItem selectItem = new SelectItem();
        selectItem.setHeight(22);
        selectItem.setWidth(130);
        selectItem.setControlStyle("themeSelectItemControl");
        LinkedHashMap<String, String> valueMap = new LinkedHashMap<String, String>();
        valueMap.put("default", "Default Theme");
        valueMap.put("dark-blue", "Dark Blue");
        valueMap.put("dark-green", "Dark Green");
        valueMap.put("gray", "Gray");
        valueMap.put("grid", "Grid");
        valueMap.put("skies", "Skies");

        selectItem.setValueMap(valueMap);

        final String themeCookieName = "theme_name";
        String currentTheme = Cookies.getCookie(themeCookieName);
        if (currentTheme == null) {
            currentTheme = "default";
        }
        selectItem.setDefaultValue(currentTheme);
        selectItem.setShowTitle(false);
        selectItem.addChangeHandler(new ChangeHandler() {
            public void onChange(ChangeEvent event) {
                Cookies.setCookie(themeCookieName, (String) event.getValue());
                com.google.gwt.user.client.Window.Location.reload();
            }
        });

        topBar.addFormItem(selectItem);

        topBar.addSpacer(6);

        main.addMember(topBar);

        main.setWidth100();
        main.setHeight100();
        main.setStyleName("tabSetContainer");

        HLayout hLayout = new HLayout();
        hLayout.setLayoutMargin(5);
        hLayout.setMembersMargin(5);
        hLayout.setWidth100();
        hLayout.setHeight100();

        VLayout sideNavLayout = new VLayout();
        sideNavLayout.setHeight100();
        sideNavLayout.setWidth(215);
        sideNavLayout.setShowResizeBar(true);

        exampleTree = new ExampleTree();
        exampleTree.addLeafClickHandler(new LeafClickHandler() {
            public void onLeafClick(LeafClickEvent event) {
                TreeNode node = event.getLeaf();
                showExample(node);
            }
        });

        sideNavLayout.addMember(exampleTree);

        hLayout.addMember(sideNavLayout);

        examplePaneContainer = new Canvas();
        examplePaneContainer.setBorder("1px solid #C0C3C7");
        examplePaneContainer.setWidth100();
        examplePaneContainer.setHeight100();
        hLayout.addMember(examplePaneContainer);
        main.addMember(hLayout);

        /*
        if (SC.hasFirebug()) {
            Label label = new Label();
            label.setWidth100();
            label.setHeight(50);
            label.setValign(VerticalAlignment.CENTER);
            label.setAlign(Alignment.CENTER);
            label.setContents("Firebug can make the Showcase run slow. For the best performance, we suggest disabling Firebug for this site.");

            Window fbWindow = new Window();
            fbWindow.setTitle("Firebug Detected");
            fbWindow.setWidth100();
            fbWindow.setHeight(80);
            fbWindow.addItem(label);
            fbWindow.setRedrawOnResize(true);
            main.addMember(fbWindow);
        }
        */

        // When running in dev mode, use the following type of syntax to switch the chart that comes up by default
        // showPane(new ClickToManagePointsExample("Test Chart", "icons/16/area_chart.png"));

        // IE and mobile appear not to fire the current history state properly, so always show the home pane first
        showPane(new HomePane());

        // Add history listener
        History.addValueChangeHandler(this);

        final RootPanel showcaseContainer = RootPanel.get("showcaseContainer");
        removeChildren(showcaseContainer.getElement());
        showcaseContainer.add(main);

        if (!devMode) {
            History.fireCurrentHistoryState();
        }
    }

    private void showPane(Canvas newPane) {
        if (currentExamplePane == newPane) {
            return;
        }
        if (currentExamplePane != null) {
            examplePaneContainer.removeChild(currentExamplePane);
        }
        examplePaneContainer.addChild(newPane);
        currentExamplePane = newPane;
    }

    private void removeChildren(Node rootNode) {
        while (rootNode.hasChildNodes()) {
            rootNode.removeChild(rootNode.getLastChild());
        }
    }

    public void onValueChange(ValueChangeEvent<String> stringValueChangeEvent) {
        String historyToken = stringValueChangeEvent.getValue();

        if (historyToken.equals("main")) {
            if (!devMode) {
                showPane(new HomePane());
            }
        } else {
            ExampleTreeNode[] exampleTreeNodes = exampleTree.getExampleTreeNodes();
            for (ExampleTreeNode explorerTreeNode : exampleTreeNodes) {
                if (explorerTreeNode.getNodeId().equals(historyToken)) {
                    showExample(explorerTreeNode);
                    exampleTree.selectRecord(explorerTreeNode);
                    Tree tree = exampleTree.getData();
                    TreeNode categoryNode = tree.getParent(explorerTreeNode);
                    while (categoryNode != null && !"/".equals(tree.getName(categoryNode))) {
                        tree.openFolder(categoryNode);
                        categoryNode = tree.getParent(categoryNode);
                    }
                }
            }
        }
    }

    protected void showExample(TreeNode node) {

        if (!(node instanceof ExampleTreeNode)) {
            return;
        }

        ExampleTreeNode exampleTreeNode = (ExampleTreeNode) node;

        ExampleFactory exampleFactory = exampleTreeNode.getExampleFactory();

        // Nothing to do for nodes that don't have example chart associated with them
        if (exampleFactory == null) {
            return;
        }

        showPane(exampleFactory.createChartCanvas());

        History.newItem(exampleTreeNode.getNodeId());

    }

}
