<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>Moxie Apps GWT Highcharts Showcase</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" href="css/showcase.css">
    <script type="text/javascript" language="javascript">
        var isomorphicDir = "org.moxieapps.gwt.highcharts.showcase.Showcase/sc/";
    </script>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script type="text/javascript">!window.jQuery && document.write('<script src="/js/jquery-1.10.2.min.js"><\/script>');</script>
    <script type="text/javascript" src="js/highstock.min.js"></script>
    <script type="text/javascript" src="js/highcharts-more.js"></script>
    <script type="text/javascript" src="js/modules/funnel.js"></script>
    <script type="text/javascript" src="js/modules/heatmap.js"></script>
    <script type="text/javascript" src="js/highcharts-3d.js"></script>
    <script type="text/javascript" src="js/modules/solid-gauge.js"></script>
    <script type="text/javascript" src="js/modules/treemap.js"></script>
    <script type="text/javascript" src="js/modules/drilldown.js"></script>

    <%
        String theme = getCookieValue(request, "theme_name");
        if(theme != null && !"default".equals(theme)) {
    %>
        <script type="text/javascript" src="js/themes/<%=theme%>.js"></script>
    <%
        }
    %>
    <script type="text/javascript" src="js/modules/exporting.js"></script>
</head>
<body>
    <div id="showcaseContainer">
        <div id="loadingContainer">
            <table border="0" cellpadding="8" cellspacing="0">
                <tr>
                    <td>
                        <img border="0" width="64" height="64" src="images/animated/progress_large.gif" alt="Loading..."/>
                    </td>
                    <td id="loadingMessage">
                        Loading showcase chart examples...
                    </td>
                </tr>
            </table>
        </div>
    </div>
    <script type="text/javascript" language="javascript"
            src="org.moxieapps.gwt.highcharts.showcase.Showcase/org.moxieapps.gwt.highcharts.showcase.Showcase.nocache.js"></script>
    <iframe src="javascript:''" id="__gwt_historyFrame" tabIndex='-1'
            style="position:absolute;width:0;height:0;border:0"></iframe>
</body>
</html>

<%!
    private String getCookieValue(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();
        if(cookies != null) {
            for (int i = 0, cookiesLength = cookies.length; i < cookiesLength; i++) {
                Cookie cookie = cookies[i];
                if (cookieName.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
%>
