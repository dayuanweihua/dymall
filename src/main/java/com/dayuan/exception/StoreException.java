package com.dayuan.exception;

import com.dayuan.constant.ConstantCode;

public class StoreException extends RuntimeException{

	private ConstantCode constantCode;

	public StoreException(ConstantCode constantCode){
		super(constantCode.getMsg());
		this.constantCode=constantCode;
	}
	
	public ConstantCode getConstantCode() {
		return constantCode;
	}
}
