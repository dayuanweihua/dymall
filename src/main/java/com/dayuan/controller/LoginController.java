package com.dayuan.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dayuan.bean.UserInfo;
import com.dayuan.constant.ConstantCode;
import com.dayuan.service.UserInfoService;
import com.dayuan.utils.PatternUtils;
import com.dayuan.vo.ResultVo;

@Controller
@RequestMapping("/login")
public class LoginController {

	private static Logger logger = LoggerFactory.getLogger(UserInfoController.class);
	@Resource
	private UserInfoService userInfoService;

	/**
	 * 
	 * @param session
	 * @param loginInfo
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/login.shtml", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public ResultVo login(HttpSession session, String loginInfo, String password) {
		ResultVo resultVo = null;
		try {

			// 已在前端判断用户输入的账号或密码为空的情况。
			/*
			 * if (loginInfo == null ||"".equals(loginInfo)|| password ==
			 * null||"".equals(password)) { resultVo = new ResultVo();
			 * resultVo.setCode(ConstantCode.LOGIN_FAIL.getCode());
			 * resultVo.setMsg("用户输入的账号或密码为空！");
			 * System.out.println("用户输入的账号或密码为空"); return resultVo; }
			 */

			UserInfo userInfo = new UserInfo();
			if (PatternUtils.isEmail(loginInfo)) {
				userInfo.setEmail(loginInfo);
			}
			if (PatternUtils.isMobile(loginInfo)) {
				userInfo.setPhone(loginInfo);
			}
			if (PatternUtils.isUsername(loginInfo)) {
				userInfo.setUsername(loginInfo);
			} /*else {
				resultVo = new ResultVo(ConstantCode.LOGIN_FAIL.getCode(), "账号不符合规则，请重新输入！");
				return resultVo;
			}*/

			userInfo = userInfoService.selectUserInfoByParam(userInfo);
			if (userInfo == null) {
				resultVo = new ResultVo(ConstantCode.LOGIN_FAIL.getCode(), "数据库中账号不存在，请重新输入！");
				return resultVo;
			}

			if (!password.equals(userInfo.getPassword())) {
				resultVo = new ResultVo(ConstantCode.LOGIN_FAIL.getCode(), "账号或密码错误，请重新输入！");
				resultVo.setCode(ConstantCode.LOGIN_FAIL.getCode());
				logger.error(loginInfo + "在数据库中获取的密码与用户输入的密码不匹配。" + password);
				return resultVo;
			}
			// 过滤所有条件后，将客户信息存入session，并告知前端客户登录成功，可以跳转至主页。
			session.setAttribute("userInfo", userInfo);

			resultVo = new ResultVo("登陆成功",userInfo);
			return resultVo;
		} catch (Exception e) {
			if (resultVo != null) {
				resultVo = new ResultVo();
				resultVo.setCode(ConstantCode.LOGIN_FAIL.getCode());
				resultVo.setMsg("网络不稳定，请稍后再试！");
			}
			logger.error(loginInfo + "在登录时服务端发生异常。", e);
			return resultVo;
		}
	}
}