package com.neo.mail.domain.enums;

public enum EnabledEnum {
	zero(0, "有效"), one(1, "失效");
	
	
	EnabledEnum(Integer code, String value) {
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
