<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>Moxie Apps GWT Highcharts Showcase</title>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script type="text/javascript" src="autoNumeric.js"></script>
    <script>
        $(document).ready(function () {

//            $("#originalBalance").autoNumeric('init');
            $("#originalBalance").keyup(function(e) {
                alert("val: " + $(this).val());
            });
        });

    </script>
</head>
<body>
<form>
    <input id="originalBalance" class="input" name="Labor" type="text" size="20" maxlength="10" />
</form>
</body>
</html>
