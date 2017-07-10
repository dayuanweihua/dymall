
//商品列表接口
	 
//	  $(document).ready(function() {
//		$('#qc last').on('click',getGoodsList);
//	});
//	
//	function getGoodsList(){
//		$.ajax({
//			type:"POST",
//			url:"http://localhost:8080/dymall/goodsType/getGoodsList.shtml",
//			data:"goodsName=小",
//			dataType:"json",
//			success:function(obj){
//				alert("getGoodsList");
//			}			
//		});
//	}	
//	
			/***********************渲染商品展示*****************************/
//	  $(document).ready(function() {
//		  showGoodsList()
//		});
//	  
//	  function showGoodsList(){
//			$.ajax({
//				type:"POST",
//				url:"http://localhost:8080/dymall/goods/getGoodsTypes.shtml",
//				data:"",
//				dataType:"json",
//				success:function(obj){
//					
//				}			
//			});
//		}	
	    
	// alert($('#p1').text());
//var clazz=$('.text-two sug, .text-two, .text-three big, .text-three sug, .text-three, .text-three last big');
//	var clazz=$('#p1,#p2,#p3,#p4,#p5,#p6');
//	  $.each(clazz, function(index,obj){
//		//alert(index);
//		$("#p"+(index+1)+" .title").html("xxx");
//		$("#p"+(index+1)+" .sub-title ").html("¥"+1+index);
//		$("#p"+(index+1)+" img").attr("src"," ../images/"+(index+1)+".jpg");
//		//obj[i+1]('.title').html("111"+index);
//
//	//	$("img").attr("src"," ../images/"+3+".jpg");
//		/*$('img').attr("src"," ../images/3.jpg");*/
//  });

	/***********************渲染类目*****************************/
	$(document).ready(function() {
	var conent =
		"<div class=\"category-info\">"+
		"<h3 class=\"category-name b-category-name\"><i><img src=\"../images/cake.png\"></i><a class=\"ml-22\" title=\"点心\">点心/蛋糕</a></h3>"+
		"<em>&gt;</em></div>"+
		"<div class=\"menu-item menu-in top\">"+
			"<div class=\"area-in\">"+
				"<div class=\"area-bg\">"+
					"<div class=\"menu-srot\">"+
						"<div class=\"sort-side\">"+
						"</div>"+
					"</div>"+
				"</div>"+
			"</div>"+
		"</div>"+
		"<b class=\"arrow\"></b>";
	
	var typeFirst = "<li class=\"appliance js_toggle relative first\">"+conent+"</li>";
	
	var typeLast = "<li class=\"appliance js_toggle relative last\">"+conent+"</li>";
	
	
	//渲染类目
	$.ajax({
		type : "POST",
		url : "http://localhost:8081/dymall/goodsType/getGoodsTypes.shtml",
		data : "",
		async : false,
		dataType: "json",
		success : function(obj) {
				if(obj.code==1){
					
					$(".category-content .category-list").html("");
					
					/* for ( var index in obj.data) {
						alert(obj.data[index].name);
					} */
					
					var types = obj.data;
					//一级类目
					for (var i = 0; i < types.length; i++) {
						//alert(types[i].name);
						$(".category-content .category-list").append(typeFirst);
						if(i==0){
							
						}else if (i==types.length-1) {
							$(".category-content .category-list li:last").removeClass("first").addClass("last");
						}else {
							$(".category-content .category-list:last").removeClass("first");
						}
						
						$(".category-content .category-list .ml-22:last").html(types[i].name).attr("title",types[i].name);
//								$(".category-content .category-list .ml-22:last").attr("title",types[i].name);
						
						//二级类目
						var types2 = types[i].subList;
						for (var j = 0; j < types2.length; j++) {
							//alert(types2[j].name);
							$(".category-content .category-list .sort-side:last").append("<dl class=\"dl-sort\">"+
									"<dt><span title=\""+types2[j].name+"\">"+types2[j].name+"</span></dt>"+
								"</dl>");
							
							//三级类目
							var types3 = types2[j].subList;
							for (var k = 0; k < types3.length; k++) {
								//alert(types[i].name+"---"+types2[j].name+"---"+types3[k].name);
								$(".category-content .category-list .dl-sort:last").append("<dd><a title=\""+types3[k].name+"\" href=\"#\"><span>"+types3[k].name+"</span></a></dd>");
							}
						}
					}
					
				} else {
					alert(data.msg);
				}
			}
		}
	);
	
	$.ajax({
		type : "POST",
		url : "http://localhost:8081/dymall/goods/getGoods.shtml",
		data : "",
		dataType: "json",
		success : function(data) {
				if(data.code==1){
					if(data.data==null){
						
					} else {
						
						$.each(data.data, function (index, obj) {
							$("#good"+(index+1)+" .title").html(obj.goodName);
							$("#good"+(index+1)+" .sub-title").html(obj.discountPrice/100);
							$("#good"+(index+1)+" img").attr("src","http://localhost:8081/dymall/"+obj.picUrl);
							$("#good"+(index+1)+" a").attr("href","http://localhost:8081/dymall/home/introduction.html?goodId="+obj.id);
						});
						
					}
					
				} else {
					alert(data.msg);
				}
			}
		}
	);
	
	});


/********************通过商品图片进入商品详情页面**************************/


	

		$.ajax({
			type : "POST",
			url : "http://localhost:8080/dymall/user/register.shtml",
			data : {
				"phone" : phone,
				"code" : code,
				"password" : password,
				"passwordRepeat" : passwordRepeat
			},
			dataType : "json",
			success : function(data) {
				if (data.code == 1) {
					alert("注册成功即将跳入登录页面。");
					window.location.href = "login.html";
				} else {
					alert(data.msg);
				}
			}
		
	});
	
		


