<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
<link rel="stylesheet"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.13/themes/base/jquery-ui.css"
	type="text/css" media="all" />
<c:set var="ctx" value="<%=request.getContextPath()%>"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="${ctx}/css/style.css" />
</head>
<body>
	<c:set var="log" value="${sessionScope.log}" />
	<script>
		console.log("${log}");
	</script>
	<header>
		<div class="content">
			<div class="row">
				<div class="image">
					<a href="${ctx}"> <img alt="" src="./img/logo (2).png"></a>
				</div>
				<c:if test="${log ne null and log  ne 'admin'}">
					<div class="w-25 py-3">
						<div class="btn btn-light">
							<a href="${ctx}/myReserve.do?id=${log}">내 예약</a>
						</div>
						<div class="btn btn-light">
							<a href="#" onclick="resign()">회원탈퇴</a>
						</div>
						<div class="btn btn-light">
							<a href="${ctx}/logout.do">로그아웃</a>
						</div>
					</div>
				</c:if>
				<c:if test="${log  eq 'admin'}">
					<div class="w-25 py-3">
						<div class="btn btn-light">
							<a href="${ctx}/register.do?form=true">등록</a>
						</div>
						<div class="btn btn-light">
							<a href="${ctx}/logout.do">로그아웃</a>
						</div>
					</div>
				</c:if>
				<c:if test="${empty log  }">
					<div class="w-25 py-3">
						<div class="btn btn-light">
							<a href="${ctx}/join.do">회원가입</a>
						</div>
						
						<div class=" btn btn-light">
							<a href="${ctx}/login.do">로그인</a>
						</div>

					</div>
				</c:if>
			</div>
		</div>
	</header>
	<script type="text/javascript" charset="utf-8">
		
	<%@include file="/WEB-INF/js/header.js" %>
		
	</script>