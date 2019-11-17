<%-- 
    Document   : product_page
    Created on : Oct 22, 2019, 12:16:59 AM
    Author     : thang
--%>
<%@ taglib prefix="c" 
    uri="http://java.sun.com/jsp/jstl/core" %>
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
            <c:forEach var="xd" items = "${products}">
            <tr>
                <td>${xd.code}</td>
                <td>${xd.des}</td>
                <td>${xd.yearManufactured}</td>
                <td>${xd.price}</td>
                <td>
                    <form action="${pageContext.request.contextPath}/ForwardProductServlet">
                        <input type="hidden" value="${xd.code}" name="code">
                        <input type="hidden" value="${xd.des}" name="description">
                        <input type="hidden" value="${xd.yearManufactured}" name="yearManufactured" >
                        <input type="hidden" value="${xd.price}" name="price">
                        <input type="hidden" value="/admin/add_product_page.jsp" name="url">
                        <input type="submit" value="Edit">
                    </form>
                </td>
                <td>
                    <form action="${pageContext.request.contextPath}/ForwardProductServlet">
                        <input type="hidden" value="${xd.code}" name="code">
                        <input type="hidden" value="${xd.des}" name="description">
                        <input type="hidden" value="${xd.yearManufactured}" name="yearManufactured" >
                        <input type="hidden" value="${xd.price}" name="price">
                        <input type="hidden" value="/admin/confirm_delete_product.jsp" name="url">
                        <input type="submit" value="Delete">
                    </form>
                </td>
            </tr>
            </c:forEach>
        </table>
        <form action="admin/add_product_page.jsp" method="POST">
            <button type="submit">Add product</button>
        </form>
    </body>
</html>
