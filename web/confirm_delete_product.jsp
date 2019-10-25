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
        <p>Product code ${param.code}</p>
        <p>Product description ${param.description}</p>
        <p>Year manufactured ${param.yearManufactured}</p>
        <p>Price ${param.price}</p>
        <button>Delete</button> 
        <button>Cancel</button>
    </body>
</html>
