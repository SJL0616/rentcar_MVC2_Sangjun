/**
 * 
 */
$(document).ready(function() {
	
	let btn = document.getElementById('reserveBtn');
	btn.addEventListener("click", goToReserve);
});

function goToReserve() {
	console.log("gotoReserve");
	let price = document.getElementById('totalPrice').value;
	let originPrice = document.getElementById('price').value;
	let startDate = document.getElementById('startDate').value;
	let endDate = document.getElementById('endDate').value;
	let useDay = document.getElementById('useDay').value;
	let no = document.getElementById('no').value;
	let ableCnt = '${ableCnt}';
	
	
	if(ableCnt == 0 ){
		if(confirm("현재 모두 예약중입니다.")){
			location.href ="${ctx}/";
			
		}else{
			location.href ="${ctx}/";
		}
		return;
	}
	let box = document.querySelector('.infoText');
	var html = "";
	html += '<form id="reserveForm" action="${ctx}/reserve.do" method="post">'
	html += '<table><tr><td>'
	html += '<div class="carName"><h3>${vo.getName()}</h3></div>'
	html += '</td></tr>'
	html += '<tr><td>대여 기간 :</td><td>' + startDate + ' ~ ' + endDate + '</td></tr><tr>'
	html += '<td>대여일 :</td>'
	html += '<td>' + useDay + '</td>'
	html += '</tr>'
	html += '<tr>'
	html += '<td>보험적용 :</td>'
	html += '<td><input type="checkbox" name="usein" value="use"> </td>'
	html += '</tr>'
	html += '<tr>'
	html += '<td>Wifi 적용 :</td>'
	html += '<td><input type="checkbox" name="usewifi" value="use"> </td>'
	html += '</tr>'
	html += '<tr>'
	html += '<td>네비게이션 적용 :</td>'
	html += '<td><input type="checkbox" name="usenavi" value="use"></td>'
	html += '</tr>'
	html += '<tr>'
	html += '<td>베이비시트 적용 :</td>'
	html += '<td><input type="checkbox" name="useseat" value="use"></td>'
	html += '</tr>'
	html += '<tr><td>렌트 차량 수</td><td>'
	html += '<select class="selectQty" name="qty">';
	for (let i = 1; i <= ableCnt; i++) {
		html += '<option value="' + i + '" >' + i + '</option>';
	}
	html += '</select>'
	html += '</td></tr>';
	html += '</table>'
	html += '<input type="text" class="pay" name="pay" value="'+ (originPrice*useDay) + '" hidden="true">'
	html += '<input type="text" name="startDate" value="' + startDate + '" hidden="true" >'
	html += '<input type="text" name="endDate" value="' + endDate + '" hidden="true">';
	html += '<input type="text" name="dday" value="' + useDay + '" hidden="true">';
	html += '<input type="text" name="no" value="' + no + '" hidden="true">';
	html += '</form>';
	box.innerHTML = html;

	let btn = document.getElementById('reserveBtn');
	btn.removeEventListener("click", goToReserve);
	btn.value = "예약 결정";
	btn.addEventListener("click", reserve);
	let select =  document.querySelector('.selectQty');
	console.log(select);
	select.addEventListener('change',function(event){
			let num = (event.target.value*(originPrice*useDay));
			document.querySelector('.pay').value = num;
			document.getElementById('showPrice').textContent ='₩'+num.toLocaleString();
	});

}

function reserve() {
	console.log("get reserve");
	console.log(document.forms[0]);
	let form = document.forms[0];
	form.submit();
}

function change(event){
	console.log(event.target);
}

