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
        <title>Product Maintenance</title>
    </head>
    <body>
        <h1>Product Maintenance</h1>
        <form action="${pageContext.request.contextPath}/ViewProductServlet">
            <input type="hidden" value="/admin/view_product_page.jsp" name="url">
            <button type="submit">View Products</button>
        </form>
    </body>
</html>
