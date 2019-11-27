<%-- 
    Document   : xe_dap
    Created on : Oct 22, 2019, 12:11:49 AM
    Author     : thang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>Choose your role</h1>
        <p> <a href="admin/admin_index.jsp"> I'm an admin </a> </p>
        <p> 
            <form action="/xe_dap/ViewProductServlet">
                <input type="hidden" value="/user/index.jsp" name="url">
                <input value="I'm a user" type="submit"></input>
            </form> 
        </p>
    </body>
</html>
