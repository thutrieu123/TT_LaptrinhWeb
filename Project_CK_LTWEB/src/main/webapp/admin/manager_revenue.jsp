<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html dir="ltr" lang="en">

<head>
<meta charset="utf-8">

<title>Statistical Revenue</title>
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
	
	<link href="/Project_CK_LTWEB/admin/css/main.css"
	rel="stylesheet">
	
</head>

<body>
	<jsp:include page="adminHeader.jsp"></jsp:include>

	<fmt:setLocale value="${sessionScope.langName}" />
	<fmt:setBundle basename="i18n.lang" var="lang" />

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
			<!--<c:if test="${message != null}">
				<div class="alert alert-success"
					style="display: none">
					<b><fmt:message key="message.subccess"
													bundle="${lang }"></fmt:message></b>
				</div></c:if>-->
				<!-- ============================================================== -->
				<!-- Start Page Content -->
				<!-- ============================================================== -->
				<div class="row">
					<div class="col-sm-12">
						<div class="white-box">
							<c:if test="${message != null }">
								<div class="alert alert-danger">
									<fmt:message key="message.chooseDate" bundle="${lang }"></fmt:message>
								</div>
							</c:if>

							<h3 class="box-title text-uppercase text-center">
								<fmt:message key="sta.revenue" bundle="${lang }"></fmt:message>
							</h3>
							<!--  <a href="/Project_CK_LTWEB/manager_product?action=add"
								class="btn btn-success text-white mt-2 mb-2"
								style="text-align: end; margin-right: 20px;"><fmt:message
									key="product.add" bundle="${lang }"></fmt:message></a>-->
									
									
						
									
							<div class="table-responsive">
							<div >							
									 <a href="/Project_CK_LTWEB/print?page=revenue&date_start=${date_start_revenue }&date_end=${date_end_revenue}"
								class="btn btn-success text-white mt-2 mb-2"
								style="text-align: end; margin-right: 20px;"><fmt:message
									key="menu.PrintExcel" bundle="${lang }"></fmt:message></a>
								
								<form action="${pageContext.request.contextPath}/statistical" method ="GET" style="margin: 8px 20px 8px 0px;">
									<div style="display:flex;width: 100%; justify-content: end;" class="mb-3">
										<input type ="hidden" value ="revenue" name ="page">
										<div id="date">
											<label>Từ:</label>
											<input type="date" name = "date_start_revenue" value = "${date_start_revenue}">
											<label>Đến:</label>
											<input type="date" name = "date_end_revenue" value = "${date_end_revenue}">
										</div>
										
										<button type= "submit" class = "btn btn-primary ml-2">Xem Thống Kê</button>		
									</div>
											
								</form>
								</div>
								
								<table class="table text-nowrap" id="myTable">
									<thead>
										<tr>
											<th class="border-top-0"><fmt:message key="revenue.date"
													bundle="${lang }"></fmt:message></th>
											<th class="border-top-0"><fmt:message key="revenue.quanlity"
													bundle="${lang }"></fmt:message></th>
											<th class="border-top-0"><fmt:message key="revenue.price"
													bundle="${lang }"></fmt:message></th>
				
										</tr>
									</thead>
									<tbody>
										<c:forEach var="revenue" items="${listRevenue }">
											<tr>
												<td>${revenue.date }</td>
												<td style="padding: 0px 50px;">${revenue.quanlity}</td>
												<td style="padding: 0px 25px;">${revenue.totalPrice}</td>

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
	<!-- ============================================================== -->
	<!-- End Wrapper -->
	<!-- ============================================================== -->
	<!-- ============================================================== -->
	<!-- All Jquery -->
	<!-- ============================================================== -->
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
	<script>
		$(document).ready(function() {
			$('#myTable').DataTable();
		});
	</script>



</body>

</html>