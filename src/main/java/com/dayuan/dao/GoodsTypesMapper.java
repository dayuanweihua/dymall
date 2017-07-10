package com.dayuan.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.dayuan.bean.GoodsTypes;

@MapperScan
public interface GoodsTypesMapper {
	
	public List<GoodsTypes> selectGoodsTypeByPid(Integer pid);

	
}
