package com.devfun.setting_web.exception;

public class DateFormatException extends Exception{
	public DateFormatException(String date) {
		super("요청 변수가 잘못된 형식입니다(\'" + date + "\')");
	}
}
