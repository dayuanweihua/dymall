package com.dayuan.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.dayuan.bean.UserInfo;
import com.dayuan.dao.UserInfoMapper;

@Service
public class UserInfoService {
	private static Logger logger = LoggerFactory.getLogger(UserInfoService.class);

	@Resource
	private UserInfoMapper userInfoMapper;

	public void insertUserInfo(UserInfo userInfo) throws Exception {
		try {
			userInfoMapper.insertUserInfo(userInfo);
		} catch (Exception e) {
			logger.error("用户注册失败：" + e.getMessage());
			throw new Exception("网络不稳定，请稍后再试");
		}
	}

	public UserInfo selectUserInfoByParam(UserInfo userInfo) {		
		return userInfoMapper.selectUserInfoByParam(userInfo);
	}

	/**
	 * 查询数据库该手机号是否已被使用
	 * @param phone
	 * @return
	 */
	public UserInfo selectUserInfoByPhone(String phone) {
		return userInfoMapper.selectUserInfoByPhone(phone);
	}

}
