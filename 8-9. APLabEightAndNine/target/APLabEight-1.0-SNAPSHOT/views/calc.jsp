<%--
  Created by IntelliJ IDEA.
  User: kami
  Date: 11/22/2021
  Time: 4:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Stateful Calculator</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Outfit:wght@100;300&display=swap" rel="stylesheet">
</head>
<body class="body">
<div>
    <div class="elements">
        <h1 class="text">Stateful Calculator</h1>
        <h5 class="text">Memory:</h5>
        <p class="text">${memory}</p>

        <form action="CalcServlet" method="get">
            <table>
                <thead>

                </thead>
                <tbody>
                <tr>
                    <td>
                        <label>
                            <input type="text" name="x" value="${x}">
                        </label>
                    </td>
                    <td>
                        <label>
                            <input type="text" name="y" value="${y}">
                        </label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>
                            <select name="op">
                                <option value="+">+</option>
                                <option value="-">-</option>
                                <option value="*">*</option>
                                <option value="/">/</option>
                            </select>
                        </label>
                    </td>
                    <td>
                        <label>
                            <input type="submit" name="submit" value="submit">
                            <input type="submit" name="submit" value="write">
                            <input type="submit" name="submit" value="read">
                        </label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <p class="text">${result}</p>
                    </td>
                </tr>
                </tbody>
            </table>
        </form>
    </div>
</div>
</body>
</html>