package com.dayuan.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dayuan.bean.ShippingAddress;
import com.dayuan.dao.ShippingAddressMapper;

@Service
public class ShippingAddressService {

	@Resource
	private ShippingAddressMapper shippingAddressMapper;
	
	/**
	 * 增加用户收货地址
	 * @param userId
	 * @param shippingAddress
	 * @return
	 */
	public int insertShippingAddress(ShippingAddress shippingAddress){
		return shippingAddressMapper.insertShippingAddress(shippingAddress);
	}
	
	
	/**
	 * 删除用户收货地址
	 * @param userId
	 * @param shippingAddressId
	 * @return
	 */
	public int deleteShippingAddress(Long userId,Long shippingAddressId){
		return shippingAddressMapper.deleteShippingAddress(userId, shippingAddressId);
	}
	
	
	/**
	 * 更改用户收货地址
	 * @param userId
	 * @param shippingAddress
	 * @return
	 */
	public int updateShippingAddress(ShippingAddress shippingAddress){
		return shippingAddressMapper.updateShippingAddress(shippingAddress);
	}
	
	/**
	 * 查询用户所有的收货地址
	 * @param userId
	 * @return
	 */
	public List<ShippingAddress> selectShippingAddress(Long userId){
		return shippingAddressMapper.selectShippingAddress(userId);
	}

}
