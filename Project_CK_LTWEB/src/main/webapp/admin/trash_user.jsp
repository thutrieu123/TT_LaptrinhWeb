<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html dir="ltr" lang="en">

<head>
<meta charset="utf-8">

<title>Manager User</title>

<link rel="icon" type="image/png" sizes="16x16"
	href="/Project_CK_LTWEB/admin/Image/favicon.png">
<!-- Custom CSS -->
<link href="/Project_CK_LTWEB/admin/css/style.min.css" rel="stylesheet">
<link href="/Project_CK_LTWEB/admin/css/bootstrap.min.css"
	rel="stylesheet">
<link href="/Project_CK_LTWEB/admin/css/jquery.dataTables.min.css"
	rel="stylesheet">
	<link href="/Project_CK_LTWEB/admin/css/main.css"
	rel="stylesheet">

<link rel="stylesheet" type="text/css"
	href="/Project_CK_LTWEB/themify-icons/themify-icons.css">
	<link href="/Project_CK_LTWEB/admin/css/main.css"
	rel="stylesheet">

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
									<fmt:message key="message.subccess" bundle="${lang }"></fmt:message>
								</div>
							</c:if>
							<h3 class="box-title text-uppercase text-center mb-3"><fmt:message key="menu.Trash"
										bundle="${lang }"></fmt:message></h3>
										
							<a
							class="btn btn-info mb-4"
							href="/Project_CK_LTWEB/manager_user" aria-expanded="false"><span
								class="hide-menu"><fmt:message key="btn.back"
										bundle="${lang }"></fmt:message></span>
							</a>
							<div class="table-responsive">
								<table class="table text-nowrap" id="myTable">
									<thead>
										<tr>
											<th class="border-top-0"><fmt:message key="user.id"
										bundle="${lang }"></fmt:message></th>
											<th class="border-top-0"><fmt:message key="user.fullName"
										bundle="${lang }"></fmt:message></th>
											<th class="border-top-0"><fmt:message key="user.phone"
										bundle="${lang }"></fmt:message></th>
											<th class="border-top-0"><fmt:message key="user.userName"
										bundle="${lang }"></fmt:message></th>
											<th class="border-top-0"><fmt:message key="user.role"
										bundle="${lang }"></fmt:message></th>
											<th class="border-top-0"><fmt:message key="user.function"
										bundle="${lang }"></fmt:message></th>

										</tr>
									</thead>
									<tbody>
										<c:forEach var="eUser" items="${listUser}">
											<tr>
												<td>${eUser.id}</td>
												<td>${eUser.fullName }</td>
												<td>${eUser.numberPhone }</td>
												<td>${eUser.userName }</td>
												<td>${eUser.rolId == 1 ? "Admin":"User" }</td>
												<td><button onclick="changeStatus(this,${eUser.id})" class = "btn btn-primary text-white"><i class="ti-unlock"></i></button>
												</td>

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
		
	</div>
		<div>
		<div id="toast_message">
			
		</div>
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
	<script type="text/javascript">
		$(document).ready(function() {
			$('#myTable').DataTable();
		});
		
		function changeStatus(element,eId){
			element.closest("tr").classList.add("selected");
			$.ajax({
				type:"POST",
				url : "/Project_CK_LTWEB/TrashUser",
				data:{
					id:eId,
					status:0
				},
				success: function(data){
					
				}
			});
			
			var table = $('#myTable').DataTable();
			var current = table.page.info().page;
			var rows = table
			    .rows( '.selected' )
			    .remove()
			    .page(current)
			    .draw('page');
			toast();
		}
		
		function toast(){
			const main = document.getElementById('toast_message');
			if(main){
				const toast = document.createElement('div');
				toast.classList.add('toast-item');
				toast.style.animation = ` fadeIn ease 0.3s,fadeOut linear 1s 2s forwards`;
				toast.innerHTML =`
					<div class="toast__icon"><i class="ti-check icon-subccess"></i></div>
					<div class="toast__body">
						<h3 class="toast__title">Success</h3>
						<p class="toast__msg">Mở khoá User thành công</p>
					</div>
					<div class="toast__close"><i class="ti-close"></i></div>
				`;
				main.appendChild(toast);
				setTimeout(() => {
					main.removeChild(toast);
				}, 2000);
			}
		}
	</script>
</body>

</html>