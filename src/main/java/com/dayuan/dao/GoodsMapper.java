package com.dayuan.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.dayuan.bean.Goods;

@MapperScan
public interface GoodsMapper {
	
	public List<Goods> selectGoodByParam(@Param("goodsName") String goodsName);
	
	public Goods selectGoodByGoodId(@Param("goodsId")Long goodsId);

	public String selectGoodsTypeByGoodsTypeId(@Param("goodsTypeId") Integer goodsTypeId);
}
