package com.dayuan.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dayuan.bean.Goods;
import com.dayuan.dao.GoodsMapper;

@Service
public class GoodsService {

	@Resource
	private GoodsMapper goodsMapper;
	
	public List<Goods> selectGoodByParam(String goodsName) {
		return goodsMapper.selectGoodByParam(goodsName);		
	}
	
	public Goods selectGoodByGoodId(Long goodsId) {
		return goodsMapper.selectGoodByGoodId(goodsId);		
	}

	public String selectGoodsTypeByGoodsTypeId(Integer goodsTypeId) {
		return goodsMapper.selectGoodsTypeByGoodsTypeId(goodsTypeId);
	}
	
	
}
