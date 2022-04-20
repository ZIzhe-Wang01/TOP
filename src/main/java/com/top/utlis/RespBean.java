package com.top.utlis;

public class RespBean {
	
	private long code;
	private String message;
	private Object obj;
	
	public RespBean(long code, String message, Object obj) {
		code = this.code;
		message = this.message;
		obj = this.obj;
	}

	/**
	 * 成功返回结果
	 */
	public static RespBean success(String message) {
		return new RespBean(200, message, null);
	}
	
	/**
	 * 成功返回结果
	 */
	public static RespBean success(String message, Object obj) {
		return new RespBean(200, message, obj);
	}
	
	/**
	 * 失败返回结果
	 */
	public static RespBean error(String message) {
		return new RespBean(500, message, null);
	}
	
	/**
	 * 失败返回结果
	 */
	public static RespBean error(String message, Object obj) {
		return new RespBean(500, message, obj);
	}
}
