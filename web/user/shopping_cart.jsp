<%-- 
    Document   : shopping_cart
    Created on : Nov 30, 2019, 1:07:39 PM
    Author     : thang
--%>

<!DOCTYPE html>
<html>
<%@ taglib prefix="c" 
    uri="http://java.sun.com/jsp/jstl/core" %>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title> Shop cart </title>
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="robots" content="all,follow">
  <!-- theme stylesheet-->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.green.css" id="theme-stylesheet">
  <!-- Custom stylesheet-->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/custom.css">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/responsive.css">
</head>

<body>
    <jsp:include page="/user/header.jsp"/>
    <div id="heading-breadcrumbs">
      <div class="container" style="margin-top:25px">
        <div class="row d-flex align-items-center flex-wrap">
          <div class="col-md-7">
            <h1 class="h2">Shopping Cart</h1>
          </div>
        </div>
      </div>
    </div>
    <div id="content">
      <div class="container">
        <div class="row bar">
          <div class="col-lg-12">
            <p class="text-muted lead">You currently have 
                <c:choose>
                    <c:when test="${empty cart}">
                        0
                    </c:when>
                    <c:otherwise>
                        ${cart.productList.size()}
                    </c:otherwise>
                </c:choose> item(s) in your cart.</p>
          </div>
          <div id="basket" class="col-lg-9">
            <div class="box mt-0 pb-0 no-horizontal-padding">
                <div class="table-responsive">
                  <table class="table">
                    <thead>
                      <tr>
                        <th colspan="2">Product</th>
                        <th>Quantity</th>
                        <th>Unit price</th>
                        <th colspan="2">Total</th>
                      </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="xd" items = "${cart.productList}" varStatus="loop">
                      <tr>
                        <td><img src="${pageContext.request.contextPath}/${xd.imgLink}" alt="" class="img-fluid"></td>
                        <td>${xd.des}</td>
                        <td>
                          <input type="number" value="${cart.quantity[loop.index]}" class="form-control">
                        </td>
                        <td>${xd.price}$</td>
                        <td>${xd.price * cart.quantity[loop.index]}$</td>
                        <td><a href="#"><i class="fa fa-trash-o"></i></a></td>
                      </tr>
                    </tbody>
                    </c:forEach>
                    <tfoot>
                      <tr>
                        <th colspan="5">Total</th>
                        <th colspan="2">${cart.total}$</th>
                      </tr>
                    </tfoot>
                  </table>
                </div>
                <div class="box-footer d-flex justify-content-between align-items-center">
                  <div class="left-col">
                      <form action="${pageContext.request.contextPath}/ViewProductServlet">
                            <input type="hidden" value="/user/index.jsp" name="url">
                            <input value="Continue Shopping" type="submit" class="btn btn-secondary mt-0"></input>
                      </form>
                  </div>
                        
                </div>
            </div>
            
          </div>
          <div class="col-lg-3">
            <div id="order-summary" class="box mt-0 mb-4 p-0">
              <div class="box-header mt-0">
                <h3>Order summary</h3>
              </div>
              <p class="text-muted">Shipping and additional costs are calculated based on the values you have entered.
              </p>
              <div class="table-responsive">
                <table class="table">
                  <tbody>
                    <tr>
                      <td>Order subtotal</td>
                      <th>${cart.total}$</th>
                    </tr>
                    <tr>
                      <td>Shipping and handling</td>
                      <th>${cart.total * 0.1} $</th>
                    </tr>
                    <tr>
                      <td>Tax</td>
                      <th>$0.00</th>
                    </tr>
                    <tr class="total">
                      <td>Total</td>
                      <th>${cart.total + cart.total * 0.1}$</th>
                    </tr>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <jsp:include page="/user/footer.jsp"/>
  </div>
</body>

</html>