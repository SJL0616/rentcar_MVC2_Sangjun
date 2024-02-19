<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../../header.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${ctx}/css/joinStyle.css" />


<div class="content">
	<div class="listContent">
		<div class="oneCar">
			<div class="imgBox">
				<img src="">
			</div>
			<div class="infoBox">

				<div class="infoText">

					<form action="${ctx}/join.do" method="post">
						<table class="table table-bordered">
							<tr>
								<td>아이디</td>
								<td><input class="col-5" type="text" name="id" id="id"
									autofocus required /> <input type="button" value="중복체크"
									onclick="idValCheck(form)" id="checkName"
									class="btn btn-outline-dark"></td>
									<input type="text" id="checkId"/>
							</tr>
							<tr>
								<td>비밀번호</td>
								<td><input class="col-5" type="text" name="pw" id="company"
									required /></td>
							</tr>
							<tr>
								<td>email</td>
								<td><input class="col-5" type="text" name="email"
									id="company" required /></td>
							</tr>
							<tr>
								<td>전화번호</td>
								<td><input class="col-5" type="text" name="tel"
									id="company" required /></td>
							</tr>
							<tr>
								<td>직업</td>
								<td><input class="col-5" type="text" name="job"
									id="company" required /></td>
							</tr>
							<tr>
								<td>취미</td>
								<td><select class="selectCate" name="hobby"
									required="required">
										<option value="스포츠" selected="selected">스포츠</option>
										<option value="게임">게임</option>
										<option value="독서">독서</option>
										<option value="여행">여행</option>
										<option value="그림">그림</option>
										<option value="TV">TV</option>
								</select></td>
							</tr>
							<tr>
								<td>나이</td>
								<td><select class="selectCate" name="age"
									required="required">
										<option value="1" selected="selected">1</option>
										<c:forEach var="i" begin="2" end="100">
											<option value="2">${i}</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr>
								<td>설명</td>
								<td><textarea rows="10" cols="10" name="info" id="info">
								</textarea></td>
							</tr>
							<tr>
								<td colspan="2" id="btns"><input type="button" value="등록"
									class="col-3 btn btn-primary" onclick="join(form)" /></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>
<%@ include file="../../footer.jsp"%>
<script type="text/javascript" charset="utf-8">
	
<%@include file="/WEB-INF/js/join.js" %>
<%@include file="/WEB-INF/js/check.js" %>
	
</script>
