$(document).ready(function() {

	$.ajax({
		type : "POST",
		url : "http://localhost:8080/dymall/cart/checkCartInfos.shtml",
		data : "",
		dataType : "json",
		success : function(data) {
			if (data.code == 1) {

				if (data.data == null) {
				} else {
					/*alert(1);*/
					var cartTable2 = new Vue({
						el : '#cartTable2',
						data : {
							todos: data.data.cartInfoVos
						}
					})
				}
			} else {
			}
		}
	});

});