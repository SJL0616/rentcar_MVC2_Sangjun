<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../../header.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${ctx}/css/registerStyle.css" />


<div class="content">
	<div class="listContent">
		<div class="oneCar">
			<div class="imgBox">
				<img src="">
			</div>
			<div class="infoBox">

				<div class="infoText">

					<form action="${ctx}/register.do" method="post"
						enctype="multipart/form-data">
						<table class="table table-bordered">
							<tr>
								<td>차 이름</td>
								<td><input class="col-5" type="text" name="name" id="name"
									autofocus required /> <input type="button" value="중복체크"
									id="checkName" class="btn btn-outline-dark"></td>
							</tr>
							<tr>
								<td>카테고리</td>
								<td><select class="selectCate" name="category"
									required="required">
										<option value="1" selected="selected">소형차</option>
										<option value="2">중형차</option>
										<option value="3">대형차</option>
								</select></td>
							</tr>
							<tr>
								<td>가격</td>
								<td><input class="col-5" type="number" name="price"
									value="1000" id="price" required /></td>
							</tr>
							<tr>
								<td>승차 인원</td>
								<td><input class="col-5" type="number" name="usePeople"
									value="1" id="usePeople" required /></td>
							</tr>
							<tr>
								<td>수량</td>
								<td><input class="col-5" type="number" name="total_qty"
									value="1" id="total_qty" required /></td>
							</tr>
							<tr>
								<td>제조 회사</td>
								<td><input class="col-5" type="text" name="company"
									id="company" required /></td>
							</tr>
							<tr>
								<td>설명</td>
								<td><textarea rows="10" cols="10" name="info" id="info">
								</textarea></td>
							</tr>
							<tr>
								<td>프로필 사진</td>
								<td><input type="file" name="img" accept="image/*"></td>
								<%-- <td><c:if test="${vo.sFileName!=null}">
										<img src="Uploads/${vo.sFileName}" id="photo" />
										
									</c:if> <c:if test="${vo.sFileName==null}">
										<img
											src="https://upload.wikimedia.org/wikipedia/commons/1/14/No_Image_Available.jpg"
											id="photo" class="defalut">
									</c:if>
								</td> --%>
							</tr>
							<tr>
								<td colspan="2" id="btns"><input type="button" value="등록"
									class="col-3 btn btn-primary" onclick="register(form)" /></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
			<div class="priceBox">
				<%-- <div>
					<span>${useDay}일 요금</span>
				</div>
				<div>
					<h3 id="showPrice">₩${price}</h3>
				</div>
				<div>
					<input type="button" id="reserveBtn" value="예약하기"
						class="col-12 btn btn-success" />
				</div> --%>
			</div>
		</div>
	</div>
</div>
</body>
</html>
<%@ include file="../../footer.jsp"%>
<script type="text/javascript" charset="utf-8">
	
<%@include file="/WEB-INF/js/register.js" %>
<%@include file="/WEB-INF/js/check.js" %>	
</script>
