<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="dataModels.Product"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css">
{
margin












:






 






0;
padding












:






 






0;
}
body {
	background-color: #f1f3f4;
	font-family: sans-serif;
}

.carousel-control-prev-icon, .carousel-control-next-icon {
	height: 100px;
	width: 100px;
	outline: black;
	background-size: 100%, 100%;
	border-radius: 50%;
	border: 1px solid black;
	background-image: none;
}

.top-nav-bar {
	height: 170px;
	top: 0;
	position: sticky;
	background: #000000;
	margin-bottom: 20px;
	border-bottom: 3px solid orange;
	z-index: 2;
}

.logo {
	height: 120px;
	margin: -65px 22px 0;
}

.form-control {
	margin-top: 9px;
	margin-left: 30px;
	border: 1px solid orange !important;
	border-top-left-radius: 20px !important;
	border-bottom-left-radius: 20px !important;
	border-top-right-radius: 0 !important;
	border-bottom-right-radius: 0 !important;
	box-shadow: none !important;
}

.input-group-text {
	background: orange !important;
	border: 1px solid orange !important;
	margin: 8.5px 10px 3px 0 !important;
	border-top-left-radius: 0px !important;
	border-bottom-left-radius: 0px !important;
	border-top-right-radius: 20px !important;
	border-bottom-right-radius: 20px !important;
	cursor: pointer;
}

.search-box {
	display: inline-flex;
	width: 60%;
	height: 34%;
	position: relative;
	top: 90px;
}

.fa-search {
	color: #fff;
}

.menu-bar {
	width: 1000%;
	height: 57px;
	float: right;
}

.menu-bar ul {
	display: inline-flex;
	float: right;
}

.menu-bar ul li {
	border-left: 1px solid #fff;
	list-style-type: none;
	padding: 15px 35px;
	text-align: center;
	background-color: orange;
	cursor: pointer;
}

.menu-bar ul li a {
	font-size: 16px;
	font-weight: bold;
	color: #fff;
	text-decoration: none;
}

.fa-shopping-basket {
	margin-right: 5px;
}

@media only screen and (max-width: 980px) {
	.top-nav-bar {
		height: 118px;
		border-bottom: 0;
	}
	.search-box {
		width: 100%;
	}
	.menu-bar {
		width: 100%;
	}
	.menu-bar ul {
		margin: 10px 0;
		width: 100%;
	}
	.menu-bar ul li {
		height: 57px;
		width: 100%
	}

	/*------single-product-------*/
}

.single-product {
	margin-top: 70px;
}

.new-arrival {
	background: green;
	width: 50px;
	color: #fff;
	font-size: 12px;
	font-weight: bold;
	margin-top: 20px;
}

.new-arrival h2 {
	background: green;
	width: 50px;
	color: #000000;
	font-size: 12px;
	font-weight: bold;
	margin-top: 20px;
}

.col-md-7 h2 {
	color: #000000;
	width: 500px;
}

.single-product .fa {
	color: orange;
}

.single-product .price {
	color: orange;
	font-size: 26px;
	font-weight: bold;
	padding-top: 20px;
}

.single-product input {
	border: 2px solid #ccc;
	font-weight: bold;
	height: 33px;
	text-align: center;
	width: 30px;
}

.go-back {
	margin-top: 70px;
}

.go-back button {
	color: #000000;
	background: orange;
}
</style>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Single Product</title>
</head>
<body>
	<div class="top-nav-bar">
		<div class="search-box">
			<i class="fa fa-bars" id="menu-btn" onclick="openmenu()"></i> <i
				class="fa fa-times" id="close-btn" onclick="closemenu()"></i> <a
				href="/dailydeals/mainGUI.jsp"><img
				src="https://i.pinimg.com/236x/a8/31/25/a8312509e852001498c151145135e599--promotion-daily-deals.jpg"
				class=logo></a> <input type=text class="form-control"> <span
				class="input-group-text"><i class="fa fa-search"
				aria-hidden="true"></i></span>
		</div>

		<div class="menu-bar">
			<ul>
				<li><a href="GetCartServlet"><i
						class="fa fa-shopping-basket"></i>cart</a></li>
				<li><a href="WishListServlet">Wishlist</a></li>
				<li><a href="/dailydeals/signUpPage.jsp">Sign Up</a></li>
				<li><a href="/dailydeals/loginPage.jsp">Log In</a></li>
				<li><a href="/dailydeals/accountManagementPage.jsp">My
						Account</a></li>
			</ul>
		</div>
	</div>

	<!-- --single product -->
	<%="inside Product.jsp " + session.getAttribute("AuthUserEmail")%>

	<%
		System.out.println("inside product.jsp");
		Product product = (Product) request.getAttribute("product");
		System.out.println(product.getProductName());
	%>
	<section class="single-product">
	<div class="container">
		<div class="row">
			<div class="col-md-5">
				<div id="product-slider" class="carousel slide carousel-fade"
					data-ride="carousel">
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img src="${product.getImageUrls().get(0) }">
						</div>
						<c:forEach
							items="${product.getImageUrls().subList(1,product.getImageUrls().size())}"
							var="url">
							<div class="carousel-item">
								<img src="${url }">
							</div>
						</c:forEach>
						<a class="carousel-control-prev" href="#product-slider"
							role="button" data-slide="prev"> <span
							class="carousel-control-prev-icon" aria-hidden="true"></span> <span
							class="sr-only">Previous</span>
						</a> <a class="carousel-control-next" href="#product-slider"
							role="button" data-slide="next"> <span
							class="carousel-control-next-icon" aria-hidden="true"></span> <span
							class="sr-only">Next</span>
						</a>
					</div>
				</div>
			</div>

			<div class="col-md-7">
				<p class="new-arrival text-center"></p>
				<h2>${product.getProductName()}</h2>
				



				<p class="price">USD $${product.getPrice() }</p>
				<p>
					<b>Availability:</b>
					<%
						if (product.getQuantity() >= 15) {
							out.println("In Stock");
						} else if (product.getQuantity() > 0) {
							out.println("Only " + product.getQuantity() + " Left");
						} else {
							out.println("Out of Stock");
						}
					%>

				</p>
				
				<form action="AddToCartServlet" method="post">
					<input type="hidden" name="productName" value="${product.getProductName() }"/>
					<input type="hidden" name="price" value="${product.getPrice() }"/>
					<label><b>Quantity:</b></label> <input type="text" / value="1" name="quantity"> 
					<button type="submit" value="Add To Cart" >Add To Cart</button>
				</form>
				<form action="AddToWishServlet" method="post">
					<input type="hidden" name="productName" value="${product.getProductName() }"/>
					<button type="submit" value="Add To Wish List" >Add To Wish List</button>
				</form>
			</div>
		</div>
	</div>
	</section>

	<!----product-desc -->
	<section class="product-desc">
	<div class="container">
		<h6>Product Description</h6>
		<p>${product.getDescription() }</p>
	</div>
	</section>

	<section class="go-back">
	<div class="container">
		<a href="/dailydeals/mainGUI.jsp">
			<button type="button" class="btn btn-primary">Go Back</button>
		</a>
	</div>
	</section>

</body>
</html>