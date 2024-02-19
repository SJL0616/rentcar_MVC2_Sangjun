<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../../header.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${ctx}/css/carListStyle.css" />


<div class="content">
	<div class="listContent">
		<div class="oneCar">
			<div class="imgBox">
				<img src="Uploads/${vo.getImg() }" id="photo" />
			</div>
			<div class="infoBox">
				<div class="infoText">
					<table>
						<tr>
							<td>
								<div class="carName">
									<h3>${vo.getName()}</h3>
								</div>
							</td>
						</tr>
						<tr>
							<td>제조 회사 :</td>
							<td>${vo.getCompany()}</td>
						</tr>
						<tr>
							<td>차량 분류 :</td>
							<td>${vo.getCategory()}</td>
						</tr>
						<tr>
							<td>총 승차인원 :</td>
							<td>${vo.getUsepeople() }명승차</td>
						</tr>
						<tr>
							<td>렌트 가능 차량 수:</td>
							<td>${ableCnt}</td>
						</tr>
					</table>
					
					
				</div>
			</div>
			<div class="priceBox">
			<c:set var="price" value="${vo.getTotalPrice(useDay)}"></c:set>
			<input type="text" id="startDate" value="${startDate}" hidden="true" >
            <input type="text" id="endDate" value="${endDate}" hidden="true">
            <input type="text" id="useDay" value="${useDay}" hidden="true">
            <input type="text" id="price" value="${vo.getPriceNum() }" hidden="true">
            <input type="text" id="no" value="${vo.getNo()}" hidden="true">
            <input type="text" id="totalPrice" value="${price}" hidden="true">
				<div>
					<span>${useDay}일 요금</span>
				</div>
				<div>
					<h3 id="showPrice">₩${price}</h3>
				</div>
				<div>
					<input type="button" id="reserveBtn" value="예약하기"
						
						class="col-12 btn btn-success" />
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>
<%@ include file="../../footer.jsp"%>
<script type="text/javascript" charset="utf-8">
	
<%@include file="/WEB-INF/js/carInfo.js" %>
	
</script>
