<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>


<%@ include file="../../header.jsp"%>
<link rel="stylesheet" type="text/css" href="${ctx}/css/indexStyle.css" />

<div class="background">
	<div class="content">
		<form action="${ctx}/search.do">
			<div class="mainContent">


				<div class="text">
					<h2>차량 렌트 – 검색, 비교 후 예약</h2>
				</div>
				<div class="searchBar">
					<div class="btn btn-light btn-lg">
						<select name="location" class="form-select form-select-lg mb-1">
							<option value="서울" selected>서울</option>
							<option value="경기도">경기도</option>
							<option value="충청도">충청도</option>
							<option value="강원도">강원도</option>
							<option value="경상도">경상도</option>
							<option value="전라도">전라도</option>
						</select>
					</div>
					<div class="btn btn-light btn-lg" class="datepicker">
						<div class="dateIcon">
							<img alt="" src="./img/date.png">
						</div>
						<div class="dateText">
							<input class="datetype form-control"  id="sdate" type="text" name="startDate" readonly="readonly"/>
						</div>
					</div>
					<div class="btn btn-light btn-lg">
						<select  name="startHour" class="form-select form-select-sm">
							<option value="00:00" selected>00:00</option>
							<option value="01:00" >01:00</option>
							<option value="02:00" >02:00</option>
							<option value="03:00" >03:00</option>
							<option value="04:00" >04:00</option>
							<option value="05:00" >05:00</option>
							<option value="06:00" >06:00</option>
							<option value="07:00" >07:00</option>
							<option value="08:00" >08:00</option>
							<option value="09:00" >09:00</option>
							<option value="10:00" >10:00</option>
							<option value="11:00" >11:00</option>
							<option value="12:00" >12:00</option>
							<option value="13:00" >13:00</option>
							<option value="14:00" >14:00</option>
							<option value="15:00" >15:00</option>
							<option value="16:00" >16:00</option>
							<option value="17:00" >17:00</option>
							<option value="18:00" >18:00</option>
							<option value="19:00" >19:00</option>
							<option value="20:00" >20:00</option>
							<option value="21:00" >21:00</option>
							<option value="22:00" >22:00</option>
							<option value="23:00" >23:00</option>
						</select>
					</div>
					<div class="btn btn-light btn-lg">
						<div class="dateIcon">
							<img alt="" src="./img/date.png">
						</div>
						<div class="dateText">
							<input class="datetype form-control" id="edate"  type="text" name="endDate" readonly="readonly"/>
						</div>
					</div>
					<div class="btn btn-light btn-lg">
						<select name="endHour" class="form-select form-select-sm">
							<option value="00:00" selected>00:00</option>
							<option value="01:00" >01:00</option>
							<option value="02:00" >02:00</option>
							<option value="03:00" >03:00</option>
							<option value="04:00" >04:00</option>
							<option value="05:00" >05:00</option>
							<option value="06:00" >06:00</option>
							<option value="07:00" >07:00</option>
							<option value="08:00" >08:00</option>
							<option value="09:00" >09:00</option>
							<option value="10:00" >10:00</option>
							<option value="11:00" >11:00</option>
							<option value="12:00" >12:00</option>
							<option value="13:00" >13:00</option>
							<option value="14:00" >14:00</option>
							<option value="15:00" >15:00</option>
							<option value="16:00" >16:00</option>
							<option value="17:00" >17:00</option>
							<option value="18:00" >18:00</option>
							<option value="19:00" >19:00</option>
							<option value="20:00" >20:00</option>
							<option value="21:00" >21:00</option>
							<option value="22:00" >22:00</option>
							<option value="23:00" >23:00</option>
						</select>
					</div>
					<div>
						<input type="button" value="검색" onclick="search(form)"
							class="col-12 btn btn-success" />
					</div>

				</div>
			</div>
			<input type="number" id="useDay" name="useDay" hidden="true">
		</form>
	</div>
</div>
<%@ include file="../../footer.jsp"%>
<script type="text/javascript" charset="utf-8">
	
<%@include file="/WEB-INF/js/index.js" %>
	
<%@include file="/WEB-INF/js/check.js" %>
	
</script>

