/**
 * 
 */

$(document).ready(function() {
	//데이트피커 초기화
	categorySet();

	console.log(document.getElementById('startDate').value);
	console.log(document.getElementById('endDate').value);
});

function categorySet() {
	let btns = [];
	btns = Array.from(document.querySelectorAll(".oneCate"));
	let num = 0;
	btns.forEach(btn => {
		let n = num;
		btn.addEventListener('click', function(e) {
			sortByCategory(n);
		});
		num++;
	});
}

function sortByCategory(category) {
	let useDay = document.getElementById('useDay').value;
	const q = {
		startDate: document.getElementById('startDate').value,
		endDate: document.getElementById('endDate').value,
		useDay: useDay,
		category: category
	};

	$.ajax({
		type: 'post',
		url: 'search.do',
		data: q,
		async: false,
		success: function(data) {
			//console.log(data);
			//console.log(JSON.parse(data));
			let list = JSON.parse(data);
			const parent = document.querySelector('.listContent');
			var str = "";
			for (var i = 0; i < list.length; i++) {
				str += '<div class="oneCar">'
				str += '<div class="imgBox">'
				str += '<img src="Uploads/' + list[i].img + '">'
				str += '</div>'
				str += '<div class="infoBox">'
				str += '<div class="carName">'
				str += '<h3>' + list[i].name + '</h3>'
				str += '</div>'
				str += '<div class="infoText">'
				str += '<table>'
				str += '<tr>'
				str += '<td>' + list[i].category + '</td>'
				str += '<td>' + list[i].usepeople + '명승차</td>'
				str += '</tr>'
				str += '</table>'
				str += '</div>'
				str += '</div>'
				str += '<div class="priceBox">'
				str += '<div>'
				str += '<span>'+useDay+'일 요금</span>'
				str += '</div>'
				str += '<div>'
				str += '<h3>₩' + list[i].price + '</h3>'
				str += '</div>'
				str += '<div>'
				str += '<input type="button" value="예약하기"'
				str += 'onclick="showInfo(' + list[i].no + ')" class="col-12 btn btn-success" />'
				str += '</div></div></div>';
			}
			parent.innerHTML = str;
		}
	});
}


function showInfo(no) {
let id = '${sessionScope.log}';
	console.log(id);
	if((id == undefined || id == ""|| id ==null)){
		confirm("로그인이 필요한 서비스입니다.");
		location.href = '${ctx}/login.do';
		return;
	}
	let form = document.createElement("form");

	form.setAttribute("charset", "UTF-8");
	form.setAttribute("method", "Post");  //Post 방식
	form.setAttribute("action", "${ctx}/showInfo.do"); //요청 보낼 주소

	//form.appendChild(document.getElementById('startDate'));
	//form.appendChild(document.getElementById('endDate'));
	
	hiddenField = document.createElement("input");
	hiddenField.setAttribute("type", "hidden");
	hiddenField.setAttribute("name", "startDate");
	hiddenField.setAttribute("value", document.getElementById('startDate').value);
	form.appendChild(hiddenField);
	
	hiddenField = document.createElement("input");
	hiddenField.setAttribute("type", "hidden");
	hiddenField.setAttribute("name", "endDate");
	hiddenField.setAttribute("value", document.getElementById('endDate').value);
	form.appendChild(hiddenField);
	
	hiddenField = document.createElement("input");
	hiddenField.setAttribute("type", "hidden");
	hiddenField.setAttribute("name", "num");
	hiddenField.setAttribute("value", no);
    form.appendChild(hiddenField);

    hiddenField = document.createElement("input");
	hiddenField.setAttribute("type", "hidden");
	hiddenField.setAttribute("name", "useDay");
	hiddenField.setAttribute("value",  document.getElementById('useDay').value);
	form.appendChild(hiddenField);
	
	document.body.appendChild(form);

	form.submit();

}

