package com.dayuan.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.dayuan.bean.GoodsStore;
import com.dayuan.bean.GoodsTypes;

@MapperScan
public interface GoodsStoreMapper {
	
	public List<GoodsTypes> selectGoodsTypeByPid(Integer pid);

	public GoodsStore selectGoodsStoreById(Long goodsId);

	public int updateGoodsStore(Long goodsId, Integer goodsNumber);

	public GoodsStore selectByPrimaryKeyAndLock(Long id);

	public Integer updateGoodsStore(GoodsStore goodsStore);

	public Integer updateByPrimaryKeySelective(GoodsStore goodsStore);
	
}
