package com.devfun.setting_boot.dao;

import java.util.HashMap;
import java.util.List;

import com.devfun.setting_boot.dto.LoginDateListDto;


public interface StatisticMapper {
	public HashMap<String, Object> selectMonthAccess(String month);
	public HashMap<String, Object> selectDayAccess(String date);
	public HashMap<String, Object> selectMonthLoginByDept(String dept, String month);
	public HashMap<String, Object> selectDayAverage(String startDate, String endDate);
	public List<LoginDateListDto> selectMonthLogin(String month);
	public List<String> selectHoliday(String year, String month);
}
