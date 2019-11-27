<%-- 
    Document   : confirm_delete_product
    Created on : Oct 25, 2019, 4:15:36 PM
    Author     : thang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Are you sure you want to delete the following product</h1>
        <p><strong>Product code:</strong> ${xd.code}</p>
        <p><strong>Product description:</strong> ${xd.des}</p>
        <p><strong>Year manufactured:</strong> ${xd.yearManufactured}</p>
        <p><strong>Price:</strong> ${xd.price}</p>
        <form action="/xe_dap/DeleteProductServlet" method="POST">
            <input type="hidden" value="${xd.code}" name="code">
            <input type="hidden" value="${xd.des}" name="description">
            <input type="hidden" value="${xd.yearManufactured}" name="yearManufactured" >
            <input type="hidden" value="${xd.price}" name="price">
            <input type="submit" value="Delete">
        </form>
        <form action="/xe_dap/ViewProductServlet">
            <button type="submit">Return to product page</button>
            <input type="hidden" value="/admin/view_product_page.jsp" name="url">
        </form>
        
    </body>
</html>
