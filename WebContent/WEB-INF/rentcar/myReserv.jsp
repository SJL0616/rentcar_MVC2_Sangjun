<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../../header.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${ctx}/css/carListStyle.css" />


<div class="content">
	<div class="listContent">
	<c:choose>
	<c:when  test="${list ne null }">
	<c:forEach var="vo" items="${list}">
			<div class="oneCar">
				<div class="imgBox">
					 <img src="./img/car/${vo.getImg()}"> 
				</div>
				<div class="infoBox">
					<div class="carName">
						<h3>${vo.getName()}</h3>
					</div>
					<div class="infoText">
						<table>
							<tr>
							    <td>대여기간</td>
								<td>${vo.getStartDate() } ~ ${vo.getEndDate()} ( ${vo.getDday()}일 )</td>
							</tr>
							<tr>
							    <td>금액</td>
								<td>${vo.getPay()} 원</td>
							</tr>
							<tr>
							    <td>수량</td>
								<td>${vo.getQty()} 대</td>
							</tr>
							<tr>
							    <td>보험</td>
								<td>
								<input type="checkbox" <c:if test="${vo.isUsein()}"> checked </c:if>  onClick="return false;">
								</td>
							</tr>
							<tr>
							    <td>wifi</td>
								<td>
								<input type="checkbox" <c:if test="${vo.isUsewifi()}"> checked </c:if>  onClick="return false;">
								</td>
							</tr>
							<tr>
							    <td>네비게이션</td>
								<td><input type="checkbox" <c:if test="${vo.isUsenavi()}"> checked </c:if>  onClick="return false;"></td>
							</tr>
							<tr>
							    <td>베이비시트</td>
								<td><input type="checkbox" <c:if test="${vo.isUseseat()}"> checked </c:if>   onClick="return false;"></td>
							</tr>
						</table>

					</div>
				</div>
				<div class="priceBox">
					<div>
						<%-- <h3>₩${vo.getPrice() }</h3> --%>
					</div>
					<div>
						<input type="button" value="예약 취소"
							onclick="cancel(${vo.getReserve_seq()})" class="col-12 btn btn-warning" />
					</div>
					
				</div>
			</div>
		</c:forEach>
	</c:when>
	
	<c:otherwise>
	<div class="oneCar">
				<div class="infoBox">
					<div class="carName">
						<h5>예약 차량이 없습니다.</h5>
					</div>
					<div class="infoText">
						<table>
					</div>
				</div>
				<div class="priceBox">
				</div>
			</div>
	</c:otherwise>
</c:choose>
	</div>
</div>
</body>
</html>
<script type="text/javascript" charset="utf-8">
	
<%@include file="/WEB-INF/js/myReserve.js" %>
	
</script>
