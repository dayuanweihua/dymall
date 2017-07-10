$(document).ready(function(){
			$.each(province, function (index, obj) { 
				var option = "<option value='" + obj.ProID + "'>" + obj.name + "</option>";
				$("#province").append(option);
			});		
			$("#province").change(function () {
				var selValue = $(this).val(); 
				$("#city option:gt(0)").remove();
				$.each(city, function (index, obj) { 
					if (obj.ProID == selValue) {
						var option = "<option value='" + obj.CityID + "'>" + obj.name + "</option>";
						$("#city").append(option);
					}
				});
			});				
			$.each(area, function (index, obj) { 
				var option = "<option value='" + obj.Id + "'>" + obj.DisName + "</option>";
				$("#area").append(option);
			});
		});	

$.ajax({
	type : "POST",
	url : $.mallHost+"/addressManager/checkShippingAddress.shtml",
	data : "",
	dataType: "json",
	success : function(data) {
			if(data.code==1){
				if(data.data==null){
					//alert("用户未登录");
				} else {						
					var addressManager = new Vue({
						el : '#addressManager',
						data : {
							todos: data.data
						}
					})					
				}				
			} 
		}
	});

//删除选择的地址
//id="delClick" onclick="delClick(this);"
//alert($('#delClick').attr("title"));
//alert($('.new-addr-btn').attr("title"));
$(document).ready(function() {
	$('#delClick').on('click', delClick);
});

function delClick(){
	
	var id=$('#addressId').text();
	$.ajax({
		type : "POST",
		url : "http://localhost:8080/dymall/addressManager/deleteShippingAddress.shtml",
		data : {
			"id":id
		},
		dataType : "json",
		success : function(data) {
			
			if(data.code!=1){
				alert("后台："+data.msg);
				return;
			}
		}
	});
}


$(document).ready(function() {
	$('#userAddAddress').on('click', addAddress);
});
function addAddress(){	
	var id=$('#receiver').val();
	var id=$('#receiverPhone').text();
	var id=$('#province').text();
	var id=$('#city').text();
	var id=$('#area').text();
	var id=$('#addressId').text();
	
	$.ajax({
		type : "POST",
		url : "http://localhost:8080/dymall/addressManager/deleteShippingAddress.shtml",
		data : {
			"id":id
		},
		dataType : "json",
		success : function(data) {
			
			if(data.code!=1){
				alert("后台："+data.msg);
				return;
			}
		}
	});
}
