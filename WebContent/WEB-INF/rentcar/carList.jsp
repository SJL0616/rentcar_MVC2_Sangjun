<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../../header.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${ctx}/css/carListStyle.css" />


<div class="content">
	<div class="cateBtns">
		<input type="text" id="startDate" value="${startDate}" hidden="true">
		<input type="text" id="endDate" value="${endDate}" hidden="true">
		<input type="text" id="useDay" value="${useDay}" hidden="true">
		<div class="oneCate btn btn-light">
			전체
			<div class="container"></div>

		</div>
		<div class="oneCate btn btn-light">
			소형차
			<div class="container">
				<img src="${ctx}/img/category/scar.png">
			</div>
		</div>
		<div class="oneCate btn btn-light">
			중형차
			<div class="container">
				<img src="${ctx}/img/category/car.png">
			</div>
		</div>
		<div class="oneCate btn btn-light">
			대형차
			<div class="container">
				<img src="${ctx}/img/category/van.png">
			</div>
		</div>
	</div>
	<div class="listContent">
		<c:forEach var="vo" items="${list}">
			<div class="oneCar">
				<div class="imgBox">
					<c:if test="${vo.getImg() !=null}">

						<img src="Uploads/${vo.getImg() }" id="photo" />
						<%-- //<img src="./img/car/${vo.getImg()}"> --%>
					</c:if>
					<c:if test="${vo.getImg() == null}">
						
						<img
							src="https://upload.wikimedia.org/wikipedia/commons/1/14/No_Image_Available.jpg"
							id="photo" class="defalut"> 
					</c:if>

				</div>
				<div class="infoBox">
					<div class="carName">
						<h3>${vo.getName()}</h3>
					</div>
					<div class="infoText">
						<table>
							<tr>
								<td>${vo.getCategory()}</td>
								<td>${vo.getUsepeople() }명승차</td>
							</tr>
						</table>

					</div>
				</div>
				<div class="priceBox">
				    <c:set var="price" value="${vo.getTotalPrice(useDay)}"></c:set>
					<div>
						<span>${useDay}일 요금</span>
					</div>
					<div>
						<h3>₩${price}</h3>
					</div>
					<div>
						<input type="button" value="예약하기"
							onclick="showInfo(${vo.getNo()})" class="col-12 btn btn-success" />
					</div>

				</div>
			</div>
		</c:forEach>
	</div>
</div>
<%@ include file="../../footer.jsp"%>
</body>
</html>
<script type="text/javascript" charset="utf-8">
	
<%@include file="/WEB-INF/js/carList.js" %>
	
</script>
