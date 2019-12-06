<%-- 
    Document   : product_detail
    Created on : Nov 30, 2019, 1:07:39 PM
    Author     : thang
--%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Product detail</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="robots" content="all,follow">
    <!-- Bootstrap CSS-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/user/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.green.css" id="theme-stylesheet">
    <!-- Custom stylesheet-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/custom.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/responsive.css">
  </head>
  <body>
      <jsp:include page="/user/header.jsp"/>
    <div id="all">
      <div id="heading-breadcrumbs">
        <div class="container">
          <div class="row d-flex align-items-center flex-wrap">
            <div class="col-md-7">
              <h1 class="h2">${xd.des}</h1>
            </div>
          </div>
        </div>
      </div>
      <div id="content">
        <div class="container">
          <div class="row bar">
            <!-- LEFT COLUMN _________________________________________________________-->
            <div class="col-lg-12">
              <div id="productMain" class="row">
                <div class="col-sm-6">
                  <div data-slider-id="1" class="owl-carousel shop-detail-carousel">
                    <div> <img src="${pageContext.request.contextPath}/${xd.imgLink}" alt="" class="img-fluid"></div>
                  </div>
                </div>
                <div class="col-sm-6">
                  <div class="box">
                    <form action="${pageContext.request.contextPath}/ShopCartServlet">
                      <div class="sizes">
                        <h3>Available sizes</h3>
                        <select class="bs-select">
                          <option value="small">Small</option>
                          <option value="medium">Medium</option>
                          <option value="large">Large</option>
                          <option value="x-large">X Large</option>
                        </select>
                        <input type="hidden" value="${xd.code}" name="code">
                        <input type="hidden" value="${xd.des}" name="description">
                        <input type="hidden" value="${xd.yearManufactured}" name="yearManufactured" >
                        <input type="hidden" value="${xd.price}" name="price">
                        <input type="hidden" value="${xd.imgLink}" name="imgLink">
                      </div>
                      <p class="price">$${xd.price}</p>
                      <p class="text-center">
                        <button type="submit" class="btn btn-template-outlined"><i class="fa fa-shopping-cart"></i> Add to cart</button>
                      </p>
                    </form>
                  </div>
                </div>
              </div>
              <div id="pills-tabContent" class="tab-content">
                <div id="pills-home" role="tabpanel" aria-labelledby="pills-home-tab" class="tab-pane fade active show"><p></p>
                  <h4>Product details</h4>
                  This product was produced in the year ${xd.yearManufactured}
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