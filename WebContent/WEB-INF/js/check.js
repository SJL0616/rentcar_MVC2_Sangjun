/**
 * 
 */

function check(form) {
	console.log("check ");
	/*if (!idCheck(form.id.value)) {
		alert("아이디는 최소 4글자로 설정 가능합니다.");
		return false;
	}*/
	if(!imgCheck(form.uploadFile.files)){
		alert("이미지 파일 입력 오류.");
		return;
	}
	
	/*
	if(!form.vaild.checked){
		alert("아이디를 중복검사하세요.");
		return;
	}
	
	if (!pwCheck(form.pass.value)) {
		alert("패스워드는 최소 4글자 숫자로만 설정 가능합니다.");
		return;
	}
	if (!nameCheck(form.name.value)) {
		alert("이름을 다시 입력하세요.");
		return;
	}
	if(!ageCheck(form.age.value)){
		alert("나이를 다시 입력하세요.");
		return;
	}
	if(!emailCheck(form.email.value)){
		alert("이메일을 다시 입력하세요.");
		return;
	}
	if (!phoneCheck(form.phone.value)) {
		alert("전화번호를 다시 입력하세요.");
		return;
	}*/
	return true;
}

function joinCheck(form){
	if (!idCheck(form.id.value)) {
		alert("아이디는 최소 4글자로 설정 가능합니다.");
		return false;
	}
	if (!pwCheck(form.pw.value)) {
		alert("패스워드는 최소 4글자 숫자로만 설정 가능합니다.");
		return false;
	}
	if(!emailCheck(form.email.value)){
		alert("이메일을 다시 입력하세요.");
		return false;
	}
	if (!phoneCheck(form.tel.value)) {
		alert("전화번호를 다시 입력하세요.");
		return false;
	}
	let job = form.job.value;
	if (job === null || job === undefined || job === '') {
		alert("직업를 다시 입력하세요.");
		return false;
	}
	return true;
}

function imgCheck(files){
	let img = files[0];
	console.log(img);
	console.log(img.size);
	let name = img.name;
	let reg = new RegExp("^(.*?)\.(jpg|jpeg|png|bmp)$");
	if(!name.match(reg)){
		return false;
	}
	let maxSize = 5 * 1024 * 1024;
	if(img.size == 0 || img.size > maxSize){
		return false;
	}
	
	return true;
}


function phoneCheck(input) {
	console.log(input);
	if (input === null || input === undefined || input === '') {
		console.log('phone is null or undefined or a empty string');
		return false;
	}
	let regex = new RegExp("^[0-9]{3,3}-[0-9]{4,4}-[0-9]{4,4}$");
	if (!input.match(regex)) {
		console.log('phone is invailed');
		return false;
	}
	return true;
}

function emailCheck(input) {
	console.log(input);
	if (input === null || input === undefined || input === '') {
		console.log('email is null ora-z undefined or a empty string');
		return false;
	}
	let regex = new RegExp("^[A-Za-z0-9]+@[a-z]+\.[a-z]{2,3}$");
	if (!input.trim().match(regex)) {
		console.log('email is invailed');
		return false;
	}
	return true;
}

function ageCheck(input) {
	if (input === null || input === undefined || input === '') {
		console.log('age is null or undefined or a empty string');
		return false;
	}
	let regex = new RegExp("^[0-9]{1,3}$");
	if (!input.match(regex)) {
		console.log('age is invailed');
		return false;
	}
	return true;
}


function nameCheck(input) {
	if (input === null || input === undefined || input === '') {
		console.log('name is null or undefined or a empty string');
		return false;
	}
	return true;
}

function pwCheck(input) {
	if (input === null || input === undefined || input === '') {
		console.log('pw is null or undefined or a empty string');
		return false;
	}
	//최소 4글자 숫자로만 이루어질것
	let regex = new RegExp("^[0-9]{4,}$");
	if (!input.match(regex)) {
		console.log('id is invailed');

		return false;
	}
	return true;
}

function idCheck(input) {
	console.log('id check');
	if (input === null || input === undefined || input === '') {
		console.log('id is null or undefined or a empty string');
		return false;
	}
	// 정규표현식 - 영어, 숫자, 최소 4글자
	let regex = new RegExp("^[ㄱ-ㅎㅏ-ㅣ가-힣a-zA-Z0-9]{3,}$");
	console.log(input.match(regex));
	if (!input.match(regex)) {
		console.log('id is invailed');

		return false;
	}

	console.log('id is good');
	return true;
}
function carNameCheck(input) {
	console.log('id check');
	if (input === null || input === undefined || input === '') {
		console.log('id is null or undefined or a empty string');
		return false;
	}
	// 정규표현식 - 영어, 숫자, 최소 4글자
	let regex = new RegExp("^[ㄱ-ㅎㅏ-ㅣ가-힣a-zA-Z0-9]{2,}$");
	console.log(input.match(regex));
	if (!input.match(regex)) {
		console.log('id is invailed');

		return false;
	}

	console.log('id is good');
	return true;
}

