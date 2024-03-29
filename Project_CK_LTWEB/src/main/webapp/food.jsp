<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/main.css">
<title>Đồ Ăn</title>
</head>
<body>
	<jsp:include page="/header.jsp"></jsp:include>


	<div class="container-fluid">
		<div class="body">
			<h3 style="text-align: center;">
				<b>ĐỒ Ăn</b>
			</h3>
			<div class="row mr-top-20 justify-content-center">
				<c:forEach var="product" items="${listAllFood}">
					<div class="row">
						<form method="POST" action="CartController">
							<div class="col-md-4 col-sm-2 product">
								<div class="card  is-table-row" style="width: 14.5rem;">
									<a href="product?proId=${product.id }">
									<input type="hidden" name="proId" value="${product.id}">
									<input type="hidden" name="inputQuantity" value="1">
									<img src="${product.getImage()}" class="card-img-top" alt="..."></a>
									<div class="card-body">
										<a href="product?proId=${product.id }">
										<h5 class=" card-title show_txt ">
												<b>${product.getName()}</b>
										</h5></a>
										<p class="card-text show_txt">${product.getDescreption()}</p>
										<b>Giá: ${product.formatPrice()} VNĐ.</b>

										<button style="margin-top: 4px;" type="submit"
											class="btn btn-outline-success">
											<i class="ti-shopping-cart icon-black"></i> Thêm vào giỏ
										</button>
									</div>
								</div>
							</div>
						</form>
					</div>
				</c:forEach>
			</div>
			
			<div style="padding-top: 50px">
				<div style="padding-left: 750px">
					<ul class="pagination">
					<c:if test="${tag >1}">
						<li class="page-item"><a class="page-link"
							href="FoodController?index=${tag-1}">Previous</a></li></c:if>
						<c:forEach begin="1" end="${endPFood}" var="i">
							<li class="${tag==i?"page-item active":""}""><a
								class="page-link" href="FoodController?index=${i}">${i}</a></li>
						</c:forEach>
						<c:if test="${tag < endPFood}">
						<li class="page-item"><a class="page-link"
							href="FoodController?index=${tag+1}">Next</a></li></c:if>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
=======
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/main.css">
<title>Đồ Ăn</title>
</head>
<body>
	<jsp:include page="/header.jsp"></jsp:include>


	<div class="container-fluid">
		<div class="body">
			<h3 style="text-align: center;">
				<b>ĐỒ Ăn</b>
			</h3>
			<div class="row mr-top-20 justify-content-center">
				<c:forEach var="product" items="${listAllFood}">
					<div class="row">
						<form method="POST" action="CartController">
							<div class="col-md-4 col-sm-2 product">
								<div class="card  is-table-row" style="width: 14.5rem;">
									<a href="product?proId=${product.id }">
									<input type="hidden" name="proId" value="${product.id}">
									<input type="hidden" name="inputQuantity" value="1">
									<img src="${product.getImage()}" class="card-img-top" alt="..."></a>
									<div class="card-body">
										<a href="product?proId=${product.id }">
										<h5 class=" card-title show_txt ">
												<b>${product.getName()}</b>
										</h5></a>
										<p class="card-text show_txt">${product.getDescreption()}</p>
										<b>Giá: ${product.formatPrice()} VNĐ.</b>

										<button style="margin-top: 4px;" type="submit"
											class="btn btn-outline-success">
											<i class="ti-shopping-cart icon-black"></i> Thêm vào giỏ
										</button>
									</div>
								</div>
							</div>
						</form>
					</div>
				</c:forEach>
			</div>
			
			<div style="padding-top: 50px">
				<div style="padding-left: 750px">
					<ul class="pagination">
					<c:if test="${tag >1}">
						<li class="page-item"><a class="page-link"
							href="FoodController?index=${tag-1}">Previous</a></li></c:if>
						<c:forEach begin="1" end="${endPFood}" var="i">
							<li class="${tag==i?"page-item active":""}""><a
								class="page-link" href="FoodController?index=${i}">${i}</a></li>
						</c:forEach>
						<c:if test="${tag < endPFood}">
						<li class="page-item"><a class="page-link"
							href="FoodController?index=${tag+1}">Next</a></li></c:if>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
>>>>>>> 023db903cf4b54ee329e0a1d8374c5a120511db5
</html>