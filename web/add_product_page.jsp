<%-- 
    Document   : add_product_page
    Created on : Oct 24, 2019, 11:21:42 PM
    Author     : thang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add a xe dap</title>
    </head>
    <body>
        <h1>Add a product</h1>
        <!--Check error string and display if exists-->
        <p>${msg1}</p>
        <p>${msg2}</p>
        <p>${msg3}</p>
        <p>${msg4}</p>
        
        <form action="AddProductServlet" method="POST">
            <table cellspacing="5">
                <tr>
                    <td align="right">Product code:</td>
                    <td><input type="text" name="code" value="${code}"></td>
                </tr>
                <tr>
                    <td align="right">Product description:</td>
                    <td><input type="text" name="description" value="${des}"></td>
                </tr>
                <tr>
                    <td align="right">Product price:</td>
                    <td><input type="text" name="price" value="${price}"></td>
                </tr>
                <tr>
                    <td align="right">Year manufactured</td>
                    <td><input type="text" name="yearManufactured" value="${yearManufactured}"></td>
                </tr>
            </table>
            <button type="submit">Submit</button>
        </form>
    </body>
</html>
