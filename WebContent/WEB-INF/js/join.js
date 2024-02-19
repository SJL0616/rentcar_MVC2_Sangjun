/**
 * 
 */
$(document).ready(function() {

});

function join(form) {
	if(!idCheck(document.getElementById('checkId').value) || document.getElementById('checkId').value != form.id.value){
		alert("아이디를 중복검사하세요.");
		return;
	}
	
	console.log("등록");
	if(joinCheck(form)){
		form.submit();
	}
}

function idValCheck(form){
	document.getElementById('checkId').value = '';
	if(!idCheck(form.id.value)){
		alert("아이디를 확인하세요.");
		return;
	}
	let id ={
		id : form.id.value
	}
	$.ajax({
		type: 'post',
		url: 'checkId.do',
		data: id,
		async: false,
		success: function(data) {
			console.log(data);
			//console.log(JSON.parse(data));
			if(data == "true"){
				alert("아이디가 유효합니다.");
				document.getElementById('checkId').value = form.id.value;
			}else{
				alert("아이디가 유효하지 않습니다.");
			}
			
		}
	});
	
}