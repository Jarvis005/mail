package com.neo.mail.domain.enums;

public enum DeleteFlagEnum {
	zero(0, "未删除"), one(1, "已删除");
	
	
	DeleteFlagEnum(Integer code, String value) {
		this.code = code;
		this.value = value;
	}
	
	private Integer code;
	private String value;
	
	public Integer getCode() {
		return code;
	}
	
	public void setCode(Integer code) {
		this.code = code;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
}
