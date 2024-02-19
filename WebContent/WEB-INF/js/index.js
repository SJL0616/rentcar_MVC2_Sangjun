/**
 * 
 */

$(document).ready(function() {
	//데이트피커 초기화
	dateTypeIns();
}); // document ready function

//datepicker 날짜 입력함수
function dateTypeIns() {
	
	$(".datetype").datepicker(
		{
			dateFormat: "yy-mm-dd",
			changeYear: true,
			changeMonth: true,
			yearRange: 'c-80:c+10',
			dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
			monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월',
				'7월', '8월', '9월', '10월', '11월', '12월']
		});
		$(".datetype").datepicker('setDate','today');
		$("#edate").datepicker('option','minDate','today');
		$("#sdate").datepicker('option','minDate','today');
		
		$("#sdate").datepicker('option','onClose',function(selectedDate){
			$("#edate").datepicker('option','minDate',selectedDate);
		});
		$("#edate").datepicker('option','onClose',function(selectedDate){
			$("#sdate").datepicker('option','maxDate',selectedDate);
		});
}

function search(form){
	console.log(form);
	let startDate = ($(form.startDate).val()+" "+ $(form.startHour).val());
	let endDate = ($(form.endDate).val() +" "+ $(form.endHour).val());
	
	let dateStart = new Date(startDate);
	let dateEnd = new Date(endDate);
	let diff = dateEnd.getTime()- dateStart.getTime();
	let useDay = Math.ceil(Math.abs(diff/(1000 * 60 * 60 *24)));
	console.log("사용 시간 "+ useDay);
	if(diff < 0){
		alert("렌탈 반납 시간이 시작보다 빠릅니다.");
		return;
	}
	if(useDay == 0){
		alert("렌탈 반납 시간과 시작이 같습니다.");
		return;
	}
	document.getElementById('useDay').value = useDay;
	form.submit();
	
}