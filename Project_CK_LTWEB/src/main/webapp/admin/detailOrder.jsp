<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html dir="ltr" lang="en">

<head>
<meta charset="utf-8">

<title>Order Detail</title>

<link rel="icon" type="image/png" sizes="16x16"
	href="/Project_CK_LTWEB/admin/Image/favicon.png">
<!-- Custom CSS -->
<link href="/Project_CK_LTWEB/admin/css/style.min.css" rel="stylesheet">
<link href="/Project_CK_LTWEB/admin/css/bootstrap.min.css"
	rel="stylesheet">
<link href="/Project_CK_LTWEB/admin/css/jquery.dataTables.min.css"
	rel="stylesheet">

<link rel="stylesheet" type="text/css"
	href="/Project_CK_LTWEB/themify-icons/themify-icons.css">

</head>

<body>
	<jsp:include page="adminHeader.jsp"></jsp:include>
	<!-- ============================================================== -->
	<fmt:setLocale value="${sessionScope.langName}" />
	<fmt:setBundle basename="i18n.lang" var="lang" />
	<!-- ============================================================== -->
	<div class="preloader">
		<div class="lds-ripple">
			<div class="lds-pos"></div>
			<div class="lds-pos"></div>
		</div>
	</div>
	<!-- ============================================================== -->
	<!-- Main wrapper - style you can find in pages.scss -->
	<!-- ============================================================== -->
	<div id="main-wrapper" data-layout="vertical" data-navbarbg="skin5"
		data-sidebartype="full" data-sidebar-position="absolute"
		data-header-position="absolute" data-boxed-layout="full">
		<div class="page-wrapper">

			<!-- Container fluid  -->
			<!-- ============================================================== -->
			<div class="container-fluid">
				<!-- ============================================================== -->
				<!-- Start Page Content -->
				<!-- ============================================================== -->
				<div class="row">
					<div class="col-sm-12">
						<div class="white-box">
							<c:if test="${access != null }">
								<div class="alert alert-success">
									<fmt:message key="message.delete" bundle="${lang }"></fmt:message>
								</div>
							</c:if>
							<a href = "/Project_CK_LTWEB/order?action=${previous }" class = "btn btn-primary">Quay về</a>
							<h3 class="box-title text-uppercase text-center mb-3">
								<fmt:message key="order.detail" bundle="${lang }"></fmt:message>
							</h3>
							
							<h5>Mã đơn: #${order.orderId }</h5>
							<h5>Ngày đặt: ${order.date }</h5>
							<h5>Tài khoản đặt: ${order.userName }</h5>
							<h5>Trình trạng:
								<c:if test="${order.status == 0}">
									<label class ="badge badge-danger"><fmt:message key="order.destroy" bundle="${lang }"></fmt:message></label>
								</c:if>
								<c:if test="${order.status == 1}">
									<label class ="badge badge-danger"><fmt:message key="order.accept" bundle="${lang }"></fmt:message></label>
								</c:if>
								<c:if test="${order.status == 2}">
									<label class ="badge badge badge-primary"><fmt:message key="order.wattingMove" bundle="${lang }"></fmt:message></label>
								</c:if>
								<c:if test="${order.status == 3}">
									<label class ="badge badge-info"><fmt:message key="order.move" bundle="${lang }"></fmt:message></label>
								</c:if>
								<c:if test="${order.status == 4}">
									<label class ="badge badge-success"><fmt:message key="order.finish" bundle="${lang }"></fmt:message></label>
								</c:if>
							</h5>
							<h5>Phí vận chuyển: ${priceTransport } VND</h5>
							
							<div class="table-responsive">
								<table class="table text-nowrap" id="myTable">
									<thead>
										<tr>
											<th class="border-top-0"><fmt:message
													key="product.name" bundle="${lang }"></fmt:message></th>
											<th class="border-top-0"><fmt:message
													key="product.img" bundle="${lang }"></fmt:message></th>
											<th class="border-top-0"><fmt:message key="product.price"
													bundle="${lang }"></fmt:message></th>
													
											<th class="border-top-0"><fmt:message key="order.quanlity"
													bundle="${lang }"></fmt:message></th>

										</tr>
									</thead>
									<tbody>
										<c:forEach var="orderItem" items="${order.listOrderItem}">
											<tr>
												 <td>${orderItem.getProduct().getName()}</td>
												<td><img src="${orderItem.getProduct().getImage()}"
													style="width: 80px; height: 80px;"></td>
												<td>${orderItem.getProduct().formatPrice() }</td>
												<td>${orderItem.getQuanlity() }</td>
											</tr>

										</c:forEach>

									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- ============================================================== -->
		<!-- End Page wrapper  -->
		<!-- ============================================================== -->
	</div>
	<jsp:include page="adminFooter.html"></jsp:include>

	<script src="/Project_CK_LTWEB/admin/js/jquery.min.js"></script>
	<!-- Bootstrap tether Core JavaScript -->
	<script src="/Project_CK_LTWEB/admin/js/bootstrap.bundle.min.js"></script>
	<script src="/Project_CK_LTWEB/admin/js/app-style-switcher.js"></script>
	<!--Wave Effects -->
	<script src="/Project_CK_LTWEB/admin/js/waves.js"></script>
	<!--Menu sidebar -->
	<script src="/Project_CK_LTWEB/admin/js/sidebarmenu.js"></script>
	<!--Custom JavaScript -->
	<script src="/Project_CK_LTWEB/admin/js/custom.js"></script>
	<script src="/Project_CK_LTWEB/admin/js/jquery.dataTables.min.js"></script>
</body>

</html>