package com.dayuan.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dayuan.bean.GoodsStore;
import com.dayuan.dao.GoodsStoreMapper;

@Service
public class GoodsStoreService {

	@Resource
	private GoodsStoreMapper goodsStoreMapper;
	

	
	public GoodsStore selectGoodsStoreById(Long goodsId){
		return goodsStoreMapper.selectGoodsStoreById(goodsId);		
	}




	public GoodsStore selectByPrimaryKeyAndLock(Long id) {

		return goodsStoreMapper.selectByPrimaryKeyAndLock(id);
	}


	public Integer updateByPrimaryKeySelective(GoodsStore goodsStore) {
		return goodsStoreMapper.updateByPrimaryKeySelective(goodsStore);
		
	}
	
	
}
