<%-- 
    Document   : index
    Created on : 9 нояб. 2021 г., 19:16:37
    Author     : kami
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Web Calculator</title>
</head>
<body>
<div>
    <h1>Web calculator</h1>
    <form action="result.jsp" method="POST">
        <p>
            Input number X <input type="number" name="x" value="${x}" required>
        </p>
        <p>
            Input number Y <input type="number" name="y" value="${y}" required>
        </p>
        <p>
            <input type="submit" name="op" value="+"/>
            <input type="submit" name="op" value="-"/>
            <input type="submit" name="op" value="*"/>
            <input type="submit" name="op" value="/"/>
        </p>
        <p><span id="result">${result}</span></p>
    </form>
</div>
</body>
</html>