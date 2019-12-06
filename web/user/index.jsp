<%-- 
    Document   : index
    Created on : Nov 30, 2019, 1:07:39 PM
    Author     : thang
--%>

<!DOCTYPE html>
<%@ taglib prefix="c" 
    uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
	<title>Bike Page</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0" />
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/responsive.css">

</head>
<body>

	<section class="hero">
		<jsp:include page="/user/header.jsp"/>

                <section class="caption">
                        <h2 class="caption">Find You Dream Bike</h2>
                        <h3 class="properties">Bikes - Apparels - Gears</h3>
                </section>
	</section><!--  end hero section  -->

	<section class="listings">
		<div class="wrapper">
			<ul class="properties_list">
				<c:forEach var="xd" items = "${products}">
					<li>
						<a href="${pageContext.request.contextPath}/ForwardProductServlet?code=${xd.code}&price=${xd.price}&description=${xd.des}&yearManufactured=${xd.yearManufactured}&imgLink=${xd.imgLink}&url=/user/product_detail.jsp">
							<img src="${xd.imgLink}" alt="" title="" class="property_img"/>
						</a>
						<span class="price">$${xd.price}</span>
						<div class="property_details">
							<h1>
								<a href="#">${xd.des}</a>
							</h1>
							<h2>Year produced: ${xd.yearManufactured} <!--<span class="property_size">(288ftsq)</span>--></h2>
						</div>
					</li>
				</c:forEach>
			</ul>
		</div>
	</section>	<!--  end listing section  -->

	<jsp:include page="/user/footer.jsp"/>
	
</body>
</html>