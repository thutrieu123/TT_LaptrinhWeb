
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="vi" class="h-100">

<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/main.css">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Trang chi tiết sản phẩm</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
<link rel="stylesheet" href="css/product-detail.css" type="text/css">
</head>

<body>

	<jsp:include page="/header.jsp"></jsp:include>

	<div style="padding-top: 10px" class="container ">
		<div class="row">
			<div class="col">
				<div class="card">
					<div class="row">
						<div class="col-md-6">
							<div class="images p-3">
								<div class="text-center p-4">
									<img id="main-image" src="${product.image}" width="250" />
								</div>
								<div class="thumbnail text-center">
									<img onclick="change_image(this)" src="${product.image}"
										width="70"> <img onclick="change_image(this)"
										src="${product.image}" width="70">
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="product ">
								<div class="mt-4 mb-3">
									<h6 class="text-uppercase">Chi tiết sản phẩm</h6>
								</div>
								<form method="POST" action="CartController">
									<h2 class="text-uppercase">${product.name}</h2>
									<h6 class="text-uppercase">Mô tả:</h6>
									<p class="about">${product.getDescreption()}</p>
									<h6 class="text-uppercase">Loại:</h6>
									<label class="radio"> <input type="radio" name="size"
										value="S" checked> <span>Lớn</span>
									</label> <label class="radio"> <input type="radio" name="size"
										value="M"> <span>Vừa</span>
									</label> </label> <label class="radio"> <input type="radio" name="size"
										value="M"> <span>Nhỏ</span>
									</label>
									<h6>Số lượng:</h6>
									<input class="form-control text-center me-3"
										name="inputQuantity" type="number" value="1"
										style="max-width: 3rem" />
									<div>
										<div class="price">Giá :${product.formatPrice()} vnđ</div>
									</div>

									<div style="padding-top: 20px">
										<button class="btn btn-danger text-uppercase mr-2 px-4"
											type="submit">Thêm vào giỏ hàng</button>
										<i class="fa fa-heart text-muted"></i> <i
											class="fa fa-share-alt text-muted"></i>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="/footer.jsp"></jsp:include>

</body>

</html>


