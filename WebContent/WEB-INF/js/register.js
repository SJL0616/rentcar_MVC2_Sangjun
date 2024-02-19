/**
 * 
 */
function register(form) {
	console.log("등록");
	
	if(!carNameCheck(form.name.value)){
		alert("차 이름을 확인하세요.");
		return;
	}
	if(form.price.value < 1000){
		alert("가격은 최소 1000원입니다.");
		return;
	}
	if(form.usePeople.value < 1){
		alert("승차인원은 최소 1명입니다.");
		return;
	}
	if(form.total_qty.value < 1){
		alert("최소 수량은 1대 입니다.");
		return;
	}
	if(!carNameCheck(form.company.value)){
		alert("제조 회사 이름을 확인하세요.");
		return;
	}
	if(form.img.files.length == 0 || !imgCheck(form.img.files)){
		alert("이미지 파일을 확인하세요.");
		return;
	}
	form.submit();
}

