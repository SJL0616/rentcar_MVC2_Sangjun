﻿/**
 * 
 */

function resign() {
	if(confirm("정말로 탈퇴하시겠습니까?")){
		location.href= "${ctx}/resign.do";
	}
}

