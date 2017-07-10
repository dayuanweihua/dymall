package com.dayuan.bean;

public class GoodsStore {
	private Long id;
	private Long goodsId;
	private Integer goodsStore;
	
	public GoodsStore() {

	}
	public GoodsStore(Long id, int goodsStore) {
		this.id=id;
		this.goodsStore=goodsStore;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
	public Integer getGoodsStore() {
		return goodsStore;
	}
	public void setGoodsStore(Integer goodsStore) {
		this.goodsStore = goodsStore;
	}

}
