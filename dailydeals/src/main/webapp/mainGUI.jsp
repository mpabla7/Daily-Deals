<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
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
	width: 48%;
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

.fa-heart-o {
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
}

.side-menu {
	height: 79%;
	width: 15%;
	font-size: 14px;
	float: left;
	z-index: 2;
	background-color: #ddd;
}

.side-menu ul {
	margin-left: 10px;
}

.side-menu ul li {
	list-style-type: none;
	font-weight: bold;
	margin-top: 18px;
	cursor: pointer;
}

.side-menu ul li:hover {
	color: orange;
}

.side-menu ul li ul {
	display: none;
	z-index: 10;
	top
	77px;
}

.side-menu ul li:hover ul {
	display: block;
	height: 400px;
	margin-left: 11.5%;
	padding: 0 100px 10px 10px;
	position: fixed;
	background: #ececec;
	box-shadow: 1px 1px 4px 1px rgba(0, 0, 0, 0.5);
}

.fa-angle-right {
	margin-top: 4px;
	margin-right: 8px;
	float: right;
}

#menu-btn, #close-btn {
	font-size: 30px;
	margin: 10px;
	color: orange;
	display: none;
}

@media only screen and (max-width: 980px) {
	.side-menu {
		width: 34% z-index: 20;
		top: 133px;
		position: fixed;
		font-size: 10px;
		background: #f1f3f4;
		display: none;
	}
	.side-menu ul li ul {
		top: 133px;
	}
	.side-menu ul li:hover ul {
		margin-left: 31%;
	}
	#menu-btn {
		display: block;
	}
}

.slider {
	width: 85%;
	margin-left: 15%;
	padding: 0 10px;
}

.carousel {
	box-shadow: 1px 1px 4px 1px rgba(0, 0, 0, 0.5);
}

.carousel-indicators {
	z-index: 1 !important;
}

@media only screen and (max-width: 980px) {
	.slider {
		width: 100%;
		margin-left: 0;
	}
}

/*--------featured-categories CSS--------*/
.featured-categories {
	margin: 50px 0;
}

.featured-categories img {
	width: 100%;
	padding: 20px;
	transition: 1s;
	cursor: pointer;
}

.featured-categories img:hover {
	transform: scale(1.1);
}
/*--------------On Sale product CSS-------------------------*/
.title-box {
	background: orange;
	color: #fff;
	width: 180px;
	padding: 4px 10px;
	height: 40px;
	margin-bottom: 30px;
	display: flex;
}

.title-box h2 {
	font-size: 24px;
}

.title-box::after {
	content: '';
	border-top: 40px solid orange;
	border-right: 50px solid transparent;
	position: absolute;
	display: flex;
	margin-top: -4px;
	margin-left: 170px;
}
/*-------------------------Product-top CSS------------------------------*/
.product-top img {
	width: 100%;
}

.overlay-right {
	display: block;
	opacity: 0;
	position: absolute;
	top: 10%;
	margin-left: 0;
	width: 70px;
}

.overlay-right .fa {
	cursor: pointer;
	background-color: #fff;
	color: #000;
	height: 35px;
	width: 35px;
	font-size: 20px;
	padding: 7px;
	margin-top: 5%;
	margin-botton: 5%;
}

.overlay-right .btn-secondary {
	background: none !important;
	border: none !important;
	box-shadow: none !important;
}

.product-top:hover .overlay-right {
	opacity: 1;
	margin-left: 5%;
	transition: 0.5s;
}
/*----------------------Product-bottom-CSS-------------*/
.product-bottom .fa {
	color: orange;
	font-size: 10px;
}

.product-bottom h3 {
	font-size: 20px;
	font-weight: bold;
}

.product-bottom h5 {
	font-size: 15px;
	padding-bottom: 10px;
}

.new-products {
	margin: 50px 0;
}

.website-features {
	margin: 60px 0;
}

.website-features img {
	width: 20%;
}

.feature-text {
	margin-top: 10px;
	float: right;
	width: 80%;
	padding-left: 20px;
}

.feature-box {
	padding-top: 20px;
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
<title>Welcome to Daily Deals</title>
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





	<!----------------------On Sale product------------------------>
	<section class="on-sale">
	<div class="container">
		<div class="title-box">
			<h2>On Sale NOW</h2>
		</div>
		<div class="row">
			<c:forEach items="${products}" var="product">
				<div class="col-md-3">
					<div class="product-top">
						<a href="ProductServlet?productName=${product.getProductName()}"><img
							src="${ product.getImageUrls().get(0)}"></a>
						<div class="overlay-right">
						<form action="AddToWishServlet" method="post">
						<input type="hidden" name="productName" value="${product.getProductName()}"/>
							<button type="submit" class="btn btn-secondary" value="AddToWishServlet"
								title="Add to Wishlist">
								<i class="fa fa-heart-o"></i>
							</button>
						</form>
						<form action="AddToCartFromMainServlet" method="post">
						<input type="hidden" name="productName" value="${product.getProductName()}"/>
							<button type="submit" class="btn btn-secondary" value="AddToCartFromMainServlet"
								title="Add to Cart">
								<i class="fa fa-shopping-cart"></i>
							</button>
						</form>
						</div>
					</div>
					<div class="product-bottom text-center">
						${ product.getRatingStar() }
						<h3>${product.getProductName()}</h3>
						<h5>$${product.getPrice() }</h5>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	</section>



	<!-- ------Website features -->
	<section class="website-features">
	<div class="container">
		<div class="row">
			<div class="col-md-3 feature-box">
				<img
					src="https://apps.3dcart.com/assets/images/apps/3dcart-dailydeals_logo.jpg">
				<div class="feature-text">
					<p>
						<b>100% Original items</b> are available at company
					</p>
				</div>
			</div>
			<div class="col-md-3 feature-box">
				<img
					src="https://d3ccuprjuqkp1j.cloudfront.net/SupportImages/SY_ReturnPolicy.png">
				<div class="feature-text">
					<p>
						<b>Return within 30 days</b> of receiving your order
					</p>
				</div>
			</div>
			<div class="col-md-3 feature-box">
				<img
					src="data:image/png;base64,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">
				<div class="feature-text">
					<p>
						<b>Get free delivery </b>for first order
					</p>
				</div>
			</div>
			<div class="col-md-3 feature-box">
				<img
					src="data:image/png;base64,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">
				<div class="feature-text">
					<p>
						<b>Pay Online</b> using account management
					</p>
				</div>
			</div>
		</div>
	</div>
	</section>



	<!-- -----------------Footer (don't need a footer)  -->




	<script>
		function openmenu() {
			document.getElementById("side-menu").style.display = "block";
			document.getElementById("menu-btn").style.display = "none";
			document.getElementById("close-btn").style.display = "block";
		}
		function closemenu() {
			document.getElementById("side-menu").style.display = "none";
			document.getElementById("menu-btn").style.display = "block";
			document.getElementById("close-btn").style.display = "none";
		}
	</script>

</body>
</html>