	function loginCheck() {
		if(document.loginForm.iid.value=="") {
			alert("아이디를 입력해주세요.");
			loginForm.iid.focus();
			return false;
		}
		if(document.loginForm.ipwd.value=="") {
			alert("비밀번호를 입력해주세요.");
			loginForm.ipwd.focus();
			return false;
		}
		return true;
	}

	function joinCheck() {
		if(document.joinForm.iid.value=="") {
			alert("아이디를 입력해주세요.");
			joinForm.iid.focus();
			return false;
		}
		if(document.joinForm.ipwd.value=="") {
			alert("비밀번호를 입력해주세요.");
			joinForm.ipwd.focus();
			return false;
		}
		if(document.joinForm.iname.value=="") {
			alert("이름을 입력해주세요.");
			joinForm.iname.focus();
			return false;
		}
		return true;
	}
	
	function idCheck(){
		if(document.joinForm.iid.value=="") {
			alert("아이디를 입력해주세요.");
			joinForm.iid.focus();
			return false;
		}
		var url = "id_check?id=" + document.joinForm.iid.value;
		window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");
	}
	
	function writeCheck(keyword) {
		var s = null;
		
		switch(keyword){
			case 'write' :
				s = "작성하시겠습니까?";
				break;
			case 'modify' :
				s = "수정하시겠습니까?";
		}
		
		if(confirm(s)){
			if(document.writeForm.icontent.value.length<1) {
				alert("내용을 입력해주세요.");
				writeForm.icontent.focus();
				return false;
			}
			if(document.writeForm.ipwd.value.length<1) {
				alert("비밀번호를 입력해주세요.");
				writeForm.ipwd.focus();
				return false;
			}
			return true;
		} else {
			return false;
		}
	}