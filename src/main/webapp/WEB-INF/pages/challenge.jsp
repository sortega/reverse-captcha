<%@page contentType="text/html" pageEncoding="MacRoman"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reverse CAPTCHA - Test</title>
    </head>
    <body>
        <h1>Test: prove that you're not a human</h1>

        <p>By the time a human finish reading this text, the time will be
            exhausted.</p>

        <form action="../test" method="POST">
            <span class="problem">2+2</span> =
            <input type="text" id="result" name="result"/>
            <input type="submit" value="submit before xxx seconds"/>
        </form>

        <!-- todo: js para actualizar el bot—n y la cuenta atr‡s -->
    </body>
</html>
