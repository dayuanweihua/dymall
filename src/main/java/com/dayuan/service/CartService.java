package com.dayuan.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dayuan.bean.Cart;
import com.dayuan.bean.CartInfo;
import com.dayuan.dao.CartMapper;

@Service
public class CartService {

	@Resource
	private CartMapper cartMapper;

	/**
	 * 查询用户购物车信息
	 * @param userId
	 * @return
	 */
	public List<CartInfo> selectCartInfos(Long cartId){
		return cartMapper.selectCartInfos(cartId);
	}
	
	/**
	 * 获取用户对应的购物车
	 * @param userId
	 * @return
	 */
	public Cart selectCart(Long userId){
		return cartMapper.selectCart(userId);
	}
	
	/**
	 * 增加购物车主表
	 * @param cart
	 * @return
	 */
	@Transactional(rollbackFor =Exception.class)
	public int insertCart(Long userId){
		return cartMapper.insertCart(userId);
	}
	
	/**
	 * 增加购物车详情表
	 */
	@Transactional(rollbackFor =Exception.class)
	public int insertCartInfo(CartInfo cartInfo){
		return cartMapper.insertCartInfo(cartInfo);
	}
	
	/**
	 * 删除用户购物车商品
	 * @param goodsId
	 * @return
	 */
	public int deleteCartInfoById(Long cartId,Long goodsId){
		return cartMapper.deleteCartInfoById(cartId, goodsId);
	}
	
	/**
	 * 更新用户购物车商品数量
	 * @param changeNumber
	 * @param cartId
	 * @return
	 */
	public int updateCartInfo(Integer changeNumber,Long cartId,Long goodsId){
		return cartMapper.updateCartInfo(changeNumber, cartId, goodsId);
	}
	

}
