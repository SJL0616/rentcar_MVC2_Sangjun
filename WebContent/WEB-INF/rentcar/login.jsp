<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../../header.jsp"%>
<link rel="stylesheet" type="text/css" href="${ctx}/css/loginStyle.css" />

<div class="content">
	<div class="loginContent">
		<div class="img">
			<img alt="" src="./img/login.png">
		</div>
		<div class="loginForm">

			<form action="#" method="post">
			<div>
			<h1>로그인 </h1>
			</div>
			
				<table class="table table-borderless">
					<tr>
						<td>아이디</td>
						<td><input class="col-12 form-control" type="text" name="id" /></td>
					</tr>
					<tr>
						<td>패스워드</td>
						<td><input class="col-12  form-control" type="password" name="pw" /></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="button"
							value="로그인" onclick="login(form)" class="col-12 btn btn-success" /></td>
					</tr>
				</table>
			</form>
		</div>

	</div>

</div>
</body>
</html>
<%@ include file="../../footer.jsp"%>
<script type="text/javascript" charset="utf-8">

<%@include file="/WEB-INF/js/login.js" %>
<%@include file="/WEB-INF/js/check.js" %>
</script>