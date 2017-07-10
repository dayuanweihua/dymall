$(document).ready(function() {
			$('#sendMobileCode').on('click', sendCode);
		});
		function register(type) {
			if (type == 1) {
				if (!$('#reader-me').prop('checked')) {
					alert("前端：请点击同意商城协议！");
					return;
				}	
				
				var phone = $('#phone').val();
				var code = $('#code').val();
				var password = $('#password').val();
				var passwordRepeat = $('#passwordRepeat').val();	
				if(code==null||code==""||code.length!=6){
					alert("前端：验证码不正确");
					return;
				}else if(password==null||password==""||passwordRepeat==null||passwordRepeat==""){
					alert("前端：密码不能为空");
					return;
				}else if(password!=passwordRepeat){
					alert("前端：两次密码不一致");
					return;
				}else if(phone==null||phone==""||phone.length!=11){
					alert("前端：请输入正确格式的手机号码");
					return;
				}
								
				$.ajax({
					type : "POST",
					url : "http://localhost:8080/dymall/user/registerByPhone.shtml",
					data : {
						"phone" : phone,
						"code" : code,
						"password" : password,
						"passwordRepeat" : passwordRepeat
					},
					dataType : "json",
					success : function(data) {
						if (data.code == 1) {
							alert("前端：注册成功即将跳入登录页面。");
							window.location.href = "login.html";
						} else {
							alert("后台："+data.msg);
						}
					}
				});
			}
		}
			
		
		function sendCode(){	
			var phone=$('#phone').val();	
			if(phone==null||phone==""||phone.length!=11){
				alert("前端：请输入正确格式的手机号码");
				return ; 
			}
			$.ajax({
				type : "POST",
				url : "http://localhost:8080/dymall/user/sendCode.shtml",
				data : {
					"phone" : phone
				},
				dataType : "json",
				success : function(data) {
					
					if(data.code!=1){
						alert("后台："+data.msg);
						return;
					}
					alert("后台："+data.msg);
					$('#sendMobileCode').off('click');
					var time = 60;
					var setTime = setInterval(function() {
						if (time <= 0) {
							$('#sendMobileCode').on('click', sendCode);
							$("#dyMobileButton").text("获取");
							clearInterval(setTime);
							return;
						}
						time--;
						$("#dyMobileButton").text(time);
					}, 1000);
				}
			});
		}