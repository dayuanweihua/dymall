package com.dayuan.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.dayuan.bean.Order;
import com.dayuan.bean.OrderInfo;

/**
 * 订单管理
 * @author 24725
 *
 */
@MapperScan
public interface OrderMapper {
	
	public List<Order> selectOrdersByParams(@Param("params")Map<String,Object> params);
		
	public List<OrderInfo> selectOrderInfoByOrderId(@Param("orderId")Long orderId);

	public Long insertOrder( Long userId,Date orderTime,String receiver, String receiverPhone,String address);

	public Long insertOrderInfo(Long orderId, Long goodsId, Integer promotionPrice, Integer goodsNumber);

	public Long insertOrderInfo(OrderInfo orderInfo);

	public Integer insertOrder(Order order);

	public List<OrderInfo> selectorderInfos();
}
