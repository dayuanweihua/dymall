package com.dayuan.bean;

public class CartInfo {
	private Long id;

	private Long cartId;
	private Long goodsId;
	private String goodsName;
	private String pictureUrl;
	private Integer buyNumber;
	private Integer goodsOriginalPrice;
	private Integer goodsPromotionPrice;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCartId() {
		return cartId;
	}
	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}
	public Long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getPictureUrl() {
		return pictureUrl;
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	public Integer getBuyNumber() {
		return buyNumber;
	}
	public void setBuyNumber(Integer buyNumber) {
		this.buyNumber = buyNumber;
	}
	public Integer getGoodsOriginalPrice() {
		return goodsOriginalPrice;
	}
	public void setGoodsOriginalPrice(Integer goodsOriginalPrice) {
		this.goodsOriginalPrice = goodsOriginalPrice;
	}
	public Integer getGoodsPromotionPrice() {
		return goodsPromotionPrice;
	}
	public void setGoodsPromotionPrice(Integer goodsPromotionPrice) {
		this.goodsPromotionPrice = goodsPromotionPrice;
	}
	


}
