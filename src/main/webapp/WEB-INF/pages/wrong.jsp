<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="user-scalable=no, width=device-width" />
        <title>Reverse CAPTCHA - Test</title>
        <link rel="stylesheet" type="text/css" href="style.css" />
    </head>
    <body>
        <h1>Fail</h1>

        <p>${message}</p>

        <p>Go away or <a href="test">retry</a>.</p>
        
        <p>
            <iframe src="http://www.youtube.com/embed/oHg5SJYRHA0" 
                    frameborder="0" allowfullscreen></iframe>
        </p>
    </body>
</html>
