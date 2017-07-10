package com.dayuan.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dayuan.bean.GoodsTypes;
import com.dayuan.dao.GoodsTypesMapper;
import com.dayuan.vo.GoodsTypesVo;

@Service
public class GoodsTypesService {

	@Resource
	private GoodsTypesMapper goodTypesMapper;
	
	public List<GoodsTypes> selectGoodsTypeByPid(Integer pid) {
		return goodTypesMapper.selectGoodsTypeByPid(pid);		
	}
	/**
	 * 递归方式获取所有商品类目的类目节点树。
	 * @return
	 */
	public List<GoodsTypesVo> getTypes(Integer pid) {		
		//获取所有一级的商品类目
		List<GoodsTypes> goodsTypes=selectGoodsTypeByPid(pid);
		List<GoodsTypesVo> goodsTypeVos=new ArrayList<>();
		//对一级的商品类目进行遍历
		for (GoodsTypes goodsType : goodsTypes) {
		GoodsTypesVo goodsTypeVo=new GoodsTypesVo(goodsType.getId(),goodsType.getName(),goodsType.getPid(),getTypes(goodsType.getId()));
			goodsTypeVos.add(goodsTypeVo);
		}		
		return goodsTypeVos;
	}
	
	

	
}
