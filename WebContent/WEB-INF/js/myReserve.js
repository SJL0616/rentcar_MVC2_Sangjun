/**
 * 
 */
$(document).ready(function() {

});

function cancel(no) {
	console.log("get cancel");
	console.log(no);
	let log = "${sessionScope.log}";
	const q = {
		resv_seq: no
	};

	$.ajax({
		type: 'post',
		url: 'cancel.do',
		data: q,
		async: false,
		success: function(data) {
			console.log(data);
			if (data) {
				alert("삭제 성공");
			} else {
				alert("삭제 실패");
			}
			location.href = '${ctx}/myReserve.do?id='+log;
		}

		});
}

