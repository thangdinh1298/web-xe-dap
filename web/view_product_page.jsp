<%-- 
    Document   : product_page
    Created on : Oct 22, 2019, 12:16:59 AM
    Author     : thang
--%>

<%@page import="java.io.File"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.XeDapIO"%>
<%@page import="Model.XeDap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View xe dap page</title>
    </head>
    
    <body>
        <h1>Bikes in stock</h1>
        <table cellspacing="5" cellpadding="5" border="1">
            <tr>
                <th>Code</th>
                <th>Description</th>
                <th>Years manufactured</th>
                <th>Price</th>
                <th></th>
                <th></th>
            </tr>
            <%  ArrayList<XeDap> xds = (ArrayList<XeDap>) request.getAttribute("products");
                for (XeDap xd: xds){
            %>
            <tr>
                <td><%= xd.getCode() %></td>
                <td><%= xd.getDes() %></td>
                <td><%= xd.getYearManufactured() %></td>
                <td><%= xd.getPrice() %></td>
                <td>
                    <form action="AddProductServlet">
                        <input type="hidden" value="<%= xd.getCode() %>" name="code">
                        <input type="hidden" value="<%= xd.getDes() %>" name="description">
                        <input type="hidden" value="<%= xd.getYearManufactured() %>" name="yearManufactured" >
                        <input type="hidden" value="<%= xd.getPrice()%>" name="price">
                        <input type="submit" value="Edit">
                    </form>
                </td>
                <td>
                    <form action="confirm_delete_product.jsp">
                        <input type="hidden" value="<%= xd.getCode() %>" name="code">
                        <input type="hidden" value="<%= xd.getDes() %>" name="description">
                        <input type="hidden" value="<%= xd.getYearManufactured() %>" name="yearManufactured" >
                        <input type="hidden" value="<%= xd.getPrice()%>" name="price">
                        <input type="submit" value="Delete">
                    </form>
                </td>
            </tr>
            <% } %>
        </table>
        <form action="add_product_page.jsp">
            <button type="submit">Add product</button>
        </form>
    </body>
</html>
