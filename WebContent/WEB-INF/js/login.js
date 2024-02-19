/**
 * 
 */

function login(form){
	console.log("login");
	if(!idCheck(form.id.value)){
		alert("아이디를 다시 입력하세요.");
		return;
	}
	if(!pwCheck(form.pw.value)){
		alert("비밀번호를 다시 입력하세요.");
		return;
	}
	send(form);
}

function send(form){
	const m = {
		id: form.id.value,
		pw: form.pw.value
		};
	
	$.ajax({
	type: 'post',
	url: 'login.do',
	data: m,
	success: function(result) {
			console.log(result);
			if (result == 1) {
				alert("로그인 성공");
				location.href = "${ctx}/index.jsp";
			}else {
				alert("로그인 실패");
			}
		} 
	});
}