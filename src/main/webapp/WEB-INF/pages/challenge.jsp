<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reverse CAPTCHA - Test</title>
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
        <h1>Test: prove that you're not a human</h1>

        <p>By the time a human finish reading this text, the time will be
            exhausted.</p>
        
        <form action="test" method="POST">
            <span class="challenge">${challenge}</span> =
            <input type="text" id="result" name="result"/>
            <input type="submit" id="submit" value="submit before --- ms"/>
        </form>
    </body>
</html>
