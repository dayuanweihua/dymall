package com.dayuan.constant;

public enum ResourcePerm {
	
	getOrdersByParams("根据订单状态码，获取对应的所有订单"),
	getOrderInfo("根据订单号获取对应的订单"),
	submitOrder("提交订单"),
	addUserCart("用户创建购物车"),
	checkCartInfos("用户查询购物车商品"),
	addToCartInfo("用户将商品加入购物车"),
	updateCartInfo("用户更改购物车商品数量"),
	deleteCartInfo("用户删除购物车中该商品"),
	addShippingAddress("增加用户收货地址"),
	deleteShippingAddress("删除用户选择的收货地址"),
	updateShippingAddress("更改用户选择的收货地址"),
	checkShippingAddress("查询用户的收货地址");
	

	
	private String msg;

	private ResourcePerm(String msg) {
		
		this.msg=msg;
	}
	

	public String getMsg(){
		return msg;
	}


}
