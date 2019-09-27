package com.neo.mail.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonResult {
	private static Logger logger = LoggerFactory.getLogger(JsonResult.class);
	
	/**
	 * 成功
	 */
	public static final Integer SUCCESS = 200;
	/**
	 * 失败
	 */
	public static final Integer FAIL = 500;
	
	/**
	 * 未授权
	 */
	public static final Integer UNAUTH = 401;
	
	/**
	 * 状态 200：成功
	 */
	private Integer status;
	/**
	 * 消息提示
	 */
	private String msg;
	/**
	 * 响应数据
	 */
	private Object data;
	/**
	 * 响应数据扩展
	 */
	private Object extras;
	
	public Integer getStatus() {
		return status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public Object getData() {
		return data;
	}
	
	public void setData(Object data) {
		this.data = data;
	}
	
	public Object getExtras() {
		return extras;
	}
	
	public void setExtras(Object extras) {
		this.extras = extras;
	}
	
	/**
	 * 返回JSON对象
	 *
	 * @param status 状态
	 * @param msg    信息
	 * @param data   数据
	 * @param extras 扩展数据
	 */
	public static JsonResult createJsonResult(Integer status, String msg, Object data, Object extras) {
		JsonResult result = new JsonResult();
		result.setStatus(status);
		result.setMsg(msg);
		result.setData(data);
		result.setExtras(extras);
		if (status != null && FAIL == status) {
			logger.error("ERROR:" + msg);
		}
		return result;
	}
	
	/**
	 * 返回JSON对象
	 *
	 * @param status 状态
	 * @param msg    信息
	 * @param data   数据
	 */
	public static JsonResult createJsonResult(Integer status, String msg, Object data) {
		return createJsonResult(status, msg, data, null);
	}
	
	/**
	 * 返回成功 JSON
	 *
	 * @param msg
	 * @param data
	 * @param extras
	 * @return
	 */
	public static JsonResult createSuccessJsonResult(String msg, Object data, Object extras) {
		return createJsonResult(SUCCESS, msg, data, extras);
	}
	
	/**
	 * 返回成功 JSON
	 *
	 * @param msg
	 * @param data
	 * @return
	 */
	public static JsonResult createSuccessJsonResult(String msg, Object data) {
		return createJsonResult(SUCCESS, msg, data, null);
	}
	
	/**
	 * 返回成功 JSON
	 *
	 * @param msg
	 * @return
	 */
	public static JsonResult createSuccessJsonResult(String msg) {
		return createSuccessJsonResult(msg, null, null);
	}
	
	/**
	 * 返回失败 json
	 *
	 * @param msg
	 * @return
	 */
	public static JsonResult createFailJsonResult(String msg) {
		return createJsonResult(FAIL, msg, null, null);
	}
	
}
