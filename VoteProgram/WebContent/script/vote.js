function submitChk(){
	//주민번호 입력여부
	if(document.frm.V_JUMIN.value.lengh == 0){
		alert('주민번호가 입려고디지 않았습니다!')
		frm.V_JUMIN.focus();
		return false;
	}
		
	//이름 입력 여부
	if(document.frm.V_NAME.value.length == 0){
		alert('성명이 입력되지 않았습니다!')
		frm.V_NAME.focus();
		return false;
	}
	
	//후보번호 입력 여부
	if(document.frm.M_NO.value.length == 0){
		alert('후보번호가 선택되지 않았습니다!')
		frm.M_NO.focus();
		return false;
	}
	
	//암호 입력 여부
	if(document.frm.V_TIME.value == 0){
		alert('투표시간이 입력되지 않았습니다!')
		frm.V_TIME.focus();
		return false;
	}
	
	
	if(document.frm.V_AREA.value == 0){
		alert('투표장소가 입력되지 않았습니다다!')
		frm.V_AREA.focus();
		return false;
	}
	
	if(document.frm.V_CONFIRM.value == 0){
		alert('유관자확인이 선택되지 않았습니다!')
		frm.V_CONFIRM.focus();
		return false;
	}
	
	alert('투표하기 정보가 정상적으로 등록 되었습니다!')
	return true;
}