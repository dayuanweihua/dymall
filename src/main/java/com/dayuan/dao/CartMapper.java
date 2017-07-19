package com.dayuan.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.dayuan.bean.Cart;
import com.dayuan.bean.CartInfo;

@MapperScan
public interface CartMapper {
	
	/**
	 * 查询用户购物车信息
	 * @param userId
	 * @return
	 */
	public List<CartInfo> selectCartInfos(Long cartId);
	
	/**
	 * 获取用户对应的购物车
	 * @param userId
	 * @return
	 */
	public Cart selectCart(Long userId);
	
	/**
	 * 增加购物车主表
	 * @param cart
	 * @return
	 */
	public int insertCart(Long userId);
	
	/**
	 * 增加购物车详情表
	 */
	public int insertCartInfo(CartInfo cartInfo);
	
	/**
	 * 删除用户购物车商品
	 * @param goodsId
	 * @return
	 */
	public int deleteCartInfoById(@Param("cartId")Long cartId,@Param("goodsId")Long goodsId);
	
	/**
	 * 更新用户购物车商品数量
	 * @param changeNumber
	 * @param cartId
	 * @return
	 */
	public int updateCartInfo(@Param("changeNumber")Integer changeNumber,@Param("cartId")Long cartId,@Param("goodsId")Long goodsId);

	public List<CartInfo> selectCartInfoS();
	
}
