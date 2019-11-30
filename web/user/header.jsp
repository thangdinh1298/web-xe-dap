<%-- 
    Document   : header
    Created on : Nov 29, 2019, 2:53:59 PM
    Author     : thang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/user/vendor/bootstrap/css/bootstrap.min.css">
    </head>
    <header>
        <div class="wrapper">
                <a href="${pageContext.request.contextPath}/ViewProductServlet?&url=/user/index.jsp"><img src="${pageContext.request.contextPath}/img/logo.png" class="logo" alt="" title=""/></a>
                <a href="#" class="hamburger"></a>
                <nav>
                        <ul>
                                <li><a href="${pageContext.request.contextPath}/user/shopping_cart.jsp">Shopping Cart</a></li>
                                <li><a href="#">About</a></li>
                                <li><a href="#">Contact</a></li>
                        </ul>
                        <a href="#" class="login_btn">Login</a>
                </nav>
        </div>
    </header><!--  end header section  -->
</html>
