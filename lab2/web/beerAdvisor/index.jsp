<%--
  Created by IntelliJ IDEA.
  User: skalskip
  Date: 3/19/19
  Time: 10:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Age Verification</title>
</head>
<body>
<form action="/beerAdvisor/validateAge" method="post">
    <label for="age">
        How old are you?
        <input type="text" name="age" id="age" />

        <button type="submit">Enter</button>
    </label>
</form>
</body>
</html>