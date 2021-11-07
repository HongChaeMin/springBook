<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>SB Admin 2 - Bootstrap Admin Theme</title>

<!-- Bootstrap Core CSS -->
<link href="/resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="/resources/vendor/metisMenu/metisMenu.min.css"
	rel="stylesheet">

<!-- DataTables CSS -->
<link
	href="/resources/vendor/datatables-plugins/dataTables.bootstrap.css"
	rel="stylesheet">

<!-- DataTables Responsive CSS -->
<link
	href="/resources/vendor/datatables-responsive/dataTables.responsive.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="/resources/dist/css/sb-admin-2.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="/resources/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- jQuery -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

</head>

<body>

	<form id="operForm" action="/board/modify" method="get">
		<input type="hidden" id="bon" name="bon" value="${board.bon}">
		<input type="hidden" id="pageNum" name="pageNum" value="${cri.pageNum}">
		<input type="hidden" id="amount" name="amount" value="${cri.amount}">
	</form>

	<div id="wrapper">

		<%@ include file="../includes/header.jsp"%>

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Board Read Page</h1>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">Board Read Page</div>
						<div class="panel-body">
							<div class="form-group">
								<label>No</label><input class="form-control" name="bon" value="${board.bon }" readonly>
							</div>
							<div class="form-group">
								<label>Title</label><input class="form-control" name="title" value="${board.title }" readonly>
							</div>
							<div class="form-group">
								<label>Text area</label>
								<textarea class="form-control" rows="3" name="content" readonly><c:out value="${board.content }" /></textarea>
							</div>
							<div class="form-group">
								<label>Writer</label><input class="form-control" name="writer" value="${board.writer }" readonly>
							</div>
							<button data-oper="modify" class="btn btn-default" onclick="location.href='/board/updatePage'">Modify</button>
							<button data-oper="list" class="btn btn-info" onclick="location.href='/board/list?pageNum=${cri.pageNum}&amount=${cri.amount}'">List</button>
							<form action="/board/updatePage" method="get">
								<input type="hidden" name="bon" value="${board.bon}">
								<input type="hidden" name="pageNum" value="${cri.pageNum}">
								<input type="hidden" name="amount" value="${cri.amount}">
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="../includes/footer.jsp"%>

</body>

</html>
