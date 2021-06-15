
function loginCheck(){
	if(document.frm.userId.value.length == 0){
		alert('아이디를 입력해 주세요!');
		frm.userId.focus();
		return false;
	}
	if(document.frm.userPwd.value == ""){
		alert('비밀번호를 입력해 주세요!');
		frm.userPwd.focus();
		return false;
	}
	return true;
}

function joinCheck(){
	//이름 입력 여부
	if(document.frm.name.value.length == 0){
		alert('이름을 입력해 주세요!');
		frm.userId.focus();
		return false;
	}
	
	//아이디 입력 여부
	if(document.frm.userId.value.length == 0){
		alert('아이디를 입력해 주세요!');
		frm.userId.focus();
		return false;
	}
	
	//암호 입력 여부
	if(document.frm.userPwd.value == ""){
		alert('비밀번호를 입력해 주세요!');
		frm.userPwd.focus();
		return false;
	}
	//입력된 암호 일치 여부
	if(document.frm.userPwd.value != document.frm.pwd_check.value){
		alert('비밀번호가 일치하지 않습니다.!');
		document.frm.userPwd.value ="";
		document.frm.pwd_check.value = "";
		
		frm.userPwd.focus();
		return false;
	}
	
	//아이디 중복 체크 여부(reid=??)
	if(document.frm.reid.value.length == 0){
		alert('중복 체크를 하지 않았습니다.');
		frm.userId.focus();
		return false;
	}
	return true;
}

function idCheck(){
	if(document.frm.userId.value.length == 0){
		alert('아이디를 입력해 주세요.');
		frm.userPwd.focus();
		return false;
	}
	var url = "idCheck.do?userId="+document.frm.userId.value;
	
	window.open(url,"_blank_1","toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");
}

function idok(){
	opener.frm.userId.value = document.frm.userId.value;
	opener.frm.reid.value = document.frm.userId.value;
	
	self.close(); //새로 열린창 종료
}