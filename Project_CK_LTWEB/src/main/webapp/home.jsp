<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
<meta charset="UTF-8">
<meta name="description" content="Ogani Template">
<meta name="keywords" content="Ogani, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Thực Tập Lập Trình Web</title>
<link
	href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap"
	rel="stylesheet">

<!-- Css Styles -->
<link rel="stylesheet" href="css-1/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="css-1/font-awesome.min.css" type="text/css">
<link rel="stylesheet" href="css-1/elegant-icons.css" type="text/css">
<link rel="stylesheet" href="css-1/nice-select.css" type="text/css">
<link rel="stylesheet" href="css-1/jquery-ui.min.css" type="text/css">
<link rel="stylesheet" href="css-1/owl.carousel.min.css" type="text/css">
<link rel="stylesheet" href="css-1/slicknav.min.css" type="text/css">
<link rel="stylesheet" href="css-1/style.css" type="text/css">
</head>

<body>

	<div id="preloder">
		<div class="loader"></div>
	</div>

	<jsp:include page="header.jsp"></jsp:include>

	<!-- Loại Sản Phẩm -->
	<section class="categories">
		<div class="container">
			<div class="row">
				<div class="categories__slider owl-carousel">
					<div class="col-lg-3">
						<div class="categories__item set-bg"
							data-setbg="img/categories/cat-1.jpg">
							<h5>
								<a href="#">Fresh Fruit</a>
							</h5>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Loại Sản Phẩm -->


	<!-- List All Product -->
	<section class="featured spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="section-title">
						<h2>Shop đồ ăn HandMade</h2>
					</div>
					<div class="featured__controls">
						<ul>
							<li class="active" data-filter="*">Tất cả</li>
							<li data-filter=".oranges">Đồ ăn</li>
							<li data-filter=".fresh-meat">Đồ uống</li>
							<li data-filter=".vegetables">Bánh kem</li>
							<li data-filter=".fastfood">Trái cây</li>
							<li data-filter=".fastfood">Thêm</li>
						</ul>
					</div>
				</div>
			</div>
			<div class="row featured__filter">
				<c:forEach var="product" items="${ListAllProduct}">
					<div class="col-lg-3 col-md-4 col-sm-6 mix vegetables fastfood">
						<div class="featured__item">
							<div class="featured__item__pic set-bg"
								data-setbg="${product.getImage() }">
								<ul class="featured__item__pic__hover">
									<li><a href="#"><i class="fa fa-heart"></i></a></li>
									<li><a href="#"><i class="fa fa-retweet"></i></a></li>
									<li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
								</ul>
							</div>
							<div class="featured__item__text">
								<h6>
									<a href="product?proId=${product.id }">${product.getName()}</a>
								</h6>
								<h5>Giá: ${product.formatPrice()} VNĐ.</h5>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>

			<!-- Phân Trang -->

			<div class="pagination">
				<c:if test="${tag > 1}">
					<a href="HomeController?index=${tag-1}"><i
						class="fa fa-long-arrow-left"></i></a>
				</c:if>
				<c:forEach begin="1" end="${endP}" var="i">
					<a class="${tag==i?" active":""}" href="HomeController?index=${i}">${i}</a>
				</c:forEach>
				<c:if test="${tag < endP}">
					<a href="HomeController?index=${tag+1}"><i
						class="fa fa-long-arrow-right"></i></a>
				</c:if>
			</div>
			<!-- Phân Trang -->

		</div>
	</section>
	<!-- List All Product -->



	<!-- Latest Product Section Begin -->
	<section class="latest-product spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-4 col-md-6">
					<div class="latest-product__text">
						<h4>Sản Phẩm Khuyến Mãi</h4>
						<div class="latest-product__slider owl-carousel">
							<div class="latest-prdouct__slider__item">
								<c:forEach var="product" items="${listProductNew}">
									<a href="#" class="latest-product__item">
										<div class="latest-product__item__pic">
											<img src="${product.image}" alt="">
										</div>
										<div class="latest-product__item__text">
											<h6>${product.name}</h6>
											<span>Giá: ${product.price} vnđ</span>
										</div>
									</a>
								</c:forEach>
							</div>
							<div class="latest-prdouct__slider__item">
								<c:forEach var="product" items="${listProductNew}">
									<a href="#" class="latest-product__item">
										<div class="latest-product__item__pic">
											<img src="${product.image}" alt="">
										</div>
										<div class="latest-product__item__text">
											<h6>${product.name}</h6>
											<span>Giá: ${product.price} vnđ</span>
										</div>
									</a>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-6">
					<div class="latest-product__text">
						<h4>Sản Phẩm Khuyến Mãi</h4>
						<div class="latest-product__slider owl-carousel">
							<div class="latest-prdouct__slider__item">
								<c:forEach var="product" items="${listProductNew}">
									<a href="#" class="latest-product__item">
										<div class="latest-product__item__pic">
											<img src="${product.image}" alt="">
										</div>
										<div class="latest-product__item__text">
											<h6>${product.name}</h6>
											<span>Giá: ${product.price} vnđ</span>
										</div>
									</a>
								</c:forEach>
							</div>
							<div class="latest-prdouct__slider__item">
								<c:forEach var="product" items="${listProductNew}">
									<a href="#" class="latest-product__item">
										<div class="latest-product__item__pic">
											<img src="${product.image}" alt="">
										</div>
										<div class="latest-product__item__text">
											<h6>${product.name}</h6>
											<span>Giá: ${product.price} vnđ</span>
										</div>
									</a>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-6">
					<div class="latest-product__text">
						<h4>Sản Phẩm Khuyến Mãi</h4>
						<div class="latest-product__slider owl-carousel">
							<div class="latest-prdouct__slider__item">
								<c:forEach var="product" items="${listProductNew}">
									<a href="#" class="latest-product__item">
										<div class="latest-product__item__pic">
											<img src="${product.image}" alt="">
										</div>
										<div class="latest-product__item__text">
											<h6>${product.name}</h6>
											<span>Giá: ${product.price} vnđ</span>
										</div>
									</a>
								</c:forEach>
							</div>
							<div class="latest-prdouct__slider__item">
								<c:forEach var="product" items="${listProductNew}">
									<a href="#" class="latest-product__item">
										<div class="latest-product__item__pic">
											<img src="${product.image}" alt="">
										</div>
										<div class="latest-product__item__text">
											<h6>${product.name}</h6>
											<span>Giá: ${product.price} vnđ</span>
										</div>
									</a>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Latest Product Section End -->

	<!-- Blog Section Begin -->
	<section class="from-blog spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="section-title from-blog__title">
						<h2>From The Blog</h2>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-4 col-md-4 col-sm-6">
					<div class="blog__item">
						<div class="blog__item__pic">
							<img src="img/blog/blog-1.jpg" alt="">
						</div>
						<div class="blog__item__text">
							<ul>
								<li><i class="fa fa-calendar-o"></i> May 4,2019</li>
								<li><i class="fa fa-comment-o"></i> 5</li>
							</ul>
							<h5>
								<a href="#">Cooking tips make cooking simple</a>
							</h5>
							<p>Sed quia non numquam modi tempora indunt ut labore et
								dolore magnam aliquam quaerat</p>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-4 col-sm-6">
					<div class="blog__item">
						<div class="blog__item__pic">
							<img src="img/blog/blog-2.jpg" alt="">
						</div>
						<div class="blog__item__text">
							<ul>
								<li><i class="fa fa-calendar-o"></i> May 4,2019</li>
								<li><i class="fa fa-comment-o"></i> 5</li>
							</ul>
							<h5>
								<a href="#">6 ways to prepare breakfast for 30</a>
							</h5>
							<p>Sed quia non numquam modi tempora indunt ut labore et
								dolore magnam aliquam quaerat</p>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-4 col-sm-6">
					<div class="blog__item">
						<div class="blog__item__pic">
							<img src="img/blog/blog-3.jpg" alt="">
						</div>
						<div class="blog__item__text">
							<ul>
								<li><i class="fa fa-calendar-o"></i> May 4,2019</li>
								<li><i class="fa fa-comment-o"></i> 5</li>
							</ul>
							<h5>
								<a href="#">Visit the clean farm in the US</a>
							</h5>
							<p>Sed quia non numquam modi tempora indunt ut labore et
								dolore magnam aliquam quaerat</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Blog Section End -->

	<!-- Footer Section Begin -->
	<footer class="footer spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-3 col-md-6 col-sm-6">
					<div class="footer__about">
						<div class="footer__about__logo">
							<a href="./index.html"><img src="img/logo.png" alt=""></a>
						</div>
						<ul>
							<li>Address: 60-49 Road 11378 New York</li>
							<li>Phone: +65 11.188.888</li>
							<li>Email: hello@colorlib.com</li>
						</ul>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 col-sm-6 offset-lg-1">
					<div class="footer__widget">
						<h6>Useful Links</h6>
						<ul>
							<li><a href="#">About Us</a></li>
							<li><a href="#">About Our Shop</a></li>
							<li><a href="#">Secure Shopping</a></li>
							<li><a href="#">Delivery infomation</a></li>
							<li><a href="#">Privacy Policy</a></li>
							<li><a href="#">Our Sitemap</a></li>
						</ul>
						<ul>
							<li><a href="#">Who We Are</a></li>
							<li><a href="#">Our Services</a></li>
							<li><a href="#">Projects</a></li>
							<li><a href="#">Contact</a></li>
							<li><a href="#">Innovation</a></li>
							<li><a href="#">Testimonials</a></li>
						</ul>
					</div>
				</div>
				<div class="col-lg-4 col-md-12">
					<div class="footer__widget">
						<h6>Join Our Newsletter Now</h6>
						<p>Get E-mail updates about our latest shop and special
							offers.</p>
						<form action="#">
							<input type="text" placeholder="Enter your mail">
							<button type="submit" class="site-btn">Subscribe</button>
						</form>
						<div class="footer__widget__social">
							<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
								class="fa fa-instagram"></i></a> <a href="#"><i
								class="fa fa-twitter"></i></a> <a href="#"><i
								class="fa fa-pinterest"></i></a>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="footer__copyright">
						<div class="footer__copyright__text">
							<p>
								<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
								Copyright &copy;
								<script>
									document.write(new Date().getFullYear());
								</script>
								All rights reserved | This template is made with <i
									class="fa fa-heart" aria-hidden="true"></i> by <a
									href="https://colorlib.com" target="_blank">Colorlib</a>
								<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
							</p>
						</div>
						<div class="footer__copyright__payment">
							<img src="img/payment-item.png" alt="">
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>
	<!-- Footer Section End -->

	<!-- Js Plugins -->
	<script src="js-1/jquery-3.3.1.min.js"></script>
	<script src="js-1/bootstrap.min.js"></script>
	<script src="js-1/jquery.nice-select.min.js"></script>
	<script src="js-1/jquery-ui.min.js"></script>
	<script src="js-1/jquery.slicknav.js"></script>
	<script src="js-1/mixitup.min.js"></script>
	<script src="js-1/owl.carousel.min.js"></script>
	<script src="js-1/main.js"></script>



</body>

</html>