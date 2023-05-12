
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Product Details Page</title>
<link rel="stylesheet" href="user/style.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<section class="">
	<form method="POST" action="CartController">
		<div style="padding-top: 20px" class="flex-box">
			<div class="left">
			<input type=  "hidden" name = "proId" value ="${product.id}">
			<div class="small mb-1" >SKU: ${product.id}</div>
				<div class="big-img">
					<img src="${product.image}">
				</div>
				<div class="images">
					<div class="small-img">
						<img src="${product.image}" onclick="showImg(this.src)">
					</div>
					<div class="small-img">
						<img src="${product.image}" onclick="showImg(this.src)">
					</div>
					<div class="small-img">
						<img src="${product.image}" onclick="showImg(this.src)">
					</div>
					<div class="small-img">
						<img src="${product.image}" onclick="showImg(this.src)">
					</div>
				</div>
			</div>

			<div class="right">
				<div class="pname">${product.name}</div>
				<div class="ratings">
					<i class="fas fa-star"></i> <i class="fas fa-star"></i> <i
						class="fas fa-star"></i> <i class="fas fa-star"></i> <i
						class="fas fa-star-half-alt"></i>
				</div>
				<p class="about">${product.getDescreption()}</p>
				<div class="price">Giá :${product.formatPrice()} vnđ</div>
				<div class="size">
					<p>Size :</p>
					<div class="psize active">M</div>
					<div class="psize">L</div>
					<div class="psize">XL</div>
					<div class="psize">XXL</div>
				</div>
				<div class="quantity">
					<p>Quantity :</p>
					<input name="inputQuantity" type="number" value="1">
				</div>
				<div class="btn-box">				
					<button type="submit" class="cart-btn">Add to Cart</button>									
				</div>
			</div>
		</div>
	</form>
	</section>
	<jsp:include page="footer.jsp"></jsp:include>
	<script>
		let bigImg = document.querySelector('.big-img img');
		function showImg(pic) {
			bigImg.src = pic;
		}
	</script>
</body>
</html>


