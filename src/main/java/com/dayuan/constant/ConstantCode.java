package com.dayuan.constant;

public enum ConstantCode implements BaseCode{
	FAIL(0,"失败"), SUCCESS(1,"成功"),//所有的成功操作都返回1.
	PARAM_EMPTY(1001,"参数为空"),//参数为空
	CODE_ERROR(1002,"验证码为空"),//验证码错误
	PARAM_ERROR(1003,"参数错误"),//登录参数错误
	PHONE_NUMBER_ERROR(1004,"手机号错误"),//手机号码错误
	PHONE_HAS_USED(1005,"手机号已被使用"),//手机号已被使用
	LOGIN_FAIL(2000,"登录失败"),
	STORE_LOW(3000,"库存不足"), 
	NOT_LOGIN(2001,"用户未登录"),
	EXCEPTION(1006,"发生异常"),
	DBEXCEPTION(1007,"数据库操作异常");
	
	
	

	private int code;
	private String msg;

	private ConstantCode(int code,String msg) {
		this.code=code;
		this.msg=msg;
	}
	
	public int getCode(){
		return code;
	}
	public String getMsg(){
		return msg;
	}
	
	@Override
	public String printMsg(){
		return (code+","+msg);
	}


}

interface BaseCode{
	public String printMsg();
}
