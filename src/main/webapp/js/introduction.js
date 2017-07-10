$.ajax({
	type:"POST",
	url:"http://localhost:8080/dymall/goods/getGoodsById.shtml",
	data:"goodsId="+document.URL.getQuery("goodsId"),
	dataType:"json",
	success:function(data){
		
		if(data.code==1){
			if(data.data==null){
				
			}else{
				var goods=data.data;
				//alert(document.URL);获取资源路径和参数
				//alert(document.URL.getQuery("goodsId"));
				
				var picUrl="http://localhost:8080/dymall/"+goods.pictureUrl;
				//alert(pUrl);
				//alert(goods.goodsName);
				$(".box .tb-s310 img").attr({"src":picUrl,"rel":picUrl});
				$(".box .tb-s310 a").attr({"href":picUrl});
				$(".tb-detail-hd h1").text(goods.goodsName);
				$(".sys_item_price").text(goods.promotionPrice);
				$(".sys_item_mktprice").text(goods.originalPrice);
			}
		}
	}
})