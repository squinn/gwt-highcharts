<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
    <title>Moxie Apps GWT Highcharts Showcase</title>
    <link rel="stylesheet" href="css/test-gwt.css">
    <script type="text/javascript">
        var isomorphicDir = "org.moxieapps.gwt.highcharts.showcase.Showcase/sc/";
    </script>
    <script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
    <%--<script type="text/javascript" src="js/highstock.src.js"></script>--%>
    <%--<script type="text/javascript" src="js/themes/grid.js"></script>--%>
    <script src="http://code.highcharts.com/highcharts.js"></script>
    <script src="http://code.highcharts.com/highcharts-more.js"></script>
    <script src="http://code.highcharts.com/modules/exporting.js"></script>
    <!--<script type="text/javascript" src="js/modules/exporting.js"></script>-->
</head>
<body>
<script type="text/javascript">
    $(document).ready(function () {
        /*
         var chart = new Highcharts.StockChart({
         "chart":{"height":500, "renderTo":"container"}, "series":[
         {"id":"gwt-uid-4", "name":"ORCL", "data":[
         [1,3],
         [2,4]
         ]},
         {"id":"gwt-uid-5", "name":"Volume", "yAxis":1, "data":[
         [1,2],
         [2,2]
         ]}
         ], "yAxis":[
         {"id":"gwt-uid-2", "title":{"text":"Closing"}, "height":200, "lineWidth":2},
         {"id":"gwt-uid-3", "title":{"text":"Volume"}, "height":100, "top":300, "offset":0, "lineWidth":2}
         ]}
         );
         */
        /*
         var chart = new Highcharts.StockChart({
         chart : {
         renderTo : 'container',
         zoom : 'xy',
         width : 500,
         height : 500
         },
         xAxis : {},
         yAxis : [ {
         height : 150
         }, {
         top : 250,
         height : 150
         } ],
         series : [ {
         name : 'data1',
         data : [ 1, 5, 6, 3, 1, 5, 6, 3, 1, 5, 6, 3 ]
         }, {
         name : 'data2',
         data : [ 1, 5, 6, 3, 1, 5, 6, 3, 1, 5, 6, 3 ],
         yAxis: 1
         } ]
         });
         */
        $('#container').highcharts({
            chart: {
                type: 'waterfall'
            },

            title: {
                text: 'Highcharts Waterfall'
            },

            xAxis: {
                type: 'category'
            },

            yAxis: {
                title: {
                    text: 'USD'
                }
            },

            legend: {
                enabled: false
            },

            tooltip: {
                pointFormat: '<b>point.y:,.2f</b> USD'
            },

            series: [{
                data: [{
                    name: 'Start',
                    y: 120000
                }, {
                    name: 'Product Revenue',
                    y: 569000
                }, {
                    name: 'Service Revenue',
                    y: 231000
                }, {
                    name: 'Positive Balance',
                    isIntermediateSum: true,
                    color: Highcharts.getOptions().colors[1]
                }, {
                    name: 'Fixed Costs',
                    y: -342000
                }, {
                    name: 'Variable Costs',
                    y: -233000
                }, {
                    name: 'Balance',
                    isSum: true,
                    color: Highcharts.getOptions().colors[1]
                }],
                dataLabels: {
                    enabled: true,
                    formatter: function () {
                        return Highcharts.numberFormat(this.y / 1000, 0, ',') + 'k';
                    },
                    style: {
                        color: '#FFFFFF',
                        fontWeight: 'bold'
                    }
                },
                pointPadding: 0
            }]
        });
    });
</script>
<div id="container" style="height: 500px"></div>
</body>
</html>
