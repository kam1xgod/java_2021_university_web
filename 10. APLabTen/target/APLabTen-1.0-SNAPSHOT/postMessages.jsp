<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<%--todo: ref to list messages. starting point in app will be PostMessageServlet.--%>

<h3>Welcome!</h3>

<form action="PostMessageServlet" method="get">
    <label>
        <input type="text" name="message" placeholder="Insert text here...">
        <input type="submit" name="submit" value="Send">
    </label>
</form>

<h3><a href="ListMessagesServlet">View messages.</a></h3>
</body>
</html>