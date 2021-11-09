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

	<div id="wrapper">

		<%@ include file="../includes/header.jsp"%>

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Tables</h1>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">Board List Page</div>
						<div class="panel-body">
							<table class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th>#번호</th>
										<th>제목</th>
										<th>작성자</th>
										<th>작성일</th>
										<th>수정일</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="board" items="${list}">
										<tr onclick='location.href="/board/showBoard?bon=${board.bon}&pageNum=${pageMaker.cri.pageNum}&amount=${pageMaker.cri.amount}"'>
											<td>${board.bon}</td>
											<td><c:out value="${board.title}" /></td>
											<td><c:out value="${board.writer}" /></td>
											<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regdate}" /></td>
											<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.updateDate}" /></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<form id="schForm" action="/board/list" method="get">
								<select id="type" name="type" class="form-control col-6">
									<option value="" <c:if test="${pageMaker.cri.type eq null}">selected</c:if>>--</option>
									<option value="T" <c:if test="${pageMaker.cri.type eq 'Y'}">selected</c:if>>제목</option>
									<option value="C" <c:if test="${pageMaker.cri.type eq 'C'}">selected</c:if>>내용</option>
									<option value="W" <c:if test="${pageMaker.cri.type eq 'W'}">selected</c:if>>작성자</option>
									<option value="TC" <c:if test="${pageMaker.cri.type eq 'TC'}">selected</c:if>>제목 or 내용</option>
									<option value="TW" <c:if test="${pageMaker.cri.type eq 'TW'}">selected</c:if>>제목 or 작성자</option>
									<option value="TWC" <c:if test="${pageMaker.cri.type eq 'TWC'}">selected</c:if>>All</option>
								</select>
								<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
								<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
								<input id="keyword" name="keyword" value="${pageMaker.cri.keyword}" class="form-control col-6">
								<button class="btn btn-default" onclick="$('#schForm').submit();">Search</button>
							</form>
							<button class="btn btn-info" onclick="location.href='/board/boardWrite'">Write</button>
							<div class="pull-right">
								<ul class="pagination">
									<c:if test="${pageMaker.prev}">
										<li class="paginate_button previous"><a href="${pageMaker.startPage - 1}">Previous</a></li>
									</c:if>
									<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage }">
										<li class="paginate_button ${pageMaker.cri.pageNum == num ? "active" : "" } "><a href="${num}">${num}</a></li>
									</c:forEach>
									<c:if test="${pageMaker.next}">
										<li class="paginate_button next"><a href="${pageMaker.endPage + 1}">Next</a></li>
									</c:if>
								</ul>
							</div>
							<form id="actionForm">
								<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
								<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4>Modal title</h4>
				</div>
				<div class="modal-body">처리가 완료되었습니다.</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal">Save changes</button>
				</div>
			</div>
		</div>		
	</div>
	
	<script type="text/javascript">
		$(document).ready(function() {
			var result = '<c:out value="${result}"/>';
	        
	        checkModal(result);
	        
	        history.replaceState({}, null, null);
	        
	        function checkModal(result) {
	        	if (result === '' || history.state) return;
	        	if (ParseInt(result) > 0) {
	        		$(".modal-body").html("게시글 " + parseInt(result) + "번이 등록되었습니다.");
	        	}
            	$("#myModal").modal("show");
	        }
	        
	        var actionForm = $("#actionForm");
	        
	        $(".paginate_button a").on("click", function(e) {
	        	e.preventDefault();
	        	
	        	actionForm.find("input[name='pageNum']").val($(this).attr("href"));
	        	actionForm.submit();
	        });
	        
	        /* var schForm = $("#schForm");
	        
	        $("#schForm button").on("click", function(e) {
	        	schForm.find("input[name='pageNum']").val("1");
	        	e.preventDefault();
	        	
	        	schForm.submit();
	        }); */
	        
		});
	</script>

	<%@ include file="../includes/footer.jsp"%>

</body>

</html>
