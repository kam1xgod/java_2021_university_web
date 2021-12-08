<%--
  Created by IntelliJ IDEA.
  User: kami
  Date: 11/11/2021
  Time: 5:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List All</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Outfit:wght@100;300&display=swap" rel="stylesheet">
</head>
<body class="body">

<div class="elements">
    <table>
        <caption id="tableCaption">
            <h2>Employees List</h2>
        </caption>
        <thead>
        <tr id="firstRow">
            <th>ID</th>
            <th>Firstname</th>
            <th>Lastname</th>
            <th>Manager</th>
            <th>Salary</th>
            <th>Department</th>
            <th>City</th>
        </tr>
        </thead>
        <tbody>
        ${table}
        </tbody>
    </table>
    <label>Return to <a href="/APLabEight-1.0-SNAPSHOT">Homepage</a></label>
</div>
</body>
</html>
