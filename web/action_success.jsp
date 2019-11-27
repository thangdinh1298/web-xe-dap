<%-- 
    Document   : product_update_success
    Created on : Oct 25, 2019, 3:47:51 PM
    Author     : thang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Success</title>
    </head>
    <body>
        <h1>Your product has been updated successfully</h1>
        <form action="/xe_dap/ViewProductServlet">
            <button type="submit">Return to product page</button>
            <input type="hidden" value="/admin/view_product_page.jsp" name="url">
        </form>
    </body>
</html>
