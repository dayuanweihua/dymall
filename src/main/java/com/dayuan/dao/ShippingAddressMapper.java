package com.dayuan.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.dayuan.bean.ShippingAddress;
/**
 * 用户收货地址管理
 * @author 24725
 *
 */
@MapperScan
public interface ShippingAddressMapper {
	
	
	/**
	 * 增加用户收货地址
	 * @param userId
	 * @param shippingAddress
	 * @return
	 */
	public int insertShippingAddress(ShippingAddress shippingAddress);
	
	
	/**
	 * 删除用户收货地址
	 * @param userId
	 * @param shippingAddressId
	 * @return
	 */
	public int deleteShippingAddress(@Param("userId") Long userId,@Param("shippingAddressId")Long shippingAddressId);
	
	
	/**
	 * 更改用户收货地址
	 * @param userId
	 * @param shippingAddress
	 * @return
	 */
	public int updateShippingAddress(ShippingAddress shippingAddress);
	
	/**
	 * 查询用户所有的收货地址
	 * @param userId
	 * @return
	 */
	public List<ShippingAddress> selectShippingAddress(@Param("userId") Long userId);
	
}
