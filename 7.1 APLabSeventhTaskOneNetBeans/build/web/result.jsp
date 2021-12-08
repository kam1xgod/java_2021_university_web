<%-- 
    Document   : result
    Created on : 9 ????. 2021 ?., 19:23:40
    Author     : kami
--%>
<%
    try { 
        Integer.parseInt(request.getParameter("x"));
    } catch (NumberFormatException exc) {
        response.setContentType("text/plain");
        response.getWriter().println("Error: variables are empty.");
    }
    
    try {
        Integer.parseInt(request.getParameter("y"));
    } catch (NumberFormatException exc) {
        response.setContentType("text/plain");
        response.getWriter().println("Error: variables are empty.");
    }
    
    double x = Double.parseDouble(request.getParameter("x"));
    double y = Double.parseDouble(request.getParameter("y"));
    double action = 0;
    String result = "";
    String operation = request.getParameter("op");
    if ("+".equals(operation)) {
        action = x + y;
        result = "Sum of " + x + " and " + y + " equals to:" + action;
    } else if ("-".equals(operation)) {
        action = x - y;
        response.setContentType("text/plain");
        result = "Difference of " + x + " and " + y + " equals to:" + action;
    } else if ("*".equals(operation)) {
        action = x * y;
        result = "Multiplication of " + x + " and " + y + " equals to:" + action;
    } else if ("/".equals(operation) && y != 0) {
        action = x / y;
        result = "Division of " + x + " and " + y + " equals to:" + action;
    } else {
        result = "Error: you can't divide by zero";
    }

    request.setAttribute("result", result);
    request.setAttribute("x", x);
    request.setAttribute("y", y);
    request.getRequestDispatcher("index.jsp").forward(request, response);
%>