<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: skalskip
  Date: 3/13/19
  Time: 11:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>To jest moja pierwza aplikacja w JavaEE</h1>
  <p>Wyświetlamy na razie stronę JSP</p>

  <%
    Date tmp = new Date();
    out.print("<h2>" + tmp.toString() + "</h2>");
  %>

  </body>
</html>
