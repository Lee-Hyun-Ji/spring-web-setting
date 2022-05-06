package com.devfun.setting_boot.service;

import java.util.HashMap;

import com.devfun.setting_web.exception.DateFormatException;

public interface StatisticService {
	public HashMap<String, Object> yearLoginNum(String year);
	
	public HashMap<String, Object> monthAeccessNum(String month) throws DateFormatException;
	public HashMap<String,Object> dayAccessNum(String date) throws DateFormatException;
	public HashMap<String,Object> monthLoginNumByDept(String dept, String month) throws DateFormatException;
	public HashMap<String,Object> dayLoginAverage(String startDate, String endDate) throws DateFormatException;
	public HashMap<String,Object> monthLoginNumExceptHoliday(String month) throws DateFormatException;
}
