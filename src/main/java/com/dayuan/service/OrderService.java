package com.dayuan.service;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dayuan.bean.Goods;
import com.dayuan.bean.GoodsStore;
import com.dayuan.bean.Order;
import com.dayuan.bean.OrderInfo;
import com.dayuan.constant.ConstantCode;
import com.dayuan.dao.OrderMapper;
import com.dayuan.exception.StoreException;
import com.dayuan.utils.DateUtils;

@Service
public class OrderService {

	@Resource
	private OrderMapper orderMapper;
	
	@Resource
	private GoodsStoreService goodsStoreService;

	@Resource
	private GoodsService goodsService;

	public List<Order> selectOrdersByParams(Integer orderStatus, Long userId) {
		Map<String, Object> params = new HashMap<String, Object>();
		if (orderStatus != -1) {
			params.put("orderStatus", orderStatus);
		}
		params.put("userId", userId);
		return orderMapper.selectOrdersByParams(params);
	}

	public List<OrderInfo> selectOrderInfoByOrderId(Long orderId) {
		return orderMapper.selectOrderInfoByOrderId(orderId);
	}

	public Long insertOrder(Long userId, Date orderTime, String receiver, String receiverPhone, String address) {
		return orderMapper.insertOrder(userId, orderTime, receiver, receiverPhone, address);
	}

	public Long insertOrderInfo(OrderInfo orderInfo) {
		return orderMapper.insertOrderInfo(orderInfo);
	}
	
	@Transactional(rollbackFor =Exception.class)
	public void submitOrder(Long goodsId, Integer goodsNumber, Order order, Long userId) throws Exception {

		GoodsStore goodsStore = goodsStoreService.selectGoodsStoreById(goodsId);
		
		if(goodsStore==null){
			throw new Exception("商品不存在");
		}
		if(goodsStore.getGoodsStore()<goodsNumber){
			throw new StoreException(ConstantCode.STORE_LOW);
		}
		
		GoodsStore newGoodsStore = goodsStoreService.selectByPrimaryKeyAndLock(goodsStore.getId());
		if(newGoodsStore==null){
			throw new Exception("商品不存在");
		}
		if(newGoodsStore.getGoodsStore()<goodsNumber){
			throw new Exception("商品库存不足");
		}
		
		goodsStoreService.updateByPrimaryKeySelective(new GoodsStore(newGoodsStore.getId(),(newGoodsStore.getGoodsStore()-goodsNumber)));

		Goods goods = goodsService.selectGoodByGoodId(goodsId);
		if (goods == null) {
			throw new Exception("商品不存在");
		}
		
		order.setOrderTime(DateUtils.DateToStr(new Date()));
		order.setOrderAmount(goods.getPromotionPrice()*goodsNumber);
		order.setUserId(userId);
		orderMapper.insertOrder(order);
		
		OrderInfo orderInfo=new OrderInfo();
		orderInfo.setOrderId(order.getId());
		orderInfo.setGoodsId(goodsId);
		orderInfo.setGoodsNumber(goodsNumber);
		orderInfo.setGoodsPrice(goods.getPromotionPrice());
		orderMapper.insertOrderInfo(orderInfo);

	}

	public List<OrderInfo> selectorderInfos() {
		orderMapper.selectorderInfos();
		return null;
	}

	

}
