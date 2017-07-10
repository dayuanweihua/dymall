package com.dayuan.dao;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.dayuan.bean.UserInfo;

@MapperScan
public interface UserInfoMapper {
	/**
	 * @desc 根据用户ID查询用户信息
	 * 
	 * @param id
	 *            用户id
	 * @return 用户信息
	 */
	public UserInfo selectUserInfoById(Integer id);

	/**
	 * @desc 用户注册
	 * @param userInfo
	 * @return
	 */
	public int insertUserInfo(UserInfo userInfo);

	public int updateCardById(UserInfo userInfo);

	public int deleteCardById(Integer id);

	public UserInfo selectUserInfoByParam(UserInfo userInfo);
	
	/**
	 * 查询数据库该手机号是否已被使用
	 * @param phone
	 * @return
	 */
	public UserInfo selectUserInfoByPhone(@Param("phone") String phone);
}
