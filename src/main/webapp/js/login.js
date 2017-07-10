function userLogin(type) {
	if (type == 1) {
		var loginInfo = $('#loginInfo').val();
		var password = $('#password').val();
		if(loginInfo==null||loginInfo==""||password==null||password==""){
			alert("前端：登录账户或密码不能为空");
			return;
		}
		
		$.ajax({
			type : "POST",
			url : "http://localhost:8080/dymall/login/login.shtml",
			data : {
				"loginInfo" : loginInfo,
				"password" : password
			},
			dataType : "json",
			success : function(data) {
				if (data.code == 1) {
					alert("登录成功，进入主页");
					window.location.href = "home.html";
				} else {
					alert(data.msg);
				}
			}
		});
	}
}