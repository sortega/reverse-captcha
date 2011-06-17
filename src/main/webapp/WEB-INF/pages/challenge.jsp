<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
      "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/xml; charset=UTF-8"/>
        <meta name="viewport" content="user-scalable=no, width=device-width" />
        <title>Reverse CAPTCHA - Test</title>
        <link rel="stylesheet" type="text/css" href="style.css" />
        <script type="text/javascript" src="lib/prototype-1.6.1.js"></script>
        <script type="text/javascript">
            window.onload = function() {
                var submit = $("submit");
                var timeout = new Date().getTime() + ${remaining_millis};
                var delay = 50; // ms

                var update_submit = function() {
                    var remaining = timeout - new Date().getTime();
                    if (remaining > 0) {
                        submit.value = "submit before " + remaining + " ms";
                    } else {
                        submit.value = "too late";
                    }
                };

                setInterval(update_submit, delay);
            }
        </script>
    </head>
    <body>
        <h1>Test: prove that you're not human</h1>

        <p>By the time a human finish reading this text, the time will be
            exhausted. By the way, use integer arithmetic.</p>

        <form action="test" method="post">
            <span class="challenge">${challenge}</span>
            = <input type="text" id="result" name="result"/>
            <input type="submit" id="submit" value="submit before --- ms"/>
        </form>
    </body>
</html>
