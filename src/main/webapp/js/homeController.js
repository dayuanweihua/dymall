$(document).ready(function(){
	
	
	/***********************渲染类目*****************************/
	
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
	
	
	alert($('#addressId').text());
	//渲染类目
	$.ajax({
		type : "POST",
		url : $.mallHost+"/goods/getGoodsTypes.shtml",
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
	
	/**********************************************/
	//渲染商品列表
	$.ajax({
		type : "POST",
		url : $.mallHost+"/goods/getGoodsList.shtml",
		data : "",
		dataType: "json",
		success : function(data) {
				if(data.code==1){
					if(data.data==null){						
					} else {						
						$.each(data.data, function (index, obj) {
							$("#good"+(index+1)+" .title").html(obj.goodsName);
							$("#good"+(index+1)+" .sub-title").html(obj.promotionPrice/100);
							$("#good"+(index+1)+" img").attr("src","http://localhost:8080/dymall/"+obj.pictureUrl);
							$("#good"+(index+1)+" a").attr("href","http://localhost:8080/dymall/home/introduction.html?goodId="+obj.id);
						});						
					}				
				} 
			}
		}
	);
	
});