package org.moxieapps.gwt.highcharts.showcase.client;

import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.http.client.*;
import com.google.gwt.json.client.JSONArray;
import com.smartgwt.client.types.ContentsType;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;
import com.smartgwt.client.widgets.toolbar.ToolStripButton;
import org.moxieapps.gwt.highcharts.client.BaseChart;
import org.moxieapps.gwt.highcharts.client.Series;


public abstract class BaseChartExample extends VLayout {

    public abstract BaseChart createChart();

    public abstract String getSourcePath();

    public JSONArray loadAsyncData(final Series series, final String url) {
        RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);
        final JSONArray[] jsonArray = new JSONArray[1];
            try {
                Request request = builder.sendRequest(null, new RequestCallback() {
                    @Override
                    public void onResponseReceived(Request request, Response response) {
                        if (200 == response.getStatusCode()) {
                            jsonArray[0] = new JSONArray(JsonUtils.safeEval(response.getText()));
                            series.setPoints(jsonArray[0], true);
                        }
                    }

                    @Override
                    public void onError(Request request, Throwable throwable) {

                    }
                });

            } catch (RequestException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        return jsonArray[0];
    }


    public BaseChartExample(String titleText, String iconSource) {

        this.setWidth100();
        this.setHeight100();

        ToolStrip topBar = new ToolStrip();
        topBar.setWidth100();
        topBar.setHeight(33);

        topBar.addSpacer(6);
        final Img icon = new Img(iconSource);
        icon.setWidth(16);
        icon.setHeight(16);
        topBar.addMember(icon);

        topBar.addSpacer(6);

        final Label title = new Label(titleText.replace(" ", "&nbsp;"));
        title.setStyleName("paneTitle");
        topBar.addMember(title);

        topBar.addFill();

        if (getSourcePath() != null) {
            ToolStripButton sourceButton = new ToolStripButton();
            sourceButton.setTitle("View Source");
            sourceButton.setIcon("icons/16/view_source.png");
            sourceButton.addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent event) {
                    showSource("source/" + getSourcePath(), 750, 480);
                }
            });
            topBar.addMember(sourceButton);
        }

        topBar.addSpacer(6);
        this.addMember(topBar);

        final BaseChart chart = createChart();
        chart.setReflow(false);

        final Canvas chartContainer = new Canvas();
        chartContainer.setWidth100();
        chartContainer.setHeight("*");

        final WidgetCanvas widgetCanvas = new WidgetCanvas(chart);
        widgetCanvas.setWidth100();
        widgetCanvas.setHeight100();
        widgetCanvas.setOverflow(Overflow.HIDDEN);

        chartContainer.addResizedHandler(new ResizedHandler() {
            public void onResized(ResizedEvent event) {
                chart.setSize(chartContainer.getWidth() - 4, chartContainer.getHeight() - 4, false);
            }
        });
        chartContainer.addDrawHandler(new DrawHandler() {
            public void onDraw(DrawEvent event) {
                chart.setSize(chartContainer.getWidth() - 4, chartContainer.getHeight() - 4, false);
            }
        });

        chartContainer.addChild(widgetCanvas);

        this.addMember(chartContainer);
    }

    protected void showSource(String sourceUrl, int width, int height) {

        final Window win = new Window();
        win.setTitle("Source");
        win.setHeaderIcon("icons/16/view_source.png", 16, 16);
        win.setKeepInParentRect(true);

        int userWidth = com.google.gwt.user.client.Window.getClientWidth() - 20;
        win.setWidth(userWidth < width ? userWidth : width);

        int userHeight = com.google.gwt.user.client.Window.getClientHeight() - 96;
        win.setHeight(userHeight < height ? userHeight : height);

        int windowTop = 40;
        int windowLeft = com.google.gwt.user.client.Window.getClientWidth() - (win.getWidth() + 20) - getPageLeft();
        win.setLeft(windowLeft);
        win.setTop(windowTop);
        win.setCanDragReposition(true);
        win.setCanDragResize(true);
        win.setMembersMargin(5);

        win.addItem(buildSourceCanvas(sourceUrl));
        addChild(win);
        win.show();
    }

    public Canvas buildSourceCanvas(String url) {
        HTMLPane sourcePane = new HTMLPane();
        sourcePane.setWidth100();
        sourcePane.setHeight100();
        sourcePane.setContentsURL(url);
        sourcePane.setContentsType(ContentsType.PAGE);
        return sourcePane;
    }


}
